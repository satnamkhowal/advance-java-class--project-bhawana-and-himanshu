package com.groot.sbibank;

import com.groot.rbi.RBIBank;

public class SBIFactory {
	public static RBIBank getObj() {
		return new SBIBank();
	}
}
