package swea;

import java.util.Scanner;

public class Solution_1861_정사각형방 {
	
	static int max = 0;
	static int maxIdx = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt(); // 테스트케이스 수
		
		for (int testCase = 1; testCase <= t; testCase++) {
			int n = sc.nextInt(); // 방 크기 
			
			int[][] arr = new int[n][n];
			
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[i].length; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			max = 0; // 최대 이동 방 개수
			maxIdx = 0; // 최대 이동 방 개수의 시작점 값
			
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[i].length; j++) {
					move(arr, i, j, arr[i][j], 1, arr[i][j]);
					
				}
			}
			
			System.out.println("#" + testCase + " " + maxIdx + " " + max);
		}
	}
	
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	
	static void move(int[][] arr, int r, int c, int forward, int cnt, int start) {
		for (int i = 0; i < dy.length; i++) {
			if(r + dy[i] < 0 || r + dy[i] > arr.length - 1 
								|| c + dx[i] < 0 || c + dx[i] > arr[0].length - 1) continue;
			
			if(arr[r+dy[i]][c+dx[i]] == (arr[r][c] + 1)) { // 이동할 수 있는 경우
				cnt++;
				
				move(arr, r + dy[i], c + dx[i], arr[r+dy[i]][c+dx[i]], cnt, start);
			} 
		}
		
		if(cnt == 1) return; // 이동하지 못하였으면 종료
		
		if(max == cnt && (maxIdx == 0 || maxIdx > start)) { // 이동 값이 같은데, 시작위치 값이 작은 경우
				max = cnt;
				maxIdx = start;
		} else if (max < cnt) { // 이동 값이 큰 경우
			max = cnt;
			maxIdx = start;
		}
	}
}
