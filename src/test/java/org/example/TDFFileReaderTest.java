package org.example;

import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class TDFFileReaderTest {

    TDFFileReader tdfFileReader = new TDFFileReader("tdfData2023.csv");

    TDFFileReaderTest() throws FileNotFoundException {
    }

    @org.junit.jupiter.api.Test
    void getTeams() {
       Set<String> teams = tdfFileReader.getTeams();
       int expectedSize = 22;
       assertEquals(expectedSize, teams.size());
       assertTrue(teams.contains("Jumbo-Visma"));
    }

    @org.junit.jupiter.api.Test
    void getTeamsWithMembers() {
        Map<String, String> membersWithTeam = tdfFileReader.getTeamsWithMembers();
        int expectedSize = 150;
        assertEquals(expectedSize, membersWithTeam.size());
        assertTrue(membersWithTeam.containsKey("Bob Jungels"));
    }

    @org.junit.jupiter.api.Test
    void getTeamMembers() {
        Set<String> teamMembers = tdfFileReader.getTeamMembers("Jumbo-Visma");
        int expectedSize = 7;
        assertTrue(teamMembers.contains("Jonas Vingegaard"));
        assertEquals(expectedSize, teamMembers.size());
    }
}