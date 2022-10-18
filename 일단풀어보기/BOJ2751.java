package 일단풀어보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2751 {
    static int arr[], sort[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        sort = new int[N];

        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        mergeSort(0, N-1);
        StringBuilder sb = new StringBuilder();
        for(int s : arr) sb.append(s).append("\n");
        System.out.println(sb);
    }

    static void mergeSort(int s, int e) {
        if(s < e) {
            int mid = (s+e)/2;
            mergeSort(s, mid);
            mergeSort(mid+1, e);
            merge(s, mid, e);
        }
    }

    static void merge(int s, int mid, int e) {
        int i = s; int j = mid+1; int k = s;
        while(i <= mid && j <= e) {
            if(arr[i] <= arr[j]) {
                sort[k] = arr[i];
                i++;
            }
            else {
                sort[k] = arr[j];
                j++;
            }
            k++;
        }

        if(i > mid) {
            for(int p=j; p<=e; p++){
                sort[k] = arr[p];
                k++;
            }
        }
        else {
            for(int p=i; p<=mid; p++ ){
                sort[k] = arr[p];
                k++;
            }
        }

        for (int p = s; p <= e; p++) {
            arr[p] = sort[p];
        }
    }
}
