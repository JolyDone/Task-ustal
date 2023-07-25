package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    public List<User> findAll();
    public User find(long id);
    public void save(User user);
    public void delete(long uid);
    public void edit(long id, User user);
}
