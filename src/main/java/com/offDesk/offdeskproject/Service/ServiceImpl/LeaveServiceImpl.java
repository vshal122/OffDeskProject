package com.offDesk.offdeskproject.Service.ServiceImpl;

import com.offDesk.offdeskproject.Dao.ILeaveRepository;
import com.offDesk.offdeskproject.Model.Leave;
import com.offDesk.offdeskproject.Service.ILeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeaveServiceImpl implements ILeaveService {

    @Autowired
    ILeaveRepository iLeaveRepository;

    @Override
    public Leave takeLeaveByEmployee(Leave leave) {
        return iLeaveRepository.save(leave);
    }
}
