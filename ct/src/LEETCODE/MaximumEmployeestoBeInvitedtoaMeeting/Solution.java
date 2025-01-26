package LEETCODE.MaximumEmployeestoBeInvitedtoaMeeting;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int maximumInvitations(int[] favorite) {
        int n = favorite.length;
        int[] inDeg = new int[n];
        int[] chainLen = new int[n];
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();

        // 각 직원이 얼마나 많은 사람들에게 선호되는지 계산
        for (int f : favorite) inDeg[f]++;

        // 다른 직원들에게 선호되지 않는 직원들부터 (체인 시작점)
        // 체인 : 단방향 비순환 그래프
        for (int i = 0; i < n; i++)
            if (inDeg[i] == 0) q.add(i);

        // 체인을 처리하며 최대 체인 길이를 계산
        while (!q.isEmpty()) {
            int u = q.poll();
            visited[u] = true;
            int v = favorite[u];
            chainLen[v] = Math.max(chainLen[v], chainLen[u] + 1);
            if (--inDeg[v] == 0) q.add(v);
        }

        int maxCycle = 0, pairChains = 0;

        // 사이클을 탐지하고 결과 계산
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;

            int cycleLen = 0, current = i;
            // 사이클 길이 계산
            while (!visited[current]) {
                visited[current] = true;
                current = favorite[current];
                cycleLen++;
            }

            //cycleLen == 2 라는건 a->b ,b->a 일경우
            //즉 이때는 목적지가 a인 체인과 , b인 체인을 결합하여 인원을 배치할수있음
            if (cycleLen == 2) // 상호 쌍인 경우
                pairChains += 2 + chainLen[i] + chainLen[favorite[i]];
            else
                maxCycle = Math.max(maxCycle, cycleLen);
        }

        return Math.max(maxCycle, pairChains);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.maximumInvitations(new int[]{2,2,1,2});
    }
}
