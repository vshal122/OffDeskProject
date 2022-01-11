package com.offDesk.offdeskproject.Dto;

import lombok.Data;

@Data
public class LeaveDto {

    private  Long LeaveId;

    private  String fromDate;

    private String endDate;

    private Integer userLeaveId;

    private  boolean leaveStatus;

}
