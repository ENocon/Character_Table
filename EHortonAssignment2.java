//Programmer Name: Elizabeth Nocon
//Class and Section: CS 1450.001
//Assignment Number: 2
//Due Date: 9/6/2018
//Description: 
//This program reads a text document, then performs methods to get information. 
//Once the information is acquired, the information is displayed in a table.

import java.util.Scanner;

public class EHortonAssignment2 
{
	//Main Method: Will read text document, and display information in table.
	public static void main (String [] args) throws Exception
	{
		//Create a file instance.
		java.io.File file = new java.io.File("characters.txt");
		
		//Create a scanner for the characters text file. 
		Scanner input = new Scanner(file);
		
		//Read first string and convert the numbers to integer form.
		String numberOfCharacters = input.next();
		int integerOfCharacters = Integer.parseInt(numberOfCharacters);
		
		//Create polymorphic array. Assign size as integer from text document.
		Character1[] characters = new Character1[integerOfCharacters];
		
		//Create loop to read each line of the file and assign to the polymorphic array.
		for (int i = 0; i < characters.length; i++) 
		{
			//Assign values in document to variables key and name.
			String key = input.next();
			String name = input.nextLine();
			String typeString;
			
			//Create switch statements to call subclasses.
			switch (key) 
			{
			case "h": typeString = "Hero";
					  characters[i] = new Hero(name, typeString);
					  break;
			case "v": typeString  = "Villain";
					  characters[i] = new Villain(name, typeString);
					  break;
			case "m": typeString = "Monster";
					  characters[i] = new Monster(name, typeString);
					  break;
			case "d": typeString = "Droid";
			          characters[i] = new Droid(name, typeString);
			          break;
			}
		} //For Loop
		
		//Close scanner reading text file.
		input.close();
		
		//Display heading on table. 
		System.out.print("Character Name\t\t Type\t\t  Statement\t\t\n");
		//Use loop to print row of dashes. 
		for (int i = 0; i < 81; i ++) 
		{
			System.out.print("-");
		}
		
		//Create a space, so that Superman is below the dashed line.
		System.out.print("\n");
		
		//Create loop to read array, and print name, type and statement for each.
		for (int i = 0; i < characters.length; i++) 
		{
			//Acquire name, type, and statement. Print in table.
			System.out.printf("%-25s%-17s%-35s\n", characters[i].getName(), characters[i].getType(), characters[i].speak());
			
		}
		
	} //Main
} //Assignment 2

//Create class Character. Create abstract so that later on method speak can be abstract.
		class Character1
		{
			//Declare the instance variables for the character class.
			private String name; 
			private String type;
			
			//Default character constructor.
			public Character1() 
			{
			}
			
			//Character constructor for specific name and type. 
			public Character1(String name, String type) 
			{
				this.name = name;
				this.type = type;
			}
			
			//Getter for name. 
			public String getName() 
			{
				return name;
			}
			
			//Getter for type. 
			public String getType() 
			{
				return type;
			}
			
			//Method for speak. Method to be overridden by subclasses.
			public String speak() 
			{
				return "String";
			}
			
		} //Character class.
	
	//Create Hero subclass. 
	class Hero extends Character1 
	{
		//Declare string for speak override later on.
		public String characterSays = "To the rescue! KAPOW!! BAM!! POW!!";
		
		//Hero constructor.
		public Hero (String name, String type) 
		{
			super(name, type);
		}
		
		//Override the speak method. 
		@Override
		public String speak() 
		{
			return characterSays;
		}
	} //Hero
	
	//Create Villain Subclass.
	class Villain extends Character1
	{
		//Declare string for speak override later on.
		public String characterSays = "You'll never stop me! Haaaaaaa!";
		
		//Villain constructor. 
		public Villain (String name, String type) 
		{
			super(name, type);
		}
		
		//Override the speak method. 
		@Override
		public String speak() 
		{
			return characterSays;
		}
	} //Villain
	
	//Create subclass Monster.
	class Monster extends Character1
	{
		//Declare string for speak override later on. 
		public String characterSays = "RRAAAUUGGHH GRROWR!!!";
		
		//Monster Constructor. 
		public Monster (String name, String type) 
		{
			super(name, type);
		}
		
		//Override the speak method. 
		@Override
		public String speak() 
		{
			return characterSays;
		}
	} //Monster
	
	//Create subclass Droid. 
	class Droid extends Character1
	{
		//Declare string for speak override later on.
		public String characterSays = "Beep Beep Bloop Boop Beep";
		
		//Droid constructor. 
		public Droid (String name, String type) 
		{
			super(name, type);
		}
		
		//Override the speak method. 
		@Override
		public String speak() 
		{
			return characterSays;
		}
	} //Droid