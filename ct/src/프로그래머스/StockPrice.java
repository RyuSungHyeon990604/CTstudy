public class StockPrice {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for(int i = 0 ; i < prices.length ; i++){
            int sec = 0;
            for(int j = i+1 ; j < prices.length ;j++ ){
                if(prices[i] > prices[j] ){
                    sec = 1;
                    break;
                }
                else
                    sec++;
            }
            answer[i] = sec;
        }

        return answer;
    }
}
