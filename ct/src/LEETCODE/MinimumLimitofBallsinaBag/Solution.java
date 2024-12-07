package LEETCODE.MinimumLimitofBallsinaBag;

import java.util.Collections;
import java.util.PriorityQueue;

public class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int left = 1;
        int right = 0;

        //가장 큰 값을 찾는다
        for (int num : nums) {
            right = Math.max(right, num);
        }

        while (left < right) {
            int mid = (left + right) / 2;

            if (isPossible(mid, nums, maxOperations)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
    //가방에 들어갈수있는 공의 갯수에 제한을두고, 그 조건에 만족시킬려면 몇번의 연산이 필요한지 계산
    //9는 (1,8)(2,7)(3,6)(4,5) 로 나뉠수있다. 즉 1,2,3,4,5,6,7,8로 나뉠수있는데 이것들을 하나의 가방에 들어갈수있는 공의 최대갯수라고하자.
    //만약 하나의 가방에 들어갈수있는 공의 최대갯수가 5라고 할때 몇번의 연살이 필요할까? (5,4) 1번이 필요하다
    // 4라면? (4,4,1) 2번
    // 3이라면? (3,3,3) 2번
    // 2라면? (2,2,2,2,1) 4번
    // 1이라면? (1,1,1,1,1,1,1,1,1) 8번
    // 즉 maxOperations이 2라면 우리가 원하는값은 3<4 이므로 3이다.

    //num = [9,5] 라면?
    // max = 9 [9,5] operations = 0
    // ...
    // max = 5 [(5,4),5] operations = 1
    // max = 4 [(4,4,1),(4,1)] operations = 3
    // 즉 maxOperations이 2라면 우리가 원하는값은 5이다.
    private boolean isPossible(int maxBallsInBag, int[] nums, int maxOperations) {
        int cnt = 0;

        for (int num : nums) {

            int operations = (num-1)/maxBallsInBag ;
            cnt += operations;

            if (cnt > maxOperations) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.minimumSize(new int[]{9}, 2);
    }
}
