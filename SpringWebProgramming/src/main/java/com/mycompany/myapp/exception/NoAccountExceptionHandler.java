package com.mycompany.myapp.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.mycompany.myapp.controller.Exam15TransactionController;

@Component
@ControllerAdvice //컨트롤러마다 공통으로 발생하는 예외를 처리하는 객체라는 뜻
public class NoAccountExceptionHandler {
	private static final Logger LOGGER = LoggerFactory.getLogger(Exam15TransactionController.class);
	@ExceptionHandler
	public String handleNoAccountException(NoAccountException e, Model model){
		LOGGER.info("실행");
		model.addAttribute("reason", e.getMessage());
		return "transaction/exam02";
	}

}
