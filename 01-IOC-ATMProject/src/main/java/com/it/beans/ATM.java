package com.it.beans;

public class ATM {
	
	private Printer printer;
	
	public ATM() {
		System.out.println("ATM.ATM()");
	}
	
	public ATM(Printer printer) {
		this.printer=printer;
	}
	
	public void setPrinter(Printer printer) {
		System.out.println("ATM.setPrinter() :: method called");
		this.printer=printer;
	}
	
	public void withdraw(int amt) {
		System.out.println("amt deducted...");
		printer.print();
	}
}
