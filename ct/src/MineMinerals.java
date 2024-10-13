import java.util.HashMap;
import java.util.Map;

public class MineMinerals {
    int answer = Integer.MAX_VALUE;
    public int solution(int[] picks, String[] minerals) {
        //picks는 [dia, iron, stone]
        Map<String,Integer> map =new HashMap<>();
        map.put("diamond",0);
        map.put("iron",1);
        map.put("stone",2);
        int totalPicks=0;
        for(int i=0;i<picks.length;i++){
            totalPicks+=picks[i];
        }
        mine(picks,minerals,map,0,0,totalPicks);
        return answer;
    }

    public void mine(int[] picks, String[] minerals,Map<String,Integer> map,int fatigueSum,int targetMineral,int totalPicks){
        if(fatigueSum > answer){//조기 종료 추가
            return;
        }
        if(targetMineral >= minerals.length || targetMineral == totalPicks * 5){
            answer = Math.min(answer,fatigueSum);
            return;
        }
        for (int i = 0 ; i < picks.length ; i++){
            if(picks[i] >0){
                picks[i]--;
                int tmp = fatigueSum;
                for (int t  = targetMineral; t < targetMineral+5;t++){
                    if(t<minerals.length){
                        int  fatigueIndex = map.get(minerals[t]);
                        //Math.pow 는 성능상 비용이 크다
                        //tmp+=Math.pow(5,i <= fatigueIndex ? 0 : i-fatigueIndex);

                        if(i <= fatigueIndex ){
                            tmp += 1;
                        }else if(i == 1){
                            if(fatigueIndex == 0){
                                tmp += 5;
                            }
                        }else if(i == 2){
                            if(fatigueIndex == 0){
                                tmp += 25;
                            }
                            if(fatigueIndex == 1){
                                tmp += 5;
                            }
                        }
                    }else{
                        break;
                    }
                }

                mine(picks, minerals,map,tmp,targetMineral+5,totalPicks);
                picks[i]++;
            }
        }
    }

    public static void main(String[] args) {
        MineMinerals m = new MineMinerals();
        //picks는 [dia, iron, stone]
        m.solution(new int[]{1, 0, 1},new String[]{"iron", "iron", "iron", "iron", "diamond", "diamond", "diamond"});
    }
}
