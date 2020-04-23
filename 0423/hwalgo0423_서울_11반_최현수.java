import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class hwalgo0423_서울_11반_최현수 {

	static int N;
	static int L;
	static int R;
	static int[][] A;
	static boolean[][] v;
	
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // N^2의 나라들
		L = Integer.parseInt(st.nextToken()); // 인구 차이 최솟값
		R = Integer.parseInt(st.nextToken()); // 인구 차이 최댓값

		A = new int[N][N]; // 나라별 인구를 나타낸 배열

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		
		int result = 0;
		
		while(true) {
			boolean flag = false;
			v = new boolean[N][N];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(!v[i][j] && check(i, j) > 1) {
						flag = true;
					}
				}
			}
			
			if(flag) 
				result++;
			else 
				break;
		}
		
		System.out.println(result);

	} // end of main

	private static int check(int r, int c) {
		ArrayList<int[]> list = new ArrayList<>();
		Queue<int[]> q = new LinkedList<>();
		
		q.add(new int[] {r, c});
		list.add(new int[] {r, c});
		
		v[r][c] = true;
		
		int sum = A[r][c];
		
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			
			int tr = tmp[0];
			int tc = tmp[1];
			
			for (int i = 0; i < dr.length; i++) {
				int nr = tr + dr[i];
				int nc = tc + dc[i];
				
				if(nr >= 0 && nr < N && nc >= 0 && nc < N && !v[nr][nc]
						&& Math.abs(A[tr][tc] - A[nr][nc]) >= L 
						&& Math.abs(A[tr][tc] - A[nr][nc]) <= R) {
					
					q.add(new int[] {nr, nc});
					list.add(new int[] {nr, nc});
					
					sum += A[nr][nc];
					v[nr][nc] = true;
				}
			}		
		}
		
		if(list.size() != 1) {
			int val = sum / list.size();
			
			for (int i = 0; i < list.size(); i++) {
				A[list.get(i)[0]][list.get(i)[1]] = val;
			}
		}
		
		return list.size();
	}
	
	
}
