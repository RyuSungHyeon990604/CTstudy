import java.util.ArrayList;

public class RemoveNthNodeFromEndofList {
     class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public void s(){
         ListNode head = new ListNode(0,new ListNode(1,null));
        removeNthFromEnd(head,2);
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode ans= new ListNode(0, head);
        ListNode ans2= ans;
        for(int i=0 ; i< n;i++){
            head = head.next;
        }

        while(head!=null){
            head = head.next;
            ans2 = ans2.next;
        }
        ans2.next = ans2.next.next;



        return ans.next;
    }
}
