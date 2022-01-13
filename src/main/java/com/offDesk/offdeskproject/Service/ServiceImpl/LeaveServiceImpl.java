package com.offDesk.offdeskproject.Service.ServiceImpl;

import com.offDesk.offdeskproject.Dao.ILeaveRepository;
import com.offDesk.offdeskproject.Dao.IUserRepository;
import com.offDesk.offdeskproject.Model.Leave;
import com.offDesk.offdeskproject.Model.User;
import com.offDesk.offdeskproject.Service.ILeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveServiceImpl implements ILeaveService {

    @Autowired
    ILeaveRepository iLeaveRepository;

    @Autowired
    IUserRepository iUserRepository;

    @Override
    public Leave takeLeaveByEmployee(Leave leave,Integer userIdForLeave) {

        iLeaveRepository.save(leave);

        User user = iUserRepository.getById(userIdForLeave);

        List<Leave> listOfLeave = user.getLeaveDetails();
        listOfLeave.add(leave);

        user.setLeaveDetails(listOfLeave);

        iUserRepository.save(user);


        return leave;
    }
}
