package com.mfrp.risk;

import java.sql.SQLException;

import javax.annotation.PostConstruct;

import org.h2.tools.Server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@SpringBootApplication
@EnableFeignClients
public class RiskApplication {

	

	public static void main(String[] args) {
		SpringApplication.run(RiskApplication.class, args);
	}
	

    /**
     * 
     * This will enable other apps to interact with h2 database with tcp port 8090
     * 
     */
	 
}
