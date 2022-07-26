// import java.util.*;
// import java.io.*;

// public class BOJ11725 {

//     static int N;
//     static boolean[] visited;
//     static int[][] tree;
//     static int[] arr;
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st = new StringTokenizer(br.readLine());
//         N = Integer.parseInt(st.nextToken());  //전체 사람 수
        
//         visited = new boolean[N];
//         tree = new int[N][N];
//         arr = new int[N];

//         for(int i=0; i<N-1; i++) {
//             st = new StringTokenizer(br.readLine());
//             int x = Integer.parseInt(st.nextToken()); 
//             int y = Integer.parseInt(st.nextToken()); 
//             tree[x-1][y-1] = 1;
//             tree[y-1][x-1] = 1;
//         }

//         dfs(0);

//         for(int i=1; i<N; i++) {
//             System.out.println(arr[i]+1);
//         }
//     }

//     static void dfs(int curr) {
//         Stack<Integer> s = new Stack<>();

//         s.push(curr);
//         visited[curr] = true;

//         while(!s.isEmpty()) {
//             int out = s.pop();

//             for(int i=0; i<N; i++) {
//                 if(!visited[i] && tree[out][i] == 1) {
//                    // System.out.println("부모 " + out + " 자식 " + i);
//                     visited[i] = true;
//                     s.push(i);
//                     arr[i] = out;
//                 }
//             }

//         }
//     }
    
// }

// ==========================> 메모리 초과남 
// 노드의 개수가 100,000개까지 가질 수 있어서 이차원 배열을 선언할 경우에 메모리 초과가 나는 것 같다.