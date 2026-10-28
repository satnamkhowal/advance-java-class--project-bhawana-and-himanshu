package com.groot.abc.paytm;

import com.groot.rbi.RBIBank;
import com.groot.sbibank.SBIFactory;

public class Test {
	public static void main(String[] args) {
		RBIBank rbi= SBIFactory.getObj();
		rbi.getRateOfIntert();
	}
}
