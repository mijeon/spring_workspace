package com.edu.springmvc1.model.emp;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.edu.springmvc1.domain.Dept;
import com.edu.springmvc1.exception.DeptException;

//이 어노테이션을 붙여놓으면 스캔에 의해 검색되어 자동으로 인스턴스를 생성해줌
//왜 xml에서 명시하지 않나? xml에 너무나 많은 매핑이 걸려서 오히려 알아보기 힘듬
//따라서 설정파일인 xml이 간소화되는 추세이기 때문에 어노테이션이 적극적으로 사용됨
@Repository
public class DeptDAO {
	private SqlSession sqlSession;
	
	//트랜잭션을 위해 주입받음
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	//부서 등록
	public void insert(Dept dept) throws DeptException {
		int result=0;
		result=sqlSession.insert("Dept.insert", dept);
		if(result<1) {
			throw new DeptException("부서등록 실패");
		}
	}
	
	//부서 한개 지우기
	public void delete(int deptno) throws DeptException {
		int result=sqlSession.delete("Dept.delete", deptno);
		if(result<1) {
			throw new DeptException("부서삭제 실패");
		}
	}
}
