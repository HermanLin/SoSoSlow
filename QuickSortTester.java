

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

    public static void quicksort (int[] arr, int left, int right, int pivot) {
	if (left < right) {
	    int pvtPos = partition (arr, left, right, pivot);
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
	
	
	int[] best, worst, average;
	//best case: median pivot (we can use fastselect)
	best = {1, 2, 3, 4, 5};
	//worst case: pivot is the least or greatest value of the array
	//            pivot is at either end of the array when the array is sorted
	worst = {1, 2, 3, 4, 5};
	//average case: middle point is the pivot
	average = {1, 2, 3, 4, 5};
	
	

    }
    
}
