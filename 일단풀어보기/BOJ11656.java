package 일단풀어보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class BOJ11656 {
    //substring을 통해 접미사를 list에 넣기
    //comparator써서 비교하기 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        List<String> list = new LinkedList<>();
        for(int i=0; i<str.length(); i++) 
            list.add(str.substring(i));
        
        Collections.sort(list, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                // TODO Auto-generated method stub
                if(o1.compareTo(o2) < 0) return -1;
                else if(o1.compareTo(o2) == 0) return 0;
                else return 1;
            }
            
        });

        for(String l :list)
            System.out.println(l);
    }
    
}
