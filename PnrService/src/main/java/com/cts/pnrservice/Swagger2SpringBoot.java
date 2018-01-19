package com.cts.pnrservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import com.cts.pnrservice.manager.DBConfig;
import com.cts.pnrservice.manager.DBProperties;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@Configuration
public class Swagger2SpringBoot implements CommandLineRunner {

    @Override
    public void run(String... arg0) throws Exception {
        if (arg0.length > 0 && arg0[0].equals("exitcode")) {
            throw new ExitException();
        }
    }

    public static void main(String[] args) throws Exception {
    	
    	/*ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(Swagger2SpringBoot.class)
                .properties("spring.config.name:application",
                        "spring.config.location:classpath:/src/main/resources").build().run(args);
 
        ConfigurableEnvironment environment = applicationContext.getEnvironment();*/
        
    	/*AbstractApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);
    	 
    	DBProperties appProperties = context.getBean(DBProperties.class);
 
        System.out.println("host-->"+appProperties.getHost());*/
    	
        new SpringApplication(Swagger2SpringBoot.class).run(args);
    }

    class ExitException extends RuntimeException implements ExitCodeGenerator {
        private static final long serialVersionUID = 1L;

        @Override
        public int getExitCode() {
            return 10;
        }

    }
}
