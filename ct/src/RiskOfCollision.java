import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RiskOfCollision {
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        Map<Integer,int[]> pointMap = new HashMap<>();
        Map<Integer,int[]> routeMap = new HashMap<>();// 로봇의 현재위치
        for (int i = 0; i < points.length; i++) {
            pointMap.put(i+1,points[i]);
        }
        for (int i = 0; i < routes.length; i++) {
            int[] t = new int[]{pointMap.get(routes[i][0])[0], pointMap.get(routes[i][0])[1],1};
            routeMap.put(i+1,t);
        }
        //이동 {r,c} 무조건 r을 맞춘뒤에 c를 맟춘다
        int countExit = routes.length;
        while(countExit!=0) {
            answer+=getCollisionCount(routeMap);
            for (int robot : routeMap.keySet()) {
                int[] route = routeMap.get(robot);
                if(route[2]==-1)
                    continue;
                int[] targetPoint = pointMap.get(routes[robot-1][route[2]]);
                if(route[0] == targetPoint[0] && route[1] == targetPoint[1]) {
                    if(routes[robot-1].length-1>route[2]) {//다음 목표 포인트가 존재한다면
                        route[2]++; //다음 목표목적지 설정
                        targetPoint = pointMap.get(routes[robot-1][route[2]]);// targetPoint 갱신
                    }else{
                        route[2] = -1;//다음목표가없다면 물류센터를 벗어난다
                        countExit-=1;
                        continue;
                    }
                }
                if (route[0] == targetPoint[0] ) {//r 이 같다면
                    if(route[1] > targetPoint[1]) {
                        route[1]--;
                    } else if(route[1] < targetPoint[1]) {
                        route[1]++;
                    }
                }else{
                    if(route[0] > targetPoint[0]) {
                        route[0]--;
                    } else if(route[0] < targetPoint[0]) {
                        route[0]++;
                    }
                }
                routeMap.put(robot,route);

            }
        }
        return answer;
    }

    public int getCollisionCount(Map<Integer,int[]> routeMap){
        Map<String,Integer> map= new HashMap<>();
        for (int[] route : routeMap.values()) {
            if(route[2]==-1)
                continue;
            StringBuffer sb = new StringBuffer(route[0]+","+route[1]);
            map.put(sb.toString(),map.getOrDefault(sb.toString(),0)+1);
        }
        int res = 0;
        for (int c : map.values()) {
            if( c> 1)
                res+=1;
        }
        return res;
    }

    public static void main(String[] args) {
        RiskOfCollision r = new RiskOfCollision();
        r.solution(new int[][]{{2, 2}, {2, 3}, {2, 7}, {6, 6}, {5, 2}},new int[][]{{2, 3, 4, 5}, {1, 3, 4, 5}});
    }
}
