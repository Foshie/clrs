package clrs;

public class Sorts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello World");
		int[] arr = {5, 2, 4, 6, 1, 3};
		
		System.out.println("Increasing");
		insertionSortInc(arr);

		System.out.println("Decreasing");
		insertionSortDec(arr);
		
		
	}
	//Increasing
	public static void insertionSortInc(int[] a) {
		for(int i = 1; i < a.length; i++) {
			int key = a[i], j = i-1;
			while(j >= 0 && a[j] > key) {
				//shift item to the right
				a[j+1] = a[j];
				j--;
			}
			a[j+1] = key;
			
			intArrayToString(a);
		}
	}
	
	//Decreasing
	public static void insertionSortDec(int[] a) {
		for(int i = 1; i < a.length; i++) {
			int key = a[i], j = i-1;
			while(j >= 0 && a[j] < key) {
				//shift item to right
				a[j+1] = a[j];
				j--;
			}
			a[j+1] = key;
			
			intArrayToString(a);
		}
	}
	
	public static void intArrayToString(int[] arr) {
		System.out.print("[");
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
			if(i != arr.length-1)
				System.out.print(", ");
		}
		System.out.print("]\n");
	}
}
