package web.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

@Repository
public class UserDaoImp implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> findAll(){
        return entityManager.createQuery("from User", User.class)
                .getResultList();
    }

    @Override
    public User find(long id){
        return entityManager.find(User.class, id);
    }

    @Override
    public void save(User user){
        entityManager.persist(user);
    }
    @Override
    public void delete(long uid){
        User userDelete = entityManager.find(User.class,uid);
        entityManager.remove(userDelete);
    }
    @Override
    public void update(long id, User user){
        User updateUser = entityManager.find(User.class, id);
        if(updateUser!=null){
            updateUser.setName(user.getName());
            updateUser.setLastName(user.getLastName());
            updateUser.setAge(user.getAge());
        }
    }
}