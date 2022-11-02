package com.fareye.training.repository;
import com.fareye.training.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long>{




    List<Todo> findAllByEmail(String email);

    Todo findByTitleAndEmail(String title, String email);

    void deleteByTitleAndEmail(String title, String email);
}
