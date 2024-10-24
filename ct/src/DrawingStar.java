import java.util.*;

public class DrawingStar {
    int minX = Integer.MAX_VALUE;
    int maxX = Integer.MIN_VALUE;
    int minY = Integer.MAX_VALUE;
    int maxY = Integer.MIN_VALUE;
    public String[] solution(int[][] line) {
        Map<Integer,Set<Integer>> map = new HashMap<>();
        comb(line,0,map,null,null);
        String[] res = new String[maxY-minY+1];
        int index = 0;
        for (int y = maxY ; y >= minY ; y--) {
            StringBuilder sb = new StringBuilder();
            for (int x = minX; x <= maxX; x++) {
                if(map.containsKey(x)) {
                    if (map.get(x).contains(y)) {
                        sb.append('*');
                    }else{
                        sb.append('.');
                    }
                }else{
                    sb.append('.');
                }
            }
            res[index++] = sb.toString();
        }

        return res;
    }

    public void comb(int[][] line, int start, Map<Integer, Set<Integer>> map, int[] line1, int[] line2) {
        if(line1 != null && line2 != null) {
            //if(isParallel(line1,line2)) return;
            int[] integerMeet = getIntegerMeet(line1, line2);
            if(integerMeet == null) return;
            if(map.containsKey(integerMeet[0])) {
                map.get(integerMeet[0]).add(integerMeet[1]);
            }else{
                Set<Integer> set = new HashSet<>();
                set.add(integerMeet[1]);
                map.put(integerMeet[0],set);
            }
            minX = Math.min(minX,integerMeet[0]);
            maxX = Math.max(maxX,integerMeet[0]);
            minY = Math.min(minY,integerMeet[1]);
            maxY = Math.max(maxY,integerMeet[1]);
            return;
        }
        for (int i = start; i < line.length; i++) {
           if(line1 == null) {
               comb(line,i+1,map,line[i],line2);
           }else if(line2 == null) {
               comb(line,i+1,map,line1,line[i]);
           }
        }
    }

//    public boolean isParallel(int[] line1, int[] line2) {
//       return line1[0] * line2[1] - line1[1] * line2[0] == 0;
//    }
    //Ax + By + E = 0
    //Cx + Dy + F = 0

    public int[] getIntegerMeet(int[] line1, int[] line2) {
        // 분모: 두 직선의 교차 여부를 확인하기 위한 계산
        long denominator = (long)line1[0] * line2[1] - (long)line1[1] * line2[0];

        if (denominator == 0) {
            // 평행하면 교점이 없음
            return null;
        }

        // x 좌표 계산
        long numeratorX = (long)line1[1] * line2[2] - (long)line1[2] * line2[1];
        if (numeratorX % denominator != 0) {
            // x 좌표가 정수가 아닐 경우 null 리턴
            return null;
        }
        int x = (int) (numeratorX / denominator);

        // y 좌표 계산
        long numeratorY = (long)line1[2] * line2[0] - (long)line1[0] * line2[2];
        if (numeratorY % denominator != 0) {
            // y 좌표가 정수가 아닐 경우 null 리턴
            return null;
        }
        int y = (int) (numeratorY / denominator);

        return new int[]{x, y};  // 정수 좌표 리턴
    }

    public static void main(String[] args) {
        DrawingStar d = new DrawingStar();
        d.solution(new int[][]{{0, 1, -1}, {1, 0, -1}, {1, 0, 1}});
    }
}
