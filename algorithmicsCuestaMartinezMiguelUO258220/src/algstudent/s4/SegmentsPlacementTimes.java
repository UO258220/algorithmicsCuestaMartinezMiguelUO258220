package algstudent.s4;

import java.util.ArrayList;

public class SegmentsPlacementTimes {

	public static void main(String[] args) {

		int nTimes = Integer.parseInt(args[0]);

		for (int n = 100; n < Integer.MAX_VALUE; n *= 2) {

			ArrayList<Integer> random = new ArrayList<Integer>(n);

			random.add(n);

			for (int i = 0; i < n; i++) {
				random.add((int) (Math.random() * 100));
			}

			SegmentsPlacement sp = new SegmentsPlacement(random);

			long t1, t2;
			t1 = System.currentTimeMillis();
			for (int rep = 1; rep <= nTimes; rep++) {
				sp.run();
			}
			t2 = System.currentTimeMillis();

			System.err.println(String.format("SIZE = %d **  TIME = %d ms  NTIMES = %d", n, t2 - t1, nTimes));
		}
	}

}
