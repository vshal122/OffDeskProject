package com.offDesk.offdeskproject.Model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="leave_record")
@Data

public class Leave {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "leave_id")
    private  Long LeaveId;

    @Column(name = "from_date")
    private  String fromDate;

    @Column(name="end_date")
     private String endDate;

    @Column(name = "leave_status",nullable = false)
    private String leaveStatus;

    public Leave(String fromDate, String endDate, String leaveStatus) {
        this.fromDate = fromDate;
        this.endDate = endDate;
        this.leaveStatus = leaveStatus;
    }
    public Leave(){}
}
