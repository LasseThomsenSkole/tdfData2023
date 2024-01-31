package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TDFFileReader {
    private Scanner scanner;
    private List<Rider> riders;
    private Map<String,String> teamWithMembers;
    public TDFFileReader(String fileName) throws FileNotFoundException {
        scanner = new Scanner(new File(fileName));
        riders = readFile();
        teamWithMembers = getTeamsWithMembers();

    }

    public List<Rider> readFile(){
        List<Rider> riders = new ArrayList<>();
        while (scanner.hasNextLine()){
            String[] tokens = scanner.nextLine().split(";");
            int placement = Integer.parseInt(tokens[0]);
            String name = tokens[1];
            String team = tokens[2];

            riders.add(new Rider(placement, name, team));
        }
        return riders;
    }

    public Set<String> getTeams(){
        Set<String> teams = new HashSet<>();
        for (Rider rider : riders){
            teams.add(rider.getTeam());
        }
        return teams;
    }
    public Map<String, String> getTeamsWithMembers(){
        Map<String, String> membersWithTeams = new HashMap<>();
        for (Rider rider:riders){
            membersWithTeams.putIfAbsent(rider.getName(), rider.getTeam());
        }
        return membersWithTeams;
    }
    public Set<String> getTeamMembers(String team){
        Set<String> teamMembers = new HashSet<>();
        for (Map.Entry<String, String> entry: teamWithMembers.entrySet()){
            if (entry.getValue().equalsIgnoreCase(team)){
                teamMembers.add(entry.getKey());
            }
        }
        return teamMembers;
    }


}
