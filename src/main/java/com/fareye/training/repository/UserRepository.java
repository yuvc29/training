package com.fareye.training.repository;

import com.fareye.training.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String user);

    void deleteByEmail(String user);

    List<User> findAllByEmail(String user);
}
