package com.offDesk.offdeskproject.Service.ServiceImpl;

import com.offDesk.offdeskproject.Dao.ILeaveRepository;
import com.offDesk.offdeskproject.Dao.IUserRepository;
import com.offDesk.offdeskproject.Model.Leave;
import com.offDesk.offdeskproject.Model.User;
import com.offDesk.offdeskproject.Service.ILeaveService;
import com.offDesk.offdeskproject.Service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    IUserRepository iUserRegistry;

    @Autowired
    ILeaveService iLeaveService;

    @Autowired
    ILeaveRepository iLeaveRepository;

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

    @Override
    public List<User> getManagerEmployee() {
        return iUserRegistry.findAll();
    }

    @Override
    public List<User> getEmployeeByManagerId(Integer managerId) {

        return iUserRegistry.EmployeeWithManagerId(managerId);
    }

    @Override
    public Integer updateLeaveBalance(Integer id) throws ParseException {


       Leave leave = iLeaveRepository.findLeaveDetailsUsingUserId(id);
       User user = iUserRegistry.getById(id);
       Integer TotalLeave = user.getLeaveBalance();
        Integer leaveBalance=0;
       if(leave.getLeaveStatus().equalsIgnoreCase("waiting") && TotalLeave>0) {

           DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
           LocalDate endDate = LocalDate.parse(leave.getEndDate(),dtf);
           LocalDate fromDate = LocalDate.parse(leave.getFromDate(),dtf);
           Period diff = Period.between(endDate, fromDate);
           leaveBalance = -(diff.getDays());
           TotalLeave=TotalLeave-leaveBalance;
           leave.setLeaveStatus("accept");
           user.setLeaveBalance(TotalLeave);
           iUserRegistry.save(user);
           iLeaveRepository.save(leave);


       } else {
            leave.setLeaveStatus("reject");
            iLeaveRepository.save(leave);
            TotalLeave = user.getLeaveBalance();
            System.out.println("My else Method in UPDATE LEAVE BALANCE");
       }

        return TotalLeave;
    }

    @Override
    public Integer checkEmployeeLeave(Integer id) {

         User user = iUserRegistry.getById(id);
        return  user.getLeaveBalance();

    }
}
