public class MinimumNumberofSwapstoMaketheStringBalanced {
    public int minSwaps(String s) {
        int ans = 0;
        int l = 0, r = s.length() - 1;
        StringBuilder sb = new StringBuilder(s);
        int chkL = 0;
        int chkR = 0;
        while (l < r ) { //]]][[[
            while (l <r){
                if(sb.charAt(l) == '['){
                    chkL++;
                }else{
                    chkL--;
                }
                if(chkL < 0)
                    break;
                l++;
            }
            while (l <r){
                if(sb.charAt(r) == ']'){
                    chkR++;
                }else{
                    chkR--;
                }
                if(chkR < 0)
                    break;
                r--;
            }
            if(sb.charAt(l) == ']' && sb.charAt(r) == '[') {
                ans++;
                chkR = 1; // chkR, chkL 를 1로 바꾼다는 것 : ][ 을 [] 으로 바꿈으로써 -1 -1 ==> 1 1로 바꾼다는것을 뜻함
                chkL = 1;
                l++;
                r--;
            }
        }

        return ans;
    }

    public int minSwaps2(String s) {
        int ans = 0;
        int chk = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[') {
                chk++;
            }else
                chk--;
            if(chk < 0){
                ans++;
                chk = 1;
            }

        }



        return ans;
    }



    public static void main(String[] args) {
        MinimumNumberofSwapstoMaketheStringBalanced obj = new MinimumNumberofSwapstoMaketheStringBalanced();
        System.out.println(obj.minSwaps("]]][[["));
    }

}
