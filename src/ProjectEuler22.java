import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ProjectEuler22 {
	public static void main(String[] args) {
		new ProjectEuler22();
	}

	ProjectEuler22() {
		String csvFile = "names.txt";
		BufferedReader br = null;
		String line;
		String cvsSplitBy = ",";
		List<String> names = new ArrayList<>();
		int numNames = 1;
		double total = 0;

		try {
			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {
				String[] namesBin = line.split(cvsSplitBy);
				names.addAll(Arrays.asList(namesBin));
			}

			Collections.sort(names);

			for (String s : names) {
				int value = 0;
				for (int i = 1; i < s.length() - 1; i++) {
					value += Character.getNumericValue(s.charAt(i)) - 9;
				}
				total += value * numNames++;
			}

			System.out.printf("%.2f", total);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
