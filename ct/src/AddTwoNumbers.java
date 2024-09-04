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
        ListNode answer =new ListNode();
        ListNode tmp = answer;
        int a = 0;
        while(true){
            if(l1 == null && l2 == null){
                if(a > 0){
                    tmp.next = new ListNode(a);
                }
                break;
            }
            int v1 = l1 == null ? 0 : l1.val;
            int v2 = l2 == null ? 0 : l2.val;
            int mod = (a + v1 + v2) % 10;
            tmp.next = new ListNode(mod);
            a = (a+v1 + v2)/10;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
            tmp = tmp.next;
        }

        return answer.next;
    }
}
