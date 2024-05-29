package com.example.tigergrid.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.tigergrid.model.Form.Dropdown;

@Repository
public interface DropdownQuestionRepository extends JpaRepository<Dropdown, Long> {
}
