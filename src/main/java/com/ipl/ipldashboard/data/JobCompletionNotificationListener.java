package com.ipl.ipldashboard.data;

import com.ipl.ipldashboard.model.Team;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.Map;

@Component
public class JobCompletionNotificationListener extends JobExecutionListenerSupport {

    private final EntityManager entityManager;

    @Autowired
    public JobCompletionNotificationListener(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void afterJob(JobExecution jobExecution) {
        if(jobExecution.getStatus() == BatchStatus.COMPLETED){
            // SUCCESS
            Map<String, Team> teamMap = new HashMap<>();
            entityManager.createQuery("SELECT team1, team2, matchWinner FROM Match", Object[].class)
                    .getResultList()
                    .stream()
                    .map(e-> {
                        Team newTeam = null;
                        if (!teamMap.containsKey(e[0]) ) {
                            newTeam = new Team();
                            newTeam.setTeamName((String)e[0]); newTeam.setTotalMatches(1); newTeam.setTotalWins(0);
                            if(e[2].equals(e[0]))
                                newTeam.setTotalWins(1);
                        } else {
                            Team existingTeam = teamMap.get(e[0]);
                            existingTeam.setTotalMatches(existingTeam.getTotalMatches()+1);
                            if(e[2].equals(e[0]))
                                existingTeam.setTotalWins(existingTeam.getTotalWins()+1);
                        }
                        if (!teamMap.containsKey(e[1]) ) {
                            newTeam = new Team();
                            newTeam.setTeamName((String)e[1]); newTeam.setTotalMatches(1); newTeam.setTotalWins(0);
                            if(e[2].equals(e[1]))
                                newTeam.setTotalWins(1);
                        } else {
                            Team existingTeam = teamMap.get(e[1]);
                            existingTeam.setTotalMatches(existingTeam.getTotalMatches()+1);
                            if(e[2].equals(e[1]))
                                existingTeam.setTotalWins(existingTeam.getTotalWins()+1);
                        }

                        return newTeam;
                    })
                            .forEach(team->{
                                if(team!=null)
                                    teamMap.put(team.getTeamName(), team);
                            });
            teamMap.values().forEach(team -> entityManager.persist(team));
            //teamMap.values().forEach(team -> System.out.println(team));

        }
    }
}