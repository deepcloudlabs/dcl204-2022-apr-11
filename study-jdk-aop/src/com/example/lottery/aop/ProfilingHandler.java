package com.example.lottery.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
*
*  @author Binnur Kurt <binnur.kurt@gmail.com>
*/
public class ProfilingHandler implements InvocationHandler {
	private Object target;
	
	public ProfilingHandler(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		long start = System.nanoTime();
		var result = method.invoke(target, args);
		long stop = System.nanoTime();
		System.out.println("%s runs %d ns.".formatted(method.getName(),(stop-start)));	
		return result;
	}

}
