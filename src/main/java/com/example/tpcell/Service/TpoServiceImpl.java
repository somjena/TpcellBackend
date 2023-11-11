package com.example.tpcell.Service;

import com.example.tpcell.Entity.Students;
import com.example.tpcell.Entity.Tpos;
import com.example.tpcell.Exception.ResourceNotFoundException;
import com.example.tpcell.Repository.TpoRepository;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class TpoServiceImpl implements TpoService{
    private TpoRepository tpoRepository;
    public TpoServiceImpl(TpoRepository tpoRepository){
        this.tpoRepository = tpoRepository;
    }

    @Override
    public Tpos saveTpos(Tpos tpos) {
        return tpoRepository.save(tpos);
    }

    @Override
    public List<Tpos> getAll() {
        return tpoRepository.findAll();
    }

    @Override
    public Tpos getTposById(Long id) {
        Optional<Tpos> tpos = tpoRepository.findById(id);
        if (tpos.isPresent()){return tpos.get();
    }else {
            throw new ResourceNotFoundException("Tpo","id",id);
        }
    }

    @Override
    public Tpos updateTposById(Tpos tpo, Long id) {
        Tpos existingTpo = tpoRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Tpos","Id","id"));
        existingTpo.setUsername(tpo.getUsername());
        existingTpo.setFirstName(tpo.getFirstName());
        existingTpo.setLastName(tpo.getLastName());
        existingTpo.setEmail(tpo.getEmail());
        existingTpo.setNumber(tpo.getNumber());
        existingTpo.setPassword(tpo.getPassword());
        tpoRepository.save(existingTpo);
        return existingTpo;
    }

    @Override
    public void deleteTpo(String tpo, Long id) {
        Tpos existingTpo = tpoRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Tpos","Id","id"));
        tpoRepository.delete(existingTpo);

    }
}
