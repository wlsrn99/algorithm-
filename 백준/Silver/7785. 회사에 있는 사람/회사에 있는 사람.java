import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		Set<String> set = new HashSet<>();

		for (int i = 1; i <= n; i++) {
			String[] name = br.readLine().split(" ");

			if (set.contains(name[0])) {
				set.remove(name[0]);
			} else {
				set.add(name[0]);
			}
		}

		List<String> workingPerson = set.stream()
			.sorted(Collections.reverseOrder())
			.collect(Collectors.toList());

		StringBuilder sb = new StringBuilder();
		for (String person : workingPerson) {
			sb.append(person).append("\n");
		}
		System.out.println(sb);
	}
}
