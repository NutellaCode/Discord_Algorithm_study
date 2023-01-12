import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q2470 {
    public static void main(String[] args) throws IOException {
        // 1. input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // ����� �� n
        int[] arr = new int[n];

        // �־��� ���� �ð��� 1��, n�� ������ -1,000,000,000 �̻� 1,000,000,000 ����
        // 2�� for ���� ����ؼ� �ذ��ϴ� ������ �ƴ϶�, �� �����͸� �˰��� Ȱ��

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        } // ����� ��� �迭
        // ���������� 0�� ���� ����� ���� ã�� ���̴�.

        // 2. �� ���� ���� �� ������ ���� ���Ѵ�.
        // �� ���� ���� ���� �����, �ּڰ��� ��� �����ϸ鼭 �� ���� ��( -98, 99ó�� )�� ��� ����.

        Arrays.sort(arr);

        int start = 0;
        int end = n - 1;

        int min = Integer.MAX_VALUE;
        int number = 0; // number ������ �ּڰ��� ã�´�
        int a = 0; // �� �� �� �ϳ�
        int b = 0; // �� �� �� �ϳ� ( �� ���� ���� 0�̶� ����� ��, �� �� index ���� a, b��. )
        int check = 0; // check ������ index ��ȣ�� ������ �� �ְ��Ѵ�
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

