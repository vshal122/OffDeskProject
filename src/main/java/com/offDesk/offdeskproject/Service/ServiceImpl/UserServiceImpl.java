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

import static java.lang.Math.abs;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    IUserRepository iUserRepository;

    @Autowired
    ILeaveService iLeaveService;

    @Autowired
    ILeaveRepository iLeaveRepository;

    @Override
    public User userSave(User user) {
        return iUserRepository.save(user);

    }

    @Override
    public User getuser(Long id) {
        return iUserRepository.getById(id);
    }

    @Override
    public Boolean deleteUser(Long id) {
        Boolean f=false;

        User user = iUserRepository.getById(id);
        user.setManager(null);
        if(!f) {
            iUserRepository.delete(user);
            f=true;
        }
        return f;

    }

    @Override
    public User updateUser(Long id, User user) {
        user.setUserId(id);
        return iUserRepository.save(user);
    }

    @Override
    public List<User> getManagerEmployee() {
        return iUserRepository.findAll();
    }

    @Override
    public List<User> getEmployeeByManagerEmail(String email) {

       User user= iUserRepository.getUserByEmail(email);
        return iUserRepository.EmployeeWithManagerId(user.getUserId());
    }

    @Override
    public Boolean giveLeaveApproveByManager(Long leaveId) throws ParseException {
        Integer newleave=0,oldLeaveBalance=0,oldTakenLeave=0,oldTotalLeave=0,oldExtraLeave=0;
        Leave leave = iLeaveRepository.getById(leaveId);
        Long userIdBYLeaveId=iLeaveRepository.findUserIdByLeaveId(leaveId);
        Leave   Oldleave = iLeaveRepository.findLeaveForBalance(userIdBYLeaveId);
        oldLeaveBalance=Oldleave.getLeaveBalance();
        oldExtraLeave=Oldleave.getExtraLeave();
        oldTakenLeave=Oldleave.getTakenLeave();
        oldTotalLeave=Oldleave.getTotalLeave();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate endDate = LocalDate.parse(leave.getEndDate(),dtf);
        LocalDate fromDate = LocalDate.parse(leave.getFromDate(),dtf);
        Period diff = Period.between(endDate, fromDate);
        newleave = abs(diff.getDays());
        if(leave.getLeaveBalance()<13 && leave.getLeaveBalance()>0)
        {
            leave.setLeaveBalance(oldLeaveBalance-newleave);
            leave.setTakenLeave(newleave+oldTakenLeave);
            leave.setTotalLeave(oldTotalLeave+newleave);
            leave.setExtraLeave(oldExtraLeave);
            leave.setLeaveStatus("Approved");
            iLeaveRepository.save(leave);
            return  true;

        }
        else if(leave.getLeaveBalance()==0)
        {
            leave.setTakenLeave(oldTakenLeave+newleave);
            leave.setExtraLeave(newleave+oldExtraLeave);
            leave.setTotalLeave(oldTotalLeave+newleave);
            leave.setLeaveStatus("Approved");
            iLeaveRepository.save(leave);
            return  true;
        }
       else {
           return  false;
        }





    }

    @Override
    public User getUserByEmail(Long id) {

         User user = iUserRepository.getById(id);
        return  user;

    }

 @Override
 public Boolean rejectLeaveByManager(Long leaveId)
   {
       Boolean temp=false;
       Leave leave = iLeaveRepository.getById(leaveId);
       if(leave.getLeaveStatus().equalsIgnoreCase("waiting"))
       {
           leave.setLeaveStatus("Reject");
           iLeaveRepository.save(leave);
           temp= true;
       }
   return  temp;

   }

    @Override
    public List<User> getEmployeeWaitAndApprovedState(String email) {
        User user = iUserRepository.getUserByEmail(email);
        return iUserRepository.getAllEmployeeWithStatusWaitAndApprove(user.getUserId());
    }
}
