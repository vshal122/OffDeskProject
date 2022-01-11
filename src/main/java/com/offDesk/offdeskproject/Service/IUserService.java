package com.offDesk.offdeskproject.Service;

import com.offDesk.offdeskproject.Model.User;
import org.springframework.stereotype.Service;

@Service
public interface IUserService {

     User userSave(User user);

     User getuser(Integer id);

     Boolean deleteUser(Integer id);

     User updateUser(Integer id,User user);

}
