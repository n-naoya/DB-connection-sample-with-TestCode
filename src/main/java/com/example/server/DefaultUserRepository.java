package com.example.server;

import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DefaultUserRepository implements UserRepository {

    private JdbcOperations jdbcOperations;

    public DefaultUserRepository(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    @Override
    public List<User> getAll() {
        String sql = "SELECT * FROM USER_MASTER";
        return jdbcOperations.query(sql, new UserMapper());
    }

    @Override
    public User get(String id) {
        String sql = "SELECT * FROM USER_MASTER WHERE ID='" + id + "'";
        return jdbcOperations.queryForObject(sql, new UserMapper());
    }
}
