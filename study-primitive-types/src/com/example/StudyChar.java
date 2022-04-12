package com.example;

public class StudyChar {

	public static void main(String[] args) {
		char u = 'x'; // 2-byte, unsigned int, unicode
		System.out.println((char)(u+1));
        char v = '\u20ba';
        System.out.println(v);
	}

}
