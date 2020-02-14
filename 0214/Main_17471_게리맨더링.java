package beakjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main_17471_게리맨더링 {
	
	static int min = Integer.MAX_VALUE; // 구역 간 인구 수 차이 중 최솟값 
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); // 구역의 개수
		int[] popul = new int[n+1]; // 구역의 인구 수
		
		for (int i = 1; i < popul.length; i++) {
			popul[i] = sc.nextInt();
		}
		
		int[][] adj = new int[n+1][n+1];
		int input; // 인접한 구역의 개수
		
		for (int i = 1; i < adj.length; i++) {
			input = sc.nextInt();
			
			for (int j = 0; j < input; j++) {
				adj[i][sc.nextInt()] = 1;
			}
		}
		
//		for (int i = 0; i < adj.length; i++) {
//			System.out.println(Arrays.toString(adj[i]));
//		}
		
		for (int i = 1; i <= n; i++) {
			boolean[] visited = new boolean[n+1];
			link(adj, i, 0, visited, 0, popul);
		}
		
		if(min == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(min);
		
	}
	
	public static void link(int[][] adj, int idx, int sum, boolean[] visited, int cnt, int[] popul) {
		if(cnt > adj.length - 2) return;
		
		boolean[] copyVisited = new boolean[visited.length];
		
		for (int i = 1; i < adj[idx].length; i++) {
			if(adj[idx][i] == 1 && !visited[i]) {
				
				System.arraycopy(visited, 0, copyVisited, 0, visited.length);
				copyVisited[i] = true;
				
				link(adj, i, sum + popul[i], copyVisited, cnt + 1, popul);
			}
		}
		
		int[] other = new int[adj.length - 1 - cnt];
		
		if(other.length > adj.length - 2) return;
		
		int k = 0;
		int otherSum = 0;
		
		for (int i = 1; i < visited.length; i++) {
			if(!visited[i]) {
				other[k++] = i;
				otherSum += popul[i];
			}
		}
		
		boolean[] check = new boolean[other.length];
		
		for (int i = 0; i < other.length; i++) {
			for (int j = 0; j < other.length; j++) {
				if(adj[other[j]][other[i]] == 1) {
					check[i] = true;
					break;
				}
			}
		}
		
		boolean turn = true;
		
		for (int i = 0; i < check.length; i++) {
			if(!check[i]) {
				turn = false;
				break;
			}
		}
	
		if(!turn) return;
		
		
		System.out.println(sum + " " + otherSum + " " + Math.abs(sum - otherSum));
		min = Math.min(min, Math.abs(sum - otherSum));
	}
	
}
