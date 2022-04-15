package com.example;

/**
*
*  @author Binnur Kurt <binnur.kurt@gmail.com>
*/
public class StudyStringBuilder {

	public static void main(String[] args) {
		// StringBuffer -> Thread-Safe
//		StringBuffer s = new StringBuffer(12888890);
		StringBuilder s = new StringBuilder(12888890);
		
		var start = System.currentTimeMillis();
		for (var i=0;i<2_000_000;++i)
			s.append(Integer.toString(i)); 
		var stop = System.currentTimeMillis();
		System.err.println("s.length(): %d @ %d ms.".formatted(s.length(),stop-start));
	}

}
