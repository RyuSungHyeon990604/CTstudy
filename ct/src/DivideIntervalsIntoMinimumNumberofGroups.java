import java.util.Arrays;

public class DivideIntervalsIntoMinimumNumberofGroups {
    public int minGroups(int[][] intervals) {
        int n = intervals.length;
        int[] starts = new int[n];
        int[] ends = new int[n];

        // 시작점과 끝점을 각각 따로 배열에 저장
        for (int i = 0; i < n; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }

        // 시작점과 끝점을 각각 정렬
        //starts 와 end 가 꼭 intervals과 같은 쌍을 이룰 필요가없다
        //why? 이 문제는 겹치는 구간을 구하는 문제이기때문에
        Arrays.sort(starts);
        Arrays.sort(ends);

        int activeIntervals = 0; // 현재 구간에서 겹치는 수
        int maxGroups = 0; //최대 그룹 수
        int i = 0, j = 0;

        while (i < n) {
            if (starts[i] <= ends[j]) {
                activeIntervals++;
                maxGroups = Math.max(maxGroups, activeIntervals);
                i++;
            } else {
                activeIntervals--;
                j++;
            }
        }

        return maxGroups;
    }

    public static void main(String[] args) {
        DivideIntervalsIntoMinimumNumberofGroups d = new DivideIntervalsIntoMinimumNumberofGroups();
        int i = d.minGroups(new int[][]{{5, 10}, {6, 8}, {1, 5}, {2, 3}, {1, 10}});
        System.out.println("i = " + i);
    }
}
