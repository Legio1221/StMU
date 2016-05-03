/* *******************************************************
*	Author: 	Oscar Guillermo Castro
*	Compile: 	mpicc -o Life_MPI Life_MPI.c
*	Run: 		mpiexec -n <Number of Processors> ./Life_MPI
*/

#include <stdio.h>
#include <stdlib.h>
#include <mpi.h>
#include <time.h>

/* Definitions */
// These macro definitions were inspired from the rosetta stone serial game of life implementation.
#define for_x for (int x = 0; x < rows; x++)
#define for_y for (int y = 0; y < columns; y++)
#define for_xy for_x for_y

#define MASTER 0
#define NUM_ROWS 20
#define NUM_COLUMNS 20
#define ARRAY_SIZE 400

/* Function prototypes */
void print_board(int **grid, int rows, int columns);
int check_neighbors(int **board, int rows, int columns, int current_x, int current_y);
void free_board(int **board, int rows);
void randomize_board(int **board);
int evolve_cell(int neighbors, int status);
int continue_game(int game_counter);
void preset_grid(int **board);
void zero_grid(int **board, int rows, int columns);
void print_neighbors(int **board, int rows, int columns);
void print_real_values(int **board, int rows, int columns);
void evolve(int **board, int rows, int columns, int current_x, int current_y, int **backend);
void local_instantiate(int **local_board, int **local_backend, int local_rows, int local_columns);
void split_grid(int **board, int **local_board, int local_rows, int local_columns, int my_rank);
void local_evolve(int **local_board, int **local_backend, int local_rows, int local_columns);
int local_dimensions(int my_rank, int rows, int section_cut, int nprocs);
void local_unite(int **main_board, int **local_board, int local_rows, int local_columns, int my_rank, int nprocs);
int malloc2d_int(int ***array, int n, int m);
int free2D_int(int ***array);

/* ====================================================== MAIN =========================================================================================== */
int main(int argc, char* argv[])
{
	/* ------------------------------------------------ Pre-MPI Environment Intialization ----------------------------------------------------*/


	/* Global variables */
	int num_sections,
		my_rank,
		name_length,
		nprocs,
		len,
		isContinue;

	char name[80];

	/* Pre-defined rows & columns */
	int rows = NUM_ROWS;
	int columns = NUM_COLUMNS;
	
	/* Cell status can be either 1 or 0. [1 = Alive] [0 = Dead] */
	//int cell_status;
	
	/* Instantiate isContinue*/
	isContinue = 1;

	/* END Pre-MPI Environment Intialization ----------------------------------------------------*/

	// --------------------------------------------------- MPI Initialization ----------------------------------------------------------------- //


	MPI_Init(&argc, &argv);

	// A processor will retrieve their unique local rank
	MPI_Comm_rank(MPI_COMM_WORLD, &my_rank);

	// Setting the total amount of processors
	MPI_Comm_size(MPI_COMM_WORLD, &nprocs);

	// Getting the processor name
	MPI_Get_processor_name(name, &len);
	

	// END MPI Initialization -------------------------------------------------//


	// ------------------------------------------------------------- MPI Logic ---------------------------------------------------------------------- //
	
	/*          Guess who forgot how to pass the MPI_My_Rank parameter to functions                */

	

	/* MPI Logic Variables */
	int local_rows = 0;
	int local_columns = columns;
	double section_cut = (double)1 / nprocs;	// Allocate the local grid with enough memory for (1/nrpocs) rows.

	// ----------------------------------------- Memory Allocation ----------------------------------------- //
	/* Superior grids */
	int **primary_grid;
	int **backend_grid;

	malloc2d_int(&primary_grid, rows, columns);
	malloc2d_int(&backend_grid, rows, columns);

		// formerly local_dimensions
		int last_node = nprocs - 1;
		int row_buffer = section_cut * rows; // If number_processors = 4, row_buffer = .25 * 20 = 5

		if (my_rank == MASTER || my_rank == last_node)
		{
			local_rows = row_buffer + 1;
		}
		else
		{
			local_rows = row_buffer + 2;
		}// local_dimensions

	// Local grids
	int **local_grid;
	int **local_backend; 

	malloc2d_int(&local_grid, rows, columns);
	malloc2d_int(&local_backend, rows, columns);
	// Memory Allocation ----------------------------------------- //

	// All processors must zero out the grid.
	zero_grid(primary_grid, rows, columns);
	zero_grid(local_grid, local_rows, local_columns);
	zero_grid(backend_grid, local_rows, local_columns);

	MPI_Barrier(MPI_COMM_WORLD);

	// print out the initial grid.
	if (my_rank == 0) {
		//preset_grid(primary_grid);
		randomize_board(primary_grid);
		print_board(primary_grid, rows, columns);
	}
	
	// Broadcast the primary grid to everyone.
	MPI_Bcast(&(primary_grid[0][0]), ARRAY_SIZE, MPI_INT, MASTER, MPI_COMM_WORLD);

	//testing; Checking to see if all other processors properly receive the array from the broadcast.
	/*
	if (my_rank == 1)
	{
		printf("\n\n");
		fflush(stdout);
		print_board(primary_grid, rows, columns);
	}
	*/
	//end testing
	//PASS

	// Force processors to wait for master.
	MPI_Barrier(MPI_COMM_WORLD);
	// MPI Logic --------------------------------------------------------------------- //

	while (1)
	{
		/* ----------------------------- ASK USER FOR CONTINUATION ----------------------------------*/
		// Ask user if they'd like to continue with the game.
		if (my_rank == 0)
		{
			isContinue = continue_game(isContinue);
		}
		
		// Bcast value of isContinue
		MPI_Bcast(&isContinue, 1, MPI_INT, MASTER, MPI_COMM_WORLD);

		if (isContinue == 0)
		{
			break;
		}
		/* ASK USER FOR CONTINUATION ----------------------------------*/
		
		//formerly the split_grid routine
		/* --------------------------------------SPLIT_GRID----------------------------------------------*/
		
		//Broadcast the primary grid
		MPI_Bcast(&(primary_grid[0][0]), ARRAY_SIZE, MPI_INT, MASTER, MPI_COMM_WORLD);
		
		if (my_rank == 0)
		{
			for (int i = 0; i < local_rows; i++)
			{
				for (int j = 0; j < local_columns; j++)
				{
					local_grid[i][j] = primary_grid[i][j];
				}
			}
		}
		else
		{
			for (int i = 0; i < local_rows; i++)
			{
				int board_row_intial_index = (my_rank * row_buffer) - 1;
				int board_row_index = board_row_intial_index + i;

				for (int j = 0; j < local_columns; j++)
				{
					local_grid[i][j] = primary_grid[board_row_index][j];
				}
			}
		} 
		/* SPLIT_GRID----------------------------------------------*/

		/* testing; check local grids do in fact make up the primary grid */
		/*if (my_rank == 0) print_board(local_grid, local_rows, local_columns);
		MPI_Barrier(MPI_COMM_WORLD);
		if (my_rank == 0)
		{
			printf("\n");
			fflush(stdout);
		}
		if (my_rank == 1) print_board(local_grid, local_rows, local_columns);
		MPI_Barrier(MPI_COMM_WORLD);
		if (my_rank == 0)
		{
			printf("\n");
			fflush(stdout);
		}
		if (my_rank == 2) print_board(local_grid, local_rows, local_columns);
		MPI_Barrier(MPI_COMM_WORLD);
		if (my_rank == 0)
		{
			printf("\n");
			fflush(stdout);
		}
		if (my_rank == 3) print_board(local_grid, local_rows, local_columns);
		MPI_Barrier(MPI_COMM_WORLD);*/
		/*end testing, PASS*/

		//formerly local_evolve
		evolve(local_grid, local_rows, local_columns, 0, 0, local_backend);

		//formerly local_unite
		// *********************************** LOCAL_UNITE *********************************** //
		int chunk_size = ARRAY_SIZE / nprocs; // should be 400 / 4 = 100
		int last_node = nprocs - 1;
		//int max_array_size = ARRAY_SIZE * sizeof(int);
		int rows_per_local = rows / nprocs;
		int columns_per_local = columns;

		if (my_rank == MASTER)
		{

			
			/* Adding first local grid to master grid. */
			for (int i = 0; i < (local_rows - 1); i++)
			{
				//Only need local_rows - 1
				// Set the rows from the master nodes.
				for (int j = 0; j < local_columns; j++)
				{
					primary_grid[i][j] = local_grid[i][j];
				}
			}
			/* Test; Check to see if local grid has correct contents after evolving */ 
			/*
			print_board(local_grid, local_rows, local_columns);
			*/
			/* End Test; PASS*/

			 /* ----------------------------- Receive local grids and add them to the master grid -------------------------- */
			 //Receive row from the other nodes
			for (int i = 1; i < nprocs; i++)
			{
				int recv_rows,
					recv_columns;
				int **recv_array;
				int current_node = i;
				int tag = i;
				int max_array_size;
				MPI_Status status;

				// Need to instantiate variables before receiving.
				recv_rows = 0;
				recv_columns = 0;

				MPI_Recv(&recv_rows, 1, MPI_INT, current_node, tag, MPI_COMM_WORLD, MPI_STATUS_IGNORE);
				MPI_Recv(&recv_columns, 1, MPI_INT, current_node, tag, MPI_COMM_WORLD, MPI_STATUSES_IGNORE);

				// allocate memory for array.
				malloc2d_int(&recv_array, recv_rows, recv_columns);

				max_array_size = recv_rows * recv_columns;

				MPI_Recv(&(recv_array[0][0]), max_array_size, MPI_INT, current_node, tag, MPI_COMM_WORLD, &status);

				/*Test; check to see that array was received successfully by printing it out.*/
				/*
				printf("Printing out received board from %d\n", current_node);
				fflush(stdout);
				print_board(recv_array, recv_rows, recv_columns);
				printf("\n");
				fflush(stdout);
				/**/
				/*End Test; PASS*/
				
				// ----------------------------------------------------------------------------------//
				/* Adding local grids to master gird */
				for (int j = 0; j < rows_per_local; j++)
				{
					int main_board_index = current_node * rows_per_local + j;
					//Handle for the last node and all others.
					for (int k = 0; k < columns_per_local; k++)
					{
						if (current_node != last_node)
						{
							int recv_board_index = j + 1; // Don't use the top ghost row.
							
							primary_grid[main_board_index][k] = recv_array[recv_board_index][k];
							
						}
						else
						{
							int recv_board_index = j; // Top ghost row DNE.
							
							primary_grid[main_board_index][k] = recv_array[recv_board_index][k];
							
						}
					}
				} /* END Adding local grids to master grid */
				  // ----------------------------------------------------------------------------------//

				free2D_int(&recv_array);
			}
			/* ----------------------------- Receive local grids and add them to the master grid -------------------------- */
		}
		else
		{
			for (int i = 1; i < nprocs; i++)
			{

				int send_rows,
					send_columns;
				int **send_array;
				int current_node = i;
				int tag = i;
				int send_array_size;

				send_rows = local_rows;
				send_columns = local_columns;

				send_array_size = send_rows * send_columns;

				// allocate memory for array.
				malloc2d_int(&send_array, send_rows, send_columns);

				//send_array = local_grid;
				for (int x = 0; x < local_rows; x++)
				{
					for (int y = 0; y < local_columns; y++)
					{
						send_array[x][y] = local_grid[x][y];
					}
				}

				MPI_Send(&send_rows, 1, MPI_INT, MASTER, tag, MPI_COMM_WORLD);
				MPI_Send(&send_columns, 1, MPI_INT, MASTER, tag, MPI_COMM_WORLD);
				MPI_Send(&(send_array[0][0]), send_array_size, MPI_INT, MASTER, tag, MPI_COMM_WORLD);

				free2D_int(&send_array);
			}
		}
		// LOCAL_UNITE *********************************** //

		// Print board to user.
		if (my_rank == 0) {
			print_board(primary_grid, rows, columns);
		}
	}

	//  Game Logic  --------------------------------------------------------------------- //
	
	
	
	free2D_int(&primary_grid);
	free2D_int(&backend_grid);
	free2D_int(&local_grid);
	free2D_int(&local_backend);

	// Wait for everyone to free memory.
	MPI_Barrier(MPI_COMM_WORLD);

	// End the MPI.
	MPI_Finalize();
} /* MAIN ================================================================================================================================================= */






/* --------------------------------------------------------------------------------------------
* Function:	print_board();
* Purpose: prints a grid out to the terminal / command prompt
*/
void print_board(int **grid, int rows, int columns)
{
	for (int x = 0; x < rows; x++)
	{
		for (int y = 0; y < columns;y++)
		{
			if (grid[x][y] == 1)
			{
				printf("X ");
				fflush(stdout);
			}
			else
			{
				printf("- ");
				fflush(stdout);
			}
		}
		// After each row, print new line.
		printf("\n");
		fflush(stdout);
	}
}

/* ----------------------------------------------------------------------------
* Function: random_between
* Purpose: Find a random number between min and max.
*/
int random_between(int min, int max) {
	return rand() % (max - min + 1) + min;
}

/* ----------------------------------------------------------------------------
Function: randomize_board
Purpose: Randomizes the board's cells to DEAD and ALIVE status.
 */
void randomize_board(int **board)
{
	//Hard-coded
	int rows = NUM_ROWS;
	int columns = NUM_COLUMNS;
	int cell_status;

	/* Using srand to generate a semi-random grid.*/
	srand(time(NULL));


	for_xy
	{
		cell_status = random_between(0,1);

		if (cell_status == 1)
		{
			board[x][y] = cell_status;
		}
		else
		{
			board[x][y] = 0;
		}
	}
}

/* --------------------------------------------------------------------------------
Function: free_board
Purpose:frees memory that is being used by matrices.
*/
void free_board(int **board, int rows)
{

	for (int x = 0; x < rows; x++)
	{
		free(board[x]);
	}

	free(board);
}

/* ----------------------------------------------------------------------------------------
Function: check_neighbors
Purpose: Checks the current cell's neighbors.
Returns the number of neighbors.
*/
int check_neighbors(int **board, int rows, int columns, int current_x, int current_y)
{
	int cell_counter = 0;

	int north = current_x - 1;
	int south = current_x + 1;
	int central = current_x;

	int west = current_y - 1;
	int east = current_y + 1;
	int center = current_y;

	
	// C does not throw exceptions for out of bound array :(
	// Pseudo-booleans that'll only allow their respective direction to
	// follow suit if they're 1.
	// i.e. 1 = true, 0 = false
	int isNorth = 0;
	int isSouth = 0;
	int isWest = 0;
	int isEast = 0;

	if (north >= 0) isNorth = 1;
	if (south < rows) isSouth = 1;
	if (west >= 0) isWest = 1;
	if (east < columns) isEast = 1;

	// Counting cells in the northern area.
	if (isNorth == 1 && isWest == 1) 
	{
		if(board[north][west] == 1) cell_counter += 1;
	}
	if (isNorth == 1)
	{
		if (board[north][center] == 1) cell_counter += 1;
	}
	if (isNorth == 1 && isEast == 1)
	{
		if(board[north][east] == 1) cell_counter += 1;
	}

	// Counting cells in the central area
	if ( isWest == 1)
	{
		if(board[central][west] == 1) cell_counter += 1;
	}
	// Whoops, don't count *yourself* as a *neighbor*.
	/*if (board[central][center] == 1)
	{
		cell_counter += 1;
	}*/
	if (isEast == 1)
	{
		if (board[central][east] == 1) cell_counter += 1;
	}

	// Counting cells in the southern area.
	if ( isSouth == 1 && isWest == 1)
	{
		if (board[south][west] == 1) cell_counter += 1;
	}
	if (isSouth ==1)
	{
		if(board[south][center] == 1) cell_counter += 1;
	}
	if (isSouth == 1 && isEast ==1)
	{
		if(board[south][east] == 1) cell_counter += 1;
	}
	
	return cell_counter;
}

/*
Function: evolve_cell
Purpose: Determines the status of a cell depending on the amount of neighbors said cell has.
2 - Remain alive
3 - Become alive if dead, else remain alive.
Parameter (status): 1 for alive, 0 for dead.
*/
int evolve_cell(int neighbors, int status)
{
	
	int cell_status = 0;

	if (neighbors == 3) 
	{
		cell_status = 1;
	}
	else if (neighbors == 2 && status == 1)
	{
		cell_status = 1;
	}
	else
	{
		cell_status = 0;
	}

	return cell_status;
}

/*
Function: evolve
Purpose: updates primary board with evolved cells
*/
void evolve(int **board, int rows, int columns, int current_x, int current_y, int **backend)
{
	zero_grid(backend, rows, columns);

	// Set up static backend grid.
	for_xy
	{
		backend[x][y] = board[x][y];
	}

	int neighbors = 0;
	zero_grid(board, rows, columns);

	for_x
	{
		for_y
		{
			neighbors = check_neighbors(backend, rows, columns, x, y);
			int status = evolve_cell(neighbors, backend[x][y]);
			if (status == 1) board[x][y] = 1;
		}
	}

}

/*
Function: continue_game
Purpose: The function asks the user if he would like to advance another generation.
*/
int continue_game(int game_counter)
{

	char isContinue;

	printf("Continue? (y/n)\n");
	fflush(stdout);

	fflush(stdin);
	scanf(" %c", &isContinue);

	if (isContinue == 'y' || isContinue == 'Y')
	{
		game_counter = 1;
	}
	else
	{
		game_counter = 0;
	}

	return game_counter;
	
}

/*
Function: preset_grid
Purpose: A debuggin function. Contains basic blinkings GoL shapes.
Developer should be able to observe blinkers black box style.
*/
void preset_grid(int **board)
{
	int rows = NUM_ROWS;
	int columns = NUM_COLUMNS;
	for_x{
		if (x % 10 == 0 && x != 0) {
			for_y{
				if (y == 4 || y == 5 || y == 6)
				{
					board[x][y] = 1;
				}
			}
		}
	}
}

/*
Function: zero_grid
Purpose: zero out every cell prior to randomzing / setting grid.
*/
void zero_grid(int **board, int rows, int columns)
{
	for_xy{
		board[x][y] = 0;
	}
}

/*
Function: print_neighbors
Purpose: debugging function, prints the amount of neighbors a cell has.
*/
void print_neighbors(int **board, int rows, int columns)
{
	/*for_x{
	for_y{
	int neighbors = check_neighbors(primary_grid,rows,columns,x,y);
	printf("%d ", neighbors);
	fflush(stdout);
	}
	printf("\n");
	fflush(stdout);
	}*/
	for_x
	{
		for_y
		{
			int neighbors = check_neighbors(board,rows,columns,x,y);
			printf("%d ", neighbors);
			fflush(stdout);
		}
		printf("\n");
		fflush(stdout);
	}
}

/*
Function: print_real_values
Purpose: debugging function, prints the actual values in the grid.
*/
void print_real_values(int **board, int rows, int columns)
{
	for_x
	{
		for_y
		{
			printf("%d ",board[x][y]);
			fflush(stdout);
		}
		printf("\n");
		fflush(stdout);
	}
}

/*
Function: local_dimensions
Purpose: Determines the local grid's rows and columns.
*/
int local_dimensions(int my_rank, int rows, int section_cut, int nprocs)
{
	int local_rows = 0;

	int last_node = nprocs - 1;
	int row_buffer = section_cut * rows; // If number_processors = 4, row_buffer = .25 * 20 = 5

	if (my_rank == MASTER || my_rank == last_node)
	{
		local_rows = row_buffer + 1;
	}
	else
	{
		local_rows = row_buffer + 2;
	}

	return local_rows;
}

/*
Function: local_instantiate
Purpose: instantiates the local grids for every processor

Old paramters:void local_instantiate(int **local_board, int **local_backend, int my_rank, int local_rows, int local_columns) int section_cut, int rows, int columns, int nprocs)
*/
void local_instantiate(int **local_board, int **local_backend, int local_rows, int local_columns)
{
	// Need to free to re-apply malloc
	free(local_board);
	free(local_backend);

	local_board = malloc(local_rows * sizeof(*local_board));
	local_backend = malloc(local_rows * sizeof(*local_backend));

	for (int i = 0; i < local_rows; i++)
	{
		local_board[i] = malloc(local_columns * sizeof(*local_board[i]));
		local_backend[i] = malloc(local_columns * sizeof(*local_backend[i]));
	}

	/*
	if (my_rank == 0)
	{
		local_row_size = section_cut * (rows + 1);
		local_column_size = columns;

		// Instantiating local grids
		board = malloc(local_row_size * sizeof(*board));
		backend = malloc(local_row_size * sizeof(*backend));

		for (int x = 0; x < local_row_size; x++)
		{
			board[x] = malloc(local_column_size * sizeof(*board[x]));
			backend[x] = malloc(local_column_size * sizeof(*backend[x]));
		}
	}
	else if (my_rank != 0 && my_rank != (nprocs - 1))
	{
		local_row_size = section_cut * (rows + 2);
		local_column_size = section_cut * columns;

		// Instatiating local grids 
		board = malloc(local_row_size * sizeof(*board));
		backend = malloc(local_row_size * sizeof(*backend));

		for (int x = 0; x < local_row_size; x++)
		{
			board[x] = malloc(local_column_size * sizeof(*board[x]));
			backend[x] = malloc(local_column_size * sizeof(*backend[x]));
		}
	}
	else if (my_rank == (nprocs - 1))
	{
		local_row_size = section_cut * (rows + 1);
		local_column_size = section_cut * columns;

		// Instantiating local grids
		board = malloc(local_row_size * sizeof(*board));
		backend = malloc(local_row_size * sizeof(*backend));

		for (int x = 0; x < local_row_size; x++)
		{
			board[x] = malloc(local_column_size * sizeof(*board[x]));
			backend[x] = malloc(local_column_size * sizeof(*backend[x]));
		}
	}*/
}

/*
Function: split_grid
Purpose: Split the work evenly across all the processors
Old Parameter list: void split_grid(int **board, int rows, int columns, int **local_board, int **local_backend, int local_rows, int local_columns, int my_rank, int num_procs)
*/
void split_grid(int **board, int **local_board, int local_rows, int local_columns, int my_rank)
{
	if (my_rank == 0)
	{
		for (int i = 0; i < local_rows; i++)
		{
			for (int j = 0; j < local_columns; j++)
			{
				printf("%d\n", local_board[i][j]);
				fflush(stdout);
				//local_board[i][j] = board[i][j];
				printf("reached here.\n");
				fflush(stdout);
			}
		}
	}
	else
	{
		for (int i = 0; i < local_rows; i++)
		{
			int board_row_intial_index = (my_rank * local_rows) - 1;
			int board_row_index = board_row_intial_index + i;

			for (int j = 0; j < local_columns; j++)
			{
				local_board[i][j] = board[board_row_index][j];
			}
		}
	}

	/*if (my_rank != (num_procs - 1))
	{
	// Second to penultimate nodes
	// The start of an index = (rank * section_cut (or rows or columns)) - 1
	for (int i = 0; i < local_rows; i++)
	{
	int board_row_intial_index = (my_rank * local_rows) - 1;
	int board_row_index = board_row_intial_index + i;

	for (int j = 0; j < local_columns; j++)
	{
	local_board[i][j] = board[board_row_index][j];
	}
	}
	}
	else
	{
	// Last node
	for (int i = 0; i < local_rows; i++)
	{
	int board_initial_index = (my_rank * local_rows) - 1;
	int board_row_index = board_initial_index + i;
	for (int j = 0; j < local_columns; j++)
	{
	local_board[i][j] = board[board_row_index][j];
	}
	}
	}*/

	/*for (int i = 1; i < num_procs; i++)
	{
	if (i != (num_procs - 1))
	{
	// These are nodes between the second to penultimate node

	}
	else
	{
	// This is the last node
	}
	}*/

	// evolve the local grids
}

/*
Function: local_evolve
Purpose: evolves the cells in the local grids
*/
void local_evolve(int **local_board, int **local_backend, int local_rows, int local_columns)
{
	evolve(local_board, local_rows, local_columns, 0, 0, local_backend);
	// The grids should be evolved, now it's time to put the main grid back together.
}

/*
Function: local_unite
Purpose: unite the cells into a one grid.
*/
void local_unite(int **main_board, int **local_board, int local_rows, int local_columns, int my_rank, int nprocs)
{
	int rows = NUM_ROWS;
	int columns = NUM_COLUMNS;
	int chunk_size = ARRAY_SIZE / nprocs; // should be 400 / 4 = 100
	int last_node = nprocs - 1;
	int max_array_size = ARRAY_SIZE * sizeof(int);
	int rows_per_local = rows / nprocs;
	int columns_per_local = columns / nprocs;

	if (my_rank == MASTER)
	{
		
		// ---------------------------------------------------------//
		/* Adding first local grid to master grid. */

		//Only need local_rows - 1
		// Set the rows from the master nodes.
		for (int i = 0; i < (local_rows - 1); i++) 
		{
			for (int j = 0; j < local_columns; j++)
			{
				main_board[i][j] = local_board[i][j];
			}
		}/* Adding first local grid to master grid. */
		 // ---------------------------------------------------------//


		 /* ----------------------------- Receive local grids and add them to the master grid -------------------------- */
		//Receive row from the other nodes
		for (int i = 1; i < nprocs; i++)
		{
			int recv_rows,
				recv_columns;
			int **recv_array;
			int current_node = i;
			int tag = i;

			// Need to instantiate variables before receiving.
			recv_rows = 0;
			recv_columns = 0;

			MPI_Recv(recv_rows, max_array_size, MPI_INT, current_node, tag, MPI_COMM_WORLD, MPI_STATUS_IGNORE);
			MPI_Recv(recv_columns, max_array_size, MPI_INT, current_node, tag, MPI_COMM_WORLD, MPI_STATUSES_IGNORE);
			
			// allocate memory for array.
			recv_array = malloc(recv_rows * sizeof(*recv_array));
			for (int j = 0; j < recv_rows; j++) 
			{
				recv_array[j] = malloc(recv_columns * sizeof(*recv_array[j]));
			}

			MPI_Recv(recv_array, chunk_size, MPI_INT, current_node, tag, MPI_COMM_WORLD, MPI_STATUSES_IGNORE);

			
			// ----------------------------------------------------------------------------------//
			/* Adding local grids to master gird */
			for (int j = 0; j < rows_per_local; j++)
			{
				int main_board_index = current_node * rows_per_local + j;
				//Handle for the last node and all others.
				for (int k = 0; k < columns_per_local; k++)
				{
					if (current_node != last_node)
					{
						int recv_board_index = j + 1; // Don't use the top ghost row.
						main_board[main_board_index][k] = recv_array[recv_board_index][k];
					}
					else
					{
						int recv_board_index = j; // Top ghost row DNE.
						main_board[main_board_index][k] = recv_array[recv_board_index][k];
					}
				}
			} /* END Adding local grids to master grid */
			// ----------------------------------------------------------------------------------//

			free(recv_array);
		}
		/* ----------------------------- Receive local grids and add them to the master grid -------------------------- */
	}
	else
	{
		// Just send them in?
		

		for (int i = 1; i < nprocs; i++)
		{

			int send_rows,
				send_columns;
			int **send_array;
			int current_node = i;
			int tag = i;
			int send_array_size;

			send_rows = local_rows;
			send_columns = local_columns;
			
			send_array_size = sizeof(send_rows * send_columns);

			// allocate memory for array.
			send_array = malloc(send_rows * sizeof(*send_array));
			for (int j = 0; j < send_rows; j++)
			{
				send_array[j] = malloc(send_columns * sizeof(*send_array[j]));
			}

			send_array = local_board;

			MPI_Send(send_rows, 1, MPI_INT, MASTER, tag, MPI_COMM_WORLD);
			MPI_Send(send_columns, 1, MPI_INT, MASTER, tag, MPI_COMM_WORLD);
			MPI_Send(send_array, send_array_size, MPI_INT, MASTER, tag, MPI_COMM_WORLD);
		}
	}
}

/*
Taken from http://stackoverflow.com/questions/5104847/mpi-bcast-a-dynamic-2d-array and slightly modified.
Example: malloc2d_int(&array, rows, columns);
*/
int malloc2d_int(int ***array, int n, int m) 
{

	/* allocate the n*m contiguous items */
	int *p = (int *)malloc(n*m*sizeof(int));
	if (!p) return -1;

	/* allocate the row pointers into the memory */
	(*array) = (int **)malloc(n*sizeof(int*));
	if (!(*array)) {
		free(p);
		return -1;
	}

	/* set up the pointers into the contiguous memory */
	for (int i = 0; i<n; i++)
		(*array)[i] = &(p[i*m]);

	return 0;
}

/*
Taken from  http://stackoverflow.com/questions/5104847/mpi-bcast-a-dynamic-2d-array and slighty modified
*/
int free2D_int(int ***array) {
	/* free the memory - the first element of the array is at the start */
	free(&((*array)[0][0]));

	/* free the pointers into the memory */
	free(*array);

	return 0;
}