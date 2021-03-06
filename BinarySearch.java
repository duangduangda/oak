package eric.algorithmn.search;

import eric.util.SortUtil;

/**
 * 
 * @description binary search
 * @author duangduangda
 * @since 2015��9��15��
 */
public class BinarySearch {
	public static void main(String[] args) {
		int []a = {49, 38, 97, 65, 76, 13, 27};
		int key = 23;
		long starttime = System.currentTimeMillis();
		binarySearch(a,key);
		System.out.println("��ʱ��" + (System.currentTimeMillis() - starttime) + "ms");
	}

	private static void binarySearch(int[] a, int key) {
		SortUtil.quickSort(a);
		int left = 0,right = a.length - 1, mid = a.length/2;
		while(left <= right){
			if(a[mid] > key){
				right = mid - 1;
				mid = (left + right)/ 2;
			}else if(a[mid] < key){
				left = mid + 1;
				mid = (left + right) / 2;
			}else{
				System.out.println("find the position,and index of the value in the array is " + mid);
				break;
			}
		}
		if(left > right ){
			System.out.println("can not find the value in array");
		}
	}
}
