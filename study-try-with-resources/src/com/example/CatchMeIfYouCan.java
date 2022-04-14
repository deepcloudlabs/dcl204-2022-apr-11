package com.example;

/**
*
*  @author Binnur Kurt <binnur.kurt@gmail.com>
*/
public class CatchMeIfYouCan {
	public static int fun() {
		try {
			return 42;
		} finally {
			return 108;
		}
	}
	public static void main(String[] args) {
		System.err.println(fun());
	}

}
