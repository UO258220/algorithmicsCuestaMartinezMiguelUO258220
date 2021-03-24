package algstudent.s4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.stream.Stream;

public class SegmentsPlacement {

	private ArrayList<Integer> segments = new ArrayList<>();
	private LinkedList<Integer> copy;

	public static void main(String[] args) {
		SegmentsPlacement sp = new SegmentsPlacement(args[0]);
		sp.run();
	}

	public void run() {
//		greedy1();
//		greedy2();
		greedy3();
	}

	public SegmentsPlacement(String fileName) {
		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
			stream.forEach(values -> {
				segments.add(Integer.parseInt(values));
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public SegmentsPlacement(ArrayList<Integer> values) {
		this.segments = values;
	}

	private void greedy1() {
		this.copy = new LinkedList<>(segments); // O(n)
		System.out.println("Solving game of size " + copy.poll() + " with Greedy 1");
		System.out.println("Cost of greedy 1 = " + solve1(0) + "pufosos");
	}

	private double solve1(int currentPoint) {
		if (copy.size() > 0) {
			int newPoint = currentPoint + copy.poll();
			System.out.print("(" + currentPoint + " to " + newPoint + "), ");
			double addedPufosos = (double) (currentPoint + newPoint) / 2;
			System.out.println("midpoint = " + addedPufosos);
			return addedPufosos + solve1(newPoint);
		}
		return 0;
	}

	private void greedy2() {
		this.copy = new LinkedList<>(segments); // O(n)
		System.out.println("Solving game of size " + copy.poll() + " with Greedy 2");
		System.out.println("Cost of greedy 2 = " + solve2(0) + "pufosos");
	}

	private double solve2(int currentPoint) {
		if (copy.size() > 0) {
			int newPoint = currentPoint + findMax(copy);
			System.out.print("(" + currentPoint + " to " + newPoint + "), ");
			double addedPufosos = (double) (currentPoint + newPoint) / 2;
			System.out.println("midpoint = " + addedPufosos);
			return addedPufosos + solve2(newPoint);
		}
		return 0;
	}

	private int findMax(LinkedList<Integer> list) {
		return list.remove(list.indexOf(Collections.max(list)));
	}

	private void greedy3() {
		this.copy = new LinkedList<>(segments); // O(n)
//		System.out.println("Solving game of size " + copy.poll() + " with Greedy 3");
//		System.out.println("Cost of greedy 3 = " + solve3(0) + "pufosos");
	}

	private double solve3(int currentPoint) {
		if (copy.size() > 0) {
			int newPoint = currentPoint + findMin(copy);
//			System.out.print("(" + currentPoint + " to " + newPoint + "), ");
			double addedPufosos = (double) (currentPoint + newPoint) / 2;
//			System.out.println("midpoint = " + addedPufosos);
			return addedPufosos + solve3(newPoint);
		}
		return 0;
	}

	private int findMin(LinkedList<Integer> list) {
		return list.remove(list.indexOf(Collections.min(list)));
	}

}
