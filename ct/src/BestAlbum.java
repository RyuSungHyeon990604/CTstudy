import java.util.*;


public class BestAlbum {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};

        List<Integer> result = new ArrayList<>();

        Map<String, Integer> genresTotalCount = new HashMap<>();
        Map<String, List<Integer>> genresDetailCount = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            genresTotalCount.put(genres[i],genresTotalCount.getOrDefault(genres[i],0)+plays[i]);

            List<Integer> orDefault = genresDetailCount.getOrDefault(genres[i], new ArrayList<Integer>());
            orDefault.add(plays[i]);
            genresDetailCount.put(genres[i],orDefault);
        }

        List<Map.Entry<String, Integer>> entries = new ArrayList<>(genresTotalCount.entrySet());
        entries.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue()-o1.getValue();
            }
        });
        for (Map.Entry<String, Integer> entry : entries) {
            String key = entry.getKey();
            List<Integer> detailCounts = genresDetailCount.get(key);

            Collections.sort(detailCounts);
            Collections.reverse(detailCounts);

            for (int i = 0; i < detailCounts.size(); i++) {
                int c = detailCounts.get(i);
                for (int j = 0; j < plays.length; j++) {
                    if(c == plays[j]) {
                        if(!result.contains(j)) {
                            result.add(j);
                            break;
                        }
                    }
                }
                if(i == 1)
                    break;
            }
        }
        answer = new int[result.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = result.get(i);
        }


        return answer;
    }
}
