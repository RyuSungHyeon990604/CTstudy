public class AvailableSquare {
    public long solution(int w, int h) {
        long answer = 0;
        long n = w * h;

        return n+(w+h-gcd(w,h));
    }
    public long gcd(long a,long b){
        if(b == 0)
            return a;
        else
           return gcd(b,a%b);
    }

    public static void main(String[] args) {
        AvailableSquare s = new AvailableSquare();
        s.solution(100000000, 999999999);
    }
}
