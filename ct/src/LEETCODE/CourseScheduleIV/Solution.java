package LEETCODE.CourseScheduleIV;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        int[][] graph = new int[numCourses][numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            int start = prerequisites[i][0];
            int end = prerequisites[i][1];
            graph[start][end] = 1;
        }

        for(int r = 0; r < numCourses; r++){
            for(int c = 0; c < numCourses; c++){
                for(int d = 0; d < numCourses; d++){
                    if(graph[c][r] == 1 && graph[r][d] == 1){
                        graph[c][d] = 1;
                    }
                }
            }
        }

        List<Boolean> ans = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            if(graph[start][end] == 1)
                ans.add(true);
            else ans.add(false);
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.checkIfPrerequisite(2,new int[][]{{1,0}},new int[][]{{0,1},{1,0}});
    }
}
