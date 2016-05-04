/*************************************************************
* The following source code is in produced in fulfillment    *
* for EG4387A SP2016 - Parallel Programming course.          *
* OpenMP
*************************************************************/
// Author - Oscar Guillermo Castro //
// Professor- Dr. Djaffer Ibaroudene //
// To compile using GCC, use the following (below):
//		gcc -g -Wall -fopenmp -o binary_name series_openmp.c

// --------------------------------------------------------------------------
// To run use the following:
// ./BINARY_NAME [Number of Processors] [Number of Terms] [Constant Difference] [First Element]
//
//		Brackets, that is[], denote options that the program.
#include <stdio.h>
#include <stdlib.h>
#include <mpi.h>
#include <time.h>

#define MASTER 0

int main(int argc, char* argv[])
{
	/*BEGIN defults*/
	int k = 0;
	int n = 100;
	int a1 = 3;
	int d = 7;
	int nprocs = 2;
	/*defaults*/

	//int arg_counter = argc;


	/* Taking terminal arguments */
	//if (argc >= 3) nprocs = strtol(argv[2], NULL, 10);
	//if (argc >= 4) n = strtol(argv[3], NULL, 10);
	if (argc >= 2) a1 = strtol(argv[1], NULL, 10);
	if (argc >= 3) n = strtol(argv[2], NULL, 10);
	if (argc >= 4) d = strtol(argv[3], NULL, 10);
	/*terminal arguments*/

	//Timer object
	// code taken from stackoverflow. (In regards to timer)
	/* http://stackoverflow.com/questions/459691/best-timing-method-in-c */
	clock_t start = clock(), diff;

	//MPI values
	int my_rank, comm_sz;
	int my_sum = 0;
	int sequence_total = 0;
	int global_sum = 0;
	int isExit = 0;

	// Initialize MPI environment
	MPI_Init(&argc, &argv);

	/* Get my process rank */
	MPI_Comm_rank(MPI_COMM_WORLD, &my_rank);

	/* Determine total number of processors */
	MPI_Comm_size(MPI_COMM_WORLD, &nprocs);

	/*
	if (my_rank == MASTER)
	{
		printf("The number of arguements is %d.\n", arg_counter);
		fflush(stdout);
		printf("nprocs = %d\n", nprocs);

		int i = 0;
		for (i = 0; i < argc; i++)
		{
			printf("%s\n", argv[i]);
			fflush(stdout);
		}
	}
	*/

	//Checking that n is divisible evenly by nprocs.
	if (my_rank == 0)
	{
		if ((n % nprocs) != 0)
		{
			printf("Please enter a number of n (%d) that is evenly divisible by %d processors\n",n, nprocs);
			fflush(stdout);
			isExit = 1;
		}
	}

	MPI_Bcast(&isExit, 1, MPI_INT, MASTER, MPI_COMM_WORLD);
	MPI_Barrier(MPI_COMM_WORLD);

	if (isExit == 1)
	{
		MPI_Finalize();
		exit(1);
	}

	// Calculating summation of the series
	int low = (my_rank * n / nprocs);
	int high = (my_rank + 1) * (n / nprocs);
	for (k = low; k < high; k++)
	{
		my_sum += (a1 + (k) * d);

	}

	//Barrier; wait for everyone before reduction.
	MPI_Barrier(MPI_COMM_WORLD);

	// Reduction
	MPI_Reduce(&my_sum, &global_sum, 1, MPI_INT, MPI_SUM, MASTER, MPI_COMM_WORLD);

	// Sequence formula
	// In the documentation this is formula (2)
	sequence_total = ((.5*n) * (2 * a1 + d * (n - 1)));



	// Obtaining the time it took to process.
	diff = clock() - start;
	int msec = diff * 1000 / CLOCKS_PER_SEC;

	if (my_rank == MASTER)
	{
		printf("The summation of the series is %d\n", global_sum);
		fflush(stdout);
		printf("The result given by formula (2) is %d\n", sequence_total);
		fflush(stdout);
		printf("Time taken, %d seconds, %d milliseconds\n", msec / 1000, msec % 1000);
		fflush(stdout);
	}

	MPI_Finalize();
}