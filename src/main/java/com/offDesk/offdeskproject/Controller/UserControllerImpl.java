package com.offDesk.offdeskproject.Controller;

import com.offDesk.offdeskproject.Dao.IUserRepository;
import com.offDesk.offdeskproject.Dto.UserDto;
import com.offDesk.offdeskproject.Model.User;
import com.offDesk.offdeskproject.Service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

@RestController
public class UserControllerImpl implements IUserController{

    @Autowired
    IUserService iUserService;

    @Autowired
    IUserRepository iUserRepository;

    @Override
    public User createUser(UserDto userDto) {
        User user = new User(userDto.getUserName(),userDto.getPassword(),userDto.getJoinDate(),userDto.getMobile(),userDto.getGender(),userDto.getAddress(),userDto.getEmail(),userDto.getLeaveBalance(),userDto.getDesignation());
       if(userDto.getManagerId()==null)
       {
           return iUserService.userSave(user);
       }
       else {
           User managerUser = iUserRepository.getById(userDto.getManagerId());
           user.setManager(managerUser);
           return iUserService.userSave(user);
       }
    }

    @Override
    public User searchUser(Integer id) {
        return iUserService.getuser(id);
    }

    @Override
    public Boolean deleteUser(Integer id) {
        Boolean f= iUserService.deleteUser(id);
        return  f;
    }

    @Override
    public User updateUser(Integer id, User user) {
        return iUserService.updateUser(id,user);
    }

    @Override
    public List<User> getManagerEmployee() {
        return iUserService.getManagerEmployee();
    }

    @Override
    public List<User> getEmployeeByManagerId(Integer id) {
        return iUserService.getEmployeeByManagerId(id);
    }

    @Override
    public Integer updateLeaveBalance(Integer id) throws ParseException {
        return iUserService.updateLeaveBalance(id);
    }

    @Override
    public Integer checkEmployeeLeave(Integer id) {
        return iUserService.checkEmployeeLeave(id);
    }


}
