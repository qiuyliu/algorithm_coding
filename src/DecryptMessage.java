public class DecryptMessage{
    public String decrypt(String word) {
        // your code goes here
        if (word == null || word.length() == 0) {
            return word;
          }
        /*
        en[i] = de[i] + step2[i - 1] - 26*m
        de[i] = en[i] - step2[i - 1] + 26*m
        de[1] = en[1] - en[0] + 26 * m
        */
        
        char[] chars = word.toCharArray();
        int[] en = new int[chars.length];
        for (int i = 0; i < en.length; i++) {
            en[i] = (int) chars[i];
        }
        int[] de = new int[chars.length];
        int[] step2 = new int[chars.length];
        step2[0] = en[0];
        int j = 0;
        while (j < en.length) {
            if (j == 0) {
                de[j] = en[j] - 1;
            } else {
                de[j] = en[j] - step2[j - 1];
                while (de[j] < 97) {
                    de[j] += 26;
                }
                step2[j] = (step2[j - 1] + de[j]) % 26;
            }
            j++;
        }
        char[] res = new char[de.length];
        for (int i  = 0; i < res.length; i++) {
            res[i] = (char)de[i];
        }
        return String.valueOf(res);
      }
    
      public static void main(String[] args) {
        DecryptMessage sol = new DecryptMessage();
        String word = "flgxswdliefy";
        //String word = "dnotq";
        System.out.println(sol.decrypt(word));
      }
}