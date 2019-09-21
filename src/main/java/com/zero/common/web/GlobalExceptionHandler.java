package com.zero.common.web;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.zero.common.vo.JsonResult;

/**
 * 当控制层对象出现异常后：
 * 1)检测控制层对象内部有没有@ExceptionHandler描述异常处理方法
 * 2)检测Spring容器中是否有对象使用了@ControllerAdvice注解修饰
 * 假如有，则使用类中的@ExceptionHandler描述的异常处理方法，对
 * 特定异常进行处理。
 * @author Administrator
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(RuntimeException.class)
	public JsonResult doHandleRuntimeException(
			RuntimeException e) {
		e.printStackTrace();
		return new JsonResult(e);
	}
}
