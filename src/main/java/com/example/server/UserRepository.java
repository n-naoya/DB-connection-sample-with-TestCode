package com.example.server;

import java.util.List;

public interface UserRepository {
    List<User> getAll();
    User get(String id);
}
