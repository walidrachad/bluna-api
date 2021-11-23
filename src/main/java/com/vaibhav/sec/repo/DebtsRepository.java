package com.vaibhav.sec.repo;

import com.vaibhav.sec.model.Debts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DebtsRepository extends JpaRepository<Debts,Long> {
    List<Debts> getByUserId(Long userId);
    List<Debts> getByDateContaining(String date);
}
