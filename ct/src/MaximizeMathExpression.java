import java.util.*;

public class MaximizeMathExpression {
    public long solution(String expression) {
        long answer = 0;
        String [][] list = new String[][]{{"+","-","*"},{"+","*","-"},{"-","+","*"},{"-","*", "+"},{"*","-","+"},{"*","+","-"}};
        List<String> exp = new ArrayList<String>();
        List<Long> results= new ArrayList<>();
        int div = 0;
        for (int i = 0; i < expression.length(); i++) {
            if(expression.charAt(i) == '+' || expression.charAt(i) == '-' || expression.charAt(i) == '*') {
                exp.add(expression.substring(div, i));
                exp.add(expression.substring(i, i + 1));
                div = i+1;
            }
            if(i == expression.length()-1) {
                exp.add(expression.substring(div, i+1));
            }
        }
        for (String[] ints : list) {
            List<String> tmp =new ArrayList<>(exp);
            for (String anInt : ints) {
                for (int i = 1 ; i <tmp.size() ; i = i + 2) {
                    if(tmp.get(i).equals(anInt)) {
                        long a = Long.parseLong(tmp.get(i-1));
                        long b = Long.parseLong(tmp.get(i+1));
                        if(anInt.equals("+")) {
                            tmp.set(i-1, String.valueOf(a+b));
                            tmp.remove(i);
                            tmp.remove(i);
                            i-=2;
                        }
                        if(anInt.equals("-")) {
                            tmp.set(i-1, String.valueOf(a-b));
                            tmp.remove(i);
                            tmp.remove(i);
                            i-=2;
                        }
                        if(anInt.equals("*")) {
                            tmp.set(i-1, String.valueOf(a*b));
                            tmp.remove(i);
                            tmp.remove(i);
                            i-=2;
                        }

                    }
                }
            }
            long re = Long.parseLong(tmp.get(0));
            results.add(re < 0 ? -1 * re : re);
        }
        Collections.sort(results, Collections.reverseOrder());
        System.out.println(results);
        answer= Math.abs(results.get(0));
        return answer;
    }
}
