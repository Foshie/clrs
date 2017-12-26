package leetcode;

import java.util.HashSet;

/*
 * Given a string, find the length of the longest substring without repeating characters.

	Examples:

	Given "abcabcbb", the answer is "abc", which the length is 3.
	
	Given "bbbbb", the answer is "b", with the length of 1.
	
	Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstring {

	public int lengthOfLongestSubstring(String s) {
        String sub = "";
        for(int i = 0; i < s.length(); i++){
            HashSet<Character> chars = new HashSet<Character>();
            String temp = "";
            for(int j = i; j < s.length(); j++){
                if(chars.contains(s.charAt(j))){
                    //end of substring;
                    temp = s.substring(i, j);
                    break;
                }else {
                		chars.add(s.charAt(j));
                }
                
            }
            if(temp.equals("")){
                temp = s.substring(i);
            }
            if(temp.length() > sub.length()) {
                sub = temp;
            }   
            
        }
        return sub.length();
        
    }
}
