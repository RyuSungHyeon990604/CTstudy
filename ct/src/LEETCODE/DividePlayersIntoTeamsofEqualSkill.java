import java.util.Arrays;

public class DividePlayersIntoTeamsofEqualSkill {
    public long dividePlayers(int[] skill) {
        long res = 0L;
        int[] arr = new int[1001];
        long totalSum =0;
        for (int i = 0; i < skill.length; i++) {
            arr[skill[i]]++;
            totalSum += skill[i];
        }

        if(totalSum % (skill.length/2) != 0) { return -1;}
        long n = totalSum / (skill.length/2);
        for (int i = 0; i < skill.length; i++) {
            if(arr[(int) (n - skill[i])] == 0)
                return -1;
            arr[(int) (n - skill[i])]--;
            res += skill[i] * (n - skill[i]);
        }
        return res/2;
    }

    public static void main(String[] args) {
        DividePlayersIntoTeamsofEqualSkill skill = new DividePlayersIntoTeamsofEqualSkill();
        skill.dividePlayers(new int[]{3,4});
    }
}
