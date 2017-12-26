package cracking;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Anagrams {

	/*
	 * Given two strings,  and , that may or may not be of the same length, 
	 * determine the minimum number of character deletions required to make  
	 * and  anagrams. Any characters can be deleted from either of the strings.
	 */

    public static int numberNeeded(String first, String second) {
    		int count = 0;
        int freq[] = new int[26];
        
        for (char c: first.toCharArray()) {
        		freq[c - 'a']++;
        }
        for (char c: second.toCharArray()) {
	    		freq[c - 'a']--;
	    }
        for(int i : freq) {
        		count+= Math.abs(i);
        }
        return count;
        
    }
  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
        
        in.close();
        
    }
}
