public class GcdLcm {
    public int[] solution(int n, int m) {
        int g = gcd(n,m);
        int[] answer = {g,n*m/g};

        return answer;
    }

    public int gcd(int a ,int b){
        if(b == 0) return a;
        else return gcd(b, a % b);
    }
}
