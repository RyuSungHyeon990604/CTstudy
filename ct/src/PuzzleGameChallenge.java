public class PuzzleGameChallenge {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = -1;
        int maxLevel = 0;
        for (int i = 0 ; i<diffs.length ; i++) {
            maxLevel = Math.max(maxLevel, diffs[i]);
        }
        int l = 1 ,r = maxLevel;
        while (l<=r) {// 이진탐색 <=
            int level = (r + l) / 2;
            if(isPossable(diffs,limit,times,level)) {
                r = level-1;
                answer = level;
            }else{
                l = level+1;
            }
        }
        return answer;
    }

    public boolean isPossable(int[] diffs, long limit,int[] times,int level) {
        long total = 0;
        for (int i=0 ; i<diffs.length ; i++) {
            if (diffs[i] <= level) {
                total += times[i];
            }else{
                total += (diffs[i] - level) * (times[i] + times[i-1]) + times[i];
            }
        }

        return total <= limit;
    }



    public static void main(String[] args) {
        PuzzleGameChallenge game = new PuzzleGameChallenge();
        int solution = game.solution(new int[]{1, 5, 3}, new int[]{2,4,7}, 30);
        System.out.println("solution = " + solution);
    }
}
