import java.util.*;

public class MinimumTotalDistanceTraveled {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory, Comparator.comparingInt(a -> a[0]));

        // 공장이 수용할수있는 로봇의 수  만큼 공장리스트생성
        List<Integer> factoryPositions = new ArrayList<>();
        for (int[] f : factory) {
            for (int i = 0; i < f[1]; i++) {
                factoryPositions.add(f[0]);
            }
        }

        int robotCount = robot.size();
        int factoryCount = factoryPositions.size();

        long[][] dp = new long[robotCount + 1][factoryCount + 1];

        //     공장1 공장2 공장3 공장4
        //로봇1                       1000000000000000
        //로봇2                       1000000000000000
        //로봇3                       1000000000000000
        //로봇4                       1000000000000000
        //이런 느낌으로 dp표가 만들어진다.
        for (int i = 0; i < robotCount; i++) {
            dp[i][factoryCount] = 1000000000000l;
        }


        for (int i = robotCount - 1; i >= 0; i--) {
            for (int j = factoryCount - 1; j >= 0; j--) {
                // 현재 로봇과 공장의 거리와 이전 로봇이 공장에 할당됐을때 의 거리의 누적값
                long assign =Math.abs(robot.get(i) - factoryPositions.get(j)) + dp[i + 1][j + 1];
                // 이전에 배치한 거리값
                long skip = dp[i][j + 1];
                //이전에 배치한값과 비교하여 더 짮은 거리를 선택
                dp[i][j] = Math.min(assign, skip);
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        MinimumTotalDistanceTraveled test = new MinimumTotalDistanceTraveled();
        List<Integer> robot = new ArrayList<>();
        robot.add(0);
        robot.add(4);
        robot.add(6);
        int[][] factory = new int[][]{{2, 2}, {6, 2}};
        test.minimumTotalDistance(robot, factory);
    }

}
