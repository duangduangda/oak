package eric.algorithmn.search;
/**
 * 
 * @description joseph ring
 * @author duangduangda
 * @since 2015-09-11
 */
public class Joseph {
	public static void main(String[] args) {
		int[]a = new int[100];
		int key = 12;
		for(int i = 0;i < a.length;i++){
			a[i] = i + 1;
		}
		doJoseph(a,key);
	}

	private static void doJoseph(int[] a, int key) {
		int cursor = 1, index = 0, num = a.length,rank = 1;
		while (num > 0) {
			if (a[index % a.length] != -1) {
				if (cursor % key == 0) {
					System.out.println("The " + rank++ + "th output number is "+ a[index % a.length]);
					if (num-- == 1) {
//						System.out.println("The last output number is "+ a[index % a.length]);
						break;
					}
					a[index % a.length] = -1; // out of the ring
				}
				cursor++;
			}
			index++;
		}
		System.out.println("cursor = " + cursor + ",index = " + index);
	}

}
