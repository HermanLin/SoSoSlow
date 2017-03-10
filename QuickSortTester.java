

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

    public static void main (String[] args) {
	
	//best: pvtPos = median
	//worst: pvtPos = biggest/smallest value
	//average: pvtPos = middle element
	
	int[] arrayOne = {1, 2, 3, 4, 5};
	//int[] arrayTwo = 
	
	System.out.println("Checking case for:");
	printArr(arrayOne);
	
	double bestStartTime = 0;
	double bestEndTime = 0;
	double bestTime = 0;
	double summation = 0;
	for (int x = 0; x < 10; x ++) {
	    bestStartTime = System.nanoTime();
	    qsort(arrayOne);
	    bestEndTime = System.nanoTime();
	    bestTime = (bestEndTime - bestStartTime);
	    System.out.println("Test " + x + ": " + bestTime + " nanoseconds");
	    summation += bestTime;
	}
	System.out.println("\nAverage Time: " + summation/10 + " nanoseconds");
    }

}
	      

    
