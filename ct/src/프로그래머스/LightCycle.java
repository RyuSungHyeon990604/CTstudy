import java.util.*;

public class LightCycle {
    final String LEFT = "left";
    final String UP = "up";
    final String DOWN = "down";
    final String RIGHT = "right";
    public int[] solution(String[] grid) {
        int[] answer = new int[]{};
        List<Integer> ans = new ArrayList<>();
        String[] directions = new String[]{LEFT, UP, DOWN, RIGHT};
        char[][] m = new char[grid.length][grid[0].length()];
        Set<String> set = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            m[i] = grid[i].toCharArray();
        }
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
               for (int d = 0; d < directions.length; d++) {
                   s.append(i);
                   s.append('/');
                   s.append(j);
                   s.append(directions[d]);
                   if(set.add(s.toString())) {
                       int x = i;
                       int y = j;
                       String direction = directions[d];
                       int len = 0;
                        while(true){
                            len++;
                            char c = m[x][y];
                            switch (direction) {
                                case LEFT:
                                    if(c == 'S'){
                                        y--;
                                        direction = LEFT;
                                    }else if(c == 'L'){
                                        x++;
                                        direction = DOWN;
                                    }else if(c =='R'){
                                        x--;
                                        direction = UP;
                                    }
                                    break;
                                case UP:
                                    if(c == 'S'){
                                        x--;
                                        direction = UP;
                                    }else if(c == 'L'){
                                        y--;
                                        direction = LEFT;
                                    }else if(c =='R'){
                                        y++;
                                        direction = RIGHT;
                                    }
                                    break;
                                case DOWN:
                                    if(c == 'S'){
                                        x++;
                                        direction = DOWN;
                                    }else if(c == 'L'){
                                        y++;
                                        direction = RIGHT;
                                    }else if(c =='R'){
                                        y--;
                                        direction = LEFT;
                                    }
                                    break;
                                case RIGHT:
                                    if(c == 'S'){
                                        y++;
                                        direction = RIGHT;
                                    }else if(c == 'L'){
                                        x--;
                                        direction = UP;
                                    }else if(c =='R'){
                                        x++;
                                        direction = DOWN;
                                    }
                                    break;
                                default:
                                    break;
                            }
                            if(x> m.length-1){
                                x = 0;
                            }
                            if(x< 0){
                                x = m.length-1;
                            }
                            if(y > m[0].length-1){
                                y = 0;
                            }
                            if(y < 0){
                                y =m[0].length-1;
                            }
                            StringBuilder st = new StringBuilder();
                            st.append(x);
                            st.append('/');
                            st.append(y);
                            st.append(direction);
                            if(!set.add(st.toString())){
                                ans.add(len);
                                break;
                            }
                        }
                   }
                   s.setLength(0);
               }
            }
        }
        Collections.sort(ans);
        answer = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            answer[i] = ans.get(i);
        }
        return answer;
    }


    public static void main(String[] args) {
        LightCycle c = new LightCycle();
        c.solution(new String[]{"R", "R"});
    }
}
