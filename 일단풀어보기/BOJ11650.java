package 일단풀어보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Position implements Comparable<Position> { //x좌표가 증가하는 순으로, x좌표가 같으면 y좌표가 증가하는 순서
    int x, y;

    Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Position o) { //양수일 경우 두 위치를 바꾼다는 것임
        if(this.x < o.x) return -1;
        else if(this.x == o.x) {
            if(this.y < o.y) return -1;
            else if(this.y > o.y) return 1;
        }
        else return 1;

        return 0;
    }
}
public class BOJ11650 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Position[] arr = new Position[N];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = new Position(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
           // arr[i].y = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        for(Position a: arr) {
            System.out.println(a.x + " " + a.y);
        }
    }
    
}
