package com.groot.pqr1;

public class Demo {
	public static void main(String[] args) {
		A a=new A();
		a.say();
		B b=new B();
		b.say();
		b.display();
	}
}
class B extends A{
	B(){
		say();
		display();
	}
}
