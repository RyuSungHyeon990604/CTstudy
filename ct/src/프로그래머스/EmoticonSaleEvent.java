public class EmoticonSaleEvent {
    int[] ans = new int[]{0,0};
    public int[] solution(int[][] users, int[] emoticons) {
        int[] rate = new int[]{90,80,70,60};
        int[][] price = new int[emoticons.length][2];
        p(emoticons,rate,price,0,users);


        return ans;
    }

    public void p(int[] emoticons,int[] rate,int[][] price,int depth,int[][] users){
        if(depth == emoticons.length){
            int[] tmp =new int[]{0,0};//이모티콘 매출과, 플러스가입자수를 담는 배열생성
            for (int i = 0 ;i<users.length;i++){// 각각의 사용자 순회
                int total = 0;
                for (int[] p : price) {
                    if(p[0] <= 100 - users[i][0]){//p[0] == 최종 할인비율(100-할인율)
                        //사용자가 원하는 할인율을 넘어선다며 구매한다.
                        total+=p[1];
                    }
                }
                if(total >= users[i][1]){
                    tmp[0]++;
                }else{
                    tmp[1] += total;
                }
            }
            if(tmp[0] > ans[0])
                ans = tmp;
            else if(tmp[0] == ans[0]){
                if(tmp[1] > ans[1])
                    ans = tmp;
            }
            return;
        }
        for (int i = 0 ;i<rate.length;i++){
            price[depth][0] = rate[i];
            price[depth][1] = emoticons[depth]*rate[i]/100;
            p(emoticons,rate,price,depth+1,users);//모든조합으로 이모티콘에 할인율를 재귀적으로 적용 price[i] = [할인율, 할인가]
        }
    }

    public static void main(String[] args) {
        EmoticonSaleEvent e = new EmoticonSaleEvent();
        e.solution(new int[][]{{40, 10000},{25,10000}}, new int[]{7000,9000});
    }

}
