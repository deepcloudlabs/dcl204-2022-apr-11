package com.example.lottery.controller;

import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.example.lottery.service.LotteryService;

/**
*
*  @author Binnur Kurt <binnur.kurt@gmail.com>
*/
@RestController
@RequestScope
@RequestMapping("/numbers")
@CrossOrigin
@Validated
public class LotteryRestController {
	private LotteryService lotteryService;
	
	public LotteryRestController(LotteryService lotteryService) {
		this.lotteryService = lotteryService;
	}

	@GetMapping(params= {"max","size","column"})
	public List<List<Integer>> getLotteryNumbers(
			@RequestParam @Min(30) @Max(80) int max,
			@RequestParam @Max(20) int size,
			@RequestParam @Max(20) int column){
		if (column < 3) throw new IllegalArgumentException("column cannot be smaller than 3");
		return lotteryService.draw(max,size,column);
	}
}
