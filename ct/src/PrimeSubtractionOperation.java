public class PrimeSubtractionOperation {
    public boolean primeSubOperation(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i>0 ? nums[i]-nums[i-1]-1 : nums[i] - 1; j >= 2; j--) {
                //구할수 있는 가장 큰 소수를 구한다
                if (isPrimeNumber(j) && nums[i] - j < nums[i + 1]) {// 소수를 뺀 값이 다음 값보다 작아야함
                    if (i > 0 && nums[i] - j <= nums[i - 1]) {// 추가로 만약 i>0 이라면 소수를 뺀 값이 이전값보다 커야함
                        continue;
                    }
                    nums[i] = nums[i] - j;
                    break;
                }
            }
            if (nums[i] >= nums[i + 1]) {//그럼에도 다음값보다 크거나같다면 false
                return false;
            }
        }
        return true;
    }

    public boolean isPrimeNumber(int n) {
        if (n == 2) return true;
        if (n == 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        PrimeSubtractionOperation op = new PrimeSubtractionOperation();
        System.out.println(op.primeSubOperation(new int[]{73,28,12,66,75,12,11,64,88,39}));
    }
}
