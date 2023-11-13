package com.example.tpcell.Service;
import com.example.tpcell.Entity.Hrs;
import com.example.tpcell.Exception.ResourceNotFoundException;
import com.example.tpcell.Repository.HrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class HrServiceImpl implements HrService{
    private HrRepository hrRepository;
    @Autowired
    public HrServiceImpl(HrRepository hrRepository) {
        this.hrRepository = hrRepository;
    }

    @Override
    public Hrs saveHrs(Hrs hrs) {
        return hrRepository.save(hrs);
    }

    @Override
    public List<Hrs> getAll() {
        return hrRepository.findAll();
    }

    @Override
    public Hrs getHrById(Long id) {
        Optional<Hrs> hrs = hrRepository.findById(id);
        if (hrs.isPresent()){
            return hrs.get();
        }else {
            throw new ResourceNotFoundException("Hrid","id",id);
        }
    }

    @Override
    public Hrs updateHrById(Hrs hr, Long id) {
        Hrs existingHrs = hrRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Hrs","Id","id"));
        existingHrs.setUsername(hr.getUsername());
        existingHrs.setFirstName(hr.getFirstName());
        existingHrs.setLastname(hr.getLastname());
        existingHrs.setEmail(hr.getEmail());
        existingHrs.setCompany(hr.getCompany());
        existingHrs.setContact(hr.getContact());
        existingHrs.setPassword(hr.getPassword());
        hrRepository.save(existingHrs);
        return existingHrs;
    }

    @Override
    public void deleteHr(String hr, Long id) {
        Hrs existingHr = hrRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Hrs","Id","id"));
        hrRepository.delete(existingHr);

    }
}
