package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
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

    @Transactional(readOnly = true)
    public List<User> findAll(){
        return entityManager.createQuery("from User", User.class)
                .getResultList();
    }

    @Transactional(readOnly = true)
    public User find(long id){
        return entityManager.find(User.class, id);
    }

    @Transactional
    public void save(User user){
        entityManager.persist(user);
    }

    @Transactional
    public void delete(long uid){
        User user = entityManager.find(User.class, uid);
        if(user!=null){
            entityManager.remove(user);
        }
    }

    @Transactional
    public void update(long id, User user){
        User updateUser = entityManager.find(User.class, id);
        if(updateUser!=null){
            updateUser.setName(user.getName());
            updateUser.setLastName(user.getLastName());
            updateUser.setAge(user.getAge());
        }
    }
}
