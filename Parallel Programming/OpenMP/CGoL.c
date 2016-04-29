#include<stdio.h>
#include<string.h>
#include<mpi.h>
​
void showBoard(char a[][21]);
int checkNeighbors(int i, int j, int a[][20]);
int checkGhostRowTop(int i,int j,int ghost_row_top[20],int local_a[][20]);
void evolve();
​
	int a[20][20] = {	{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
						{0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0},
						{0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0},
						{0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0},
						{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
						{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
						{0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0},
						{0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0},
						{0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0},
						{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
						{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
						{0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0},
						{0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0},
						{0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0},
						{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
						{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
						{0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0},
						{0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0},
						{0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0},
						{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}};
    	
	
	int cut_size_rows;
	int columns;
	int cut_size;
	int size;
	int count = 0;
    
int main(int argc, char* argv[]){
	
	int my_rank, num_procs;
	int no_rows, total_size, no_columns;
	
	size = sizeof(a)/sizeof(int);
	//printf("Total size of Array: %d\n", size);
	
	columns = sizeof(a[0])/sizeof(int);
	//printf("Number of Columns: %d\n", columns);
	
	no_rows = size / columns;
	
	
	
	
	
	MPI_Init(&argc, &argv);
	
	MPI_Comm_rank(MPI_COMM_WORLD, &my_rank);
    MPI_Comm_size(MPI_COMM_WORLD, &num_procs);
	
	
	
		
	cut_size = size/num_procs;
	//printf("Number of values for cut size: %d\n", cut_size);
	
	cut_size_rows = cut_size/columns;
	//printf("Number of rows : %d", cut_size_rows);
	
	int temp_b[cut_size_rows][columns];
​
	
	if(my_rank == 0)
	{
	int i,j;	
		
	int local_a[cut_size_rows][columns];
	int ghost_row_bottom[columns];
	int send;
	
	MPI_Send(&a,cut_size,MPI_INT,0,0,MPI_COMM_WORLD);
	
	for(send = 1; send < num_procs; send++){
		MPI_Send(a[0] + (cut_size * send),cut_size,MPI_INT,send,0,MPI_COMM_WORLD);
	}
		
	MPI_Recv(local_a,cut_size,MPI_INT,0,0,MPI_COMM_WORLD,NULL);
	//recieve from bottom
	MPI_Recv(ghost_row_bottom,columns,MPI_INT,1,0,MPI_COMM_WORLD,NULL);
	//send to bottom
	MPI_Send(local_a[cut_size_rows - 1], columns, MPI_INT, my_rank + 1,0,MPI_COMM_WORLD);
	
			int temp[cut_size_rows][columns];
			int ghost_row_top[columns];
			int sum = 0;
​
			for(i = 0; i < columns;i++){
				ghost_row_top[i] = 0;
			}
			
			for(i = 0; i < cut_size_rows; i++){
				for(j = 0;j <columns;j++){
					temp[i][j] = local_a[i][j];
				}
			}
			
			for(i = 0; i < cut_size_rows;i++){
				for(j = 0; j < columns;j++){
					if(i != 0 && i != 4){
						sum = local_a[i-1][j-1] + local_a[i-1][j] + local_a[i-1][j+1] 
						+ local_a[i][j-1] + local_a[i][j+1] 
						+ local_a[i+1][j-1] + local_a[i+1][j] + local_a[i+1][j+1];
						
						if(sum == 2 || sum == 3){
							temp[i][j] = 1;
						}
						else if(sum < 2 || sum > 3){
							temp[i][j] = 0;
						}
					}
					else if(i == 0){
						sum = ghost_row_top[j] + ghost_row_top[j - 1] + ghost_row_top[j + 1] 
						+ local_a[i][j-1] + local_a[i][j+1] 
						+ local_a[i+1][j-1] + local_a[i+1][j] + local_a[i+1][j+1];
						
						if(sum == 2 || sum == 3){
							temp[i][j] = 1;
						}
						else if(sum < 2 || sum > 3){
							temp[i][j] = 0;
						}
					}
					else if(i == cut_size_rows - 1){
						sum = ghost_row_bottom[j] + ghost_row_bottom[j - 1] + ghost_row_bottom[j + 1] 
						+ local_a[i][j-1] + local_a[i][j+1] 
						+ local_a[i-1][j-1] + local_a[i-1][j] + local_a[i-1][j+1];
						
						if(sum == 2 || sum == 3){
							temp[i][j] = 1;
						}
						else if(sum < 2 || sum > 3){
							temp[i][j] = 0;
						}
					}
				}
			}
​
			for(i = 0; i < cut_size_rows; i++){
				for(j = 0;j <columns;j++){
					local_a[i][j] = temp[i][j];
				}
			}
			MPI_Send(local_a[0],cut_size,MPI_INT,0,0,MPI_COMM_WORLD);
			
			int k = 0;
			for(i = 0;i<num_procs;i++){
				MPI_Recv(temp_b,cut_size,MPI_INT,i,0,MPI_COMM_WORLD,NULL);
				int start = cut_size_rows * i;
				
				
				for(k = 0;k<cut_size_rows;k++){
					for(j=0;j<columns;j++){
						a[k + start][j] = temp_b[k][j];
						}
				}
			}
	for(i =0;i<no_rows;i++){
		for(j=0;j<columns;j++){
			printf("%d",a[i][j]);
		}
		printf("\n");
	}
			
​
	}
	
	else{
		int local_a[cut_size_rows][columns];
		int temp[cut_size_rows][columns];
		int ghost_row_top[columns];
		int ghost_row_bottom[columns];
		MPI_Recv(local_a,cut_size,MPI_INT,0,0,MPI_COMM_WORLD,NULL);
		int even_odd = my_rank % 2;
		int bottom = num_procs - 1;
		if(even_odd == 1 && my_rank != bottom){
			//recieve from bottom
			MPI_Recv(ghost_row_bottom,columns,MPI_INT,my_rank + 1,0,MPI_COMM_WORLD,NULL);
			//send to top
			MPI_Send(local_a[0],columns,MPI_INT,my_rank - 1,0,MPI_COMM_WORLD);
			//revieve from top
			MPI_Recv(ghost_row_top,columns,MPI_INT,my_rank - 1,0,MPI_COMM_WORLD,NULL);
			//send to bottom
			MPI_Send(local_a[cut_size_rows - 1],columns,MPI_INT,my_rank + 1,0,MPI_COMM_WORLD);
			int i = 0;
			int j = 0;
			int sum = 0;
			
			for(i = 0; i < cut_size_rows; i++){
				for(j = 0;j <columns;j++){
					temp[i][j] = local_a[i][j];
				}
			}
			
			for(i = 0; i < cut_size_rows;i++){
				for(j = 0; j < columns;j++){
					if(i != 0 && i != 4){
						sum = local_a[i-1][j-1] + local_a[i-1][j] + local_a[i-1][j+1] 
						+ local_a[i][j-1] + local_a[i][j+1] 
						+ local_a[i+1][j-1] + local_a[i+1][j] + local_a[i+1][j+1];
						
						if(sum == 2 || sum == 3){
							temp[i][j] = 1;
						}
						else if(sum < 2 || sum > 3){
							temp[i][j] = 0;
						}
					}
					else if(i == 0){
						sum = ghost_row_top[j] + ghost_row_top[j - 1] + ghost_row_top[j + 1] 
						+ local_a[i][j-1] + local_a[i][j+1] 
						+ local_a[i+1][j-1] + local_a[i+1][j] + local_a[i+1][j+1];
						
						if(sum == 2 || sum == 3){
							temp[i][j] = 1;
						}
						else if(sum < 2 || sum > 3){
							temp[i][j] = 0;
						}
					}
					else if(i == cut_size_rows - 1){
						sum = ghost_row_bottom[j] + ghost_row_bottom[j - 1] + ghost_row_bottom[j + 1] 
						+ local_a[i][j-1] + local_a[i][j+1] 
						+ local_a[i-1][j-1] + local_a[i-1][j] + local_a[i-1][j+1];
						
						if(sum == 2 || sum == 3){
							temp[i][j] = 1;
						}
						else if(sum < 2 || sum > 3){
							temp[i][j] = 0;
						}
					}
				}
			}
​
			for(i = 0; i < cut_size_rows; i++){
				for(j = 0;j <columns;j++){
					local_a[i][j] = temp[i][j];
				}
			}
​
			//send to zero
			MPI_Send(local_a[0],cut_size,MPI_INT,0,0,MPI_COMM_WORLD);			
		}
		else if(even_odd == 0&& my_rank != bottom){
			//send to top
			MPI_Send(local_a[0],columns,MPI_INT,my_rank - 1,0,MPI_COMM_WORLD);
			//revieve from top
			MPI_Recv(ghost_row_top,columns,MPI_INT,my_rank - 1,0,MPI_COMM_WORLD,NULL);
			//send to bottom
			MPI_Send(local_a[cut_size_rows - 1],columns,MPI_INT,my_rank + 1,0,MPI_COMM_WORLD);
			//recieve from bottom
			MPI_Recv(ghost_row_bottom,columns,MPI_INT,my_rank + 1,0,MPI_COMM_WORLD,NULL);
			
			int i = 0;
			int j = 0;
			int sum = 0;
			
			for(i = 0; i < cut_size_rows; i++){
				for(j = 0;j <columns;j++){
					temp[i][j] = local_a[i][j];
				}
			}
			
			for(i = 0; i < cut_size_rows;i++){
				for(j = 0; j < columns;j++){
					if(i != 0 && i != 4){
						sum = local_a[i-1][j-1] + local_a[i-1][j] + local_a[i-1][j+1] 
						+ local_a[i][j-1] + local_a[i][j+1] 
						+ local_a[i+1][j-1] + local_a[i+1][j] + local_a[i+1][j+1];
						
						if(sum == 2 || sum == 3){
							temp[i][j] = 1;
						}
						else if(sum < 2 || sum > 3){
							temp[i][j] = 0;
						}
					}
					else if(i == 0){
						sum = ghost_row_top[j] + ghost_row_top[j - 1] + ghost_row_top[j + 1] 
						+ local_a[i][j-1] + local_a[i][j+1] 
						+ local_a[i+1][j-1] + local_a[i+1][j] + local_a[i+1][j+1];
						
						if(sum == 2 || sum == 3){
							temp[i][j] = 1;
						}
						else if(sum < 2 || sum > 3){
							temp[i][j] = 0;
						}
					}
					else if(i == cut_size_rows - 1){
						sum = ghost_row_bottom[j] + ghost_row_bottom[j - 1] + ghost_row_bottom[j + 1] 
						+ local_a[i][j-1] + local_a[i][j+1] 
						+ local_a[i-1][j-1] + local_a[i-1][j] + local_a[i-1][j+1];
						
						if(sum == 2 || sum == 3){
							temp[i][j] = 1;
						}
						else if(sum < 2 || sum > 3){
							temp[i][j] = 0;
						}
					}
				}
			}
​
			for(i = 0; i < cut_size_rows; i++){
				for(j = 0;j <columns;j++){
					local_a[i][j] = temp[i][j];
				}
			}
			//send to zero
			MPI_Send(local_a[0],cut_size,MPI_INT,0,0,MPI_COMM_WORLD);
			
		}
		else{
			//recieve from top
			MPI_Recv(ghost_row_top,columns,MPI_INT,my_rank - 1,0,MPI_COMM_WORLD,NULL);
			//send to top
			MPI_Send(local_a[0],columns,MPI_INT,my_rank - 1,0,MPI_COMM_WORLD);
			
			int i = 0;
			int j = 0;
			int sum = 0;
			
			int ghost_row_bottom[columns];
			
​
			for(i = 0; i < columns;i++){
				ghost_row_bottom[i] = 0;
			}
			
			for(i = 0; i < cut_size_rows; i++){
				for(j = 0;j <columns;j++){
					temp[i][j] = local_a[i][j];
				}
			}
			
			for(i = 0; i < cut_size_rows;i++){
				for(j = 0; j < columns;j++){
					if(i != 0 && i != 4){
						sum = local_a[i-1][j-1] + local_a[i-1][j] + local_a[i-1][j+1] 
						+ local_a[i][j-1] + local_a[i][j+1] 
						+ local_a[i+1][j-1] + local_a[i+1][j] + local_a[i+1][j+1];
						
						if(sum == 2 || sum == 3){
							temp[i][j] = 1;
						}
						else if(sum < 2 || sum > 3){
							temp[i][j] = 0;
						}
					}
					else if(i == 0){
						sum = ghost_row_top[j] + ghost_row_top[j - 1] + ghost_row_top[j + 1] 
						+ local_a[i][j-1] + local_a[i][j+1] 
						+ local_a[i+1][j-1] + local_a[i+1][j] + local_a[i+1][j+1];
						
						if(sum == 2 || sum == 3){
							temp[i][j] = 1;
						}
						else if(sum < 2 || sum > 3){
							temp[i][j] = 0;
						}
					}
					else if(i == cut_size_rows - 1){
						sum = ghost_row_bottom[j] + ghost_row_bottom[j - 1] + ghost_row_bottom[j + 1] 
						+ local_a[i][j-1] + local_a[i][j+1] 
						+ local_a[i-1][j-1] + local_a[i-1][j] + local_a[i-1][j+1];
						
						if(sum == 2 || sum == 3){
							temp[i][j] = 1;
						}
						else if(sum < 2 || sum > 3){
							temp[i][j] = 0;
						}
					}
				}
			}
​
			for(i = 0; i < cut_size_rows; i++){
				for(j = 0;j <columns;j++){
					local_a[i][j] = temp[i][j];
				}
			}
			//send to zero
			MPI_Send(local_a[0],cut_size,MPI_INT,0,0,MPI_COMM_WORLD);
​
		}
		
	}	
	MPI_Finalize();
}