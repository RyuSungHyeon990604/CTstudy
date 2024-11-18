public class DefusetheBomb {
    public int[] decrypt(int[] code, int k) {
        int[] answer = new int[code.length];
        if( k == 0) return answer;
        for (int i = 0 ; i < code.length ; i++){
           int sum = 0;
           if(k > 0){
               for(int j = i+1 ; j <= i+k ; j++){
                   sum += code[j%code.length];
               }
           }else{
               for(int j = i-1 ; j >= i+k ; j--){
                   sum += code[(j < 0 ? code.length+j : j)%code.length];
               }
           }
           answer[i] = sum;
        }
        return answer;
    }

    public static void main(String[] args) {
        DefusetheBomb d = new DefusetheBomb();
        d.decrypt(new int[]{2,4,9,3}, -2);
    }
}
