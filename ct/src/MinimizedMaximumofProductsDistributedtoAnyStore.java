public class MinimizedMaximumofProductsDistributedtoAnyStore {
    public int minimizedMaximum(int n, int[] quantities) {
        int left = 1 ,right = Integer.MAX_VALUE;
        int answer = 0;
        if(quantities.length == 1)
            return n >quantities.length ? 1 : quantities[0] / n;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(getStores(quantities,mid,n) <= n){
                right = mid - 1;
                answer = mid;
            }else{
                left = mid + 1;
            }
        }
        return answer;
    }

    //n개씩 물건을 넣을때 상점이 몇개가 필요한가?
    public int getStores(int[] quantities,int n,int limit){
        int c = 0;
        for(int i = 0 ; i < quantities.length;i++){
            int t= quantities[i];
            c+=(t+n-1)/n;
            if(c > limit)
                return c;
        }
        return c;
    }

    public static void main(String[] args) {
        MinimizedMaximumofProductsDistributedtoAnyStore m = new MinimizedMaximumofProductsDistributedtoAnyStore();
        m.minimizedMaximum(7,new int[]{15,10,10});
    }
}
