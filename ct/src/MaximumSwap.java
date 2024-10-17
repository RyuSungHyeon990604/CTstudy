import java.util.PriorityQueue;

public class MaximumSwap {
    int ans = 0;
    public int maximumSwap(int num) {
        ans = num;
        int n = (int) (Math.log(num) / Math.log(10)) + 1;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = num % 10;
            num /= 10;
        }
        for(int i = 0;i<n;i++) {
            s(arr,0,i);
        }

        return ans;
    }

    public void s(int[] arr,int depth,int start) {
        if(depth == 1) {
            ans = Math.max(ans,arraysToInts(arr));
            return;
        }
        for (int i = start; i < arr.length; i++) {
            if(arr[i] < arr[start]) {
                int t = arr[start];
                arr[start] = arr[i];
                arr[i] = t;
                s(arr,depth+1,i+1);
                arr[i] = arr[start];
                arr[start] = t;
            }
        }
    }

    public int arraysToInts(int[] arr) {
        int ans = 0;
        for (int i = arr.length-1; i >= 0; i--) {
            ans = ans*10 + arr[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        MaximumSwap m = new MaximumSwap();
        System.out.println(m.maximumSwap(2736));
    }
}
