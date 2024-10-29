import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

class Qubic {
    int weight;
    int price;

    public Qubic(int weight, int price) {
        this.weight = weight;
        this.price = price;
    }
}

public class BOJ_1202_Theif {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        PriorityQueue<Qubic> pq = new PriorityQueue<>((a, b) -> b.price - a.price);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            pq.add(new Qubic(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        TreeMap<Integer, Integer> weightMap = new TreeMap<>();
        for (int i = 0; i < K; i++) {
            int weight = Integer.parseInt(br.readLine());
            weightMap.put(weight, weightMap.getOrDefault(weight, 0) + 1);
        }

        long ans = 0L;

        while (!pq.isEmpty()) {
            Qubic qubic = pq.poll();

            // 무게일치
            if (weightMap.containsKey(qubic.weight) && weightMap.get(qubic.weight) > 0) {
                weightMap.put(qubic.weight, weightMap.get(qubic.weight) - 1);
                ans += qubic.price;
            } else {
                // 일치안하면 가능한 가방중 제일작은거
                Integer availableWeight = weightMap.ceilingKey(qubic.weight);
                if (availableWeight != null && weightMap.get(availableWeight) > 0) {
                    weightMap.put(availableWeight, weightMap.get(availableWeight) - 1);
                    ans += qubic.price;
                }
            }
        }

        System.out.println(ans);
    }
}
