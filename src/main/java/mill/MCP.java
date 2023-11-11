package mill;

import mill.core.Board;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MCP {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String firstinput;
        Board board = new Board();

        System.out.println("Welcome to the Mill Game");
        System.out.println("Start the Tutorial --> press t");
        System.out.println("Start a new Game   --> press g");

        firstinput = br.readLine();

        if (firstinput.equals("g")) {
            System.out.println("Wir beginnen das Spiel!");
            System.out.println("leider müssen wir hier abbrechen. Mehr gibts noch nicht");
        }
        else if (firstinput.equals("t")){
            System.out.println("Hier das Tutorial:");
            board.printErklaerungsfeld();
        }
        else {
            System.out.println("Eingabe ungültig. Auf Wiedersehen");
        }


    }
}