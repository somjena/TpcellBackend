package com.example.tpcell.Repository;

import com.example.tpcell.Entity.Tpos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TpoRepository extends JpaRepository<Tpos,Long> {
}
