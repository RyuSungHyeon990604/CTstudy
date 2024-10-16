import java.util.*;

public class DonutBarGraphs {
    class Node{
        int value;
        List<Node> pre;
        List<Node> next;

        public Node(int value) {
            this.value = value;
            pre = new ArrayList<Node>();
            next = new LinkedList<Node>();
        }
    }
    public int[] solution(int[][] edges) {
        int[] answer = {0,0,0,0};
        Map<Integer, Node> map = new HashMap<>();

        for (int[] edge : edges) {
            int start = edge[0];
            int end = edge[1];
            if (!map.containsKey(start)) {
                Node newNode = new Node(start);
                if (map.containsKey(end)) {
                    Node endNode = map.get(end);
                    newNode.next.add(endNode);
                    endNode.pre.add(newNode);
                }else{
                    if(start == end){
                        newNode.next.add(newNode);
                        newNode.pre.add(newNode);
                    }else{
                        Node newEndNode = new Node(end);
                        newNode.next.add(newEndNode);
                        newEndNode.pre.add(newNode);
                        map.put(end, newEndNode);
                    }
                }
                map.put(start, newNode);
            }else{
                Node node = map.get(start);
                if (map.containsKey(end)) {
                    Node endNode = map.get(end);
                    node.next.add(endNode);
                    endNode.pre.add(node);
                }else{
                    if(start == end){
                        node.next.add(node);
                        node.pre.add(node);
                    }else{
                        Node newEndNode = new Node(end);
                        node.next.add(newEndNode);
                        newEndNode.pre.add(node);
                        map.put(end, newEndNode);
                    }
                }
                map.put(start, node);
            }
        }
        for (Node node : map.values()) {
            //[정점, 도넛, 막대, 8자]
            if (node.pre.isEmpty() && node.next.size() >= 2) {
                answer[0] = node.value;
            }
            if (node.next.size() ==0) {
                answer[2] += 1;
            }
            if ((node.pre.size() == 2 || node.pre.size() == 3) && node.next.size() == 2){
                answer[3] += 1;
            }
        }
        answer[1] = map.get(answer[0]).next.size() - answer[2] - answer[3];


        return answer;
    }

    public static void main(String[] args) {
        DonutBarGraphs donutBarGraphs = new DonutBarGraphs();
        donutBarGraphs.solution(new int[][]{{2, 3}, {4, 3}, {1, 1}, {2, 1}});
    }
}
