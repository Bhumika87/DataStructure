package String;

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

    //125. Valid Palindrome
    //Input: s = "A man, a plan, a canal: Panama"
    //Output: true
    //Explanation: "amanaplanacanalpanama" is a palindrome.
    public boolean isPalindromeString(String s) {
        int left =0;
        int right = s.length()-1;
        char head,tail;
        while(left<right){
            head = s.charAt(left);
            tail = s.charAt(right);
            if(!Character.isLetterOrDigit(head)) left++;
            else if (!Character.isLetterOrDigit(tail)) right--;
            else if(Character.toLowerCase(head)!=Character.toLowerCase(tail))return false;
            else {
                left++;
                right--;
            }
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
