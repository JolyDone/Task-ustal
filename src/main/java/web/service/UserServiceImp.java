package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.UserDaoImp;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImp {

    private final UserDaoImp userDaoImp;

    @Autowired
    public UserServiceImp(UserDaoImp userDaoImp) {
        this.userDaoImp = userDaoImp;
    }

    public List<User> findAll(){
        return userDaoImp.findAll();
    }

    public User find(long id){
        return userDaoImp.find(id);
    }

    public void save(User user){
        userDaoImp.save(user);
    }

    public void delete(long uid){
        userDaoImp.delete(uid);
    }
    public void edit(long id, User user){
        userDaoImp.update(id, user);
    }

}
