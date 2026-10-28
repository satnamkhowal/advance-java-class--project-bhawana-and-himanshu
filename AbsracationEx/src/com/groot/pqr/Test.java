package com.groot.pqr;
import java.awt.DisplayMode;

import com.groot.pqr1.*;
public class Test {
	public static void main(String[] args) {
			Animal a=new Animal() {
				@Override
				public void eat() {
					// TODO Auto-generated method stub
					System.out.println("Dog is eating bread");
				}
				public void display() {
					System.out.println("ok");
				}
			};
			a.eat();
	}
} 
class Animal{
	public void eat() {
		System.out.println("Animal is eating ");
	}
}