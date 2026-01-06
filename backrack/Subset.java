package backrack;
import java.util.*;

// Solution class to generate all subsequences using recursion
class Subset {
    // Helper recursive method to generate subsequences
    private void helper(String s, int index, StringBuilder current, List<String> result) {
        if(index == s.length()){
            result.add(current.toString());

            return;
        }
        // Include the current character
        current.append(s.charAt(index));
        helper(s, index + 1, current, result);
        current.deleteCharAt(current.length() - 1);
        helper(s, index + 1, current, result);
    }

    // Method to return all subsequences of string s
    public List<String> getSubsequences(String s) {
        // List to store all subsequences
        List<String> result = new ArrayList<>();

        // StringBuilder to store current subsequence
        StringBuilder current = new StringBuilder();

        // Start recursion from index 0
        helper(s, 0, current, result);

        // Return list of subsequences
        return result;
    }

    public static void main(String[] args) {
        // Input string
        String s = "abc";

        // Create Solution object
        Subset sol = new Subset();

        // Get all subsequences
        List<String> subsequences = sol.getSubsequences(s);

        // Print all subsequences
        for (String subseq : subsequences) {
            System.out.println("\"" + subseq + "\"");
        }
    }

}

