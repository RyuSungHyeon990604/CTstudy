public class MinimumAddtoMakeParenthesesValid {
    public int minAddToMakeValid(String s) {
        int ans = 0;
        int chk =0 ;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                chk++;
            }else{
                chk--;
            }
            if (chk < 0){ // ) 가 남는다
                ans++; // ( 를 추가해준다
                chk =0; // () 가 됐으므로 0으로 초기화
            }
        }
        ans += chk; // 최종적 chk의 값은 ( 의갯수 즉 추가해야하는 ) 의 갯수와 같다
        return ans;
    }
}
