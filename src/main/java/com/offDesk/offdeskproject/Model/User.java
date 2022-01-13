package com.offDesk.offdeskproject.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user_record")
@Data
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler"})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Integer userId;

    @Column(name = "user_name")
    private  String  userName;

    @Column(name="user_password")
    private String password;

    @Column(name="join_date")
    private  String joinDate;

    private  String mobile;

    private  String gender;

    private  String address;

    private  String email;

    @Column(name = "leave_balance")
    private Integer leaveBalance;


    private  String designation;


    @OneToOne(cascade={CascadeType.ALL})
    private User manager;


    @JsonBackReference
    @OneToMany(mappedBy = "manager")
    private Set<User> listOfuser = new HashSet<User>();

    //@JsonIgnore
    @OneToMany(fetch= FetchType.EAGER,cascade= CascadeType.ALL,targetEntity = Leave.class)
    @JoinColumn
    private List<Leave> leaveDetails;

    public User(String userName, String password, String joinDate, String mobile,String gender ,String address, String email, Integer leaveBalance, String designation) {
        this.userName = userName;
        this.password = password;
        this.joinDate = joinDate;
        this.mobile = mobile;
        this.gender=gender;
        this.address = address;
        this.email = email;
        this.leaveBalance = leaveBalance;
        this.designation = designation;
    }

    public User() {
    }
}
