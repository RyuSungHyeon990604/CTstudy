public class Immigration {
    public long solution(int n, int[] times) {
        long ans = 0;
        long left = 0, right = Long.MAX_VALUE;
        //mid 만큼 시간이 걸렸을때 통과할수있는 사람의 수
        while (left <= right) {
            long mid = (left + right) / 2;
            if(isMore(mid,times,n)){
                ans= mid;
                right = mid - 1;
            }else
                left = mid + 1;
        }

        return ans;
    }
    public boolean isMore(long n, int[] times,int limit){
        long sum = 0;
        for (int i = 0; i < times.length; i++) {
            sum += n/times[i];
            if(sum >= limit)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Immigration imm = new Immigration();
        System.out.println(imm.solution(6,new int[]{7,8}));
    }
}
