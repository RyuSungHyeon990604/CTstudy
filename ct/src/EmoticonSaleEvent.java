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
            int[] tmp =new int[]{0,0};
            for (int i = 0 ;i<users.length;i++){
                int total = 0;
                for (int[] p : price) {
                    if(p[0] <= 100 - users[i][0]){
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
            p(emoticons,rate,price,depth+1,users);
        }
    }

    public static void main(String[] args) {
        EmoticonSaleEvent e = new EmoticonSaleEvent();
        e.solution(new int[][]{{40, 10000},{25,10000}}, new int[]{7000,9000});
    }

}
