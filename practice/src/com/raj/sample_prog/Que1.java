package com.raj.sample_prog;

public class Que1 {

	public static int binSearch(int [] arr, int x, int start, int n ){
		
		
		int mid = start + (n-start)/2;
		if (start > n)
			return -1;
		if (arr[mid] == x)
			return mid;
		if (x < arr[mid])
			return binSearch(arr, x, start, mid-1);
		else
			return binSearch(arr, x, mid+1, n);
		
			
		
		//return -1;
	}
	
//	public static int binSearch(int [] arr, int x, int start, int n ){
//	int mid = start + (n-start)/2;
//	
//	if (arr[mid] == x)
//		return mid;
//	else if (x < arr[mid])
//		return binSearch(arr, x, start, mid-1);
//	else if(x > arr[mid])
//		return binSearch(arr, x, mid+1, n);
//	else 
//		
//		return -1;
//}
	
	public static int binSearch2(int[] arr, int x) {

		int start = 0;
		int end = arr.length-1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (arr[mid] == x)
				return mid;
			else if (arr[mid] < x)
				start = mid + 1;
			else
				end = mid - 1;
		}
		return -1;
	}
	
	public static int binSearch3(int[] arr, int x) {
		int k = 0, n = arr.length;
		for (int b = n / 2; b >= 1; b /= 2) {
			//System.out.println("==>" + b);
			while (k + b < n && arr[k + b] <= x) {
				//System.out.println("====>" + k);
				k += b;
				//System.out.println("======>" + k);
			}
		}
		if (arr[k] == x)
			return k;
		return -1;
	}
	
	
	public static void main(String[] args) {
		// int [] arr = new int[] {1,2,3,5,6,8,9,12,24,45,50};
		int[] arr = new int[] { 1, 2, 3, 5, 6, 8, 9, 12, 24,30 };
		int res = binSearch(arr, 5, 0, arr.length-1);
		System.out.println(res);
		res = binSearch2(arr, 10);
		System.out.println(res);
		
		res = binSearch3(arr, 30);
		System.out.println(res);
		
		arr = new int[] { 18, 19, 22, 24, 31, 32, 1, 2, 3, 5, 6, 7, 8, 9, 10 };
//		arr = new int[] {   32, 1, 2, 3, 5, 6, 7, 8, 9, 10 };
		res = binSearchInRotate(arr, 30, 0, arr.length-1);
		System.out.println(res);
	}
	
	
	
	
	public static int binSearchInRotate(int [] arr, int x, int start, int n ){
		if (start > n)
			return -1;
		
		int mid = start + (n-start)/2;
		//System.out.println("==>" + mid);
		if (arr[mid] == x)
			return mid;
		//When 1st half is proper sorted rest half is rotated sorted.
		if (arr[start] < arr[mid])
			if(x >= arr[start] && x <arr[mid] )
				return binSearchInRotate(arr, x, start, mid-1);
			else
				return binSearchInRotate(arr, x, mid+1, n);

		else {
		//	System.out.println("===>" + mid);
			if(x <= arr[n] && x > arr[mid])
				return binSearchInRotate(arr, x, mid+1, n);
			else
				return binSearchInRotate(arr, x, start, mid-1);
		}
		//return -1;
	}
	
	
	
}
