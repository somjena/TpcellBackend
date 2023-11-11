package com.example.tpcell.Controller;

import com.example.tpcell.Entity.Students;
import com.example.tpcell.Entity.Tpos;
import com.example.tpcell.Service.StudentService;
import com.example.tpcell.Service.TpoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/tpos")

public class TpoController {
    private TpoService tpoService ;

    @Autowired
    public TpoController(TpoService tpoService) {
        this.tpoService = tpoService;
    }
    @PostMapping
    public ResponseEntity<Tpos> saveTpos(@RequestBody Tpos tpos){
        return new ResponseEntity<Tpos>(tpoService.saveTpos(tpos), HttpStatus.CREATED);
    }
    @GetMapping
    public List<Tpos> getAllTpos(){
        return tpoService.getAll();
    }
    @GetMapping("{id}")
    public ResponseEntity<Tpos> getTpo(@PathVariable("id")long To_id){
        return new ResponseEntity<Tpos>(tpoService.getTposById(To_id),HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<String> updateTpo(@RequestBody Tpos tpos, @PathVariable("id")long To_id){
        tpoService.updateTposById(tpos ,To_id);
        return new ResponseEntity<String>("Successfully Updated", HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTpo(@RequestBody String tpo, @PathVariable("id")long To_id){
        tpoService.deleteTpo(tpo,To_id);
        return new ResponseEntity<String>("Deleted Successfully",HttpStatus.OK);
    }
}
