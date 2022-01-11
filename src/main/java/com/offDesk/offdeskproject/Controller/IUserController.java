package com.offDesk.offdeskproject.Controller;

import com.offDesk.offdeskproject.Dto.UserDto;
import com.offDesk.offdeskproject.Model.User;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
public interface IUserController {

    @PostMapping("/save")
    User createUser(@RequestBody UserDto userDto);

    @GetMapping("/get/{id}")
    User searchUser(@PathVariable Integer id);

    @DeleteMapping("delete/{id}")
    Boolean deleteUser(@PathVariable Integer id);

    @PutMapping("update/{id}")
    User updateUser(@RequestBody Integer id,@RequestBody User user);
}
