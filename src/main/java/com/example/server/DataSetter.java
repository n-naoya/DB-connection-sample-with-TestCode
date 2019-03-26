package com.example.server;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcOperations;

@Configuration
@Profile("e2e")
public class DataSetter {
    public DataSetter(JdbcOperations jdbc) {
        jdbc.execute("CREATE TABLE USER_MASTER (ID varchar(40) primary key, NAME varchar(250))");
        jdbc.update("INSERT INTO USER_MASTER (ID, NAME) VALUES ('00000001', '1号')");
        jdbc.update("INSERT INTO USER_MASTER (ID, NAME) VALUES ('00000002', '2号')");
        jdbc.update("INSERT INTO USER_MASTER (ID, NAME) VALUES ('00000003', '3号')");
        jdbc.update("INSERT INTO USER_MASTER (ID, NAME) VALUES ('00000004', '4号')");
    }
}
