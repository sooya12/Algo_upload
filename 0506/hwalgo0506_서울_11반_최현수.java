import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class hwalgo0506_서울_11반_최현수 {
	
	static int[] team1 = {0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 3, 3, 4};
	static int[] team2 = {1, 2, 3, 4, 5, 2, 3, 4, 5, 3, 4, 5, 4, 5, 5};
	
	static int[] win = new int[6];
	static int[] draw = new int[6];
	static int[] lose = new int[6];
	
	static boolean check;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int tc = 0; tc < 4; tc++) { // 주어진 네 가지 결과
			st = new StringTokenizer(br.readLine(), " ");
			
			int sumWin = 0;
			int sumDraw = 0;
			int sumLose = 0;
			
			check = false;
			
			for (int i = 0; i < 6; i++) {
				win[i] = Integer.parseInt(st.nextToken());
				draw[i] = Integer.parseInt(st.nextToken());
				lose[i] = Integer.parseInt(st.nextToken());
				
				sumWin += win[i];
				sumDraw += draw[i];
				sumLose += lose[i];
			}
			
			if(sumWin + sumDraw + sumLose != 30) {
				check = false;
			
			} else {
				game(0);
			}
			
			sb.append((check ? 1 : 0) + " ");
		}
		
		System.out.println(sb);
	}

	private static void game(int x) {
		if(check) return;
		
		if(x == 15) {
			check = true;
			return;
		}
		
		int t1 = team1[x];
		int t2 = team2[x];
		
		if(win[t1] > 0 && lose[t2] > 0) {
			win[t1]--;
			lose[t2]--;
			
			game(x+1);
			
			win[t1]++;
			lose[t2]++;
		}
		
		if(lose[t1] > 0 && win[t2] > 0) {
			lose[t1]--;
			win[t2]--;
			
			game(x+1);
			
			lose[t1]++;
			win[t2]++;
		}
		
		if(draw[t1] > 0 && draw[t2] > 0) {
			draw[t1]--;
			draw[t2]--;
			
			game(x+1);
			
			draw[t1]++;
			draw[t2]++;
		}
	}
}
