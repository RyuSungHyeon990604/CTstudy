public class CircularSentence {
    public boolean isCircularSentence(String sentence) {
        String[] split = sentence.split(" ");
        String first = split[0];
        if(split.length == 1) {
            if(first.charAt(0) == first.charAt(first.length() - 1)) {
                return true;
            }
            return false;
        }
        for (int i = 1; i < split.length; i++) {
            if(split[i].charAt(0) != split[i-1].charAt(split[i-1].length() - 1))
                return false;
            if(i == split.length - 1) {
                if(split[i].charAt(split[i].length() - 1) != first.charAt(0)){
                    return false;
                }
            }

        }
        return true;
    }
}
