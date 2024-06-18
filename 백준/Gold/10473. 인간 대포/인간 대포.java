

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static class Coordinate {
		double x, y;

		Coordinate(double x, double y) {
			this.x = x;
			this.y = y;
		}

		double distance(Coordinate p) {
			return Math.sqrt(Math.pow(this.x - p.x, 2) + Math.pow(this.y - p.y, 2));
		}
	}

	static class Edge {
		int to;
		double cost;

		Edge(int to, double cost) {
			this.to = to;
			this.cost = cost;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 시작점과 끝점 입력 받기
		double[] startCoords = Arrays.stream(br.readLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
		double[] endCoords = Arrays.stream(br.readLine().split(" ")).mapToDouble(Double::parseDouble).toArray();

		Coordinate start = new Coordinate(startCoords[0], startCoords[1]);
		Coordinate end = new Coordinate(endCoords[0], endCoords[1]);

		// 대포의 수 입력 받기
		int n = Integer.parseInt(br.readLine());
		Coordinate[] cannons = new Coordinate[n];
		for (int i = 0; i < n; i++) {
			double[] cannonCoords = Arrays.stream(br.readLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
			cannons[i] = new Coordinate(cannonCoords[0], cannonCoords[1]);
		}
		
		List<List<Edge>> graph = new ArrayList<>();
		for (int i = 0; i < n + 2; i++) {
			graph.add(new ArrayList<>());
		}

		// 시작점에서 대포까지의 거리
		for (int i = 0; i < n; i++) {
			double dist = start.distance(cannons[i]);
			graph.get(0).add(new Edge(i + 1, dist / 5.0));
		}

		// 대포에서 도착점까지의 거리
		for (int i = 0; i < n; i++) {
			double dist = cannons[i].distance(end);
			graph.get(i + 1).add(new Edge(n + 1, Math.abs(dist - 50) / 5.0 + 2.0));
		}

		// 대포 간 거리
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i != j) {
					double dist = cannons[i].distance(cannons[j]);
					graph.get(i + 1).add(new Edge(j + 1, Math.abs(dist - 50) / 5.0 + 2.0));
				}
			}
		}

		// 시작점에서 도착점까지의 거리
		graph.get(0).add(new Edge(n + 1, start.distance(end) / 5.0));
		
		double[] dist = new double[n + 2];
		Arrays.fill(dist, Double.MAX_VALUE);
		dist[0] = 0.0;

		PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingDouble(e -> e.cost));
		pq.add(new Edge(0, 0.0));

		while (!pq.isEmpty()) {
			Edge cur = pq.poll();
			int u = cur.to;

			if (cur.cost > dist[u]) continue;

			for (Edge next : graph.get(u)) {
				int v = next.to;
				double newDist = dist[u] + next.cost;

				if (newDist < dist[v]) {
					dist[v] = newDist;
					pq.add(new Edge(v, newDist));
				}
			}
		}

		System.out.printf("%.6f\n", dist[n + 1]);
	}
}
