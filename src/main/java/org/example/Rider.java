package org.example;

public class Rider {
    private int placement;
    private String name;
    private String team;

    public Rider(int placement,String name, String team){
        this.placement = placement;
        this.name = name;
        this.team = team;
    }

    public int getPlacement() {
        return placement;
    }

    public String getName() {
        return name;
    }

    public String getTeam() {
        return team;
    }
}
