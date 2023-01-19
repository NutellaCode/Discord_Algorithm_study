package samsung01.jeensung;

import java.util.*;
class BOJ1300 {
    public static void main(String[] args){
    	Scanner scan = new Scanner(System.in);
    	int n = scan.nextInt();
    	int k = scan.nextInt();
    	/**
    	1  2  3  4  5  6  7  8
    	2  4  6  8 10 12 14 16
    	3  6  9 12 15 18 21 24
    	4  8 12 16 20 24 28 32
    	5 10 15 20 25 30 35 40
    	6 12 18 24 30 36 42 48
    	7 14 21 28 35 42 49 56
    	8 16 24 32 40 48 56 64
    	**/
    	int min = 1;
    	int max = k;
    	while(min < max) {
    		int mid = (min + max) / 2;
    		int count = 0;
    		for(int i = 1; i <= n; i++)
    			count += Math.min(mid / i, n);
    		//Math.min�̾�� �� �࿡ ���� x������ ���� ������ n���Ϸ� ��������
    		if(count >= k)
    			max = mid;
    		else
    			min = mid + 1;
    	}
    	System.out.println(min);
    }
}