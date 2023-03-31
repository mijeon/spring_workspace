package com.edu.springmvc1.model.emp;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.springmvc1.domain.Emp;
import com.edu.springmvc1.exception.DeptException;
import com.edu.springmvc1.exception.EmpException;
import com.edu.springmvc1.mybatis.MybatisConfig;

import lombok.Setter;
/*
 	이 객체는 트랜잭션을 포함해 모델 파트에서의 서비스 역활을 수행함 -> '부장' 역활
 	만일 서비스의 존재가 없을 경우, 컨트롤러가 너무 세부적인 Model 영역의 업무를 수행하게 됨
 	또한 트랜잭션 상황에서 각각의 DAO들의 업무 수행이 성공했는지 여부를 판단하여 트랜잭션을 
 	commit 할지 rollback 을 결정짓는 역활을 수행함
 	주의) 직접 일하지 않고 각종 모델 영역의 객체들에게 일을 시킴
 */
//어노테이션을 붙여놓으면, 스프링의 컴포넌트로 인식되어, 자동 검색에 걸리게 되어 인스턴스를 빈으로 올려줌
@Service
@Setter
public class EmpServiceImpl implements EmpService{
	MybatisConfig mybatisConfig=MybatisConfig.getInstance();
	
	//자동주입(xml에 명시하지 않아도 주입 처리)
	@Autowired
	private DeptDAO deptDAO;  //사원
	
	@Autowired
	private EmpDAO empDAO;  //사원
	
	
	//사원등록
	public void regist(Emp emp) {
		SqlSession sqlSession=mybatisConfig.getSqlSession();
		try {
			//세션 얻어와서 배분하기 (주입)
			deptDAO.setSqlSession(sqlSession);
			empDAO.setSqlSession(sqlSession);
			
			deptDAO.insert(emp.getDept());  //부서등록
			empDAO.insert(emp);  //사원등록
			sqlSession.commit();
		} catch (DeptException e) {
			sqlSession.rollback();
			e.printStackTrace();
		}catch (EmpException e) {
			sqlSession.rollback();
			e.printStackTrace();
		}finally {
			mybatisConfig.release(sqlSession);
		}
	}
	
	//모든 사원 가져오기
	public List selectAll() {
		SqlSession sqlSession=mybatisConfig.getSqlSession();
		empDAO.setSqlSession(sqlSession);
		List list= empDAO.selectAll();
		mybatisConfig.release(sqlSession);
		return list;
	}
	
	//사원 한명 가져오기
	public Emp select(int empno){
		SqlSession sqlSession=mybatisConfig.getSqlSession();
		empDAO.setSqlSession(sqlSession);
		Emp emp=empDAO.select(empno);
		mybatisConfig.release(sqlSession);
		return emp;
	}
	
	//사원 퇴사처리 (부서, 사원 둘다 삭제)
	public void remove(Emp emp) {
		SqlSession sqlSession=mybatisConfig.getSqlSession();
		empDAO.setSqlSession(sqlSession);
		deptDAO.setSqlSession(sqlSession);
		
		try {
			//사원 삭제
			empDAO.delete(emp.getEmpno());  //사원 번호를 이용해 삭제함
			//부서 삭제
			deptDAO.delete(emp.getDept().getDeptno());
			sqlSession.commit();
		} catch (EmpException e) {
			e.printStackTrace();
			sqlSession.rollback();
		} catch (DeptException e) {
			e.printStackTrace();
			sqlSession.rollback();
		}finally {
			mybatisConfig.release(sqlSession);
		}
	}
}
