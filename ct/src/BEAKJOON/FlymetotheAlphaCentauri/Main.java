package BEAKJOON.FlymetotheAlphaCentauri;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine()," ");
            print(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }
    }
    public static void print(int start, int end){
        int len = end - start;
        //len == 2147483647
        int sqrt = (int) Math.sqrt(len);
        //1+2+3+...n-1+n+n-1+...3+2+1 = sqrt*(sqrt+1)/2 + sqrt*(sqrt-1)/2 == sqrt * sqrt
        if(sqrt * sqrt == len){
            //          n
            //      ...   ...
            //     3         3
            //   2             2
            // 1                 1
            System.out.println(sqrt + sqrt - 1);
        }else{
            int diff = len - sqrt*sqrt;
            int cnt = (int) Math.ceil((double)diff / sqrt);
            // if diff == k && diff < sqrt              // if     diff == sqrt                 // if diff - sqrt == k && diff > sqrt
            //            sqrt                          //         sqrt   sqrt                 //         sqrt   sqrt
            //           ...                            //             ...                     //             ...
            //       k           k   k                  //    3                   3            //       k            k   k
            //           ...                            //  2                       2          //             ...
            //    3                     3               //1                           1        //    3                        3
            //  2                         2                                                    //  2                            2
            //1                              1                                                 //1                                1
            System.out.println(sqrt + sqrt - 1 + cnt);
        }
    }
}
