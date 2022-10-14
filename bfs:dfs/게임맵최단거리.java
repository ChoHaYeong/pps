// import java.util.*;

// class Solution {
    
//     static int[][] dist;
//     static boolean[][] visited;
//     static int N, M;
//     static int[] dx = {-1 , 0, 1 ,0};
//     static int[] dy = {0 ,-1, 0, 1};
//     static boolean flag = false;
//     public int solution(int[][] maps) {
//         int answer = 0;
//         N = maps.length;
//         M = maps[0].length;
        
//         dist = new int[N][M];
//         visited = new boolean[N][M];
//         bfs(0, 0, maps);
//         if(flag){
//             answer = dist[N-1][M-1] + 1;
//             return answer;
//         }
//         else {
//             return -1;
//         }
//     }
    
//     static void bfs(int x, int y, int[][] maps) {
//         Queue<Position> q = new LinkedList<>();
//         q.add(new Position(x, y));
//         visited[x][y] = true;
        
//         while(!q.isEmpty()) {
//             Position out = q.poll();
//             for(int i=0; i<4; i++) {
//                 int nx = out.x + dx[i];
//                 int ny = out.y + dy[i];
                
//                 if(nx<0 || ny<0 || nx >= N || ny >=M) continue;
//                 else if(visited[nx][ny] || maps[nx][ny] == 0) continue;
//                 else {
//                     if(nx == N-1 && ny == M-1)
//                         flag = true;
                    
//                     q.add(new Position(nx, ny));
//                     visited[nx][ny] = true;
//                     dist[nx][ny] = dist[out.x][out.y] + 1;
//                 }
//             }
//         }
        
        
//     }
// }