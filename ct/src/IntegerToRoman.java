import java.util.HashMap;
import java.util.Map;

public class IntegerToRoman {
    public String intToRoman(int num) {
        StringBuilder answer = new StringBuilder();
        Map<Integer,String> roman = new HashMap<Integer,String>();
        roman.put(1, "I");
        roman.put(5, "V");
        roman.put(10, "X");
        roman.put(50, "L");
        roman.put(100, "C");
        roman.put(500, "D");
        roman.put(1000, "M");
        int temp  = num;

        int n  = (int) Math.floor(Math.log10(num));
        int n1 = (int) Math.pow(10, n);

        while(n1 != 0){
            int a = (int) Math.floor(temp/n1);

            //To Roman
            if(a == 4){
                answer.append(roman.get(n1));
                answer.append(roman.get(5*n1));
            }else if(a ==9){
                answer.append(roman.get(n1));
                answer.append(roman.get(n1*10));
            }else if(a == 5){
                answer.append(roman.get(n1*a));
            }else{
                if(a < 4){
                   for (int i = 0 ; i <a ;i++)
                       answer.append(roman.get(n1));
                }
                if(a > 5){
                    answer.append(roman.get(n1*5));
                    for (int i = 0; i< a - 5;i++)
                        answer.append(roman.get(n1));
                }
            }

            temp = temp  - (a * n1);
            n1 /= 10;
        }



        return answer.toString();
    }
}
