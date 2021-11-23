package com.vaibhav.sec.repo;

import com.vaibhav.sec.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client,Long> {
    Client getByPhone(String phone);
    Client getById(Long id);
    List<Client> getByGender(String gender);
    List<Client> getByDateOfbrithContaining(String gender);
}
