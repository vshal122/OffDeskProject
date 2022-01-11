package com.offDesk.offdeskproject.Service.ServiceImpl;

import com.offDesk.offdeskproject.Dao.IUserRepository;
import com.offDesk.offdeskproject.Model.User;
import com.offDesk.offdeskproject.Service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    IUserRepository iUserRegistry;

    @Override
    public User userSave(User user) {
        return iUserRegistry.save(user);

    }

    @Override
    public User getuser(Integer id) {
        return iUserRegistry.getById(id);
    }

    @Override
    public Boolean deleteUser(Integer id) {
        Boolean f=false;

        User user = iUserRegistry.getById(id);
        user.setManager(null);
        if(!f) {
            iUserRegistry.delete(user);
            f=true;
        }
        return f;

    }

    @Override
    public User updateUser(Integer id, User user) {
        user.setUserId(id);
        return iUserRegistry.save(user);
    }
}
