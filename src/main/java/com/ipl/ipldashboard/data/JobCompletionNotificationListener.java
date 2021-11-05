package com.ipl.ipldashboard.data;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JobCompletionNotificationListener extends JobExecutionListenerSupport {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JobCompletionNotificationListener(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        if(jobExecution.getStatus() == BatchStatus.COMPLETED){
            // SUCCESS

            jdbcTemplate.query("SELECT team1, team2, date from match",
                    (rs,row)->"[Team1: " + rs.getNString(1) +
                            "] [Team2: " + rs.getString(2) +
                            "] [Date : " + rs.getNString(3) + "]\n"
            ).forEach(str -> System.out.println(str));

        }
    }
}