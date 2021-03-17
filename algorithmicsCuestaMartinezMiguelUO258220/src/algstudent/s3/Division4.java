package algstudent.s3;

/* Params: a=4;b=4;k=2
 * As a < b^k, the complexity is O(n^k)
 * Total complexity = O(n^2)
 */
public class Division4 {
	public static long rec4 (int n) {
		long cont = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				cont++; //O(n²)
			}
		}
		if (n<=0) 
			cont++;
		else {    
			rec4(n/4);
			rec4(n/4); 
			rec4(n/4);
			rec4(n/4);
			cont++ ;
		}
		return cont;   
	}
	
	public static void main (String arg []) {
		 long t1,t2,cont = 0;	 
		 for (int n=1;n<=10000000;n*=2) {
			  t1 = System.currentTimeMillis ();			   
			  cont = rec4(n);
			  t2 = System.currentTimeMillis ();
			
			  System.out.println ("n="+n+ "**TIME="+(t2-t1)+"**cont="+cont);	
		 }  // for
	} // main
} //class