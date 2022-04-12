package com.example;

public class StudyString {

	public static void main(String[] args) {
		// -Xms4g
		// -Xmx6g
		// Heap, Stack, Text, Data, MetaSpace(Constant Pool)/PermGen
		// Object Pooling -> MetaSpace/Perm Gen Caching -> Immutable Class
		// String is immutable class
		String name1 = "jack"; // static -> constant pool (cache)
		String name2 = new String("jack"); // dynamic -> heap
		String name3 = "jack"; // static -> constant pool (cache)
		name3.toUpperCase();
		System.out.println(name3);
		name2 = name2.intern();
		System.out.println("name1 == name2? "+(name1==name2)); // false -> true
		System.out.println("name1 == name3? "+(name1==name3)); // true

	}

}
