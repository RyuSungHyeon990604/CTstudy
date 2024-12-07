package BEAKJOON.두배열의합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int[] nums1;
        int[] nums2;
        int t = Integer.parseInt(st.nextToken());
        nums1 = new int[Integer.parseInt(new StringTokenizer(br.readLine()," ").nextToken())];
        st = new StringTokenizer(br.readLine()," ");
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = Integer.parseInt(st.nextToken());
        }
        nums2 = new int[Integer.parseInt(new StringTokenizer(br.readLine()," ").nextToken())];
        st = new StringTokenizer(br.readLine()," ");
        for (int i = 0; i < nums2.length; i++) {
            nums2[i] = Integer.parseInt(st.nextToken());
        }

        print(nums1, nums2, t);

    }
    public static void print(int[] nums1,int[] nums2,int targetSum) {
        long answer = 0;

        Map<Integer,Integer> map1 = new HashMap<>();
        Map<Integer,Integer> map2 = new HashMap<>();

        comb(nums1,map1);
        comb(nums2,map2);

        for(int aSum : map1.keySet()) {
            int bSum = targetSum - aSum;
            answer += (long)map1.get(aSum) * map2.getOrDefault(bSum,0);
        }


        System.out.println(answer);
    }

    public static void comb(int[] nums, Map<Integer, Integer> map) {

        for (int size = 1; size <= nums.length; size++) {
            for (int start = 0; start <= nums.length - size ; start++) {
                int s = 0;
                for (int end = start; end < start+size ; end++) {
                    s+=nums[end];
                }
                map.put(s,map.getOrDefault(s,0)+1);
            }
        }
    }
}
