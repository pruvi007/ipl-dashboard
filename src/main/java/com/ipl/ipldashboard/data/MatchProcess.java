package com.ipl.ipldashboard.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class MatchProcess {
    @Setter @Getter
    private String id;

    @Setter @Getter
    private String city;

    @Setter @Getter
    private String date;

    @Setter @Getter
    private String player_of_match;

    @Setter @Getter
    private String venue;

    @Setter @Getter
    private String neutral_venue;

    @Setter @Getter
    private String team1;

    @Setter @Getter
    private String team2;

    @Setter @Getter
    private String toss_winner;

    @Setter @Getter
    private String toss_decision;

    @Setter @Getter
    private String winner;

    @Setter @Getter
    private String result;

    @Setter @Getter
    private String result_margin;

    @Setter @Getter
    private String eliminator;

    @Setter @Getter
    private String method;

    @Setter @Getter
    private String umpire1;

    @Setter @Getter
    private String umpire2;

}
