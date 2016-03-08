package com.nadeem.app.dsa.algo;

public class MELevenshteinWordDistanceCalculator {
	
	public static final MELevenshteinWordDistanceCalculator DEFAULT = new MELevenshteinWordDistanceCalculator(1, 1, 1);

	private final int substitutionCost;
	private final int deletionCost;
	private final int insertionCost;

	public MELevenshteinWordDistanceCalculator(int costOfSubstitution, int costOfDeletion, int costOfInsertion) {
		substitutionCost = costOfSubstitution;
		deletionCost = costOfDeletion;
		insertionCost = costOfInsertion;
	}
	
	/***
	 * Algo 
	 * 1 Set n to be the length of s. ("GUMBO")
			Set m to be the length of t. ("GAMBOL")
			If n = 0, return m and exit.
			If m = 0, return n and exit.
			Construct two vectors, v0[m+1] and v1[m+1], containing 0..m elements.
	2	Initialize v0 to 0..m.
	3	Examine each character of s (i from 1 to n).
	4	Examine each character of t (j from 1 to m).
	5	If s[i] equals t[j], the cost is 0.
	If s[i] is not equal to t[j], the cost is 1.
	6	Set cell v1[j] equal to the minimum of:
	a. The cell immediately above plus 1: v1[j-1] + 1.
	b. The cell immediately to the left plus 1: v0[j] + 1.
	c. The cell diagonally above and to the left plus the cost: v0[j-1] + cost.
	7	After the iteration steps (3, 4, 5, 6) are complete, the distance is found in the cell v1[m].
	 * 
	 * 
	 * 
	 * Refer http://www.codeproject.com/Articles/13525/Fast-memory-efficient-Levenshtein-algorithm
	 * https://en.wikibooks.org/wiki/Algorithm_Implementation/Strings/Levenshtein_distance#Java
	 * https://en.wikipedia.org/wiki/Levenshtein_distance
	 */
	public int calculate(CharSequence s, CharSequence t) {                          
	    int sourceLength = s.length() + 1;                                                     
	    int targetLength = t.length() + 1;                                                     
	                                                                                    
	    // the array of distances                                                       
	    int[] cost = new int[sourceLength]; // v0                                                     
	    int[] newcost = new int[sourceLength];// v1                                                  
	                                                                                    
	    // initialize cost (the previous row of distances)
	    // this row is A[0][i]: edit distance for an empty s
	    // the distance is just the number of characters to delete from t
	    for (int i = 0; i < sourceLength; i++) cost[i] = i;                                     
	                                                                                    
	    // dynamically computing the array of distances                                  
	                                                                                    
	    // transformation cost for each letter in s1                                    
	    for (int j = 1; j < targetLength; j++) {   
	    	
	    	// calculate v1 (current row distances) from the previous row v0
	        // first element of v1 is A[i+1][0]
	        //   edit distance is delete (i+1) chars from s to match empty t
	        newcost[0] = j;                                                             
	                                                                                    
	        // transformation cost for each letter in s0                                
	        for(int i = 1; i < sourceLength; i++) {                                             
	            // matching current letters in both strings                             
	            // keep minimum cost 
	            newcost[i] = minimumCost(s, t, cost, newcost, j, i);
	        }                                                                           
	                                                                                    
	        // swap cost/newcost arrays                                                 
	        int[] swap = cost; cost = newcost; newcost = swap;                          
	    }                                                                               
	                                                                                    
	    // the distance is the cost for transforming all letters in both strings        
	    return cost[sourceLength - 1];                                                          
	}

	private int minimumCost(CharSequence s, CharSequence t, int[] cost, int[] newcost, int j, int i) {
		return min(insertionCost(cost, i), deletionCost(newcost, i), substitutionCost(s, t, cost, j, i));
	}

	private int deletionCost(int[] newcost, int i) {
		return newcost[i - 1] + deletionCost;
	}

	private int insertionCost(int[] cost, int i) {
		return cost[i] + insertionCost;
	}

	private int substitutionCost(CharSequence s, CharSequence t, int[] cost, int j, int i) {
		int appliedCost = (s.charAt(i - 1) == t.charAt(j - 1)) ? 0 : substitutionCost;             
		                                                                        
		// computing cost for each transformation                               
		int cost_replace = cost[i - 1] + appliedCost;
		return cost_replace;
	}

	private static int min(int a, int b, int c) {
		return Math.min(a, Math.min(b, c));
	}
}
