package com.offDesk.offdeskproject.Dto;

import lombok.Data;

@Data
public class UserDto {
    private String userName;
    private String password;
    private String joinDate;
    private String mobile;
    private String address;
    private String email;
    private  String gender;
    private Integer leaveBalance;
    private String designation;
    private Integer managerId;
}