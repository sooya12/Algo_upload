import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class hwstring01_서울_11반_최현수 {
	
	static int[] getPi(String pattern) {
		int[] pi = new int[pattern.length()];
		int j = 0;
		
		for (int i = 1; i < pattern.length(); i++) {
			
			while(j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
				j = pi[j - 1];
			}
			
			if(pattern.charAt(i) == pattern.charAt(j)) {
				pi[i] = ++j;
			}
		}
		return pi;
	}
	
	static int cnt = 0;
	static ArrayList<Integer> list = new ArrayList<>();
	
	static void KMP(String origin, String pattern) {
		int[] pi = getPi(pattern);
		int j = 0;
		
		for (int i = 0; i < origin.length(); i++) {
			
			while(j > 0 && origin.charAt(i) != pattern.charAt(j)) {
				j = pi[j - 1];
			}
			
			if(origin.charAt(i) == pattern.charAt(j)) {
				if(j == pattern.length() - 1) {
					cnt++;
					list.add((i - pattern.length() + 1) + 1);
					j = pi[j];
				}
				
				else 
					j++;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String origin = br.readLine();
		String pattern = br.readLine();
		
		KMP(origin, pattern);
		
		System.out.println(cnt);
		for(int l : list) {
			System.out.print(l + " ");
		}
	}
}
