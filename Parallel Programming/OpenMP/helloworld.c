/****************************************************************
* The following source code taken from Saint Mary's University's
* EG XXXX - Parallel Programming Course
* Materials taken from An Introduction to Parallel Programming.
* Professor: Dr. Djaffer Ibaroudene
* Written by: Oscar Guillermo Castro
* 
* The source code was compiled with GCC with the following:
* gcc -g -Wall -fopenmp -o omp_hello helloworld.c
*******************************************************************/

#include <stdio.h>
#include <stdlib.h>
#include <omp.h>

void Hello(void); /* Thread function*/

int main(int argc, char* argv[]) {
	
	int thread_count = strtol(argv[1], NULL, 10);
	
	# pragma omp parallel num_threads(thread_count)
	Hello();
	
	// Trapezoidal function part
	double global_result = 0.0;
	double a, b;
	int n;
	
	printf("Enter a, b, and n\n");
	scanf("%lf %lf %d", &a, &b, &n);
	# pragma omp parallel num_threads(thread_count)
	Trap(a, b, n, &global_result);
	
	printf("With n = %d trapezoids, our estimate\n", n);
	printf("of the integral from %f to %f = %.14e\n", a, b, global_result);
	
	return 0;
} /* main */

void Hello(void) {
	int my_rank = omp_get_thread_num();
	int thread_count = omp_get_num_threads();
	
	printf("Hello from thread %d of %d\n", my_rank, thread_count);
} /* hello */

void Trap(double a, double b, int n, double* global_result_p){
	double h, x, my_result;
	double local_a, local_b;
	int i, local_n;
	int my_rank = omp_get_thread_num();
	int thread_count = omp_get_num_threads();
	
	h = (b-a)/n;
	local_n = n/thread_count;
	local_a = a + my_rank * local_n * h;
	local_b = local_a + local_n * h;
	
	//my_result = (f(local_a))
}