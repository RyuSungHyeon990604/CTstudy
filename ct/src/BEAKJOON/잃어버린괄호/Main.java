package BEAKJOON.잃어버린괄호;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = new StringTokenizer(br.readLine()).nextToken();
        print(str);
    }
    public static void print(String str) {
        int n = str.length();
        int left = 0;
        int totalSum = 0;
        boolean isNegative = false;
        for (int right = 0; right <= n; right++) {
            if (right == n || str.charAt(right) == '+' || str.charAt(right) == '-') {
                int num = Integer.parseInt(str.substring(left, right));
                if (isNegative) {
                    totalSum -= num;
                } else {
                    totalSum += num;
                }
                left = right + 1;
                if (right < n && str.charAt(right) == '-') {
                    isNegative = true;
                }
            }
        }

        System.out.println(totalSum);
    }
}
