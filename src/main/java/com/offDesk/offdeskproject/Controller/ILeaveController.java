package com.offDesk.offdeskproject.Controller;

import com.offDesk.offdeskproject.Dto.LeaveDto;
import com.offDesk.offdeskproject.Model.Leave;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/offdesk/leave")
public interface ILeaveController {

    @PostMapping("/save")
    Leave takeLeave(@RequestBody LeaveDto leaveDto);

    @GetMapping("/getleaveuserbyemail/{email}")
    List<Leave> getLeaveRecordByMail(@PathVariable String email);
}
