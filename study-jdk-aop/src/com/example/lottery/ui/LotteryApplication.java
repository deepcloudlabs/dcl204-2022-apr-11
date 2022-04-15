package com.example.lottery.ui;

import java.lang.reflect.Proxy;

import com.example.lottery.aop.AuditingHandler;
import com.example.lottery.aop.ProfilingHandler;
import com.example.lottery.service.LotteryService;
import com.example.lottery.service.business.StandardLotteryService;

/**
 *
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public class LotteryApplication {
	public static void main(String[] args) {
         var target = new StandardLotteryService();
         LotteryService lotteryService = target;
        var clazz = lotteryService.getClass();
        lotteryService = (LotteryService)
        Proxy.newProxyInstance(
        		clazz.getClassLoader(), 
        		clazz.getInterfaces(), 
        		new ProfilingHandler(lotteryService));
        lotteryService = (LotteryService)
        Proxy.newProxyInstance(
        		clazz.getClassLoader(), 
        		clazz.getInterfaces(), 
        		new AuditingHandler(lotteryService));
        target.setSelf(lotteryService);
        lotteryService.draw(60, 6, 10).forEach(System.out::println);
	}
}
