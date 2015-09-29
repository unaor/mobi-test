package com.uri.mobi.runner;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.uri.mobi.service.NumberPrettifierImpl;

public class Runner {
	
	

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter a Number or 0 to exit");
		while(true){
			Float input=-1f;
			try{
				input = scanner.nextFloat();
			}catch(InputMismatchException ex){
				System.out.println("A number please not some crazy String");
				scanner.nextLine();
				continue;
			}
			 
			
			if(input ==0){
				System.out.println("Bye");
				scanner.close();
				break;
			}
			
			NumberPrettifierImpl np = new NumberPrettifierImpl();
			
			System.out.println(np.prettify(input));
		}
		

	}

}
