package core;

import java.util.ArrayList;

public class Team 
{
    // member variables
    private ArrayList<Player> team;
    private int teamScore;
    private int teamTricks;
    private String teamName;
    
    public Team()
    {
        team = new ArrayList();
    }

    public void outputTeam()
    {
        System.out.println(teamName + " includes players: ");
        
        for(Player player : team)
        {
            System.out.println(player.getName());
        }
    }
    
    public void outputHands()
    {
        //System.out.println("*************************");
        //System.out.println("        " + teamName.toUpperCase());
        //System.out.println("*************************");      

        for(Player player : team)
        {
            player.sortBySuit();
            
            //if(player instanceof HumanPlayer)
                //player.displayHand();
        }
    }
    
    public int getTeamScore() 
    {
        return teamScore;
    }

    public void setTeamScore(int teamScore) 
    {
        this.teamScore = teamScore;
    }

    public int getTeamTricks() 
    {
        return teamTricks;
    }

    public void setTeamTricks(int teamTricks) 
    {
        this.teamTricks = teamTricks;
    }

    public ArrayList<Player> getTeam() 
    {
        return team;
    }

    public void setTeam(ArrayList<Player> teamOne) 
    {
        this.team = teamOne;
    }

    public String getTeamName() 
    {
        return teamName;
    }

    public void setTeamName(String teamName) 
    {
        this.teamName = teamName;
    }
}
