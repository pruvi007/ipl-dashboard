package com.ipl.ipldashboard.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.List;

@Entity
public class Team {
    @Id @GeneratedValue @Setter @Getter
    private long id;

    @Setter @Getter
    private String teamName;

    @Setter @Getter
    private long totalMatches;

    @Setter @Getter
    private long totalWins;

    @Transient @Setter @Getter
    List<Match> matchList;

    @Override
    public String toString() {
        return "{ teamName: " + teamName +
                ", totalMatches: " + totalMatches +
                ", totalWins: " + totalWins + "}";
    }
}
