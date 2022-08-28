package 일단풀어보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// class Person implements Comparable<Person> {
//     int age;
//     String name;

//     Person(int age, String name) {
//         this.age = age;
//         this.name = name;
//     }

//     @Override
//     public int compareTo(Person o) { //다. 이때, 회원들을 나이가 증가하는 순으로, 나이가 같으면 먼저 가입한 사람이 앞에 오는 순서
//         if(this.age < o.age) return -1;
//         else if(this.age == o.age) return 0;
//         else return 1;
//     }
// }

public class BOJ10814 {
    private static class Person implements Comparable<Person> {
        int age;
        String name;

        Person(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(Person o) { //다. 이때, 회원들을 나이가 증가하는 순으로, 나이가 같으면 먼저 가입한 사람이 앞에 오는 순서
            if(this.age < o.age) return -1;
            else if(this.age == o.age) return 0;
            else return 1;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Person[] arr = new Person[N];
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = new Person(Integer.parseInt(st.nextToken()), st.nextToken());
        }

        Arrays.sort(arr);

        for(Person a:arr) {
            System.out.println(a.age + " " + a.name);
        }
    }    
}
