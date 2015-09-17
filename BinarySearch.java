package eric.algorithmn.search;

import eric.util.SortUtil;

/**
 * 
 * @description binary search
 * @author duangduangda
 * @since 2015年9月15日
 */
public class BinarySearch {
	public static void main(String[] args) {
		int []a = {49, 38, 97, 65, 76, 13, 27};
		int key = 23;
		long starttime = System.currentTimeMillis();
		binarySearch(a,key);
		System.out.println("耗时：" + (System.currentTimeMillis() - starttime) + "ms");
	}

	private static void binarySearch(int[] a, int key) {
		SortUtil.quickSort(a);
		int left = 0,right = a.length - 1, mid = a.length/2;
		boolean isFound = false;
		while(left <= right){
			if(a[mid] > key){
				right = mid - 1;
				mid = (left + right - 1 )/ 2;
			}else if(a[mid] < key){
				left = mid + 1;
				mid = (left + right - 1 ) / 2;
			}else{
				isFound = true;
				break;
			}
		}
		if(isFound){
			//the return index is base on the sorted array,not the initial index
			System.out.println("find the position,and index of the value in the array is " + mid);
		}else{
			System.out.println("can not find the value in array");
		}
	}
}
