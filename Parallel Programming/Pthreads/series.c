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
//#include <omp.h>
#include <time.h>
#include <pthread.h>

#define MAX_THREADS 25

void *for_sum(void *arguements);
//void *calc_sequences(int *array, int a1, int d, int n_times);

struct arg_for_sum {
	int sum;
	int n_times;
	int *array;
	int d;
	int a1;
	int thread_id;
	int thread_count;
};

struct arg_calc_sequences {
	int *array;
	int a1;
	int d;
	int n_times;
	int thread_id;
	int thread_count;
};

	
/* Shared Variables */
int global_sum = 0;
int *global_array;
pthread_mutex_t sum_mutex = PTHREAD_MUTEX_INITIALIZER;
int thread_count;

int main(int argc,char* argv[])
{
	/*BEGIN defaults*/
	int k = 0;
	int n = 5;
	int a1 = 3;
	int d = 7;
	int *array;
	int summation_total = 0;
	int sequence_total = 0;
	thread_count = 1;
	long thread;
	/*defaults*/
	
	/* Taking terminal arguments */
	if (argc >= 2) a1 = strtol(argv[1], NULL, 10);
	if (argc >= 3) n = strtol(argv[2], NULL, 10);
	if (argc >= 4) d = strtol(argv[3], NULL, 10);
	if (argc >= 5) thread_count = strtol(argv[4], NULL, 10);
	/*terminal arguments*/
	
	// allocating memory
	//global_array = (int *)malloc(sizeof(int *) * n);
	global_array = (int *)malloc(sizeof(int *) * thread_count);
	pthread_t* thread_handles = malloc(thread_count * sizeof(pthread_t));

	// Creating arg structs
	struct arg_for_sum *sum_args;
	// struct arg_calc_sequences calc_args;

	sum_args = malloc(thread_count * sizeof(sum_args));
	for (int i = 0; i < thread_count; i++)
	{
		sum_args[i].array = array;
		sum_args[i].n_times = n;
		sum_args[i].sum = summation_total;
		sum_args[i].a1 = a1;
		sum_args[i].d = d;
		sum_args[i].thread_count = thread_count;
		sum_args[i].thread_id = i;
	}
	

	/*
	calc_args.a1 = a1;
	calc_args.array = array;
	calc_args.d = d;
	calc_args.n_times = n;
	*/

	

	//OpenMP version
	/*
	// Calculating each sequence in the series
	# pragma omp parallel for num_threads(thread_count)
	for(k = 0; k < n; k++)
	{
		array[k] = (a1 +(k) * d);
	}
	*/
	//end OpenMP version

	// Adding elements of the series to array
	for (thread = 0; thread < thread_count; thread++)
	{
		pthread_create(&thread_handles[thread], NULL, for_sum, (void *) &sum_args[thread]);
	}


	// OpenMP version
	/*
	// Calculating summation of the series
	# pragma omp parallel for num_threads(thread_count) \
		reduction(+: summation_total)
	for(k = 0; k < n; k++)
	{
		summation_total += array[k];
	}*/
	//end OpenMP



	// Sequence formula
	// In the documentation this is formula (2)
	sequence_total = ((.5*n) * (2 * a1 + d * (n-1)));
	
	
	
	
	printf("The summation of the series is %d\n", global_sum);
	fflush(stdout);
	printf("The result given by formula (2) is %d\n", sequence_total);
	fflush(stdout);
	
	
	free(array);
	free(thread_handles);

	pthread_exit(NULL);
}


void *for_sum(void *arguements) 
{
	struct arg_for_sum *args = arguements;

	int n = args->n_times;
	int sum = args->sum;
	//int array = args->array;
	int t_id = args->thread_id;
	int t_count = args->thread_count;
	int a1 = args->a1;
	int d = args->d;
	

	int my_sum;
	int *local_array;
	int chunk_size = n / t_count;

	local_array = malloc(n * sizeof(int));

	for (int i = 0; i < n; i++)
	{
		local_array[i] = 0;
	}

	for (int k = (chunk_size * t_id); k < (t_id + 1)*chunk_size; k++)
	{
		local_array[k] = (a1 + (k)* d);
	}

	for (int i = 0; i < n; i++)
	{
		my_sum += local_array[i];
	}

	pthread_mutex_lock(&sum_mutex);
	global_sum += my_sum;
	pthread_mutex_unlock(&sum_mutex);

	pthread_exit(NULL);
	return NULL;
}
