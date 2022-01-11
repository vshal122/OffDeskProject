package com.offDesk.offdeskproject.Dao;

import com.offDesk.offdeskproject.Model.Leave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILeaveRepository extends JpaRepository<Leave,Long> {
}
