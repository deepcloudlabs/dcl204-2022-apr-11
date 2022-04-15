package com.example.lottery.ui;

import java.util.ServiceLoader;

import com.example.lottery.service.business.StandardLotteryService;
import com.example.random.service.RandomNumberService;

/**
*
*  @author Binnur Kurt <binnur.kurt@gmail.com>
*/
public class LotteryApplication {

	public static void main(String[] args) {
		var lotteryService = new StandardLotteryService();
		var randomNumberServices = ServiceLoader.load(RandomNumberService.class);
		lotteryService.setRandomNumberService(randomNumberServices.findFirst().get());
		lotteryService.draw(60, 6, 10).forEach(System.out::println);
	}

}
