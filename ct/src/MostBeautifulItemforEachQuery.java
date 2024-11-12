import java.util.*;

public class MostBeautifulItemforEachQuery {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        int[] answer = new int[queries.length];
        Arrays.sort(items, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) return o1[1] - o2[1];
                return o1[0] - o2[0];
            }
        });

        //***가장 중요한 부분***
        //items 배열을 가격 순으로 정렬한 후, 각 가격에서 얻을 수 있는 최대 아름다움 값으로 설정한다
        int max = items[0][1];
        for (int i = 0; i < items.length; i++) {
            max = Math.max(max, items[i][1]);
            items[i][1] = max;
        }
        //***가장 중요한 부분***

        for (int i = 0; i < queries.length; i++) {
            int targetPrice = queries[i];
            int left = 0, right = items.length - 1;
            while (left <= right) {
                int mid = (right + left) / 2;
                if (items[mid][0] <= targetPrice) {
                    left = mid + 1;
                    answer[i] = items[mid][1];
                } else {
                    right = mid - 1;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        MostBeautifulItemforEachQuery m = new MostBeautifulItemforEachQuery();
        m.maximumBeauty(new int[][]{{193, 732}, {781, 962}, {864, 954}, {749, 627}, {136, 746}, {478, 548}, {640, 908}, {210, 799}, {567, 715}, {914, 388}, {487, 853}, {533, 554}, {247, 919}, {958, 150}, {193, 523}, {176, 656}, {395, 469}, {763, 821}, {542, 946}, {701, 676}}, new int[]{885, 1445, 1580, 1309, 205, 1788, 1214, 1404, 572, 1170, 989, 265, 153, 151, 1479, 1180, 875, 276, 1584});
    }
}
