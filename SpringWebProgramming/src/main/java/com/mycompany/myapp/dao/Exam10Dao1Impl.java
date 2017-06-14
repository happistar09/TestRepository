
package com.mycompany.myapp.dao;

import org.springframework.stereotype.Component;

@Component
public class Exam10Dao1Impl implements Exam10Dao1{
	
	@Override
	public void insert() {
		System.out.println("Exam10Dao1 - insert() 실행");
		
	}
	
	@Override
	public void select() {
		System.out.println("Exam10Dao1 - select() 실행");
		
	}
}
