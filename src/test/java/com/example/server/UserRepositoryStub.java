package com.example.server;

import java.util.List;

public class UserRepositoryStub implements UserRepository {

    boolean getAllWasCalled = false;
    boolean getWasCalled = false;

    @Override
    public List<User> getAll() {
        getAllWasCalled = true;
        return null;
    }

    @Override
    public User get(String id) {
        getWasCalled = true;
        return null;
    }
}
