public class DeleteCharacterstoMakeFancyString {
    public String makeFancyString(String s) {
        if(s.length() < 3)
            return s;
        StringBuilder answer = new StringBuilder();
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length-2; i++) {
            if(charArray[i] == charArray[i+1] && charArray[i+2] == charArray[i] ) {
                continue;
            }
            answer.append(charArray[i]);
        }
        answer.append(charArray[charArray.length-2]);
        answer.append(charArray[charArray.length-1]);
        return answer.toString();
    }
}
