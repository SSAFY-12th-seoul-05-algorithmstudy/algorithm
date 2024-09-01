import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj24060 {
	static int targetCnt = 0;
	static int saveCnt = 0;
	static boolean isFinished = false;
	static int savedNo = -1;
	static int[] arr = {};
	static int[] tmpArr = {};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int arrSize = Integer.parseInt(st.nextToken());
		targetCnt = Integer.parseInt(st.nextToken());
		arr = new int[arrSize];
		tmpArr = new int[arrSize];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arrSize; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		merge_sort(0, arrSize - 1);
		System.out.println(savedNo);
	}
	
	public static void merge_sort(int start, int end) {
		if (isFinished)
			return;
		if (start < end) {
			int mid = (start + end) / 2;
			merge_sort(start, mid);
			merge_sort(mid + 1, end);
			merge(start, mid, end);
		}
	}
	
	public static void merge(int start, int mid, int end) {
		int i = start, j = mid + 1, t = 0;
		
		while(i <= mid && j <= end) {
			if (arr[i] <= arr[j])
				tmpArr[t++] = arr[i++];
			else
				tmpArr[t++] = arr[j++];
		}
		while (i <= mid)
			tmpArr[t++] = arr[i++];
		
		while (j <= end)
			tmpArr[t++] = arr[j++];
		
		i = start;
		t = 0;
		while (i <= end) {
			if (++saveCnt == targetCnt) {
				savedNo = tmpArr[t];
				isFinished = true;
				return;
			}
			arr[i++] = tmpArr[t++];
			
		}
	}
}
