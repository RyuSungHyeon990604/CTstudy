import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SentenceSimilarityIII {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
       String[] str1 = sentence1.split(" ");
       String[] str2 = sentence2.split(" ");
       if(str1.length >= str2.length) {
           return isSimilar(str1,str2);
       }else{
           return isSimilar(str2,str1);
       }
    }
    public boolean isSimilar(String[] a, String[] b) {//"1 2 3 4 5 7" , "4 5 7" , "1 2 3" , "1 2 7"

        int l = 0, rA = a.length - 1, rB = b.length - 1;

        //a,b 의 양쪽 문자들을 서로 비교하여 동일한 경울 한칸씩 이동한다
        // n + b = a의 경우 l는 0이지만 rb 가 -1이된다
        // b + n = a의 경우 l는 (b의 길이)  rb  (b의 길이-1)이 된다
        // b' + n + b' = a 의 경우  a= "0 1 2 3 4 5 6"  b= "0 1 5 6" 일때  l = 2 rb = 1 이된다.
        // l은 a와 b모두 0부터 시작하지만,  rB는 b의 길이를 기준으로 값이 정해진다
        // 그래서 rB값보다 l의 값이 클때 a와 b가 비슷하다고 할수있다.

        while (l <= a.length-1 && a[l].equals(b[l])) {
            l++;
        }

        while (rA >= 0 && b[rB].equals(a[rA])) {
            rA--;
            rB--;
        }


        return rB < l;
    }

    public static void main(String[] args) {
        SentenceSimilarityIII sim = new SentenceSimilarityIII();
        boolean b = sim.areSentencesSimilar("d T d ED uXW L U J n klIe", "d T d ED uXW L U J klIe");
        System.out.println("b = " + b);
    }
}
