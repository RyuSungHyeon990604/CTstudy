import java.util.*;

public class DiskController {
    public int solution(int[][] jobs) {
        int answer = 0;
        Queue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        // 원본 배열 오름차순 정렬 (요청시간 오름차순)
        Arrays.sort(jobs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0])
                    return o1[1] - o2[1];
                else
                    return o1[0] - o2[0];
            }
        });


        int end = jobs[0][0];
        int index = 0;

        while(index < jobs.length){
            while(index < jobs.length && end >= jobs[index][0]) {
                //디스크가 작동중일때 대기하는 작업들을 넣는다
                queue.add(jobs[index]);
                index++;


                //디스크가 작동중일때 대기하는 작업이 없을 때, 즉 앞선 작업이  두의 작업요청 시간보다 빨리 끝났을 때
                if (queue.isEmpty()) {
                    queue.add(jobs[index]);
                    end = jobs[index][0];
                    index++;
                }

                int[] poll = queue.poll();
                answer += poll[1] + end - poll[0];
                end = end + poll[1];
            }

        }


        return (int) Math.floor(answer / jobs.length);
    }
}
