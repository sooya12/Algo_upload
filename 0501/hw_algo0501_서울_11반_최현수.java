import java.util.ArrayList;
import java.util.Scanner;

public class hw_algo0501_서울_11반_최현수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			String input2 = sc.next();
			String input3 = sc.next();
			
			ArrayList<Long> list2 = new ArrayList<>();
			ArrayList<Long> list3 = new ArrayList<>();
			
			String tmp2;
			String tmp3;
			String front, back;
			
			for (int i = 0; i < input2.length(); i++) {
				tmp2 = "";
				front = input2.substring(0, i);
				back = input2.substring(i+1);
				tmp2 += front;
				tmp2 += (1 - Integer.parseInt(input2.substring(i, i+1)));
				tmp2 += back;
				
				list2.add(Long.parseLong(tmp2, 2));
			}
			
			for (int i = 0; i < input3.length(); i++) {
				tmp3 = "";
				front = input3.substring(0, i);
				back = input3.substring(i+1);
				tmp3 += front;
				tmp3 += ((Integer.parseInt(input3.substring(i, i+1)) + 1) % 3);
				tmp3 += back;
				
				list3.add(Long.parseLong(tmp3, 3));
				
				tmp3 = "";
				tmp3 += front;
				tmp3 += ((Integer.parseInt(input3.substring(i, i+1)) + 2) % 3);
				tmp3 += back;
				
				list3.add(Long.parseLong(tmp3, 3));
			}
			
			boolean turn = true;
			
			for (int i = 0; i < list2.size(); i++) {
				for (int j = 0; j < list3.size(); j++) {
					if(list2.get(i).equals(list3.get(j))) {
						System.out.println("#" + tc + " " + list2.get(i));
						turn = false;
						break;
					}
				}
				
				if(!turn) break;
			}
		}
	}
}
