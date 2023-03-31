package gui.school;


public class Student {
	//Bell bell;  //의존성을 약화시키기 위한 상위 객체 사용
	
	/*
	//생성자 주입도 주입으로 인정
	public Student(Bell bell) {
		this.bell=bell;
	}
	*/
	
	public void goSchool() {
		//bell.ring();
		System.out.println("등교");
	}
	
	public void startStudy() {
		//bell.ring();
		System.out.println("오전 수업 시작");
	}
	
	public void endStudy() {
		//bell.ring();
		System.out.println("오전 수업 종료");
	}
	
	public void haveLunch() {
		//bell.ring();
		System.out.println("점심식사");
	}
	
	public void startStudy2() {
		//bell.ring();
		System.out.println("오후 수업 시작");
	}
	
	public void endStudy2() {
		//bell.ring();
		System.out.println("오후 수업 종료");
	}
	
	public void goHome() {
		//bell.ring();
		System.out.println("하교");
	}
}
