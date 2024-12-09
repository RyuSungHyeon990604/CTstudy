public class DeleteCharacterstoMakeFancyString {
    public String makeFancyString(String s) {
        if(s.length() < 3)
            return s;
        int freq = 1;
        StringBuilder answer = new StringBuilder();
        char[] charArray = s.toCharArray();
        char prev = charArray[0];
        answer.append(prev);
        for (int i = 1; i < charArray.length; i++) {
            if(charArray[i] == prev)
                freq++;
            else{
                prev = charArray[i];
                freq = 1;
            }
            if(freq < 3)
                answer.append(prev);

        }

        return answer.toString();
    }
}
