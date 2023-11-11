package com.example.tpcell.Repository;

import com.example.tpcell.Entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Students,Long> {
}
