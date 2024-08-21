public class WordMatch {
    private String word;
    public WordMatch(String in) {
        word = in;
    }
    // scoreGuess finds the number of times that guess occurs as a substring
    // of secret and then multiplies that number by the square of the length of guess.
    // Occurrences of guess may overlap within secret.
    public int scoreGuess(String input) {
        if (input.isEmpty()) {throw new IllegalArgumentException("Your guess cannot be an empty String!");}
        if (input.length() > word.length()) {throw new IllegalArgumentException("Your guess cannot exceed the number of characters in the Secret word");}
        int occurrences = 0;
        if (!(word.contains(input))) {return 0;}
        for (int i = 0; i + input.length() <= word.length(); i++) {
            if (input.equals(word.substring(i, i+input.length()))) {
                occurrences++;
            }
        }
        return occurrences * (input.length()*input.length());
    }

    public String findBetterGuess(String a, String b) {
        int word1 = scoreGuess(a);
        int word2 = scoreGuess(b);
        if (word1 < word2) {
            return b;
        }
        else if (word1 > word2) {return a;}
        if (a.length()>b.length()) {
            for (int i = 0; i < b.length(); i++) {
                if ( ((int) a.charAt(i)) < ((int) b.charAt(i))) {
                    return b;
                }
                else if (((int) a.charAt(i)) > ((int) b.charAt(i))) {
                    return a;
                }
            }
        }
        else {
            for (int i = 0; i < a.length(); i++) {
                if ( ((int) a.charAt(i)) < ((int) b.charAt(i))) {
                    return b;
                }
                else if (((int) a.charAt(i)) > ((int) b.charAt(i))) {
                    return a;
                }
            }
        }
        return a;
    }
}
