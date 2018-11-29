package Game.model;

import Game.Match;

import java.util.Scanner;

public class Team {
    long id;
    String name;
    public Player[] players = new Player[11];
    public Match[] playerInMatch=new Match[11];
    Scanner input = new Scanner(System.in);

    public Team(int j) {
        chooseCountry();
        System.out.println("Team name "+name);
        for (int player = 0; player < 11; player++) {
            players[player] = new Player();
            playerInMatch[player]=new Match();
            String s = "t" + j + "p" + (player + 1);
            players[player].setName(s);

        }

    }

    public void playersList() {
        for (int player = 0; player < 11; player++) {
            System.out.println(players[player].getName());
        }
        System.out.println();
    }
    public String getTeamName(){
        return name;
    }
    public void chooseCountry () {
        //Choosing players team
        System.out.println("Choose your team from list or enter by yourself");
        teamMenu();

    }

    //team menu
    public void teamMenu() {
        System.out.println("Choose team by selecting 1 to 5 to select from list");

        System.out.println("1. India <Press 1>");
        System.out.println("2.Australia <Press 2>");
        System.out.println("3. South Africa <Press 3>");
        System.out.println("4. Srilanka <Press 4>");
        System.out.println("5. Pakistan <Press 5>");
        //choosing contries

        int menuOption = input.nextInt();
        input.nextLine();
        switch (menuOption) {
            case 1:
                        name = "India";
                break;
            case 2:
                        name = "Australia";
                break;
            case 3:
                        name= "South Africa";
                break;
            case 4:
                name = "Srilanka";
                break;
            case 5:
                        name = "Pakistan";
                break;
            default:
                    System.out.println("Enter your opponent name");
                    name = input.nextLine();


        }
    }


}
