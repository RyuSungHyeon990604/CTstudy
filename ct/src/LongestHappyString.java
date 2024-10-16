import java.util.PriorityQueue;

public class LongestHappyString {
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder ans = new StringBuilder();
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2) -> o2[1]-o1[1]);
        if(a >0) pq.offer(new int[]{0,a});
        if(b >0) pq.offer(new int[]{1,b});
        if(c >0) pq.offer(new int[]{2,c});

       while (!pq.isEmpty()) {
           int[] cur = pq.poll();
           char ch =(char)(cur[0]+'a');
           if(ans.length()>=2 && ans.charAt(ans.length()-1)== ans.charAt(ans.length()-2) && ans.charAt(ans.length()-1) == ch){
               int[] next = pq.poll();
               if(next == null)
                   break;
               char ch2 =(char)(next[0]+'a');
               ans.append(ch2);
               next[1]--;
               if(next[1]>0)
                   pq.offer(next);
           }
           ans.append(ch);
           cur[1]--;
           if(cur[1]>0)
            pq.offer(cur);
       }

        return ans.toString();
    }


    public static void main(String[] args) {
        LongestHappyString s = new LongestHappyString();
        s.longestDiverseString(2,4,1);
    }
}
