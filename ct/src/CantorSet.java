import java.util.ArrayList;
import java.util.List;

public class CantorSet{
    public int solution(int n, long l, long r) {
        int answer = 0;
        if(n==0)
            return 1;
        double totalSize = Math.pow(5,n);
        for (long i = l; i <= r; i++) {
            int zoneNumber = getZoneNumber(totalSize, i);
            if(zoneNumber == 3)
                continue;
            else{
                double newSize = totalSize/5;
                long newI = (long) (newSize - (newSize*zoneNumber - i));
                zoneNumber = getZoneNumber(newSize,newI);
                while(newSize > 5){// newSize != 5 로 작성시 n=1일때 무한루프를 돔
                    if(zoneNumber == 3)
                        break;
                    else{
                        newSize = newSize/5;
                        newI = (long) (newSize - (newSize*zoneNumber - newI));
                        zoneNumber =  getZoneNumber(newSize,newI);
                    }
                }
                if(zoneNumber != 3)
                    answer++;
            }
        }

        return answer;
    }

    //11011
    public int getZoneNumber(double size,long l){
        if(l <= size / 5){//1
            return 1;
        }else if(l <=size / 5 *2){//1
            return 2;
        }else if(l <=size / 5 *3){//0
            return 3;
        }else if(l <=size / 5 *4){//1
            return 4;
        }else{//1
            return 5;
        }
    }



    public static void main(String[] args) {
        CantorSet set = new CantorSet();
        int solution = set.solution(1, 1,1);
        System.out.println(solution);
    }
}
