

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 트럭의 순서는 바꿀 수 없으며 -> 큐
 * 트럭 큐, 다리에 올라와 있는 트럭들의 큐
 * 
 * 시간은 똑같이 흐르므로 시간을 하나씩 증가시키면서 조건에 따라 반복하는 로직이 필요..
 * 다리의 길이만큼 큐의 길이를 유지하고 처음 무게는 전부 0으로 초기화  
 * 트럭을 넣을 수 있으면 넣고 못넣으면 대신 0을 넣어서 순서대로 빼고 시간 1씩 증가
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]); // 트럭 수
		int w = Integer.parseInt(input[1]); // 다리의 길이
		int l = Integer.parseInt(input[2]); // 최대 하중

		input = br.readLine().split(" ");
		Queue<Integer> trucks = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			trucks.offer(Integer.parseInt(input[i]));
		}

		int time = 0;
		int weightSum = 0;
		Queue<Integer> bridge = new LinkedList<>(); // 현재 다리 위에 있는 트럭들의 각 무게

		for (int i = 0; i < w; i++) {
			bridge.offer(0); // 다리의 길이만큼 큐를 0으로 채우기
		}

		while (!trucks.isEmpty() || weightSum > 0) {
			time++;

			// 다리에서 트럭을 한 대 내린다
			weightSum -= bridge.poll();

			if (!trucks.isEmpty()) {
				int nextTruck = trucks.peek();
				if (weightSum + nextTruck <= l) {
					trucks.poll();
					bridge.offer(nextTruck);
					weightSum += nextTruck;
				} else {
					bridge.offer(0); // 트럭을 올리지 못하면 0채워서 길이 유지
				}
			}
		}

		System.out.println(time);
	}
}
