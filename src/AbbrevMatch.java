public class AbbrevMatch {
    public boolean match (String input, String pattern) {
        // Write your solution here
        return match(input, pattern, 0, 0);
            
        }

    private boolean match(String input, String pattern, int i, int p) {
        // base case
        if (i == input.length() && p == pattern.length()) {
            return true;
        }
        if (i >= input.length() || p >= pattern.length()) {
            return false;
        }

        //recursion condition
        if (Character.isLetter(pattern.charAt(p))) {
            if (input.charAt(i) != pattern.charAt(p)) {
                return false;
            } else {
                return match(input, pattern, i + 1, p + 1);
            }
        }

        int count = 0;
        while (p < pattern.length() && Character.isDigit(pattern.charAt(p))) {
            count = count * 10 + (pattern.charAt(p) - '0');
            p++;
        }
        if (count > input.length()) {
            return false;
        } else {
            return match(input, pattern, count + i, p);
        }            
    }
    public static void main(String[] args) {
        AbbrevMatch sol = new AbbrevMatch();
        String input = "soood";
        String pattern = "s111d";
        System.out.println(sol.match(input, pattern));
    }

}