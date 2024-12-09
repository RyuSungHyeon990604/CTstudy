import java.util.ArrayList;
import java.util.List;

public class QuadTree {

    int[] zOrderArr;
    int index = 0;
    public int[] solution(int[][] arr) {
        int[] answer = {0,0};
        zOrderArr = new int[arr.length*arr[0].length];
        int n = (int) (Math.log(arr.length) / Math.log(2));

        zOrderCurve(arr,0,0,n);
        compress(zOrderArr,0,zOrderArr.length,answer);

        return answer;
    }

    public void zOrderCurve(int [][]arr,int row,int col,int n){
        if(n == 0){
            zOrderArr[index++] = arr[row][col];
            return;
        }
        zOrderCurve(arr,row,col,n-1);
        zOrderCurve(arr,row,col+(int) Math.pow(2,n-1),n-1);
        zOrderCurve(arr, row+(int) Math.pow(2,n-1),col,n-1);
        zOrderCurve(arr,row+(int) Math.pow(2,n-1),col+(int) Math.pow(2,n-1),n-1);

    }

    public void compress(int[] arr,int start,int len,int[] answer){
        if(canCompress(arr,start,len,arr[start])){
            answer[arr[start]]++;
            return;
        }else{
            compress(arr,start,len/4,answer);
            compress(arr,start+len/4,len/4,answer);
            compress(arr,start+(len/4)*2,len/4,answer);
            compress(arr,start+(len/4)*3,len/4,answer);
        }
    }

    public boolean canCompress(int[] arr,int start,int len,int v){
        for(int j=start;j < start + len;j++){
            if(arr[j]!=v){
                return false;
            }
        }
        return true;
    }
}
