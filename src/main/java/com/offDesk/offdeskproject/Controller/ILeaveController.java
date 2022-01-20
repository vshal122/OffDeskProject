package com.offDesk.offdeskproject.Controller;

import com.offDesk.offdeskproject.Dto.LeaveDto;
import com.offDesk.offdeskproject.Model.Leave;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/offdesk/leave")
public interface ILeaveController {

    @PostMapping("/save")
    Leave takeLeave(@RequestBody LeaveDto leaveDto);
}
