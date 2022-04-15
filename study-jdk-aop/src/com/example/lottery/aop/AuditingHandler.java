package com.example.lottery.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Date;

/**
*
*  @author Binnur Kurt <binnur.kurt@gmail.com>
*/
public class AuditingHandler implements InvocationHandler {
	private Object target;
	
	public AuditingHandler(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("%s runs at %s.".formatted(method.getName(),new Date()));	
		var result = method.invoke(target, args);
		System.out.println("%s returns %s.".formatted(method.getName(),result));	
		return result;
	}

}
