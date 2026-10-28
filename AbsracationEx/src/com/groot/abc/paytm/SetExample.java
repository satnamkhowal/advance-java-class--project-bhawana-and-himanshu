package com.groot.abc.paytm;

import java.lang.classfile.instruction.ArrayStoreInstruction;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SetExample {
	public static void main(String[] args) {
		
		List<Integer> list=Arrays.asList(12,13,56,57,23,26);	
		System.out.println(list);
		List list2=list.stream().map(SetExample::sqr).collect(Collectors.toList());
		List list3=list.stream().map((n)->n*n).collect(Collectors.toList());
		System.out.println(list);
		System.out.println(list2);
		
	}
	public static int sqr(int n) {
		return n*n;
	}
}
