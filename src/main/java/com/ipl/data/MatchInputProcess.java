package com.ipl.data;

import com.ipl.model.Match;
import org.springframework.batch.item.ItemProcessor;

import java.time.LocalDate;

public class MatchInputProcess implements ItemProcessor<MatchProcess, Match> {

    @Override
    public Match process(MatchProcess matchProcess) throws Exception {
        Match newMatch = new Match();
        newMatch.setId(Long.parseLong(matchProcess.getId()));
        newMatch.setCity(matchProcess.getCity());
        newMatch.setDate(LocalDate.parse(matchProcess.getDate()));
        newMatch.setPlayerOfMatch(matchProcess.getPlayer_of_match());

        String firstInningsTeam, secondInningsTeam;
         if(matchProcess.getToss_decision().equals("bat"))
         {
             firstInningsTeam = matchProcess.getToss_winner();
             if(matchProcess.getTeam1().equals(firstInningsTeam))
                secondInningsTeam = matchProcess.getTeam2();
             else
                 secondInningsTeam = matchProcess.getTeam1();
         } else {
             secondInningsTeam = matchProcess.getToss_winner();
             if(matchProcess.getTeam1().equals(secondInningsTeam))
                 firstInningsTeam = matchProcess.getTeam2();
             else
                 firstInningsTeam = matchProcess.getTeam1();
         }
         newMatch.setTeam1(firstInningsTeam);
         newMatch.setTeam2(secondInningsTeam);
         newMatch.setTossWiinner(matchProcess.getToss_winner());
         newMatch.setTossDecision(matchProcess.getToss_decision());
         newMatch.setWinner(matchProcess.getWinner());
         newMatch.setResult(matchProcess.getResult());
         newMatch.setResultMargin(matchProcess.getResult_margin());
         newMatch.setUmpire1(matchProcess.getUmpire1());
         newMatch.setUmpire2(matchProcess.getUmpire2());
         return newMatch;
    }
}
