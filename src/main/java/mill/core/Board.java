package mill.core;

public class Board {

    public String display(){
        return "Test";
    }

    public void printErklaerungsfeld(){
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

}
