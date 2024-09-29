import java.util.*;
//다시 풀이
class Node{
    int freq;
    Node prev;
    Node next;
    Set<String> word=new HashSet<>();

    Node(int freq) {
        this.freq = freq;
    }
}

public class AllOne {

    Node head;
    Node tail;
    Map<String, Node> map = new HashMap<>();

    public AllOne() {
      head = new Node(0);
      tail = new Node(0);
      head.next = tail;
      tail.prev = head;
    }

    public void inc(String key) {// Increments the count of the string key by 1. If key does not exist in the data structure, insert it with count 1
        if(map.containsKey(key)) {
            Node node = map.get(key);
            node.word.remove(key);//횟수가 증가하므로 현재노드에서는 지워준다

            int freq = node.freq;

            Node next = node.next;

            if(freq+1 == next.freq) {// 다음노드에 같은 횟수의 노드가있다면 그 노드를 추가해준다
              next.word.add(key);
              map.put(key, next);
            }else{//없다면 새로운 노드를 만든다
                Node newNode = new Node(freq+1);
                newNode.word.add(key);

                node.next = newNode;
                newNode.prev = node;

                newNode.next = next;
                next.prev = newNode;
                map.put(key, newNode);
            }

            if(node.word.size() == 0){//만약 단어를 지웠을때 해당 노드의 단어갯수가 0 이라면 노드를 지운다
                removeNode(node);
            }

        }else{
            Node node = head.next;
            Node next = node.next;
            if(node == tail) {
                Node newNode = new Node(1);
                head.next = newNode;
                newNode.prev = head;
                tail.prev = newNode;
                newNode.next = node;
                newNode.word.add(key);
                map.put(key, newNode);
            }else if(node.freq == 1){//다음 노드가있다면, key값으로 map에 추가한다.
                map.put(key, node);
                node.word.add(key);
            }else if(node.freq > 1){//다음 노드가있지만, 다음노드의 freq값과 달라 새로운 노드를 만들어야할때
                Node newNode = new Node(1);
                head.next = newNode;
                newNode.prev = head;
                node.prev = newNode;
                newNode.next = node;
                newNode.word.add(key);
                map.put(key, newNode);
            }
        }
    }

    public void dec(String key) {//Decrements the count of the string key by 1. If the count of key is 0 after the decrement, remove it from the data structure. It is guaranteed that key exists in the data structure before the decrement.
        if(map.containsKey(key)) {
            Node node = map.get(key);
            node.word.remove(key);
            int freq = node.freq;
            Node prev = node.prev;
            if(freq == 1) {
                node.word.remove(key);
                map.remove(key);
            }else if(freq - 1 == prev.freq){
                prev.word.add(key);
                map.put(key, prev);
            }else if(freq - 1 != prev.freq){
                Node  newNode = new Node(freq-1);
                newNode.word.add(key);

                newNode.prev = prev;
                prev.next = newNode;

                newNode.next = node;
                node.prev = newNode;
                map.put(key, newNode);
            }
            if(node.word.size() == 0){//만약 단어를 지웠을때 해당 노드의 단어갯수가 0 이라면 노드를 지운다
                removeNode(node);
            }
        }else{
            return;
        }
    }

    public String getMaxKey() {//Returns one of the keys with the maximal count. If no element exists, return an empty string "".
        if(tail.prev == head) {
            return "";
        }
        return tail.prev.word.iterator().next();
    }

    public String getMinKey() {//Returns one of the keys with the minimum count. If no element exists, return an empty string "".
        if(head.next == tail) {
            return "";
        }
        return head.next.word.iterator().next();
    }

    public void removeNode(Node node) {
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    public static void main(String[] args) {
        AllOne allOne = new AllOne();
        allOne.inc("a");
        allOne.inc("a");
        allOne.getMaxKey();
        allOne.getMinKey();
        allOne.inc("b");
        allOne.getMaxKey();
        allOne.getMinKey();
    }
}
