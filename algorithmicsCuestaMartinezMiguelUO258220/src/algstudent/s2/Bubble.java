package algstudent.s2;

/* This program can be used to sort n elements with 
 * a "bad" algorithm (quadratic). 
 * It is the BUBBLE or DIRECT EXCHANGE */
public class Bubble extends Vector {
	public Bubble(int nElements) {
		super(nElements);
	}

	@Override
	public void sort() {
		for (int i = 0 ; i < elements.length; i++) {
			for (int j = elements.length - 1 ; j > i ; j--) {
				if (elements[i] > elements[j]) {
					interchange(i, j);
				}
			}
		}
	}  
	
	@Override
	public String getName() {
		return "Bubble";
	} 
} 

