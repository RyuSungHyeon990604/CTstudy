public class StringCompressionIII {
    public String compressedString(String word) {
        char[] arr = word.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            char c =arr[i];
            int count = 0;
            while(i < arr.length && c == arr[i] ) {
                count++;
                i++;
            }
            while(count > 9){
                sb.append(9).append(c);
                count -= 9;
            }
            sb.append(count).append(c);

        }
        return sb.toString();
    }

    public static void main(String[] args) {
        StringCompressionIII s = new StringCompressionIII();
        String s1 = s.compressedString("cccccccccc");
        System.out.println("s1 = " + s1);
    }
}
