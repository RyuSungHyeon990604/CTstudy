import java.util.*;

public class MenuRenewer{
    public static int[] visit;
    public Map<String ,Integer> allcombination = new HashMap<>();
    public Map<Integer, Integer> count = new HashMap<>();
    ArrayList<String> arr =new ArrayList<>();
    //["ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"]	[2,3,4]	["AC", "ACDE", "BCFG", "CDE"]
    public String[] solution(String[] orders, int[] course) {
       String[] answer = {};



        for(String order : orders){
            for(int c : course){
                visit = new int[order.length()];
                char[] charArray = order.toCharArray();
                Arrays.sort(charArray);
                combination(charArray,0,c);
            }
        }

        Iterator<String> iterator = allcombination.keySet().iterator();
        while(iterator.hasNext()){
            String key = iterator.next();
            if( count.get(key.length()) > 1 && (allcombination.get(key) == count.get(key.length()))){
                arr.add(key);
            }
        }
        System.out.println("allcombination");
        System.out.println(allcombination);
        System.out.println();
        System.out.println("count");
        System.out.println(count);
        Collections.sort(arr);
        answer = arr.toArray(new String[arr.size()]);
        return answer;
    }

    public void combination(char[] charArray,int dept,int n){
        if(n == 0){
            String order = "";
            for(int i = 0;i < visit.length;i++){
                if(visit[i] == 1)
                    order = order+charArray[i];
            }
            if(allcombination.get(order)==null){
                allcombination.put(order,1);
            }else{
                allcombination.put(order,allcombination.get(order)+1);
            }

            if(count.get(order.length())==null){
                count.put(order.length(),1);
            }
            else if(count.get(order.length()) < allcombination.get(order) )
                count.put(order.length(),allcombination.get(order));



            return;
        }
        for(int i = dept; i < charArray.length; i++){
            visit[i] = 1;
            combination(charArray,i+1,n-1);
            visit[i] = 0;
        }
    }
}
