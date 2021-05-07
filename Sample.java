package ecommerce;

import java.util.Scanner;

import genericutilities.Excelutilities;

public class Sample {

	public static void main(String[] args) throws Throwable {

		Scanner sc=new Scanner(System.in);
		System.out.println("enter name:   ");
		String name = sc.next();
		
		
		Excelutilities ex=new Excelutilities();
		ex.setExcelData("Sheet2", 6, 3, name);
		
	}

}
