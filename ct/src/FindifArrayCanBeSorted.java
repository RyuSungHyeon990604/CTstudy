public class FindifArrayCanBeSorted {
    public boolean canSortArray(int[] nums) {
        int prevMax = Integer.MIN_VALUE; // 이전 비트 그룹의 최대값
        int currMax = nums[0]; // 현재 비트 그룹의 최대값
        int currMin = nums[0]; // 현재 비트 그룹의 최소값
        int setBits = Integer.bitCount(nums[0]); // 현재 비트 수

        for(int i = 1; i < nums.length; i++) {
            // 현재 숫자의 비트 수가 setBits와 같으면 현재 그룹 내에서 최대/최소값 갱신
            if (setBits == Integer.bitCount(nums[i])) {
                currMax = Math.max(currMax, nums[i]);
                currMin = Math.min(currMin, nums[i]);
            } else {
                // 현재 그룹의 최소값이 이전 그룹의 최대값보다 작다면 정렬 불가능
                if (currMin < prevMax)
                    return false;

                // 새로운 그룹으로 이동
                prevMax = currMax;
                setBits = Integer.bitCount(nums[i]);
                currMin = nums[i];
                currMax = nums[i];
            }
        }
        // 마지막 체크: 모든 그룹을 통과했을 때, 마지막 그룹의 최소값이 이전 그룹의 최대값보다 크면 true 반환
        return currMin > prevMax;
    }

    public static void main(String[] args) {
        FindifArrayCanBeSorted f = new FindifArrayCanBeSorted();
        System.out.println(f.canSortArray(new int[]{1,2,3,4}));
    }
}
