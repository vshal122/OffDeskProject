package com.offDesk.offdeskproject.Service;

import com.offDesk.offdeskproject.Model.Leave;

import java.util.List;

public interface ILeaveService {

    Leave takeLeaveByEmployee(Leave leave,Integer userIdForLeave);

     List<Leave> getLeaveRecordByMail(Integer id);
}
