import java.util.*;

public class SmallestRangeCoveringElementsfromKLists {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int max = Integer.MIN_VALUE;

        // 각 리스트의 첫 번째 요소를 큐에 삽입
        for (int i = 0; i < nums.size(); i++) {
            int num = nums.get(i).get(0);
            pq.offer(new int[]{num, i, 0});  // {값, 리스트 인덱스, 리스트 내 인덱스}
            max = Math.max(max, num);
        }

        int rangeStart = 0, rangeEnd = Integer.MAX_VALUE;

        // 큐에서 가장 작은 값을 계속 처리
        while (pq.size() == nums.size()) {
            int[] min = pq.poll();
            int minValue = min[0], listIndex = min[1], elementIndex = min[2];

            // 현재 범위를 업데이트
            if (max - minValue < rangeEnd - rangeStart) {
                rangeStart = minValue;
                rangeEnd = max;
            }

            // 다음 요소가 있으면 큐에 삽입
            if (elementIndex + 1 < nums.get(listIndex).size()) {
                int nextValue = nums.get(listIndex).get(elementIndex + 1);
                pq.offer(new int[]{nextValue, listIndex, elementIndex + 1});
                max = Math.max(max, nextValue);  // 최대값 업데이트
            }
        }

        return new int[]{rangeStart, rangeEnd};
    }

    public static void main(String[] args) {
        SmallestRangeCoveringElementsfromKLists s = new SmallestRangeCoveringElementsfromKLists();
        List<Integer> a1 = new ArrayList<>();
        a1.add(1);
        a1.add(4);
        a1.add(7);
        a1.add(10);
        List<Integer> a2 = new ArrayList<>();
        a2.add(2);
        a2.add(5);
        a2.add(8);
        a2.add(11);
        List<Integer> a3 = new ArrayList<>();
        a3.add(3);
        a3.add(6);
        a3.add(9);
        a3.add(12);
        List<List<Integer>> nums = new ArrayList<>();
        nums.add(a1);
        nums.add(a2);  nums.add(a3);
        s.smallestRange(nums);

    }
}
