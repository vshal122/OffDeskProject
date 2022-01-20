package com.offDesk.offdeskproject.Dao;

import com.offDesk.offdeskproject.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IUserRepository extends JpaRepository<User,Integer> {

    @Query(value = "select * from user_record c where  c.manager_user_id=?1",nativeQuery = true)
     List<User> EmployeeWithManagerId(Integer id);

    @Query(value = "select * from user_record c where c.email=?1",nativeQuery = true)
     User getUserByEmail(String email);
}
