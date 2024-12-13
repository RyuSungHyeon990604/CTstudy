package BEAKJOON.베르트랑공준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static boolean[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = 0;
        List<Integer> list = new ArrayList<>();
        while (true) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0)
                break;
            max = Math.max(max, num);
            list.add(num);
        }

        initMap(max*2);

        for (int num : list) {
            print(num+1,num*2);
        }
    }
    public static void print(int start, int end) {
        int n = 0;
        for (int i = start; i <= end; i++) {
            if (!arr[i]) n++;
        }
        System.out.println(n);
    }
    public static void initMap(int size){
        arr = new boolean[size+1];
        for(int i = 2; i <= Math.sqrt(size); i++){
            if(arr[i]) continue;
            for(int j = i*i; j <= size; j+=i){
                arr[j] = true;
            }
        }
    }
//    public static boolean isPrime(int n) {
//        if(n == 1) return false;
//        if(n == 2 || n == 3) return true;
//        if(n % 2 == 0 || n % 3 ==0 ) return false;
//        for (int i = 3; i <= Math.sqrt(n); i+=2) {
//            if (n % i == 0) {
//                return false;
//            }
//        }
//        return true;
//    }
}
