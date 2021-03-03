package algstudent.s2;


/* This program can be used to sort n elements with 
 * the best algorithm of this lab. It is the QUICKSORT */
public class QuicksortCentralElement extends Vector {
	
	public QuicksortCentralElement(int nElements) {
		super(nElements);
	}
	
	private void quickSort(int left, int right) {
		int i = left;
		int j = right - 1;
		int pivot;

		if (left < right) {
			int center = (left + right) / 2;
			pivot = elements[center];
			interchange(right, center);

			while (true) {
				while (elements[i] <= pivot && i < right) {
					i++;
				}
				while (elements[j] >= pivot && j > left) {
					j--;
				}
				if (i < j) {
					interchange(i, j);
				}
				else {
					break;
				}
			}

			interchange(i, right);
			quickSort(left, i - 1);
			quickSort(i + 1, right);
		}
	}

	@Override
	public void sort() {
		quickSort(0, elements.length-1);		
	}
	
	@Override
	public String getName() {
		return "Quicksort - Central element";
	} 
} 
