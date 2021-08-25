
public class StringShuffle {

    public String stringShuffle(String input) {
        if (input == null || input.length() < 1) {
            return null;
        }
        int l = 0, r = input.length()-1;
        char[] chars = input.toCharArray();
        convert(chars, l, r);
        return new String(chars);
    }

    private void convert(char[] chars, int l, int r) {
        if (r - l <= 1) {
            return ;
        }
        int size = r - l + 1;
        int mid = l + size / 2;
        int lmid = l + size / 4;
        int rmid = l + size * 3/4;
        
        reverse(chars, lmid, mid-1);
        reverse(chars, mid, rmid-1);
        reverse(chars, lmid, rmid-1);

        convert(chars, l, l+2*(lmid-l)-1);
        convert(chars, l+2*(lmid-l), r);
    }

    private void reverse(char[] c, int l, int r) {
        if (l >= r) {
            return ;
        }
        char temp = c[l];
        c[l] = c[r];
        c[r] = temp;
        reverse(c, l+1, r-1);
    }
    public static void main(String[] args) {
        String input = "ABCD1234";
        StringShuffle sol = new StringShuffle();
        System.out.println(sol.stringShuffle(input));
    }
}