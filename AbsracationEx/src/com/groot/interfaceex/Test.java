package com.groot.interfaceex;

public class Test {
		public static void main(String[] args) {
			C c=new C();
			c.say();
		}
}
interface A{
	public void say();
}
interface B extends A{
	public void display();
}
class C implements B{

	@Override
	public void say() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		
	}
	
}