package 프로그래머스.표병합;

import java.util.*;

public class Solution {
    int size = 50;
    String[] table = new String[size*size];
    int[] parent = new int[size*size];
    public String[] solution(String[] commands) {
        List<String> res = new ArrayList<>();
        init();
        for (int i = 0; i < commands.length; i++) {
            String[] cmd = commands[i].split(" ");
            switch (cmd[0]) {
                case "UPDATE":
                    // update 1 2 v
                    if(cmd.length == 4){
                        int convert = convertXy(Integer.parseInt(cmd[1]), Integer.parseInt(cmd[2]));
                        update(convert, cmd[3]);
                    }

                    //update v1 v2
                    if(cmd.length == 3){
                        replace(cmd[1], cmd[2]);
                    }
                    break;
                case "MERGE":
                    int mergeCvt1 = convertXy(Integer.parseInt(cmd[1]), Integer.parseInt(cmd[2]));
                    int mergeCvt2 = convertXy(Integer.parseInt(cmd[3]), Integer.parseInt(cmd[4]));
                    merge(mergeCvt1, mergeCvt2);
                    break;
                case "UNMERGE":
                    int unMergeCvt = convertXy(Integer.parseInt(cmd[1]), Integer.parseInt(cmd[2]));
                    unMerge(unMergeCvt);
                    break;
                case "PRINT":
                    int printCvt = convertXy(Integer.parseInt(cmd[1]), Integer.parseInt(cmd[2]));
                    int p = find(printCvt);
                    if(table[p] == null){
                        res.add("EMPTY");
                    }else{
                        res.add(table[p]);
                    }
                    break;
            }
        }
        String[] answer = new String[res.size()];
        for (int i = 0; i < res.size(); i++) {
            answer[i] = res.get(i);
        }
       return answer;
    }
    public void init(){
        for (int i = 0; i < size*size; i++){
            parent[i] = i;
        }
    }
    public int find(int v){
        if(parent[v] == v){
            return parent[v];
        }else{
            return parent[v] = find(parent[v]);
        }
    }
    public int convertXy(int x, int y){
        return size *(x-1) + (y-1);
    }
    public void update(int i,String v){
        table[find(i)] = v;
    }
    public void replace(String b,String a){
        for (int i = 0; i < size*size; i++){
            if(table[i]!=null && table[i].equals(b)){
                table[i] = a;
            }
        }
    }
    public void merge(int i1,int i2){
        int p1 = find(i1);
        int p2 = find(i2);
        if(p1 != p2){
            if(table[p1] != null || table[p2] == null){
                //p2의 부모를 p1으로 병합
                parent[p2] = p1;
            }else{
                //p1의 부모를 p2으로 병합
                parent[p1] = p2;
            }
        }
    }
    public void unMerge(int v){
        //최상위 부모를 찾는다
        int p = find(v);
        String value = table[p];
        List<Integer> mergedList = new ArrayList<>();
        //최상위 부모가 p인 모든 셀을 탐색
        for (int i = 0 ; i< size*size;i++){
            int vp = find(i);
            if(vp == p){
                mergedList.add(i);
            }
        }
        //모든셀을 병합해제
        for (int i = 0; i < mergedList.size(); i++){
            //병합해제
            parent[mergedList.get(i)] = mergedList.get(i);
            //값 초기화
            table[mergedList.get(i)] = null;
        }
        //v만 병합해제전의 값으로 할당
        table[v] = value;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] cmd = new String[]{"UPDATE 1 1 menu", "UPDATE 1 2 category", "UPDATE 2 1 bibimbap", "UPDATE 2 2 korean", "UPDATE 2 3 rice", "UPDATE 3 1 ramyeon", "UPDATE 3 2 korean", "UPDATE 3 3 noodle", "UPDATE 3 4 instant", "UPDATE 4 1 pasta", "UPDATE 4 2 italian", "UPDATE 4 3 noodle", "MERGE 1 2 1 3", "MERGE 1 3 1 4", "UPDATE korean hansik", "UPDATE 1 3 group", "UNMERGE 1 4", "PRINT 1 3", "PRINT 1 4"};
        System.out.println(solution.solution(cmd));
    }
}
