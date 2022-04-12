package com.example.banking.domain;

public class A {
   public A() { } // No-arg Constructor / Default Constructor
}

class B {
	// has no no-arg constructor
	public B(int x) {} 
	public B(int x,int y) {}
	public B(boolean z) {}
	// overloaded methods: fun
	public void fun() {}
	public void fun(int x) {}
	public void fun(double x) {}
}

class C {} // has a no-arg constructor

class D {
	public D(int x) {}
}

class E extends D {
	// compiler adds the following no-arg constructor if you don't provide one:
	public E(int i) {
		super(2*i); // D's No-arg constructor
	}
}