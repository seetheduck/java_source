package kr.mvc.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.mvc.controller.UserForm;

//Controller 클래스에 요청을 받아 DB 연동 처리 담당
public class UserDaoModel {
	private SqlSessionFactory factory = SqlMapConfig.getSqlSession();
	
	public UserDaoModel() {
		
	}
	
	public UserDto findUser(String userid) {
		UserDto dto = null;
		
		SqlSession session = factory.openSession();
		
		try {
			dto = session.selectOne("findUser", userid);
		} catch (Exception e) {
			System.out.println("findUser err : " + e);
		}finally {
			session.close();
		}
		
		return dto;
	}
	
	public ArrayList<UserDto> getUserDataAll(){
		List<UserDto> list = null;
		
		SqlSession session = factory.openSession();
		
		try {
			list = session.selectList("selectDataAll");
		} catch (Exception e) {
			System.out.println("getUserDataAll err : " + e);
		}finally {
			session.close();
		}
		
		return(ArrayList<UserDto>)list;
	}
	
	public int insertData(UserForm userForm){
		int result = 0;
		SqlSession session = factory.openSession();
		
		try {
			result = session.insert("insertData", userForm);
			session.commit();
		} catch (Exception e) {
			System.out.println("insertData err : " + e);
			session.rollback();
		} finally {
			session.close();
		}
		
		return result;
	}
	
	public int updateData(UserForm userForm) {
		int result = 0;
		SqlSession session = factory.openSession();
		
		try {
			result = session.update("updateData", userForm);
			session.commit();
		} catch (Exception e) {
			System.out.println("updateData err : " + e);
			session.rollback();
		} finally {
			session.close();
		}
		
		return result;
		
	}
	
	public int deleteData(String userid){
		int result = 0;
		SqlSession session = factory.openSession();
		
		try {
			result = session.delete("deleteData", userid);
			session.commit();
		} catch (Exception e) {
			System.out.println("deleteData err : " + e);
			session.rollback();
		} finally {
			session.close();
		}
		
		return result;
		
		
	}
	
	
}
