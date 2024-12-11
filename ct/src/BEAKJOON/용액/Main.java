package BEAKJOON.용액;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        int[] nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        print(nums);
    }
    public static void print(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int[] answer = new int[2];
        int min = Integer.MAX_VALUE;
        while (left < right) {
            int sum = Math.abs(nums[left] + nums[right]);
            if (sum < min) {
                min = sum;
                answer[0] = nums[left];
                answer[1] = nums[right];
                if(min == 0)
                    break;
            }
            if (nums[left] + nums[right] < 0) {
                left++;
            }else{
                right--;
            }
        }
        System.out.println(answer[0] + " " + answer[1]);
    }
}
