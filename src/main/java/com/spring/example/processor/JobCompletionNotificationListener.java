package com.spring.example.processor;

import com.spring.example.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 *
 * @author Tanawit Aeabsakul
 */
@Component
public class JobCompletionNotificationListener extends JobExecutionListenerSupport {
    
    private static final Logger log = LoggerFactory.getLogger(JobCompletionNotificationListener.class);
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Override
    public void afterJob(JobExecution jobExecution) {
        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
            log.info("!!! JOB FINISHED! Time to verify the result");
            jdbcTemplate.query("SELECT first_name, last_name FROM people", (rs, row) -> {
                return new Person(rs.getString(1), rs.getString(2));
            }).forEach(person -> log.info("Found <" + person + "> in the database."));
        }
    }
    
}
