import java.util.*;

public class OilExtraction {
    public static int h = 2;
    //public static Map<Integer,Integer> m = new HashMap<Integer,Integer>();
    public static int[] m;
    // [0, 0, 0, 1, 1, 1, 0, 0]
    // [0, 0, 0, 0, 1, 1, 0, 0]
    // [1, 1, 0, 0, 0, 1, 1, 0]
    // [1, 1, 1, 0, 0, 0, 0, 0]
    // [1, 1, 1, 0, 0, 0, 1, 1]
    public int solution(int[][] land) {
        int answer = 0;
       // int[][] visit = new int[land.length][land[0].length];
        Set<Integer> s = new HashSet<Integer>();
        m = new int[land.length*land[0].length];
        m[0] = 0;

        //오일 범위 체크
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[i].length; j++) {
                if  (land[i][j] == 1 ) {
                    findland(i,j,land,h++);
                }
            }
        }

        //막대 꼳기
        for(int i = 0 ; i < land[0].length ; i++) {
            for (int j = 0; j < land.length; j++) {
                s.add(land[j][i]);
            }
            int sum = 0;
            for (Integer key : s) {
                //sum += m.get(key);
                sum += m[key];
            }
            s.clear();
            if(sum >=answer)
                answer = sum;
        }


        return answer;
    }



    public void findland(int x,int y,int[][] land,int count){
        if(x < 0 || x >= land.length )
            return;
        if(y < 0 || y >= land[0].length)
            return;
        if(land[x][y] == 0){
            return;
        }
        if(land[x][y] == 1){
            land[x][y] = count;
//            if(m.get(count) != null){
//                m.put(count,m.get(count)+1);
//            }else
//                m.put(count,1);
            m[count] = m[count] + 1;
            findland(x+1,y,land,count);
            findland(x-1,y,land,count);
            findland(x,y+1,land,count);
            findland(x,y-1,land,count);
        }
    }
}
