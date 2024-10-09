import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 1->8->4->7->1->8... 식으로 loop이 형성된다는 걸 알 수 있음. 즉 하나의 loop에 속한 숫자는 다른 loop에 속하지 않는다.
//한 번의 for문 반복만으로 모든 loop을 판별하는 것이 가능
public class MasterOfPlayingAlone {
    public int solution(int[] cards) {
        int[] vis = new int[cards.length];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < cards.length; i++) {
            int back = back(cards, vis, i);
            if (back > 0) {
                list.add(back);
            }
        }
        Collections.sort(list);
        return list.size() == 1 ? 0 : list.get(list.size() - 1) *list.get(list.size() - 2) ;
    }

    public int back(int[] cards,int[] vis,int cur){
      int  count = 0;
      while(vis[cur] == 0){
          vis[cur] = 1;
          cur = cards[cur]-1;
          count++;
      }
      return count;
    }

    public static void main(String[] args) {
        MasterOfPlayingAlone a = new MasterOfPlayingAlone();
        a.solution(new int[]{8,6,3,7,2,5,1,4});
    }
}
