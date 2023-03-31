package com.edu.springmvc1.model.emp;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.edu.springmvc1.domain.Emp;
import com.edu.springmvc1.exception.EmpException;

//이 어노테이션을 붙여놓으면 스캔에 의해 검색되어 자동으로 인스턴스를 생성해줌
//왜 xml에서 명시하지 않나? xml에 너무나 많은 매핑이 걸려서 오히려 알아보기 힘듬
//따라서 설정파일인 xml이 간소화되는 추세이기 때문에 어노테이션이 적극적으로 사용됨
@Repository
public class EmpDAO {
	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	//사원 등록
	public void insert(Emp emp) throws EmpException {
		int result=0;
		result=sqlSession.insert("Emp.insert", emp);
		if(result<1) {
			throw new EmpException("사원등록 실패");
		}
	}
	
	//모든 사원 가져오기
	public List selectAll() {
		return sqlSession.selectList("Emp.selectAll");
	}
	
	//사원 한명 가져오기
	public Emp select(int empno) {
		return sqlSession.selectOne("Emp.select", empno);
	}
	
	//사원 한명 지우기
	public void delete(int empno) throws EmpException {
		int result=sqlSession.delete("Emp.delete", empno);
		if(result<1) {
			throw new EmpException("사원삭제 실패");
		}
	}
}
