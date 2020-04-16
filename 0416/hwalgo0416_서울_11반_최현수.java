import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class hwalgo0416_서울_11반_최현수 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine()); // 계단의 개수
		int[] stairs = new int[n+1];
		int[] f = new int[n+1];
		
		for (int i = 1; i < stairs.length; i++) {
			stairs[i] = Integer.parseInt(br.readLine()); // 각 계단의 점수
		}
		
		f[1] = stairs[1];
		if(n > 1) f[2] = stairs[1] + stairs[2];
		
		for (int i = 3; i < f.length; i++) {
			f[i] = Math.max(stairs[i-1] + f[i-3], f[i-2]) + stairs[i];
		}
		
		System.out.println(f[n]);
	}
	
}
