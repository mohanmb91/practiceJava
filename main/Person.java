package main;

import java.util.*;


class Person{
	protected String firstName;
	protected String lastName;
	protected int idNumber;
	// Constructor
	Person(){
		
	}
	Person(String firstName, String lastName, int identification){
		this.firstName = firstName;
		this.lastName = lastName;
		this.idNumber = identification;
	}

	// Print person data
	public void printPerson(){
		 System.out.println(
				"Name: " + lastName + ", " + firstName 
			+ 	"\nID: " + idNumber); 
	}
}

class Student extends Person{
	private int[] testScores;
   Student(String firstName, String lastName, int id, int[] testScoresDummy){
       super(firstName,lastName,id);
       this.testScores = testScoresDummy;

   }
   public char calculate(){
       int sum = 0;
       char grade = ' ';
       for(int eachScores : testScores){
    	sum += eachScores;   
       }
       sum = sum / testScores.length;
       if(sum >= 90 && sum <= 100){
           grade = 'O';
       }
       return grade;
   }
}