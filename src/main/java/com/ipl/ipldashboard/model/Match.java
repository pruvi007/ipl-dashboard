package com.ipl.ipldashboard.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Match {
    @Id
    @Setter @Getter
    private long id;

    @Setter @Getter
    private String city;

    @Setter @Getter
    private LocalDate date;

    @Setter @Getter
    private String playerOfMatch;

    @Setter @Getter
    private String venue;

    @Setter @Getter
    private String team1;

    @Setter @Getter
    private String team2;

    @Setter @Getter
    private String tossWinner;

    @Setter @Getter
    private String tossDecision;

    @Setter @Getter
    private String matchWinner;

    @Setter @Getter
    private String result;

    @Setter @Getter
    private String resultMargin;

    @Setter @Getter
    private String eliminator;

    @Setter @Getter
    private String umpire1;

    @Setter @Getter
    private String umpire2;
}
