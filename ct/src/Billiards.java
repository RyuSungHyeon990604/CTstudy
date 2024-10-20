import java.util.Arrays;

public class Billiards {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        Arrays.fill(answer,2000000);
        for (int i = 0; i < answer.length; i++) {
            int targetX = balls[i][0];
            int targetY = balls[i][1];
            if(targetY == startY && targetX > startX){//1
                c(answer,i,1,startX,startY,targetX,targetY,m,n);
            }else if(targetY == startY && targetX < startX){//2
                c(answer,i,2,startX,startY,targetX,targetY,m,n);
            }
            else if(targetX == startX && targetY < startY){//3
                c(answer,i,3,startX,startY,targetX,targetY,m,n);
            }
            else if(targetX == startX && targetY > startY){//4
                c(answer,i,4,startX,startY,targetX,targetY,m,n);
            }else{
                c(answer,i,5,startX,startY,targetX,targetY,m,n);
            }
        }

        return answer;
    }
    public void c(int[] answer,int i ,int caseN,int startX,int startY,int targetX,int targetY,int m,int n){
        if(caseN != 1)  answer[i] = Math.min((int) Math.pow(m+m-targetX - startX,2) +(int) Math.pow(targetY - startY,2),answer[i]);
        if(caseN != 2)  answer[i] = Math.min((int) Math.pow(targetX + startX,2) +(int) Math.pow(targetY - startY,2),answer[i]);
        if(caseN != 3)  answer[i] = Math.min((int) Math.pow(targetY + startY,2) +(int) Math.pow(targetX - startX,2),answer[i]);
        if(caseN != 4)  answer[i] = Math.min((int) Math.pow(n+n-targetY - startY,2) +(int) Math.pow(targetX - startX,2),answer[i]);
    }

    public static void main(String[] args) {
        Billiards b = new Billiards();
        b.solution(10,10,3,7,new int[][]{{7,7},{2,7},{7,3}});
    }
}
