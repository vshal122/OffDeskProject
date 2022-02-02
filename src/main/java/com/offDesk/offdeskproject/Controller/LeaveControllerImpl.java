package com.offDesk.offdeskproject.Controller;

import com.offDesk.offdeskproject.Dao.ILeaveRepository;
import com.offDesk.offdeskproject.Dao.IUserRepository;
import com.offDesk.offdeskproject.Dto.LeaveDto;
import com.offDesk.offdeskproject.Model.Leave;
import com.offDesk.offdeskproject.Model.User;
import com.offDesk.offdeskproject.Service.ILeaveService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class LeaveControllerImpl implements ILeaveController{

    @Autowired
    ILeaveService iLeaveService;
    @Autowired
    IUserRepository iUserRepository;
    @Autowired
    ILeaveRepository iLeaveRepository;

    @Override
    public Leave takeLeave(LeaveDto leaveDto) {
        Leave leave = new Leave(leaveDto.getFromDate(),leaveDto.getEndDate(),leaveDto.getLeaveStatus());
        Integer  userIdForLeave = leaveDto.getUserLeaveId();
      return   iLeaveService.takeLeaveByEmployee(leave,userIdForLeave);


    }

    @Override
    public List<Leave> getLeaveRecordByMail(String email) {
        log.info("Leave Controller Inside ......GetLeaveRecord By Method");
       User user= iUserRepository.getUserByEmail(email);
       log.info(" User: {}",user);
       return iLeaveService.getLeaveRecordByMail(user.getUserId());
    }
}
