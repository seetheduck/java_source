package pack;

import java.util.Scanner;

public class Test07for {

	public static void main(String[] args) {
		// 반복문 for
		// for(초기치; 조건; 증감치) {반복 처리 대상}
		int a;

		int sum = 0;
		for (a = 1; a <= 5; a++) {
			System.out.println("a : " + a);
			sum += a;
		}
		System.out.println("반복문 수행 후 a : " + a);
		System.out.println("합 : " + sum);

		for (int i = 65; i <= 90; i++) {
			System.out.print((char) i + " ");
		}
		System.out.println();

		for (int i = 'A'; i <= 'Z'; i++) {
			System.out.print(i + " ");
		}

		System.out.println();

		for (int i = 10; i > 1; i -= 2) {
			System.out.print(i + " ");
		}
		System.out.println();

		for (int ytn = 0, tvn = 5; ytn <= 5; ytn++, tvn++) {
			System.out.print(ytn + " " + tvn + " : ");
		}
		System.out.println();
		
		int aa = 1;
		for(;aa <= 5; aa++) {
			System.out.print(aa + " ");
		}
		
		System.out.println("\n\n다중 for ----------");
		
		for(int m=1; m<=3; m++) {
			System.out.println("m=" + m);
			for(int n=1; n<=4; n++) {
				System.out.print("n:" + n + " ");
			}
			System.out.println();
		}
		System.out.println();
		
		for(char i=65; i<=90; i++) {
			System.out.print(i + " : ");
			for(char j=i; j<='Z'; j++) {
				System.out.print(j);
			}
			System.out.println();
		}
		System.out.println();
		
		// 구구단 3단 출력
		for(int count=1; count<10; count++) {
			System.out.println("3 * " + count + " = " + count*3 );
		}
		
		System.out.println();
		
		// 문1 : 키보드로 숫자를 받아 구구단 출력
		// 예) 몇 단 ? 3
		// 3 * 1 = 3 3 * 2 = 6 ...
		
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자 입력 : ");
		int num = sc.nextInt();
		
		for(int i=1; i<10; i++) {
			System.out.print(num + " * " + i + " = " + num*i + " ");
		}
		sc.close();
		
		System.out.println("\n");

		// 문2 : 1 ~ 100 사이의 점수 중 3의 배수이면서 5의 배수의 갯수와 그 합을 출력
		
		int count=0, sum1=0;
		for(int i=1; i<101; i++) {
			if(i % 3 == 0 && i % 5 == 0) {
				count++;
				sum1 += i;
			}
		}
		
		System.out.println("갯수 : " + count + "\n합 : " + sum1);
		
		System.out.println();
		// 문3 : 2~9단까지 출력 ( 다중 for )
		// 2*1=2 2*2=4...
		// ...
		// 9*1=9 9*2=18...
		
		for(int i=2; i<10; i++) {
			System.out.println(i + "단 ");
			for(int j=1; j<10; j++) {
				System.out.print(i + " * " + j + " = " + i*j + " ");
			}
			System.out.println();
		}
		
	}

}
