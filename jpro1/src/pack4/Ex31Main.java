package pack4;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex31Main {

	ArrayList<Ex31StudDto> list = new ArrayList<Ex31StudDto>();
	Ex31StudDto dto;

//	public void insertList(String name, int kor, int eng) {
//		dto = new Ex31StudDto(name, kor, eng);
//		list.add(dto);
//		
//	}

	public void insertList(String name, int kor, int eng) {
		dto = new Ex31StudDto();
		dto.setName(name);
		dto.setKor(kor);
		dto.setEng(eng);
		list.add(dto);
	}

	public void showList() {

		for (Ex31StudDto i : list) {
			System.out.println("이름 : " + i.getName() + ", 국어 : " + i.getKor() + ", 영어 : " + i.getEng() + ", 총점 : "
					+ (i.getKor() + i.getEng()));
		}
		System.out.println("응시 인원 : " + list.size());
	}

	public static void main(String[] args) {
		int kor, eng;
		String name, yn;

		Ex31Main main = new Ex31Main();


		while (true) {
			Scanner sc = new Scanner(System.in);
			try {
				System.out.print("이름 입력 : ");
				name = sc.next();
				System.out.print("국어 점수 : ");
				kor = sc.nextInt();
				System.out.print("영어 점수 : ");
				eng = sc.nextInt();

				main.insertList(name, kor, eng);

				System.out.println("\n계속할까요? y/n");
				yn = sc.next();

				if (yn.equals("n")) {
					main.showList();
					System.exit(0);
				} else if (yn.equals("y"))
					continue;
			} catch (Exception e) {
				System.out.println("처리 중 오류 발생 : " + e);
				break;
			}
			sc.close();
		}

	}

}
