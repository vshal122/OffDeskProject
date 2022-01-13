package com.offDesk.offdeskproject.Service;

import com.offDesk.offdeskproject.Model.User;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

@Service
public interface IUserService {

     User userSave(User user);

     User getuser(Integer id);

     Boolean deleteUser(Integer id);

     User updateUser(Integer id,User user);

     List<User> getManagerEmployee();

     List<User> getEmployeeByManagerId(Integer managerId);

     Integer updateLeaveBalance(Integer id) throws ParseException;

     Integer checkEmployeeLeave(Integer id);
}
