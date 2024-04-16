package pack1;

import java.time.LocalDate;

public class Ex08Main {

	public static void main(String[] args) {
		// 싱글톤 패턴 연습
		Ex08SingtonClass s1 = new Ex08SingtonClass();
		System.out.println(s1.kor);
		
		Ex08SingtonClass s2 = new Ex08SingtonClass();
		System.out.println(s2.kor);
		
		System.out.println(s1 + " " + s2);
		System.out.println(s1.hashCode() + " " + s2.hashCode());
		
		System.out.println();
		
		Ex08SingtonClass s3 = Ex08SingtonClass.getInstance();
		System.out.println(s3.kor);
		
		Ex08SingtonClass s4 = Ex08SingtonClass.getInstance();
		System.out.println(s4.kor);
		
		System.out.println(s3.hashCode() + " " + s4.hashCode());
		
		System.out.println("날짜 출력 싱글톤 사용 예");
		LocalDate mynow = LocalDate.now();
		LocalDate mynow2 = LocalDate.now();
		System.out.println(mynow.hashCode() + " " + mynow2.hashCode());
		System.out.println(mynow2.getYear());
		
		
	}

}
