import java.util.Arrays;

public class RotateString {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()) return false;
        String str = s+s;
        if(str.contains(goal)) return true;
        return false;
    }

    public static void main(String[] args) {
        RotateString rs = new RotateString();
        boolean b = rs.rotateString("gcmbf", "fgcmb");
        System.out.println(b);
    }
}
