import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // a(i) + a(j) = x�� �����ϴ� (a(i), a(j))���� ������ ���ϴ� ����.
        // ������ �ſ� ũ�� ������ for���� �̿��ؼ� ���� Ž���� �ϸ� �ð� �ʰ�
        // ���� �� ������ �˰����� �̿��ؼ� �ذ�����. �� �������� �ð� ���⵵�� O(N)�̴�.

        // 1. input
        int n = Integer.parseInt(br.readLine()); // ������ ũ�� n

        int[] arr = new int [n]; // n���� ���ڸ� ��� �迭

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken()); // �ڿ��� x

        int result = 0; // ���

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

