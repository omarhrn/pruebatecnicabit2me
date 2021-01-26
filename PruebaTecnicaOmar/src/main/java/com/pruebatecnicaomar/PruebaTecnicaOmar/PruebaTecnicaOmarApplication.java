package com.pruebatecnicaomar.PruebaTecnicaOmar;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobListener;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.quartz.SchedulerFactoryBeanCustomizer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PruebaTecnicaOmarApplication {

	public static void main(String[] args) {
		SpringApplication.run(PruebaTecnicaOmarApplication.class, args);
	}

	@Bean(name = "EnviarEmailJob")
    public JobDetail quartzJob() {
        return JobBuilder.newJob(EnviarEmailJob.class)
                .withIdentity("EnviarEmailJob", "QuartzJobs")
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger quartzTrigger(@Qualifier("EnviarEmailJob") JobDetail job) {
        return TriggerBuilder.newTrigger().forJob(job)
            .withIdentity("EnviarEmailTrigger", "QuartzJobs")
            .withDescription("EnviarEmail trigger")
            .withSchedule(SimpleScheduleBuilder.simpleSchedule().repeatForever().withIntervalInSeconds(3600))
            .build();
    }

    @Bean
    public Trigger cronQuartzTrigger(@Qualifier("EnviarEmailJob") JobDetail job) {
        return TriggerBuilder.newTrigger().forJob(job)
                .withIdentity("EnviarEmailTrigger", "QuartzJobs")
                .withDescription("Cron Quartz trigger")
                .withSchedule(CronScheduleBuilder.cronSchedule("0 0 0/1 ? * * *"))
                .build();
    }

    @Bean(name = "ActualizarCriptomonedasJob")
    public JobDetail actCriptoQuartzJob() {
        return JobBuilder.newJob(ActualizarCriptomonedasJob.class)
                .withIdentity("ActualizarCriptomonedasJob", "QuartzJobs")
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger actCriptoQuartzTrigger(@Qualifier("ActualizarCriptomonedasJob") JobDetail job) {
        return TriggerBuilder.newTrigger().forJob(job)
            .withIdentity("ActualizarCriptomonedasTrigger", "QuartzJobs")
            .withDescription("ActualizarCriptomonedas trigger")
            .withSchedule(SimpleScheduleBuilder.simpleSchedule().repeatForever().withIntervalInSeconds(60))
            .build();
    }

    @Bean
    public Trigger actCriptoCronQuartzTrigger(@Qualifier("ActualizarCriptomonedasJob") JobDetail job) {
        return TriggerBuilder.newTrigger().forJob(job)
                .withIdentity("ActualizarCriptomonedasTrigger", "QuartzJobs")
                .withDescription("ActualizarCriptomonedasJob Cron Quartz trigger")
                .withSchedule(CronScheduleBuilder.cronSchedule("0 0/1 0 ? * * *"))
                .build();
    }
}
