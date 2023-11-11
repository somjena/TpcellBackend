package com.example.tpcell.Service;

import com.example.tpcell.Entity.Students;
import com.example.tpcell.Entity.Tpos;

import java.util.List;

public interface TpoService {
    Tpos saveTpos(Tpos tpos);
    List<Tpos> getAll();
    Tpos getTposById(Long id);
    Tpos updateTposById(Tpos tpo , Long id);
    void deleteTpo(String tpo,Long id);
}
