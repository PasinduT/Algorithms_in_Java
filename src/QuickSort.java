
public class QuickSort {
	public static void sort(Comparable [] a) {
		sort(a, 0, a.length - 1);
	}
	private static void sort(Comparable arr[], int lo, int hi) {
		if(hi <= lo) return;
		int j = partition(arr, lo, hi);
		sort(arr, lo, j - 1);
		sort(arr, j + 1, hi);
	}
	private static int partition(Comparable [] a, int lo, int hi) {
		int i = lo;
		int j = hi + 1;
		Comparable v = a[lo];
		while(true) {
			while(a[++i].compareTo(v) < 0) if (i == hi) break;
			while(a[--j].compareTo(v) > 0) if (j == lo) break;
			if(i >= j) break;
			Comparable temp = a[i];
			a[i] = a[j];
			a[j] = temp;
		}
		Comparable temp = a[lo];
		a[lo] = a[j];
		a[j] = temp;
		return j;
	}
	
	public static void main(String [] args) {
		Integer [] arr = {2, 4, 13, 10, 11, 7, 2, 5, 1};
		sort(arr);
		for(int i: arr) {
			System.out.println(i);
		}
	}

}
