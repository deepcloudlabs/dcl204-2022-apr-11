package com.example;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
*
*  @author Binnur Kurt <binnur.kurt@gmail.com>
*/
public class StudyClass {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, NoSuchFieldException {
		// Java's Type System -> Class -> Class Loader -> MetaSpace/PermGen
		var intType = int.class;
		var intArrayType = int[].class;
		var intMatrixType = int[][].class;
		var employeeClass = Employee.class;
		var jack = new Employee("1", "jack bauer", 100_000, "TR1");
		var empClazz = jack.getClass();
		System.out.println(employeeClass);
		System.out.println(empClazz);
		System.out.println(empClazz.equals(employeeClass));
		System.out.println(Employee.class.equals(jack.getClass()));
		System.out.println(Employee.class.isInstance(jack));
	    
		for (var method : Employee.class.getDeclaredMethods()) {
			System.out.println(method.getName());
		}
		for (var constructor : Employee.class.getDeclaredConstructors()) {
			for (var parameter : constructor.getParameters())
			    System.out.println(parameter.getType()+" "+parameter.getName());
		}
		
		var clazz = String.class;
		var name1 = "Kate Austen";
		var name2 = clazz.getConstructor(String.class).newInstance("Kate Austen");
		System.out.println(name1);
		System.out.println(name2);
		A a = new A();
		System.out.println(a);
		Field x = A.class.getDeclaredField("x");
		x.setAccessible(true);
		x.set(a, 108);
		x.setAccessible(false);
		System.out.println(a);
	}

}
class A {
	private int x = 42;

	@Override
	public String toString() {
		return "A [x=" + x + "]";
	}
	
}
record Employee (String identity,String fullname,double salary,String iban) {}