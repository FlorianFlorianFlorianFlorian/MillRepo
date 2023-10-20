package mill;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MCP {
    static void printBoard(){
        System.out.println("X----------X----------X");
        System.out.println("|          |          |");
        System.out.println("|   X------X------X   |");
        System.out.println("|   |      |      |   |");
        System.out.println("|   |   X--X--X   |   |");
        System.out.println("|   |   |     |   |   |");
        System.out.println("X---X---X     X---X---X");
        System.out.println("|   |   |     |   |   |");
        System.out.println("|   |   X--X--X   |   |");
        System.out.println("|   |      |      |   |");
        System.out.println("|   X------X------X   |");
        System.out.println("|          |          |");
        System.out.println("X----------X----------X");

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String firstinput;

        System.out.println("Welcome to the Mill Game");
        System.out.println("Start the Tutorial --> press t");
        System.out.println("Start a new Game   --> press g");

        firstinput = br.readLine();

        if (firstinput.equals("g")) {
            System.out.println("Wir beginnen das Spiel!");

        }
        else if (firstinput.equals("t")){
            System.out.println("Hier das Tutorial:");
            printBoard();
        }
        else {
            System.out.println("Eingabe ungültig. Auf Wiedersehen");
        }


    }
}