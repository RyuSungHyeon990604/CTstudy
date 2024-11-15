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

        int result = Math.min(n - left - 1, right);// 왼쪽부분과 오른쪽부분만을 남겻을때 지워지는 부분수열의 최소길이

        int i = 0, j = right;
        while (i <= left && j < n) {//i의 최댓값은 left부분의 오름차순의 마지막 인덱스 즉, left
            if (arr[i] <= arr[j]) {
                result = Math.min(result, j - i - 1);
                i++;// 더 작은 부분배열이 있는지 탐색
            } else {
                j++;//arr[i] > arr[j] 인 j값을 삭제하는 부분배열에 포함시킨다
            }
        }

        return result;
    }

    public static void main(String[] args) {
        ShortestSubarraytobeRemovedtoMakeArraySorted sort = new ShortestSubarraytobeRemovedtoMakeArraySorted();
        sort.findLengthOfShortestSubarray(new int[]{6, 3, 10, 11, 15, 20, 13, 3, 18, 12});
    }
}
