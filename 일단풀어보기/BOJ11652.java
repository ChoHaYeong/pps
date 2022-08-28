package 일단풀어보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Map.Entry;

public class BOJ11652 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<Long, Integer> map = new HashMap<>();

        for(int i=0; i<N; i++){
           // StringTokenizer st = new StringTokenizer(br.readLine());
            long key = Long.parseLong(br.readLine());
           // System.out.println("key : " + key + " , value : " + map.get(key));
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        // for(Entry<Long, Integer>  m: map.entrySet()) 
        //     System.out.println(m.getKey() + " = " + m.getValue());

       List<Entry<Long, Integer>> entryList = new ArrayList<Entry<Long, Integer>>(map.entrySet());
       Collections.sort(entryList, new Comparator<Entry<Long, Integer>>() {
        //카드개수 내림차순, 같으면 카드 번호가 작은 것 
        @Override
        public int compare(Entry<Long, Integer> o1, Entry<Long, Integer> o2) {

            if(Integer.compare(o1.getValue(), o2.getValue()) < 0) return 1; //카드개수가 많은 순서대로 (생각해보니까 무작정 빼면 양수 - 음수하면 양수되니까 앞에)
            else if(Integer.compare(o1.getValue(), o2.getValue()) == 0) { //카드개수가 똑같으면
                if(Long.compare(o1.getKey(), o2.getKey()) < 0) return -1; //카드에 적신 숫자가 작은거부터
                else if(Long.compare(o1.getKey(), o2.getKey()) > 0) return 1; //카드에 적힌 숫자가 작은거부터
            }
            else return -1;

            return 0;
        }        
        
       });

    //    for(Entry<Long, Integer> entry: entryList) {
    //         System.out.println((long) entry.getKey());
    //         break;
    //    }
       System.out.println(entryList.get(0).getKey());
    //     System.out.println(entry.getKey() + " = " + entry.getValue());

    //    System.out.println((long)map.keySet().toArray()[0]);

    }
}
