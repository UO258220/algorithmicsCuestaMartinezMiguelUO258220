package algstudent.s2;


/* This program can be used to sort n elements with 
 * a "bad" algorithm (quadratic). 
 * It is the DIRECT INSERTION */
public class Insertion extends Vector {	
	public Insertion(int nElements) {
		super(nElements);
	}

	@Override
	public void sort(){
		for (int i = 1 ; i < elements.length ; i++) {
			for (int j = i ; j > 0 ; j--) {
				if (elements[j] < elements[i]) {
					interchange(i, j);
				}
				else break;
			}
		}
	} 
	
	@Override
	public String getName() {
		return "Insertion";
	} 
} 
