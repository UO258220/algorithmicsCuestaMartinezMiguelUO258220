package algstudent.s32;

import java.util.List;

public class InversionsQuadratic {

	private List<Integer> ranking;
	private int inversions;

	public InversionsQuadratic(List<Integer> ranking) {
		this.ranking = ranking;
		this.inversions = 0;
	}

	public String start() {
		for (int i = 0; i < ranking.size(); i++) {
			for (int j = i + 1; j < ranking.size(); j++) {
				if (ranking.get(j) < ranking.get(i))
					inversions++;
			}
		} //O(n²)
		return Integer.toString(inversions);
	}

}
