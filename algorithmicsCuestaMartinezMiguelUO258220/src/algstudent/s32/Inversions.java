package algstudent.s32;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// a1
public class Inversions {

	private List<Integer> ranking;
	private int inversions;

	public Inversions(List<Integer> ranking) {
		this.ranking = ranking;
		this.inversions = 0;
	}

	public String start() {
		mergesort(0, ranking.size() - 1);
		return Integer.toString(inversions);
	}

	private void mergesort(int left, int right) {
		if (right > left) {
			int pivot = (left + right) / 2;
			mergesort(left, pivot);
			mergesort(pivot + 1, right);
			combine(left, pivot, pivot + 1, right);
		}
	}

	private void combine(int start1, int end1, int start2, int end2) {
		int size1 = end1 - start1 + 1;
		int size2 = end2 - start2 + 1;

		List<Integer> aux = new ArrayList<Integer>(size1 + size2);

		for (int i = 0; i < size1; i++) {
			aux.add(ranking.get(start1 + i));
		}
		for (int i = 0; i < size2; i++) {
			aux.add(ranking.get(start2 + i));
		}

		Collections.sort(aux);

		int pos = 0;
		for (Integer i : aux) {
			if (!ranking.get(start1 + pos).equals(i)) {
				ranking.set(start1 + pos, i);				
				inversions++;
			}
			pos++;
		}

	}

}
