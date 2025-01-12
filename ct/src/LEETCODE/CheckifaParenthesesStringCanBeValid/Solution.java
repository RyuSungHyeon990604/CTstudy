package LEETCODE.CheckifaParenthesesStringCanBeValid;

public class Solution {
    public boolean canBeValid(String s, String locked) {
        if((s.length()&1) == 1) return false;
        int open = 0;
        int unlock = 0;
        int n = s.length();
        char[] chars = s.toCharArray();
        for(int i=0; i<n; i++){
            if(locked.charAt(i) == '1'){
                if(chars[i] == '(') open++;
                else if(chars[i] == ')') open--;
            }else{
                unlock++;
            }
            if(open < 0){
                if(-open > unlock) return false;
                else unlock += open ;
                open = 0;
            }
        }
        open = 0;
        unlock = 0;
        for(int i=n-1; i>=0; i--){
            if(locked.charAt(i) == '1'){
                if(chars[i] == '(') open++;
                else if(chars[i] == ')') open--;
            }else{
                unlock++;
            }
            if(open > 0){
                if(open > unlock) return false;
                else unlock -= open ;
                open = 0;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution s= new Solution();
        s.canBeValid("))()))"
                ,"010100");
    }
}
