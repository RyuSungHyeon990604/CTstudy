public class RotatingtheBox {
    public char[][] rotateTheBox(char[][] box) {
        pushToRight(box);
        return rotate(box);
    }
    public void pushToRight(char[][] box){
        int m  = box.length;
        int n = box[0].length;
        for(int i = n-1 ; i>= 0 ;i--){
            for(int j = m-1 ; j>=0;j--){
                if(box[j][i] == '#'){
                    box[j][i] = '.';
                    int t = i;
                    while(t+1 < n && box[j][t+1] != '*' && box[j][t+1] != '#'){
                        t++;
                    }
                    box[j][t] = '#';
                }
            }
        }
    }
    public char[][] rotate(char[][] box){
        int m  = box.length;
        int n = box[0].length;
        char[][] answer = new char[n][m];
        for(int i =0 ; i < n ;i++){
            for(int j = 0 ; j < m ;j++){
                answer[i][j] = box[m-1-j][i];
            }
        }
        return answer;
    }
}
