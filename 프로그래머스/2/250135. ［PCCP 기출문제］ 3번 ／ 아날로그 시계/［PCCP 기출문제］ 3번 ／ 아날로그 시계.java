class Solution {
    // 시침 : 분침 : 초침  =  1 : 60 : 3600
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int answer = 0;
        int diff = diffParseSec(h1,m1,s1,h2,m2,s2);
        double hh = parseSec(h1,m1,s1);
        double mm = parseSec(m1,s1);
        double ss = s1;
        double h = locationH(hh);
        double m = locationM(mm);
        double s = locationS(s1);
        if(s==m || s==h){
            answer += 1;
        }
        for (int i = 0 ;i < diff ;i++) {
            double nextH = locationH(hh+1);
            double nextM = locationM(mm+1);
            double nextS = locationS(ss+1);
            if((s < h && nextS >= nextH) || (nextS == 0 && s < h)){
                answer++;
            }
            if ((s < m && nextS>= nextM) || (nextS == 0 && s < m)) {
                answer++;
            }
            if (nextH == nextM && nextS ==  nextM) {
                answer--;
            }
            s = nextS;
            h = nextH;
            m = nextM;
            hh +=1;
            mm +=1;
            ss +=1;
        }
        return answer;
    }
    public double locationH(double sec){
        return ((360.0/ 43200) * sec) % 360;
    }
    public double locationM(double sec){
        return ((360.0 / 3600) * sec) % 360;
    }
    public double locationS(double sec){
        return (6 * sec)%360;
    }
    public double parseSec(int h,int m,int s){
        return s + m*60 + h*3600;
    }
    public double parseSec(int m,int s){
        return  s + m*60;
    }




    public int diffParseSec(int h1, int m1, int s1, int h2, int m2, int s2) {
        int t1 = s1+ m1*60 + h1*3600;
        int t2 = s2+ m2*60 + h2*3600;

        return t2 - t1;
    }

}