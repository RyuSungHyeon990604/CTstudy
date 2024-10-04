import java.util.Arrays;

public class DividePlayersIntoTeamsofEqualSkill {
    public long dividePlayers(int[] skill) {
        long res = 0L;
        Arrays.sort(skill);
        int r = skill.length - 1, l = 0;
        int chk = skill[r] + skill[l];
        while (l<r) {
            if (chk != skill[l] + skill[r]) {
                return -1;
            }else{
                res += skill[l] * skill[r];
            }
            l++;
            r--;
        }

        return res;
    }
}
