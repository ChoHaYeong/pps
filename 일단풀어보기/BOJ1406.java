 package 일단풀어보기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class BOJ1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int N = Integer.parseInt(br.readLine());

        List<Character> list = new LinkedList<>();
        
        ListIterator<Character> iter = list.listIterator();

        for(int i=0; i<str.length(); i++)
            iter.add(str.charAt(i));


       // int cursor = str.length();

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            char command = st.nextToken().charAt(0);
            char ch = '?'; //그냥 초기화 
            if(st.hasMoreTokens())
                ch = st.nextToken().charAt(0);

            if(command == 'L' && iter.hasPrevious())
                iter.previous();
            else if(command == 'D' && iter.hasNext())
                iter.next();
            else if(command == 'B' && iter.hasPrevious()){
                iter.previous();
                iter.remove();
            }
            else if(command == 'P'){
                iter.add(ch);
            }

        }

        for(Character l: list)
            bw.write(l);

        bw.flush();
    }
    
}

