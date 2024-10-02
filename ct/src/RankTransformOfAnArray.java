import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class RankTransformOfAnArray {
    public int[] arrayRankTransform(int[] arr) {
        int[] res= new int[arr.length];
        Map<Integer,Integer> map = new HashMap<>();
        int[] clone = arr.clone();
        Arrays.sort(clone);
//        int rank = 1;
//        int index = 0;
//        while(index < clone.length) {
//            if(index > 0 && clone[index] == clone[index-1]) {
//                map.put(clone[index++], rank);
//            }else
//                map.put(clone[index++], ++rank);
//        }
        for(int i=0;i<clone.length;i++) {
            map.putIfAbsent(clone[i],map.size()+1);// putIfAbsent : key값이 존재한다면 value를 리턴, 없으면  put하고 null리턴
        }

        for (int i = 0; i < arr.length; i++) {
            res[i]= map.get(arr[i]);
        }

        return res;
    }
}
