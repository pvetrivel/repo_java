package Game;

import Game.model.Player;
import Game.model.Team;

public class MatchController {
    // TeamSelection selectTeam = new TeamSelection();
    Team team1 = new Team(1);
    Team team2 = new Team(2);
    static int teamScoredOn1stInn;
    static int teamScoredOn2ndInn;



    public void startMatch() {
        team1.playersList();
        team2.playersList();
        teamScoredOn1stInn = playInnings(team1, team2);
        //System.out.println("\nTarget: "+target+"\n");
        innSummary(team1, teamScoredOn1stInn);
        teamScoredOn2ndInn = playInnings(team2, team1,teamScoredOn1stInn);
        innSummary(team2, teamScoredOn2ndInn);
        endMatch(team1, team2);
        matchSummary();
    }
    void matchSummary(){
        scoreCard(team1);
        scoreCard(team2);
    }


    public int playInnings(Team bat, Team bowl) {
        int innScore = 0;
        int bowler ;
        int batsman = 0;
        while (batsman < 10) {
            bowler = Utils.doRandom(10);
            for (int balls = 0; balls < 6; balls++) {
                int runs = Utils.doRandom(8);
                if (batsman < 10) {
                    if (runs < 7) {
                        addRun(bat,batsman,runs);
                       // bat.playerInMatch[batsman].setScoredOnBatting(runs);
                        innScore += runs;
                    }else {
                        afterwicket(bat,bowl,batsman,bowler,balls);
                        batsman++;

                    }
                }
                }
                setBall(bat,bowl,batsman,bowler);
        }
        return innScore;
    }
    //overloading
    public int playInnings(Team bat, Team bowl,int target) {
        int innScore = 0;
        int bowler;
        int batsman = 0;
        while (batsman < 10) {
            bowler = Utils.doRandom(10);
            for (int balls = 0; balls < 6; balls++) {
                int runs = Utils.doRandom(8);
                if (batsman < 10 && (target>innScore)) {
                    if (runs < 7) {
                        //add runs
                        addRun(bat,batsman,runs);
                        innScore += runs;
                    }else {
                        afterwicket(bat,bowl,batsman,bowler,balls);
                        batsman++;
                    }
                }else {
                    return innScore;
                }
            }
            setBall(bat,bowl,batsman,bowler);
        }
        return innScore;
    }

    void endMatch(Team team1, Team team2) {
        if (teamScoredOn1stInn > teamScoredOn2ndInn) {
            System.out.println(team1.getTeamName() + " wonned the match\n");
        } else if (teamScoredOn2ndInn == teamScoredOn1stInn) {
            System.out.println("Match Tie\n");
        } else {
            System.out.println(team2.getTeamName() + " wonned the match\n");
        }
        //scoreCard();
        System.out.printf("\n \n **** Match Over****\n");
    }

    void innSummary(Team bat, int innScore) {
        Utils.printMessage("\n" + bat.getTeamName() + " Scored " + innScore + "\n");
    }

    void addRun(Team bat,int batsman,int runs) {
        bat.playerInMatch[batsman].setScoredOnBatting(runs);
    }

    void afterwicket(Team bat,Team bowl,int batsman,int bowler,int balls){
        bowl.playerInMatch[bowler].setWicketTaken();
        Utils.printMessage(bat.players[batsman].getName() + " scored " + bat.playerInMatch[batsman].getScoredOnBatting() + " for " + bat.playerInMatch[batsman].getOversPlayed() + "." + balls);
        Utils.printMessage(bat.players[batsman].getName() + " wicket taken by " + bat.players[bowler].getName());
        //batsman++;
    }


    void setBall(Team bat,Team bowl,int batsman,int bowler){
        bowl.playerInMatch[bowler].setBallsBowled();
        bat.playerInMatch[batsman].setBallsPlayed();

    }
    void scoreCard(Team team){
        Utils.printMessage("\n"+team.getTeamName()+" score card\n");
        for(int player=0;player<11;player++){
            Utils.printMessage("Player: "+team.players[player].getName()+" Score: "+team.playerInMatch[player].getScoredOnBatting()+" Wickets: "+team.playerInMatch[player].getWicketTaken());
        }
    }
}
