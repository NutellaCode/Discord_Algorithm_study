import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q2470 {
    public static void main(String[] args) throws IOException {
        // 1. input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // ?�액????n
        int[] arr = new int[n];

        // 주어�??�한 ?�간?� 1�? n??범위??-1,000,000,000 ?�상 1,000,000,000 ?�하
        // 2�?for 문을 ?�용?�서 ?�결?�는 문제가 ?�니?? ???�인?��? ?�고리즘 ?�용

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        } // ?�액???�는 배열
        // 최종?�으�?0�?가??가까운 값을 찾는 것이??

        // 2. �??�쪽 값과 �??�른�?값을 비교?�다.
        // ???�의 ?�을 ?�댓�??�우�? 최솟값을 계속 갱신?�면?????�의 �? -98, 99처럼 )??계속 갱신.

        Arrays.sort(arr);

        int start = 0;
        int end = n - 1;

        int min = Integer.MAX_VALUE;
        int number = 0; // number 값으�?최솟값을 찾는??
        int a = 0; // ????�??�나
        int b = 0; // ????�??�나 ( ???�의 ?�이 0?�랑 가까울 ?? �???index 값이 a, b?? )
        int check = 0; // check 값으�?index 번호�?조정?????�게?�다
        while (start < end) {
            check = arr[start] + arr[end];
            number = Math.abs(arr[start] + arr[end]);

            if (min > number) {

                min = number;
                a = arr[start];
                b = arr[end];
            }
            if (check > 0) {
                end--;
            } else if (check < 0) {
                start++;
            } else if (check == 0) {
                break;
            }
        }

        System.out.println(a + " " + b);
    }
}
