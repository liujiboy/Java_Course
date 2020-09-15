/**
 * 
 */
package code0507;

/**
 * MergeSort.java
 * Copyright (c) 2016 ChongQing University All rights reserved.
 */
public class MergeSort {
	
	public static <T extends Comparable> boolean mergeSortRecursive(T[] t){
		if(t==null || t.length <= 1) return true;		
		MSortRecursive(t, 0, t.length-1);		
		return true;
	}
	
	private static <T extends Comparable> boolean MSortRecursive(T[] t, int low, int high){
		if(t==null || t.length <= 1 || low == high) return true;		
		int mid = (low+high)/2;
		MSortRecursive(t, low, mid);
		MSortRecursive(t, mid+1, high);
		merge(t, low, mid ,high);
		return true;
	}
		
	private static <T extends Comparable> boolean merge(T[] t, int low, int mid, int high){		
		T[] s = t.clone();//先复制一个辅助数组		
		int i, j, k;//三个指示器，i指示t[low...mid]，j指示t[mid+1...high]，k指示s[low...high]
		for(i=low, j=mid+1, k=low ; i<=mid && j<=high ; k++){
			if(t[i].compareTo(t[j]) <= 0){
				s[k] = t[i++];
			}else{
				s[k] = t[j++];
			}
		}
		
		//将剩下的元素复制到s中
		if(i <= mid){
			for( ; k <= high; k++){
				s[k] = t[i++];
			}
		}else{
			for( ; k<=high; k++){
				s[k] = s[j++];
			}
		}
		for(int m = low; m<=high ; m++){//将辅助数组中的排序好的元素复制回原数组
			t[m] = s[m];
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		Integer[] arr = new Integer[]{2,3,6,8,9,2,0,1};
		mergeSortRecursive(arr);
		for(int i : arr){
			System.out.println(i);
		}
		String[] dl=new String[]{"hello","ebay","chong","qing","china"};
		mergeSortRecursive(dl);
		for(String d : dl){
			System.out.println(d);
		}
		
	}
}
