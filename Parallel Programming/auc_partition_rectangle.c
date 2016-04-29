/************************************************************
* Program: Pi Calculation                                   *
* Using the Rectangular Rule with Block Partioning		    *
* Oscar Guillermo Castro								    *
* EG 4387A												    *
* 30 March 2016											    *
*************************************************************/

#include "mpi.h"
#include <math.h>
#include <stdio.h>

#define MAX_NAME 80   /* length of characters for naming a process */
#define MASTER 0      /* rank of the master */
#define LOW(rank,nprocs,n) (rank*n/nprocs)
#define HIGH(rank,nprocs,n) (LOW((rank+1),nprocs,n)-1)

int main(int argc, char *argv[]) {

    int rank,                                           /* rank variable to identify the process */
        nprocs,                                         /* number of processes */
        i,
        len;                                            /* variable for storing name of processes */

    int n = 10000;                                      /* the number of bins */
    double PI25DT = 3.141592653589793238462643;         /* 25-digit-PI*/
    double mypi,                                        /* value from each process */
           pi,                                          /* value of PI in total*/
           step,                                        /* the step */
           sum,                                         /* sum of area under the curve */
           x,
		   my_left,										
		   my_right;

    char name[MAX_NAME];        /* char array for storing the name of each process */

    double start_time,          /* starting time */
           end_time,            /* ending time */
           computation_time;    /* time for computing value of PI */
 
	// PHASE I: INITIALIZE THE ENVIRONMENT
	/*=============================================================================
	*
	* BEGIN
	*
	*/
	
	// Initialize the environment
    MPI_Init(&argc, &argv);
	
	// A processor will retrieve their unique local rank
	MPI_Comm_rank(MPI_COMM_WORLD, &rank);
	
	// Setting the total amount of processors
	MPI_Comm_size(MPI_COMM_WORLD, &nprocs);

	// Getting the processor name
    MPI_Get_processor_name(name, &len);
	
	// Starting timer
    start_time = MPI_Wtime();
	/*
	*
	* END
	*
	*=============================================================================*/

	// REMOVE?
    /* Broadcast the number of bins to all processes */
    /* This broadcasts an integer which is n, from the master to all processes*/
	// =============================================================================
	/* BEGIN Broadcast number of bins*/
    //MPI_Bcast(&n,1,MPI_INT,MASTER,MPI_COMM_WORLD);
	/* END Broadcast number of bins*/
	// =============================================================================



	
	// PHASE II: COMPUTATION
	/* =============================================================================
	*
	* BEGIN
	*
	*/
	
    // Calculating for each process
    step = 1.0 / (double) n;
    sum = 0.0;
    for (i = rank; i < n; i += nprocs) {
        x = step * ((double)i + 0.5);
        sum += (4.0/(1.0 + x*x));
    }

    mypi = step * sum;
	/*
	*
	* END
	*
	* =============================================================================*/
	
	
	
	
	
	// PHASE III: REDUCTION
	/* =============================================================================
	*
	* BEGIN
	*
	*/
    
	// Now we can reduce all those sums to one value which is Pi
	MPI_Reduce(&mypi, &pi, 1, MPI_DOUBLE, MPI_SUM, 0, MPI_COMM_WORLD);
	
	/*
	*
	* END
	*
	* =============================================================================*/
	
	
	
	
	
	// PHASE IV: PRINT RESULTS
	/* =============================================================================
	*
	*BEGIN
	*
	*/
	
	printf("This is my sum: %.16f from rank: %d name: %s\n", mypi, rank, name);
	if (rank == 0)
	{
        printf("Pi is approximately %.16f, Error is %.16f\n", pi, fabs(pi - PI25DT));
        end_time = MPI_Wtime();
        computation_time = end_time - start_time;
        printf("Time of calculating PI is: %f\n", computation_time);
	}
    /* Terminate MPI execution environment */
    MPI_Finalize();
	/*
	*
	* END
	*
	* =============================================================================*/
	
	// Finish the program.
    return 0;
}