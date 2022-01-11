package com.offDesk.offdeskproject.Controller;

import com.offDesk.offdeskproject.Dao.ILeaveRepository;
import com.offDesk.offdeskproject.Dao.IUserRepository;
import com.offDesk.offdeskproject.Dto.LeaveDto;
import com.offDesk.offdeskproject.Model.Leave;
import com.offDesk.offdeskproject.Model.User;
import com.offDesk.offdeskproject.Service.ILeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
        Leave leave = new Leave(leaveDto.getFromDate(),leaveDto.getEndDate(),leaveDto.isLeaveStatus());
        iLeaveRepository.save(leave);

        User user = iUserRepository.getById(leaveDto.getUserLeaveId());

        List<Leave> listOfLeave = user.getLeaveDetails();
        listOfLeave.add(leave);

        user.setLeaveDetails(listOfLeave);

        iUserRepository.save(user);

        return null;
    }
}
