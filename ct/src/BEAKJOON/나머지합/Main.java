package BEAKJOON.나머지합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int m = Integer.parseInt(st.nextToken());
        int mod = Integer.parseInt(st.nextToken());
        int[] nums = new int[m];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < m; i++) {
           nums[i] = Integer.parseInt(st.nextToken());
        }
        print(nums,mod);
    }

    public static void print(int[] nums, int mod){
        long cnt = 0;
        int prefixSum = 0;
        int[] table= new int[mod];
        table[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            prefixSum = (prefixSum + nums[i])%mod;
            cnt += table[prefixSum]++;
        }
        System.out.println(cnt);
    }
}
