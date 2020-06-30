package study.studyspringcloudeurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class StudySpringCloudEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudySpringCloudEurekaServerApplication.class, args);
    }

}
