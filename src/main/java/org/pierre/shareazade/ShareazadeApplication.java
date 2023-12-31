package org.pierre.shareazade;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.h2.tools.Server;
import java.sql.SQLException;

@SpringBootApplication(exclude={SecurityAutoConfiguration.class})
public class ShareazadeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShareazadeApplication.class, args);
    }



}
