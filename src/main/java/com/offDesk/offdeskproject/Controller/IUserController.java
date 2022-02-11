package com.offDesk.offdeskproject.Controller;

import com.offDesk.offdeskproject.Dto.UserDto;
import com.offDesk.offdeskproject.Model.User;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
@CrossOrigin("*")
@RequestMapping("/offdesk/user")
public interface IUserController {

    @PostMapping("/save")
    User createUser(@RequestBody UserDto userDto);

    @GetMapping("/get/{id}")
    User searchUser(@PathVariable Long id);

    @DeleteMapping("delete/{id}")
    Boolean deleteUser(@PathVariable Long id);

    @PutMapping("update/{id}")
    User updateUser(@RequestBody Long id,@RequestBody User user);


    @GetMapping("/all_employee")
    List<User> getManagerEmployee();

    @GetMapping("/employee_by_managerid/{email}")
    List<User> getEmployeeByManagerEmail(@PathVariable String email);

    @GetMapping("/giveApproveByManager/{id}")
    Boolean giveLeaveApproveByManager(@PathVariable("id") Long id) throws ParseException;

    @GetMapping("/getuserbyemail/{email}")
    User getUserByemail(@PathVariable("email") String email);

    @GetMapping("RejectByManager/{id}")
    Boolean rejectLeaveByManager(@PathVariable("id") Long leaveId);

    @GetMapping("GetAllEmployeeWithApprovedOrWaitByManager/{email}")
    List<User> getEmployeeWaitAndApprovedState(@PathVariable String email);

    @GetMapping("/getAllmanager")
    List<String> getEmailAllManager();


}
