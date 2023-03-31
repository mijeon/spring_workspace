package com.edu.springmvc1.model.emp;


import java.util.List;

import com.edu.springmvc1.domain.Emp;

//컨트롤러가 사용할 
public interface EmpService {
	public void regist(Emp emp);
	public List selectAll();
	public Emp select(int empno);
	public void remove(Emp emp);
}
