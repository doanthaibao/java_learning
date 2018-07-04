package com.bao.doan.java.core;

 class Parent {
	{
		System.out.print("A");
	}
	static {
		System.out.println("B ");
	}
}
public class Child extends Parent {
	{
		System.out.print("C ");
	}
	static {
		System.out.print("D ");
	}
	public static void main(String []args) {
		Child child = new Child();
	}
}
