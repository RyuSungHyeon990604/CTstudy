public class JumpAndTeleportation {
    public int solution(int n) {
        int ans = 0;

        while (n > 0) {
            if (n % 2 == 0) {
                n /= 2;
            }else{
                n--;
                ans++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        JumpAndTeleportation jumpAndTeleportation = new JumpAndTeleportation();
        System.out.println(jumpAndTeleportation.solution(5));
    }
}
