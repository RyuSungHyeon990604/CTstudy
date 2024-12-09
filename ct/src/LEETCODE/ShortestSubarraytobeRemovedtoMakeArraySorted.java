public class ShortestSubarraytobeRemovedtoMakeArraySorted {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;

        int left = 0;
        while (left + 1 < n && arr[left] <= arr[left + 1]) {
            left++;
        }

        if (left == n - 1) return 0;

        int right = n - 1;
        while (right > 0 && arr[right - 1] <= arr[right]) {
            right--;
        }

        int result = Math.min(n - left - 1, right);// 왼쪽부분이나 오른쪽부분만을 남겻을때 지워지는 부분수열의 최소길이

        int i = 0;
        while (i <= left && right < n) {//i가 left를 넘어가면 비내림차순이 끝나버림, right부터 n까지는 비내림차순
            if (arr[i] <= arr[right]) {
                result = Math.min(result, right - i - 1);
                i++;// 더 작은 부분배열이 있는지 탐색
            } else {//만약 arr[i]가 arr에서 가장 큰 값이라면 right는 n이된다.
                right++;//arr[i] > arr[j] 인 j값을 삭제하는 부분배열에 포함시킨다
            }
        }

        return result;
    }

    public static void main(String[] args) {
        ShortestSubarraytobeRemovedtoMakeArraySorted sort = new ShortestSubarraytobeRemovedtoMakeArraySorted();
        sort.findLengthOfShortestSubarray(new int[]{6, 3, 10, 11, 15, 20, 13, 3, 18, 12});
    }
}
