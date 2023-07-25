package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    public List<User> findAll();
    public User find(long id);
    public void save(User user);
    public void delete(long uid);
    public void update(long id, User user);
}
