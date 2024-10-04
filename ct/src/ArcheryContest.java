public class ArcheryContest {
    int max = -1;
    int[] answer = {-1};
    public int[] solution(int n, int[] info) {

        combination(info,new int[11],n,0);

        return answer;
    }

    public void combination(int[] apeach,int[] lion, int remaind,int start){
        if(remaind < 0){
            return;
        }
        if(remaind == 0){
            int diff = getDiff(apeach,lion);
            if(diff == 0)
                return;
            if(max < diff){
                max = diff;
                answer = lion;
            }else if(max == diff){
                answer = chk(lion);
            }

            return;
        }
       for (int i = start ; i < 11 ; i++){
           if(i==10){
               lion[i] = remaind;
               remaind = 0;
               combination(apeach,lion.clone(),remaind,i+1);
           }else{
               lion[i] = apeach[i]+1;
               remaind -=(apeach[i]+1);
               combination(apeach,lion.clone(),remaind,i+1);
               remaind += (apeach[i]+1);
               lion[i] = 0;
           }
       }
    }

    public int[] chk(int[] lion){
        for(int i = lion.length-1 ; i >= 0 ; i--){
           if(answer[i] == lion[i]) continue;
           if(answer[i] < lion[i]) return lion;
           if(answer[i] > lion[i]) return answer;
        }
        return answer;
    }

    public int getDiff(int[] apeach,int[] lion){
        int a = 0;
        int l = 0;
        for (int i = 0; i < 11; i++) {
            if(apeach[i] ==0 && lion[i] ==0){
                continue;
            }
            if(apeach[i] >= lion[i])
                a+=(10-i);
            else
                l+=(10-i);
        }

        return l - a;
    }

    public static void main(String[] args) {
        ArcheryContest a = new ArcheryContest();
        a.solution(9, new int[]{0,0,1,2,0,1,1,1,1,1,1});
    }
}
