package ?��?.silver.no11729;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q11729 {
    public static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int count = (int) (Math.pow(2, n)) - 1;
        System.out.println(count);
        hanoi(n, 1, 2, 3);

    }

    public static void hanoi(int n, int start, int mid, int to) {
        // 종료 조건
        if (n == 1) {
            System.out.println(start + " " + to);
            return;
        }

        // ?�행 조건
        // n - 1개의 ?�판??a -> b�??�동????경우????
        hanoi(n - 1, start, to, mid);

        // 마�?�?a???��? ?�판??c�??�동????경우????
        System.out.println(start + " " + to);

        // n - 1개의 ?�판??b -> c�??�동????경우????
        hanoi(n - 1, mid, start, to);
    }
}
