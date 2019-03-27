package com.example.server;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;

@RunWith(MockitoJUnitRunner.class)
public class UserMapperTest {
    @InjectMocks
    UserMapper userMapper;

    @Mock
    ResultSet resultSet;

    @Test
    public void return_value_of_mapRow_method_are_correct() throws SQLException {
        Mockito.when(resultSet.getString("ID")).thenReturn("p-0001");
        Mockito.when(resultSet.getString("NAME")).thenReturn("martin");


        User user = userMapper.mapRow(resultSet, anyInt());


        assertThat(user.getId(), equalTo("p-0001"));
        assertThat(user.getName(), equalTo("martin"));
    }
}
