public class JumpAndTeleportation {
    public int solution(int n) {
        return Integer.bitCount(n);
    }

    public static void main(String[] args) {
        JumpAndTeleportation jumpAndTeleportation = new JumpAndTeleportation();
        System.out.println(jumpAndTeleportation.solution(5));
    }
}
