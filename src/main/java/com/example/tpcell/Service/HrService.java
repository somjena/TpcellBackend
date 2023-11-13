package com.example.tpcell.Service;

import com.example.tpcell.Entity.Hrs;
import org.springframework.stereotype.Service;

import java.util.List;

public interface HrService {

    Hrs saveHrs(Hrs hrs);
    List<Hrs> getAll();
    Hrs getHrById(Long id);

    Hrs updateHrById(Hrs hr , Long id);

    void deleteHr(String hr,Long id);

}
