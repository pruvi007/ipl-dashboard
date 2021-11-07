package com.ipl.ipldashboard.repository;

import com.ipl.ipldashboard.model.Match;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface MatchRepository extends CrudRepository<Match, Long> {
    List<Match> findByTeam1OrTeam2OrderByDateDesc(String team1, String team2);
}
