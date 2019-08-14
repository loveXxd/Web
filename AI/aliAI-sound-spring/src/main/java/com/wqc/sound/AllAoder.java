package com.wqc.sound;

public class AllAoder {
	public void OpenGo() {
		try {
			ProcessBuilder proc = new ProcessBuilder(
					"C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\Application\\chrome.exe",
					"http://blog.csdn.net/");
			proc.start();
		} catch (Exception e) {
			System.out.println("Error executing progarm.");

		}
	}
	
}
