package com.sample.app.controller;

public class Test {
	
	public static void main(String[] args) {
		
		
	}

	private static int sum(int[] param) {
		int res = 0;
		
		for (int i = 0; i < param.length; i++) {
			res += param[i];
		}
		
		return res;
	}

}
