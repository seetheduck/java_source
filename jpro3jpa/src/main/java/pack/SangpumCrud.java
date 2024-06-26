package pack;

import java.util.List;

import javax.net.ssl.SNIHostName;

import domain.SangpumTable;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class SangpumCrud {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("gojpa");
		
		// EntityManager : thread 단위로 작업
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		
		// 자료 추가
//		try {
//			transaction.begin();
//			SangpumTable santab = new SangpumTable(14, "도시락", 3, 6000);
//			em.persist(santab);
//			transaction.commit();
//			
//		} catch (Exception e) {
//			System.out.println("ins error : " + e);
//			transaction.rollback();
//			return;
//		}
		
		
		// 자료 수정
//		try {
//			transaction.begin();
//			SangpumTable sangtab = em.find(SangpumTable.class, "14");
//			if(sangtab == null) {
//				System.out.println("해당 자료 없음");
//			}else {
//				String newName = "마스크";
//				sangtab.setSang(newName);
//				transaction.commit();
//			}
//		} catch (Exception e) {
//			System.out.println("up error : " + e);
//			transaction.rollback();
//			return;
//		}
		
		
		// 자료 삭제
//		try {
//			transaction.begin();
//			
//			int findCode = 14;
//			SangpumTable sangtab = em.find(SangpumTable.class, findCode);
//			if(sangtab == null) {
//				System.out.println("해당 자료 없음");
//				transaction.rollback();
//			}else {
//				em.remove(sangtab);
//				System.out.printf("자료 삭제됨 : %s", findCode);
//				transaction.commit();
//			}
//			
//		} catch (Exception e) {
//			System.out.println("del error : " + e);
//			transaction.rollback();
//			return;
//		}
		
		// JPA를 사용한 DML 처리
		try {
			System.out.println("전체 자료 읽기 1");
			CriteriaBuilder cb = em.getCriteriaBuilder();
			
			CriteriaQuery<SangpumTable> query = cb.createQuery(SangpumTable.class);
			
			// 조회의 시작점을 의미하는 Root 객체 생성
			Root<SangpumTable> root = query.from(SangpumTable.class);
			query.select(root);
			List<SangpumTable> resultList = em.createQuery(query).getResultList();
			
			for(SangpumTable st:resultList) {
				System.out.println(st.getCode() + " " + st.getSang() + " " + st.getSu() + " " + st.getDan());
			}
			
			System.out.println("\n전체 자료 읽기 2");
			// TypedQuery를 이용해 JPQL 사용
			
			/*
			TypedQuery<SangpumTable> queryql = em.createQuery("select s from SangpumTable s", SangpumTable.class);
			List<SangpumTable> list = queryql.getResultList();
			 */
			
			// 위 두 줄을 한 줄로 표현
			List<SangpumTable> list = em.createQuery("select s from SangpumTable s", SangpumTable.class).getResultList();
			
			for(SangpumTable st:list) {
				System.out.println(st.getCode() + " " + st.getSang() + " " + st.getSu() + " " + st.getDan());
			}
			
			
			System.out.println("\n부분 자료 읽기 1");
			int findId = 1;	// String findId = "1"; 이렇게 써도 상관 X. pk 칼럼이 대상
			SangpumTable sangtab = em.find(SangpumTable.class, findId);
			if(sangtab == null) {
				System.out.println("자료 없음");
			}else {
				System.out.printf("%s %s %s %s\n", sangtab.getCode(), sangtab.getSang(), sangtab.getSu(), sangtab.getDan());
			}
			
			System.out.println("\n부분 자료 읽기 2");
			TypedQuery<SangpumTable> typedQuery = em.createQuery(query.where(cb.equal(root.get("sang"), "장갑")));
			
			List<SangpumTable> resultList2 =typedQuery.getResultList();
			for(SangpumTable sangtab2:resultList2) {
				System.out.printf("%s %s %s %s\n", sangtab2.getCode(), sangtab2.getSang(), sangtab2.getSu(), sangtab2.getDan());
			}
			
		} catch (Exception e) {
			System.out.println("error : " + e);
		} finally {
			em.close();
			emf.close();
		}

	}

}
