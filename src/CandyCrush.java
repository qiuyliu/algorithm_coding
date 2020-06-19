public class CandyCrush {
	

	public static String candyCrushed(String s) {
		StringBuilder stack = new StringBuilder();
		//Stack<Character> stack = new Stack<>();
		stack.append(new Candy(s.charAt(0)));
		//int count = 1;
		for (int i = 1; i < s.length(); i++) {
			char cur = s.charAt(i);
			char prev = stack.length() == 0 ? ' ' :stack.charAt(stack.length() - 1);
			Candy candy_cur = new Candy(cur);
			Candy candy_pre = new Candy(prev);
			if (cur != prev) { 
				if (candy_cur.count >= 3 && cur != prev) {
					while (stack.length() > 0 && stack.charAt(stack.length() - 1) == prev) {
						stack.setLength(stack.length() - 1);
					}
				} 
				//candy_cur.count = 1;
			} else {
				
				candy_pre.count++;
			}
			stack.append(candy_cur);
			
		}		
		
		return stack.toString();
	}
	
	public static void main(String[] args) {
		//String s = "aabbbacccd";
		//String cc = candyCrushed(s);
		System.out.println(candyCrushed("aabbbacd"));
		//System.out.println(candyCrushed("abced"));
	}
	

}
class Candy {
	char value;
	int count;
	Candy(char c) {
		value = c;
	}
}
