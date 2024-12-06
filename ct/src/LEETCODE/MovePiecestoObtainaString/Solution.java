package LEETCODE.MovePiecestoObtainaString;

public class Solution {
    public boolean canChange(String start, String target) {
        char[] starts = start.toCharArray();
        char[] targets = target.toCharArray();
        //target에서 나온 L을 start에서 처리해야함
        //start에서 나온 R을 target에서 처리해야함
        int l = 0;
        int r = 0;
        for (int i = 0; i < starts.length; i++) {
            if(starts[i] =='L'){
                l--;
            }else if(starts[i] =='R'){
                r++;
                //l!=0 이라는것은 i위치 이전에 target에서 L이 나왔음을 뜻함 즉, start에서 L이 나오기도전에 R이 나온상태
                // tartget = 'L__R" start = "_R_L"
                if(l!=0) return false;
            }
            if(targets[i] =='L'){
                l++;
                //r!=0 이라는것은 i위치 이전에 start에서 R이 나왔음을 뜻함 즉, target에서 R이 나오기도전에 L이나온상태
                //target = "_L_R" start = "R_L_"
                if(r!=0) return false;
            }else if(targets[i] =='R'){
                r--;
            }

            //start에서 L이 먼저 나오거나, target에서 R이 먼저 나온경우
            if(l<0 || r<0) return false;
        }
        return l == 0 && r == 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        boolean b = s.canChange("R__L", "_LR_");
        System.out.println("b = " + b);
    }
}
