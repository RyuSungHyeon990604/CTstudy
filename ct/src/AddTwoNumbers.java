import java.util.ArrayList;
import java.util.List;

public class AddTwoNumbers {

    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public void a(){
        ListNode l1 = new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9))));
        ListNode l2 = new ListNode(9,new ListNode(9));
        addTwoNumbers(l1,l2);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<Integer> list = new ArrayList<>();
        ListNode answer =null;
        int a = 0;
        while(true){
            if(l1 == null && l2 == null){
                if(a == 1){
                    list.add(a);
                }
                break;
            }
            int v1 = l1 == null ? 0 : l1.val;
            int v2 = l2 == null ? 0 : l2.val;

            list.add((a + v1 + v2) % 10);
            a = (a+v1 + v2)/10;

            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        for(int i = list.size() - 1; i >= 0 ;i--){
            answer = new ListNode(list.get(i),answer);
        }

        return answer;
    }
}
