public class LockAndKey {
    public boolean solution(int[][] key, int[][] lock) {
        int top = Integer.MAX_VALUE,bottom = Integer.MIN_VALUE,left=Integer.MAX_VALUE,right =Integer.MIN_VALUE;
        for (int i = 0; i < lock.length; i++) {
            for (int j = 0; j < lock[i].length; j++) {
                if (lock[i][j] == 0) {
                    top = Math.min(top, i);
                    bottom = Math.max(bottom, i);
                    left = Math.min(left, j);
                    right = Math.max(right, j);
                }
            }
        }
        if(top == Integer.MAX_VALUE){//열쇠가 필요없는 자물쇠이므로 true
            return true;
        }
        int width = right - left + 1;
        int height = bottom - top + 1;
        if(key.length < height || key[0].length < width) {//자물쇠의 홈의 범위가 열쇠의 크기보다 크면 false
            return false;
        }
        int[][] newLock = new int[height][width];//필요한 부분만 잘라서 새로운 자물쇠로만든다
        for (int i = top; i <= bottom; i++) {
            for (int j = left; j <= right; j++) {
                newLock[i-top][j-left] = lock[i][j];
            }
        }

        for (int r = 0; r < 4; r++) {
            int startX = 0;
            int startY = 0;
            while(true){
                boolean isPossible = true;
                //열쇠 배열에서 width * height 크기만큼씩 탐색
                for(int i = startX; i < startX + height; i++) {
                    for(int j = startY; j < startY + width; j++) {
                        if(newLock[i-startX][j-startY] + key[i][j] != 1) {// 1 이아닌경우는 둘다 홈이거나 돌기인경우 즉, 맞지않는 부분
                            isPossible = false;
                            break;
                        }
                    }
                    if(!isPossible) {
                        break;
                    }
                }
                if(isPossible) {//맞는 부분이 존재한다면 true리턴
                    return true;
                }
                if(startX == key.length - height && startY == key[0].length - width) {
                    break;
                }
                if(startX < key.length - height) {
                    startX++;
                }else{
                    startY++;
                    startX = 0;
                }
            }
            //90도 회전
            key = rotateArray(key);
        }
        //모든 경우에 맞는 부분이없으므로 false
        return false;
    }
    public int[][] rotateArray(int[][] key) {
        int[][] copy = new int[key.length][key[0].length];
        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key[i].length; j++) {
                copy[j][key[i].length- i - 1] = key[i][j];
            }
        }
        return copy;
    }

    public static void main(String[] args) {
        LockAndKey key = new LockAndKey();
        boolean solution = key.solution(new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}, new int[][]{{1,1,1}, {1,1,1}, {1,1,1}});
        System.out.println("solution = " + solution);;
    }
}
