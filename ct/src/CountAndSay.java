public class CountAndSay {
    public String countAndSay(int n) {
        String res = seq(n);
        return res;
    }


    public String seq(int n){
        if(n == 1){
            return "1";
        }
        String res = seq(n-1);
        StringBuilder sb = new StringBuilder();
        char[] charArray = res.toCharArray();
        char preC = charArray[0];
        int count = 0;
        for (int i = 0 ; i<charArray.length; i++){
            if(charArray[i] == preC){
                count++;
                if( i+1 >= charArray.length){
                    sb.append(count);
                    sb.append(preC);
                }
            }else{
                sb.append(count);
                sb.append(preC);
                preC = charArray[i];
                count = 0;
                i--;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        CountAndSay countAndSay = new CountAndSay();
        String s = countAndSay.countAndSay(4);
        System.out.println(s);
    }
}
