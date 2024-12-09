import java.util.*;

public class ArrayPairsAreDivisibleByK {
    public boolean canArrange(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int n = (arr[i]%k +k) % k; //arr[i] 에 더했을때 k의 배수가 되는값. +k 를 해주는 이유 : arr[i]%k < 0일때 양수값으로 구하기위해서
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        for (int i : arr) {
            int n = (i%k +k) % k;

            if(n == 0){//더해야하는 값이 0이다 ==> i는 k의 배수다 => 2개가 한 쌍이므로  더해야하는 값이 0인것의 갯수는 짝수여야한다
                if(map.get(n)% 2!=0) return false;
            }else{
               // if(map.get(n) != map.get(k-n))// (나머지가 n인 수 + a )%k ==0 이 되려면 ,a = 나머지가 k-n인 수이여야한다
               //     return false;
                if(!Objects.equals(map.get(n),map.get(k-n))) return false;// null일경우에도 체크를 위해 Objects.equals()를 사용
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ArrayPairsAreDivisibleByK a = new ArrayPairsAreDivisibleByK();
        a.canArrange(new int[]{-10,10}, 2);
    }

}
