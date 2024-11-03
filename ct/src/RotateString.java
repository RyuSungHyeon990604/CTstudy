import java.util.Arrays;

public class RotateString {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()) return false;
        for (int i = 0; i < s.length(); i++) {
            String sub = s.substring(i);
            if(goal.startsWith(sub)) {
                if(goal.substring(goal.length()-i).equals(s.substring(0,i))) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        RotateString rs = new RotateString();
        boolean b = rs.rotateString("gcmbf", "fgcmb");
        System.out.println(b);
    }
}
