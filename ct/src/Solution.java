import com.sun.source.tree.Tree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    boolean answer = false;
    public boolean solution(int[][] map,int[] ent){
        int x = ent[0];
        int y = ent[1];

        int[][] tmp = map.clone();
        isCan(tmp,x,y,1);

        tmp = map.clone();
        isCan(tmp,x,y,2);

        return answer;
    }

    public void isCan(int[][] map,  int x ,int y,int flag){//flag : 1 ==> up,down /2 : left right
        if(x > map.length-1 ||x < 0 ||  y > map[0].length-1 || y<0  || map[x][y] ==8|| map[x][y] == 0){
            return;
        }
        if(map[x][y] == 7 ){
           answer = true;
           return;
        }


        if(flag == 1){
            isCan(map,x+map[x][y],y,2);
            isCan(map,x-map[x][y],y,2);
        }
        if(flag == 2){
            isCan(map,x,y+map[x][y],1);
            isCan(map,x,y-map[x][y],1);
        }





    }

    public int solve(int[] cus, int[] model, int[] cost) {
        int answer = 0;
        TreeMap<Double, Integer> modelAndCost = new TreeMap<>();

        for (int i = 0; i < model.length; i++) {
            modelAndCost.put((double) (model[i]/cost[i]),i);
        }
        int[] ans =new int[cus.length];
        Arrays.fill(ans, Integer.MAX_VALUE);
        for (int i = 0; i < cus.length; i++) {
            ba(cus[i],  model, cost,modelAndCost,0, ans,i);
        }
        for (int i = 0; i < ans.length; i++) {
            answer+=ans[i];
        }
        return answer;
    }

    public void ba(int cus, int[] model, int[] c,TreeMap<Double, Integer> modelAndCost, int cost, int[] ans, int index){
        if(cus <= 0){
            ans[index] = Math.min(ans[index],cost);
            return;
        }
        double v = modelAndCost.lastKey();
        int i = modelAndCost.get(modelAndCost.lastKey());
        ba(cus-model[i], model,c,modelAndCost,cost + c[i],ans,index);
        if(cus-model[i] < 0){

            while(cus-model[i] <= 0 && modelAndCost.lowerKey(v) != null){
                v = modelAndCost.lowerKey(v);
                int j = modelAndCost.get(v);
                ba(cus-model[j], model,c,modelAndCost,cost + c[j],ans,index);
            }
        }

    }

    public static void main(String[] args) {
//        Solution solution = new Solution();
        //boolean solution1 = solution.solution(new int[][]{{1, 2, 3, 2, 1}, {4, 2, 0, 7, 1}, {1, 3, 2, 8, 1}, {2, 0, 1, 1, 1}, {8, 2, 1, 2, 1}}, new int[]{4, 3});
//        int solve = solution.solve(new int[]{10000,10,20,30,40,50,60,70,80,90,100,110,120,130,140,150,160,170,180,190,200,210,220,230}, new int[]{7,1,9}, new int[]{9,1,1});
//        System.out.println(solve);
        int[] arr = new int[]{1,2,3,4};



    }
}
