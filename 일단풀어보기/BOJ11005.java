package 일단풀어보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ11005 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        Map<Integer, Character> map = new HashMap<>();

        // for(int i=10; i<36; i++)
        //     map.put(i, (char) (i + 55)) ; 

        List<Character> list = new LinkedList<>();

        while(true) {
            //System.out.println("나머지 : " + (int) N % B);
            if(N%B < 10)
                list.add((char) (N % B + '0'));
            else
                list.add((char) (N % B - 10 + 'A'));
            N = N / B;
           // System.out.println("N " + N);
            if( N == 0) { 
                //list.add(1); 
                break;
            }
        }

        Collections.reverse(list); //뒤집는거 안하고 그냥 리스트의 뒤에서부터 해도됨 

        for(char l : list){
            // if(l >= 10)
            //     System.out.print(map.get(l));
            // else
                System.out.print(l);
        }
        
    }
    
}
