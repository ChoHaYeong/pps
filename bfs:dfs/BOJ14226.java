import java.util.*;
import java.io.*;

class Emoticon {
    int screen; //화면에 있는 이모티콘 개수
    int board; //클립보드에 있는 이모티콘 개수
    int time; //현재까지의 시간

    Emoticon(int screen, int board, int time) {
        this.screen = screen;
        this.board = board;
        this.time = time;
    }
}

public class BOJ14226 {
    static int S;
    static boolean[][] visited;
    static Queue<Emoticon> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = Integer.parseInt(br.readLine());
    
        visited = new boolean[10000][10000];
        queue.add(new Emoticon(1, 0, 0));
        visited[1][0] = true;
        bfs();

    }
    
    static void bfs() {
        /*
         * queue에서 빼서 첫번째 연산하면 => 화면 그대로, 클립보드 : 화면 이모티콘 개수 , 시간+1
            두번째 연산하면 => 화면 += 클립보드, 클립보드 그대로, 시간+1
            세번째 연산 => 화면 -= 1, 클립보드 그대로, 시간+1

            시간+1하면 그게 최솟값이라고 볼 수 있을까 ?? 

            화면의 이모티콘 개수가 S개랑 같아지면, 그때의 시간을 출력하기 
         */

        while(!queue.isEmpty()) {
            Emoticon out = queue.poll();

            if(out.screen == S){
                System.out.println(out.time);
                return ;
            }

            if(!visited[out.screen][out.screen]){
                
                queue.add(new Emoticon(out.screen, out.screen, out.time+1));
                visited[out.screen][out.screen] = true;
            }   
            if(out.board > 0 && !visited[out.screen + out.board][out.board]){
                queue.add(new Emoticon(out.screen + out.board, out.board, out.time+1));
                visited[out.screen + out.board][out.board] = true;
            }
            if(out.screen > 0 && !visited[out.screen -1][out.board]){
                queue.add(new Emoticon(out.screen-1, out.board, out.time+1));
                visited[out.screen -1][out.board] = true;
            }

        }
    }
}
