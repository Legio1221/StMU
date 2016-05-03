/* File:     auc_partition_trapezoid.c
* Purpose:  Use MPI to implement a parallel version of the trapezoidal
*           rule.  This version uses collective communications to
*           distribute the input data and compute the global sum.
*
* Input:    The endpoints of the interval of integration and the number
*           of trapezoids
* Output:   Estimate of the integral from a to b of f(x)
*           using the trapezoidal rule and n trapezoids.
*
* Compile:  mpicc -g -Wall -o mpi_trap2 mpi_trap2.c
* Run:      mpiexec -n <number of processes> ./auc_partition_trapezoid
*
* Algorithm:
*    1.  Each process calculates "its" interval of
*        integration.
*    2.  Each process estimates the integral of f(x)
*        over its interval using the trapezoidal rule.
*    3a. Each process != 0 sends its integral to 0.
*    3b. Process 0 sums the calculations received from
*        the individual processes and prints the result.
*
* Note:  f(x) is all hardwired.
*
* IPP:   Section 3.4.2 (pp. 104 and ff.)
*/

/*
* Editor: Oscar Guillermo Castro
* Edited using MS-MPI & MS Visual Studio Community 2015
* 	Please see the following to install MS-MPI and configure
*	MS VS Community 2015.
*		https://blogs.technet.microsoft.com/windowshpc/2015/02/02/how-to-compile-and-run-a-simple-ms-mpi-program/
*/
#include <stdio.h>
//#include <stdlib.h>

/* We'll be using MPI routines, definitions, etc. */
#include <mpi.h>

/* The following macros are borrowed from the auc_partition_rectangle.c file*/
			// Macros //
#define BLOCK_LOW(rank,n,comm_sz) ((rank)*(n)/comm_sz)
#define BLOCK_HIGH(rank,n,comm_sz)  (BLOCK_LOW((rank+1),n,comm_sz)-1)

/* ------------------------------------------ Function Prototypes -------------------------------*/

/* Get the input values */
void Get_input(int my_rank, int comm_sz, double* a_p, double* b_p,
	int* n_p);

/* Calculate local integral  */
double Trap(double left_endpt, double right_endpt, int trap_count,
	double base_len);

/* Function we're integrating */
double f(double x);
/* ---------------------------------------- END Function Prototypes ------------------------------*/

// =================================================== MAIN ============================================================= //
int main(int argc, char *argv[]) {


	/* Initial Variables*/
	// Global variables?
	int my_rank, comm_sz, n, local_n;
	double a, b, h, local_a, local_b;
	double local_int, total_int;
	double PI25DT = 3.141592653589793238462643; // Use for PI accuracy

 // ----------------------------------------- MPI Environment -------------------------------------------------------- //
	MPI_Init(&argc, &argv);

	/* Get my process rank */
	MPI_Comm_rank(MPI_COMM_WORLD, &my_rank);

	/* Determine total number of processors */
	MPI_Comm_size(MPI_COMM_WORLD, &comm_sz);
// ------------------------------------------ END MPI Environment -------------------------------------------------------- //




// ****************************************** Pi Computation ************************************************************* //
	Get_input(my_rank, comm_sz, &a, &b, &n);

	h = (b - a) / n;          /* h is the same for all processes */

	// Use the macros instead.
	local_a = BLOCK_LOW(my_rank, n, comm_sz);
	local_b = BLOCK_HIGH(my_rank, n, comm_sz);


	local_n = local_b - local_a + 1; // Attuned to macros
	local_int = Trap(local_a*h, local_b*h, local_n, h);
// ***************************************** END Pi Computation ********************************************************** //


// ----------------------------------------- Print Results --------------------------------------------------------------- //
	/* Add up the integrals calculated by each process */
	MPI_Reduce(&local_int, &total_int, 1, MPI_DOUBLE, MPI_SUM, 0,
		MPI_COMM_WORLD);

	/* Print the result */
	if (my_rank == 0) {
		printf("With n = %d trapezoids, our estimate\n", n);
		// Clear the buffer
		fflush(stdout);
		printf("of the integral from %f to %f = %.15e\n",
			a, b, total_int);
		// Clear the buffer
		fflush(stdout);
		// borrowing code from the previous programs
		printf("The error value is %.16lf\n", fabs(total_int - PI25DT)); // Not working?
		fflush(stdout);
	}
// ---------------------------------------- END Print Results ------------------------------------------------------------ //


	/* Shut down MPI */
	MPI_Finalize();

	return 0;
} /*  main  */
// =========================================================== MAIN ========================================================================== //

  /*------------------------------------------------------------------
  * Function:     Get_input
  * Purpose:      Get the user input:  the left and right endpoints
  *               and the number of trapezoids
  * Input args:   my_rank:  process rank in MPI_COMM_WORLD
  *               comm_sz:  number of processes in MPI_COMM_WORLD
  * Output args:  a_p:  pointer to left endpoint
  *               b_p:  pointer to right endpoint
  *               n_p:  pointer to number of trapezoids
  */
void Get_input(int my_rank, int comm_sz, double* a_p, double* b_p,
	int* n_p) {

	if (my_rank == 0) {
		printf("Enter a, b, and n\n");
		// Clear the buffer
		fflush(stdout);
		scanf("%lf %lf %d", a_p, b_p, n_p);
	}
	MPI_Bcast(a_p, 1, MPI_DOUBLE, 0, MPI_COMM_WORLD);
	MPI_Bcast(b_p, 1, MPI_DOUBLE, 0, MPI_COMM_WORLD);
	MPI_Bcast(n_p, 1, MPI_INT, 0, MPI_COMM_WORLD);
}  /* Get_input */

   /*------------------------------------------------------------------
   * Function:     Trap
   * Purpose:      Serial function for estimating a definite integral
   *               using the trapezoidal rule
   * Input args:   left_endpt
   *               right_endpt
   *               trap_count
   *               base_len
   * Return val:   Trapezoidal rule estimate of integral from
   *               left_endpt to right_endpt using trap_count
   *               trapezoids
   */
double Trap(
	double left_endpt  /* in */,
	double right_endpt /* in */,
	int    trap_count  /* in */,
	double base_len    /* in */) {
	double estimate, x;
	int i;

	estimate = (f(left_endpt) + f(right_endpt)) / 2.0;
	for (i = 1; i <= trap_count - 1; i++) {
		x = left_endpt + i*base_len;
		estimate += f(x);
	}
	estimate = estimate*base_len;

	return estimate;
} /*  Trap  */


  /*------------------------------------------------------------------
  * Function:    f
  * Purpose:     Compute value of function to be integrated
  * Input args:  x
  */
double f(double x) {
	// DONE: change formula
	// Semi-taken from auc_partition_rectangle.
	return (4.0 / (1.0 + x*x));
} /* f */
