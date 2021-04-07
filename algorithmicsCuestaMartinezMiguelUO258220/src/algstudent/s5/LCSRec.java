package algstudent.s5;

import java.util.Random;

public class LCSRec {
	
	/**
	 * Generates a random sequence
	 * @param n sequence size
	 * @return random sequence, sting of characters
	 */
	public String genRandomSeq(int n){
		char[] dna_elements = {'A', 'C', 'G', 'T'};
		String result = "";
		Random r = new Random();
		for (int i=0; i<n; i++)
			result += dna_elements[r.nextInt(4)];
		return result;
	}
	
	/**
	 * Find a MSC directly by a recursive approach 
	 */
	public String findLongestSubseq(String s1, String s2){
		// TODO: find directly a MSC (without a table) of two input sequences using recursion
		String msc = "";
		if (s1.charAt(0) == s2.charAt(0)) {
			msc += s1.charAt(0);
			if (s1.length() > 1 && s2.length() > 1) {
				msc += findLongestSubseq(s1.substring(1), s2.substring(1));
			}
		}
		else {
			
		}
		return msc;
	}
	
	/**
	 * Get the index for the longest of three strings
	 * @param l1 e.g. input L1=MSC(S1�, S2). S1� S1 without its last char
	 * @param l2 e.g. input L1=MSC(S1, S2'). S2' S2 without its last char
	 * @param l3 e.g. input L3=MSC(S1�, S2�) or L3+1 when both current chars are equal
	 * @return index of the longest string
	 */
	@SuppressWarnings("unused")
	private int longest(String l1, String l2, String l3) {
		return l1.length() > l2.length() ? (l1.length() > l3.length() ? 1 : 3) : (l2.length() > l3.length() ? 2 : 3);
	}

}
