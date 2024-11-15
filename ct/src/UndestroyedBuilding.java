public class UndestroyedBuilding {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int[][] map =  new int[board.length+1][board[0].length+1];
        for(int[] sk : skill){
            int degree = sk[0] == 1? -sk[5] : sk[5];
            map[sk[1]][sk[2]] = map[sk[1]][sk[2]] + degree;
            map[sk[3]+1][sk[4]+1] = map[sk[3]+1][sk[4]+1] + degree;
            map[sk[1]][sk[4]+1] = map[sk[1]][sk[4]+1] - degree;
            map[sk[3]+1][sk[2]] = map[sk[3]+1][sk[2]] - degree;
        }
        for(int j = 0; j <map.length ; j++){
            for(int i = 0; i < map[0].length;i++){
                if(i > 0){
                    map[j][i] = map[j][i] + map[j][i-1];
                }
            }
        }

        for(int i = 0 ; i < map[0].length-1 ; i++){
            for(int j = 0; j < map.length-1;j++){
                if(j>0)
                    map[j][i] = map[j][i] + map[j-1][i];
                if(map[j][i] + board[j][i] > 0)
                    answer++;
            }
        }
        return answer;
    }
}
