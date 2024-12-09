public class CircularSentence {
    public boolean isCircularSentence(String sentence) {
        if(sentence.isEmpty())
            return true;
        if(sentence.charAt(0) != sentence.charAt(sentence.length()-1)) {
            return false;
        }
        int i = sentence.indexOf(" ");
        while(i != -1) {
            if(sentence.charAt(i-1) != sentence.charAt(i+1)) {
                return false;
            }
            i = sentence.indexOf(" ", i+1);
        }

        return true;
    }
}
