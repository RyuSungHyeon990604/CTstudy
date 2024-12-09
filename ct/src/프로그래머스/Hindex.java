import java.util.*;

public class Hindex {
 //H-index 계산
 //- 연구자의 발표 논문을 피인용 횟수가 많은 순으로 내림차순으로 정렬하고 순위를 매긴 후 순위와 피인용 횟수가 같아지거나 순위가 피인용 횟수보다 작은 최대값이 ‘H’ 입니다.
    public int solution(int[] citations) {
        int answer = 0;
        Integer[] arr= new Integer[citations.length];
        for (int i = 0; i < citations.length; i++) {
            arr[i] = citations[i];
        }
        Arrays.sort(arr,new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o2- o1;
            }
        });
//        Arrays.sort(citations);
        // citations = [0,1,3,5,6]
//        for (int i = 0; i < citations.length ; i++) {
//            int rank = citations.length - i; //순위
//            //citations[i] 피인용 횟수
//            //배열은 내림차순이 아닌 오름차순 정렬했으므로
//            //rank       :  5  4  3  2  1
//            //피인용 횟수 :  0  1  3  5  6
//            if(citations[i] >= rank) {
//                answer = rank;
//                break;
//            }
//        }

        for (int i = 0; i < arr.length; i++) {
            int rank = i+1;
            if(arr[i] < rank){
                answer = rank - 1;
                break;
            }
        }


        return answer;
    }
}
