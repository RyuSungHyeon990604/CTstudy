public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        int cx = 0;
        int n=x;
        if(x < 0){
            return false;
        }
        while(n > 0){
            int rem = n % 10;
            n /= 10;
            cx = cx * 10 + rem;
        }
        return x != cx;
    }
}
