package mill.ui;

import mill.core.MillController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class UserInterface 
{
	MillController ctrl = new MillController();

	public void getDataFromCtrl1() {
		String field = readLine();
		while(!ctrl.placeToken(field)){
			System.out.println("geht nicht");
			field = readLine();
		};
	}

	public void getDataFromCtrl2() {
	}

	public void startGame() {
		System.out.println("Wir beginnen das Spiel!");
		System.out.println("leider müssen wir hier abbrechen. Mehr gibts noch nicht");
	}
	
	public void startTutorial() {
		System.out.println("Tutorial");
		System.out.println("A1---------A2--------A3");
		System.out.println("|          |          |");
		System.out.println("|   B1-----B2----B3   |");
		System.out.println("|   |      |      |   |");
		System.out.println("|   |  C1-C2-C3   |   |");
		System.out.println("|   |   |     |   |   |");
		System.out.println("A4--B4--C4   C5--B5--A5");
		System.out.println("|   |   |     |   |   |");
		System.out.println("|   |  C6-C7-C8   |   |");
		System.out.println("|   |      |      |   |");
		System.out.println("|   B6-----B7----B8   |");
		System.out.println("|          |          |");
		System.out.println("A6---------A7---------A8");
	}


	public void start() {
		System.out.println("Welcome to the Mill Game");
		Menu<Runnable> menu = new Menu<>("User Interface");
		menu.setTitel("Wählen Sie aus:");
		menu.insert("a", "Place Token", this::getDataFromCtrl1);
		menu.insert("b", "tbd", this::getDataFromCtrl2);
		menu.insert("g", "Start Game", this::startGame);
		menu.insert("t", "Start the Tutorial ",this::startTutorial);
		menu.insert("q", "Quit", null);
		Runnable choice;
		while ((choice = menu.exec()) != null) {
			 choice.run();
		}
		System.out.println("Program finished");
	}


	protected String readLine() 
	{
		String value = "\0";
		BufferedReader inReader = new BufferedReader(new InputStreamReader(System.in));
		try {
			value = inReader.readLine();
		} catch (IOException e) {
		}
		return value.trim();
	}

	protected Double readDouble(int lowerlimit, int upperlimit) 
	{
		Double number = null;
		while(number == null) {
			String str = this.readLine();
			try {
				number = Double.parseDouble(str);
			}catch(NumberFormatException e) {
				number=null;
				System.out.println("Please enter a valid number:");
				continue;
			}
			if(number<lowerlimit) {
				System.out.println("Please enter a higher number:");
				number=null;
			}else if(number>upperlimit) {
				System.out.println("Please enter a lower number:");
				number=null;
			}
		}
		return number;
	}
}
