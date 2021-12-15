package LeetCode.String.ValidPalindrome;

public class Main {

    public static void main(String[] args) {


    }

    public static boolean isPalindrome(String s) {

        String newString = s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");

        int left = 0, right = newString.length() - 1;

        while(left < right){
            if(newString.charAt(left) != newString.charAt(right)){
                return false;
            }else {
                left++;
                right--;
            }
        }

        return true;
    }

}
