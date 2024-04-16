package pack;

public class Test10Array {

	public static void main(String[] args) {
		// 배열(Array) : 성격과 크기가 일치하는 복수개의 기억장소에 대해
		// 대표명 하나를 주고 첨자(index)로 각 기억장소를 구분
		// 반복처리가 효과적
		int a; // 기억장소 한 개 선언
		int arr[]; // 배열로 선언 int []arr;, int[] arr; 이래도 괜찮음
		arr = new int[5];
		System.out.println("배열 크기 : " + arr.length);
		arr[0] = 10;
		arr[1] = 20;
		arr[4] = arr[0] + arr[1] + arr[2]; // 첨자(index)로 각 기억장소를 호출
		System.out.println(arr[4]);
//		arr[5] = 50; 런타임에러 : ArrayIndexOutOfBoundsException

		int a1 = 4, b = 4;
		System.out.println(arr[4] + " " + arr[a1] + " " + arr[b] + " " + arr[1 + 3]);
		
		System.out.println();
		int[] arr1 = new int[5];
		System.out.println(arr1[0] + " " + arr1.length);
		
		//반복문으로 배열 데이터 출력
		for(int i=0; i<arr1.length; i++) {
			arr1[i] = i;
			System.out.print(arr1[i] + " ");
		}
		
		System.out.println();
		
		// 향상된 for문 : 배열, 컬렉션에서 사용이 가능함
		for(int i:arr1) {
			System.out.print(i + " ");
		} 
		System.out.println();
		
		String city[] = {"서울", "대전", "제주"};
		System.out.println(city[0] + " " + city[1] + " " + city[2]);
		
		for(String lee:city) {
			System.out.print(lee + " ");
		}
		System.out.println();
		
		System.out.println("배열에 값 저장 후 출력 ---");
		int[] arr2 = new int[5];
		for(int i=0; i<arr2.length; i++) {
			arr2[i] = i+1;
		}
		
		int tot = 0;
		for(int i=0; i<arr2.length; i++) {
			System.out.print(arr2[i] + " ");
			tot += arr2[i];
		}
		System.out.println("arr2 요소 값 총합 : " + tot);
		
		System.out.println("\n다차원 배열---");
		
		// int au[] = new int[12]; // 1차원 배열로 요소수 12개
		int su[][] = new int[3][4]; // 2차원 배열로 요소수 12개 (4개짜리 3개)
		su[0][0] = 100;
		System.out.println(su[0][0]);
		System.out.println("행수 : " + su.length + ", 열수 : " + su[0].length);
		
		// 2차원 배열 값 저장
		int num = 10;
		for(int i=0; i<su.length; i++) {
			for(int j=0; j<su[i].length;j++) {
				su[i][j] = num++;
			}
		}
		System.out.println(su[0][0] + " " + su[2][0]);
		System.out.println();
		for(int i=0; i<su.length; i++) {
			for(int j=0; j<su[i].length;j++) {
				System.out.print(su[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println("가변 배열 : 행 마다 요소(열)의 개수가 동적");
		int[][] scores = new int[2][];
		scores[0] = new int[2];
		scores[1] = new int[3];
		System.out.println(scores.length + " " + scores[0].length + " " + scores[1].length);
		
		System.out.println();
		int [][]jum = {{90, 87},{88, 99, 100}}; // 가변배열 선언 후 값 저장
		for(int i=0; i<jum.length; i++) {
			for(int j=0; j<jum[i].length; j++) {
				System.out.print(jum[i][j] + " ");
			}
			System.out.println();
		}
		
	}

}
