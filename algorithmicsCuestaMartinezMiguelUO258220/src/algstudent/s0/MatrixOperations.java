package algstudent.s0;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MatrixOperations {

	int[][] matrix;

	public MatrixOperations(int n) {
		matrix = new int[n][n];
		Random rand = new Random();
		for (int i = 0; i < getSize(); i++) {
			for (int j = 0; j < getSize(); j++) {
				matrix[i][j] = rand.nextInt();
			}
		}
	}

	public MatrixOperations(String fileName) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
			for (String line : parse(matrix)) {
				bw.write(line);
			}
			bw.close();
		} catch (IOException e) {
			// Do nothing
		}
	}

	private List<String> parse(int[][] matrix) {
		List<String> result = new ArrayList<String>();
		result.add(String.valueOf(getSize()));
		String aux = "";
		for (int i = 0; i < getSize(); i++) {
			for (int j = 0; j < getSize(); j++) {
				aux += matrix[i][j] + " ";
			}
			result.add(aux);
		}
		return result;
	}

	public int getSize() {
		return matrix[0].length;
	}

	public void write() {
		for (String line : parse(matrix)) {
			System.out.println(line);
		}
	}

	public int sumDiagonal1() {
		int sum = 0;
		for (int i = 0; i < getSize(); i++) {
			sum += matrix[i][i];
		}
		return sum;
	}

	public int sumDiagonal2() {
		int sum = 0;
		int size = getSize();
		for (int i = 0; i < size; i++) {
			sum += matrix[i][size - (i + 1)];
		}
		return sum;
	}

	public void travelPath(int i, int j) {
		while (validPosition(i, j)) {
			switch (matrix[i][j]) {
			case 1:
				i--;
				break;
			case 2:
				j++;
				break;
			case 3:
				i++;
				break;
			case 4:
				j--;
				break;
			default:
				// Value out of range
				return;
			}
		}
	}

	private boolean validPosition(int i, int j) {
		return i >= 0 && i < getSize() && j >= 0 && j < getSize() && matrix[i][j] != -1;
	}

}