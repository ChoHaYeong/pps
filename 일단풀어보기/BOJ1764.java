package 일단풀어보기;

import java.io.*;
import java.util.*;

public class BOJ1764 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();

        for(int i=0; i<N+M; i++){ //듣도 못한 사람의 명단에는 중복되는 이름이 없으며, 보도 못한 사람의 명단도 마찬가지이다.
            String name = br.readLine();
            map.put(name, map.getOrDefault(name, 0)+1);
        }

        List<String> list = new ArrayList<>();

        for(String key : map.keySet()){
            if(map.get(key) > 1) list.add(key);
        }
        Collections.sort(list);
        
        System.out.println(list.size());
        for(String l : list)
            System.out.println(l);

    }
}
