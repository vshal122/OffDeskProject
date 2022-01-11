package com.offDesk.offdeskproject.Dao;

import com.offDesk.offdeskproject.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User,Integer> {


}
