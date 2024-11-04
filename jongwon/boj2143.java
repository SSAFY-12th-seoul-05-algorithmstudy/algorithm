import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class boj2143 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long T = sc.nextLong();
		int n = sc.nextInt();
		Long[] A = new Long[n];
		for (int i = 0; i < n; i++) {
			A[i] = sc.nextLong();
		}
		int m = sc.nextInt();
		Long[] B = new Long[m];
		for (int i = 0; i < m; i++) {
			B[i] = sc.nextLong();
		}

		List<Long> aSum = new ArrayList<>();
		List<Long> bSum = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			aSum.add(A[i]);
			Long temp = A[i];
			for (int j = i+1; j < n; j++) {
				temp += A[j];
				aSum.add(temp);
			}
		}

		for (int i = 0; i < m; i++) {
			bSum.add(B[i]);
			Long temp = B[i];
			for (int j = i+1; j < m; j++) {
				temp += B[j];
				bSum.add(temp);
			}
		}

		Collections.sort(aSum);
		Collections.sort(bSum);

		int count = 0;
		int startPointer = 0;
		int endPointer = bSum.size() - 1;
		while (startPointer < aSum.size() && endPointer >= 0) {

			long sum = aSum.get(startPointer) + bSum.get(endPointer);
			if (sum == T) {
				long a = aSum.get(startPointer);
				long b = bSum.get(endPointer);
				//
				
				long cntA = 0;
				long cntB = 0;
				
				while (startPointer < aSum.size() && aSum.get(startPointer) == a) {
					cntA++;
					startPointer++;
				}
				
				while (endPointer >= 0 && bSum.get(endPointer) == b) {
					cntB++;
					endPointer--;
				}
				count += cntA * cntB;
			}

			else if (sum > T) {
				endPointer--;
			} else if (sum < T) {
				startPointer++;
			}
		}
		
		System.out.println(count);
	}
}
