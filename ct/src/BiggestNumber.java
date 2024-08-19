import java.util.Arrays;
import java.util.Comparator;

public class BiggestNumber {
    public String solution(int[] numbers) {
        String answer = "";
        String[] arr =new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(arr,new Comparator<String>() {
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });
        
        for(String s : arr){
            answer = answer + s;
        }
        return answer;
    }
}
