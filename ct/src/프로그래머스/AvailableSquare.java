public class AvailableSquare {
    //w, h 인 사각형에서 대각선을 그엇을때 없어지는 사각형이 왜 w+ h - gcd(w,h)인가?
    //w = 2, h =3 이라 해보자
    //대각선은 무조건 한방향으로 이동한다
    // 즉 우측 아래에서 죄측상단으로 이동한다면
    // 없어지는 사각형은 현재 대각선에서 좌측 또는 상단 둘중 하나의 사각형이 없어지게된다
    // 결국 없어지는 사각형을 모두 한곳으로 밀어서 시각화 해본다면 ㄱ,ㄴ의 모양이 나타난다
    // 따라서 w+ h -1 개의 사각형이 사라진다.
    // 왜 -1 ==> -gcd(w,h) 를 해야할까?
    // 2와3의 경우에는 -1을 해도 상관없었지만 w = 6 h =4라고해보자
    // 대각선이 정확히 (3,2)를 지나면서 이 구간에서는 어떤 사각형도 없애지않게된다
    // 때문에 사각형의 w,h를 서로소가 되도록 만들어야한다
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
