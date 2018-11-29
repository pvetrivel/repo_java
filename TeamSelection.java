package Game;

import java.util.Scanner;

public class TeamSelection {
    static String myTeam;
    int overs;
    static String opponent;
    Scanner input = new Scanner(System.in);

    /*public void gameSetup(){
        chooseCountry();
        chooseOpponent();


    }*/
    public void teamMenu() {
        System.out.println("Choose your myTeam by selecting 1 to 5 to select from list");

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
                if (myTeam == null) {
                    myTeam = "India";
                } else {
                    if (myTeam.equals("India")) {
                        System.out.println("Don't choose opponent team name as your team name");
                        teamMenu();
                    } else {
                        opponent = "India";
                    }
                }
                break;
            case 2:
                if (myTeam == null) {
                    myTeam = "Australia";
                } else {
                    if (myTeam.equals("Australia")) {
                        System.out.println("Don't choose opponent team name as your team name");
                        teamMenu();
                    } else {
                        opponent = "Australia";
                    }
                }
                break;
            case 3:
                if (myTeam == null) {
                    myTeam = "South Africa";
                } else {
                    if (myTeam.equals("South Africa")) {
                        System.out.println("Don't choose opponent team name as your team name");
                        teamMenu();
                    } else {
                        opponent = "South Africa";
                    }
                }
                break;
            case 4:
                if (myTeam == null) {
                    myTeam = "Srilanka";
                } else {
                    if (myTeam.equals("Srilanka")) {
                        System.out.println("Don't choose opponent team name as your team name");
                        teamMenu();
                    } else {
                        opponent = "Srilanka";
                    }
                }
                break;
            case 5:
                if (myTeam == null) {
                    myTeam = "Pakistan";
                } else {
                    if (myTeam.equals("Pakistan")) {
                        System.out.println("Don't choose opponent team name as your team name");
                        teamMenu();
                    } else {
                        opponent = "Pakistan";
                    }
                }
                break;
            default:

                if (myTeam == null) {
                    System.out.println("Enter your team name by yourself");
                    myTeam = input.nextLine();
                } else {
                    System.out.println("Enter your opponent name");
                    opponent = input.nextLine();
                }

        }
    }

    //choose myTeam method
        public void chooseCountry () {
        //Choosing players team
        System.out.println("Choose your team from list or enter by yourself");
        teamMenu();
        System.out.println("Choose opponent myTeam name");
        teamMenu();
    }



}

