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
// ./BINARY_NAME [First Term] [Number of Terms] [Constant Difference] [Number of Threads]
//
//		Brackets, that is[], denote options that the program.
#include <stdio.h>
#include <stdlib.h>
#include <omp.h>
#include <time.h>

int main(int argc,char* argv[])
{
	/*BEGIN defults*/
	int k = 0;
	int n = 5;
	int a1 = 3;
	int d = 7;
	int *array;
	int summation_total = 0;
	int sequence_total = 0;
	int thread_count = 1;
	/*defaults*/
	
	/* Taking terminal arguments */
	if (argc >= 2) a1 = strtol(argv[1], NULL, 10);
	if (argc >= 3) n = strtol(argv[2], NULL, 10);
	if (argc >= 4) d = strtol(argv[3], NULL, 10);
	if (argc >= 5) thread_count = strtol(argv[4], NULL, 10);
	/*terminal arguments*/
	
	// allocating memory
	array = (int *)malloc(sizeof(int *) * n);
	
	//Timer object
	// code taken from stackoverflow. (In regards to timer)
	/* http://stackoverflow.com/questions/459691/best-timing-method-in-c */
	clock_t start = clock(), diff;
	// Calculating each sequence in the series
	# pragma omp parallel for num_threads(thread_count)
	for(k = 0; k < n; k++)
	{
		array[k] = (a1 +(k) * d);
	}
	
	// Calculating summation of the series
	# pragma omp parallel for num_threads(thread_count) \
		reduction(+: summation_total)
	for(k = 0; k < n; k++)
	{
		summation_total += array[k];
	}
	
	// Sequence formula
	// In the documentation this is formula (2)
	sequence_total = ((.5*n) * (2 * a1 + d * (n-1)));
	
	
	
	// Obtaining the time it took to process.
	diff = clock() - start;
	int msec = diff * 1000 / CLOCKS_PER_SEC;
	
	printf("The summation of the series is %d\n", summation_total);
	fflush(stdout);
	printf("The result given by formula (2) is %d\n", sequence_total);
	fflush(stdout);
	printf("Time taken, %d seconds, %d milliseconds\n", msec/1000, msec%1000);
	fflush(stdout);
	
	free(array);
}