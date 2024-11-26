public class FindChampionII {
    public int findChampion(int n, int[][] edges) {
        int[] loseCnt = new int[n];
        //챔피언은 한번도 지지않으므로 진 횟수를 카운팅
        for(int[] edge : edges){
            loseCnt[edge[1]]++;
        }
        int champion = -1;
        int championCnt = 0;
        for(int i = 0 ;i < n ;i++){
            if(loseCnt[i] == 0){
                championCnt++;
                champion = i;
            }
        }
        // 챔피언인 사람이 여러명이 가능할경우 -1
        return championCnt > 1 ? -1 : champion;
    }
}
