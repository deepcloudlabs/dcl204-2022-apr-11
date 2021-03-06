package com.example.random.service.business;

import java.security.SecureRandom;

import com.example.random.service.RandomNumberService;

/**
*
*  @author Binnur Kurt <binnur.kurt@gmail.com>
*/
public class SecureRandomNumberService implements RandomNumberService {

	private SecureRandom random = new SecureRandom();

	@Override
	public int generate(int min, int max) {
		return random .nextInt(min,max);
	}

}
