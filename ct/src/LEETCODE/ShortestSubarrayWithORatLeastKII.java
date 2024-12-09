public class ShortestSubarrayWithORatLeastKII {
    public int minimumSubarrayLength(int[] nums, int k) {
        int minLength = Integer.MAX_VALUE;
        int[] bits = new int[32];
        int left = 0,right = 0;
        while (right < nums.length) {// bitsToInteger>=k 가 될때까지  bits 에 비트를 추가해나간다
            updateBits(bits, nums[right], 1);
            while(left < right && bitsToInteger(bits) >= k){//bits 를 정수로 변환했을때  k이상이라면 minLength을 업데이트하고
                // left 를 증가시키면서 bits의 비트를 하나씩 없앤다
                // 그럼에도 bitsToInteger(bits) >= k 라면 minLength와 bits를 계속 업데이트한다.
                minLength = Math.min(minLength, right-left+1);
                updateBits(bits, nums[left], -1);
                left++;
            }
            //bitsToInteger(bits) 가 k보다 작다면 right를 증가시킨다.
            right++;
        }
        return minLength;
    }
    public void updateBits(int[] bits,int n ,int update){
        for(int i = 0 ; i < 32 ; i++){
            if(((n>>i)&1) ==1){
                bits[i]+=update;
            }
        }
    }
    public int bitsToInteger(int[] bits){
        int res = 0;
        for(int i = 0 ; i < 32 ; i++){
            if(bits[i] != 0){
                res = res | (1 << i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ShortestSubarrayWithORatLeastKII sol = new ShortestSubarrayWithORatLeastKII();
        int i = sol.minimumSubarrayLength(new int[]{1,2,32,21}, 55);
        System.out.println("i = " + i);
    }
}
