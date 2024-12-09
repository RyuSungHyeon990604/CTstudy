import javax.swing.*;
import javax.swing.plaf.ListUI;
//각 포인터의 역할:
//dummy: 가짜 헤드 노드로, 리스트의 시작 부분을 처리할 때 유용합니다. dummy.next는 리스트의 실제 헤드를 가리킵니다.
//prevNode: 스왑한 두 노드의 앞에 위치한 노드를 가리킵니다. 스왑 후, 이 노드의 next를 새로 스왑된 두 번째 노드로 연결합니다.
//firstNode: 현재 스왑할 첫 번째 노드를 가리킵니다.
//secondNode: 현재 스왑할 두 번째 노드를 가리킵니다.
//head: 현재 처리 중인 리스트의 노드를 가리킵니다. 반복문이 진행될수록 다음 스왑할 노드로 이동합니다.
//포인터 연결 과정:
//초기 상태:
//
//dummy -> 1 -> 2 -> 3 -> 4
//prevNode는 dummy를 가리키고, firstNode는 1, secondNode는 2를 가리킵니다.
//head는 1에서 시작합니다.
//첫 번째 스왑:
//
//prevNode.next = secondNode → dummy -> 2
//firstNode.next = secondNode.next → 1 -> 3
//secondNode.next = firstNode → 2 -> 1
//이로 인해 리스트는 dummy -> 2 -> 1 -> 3 -> 4로 변경됩니다.
//
//다음 노드로 이동:
//
//prevNode = firstNode → prevNode는 이제 1을 가리킵니다.
//head = firstNode.next → head는 3으로 이동합니다.
//두 번째 스왑:
//
//위와 동일한 과정으로 3과 4를 스왑하여 리스트는 dummy -> 2 -> 1 -> 4 -> 3이 됩니다.
//이 과정을 통해 prevNode, firstNode, secondNode, dummy, 그리고 head가 각 스텝에서 어떻게 연결되는지 이해할 수 있습니다.


//네, 맞습니다! 이 문제를 어렵게 느끼는 이유는 **각각의 노드 포인터(dummy, prevNode, firstNode, secondNode, head)**가 마치 서로 모두 연결된 것처럼 복잡하게 상상하기 때문일 수 있습니다.
//
//사실, 이 문제에서는 각 포인터는 서로 다른 노드를 가리키고 있으며, 각 노드의 next 포인터만 변경하는 것이 핵심입니다. 즉, 포인터들이 모두 "하나의 노드들"처럼 연결된 것이 아니라, 각각 특정 시점의 노드를 가리키고 있을 뿐입니다.
//
//이해를 돕기 위한 요점:
//포인터들은 그저 위치를 가리킬 뿐:
//
//dummy, prevNode, firstNode, secondNode, head는 각기 다른 노드를 가리키고 있으며, 이를 통해 노드의 연결을 변경할 수 있습니다. 그저 리스트의 특정 위치를 가리키고 있다고 보면 됩니다.
//포인터들이 스왑을 관리:
//
//firstNode와 secondNode는 현재 스왑할 두 개의 노드를 가리키고, 스왑 후에는 prevNode와 dummy가 새롭게 연결된 리스트의 위치를 관리합니다.
//스왑 후에도 각 포인터는 그저 다음 노드를 가리킴:
//
//스왑이 완료된 후, prevNode는 스왑 후의 두 번째 노드를 가리키고, head는 다음 스왑할 노드를 가리킵니다.
//포인터 역할 간단 요약:
//prevNode: 스왑하기 직전의 노드.
//firstNode: 스왑할 첫 번째 노드.
//secondNode: 스왑할 두 번째 노드.
//head: 다음으로 처리할 노드.
//dummy: 편의를 위해 리스트의 시작을 관리하는 노드.
//결론:
//포인터가 복잡하게 얽힌 것이 아니라, 단지 각 노드를 가리키고 있으며, 스왑 후 next 포인터만 바뀌는 것이 문제의 핵심입니다.
//firstNode, secondNode가 어떤 노드를 가리키고 있고 그들의 next가 어떻게 변경되는지에 집중하면 이 문제를 더 쉽게 해결할 수 있습니다.


public class SwapNodesinPairs {
    class ListNode {
      int val;
      ListNode next;ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public void asd(){
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        swapPairs(head);
    }

    public ListNode swapPairs(ListNode head) {
        // 더 이상 스왑할 노드가 없으면 바로 리턴
        if (head == null || head.next == null) {
            return head;
        }

        // 가짜 헤드(dummy)를 사용해 간단히 처리
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prevNode = dummy;

        // 두 개의 노드를 스왑하는 루프
        while (head != null && head.next != null) {
            // 스왑할 두 노드
            ListNode firstNode = head;
            ListNode secondNode = head.next;

            // 스왑 처리
            prevNode.next = secondNode;   // 이전 노드가 두 번째 노드를 가리키도록 변경
            firstNode.next = secondNode.next; // 첫 번째 노드가 다음 쌍을 가리킴
            secondNode.next = firstNode;  // 두 번째 노드가 첫 번째 노드를 가리킴

            // 다음 스왑할 쌍으로 이동
            prevNode = firstNode;  // 이전 노드는 스왑 후 첫 번째 노드가 됨
            head = firstNode.next; // head는 다음 쌍의 첫 번째 노드로 이동
        }

        // dummy.next는 새로운 리스트의 시작을 가리킴
        return dummy.next;
    }
}
