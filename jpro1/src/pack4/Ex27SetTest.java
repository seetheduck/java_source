package pack4;

import java.util.HashSet;
import java.util.Iterator;

// collection : 다수의 객체를 담을 수 있는 집합형 자료구조
public class Ex27SetTest {

	public static void main(String[] args) {
		// Set류의 HashSet 연습 : 중복 불가, 순서 X
		
		Ex27SetTest test = new Ex27SetTest();
		HashSet<String> list = new HashSet<String>();
		//list.add(1);
		list.add("lee");
		list.add("lee");
		list.add("lee");
		list.add("park");
		list.add("hong");
//		list.remove("park");
//		list.clear();
		System.out.println(list.size());
		
		for(String obj:list) {
			System.out.println(obj);
		}
		
		System.out.println();
		Iterator iter = list.iterator();
		// Iterator(반복자) : 개발자가 컨테이너, 특히 리스트를 순회할 수 있게 해주는 객체다.
		while(iter.hasNext()) {
			String ss = (String)iter.next();
			System.out.println(ss);
		}
		
	}

}
