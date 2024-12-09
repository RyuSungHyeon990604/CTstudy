package BEAKJOON.소수의연속합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());

        print(n);
    }
    public static void print(int n){
        int[] primTable = new int[n+1];
        int primCnt = initPrimeTable(primTable,n);
        int[] log = new int[primCnt];
        int logTop = 0;
        int logBottom = 0;
        int cnt = 0;
        int prefixSum = 0;
        for (int i = 2; i < primTable.length; i++) {
            if(primTable[i] == 0){
                log[logTop++] = i;
                prefixSum += i;
                if(prefixSum == n){
                    cnt++;
                }else if(prefixSum > n){
                    while(prefixSum > n){
                        prefixSum -= log[logBottom];
                        logBottom++;
                    }
                    if(prefixSum == n){
                        cnt++;
                    }
                }

            }
        }
        System.out.println(cnt);
    }
    public static int initPrimeTable(int[] table, int n){
        int cnt = 0;
        for(int i=2; i<=n; i++){
            if(table[i] == 1) continue;
            for(int j=i<<1; j <= n; j = j + i){
                if(table[j] == 0){
                    table[j] = 1;
                    cnt++;
                }
            }
        }
        return n - 1 - cnt;
    }
}
