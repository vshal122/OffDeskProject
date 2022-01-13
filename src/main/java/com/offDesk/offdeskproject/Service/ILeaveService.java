package com.offDesk.offdeskproject.Service;

import com.offDesk.offdeskproject.Model.Leave;

public interface ILeaveService {

    Leave takeLeaveByEmployee(Leave leave,Integer userIdForLeave);
}
