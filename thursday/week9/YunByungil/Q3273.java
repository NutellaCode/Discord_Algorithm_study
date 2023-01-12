import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // a(i) + a(j) = x�?만족?�는 (a(i), a(j))?�의 개수�?구하??문제.
        // 범위가 매우 ?�기 ?�문??for문을 ?�용?�서 ?�전 ?�색???�면 ?�간 초과
        // ?�라?????�인???�고리즘???�용?�서 ?�결?�자. ???�인?�의 ?�간 복잡?�는 O(N)?�다.

        // 1. input
        int n = Integer.parseInt(br.readLine()); // ?�열???�기 n

        int[] arr = new int [n]; // n개의 ?�자�??�는 배열

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken()); // ?�연??x

        int result = 0; // 결과

        int start = 0;
        int end = n - 1;
        while (start < end) {
            if (arr[start] + arr[end] == x) {
                result++;
                end--;
            } else if (arr[start] + arr[end] > x) {
                end--;
            } else if (arr[start] + arr[end] < x) {
                start++;
            }
        }

        System.out.println(result);
    }
}
