package com.example.server;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;

@RunWith(MockitoJUnitRunner.class)
public class DefaultUserRepositoryTest {

    @InjectMocks
    DefaultUserRepository defaultUserRepository;

    @Mock
    JdbcOperations jdbcOperations;

    @Captor
    ArgumentCaptor<String> strArg;

    @Captor
    ArgumentCaptor<RowMapper> mapperArg;

    @Test
    public void param_of_query_method_are_correct() {
        defaultUserRepository.getAll();


        Mockito.verify(jdbcOperations).query(strArg.capture(), mapperArg.capture());
        String sql = strArg.getValue();
        String className = mapperArg.getValue().getClass().getSimpleName();


        assertThat(sql, equalTo("SELECT * FROM USER_MASTER"));
        assertThat(className, equalTo("UserMapper"));
    }

    @Test
    public void return_value_of_getAll_method_are_correct() {
        List<User> userList = asList(new User("p-0001", "martin"));
        Mockito.when(jdbcOperations.query(anyString(), any(RowMapper.class))).thenReturn(userList);


        List<User> returnedUserList = defaultUserRepository.getAll();


        assertThat(returnedUserList, equalTo(userList));
    }
}
