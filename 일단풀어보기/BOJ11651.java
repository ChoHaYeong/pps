package 일단풀어보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Position2 implements Comparable<Position2> {
    int x, y;

    Position2(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Position2 o) { //좌표를 y좌표가 증가하는 순으로, y좌표가 같으면 x좌표가 증가하는 순서
        if(this.y < o.y) return -1;
        else if(this.y == o.y) {
            if(this.x < o.x) return -1;
            else if(this.x > o.x) return 1;
        }
        else return 1;

        return 0;
    }
}

public class BOJ11651 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Position2[] arr = new Position2[N];

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = new Position2(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(arr);
        for(Position2 a: arr) {
            System.out.println(a.x + " " + a.y);
        }
    }
}
