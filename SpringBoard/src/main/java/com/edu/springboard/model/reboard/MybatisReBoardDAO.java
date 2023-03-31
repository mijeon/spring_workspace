package com.edu.springboard.model.reboard;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edu.springboard.domain.ReBoard;
import com.edu.springboard.exception.ReBoardException;

//자식한테 @Repository 붙이면 부모도 같이 메모리에 올라감
@Repository
public class MybatisReBoardDAO implements ReBoardDAO {
	/*	@Autowired 역활
	  	xml로 표현했다면 아래와 같이 명시했어야 했음
	  	<bean class="~~">
	  		<property name="SqlSessionTemplate" ref="sqlSessionTemplate"/>
	  	</bean> */
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List selectAll() {
		return sqlSessionTemplate.selectList("ReBoard.selectAll");
	}

	@Override
	public ReBoard select(int reboard_idx) {
		return sqlSessionTemplate.selectOne("ReBoard.select", reboard_idx);
	}

	@Override
	public void insert(ReBoard reboard) throws ReBoardException{
		int result=0;
		result=sqlSessionTemplate.insert("ReBoard.insert", reboard);
		if(result<1) {
			throw new ReBoardException("원글 등록 실패");
		}
	}

	@Override
	public void update(ReBoard reboard) throws ReBoardException {
		int result=0;
		result=sqlSessionTemplate.update("ReBoard.update", reboard);
		if(result<1) {
			throw new ReBoardException("원글 수정 실패");
		}
	}

	@Override
	public void delete(int reboard_idx) throws ReBoardException {
		int result=0;
		result=sqlSessionTemplate.delete("ReBoard.delete", reboard_idx);
		if(result<1) {
			throw new ReBoardException("원글 삭제 실패");
		}
	}

	@Override
	public void updateStep(ReBoard reboard) {
		int result=0;
		result=sqlSessionTemplate.update("ReBoard.updateStep", reboard);
	}

	@Override
	public void reply(ReBoard reboard) throws ReBoardException{
		int result=0;
		result=sqlSessionTemplate.insert("ReBoard.reply", reboard);
		if(result<1) {
			throw new ReBoardException("답변 등록 실패");
		}
	}
}
