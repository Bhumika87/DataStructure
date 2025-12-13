package Graph.String;

public class palindrome {
    public boolean isPalindrome(String s){
        int left =0;
        int right = s.length()-1;

        while(left<right){
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);
        
            if(leftChar != rightChar){
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        String str = "abcdba";
        palindrome obj = new palindrome();
        boolean result = obj.isPalindrome(str);
        System.out.println(result);
    }
}
