package pack;

import java.util.Scanner;

public class Test09While {

	public static void main(String[] args) {
		// 반복문 while
		// while(조건) { 실행문들..args.. }

		int w = 1;

		while (w <= 5) {
			System.out.print("w = " + w + " ");
			w++;
		}
		System.out.println("\nwhile 수행 후 w : " + w);

		System.out.println();

		int count = 0;
		while (count < 5) {
			count++;
			System.out.println("count : " + count);
			if (count == 3) {
				System.out.println("쉬어가기");
			}
			if (count == 5) {
				System.out.println("count가 5라서 종료 : " + count);
			}
		}

		System.out.println();
		w = 0;
		while (true) { // 무한루프
			w++;
			if (w == 5)
				break;
			if (w == 3)
				continue;
			System.out.println("w는 " + w);
		}
		System.out.println();

		// factorial n!은 1 ~ n 까지의 모든 정수의 곱을 의미
		// ex) 5! = 5 * 4 * 3 * 2 * 1 = 120

//		Scanner sc = new Scanner(System.in);
//		System.out.print("정수 입력:");
//		int number = sc.nextInt(); // API를 가져다 적용

		int number = 5;
		// factorial 계산을 위한 초기값 설정
		int factorial = 1;
		int i = 1; // 반복을 위한 counter 변수

		while (i <= number) {
//			System.out.println(i);
			factorial *= i;
			i++;
		}
		System.out.printf("number는 %d 팩토리얼은 %d", number, factorial);

		System.out.println("\n다중 while ---");
		int a = 1;
		while (a <= 3) {
			System.out.println("a : " + a);
			int b = 1;
			while (b <= 4) {
				System.out.print("b : " + b + " ");
				b++;
			}
			a++;
			System.out.println();
		}
		System.out.println();
		// 키보드로 입력받은 숫자에 대해 1부터 시작해 그 숫자까지 모든 수에
		// 나누기를 시도하고 나누어 떨어지는 경우(약수) 그 수를 출력한다.
		// 0이나 음수를 입력하면 프로그램을 종료한다.

//		Scanner sc = new Scanner(System.in);
//		while(true) {
//			System.out.print("정수 입력(0이나 음수면 종료) : ");
//			int num = sc.nextInt();
//			if(num <= 0) {
//				System.out.println("프로그램 종료");
//				break;
//			}
//			System.out.println(num + "의 약수는 ");
//			int divisor = 1; // 약수를 찾기 위해 1부터 시작
//			while(divisor <= num) {
//				if(num % divisor == 0) {
//					System.out.println(divisor); // 약수 출력
//				}
//				divisor++; // 다음 수로 이동
//			}
//		}
		System.out.println();
		// do{반복 수행문...} while(조건);
		int k = 10;
		do { // 최소 1회는 수행
			System.out.println("k : " + k);
			k++;
		} while (k <= 5);

		System.out.println();
		System.out.println("exam----------");

		// 문1) 1 ~ 100 사이의 정수 중 3의 배수이지만 2의 배수가 아닌
		// 수를 출력하고, 합과 개수도 출력
		int aa = 1;
		int cnt = 0;
		int sum = 0;
		while (aa <= 100) {
			if (aa % 3 == 0 && aa % 2 != 0) {
				System.out.print(aa + " ");
				sum += aa;
				cnt++;
			}
			aa++;
		}
		System.out.println("\n합 : " + sum);
		System.out.println("개수 : " + cnt);

		System.out.println();

		// 문2) -1, 3, -5, 7, -9, 11 ... 99 까지의 합 출력
		int bb = 1, cnt1 = 1, sum1 = 0;

		while (bb <= 99) {
			if (cnt1 % 2 != 0) {
				bb *= -1;
			}
			cnt1++;
			sum1 += bb;

			if (bb < 0) {
				bb *= -1;
			}
			bb += 2;
		}
		System.out.println("합 : " + sum1);
		System.out.println();

//		int n=1, cnt=1, hap=0;
//		while(n < 100) {
//			if(cnt % 2 == 0) {
//				hap += n;
//			}else {
//				int imsi = n*-1;
//				hap += imsi;
//			}
//			n += 2;
//			cnt ++;
//		}
//		System.out.println("합은 " + hap + "입니다");

		// for로 출력
//		int hap2=0, cnt3=1;
//		for(int j=1; j<100; j++) {
//			if(cnt3 % 2 == 0) {
//				hap2 += j;
//			} else {
//				hap2 += j * -1;
//			}
//			cnt3++;
//		}
//		System.out.println("for 합은 " + hap2 + "입니다.");

		// 문3) 1 ~ 100 사이의 정수중에서 소수와 그 개수를 출력
		// 소수 : 1보다 크며 1과 그 수 자체 이외의 다른 수로는 나누어지지 않는 수
		int cc = 2;
		int dd;
		int cnt2 = 0;

		while (cc <= 100) {
			dd = 2;
			while (dd <= cc) {
				if (cc % dd == 0) {
					if (cc != dd) {
						break;
					} else {
						System.out.print(cc + " ");
						cnt2++;
					}
				}
				dd++;
			}
			cc++;
		}
		System.out.print("\n개수 : " + cnt2);
		System.out.println();

//		int g = 2, count2 = 0, ha = 0;
//		System.out.println("1부터 100까지의 소수 : ");
//		while(g <= 100) {
//			boolean imsi = false;
//			
//			int bb2 = 2;
//			while(bb2 <= g-1) {
//				if(g % bb2 == 0) {
//				imsi = true;
//				}
//				bb2++;
//			}
//			if(imsi == false) {
//			System.out.print(bb2 + " ");
//			count2++;
//			}
//			g++;
//		}
//		System.out.println("\n건수 : " + count2);
//		System.out.println("2부터 그 숫자의 제곱근까지의 모든 수로 나누어 떨어지는지 확인");
//		
		
		// 소수를 찾는 이유로 제곱근까지만 검사하는 것은 어떤 수의 약수는 그 수의 제곱근을 넘지 않기 때문
//		int num = 2;
//		int count3 = 0;
//		System.out.println("1부터 100까지의 소수 : ");
//		while (num <= 100) {
//			boolean isPrime = true; // 현재 숫자가 소수인지 판별
//			int divisor = 2;
//			while (divisor <= Math.sqrt(num)) {
//				if (num % divisor == 0) {
//					isPrime = false;
//					break; // 나누어 떨어지지 않으면 더 이상의 검사는 필요없음
//				}
//				divisor++;
//			}
//			if (isPrime) { // if(isPrime == true){
//				count3++;
//				System.out.print(num + " ");
//			}
//			num++;
//		}
//		System.out.println("\n건수 : " + count3);
		
		
	}
}
