package com.ipl.ipldashboard.controller;

import com.ipl.ipldashboard.model.Team;
import com.ipl.ipldashboard.repository.MatchRepository;
import com.ipl.ipldashboard.repository.TeamRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Pageable;

@RestController
@NoArgsConstructor
public class TeamController {
    private final int pageSize = 5;
    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private MatchRepository matchRepository;

    @GetMapping("/team/{teamName}")
    public Team getTeam(@PathVariable String teamName){
        Team team = teamRepository.findByTeamName(teamName);
        Pageable pageable = (Pageable) PageRequest.of(0, pageSize);
        team.setMatchList( matchRepository.findByTeam1OrTeam2OrderByDateDesc(teamName, teamName) );
        return team;
    }
}
