package LEETCODE.KthSmallestProductofTwoSortedArrays;

public class Solution {
	public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
		long left = (long) -1e10, right = (long) 1e10;
		while(left <= right) {
			long mid = left + (right - left) / 2;

			if(count(nums1, nums2, mid) >= k) {
				right = mid - 1;
			} else {
				left = mid + 1;

			}
		}


		return left;
	}

	private long count(int[] nums1, int[] nums2, long v) {
		long count = 0;
		for(int i = 0; i < nums1.length; i++) {
			if(nums1[i] == 0 && v >= 0) {
				count += nums2.length;
			} else {
				int i1 = countLowerValues(nums2, nums1[i], v);
				count += i1;
			}
		}
		return count;
	}

	private int countLowerValues(int[] nums2, int num, long v) {
		int left = 0, right = nums2.length - 1;
		if (num > 0) {
			while (left <= right) {
				int mid = (left + right) / 2;
				long prod = (long) num * nums2[mid];
				if (prod <= v) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}
			return left;
		} else {
			while (left <= right) {
				int mid = (left + right) / 2;
				long prod = (long) num * nums2[mid];
				if (prod <= v) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			}
			return nums2.length - left;
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		long l = s.kthSmallestProduct(new int[]{-6}, new int[]{-9}, 1);
		System.out.println("l = " + l);
	}
}
