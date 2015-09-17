/**
 * 
 */
package eric.util;

/**
 * @description sort algorithmn
 * @author duangduangda
 * @since 2015Äê9ÔÂ15ÈÕ
 */
public class SortUtil {
	
	//insert sort
	public static void insertSort(int []a){
		for (int i = 1; i < a.length; i++) {
			int key = a[i];
			int j = i - 1;
			while (j >= 0 && a[j] > key) {
				a[j + 1] = a[j];
				j--;
			}
			a[j + 1] = key;
			PrintArrUtil.printArr(a);
		}
	}
	
	//quick sort
	public static void quickSort(int []a){
		quickSort(a,0,a.length - 1);
	}
	
	//quick sort
	public static void quickSort(int[] a, int left, int right) {
		if(left < right){
			int privokey = partition(a,left,right);
			quickSort(a,left,privokey - 1);
			quickSort(a,privokey + 1,right);
		}
	}

	private static int partition(int[] a, int left, int right) {
		int key = a[left];
		while(left < right){
			while(left < right && a[right] >= key){
				right--;
			}
			a[left] = a[right];
			while(left < right && a[left] <= key){
				left++;
			}
			a[right] = a[left];
		}
		a[left] = key;
		PrintArrUtil.printArr(a);
		return left;
	}
	
	//merge sort
	public static void mergeSort(int []a){
		int []tmp = new int[a.length];
		mergeSort(a,tmp,0,a.length - 1);
	}
	//merge sort
	public static void mergeSort(int []a,int []tmp){
		mergeSort(a,tmp,0,a.length - 1);
	}
	
	//merge sort
	public static void mergeSort(int []a,int left, int right){
		int []tmp = new int[a.length];
		mergeSort(a,tmp,left, right);
	}
	
	//merge sort
	public static void mergeSort(int []a,int []tmp, int left, int right) {
		if(left < right){
			int center = (left + right) / 2;
			mergeSort(a,tmp,left,center);
			mergeSort(a,tmp,center + 1,right);
			merge(a,tmp,left,center + 1,right);
		}
	}
	
	private static void merge(int[] a, int[] tmp, int leftPos, int rightPos, int rightEnd) {
		int leftEnd = rightPos - 1;
		int tmpPos = leftPos;
		int numElements = rightEnd - leftPos + 1;
		
		//Mail loop
		while(leftPos <= leftEnd && rightPos <= rightEnd){
			if(a[leftPos] <= a[rightPos]){
				tmp[tmpPos++] = a[leftPos++];
			}else{
				tmp[tmpPos++] = a[rightPos++];
			}
		}
		while(leftPos <= leftEnd){
			tmp[tmpPos++] = a[leftPos++];
		}
		while(rightPos <= rightEnd){
			tmp[tmpPos++] = a[rightPos++];
		}
		for(int i = 0;i < numElements;i++,rightEnd--){
			a[rightEnd] = tmp[rightEnd];
		}
		PrintArrUtil.printArr(a);
	}
	
	//heap sort
	public static void heapSort(int[] a) {
		//buildHeap
		for(int i = a.length/2;i >= 0;i--){
			percDown(a,i,a.length);
		}
		for(int j = a.length - 1;j > 0;j--){
			//delelteMax
			int tmp = a[0];
			a[0] = a[j];
			a[j] = tmp;
			percDown(a,0,j);
			PrintArrUtil.printArr(a);
		}
	}

	private static void percDown(int[] a, int i, int n) {
		int child = 0,tmp = 0;
		for(tmp = a[i];leftChild(i) < n;i = child){
			child = leftChild(i);
			if(child != n - 1&& a[child] <a [child + 1]){
				child++;
			}
			if(tmp < a[child]){
				a[i] = a[child];
			}else{
				break;
			}
		}
		a[i] = tmp;
	}

	private static int leftChild(int i) {
		return 2 * i + 1;
	}
	
	//bubble sort
	public static void bubbleSort(int[] a) {
		for (int i = a.length - 1; i > 0; i--) {
			for (int j = i - 1; j >= 0; j--) {
				if (a[j] > a[i]) {
					int temp = a[j];
					a[j] = a[i];
					a[i] = temp;
				}
			}
			PrintArrUtil.printArr(a);
		}
	}
	
	//shell sort
	public static void shellSort(int []a) {
		for(int pace = a.length/2;pace >= 1;pace /= 2){
			for (int i = pace; i < a.length; i++) {
				int key = a[i];
				int j = i - pace;
				while (j >= 0 && a[j] > key) {
					a[j + pace] = a[j];
					j -= pace; 
				}
				a[j + pace] = key;
			}
			PrintArrUtil.printArr(a);
		}
	}
}
