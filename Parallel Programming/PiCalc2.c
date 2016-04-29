/***********************************************************
* Program: Pi Calculation
* Using the Rectangular Rule
* 
*************************************************************/

#include <mpi.h>
#include <math.h>
#include <stdio.h>

#define MAX_NAME 80   /* length of characters for naming a process */
#define MASTER 0      /* rank of the master */
#define BLOCK_LOW(rank,nprocs,n) ((rank)*(n)/nprocs)
#define BLOCK_HIGH(rank,nprocs,n)  (BLOCK_LOW((rank+1),nprocs,n)-1)




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
		   myLeft,
		   myRight;

    char name[MAX_NAME];        /* char array for storing the name of each process */

    double start_time,          /* starting time */
           end_time,            /* ending time */
           computation_time;    /* time for computing value of PI */

	
	MPI_Init(NULL, NULL);
	
	/* Get the number of processes */
	MPI_Comm_size(MPI_COMM_WORLD, &nprocs); 

	/* Get my rank among all the processes */
	MPI_Comm_rank(MPI_COMM_WORLD, &rank); 

    MPI_Get_processor_name(name, &len);
	
	myLeft = BLOCK_LOW(rank,nprocs,n);
	myRight = BLOCK_HIGH(rank, nprocs,n);
	

    start_time = MPI_Wtime();

    
    /* Calculating for each process */
    step = 1.0 / (double) n;
    sum = 0.0;
    for (i = myLeft; i <= myRight; i++) {
		
        x = step * ((double)i + 0.5);
        sum += (4.0/(1.0 + x*x));
    }
	
	mypi = step * sum;
	
	MPI_Reduce(&mypi,&pi , 1, MPI_DOUBLE, MPI_SUM,0,MPI_COMM_WORLD);

    printf("This is my sum: %.16f from rank: %d name: %s\n", mypi, rank, name);


    if (rank == 0) {
        printf("Pi is approximately %.16f, Error is %.16f\n", pi, fabs(pi - PI25DT));
        end_time = MPI_Wtime();
        computation_time = end_time - start_time;
        printf("Time of calculating PI is: %f\n", computation_time);
    }
    /* Terminate MPI execution environment */
    MPI_Finalize();
    return 0;
}
