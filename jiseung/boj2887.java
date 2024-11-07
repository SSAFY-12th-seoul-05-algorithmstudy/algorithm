import java.util.*;
import java.io.*;

public class Main {
    
    static class Edge implements Comparable<Edge> {
        int to, weight;
        
        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
        
        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.weight, other.weight);
        }
    }
    
    static class Planet {
        int id, x, y, z;
        
        public Planet(int id, int x, int y, int z) {
            this.id = id;
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
    
    static int N;
	static Planet[] planets;
	static List<Edge>[] adjList;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        
        planets = new Planet[N];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            planets[i] = new Planet(i, x, y, z);
        }
        
        adjList = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			adjList[i] = new ArrayList<>();
		}
		// x기준 정렬 후 간선 연결
		Arrays.sort(planets, new Comparator<Planet>() {
			@Override
			public int compare(Planet p1, Planet p2) {
				return Integer.compare(p1.x, p2.x);
			}
		});
		for (int i = 0; i < N - 1; i++) {
			Planet p1 = planets[i];
			Planet p2 = planets[i + 1];
			int dist = Math.abs(p1.x - p2.x);
			adjList[p1.id].add(new Edge(p2.id, dist));
			adjList[p2.id].add(new Edge(p1.id, dist));
		}
		// y 정렬
		Arrays.sort(planets, new Comparator<Planet>() {
			@Override
			public int compare(Planet p1, Planet p2) {
				return Integer.compare(p1.y, p2.y);
			}
		});
		for (int i = 0; i < N - 1; i++) {
			Planet p1 = planets[i];
			Planet p2 = planets[i + 1];
			int dist = Math.abs(p1.y - p2.y);
			adjList[p1.id].add(new Edge(p2.id, dist));
			adjList[p2.id].add(new Edge(p1.id, dist));
		}

		// z기준 정렬 후 간선 연결
		Arrays.sort(planets, new Comparator<Planet>() {
			@Override
			public int compare(Planet p1, Planet p2) {
				return Integer.compare(p1.z, p2.z);
			}
		});
		for (int i = 0; i < N - 1; i++) {
			Planet p1 = planets[i];
			Planet p2 = planets[i + 1];
			int dist = Math.abs(p1.z - p2.z);
			adjList[p1.id].add(new Edge(p2.id, dist));
			adjList[p2.id].add(new Edge(p1.id, dist));
		}

		// prim
		boolean[] visited = new boolean[N];
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.addAll(adjList[0]);
		visited[0] = true;
		int pick = 0;
		long ans = 0;

		while (pick < N - 1) {
			Edge e = pq.poll();
			if (visited[e.to])
				continue;
			visited[e.to] = true;
			pick++;
			ans += e.weight;
			pq.addAll(adjList[e.to]);
		}
		System.out.println(ans);
    }
}
