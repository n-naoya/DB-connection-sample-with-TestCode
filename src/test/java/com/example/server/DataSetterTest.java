package com.example.server;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.jdbc.core.JdbcOperations;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class DataSetterTest {

    @InjectMocks
    DataSetter dataSetter;

    @Mock
    JdbcOperations jdbcOperations;

    @Captor
    ArgumentCaptor<String> strArg;

    @Test
    public void the_parameters_are_correct_of_execute_method() {
//        dataSetter = new DataSetter(jdbcOperations); //@InjectMocksに記述したクラスはBean化されているためインスタンス化不要
        Mockito.verify(jdbcOperations).execute(strArg.capture());
        String sql = strArg.getValue();


        assertThat("CREATE TABLE USER_MASTER (ID varchar(40) primary key, NAME varchar(250))", equalTo(sql));
    }

    @Test
    public void the_parameters_are_correct_of_update_method() {
        Mockito.verify(jdbcOperations, Mockito.times(4)).update(strArg.capture());
        List<String> sqlList = strArg.getAllValues();


        assertThat(sqlList.get(0), equalTo("INSERT INTO USER_MASTER (ID, NAME) VALUES ('00000001', '1号')"));
        assertThat(sqlList.get(1), equalTo("INSERT INTO USER_MASTER (ID, NAME) VALUES ('00000002', '2号')"));
        assertThat(sqlList.get(2), equalTo("INSERT INTO USER_MASTER (ID, NAME) VALUES ('00000003', '3号')"));
        assertThat(sqlList.get(3), equalTo("INSERT INTO USER_MASTER (ID, NAME) VALUES ('00000004', '4号')"));
    }
}
