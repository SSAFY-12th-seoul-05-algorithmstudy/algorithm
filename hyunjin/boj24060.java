/* BOJ24060_병합 정렬 1 */

import java.util.Scanner;

public class boj24060 {
	static int N, K;
	static int[] arr;
	static int cnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();

		arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		merge_sort(arr, 0, N - 1);
		
	} // main

	static void merge_sort(int[] arr, int p, int r) {
		if (p < r) {
			int q = (p + r) / 2;
			merge_sort(arr, p, q);
			merge_sort(arr, q + 1, r);
			merge(arr, p, q, r);
		}
	} // merge_sort

	static void merge(int[] arr2, int p, int q, int r) {
		int i = p;
		int j = q + 1;
		int t = 0;
		int[] tmp = new int[N];

		cnt = 0;

		while (i <= q && j <= r) {
			if (arr[i] <= arr[j]) {
				tmp[t++] = arr[i++];

			} else {
				tmp[t++] = arr[j++];
			}
			cnt++;
		}
		

		while (i <= q) {
			tmp[t++] = arr[i++];
			cnt++;
		}

		while (j <= r) {
			tmp[t++] = arr[j++];
			cnt++;
		}

		i = p;
		t = 0;

		while (i <= r) {
			arr[i++] = tmp[t++];
			cnt++;
		}


	} // merge
}
