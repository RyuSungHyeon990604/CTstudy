public class MinOblong {
    public int solution(int[][] sizes) {
        int answer = 0;
        int x =0;
        int y= 0;
        for(int[] xy : sizes){
            int b=0,s=0;
           if(xy[0] >=  xy[1]){
               b=xy[0];
               s=xy[1];
           }else{
               s=xy[0];
               b=xy[1];
           }
           if(x <= b){
               x=b;
           }
           if(y <= s){
               y=s;
           }
        }
        return x*y;
    }
}
