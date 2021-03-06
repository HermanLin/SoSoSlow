//Team SoSoSlow -- Herman Lin, Elaina Chung, Lisa Eng
//APCS2 pd3
//LAB01 -- What Does the Data Say?
//2017-03-09

/*

  PIVOT SELECTION AFFECT EXECUTION TIME
  Create an array (arrayOne) that partitions with different pivots.

  BEST CASE PIVOT: median of the array
  WORST CASE PIVOT: smallest/largest value of the array
  AVERAGE CASE PIVOT: val at the middle index of arary

  After each run, using System.nanoTime() to time start and end time to find runtime

  DATA ARRANGEMENT AFFECT EXECUTION TIME

  Using the average case pivot to partition, we will find execution time for the following arrays:

  SHUFFLE


  After each run, using System.nanoTime() to time start and end time to find runtime
*/

public class QuickSortTester {

    public static void swap( int x, int y, int[] o ) {
	int tmp = o[x];
	o[x] = o[y];
	o[y] = tmp;
    }

    //print input array
    public static void printArr( int[] a ) {
	for ( int o : a )
	    System.out.print( o + " " );
	System.out.println();
    }

    //shuffle elements of input array
    public static void shuffle( int[] d ) {
	int tmp;
	int swapPos;
	for( int i = 0; i < d.length; i++ ) {
	    tmp = d[i];
	    swapPos = i + (int)( (d.length - i) * Math.random() );
	    swap( i, swapPos, d );
	}
    }

    //================================================
    // TEST PIVOT BEST CASE
    public static void qsort( int[] d ) {
	quicksort (d, 0, d.length - 1);
    }
    
    public static void quicksort (int[] arr, int left, int right) {
	if (left < right) {
	    int pvtPos = partition (arr, left, right, 0);
	    quicksort (arr, left, pvtPos - 1);
	    quicksort (arr, pvtPos + 1, right);
	}
    }

    public static int partition(int arr[], int left, int right, int pvtPos) {
	int pvtVal = arr[pvtPos];
	swap(pvtPos, right, arr);
	int storVal = left;

	for (int i = left; i < right; i++) {
	    if (arr[i] <= pvtVal) {
		swap(i, storVal, arr);
		storVal++;
	    }
	}
	swap(storVal, right, arr);
	return storVal;
    }
    //==================================================
    //TEST PIVOT WORST CASE
	
    public static int findMinPos (int[] a){
	int min = a[0];
	int minPos = 0;
	for (int x = 0; x < a.length; x+=1){
	    if (a[x] < min){
		min = a[x];
		minPos = x;
	    }
	}
	return minPos;
    }

    public static int findMaxPos (int[] a){
	int max = a[0];
	int maxPos = 0;
	for (int x = 0; x < a.length; x+=1){
	    if (a[x] > max){
		max = a[x];
		maxPos = x;
	    }
	}
	return maxPos;
    }
    public static void qsortWC( int[] d, int minMaxPos ) {
	quicksortWC (d, 0, d.length - 1, minMaxPos);
    }
    
    public static void quicksortWC (int[] arr, int left, int right, int minMaxPos) {
	if (left < right) {
	    int pvtPos = partition(arr, left, right, minMaxPos);
	    quicksortWC (arr, left, pvtPos - 1, minMaxPos);
	    quicksortWC (arr, pvtPos + 1, right, minMaxPos);
	}
    }
	
    public static void main (String[] args) {
	
	//best: pvtPos = median
	//worst: pvtPos = biggest/smallest value
	//average: pvtPos = middle element
	
	//BEST CASE
	int[] arrayOne = {1, 2, 3, 4, 5};
	int[] arrayTwo = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
	int[] arrayThree = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
	
	System.out.println("Checking case for:");
	printArr(arrayOne);
	    
	double bestStartTime = 0;
	double bestEndTime = 0;
	double bestTime = 0;
	double bestSummation = 0;
	for (int x = 0; x < 10; x ++) {
	    bestStartTime = System.nanoTime();
	    qsort(arrayOne);
	    bestEndTime = System.nanoTime();
	    bestTime = (bestEndTime - bestStartTime);
	    System.out.println("Test " + x + ": " + bestTime + " nanoseconds");
	    bestSummation += bestTime;
	}
	System.out.println("\nAverage Time: " + bestSummation/10 + " nanoseconds");
	    
	//WORST CASE
	System.out.println("Checking case for:");
	printArr(arrayOne);
	
	int minPos = findMinPos(arrayOne);
	int maxPos = findMaxPos(arrayOne);
	    
	double worstStartTime = 0;
	double worstEndTime = 0;
	double worstTime = 0;
	double worstSummation = 0;
	for (int x = 0; x < 10; x ++) {
	    worstStartTime = System.nanoTime();
	    qsortWC(arrayOne, maxPos);
	    worstEndTime = System.nanoTime();
	    worstTime = (worstEndTime - worstStartTime);
	    System.out.println("Test " + x + ": " + worstTime + " nanoseconds");
	    worstSummation += worstTime;
	}
	System.out.println("\nAverage Time: " + worstSummation/10 + " nanoseconds");

	//=-=-=-=-=-=AVERAGE CASE TESTING=-=-=-=-=-=
	System.out.println("Checking case for:");
	printArr(arrayTwo);

	double avgStartTime = 0;
	double avgEndTime = 0;
	double avgTime = 0;
	double avgSummation = 0;

	for (int x = 40; x < 60; x ++) {
	    for (int y = 0; y < 5; y ++) {
		avgStartTime = System.nanoTime();
		qsortWC(arrayTwo, x);
		avgEndTime = System.nanoTime();
		avgTime = avgEndTime - avgStartTime;
		//System.out.println("Test " + y + ": " + avgTime + " nanoseconds");
		avgSummation += avgTime;
	    }
	    System.out.println("Average Time for index " + x + ": " + avgSummation/5 + " nanoseconds");
	    avgSummation = 0;
	}

	shuffle(arrayTwo);
	System.out.println("\nChecking case for:");
	printArr(arrayTwo);

	double avgShuffleST = 0;
	double avgShuffleET = 0;
	double avgShuffleT = 0;
	double avgShuffleS = 0;

	for (int x = 40; x < 60; x ++) {
	    for (int y = 0; y < 5; y ++) {
		avgShuffleST = System.nanoTime();
		qsortWC(arrayTwo, x);
		avgShuffleET = System.nanoTime();
		avgShuffleT = avgShuffleET - avgShuffleST;
		//System.out.println("Test " + y + ": " + avgShuffleT + " nanoseconds");
		avgShuffleS += avgShuffleT;
	    }
	    System.out.println("Average Time for index " + x + ": " + avgShuffleS/5 + " nanoseconds");
	    avgShuffleS = 0;
	}
	/*=====================================================================
	  =====================================================================*/
    }
}
	      

    
