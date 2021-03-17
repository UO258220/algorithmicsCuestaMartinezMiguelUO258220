package algstudent.s3;

/* Params: a=3;b=2;k=0
 * As a > 1, the complexity is O(a^(n div b))
 * Total complexity = O(3^(n/2))
 */
public class Subtraction4{
	public static long rec4(int n) {
		long cont = 0; // O(1)
		if (n<=0) 
			cont++;
		else {
			rec4(n-2);
			rec4(n-2);
			rec4(n-2);
			cont++;
		}
		return cont;   
	}
	
	public static void main(String arg []) {
		long t1,t2,cont=0;
		for (int n=1;n<=100;n++) {
			t1 = System.currentTimeMillis();
			cont=rec4(n);
			t2 = System.currentTimeMillis();
			
			System.out.println ("n="+n+ "**TIME="+(t2-t1)+"**cont="+cont);
		}  // for
	} // main
} //class