package mill.ui;

import mill.core.Board;
import mill.core.Field;
import mill.core.Game;
import mill.core.MillController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;


public class UserInterface {
    //private MillController ctrl = new MillController();
    private Game game = null;

    public void placeToken() {
        System.out.println("Spieler " + this.game.getPlayer() + " ist am Zug:");
        String field = readLine();
        Pattern mypattern = Pattern.compile("^[ami][1-8]$");
        // ^ ... das folgende ist der Beginn vom String
        //[ami] ... dieser Charakter ist entweder 'a', 'm' oder 'i'
        //[1-8] ... dieser Charakte ist im Interval von 1 bis 8 (sowohal 1 als auch 8 sind inbegriffen)
        // $ ... der String ist aus - Ende vom String

        if (!mypattern.matcher(field).matches()) {
            System.out.println("Invalide Eingabe");
            return;
        }

        if (game == null) {
            System.out.println("Spiel hat noch nicht begonnen");
            return;
        }
        if (!this.game.placeToken(field)) {
            System.out.println("Feld kann nicht besetzt werden");
        } else {
            this.game.drawBoard();
        }
        arethereanyMills();
    }

    public void moveToken() {
        String field = readLine();
    }

    public void arethereanyMills() {
        if (this.game.checkForMills()) {
            System.out.println("Eine Mühle wurde gebaut!");
            iliketoremoveremoveit();
        }
        else {
            System.out.println("keine Mühle erkannt.");
        }
    }

    public void iliketoremoveremoveit(){
        // select
        System.out.println("Welches Token soll entfernt werden?");
        //read
        String tokentoremove = readLine();
        // remove
        if(this.game.removeToken(tokentoremove)){
            System.out.println("Entfernung erfolgreich");
        }else{
            System.out.println("Entfernung fehlgeschlagen");
        }
        this.game.drawBoard();
    }

    public void startGame() {
        System.out.println("Wir beginnen das Spiel!");
        this.game = new Game();
        this.game.drawBoard();
    }

    public void startTutorial() {
        System.out.println("Tutorial");
        System.out.println("A1---------A2--------A3");
        System.out.println("|          |          |");
        System.out.println("|   M1-----M2----M3   |");
        System.out.println("|   |      |      |   |");
        System.out.println("|   |  I1-I2-I3   |   |");
        System.out.println("|   |   |     |   |   |");
        System.out.println("A4--M4--I4   I5--M5--A5");
        System.out.println("|   |   |     |   |   |");
        System.out.println("|   |  I6-I7-I8   |   |");
        System.out.println("|   |      |      |   |");
        System.out.println("|   B6-----B7----B8   |");
        System.out.println("|          |          |");
        System.out.println("A6---------A7---------A8");
    }


    public void start() {
        System.out.println("Welcome to the Mill Game");
        Menu<Runnable> menu = new Menu<>("User Interface");
        menu.setTitel("Wählen Sie aus:");
        menu.insert("t", "Start the Tutorial ", this::startTutorial);
        menu.insert("g", "Start Game", this::startGame);
        menu.insert("p", "Place Token", this::placeToken);
        menu.insert("m", "Move Token", this::moveToken);
        menu.insert("q", "Quit", null);
        Runnable choice;
        while ((choice = menu.exec()) != null) {
            choice.run();
        }
        System.out.println("Program finished");
    }

    protected String readLine() {
        String value = "\0";
        BufferedReader inReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            value = inReader.readLine();
        } catch (IOException e) {
        }
        return value.trim();
    }

    protected Double readDouble(int lowerlimit, int upperlimit) {
        Double number = null;
        while (number == null) {
            String str = this.readLine();
            try {
                number = Double.parseDouble(str);
            } catch (NumberFormatException e) {
                number = null;
                System.out.println("Please enter a valid number:");
                continue;
            }
            if (number < lowerlimit) {
                System.out.println("Please enter a higher number:");
                number = null;
            } else if (number > upperlimit) {
                System.out.println("Please enter a lower number:");
                number = null;
            }
        }
        return number;
    }
}
