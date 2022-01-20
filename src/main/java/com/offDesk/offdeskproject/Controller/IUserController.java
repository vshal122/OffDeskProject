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
    User searchUser(@PathVariable Integer id);

    @DeleteMapping("delete/{id}")
    Boolean deleteUser(@PathVariable Integer id);

    @PutMapping("update/{id}")
    User updateUser(@RequestBody Integer id,@RequestBody User user);


    @GetMapping("/all_employee")
    List<User> getManagerEmployee();

    @GetMapping("/employee_by_managerid/{id}")
    List<User> getEmployeeByManagerId(@PathVariable("id") Integer id);

    @GetMapping("/giveLeaveByManager/{id}")
    Integer updateLeaveBalance(@PathVariable("id") Integer id) throws ParseException;

    @GetMapping("/checkLeave/{id}")
    Integer checkEmployeeLeave(@PathVariable("id") Integer id);
}
