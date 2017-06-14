
package com.mycompany.myapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.myapp.service.Exam10Service1;
import com.mycompany.myapp.service.Exam10Service2;
import com.mycompany.myapp.service.Exam10Service3;
import com.mycompany.myapp.service.Exam10Service4;
import com.mycompany.myapp.service.Exam10Service5;
import com.mycompany.myapp.service.Exam10Service6;

@Controller
public class Exam10DIController {
	
	@Autowired
	private Exam10Service1 exam10Service1;
	@Autowired
	private Exam10Service2 exam10Service2;
	@Autowired
	private Exam10Service3 exam10Service3;
	@Autowired
	private Exam10Service4 exam10Service4;
	@Autowired
	private Exam10Service5 exam10Service5;
	@Autowired
	private Exam10Service6 exam10Service6;
	
	/*
	@Autowired				
	public void setExam10Service2(Exam10Service2 exam10Service2) {
		System.out.println("Exam10DIController - setExam10Service2() 실행");
		this.exam10Service2 = exam10Service2;
		//초기화 추가 코드 (이 방법 사용시 장점: 추가코드 작성 가능)
	}
	*/

	@RequestMapping("/di/exam01")
	public String exam01(){
		System.out.println("exam01 실행");
		//필드 주입
		exam10Service1.join();
		//Setter 주입
		exam10Service2.join();
		//생성자 주입
		exam10Service3.join();
		//고전적 Setter 주입
		exam10Service4.join();
		//고전적 생성자 주입
		exam10Service5.join();
		
		exam10Service6.join();
		return "di/exam01";
	}
	
	@RequestMapping("/di/exam02")
	public String exam02(){
		System.out.println("exam02 실행");
		exam10Service1.login();
		exam10Service2.login();
		exam10Service3.login();
		exam10Service4.login();
		exam10Service5.login();
		exam10Service6.login();
		return "di/exam02";
	}
}
