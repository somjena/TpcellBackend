package com.example.tpcell.Controller;

import com.example.tpcell.Entity.Hrs;
import com.example.tpcell.Entity.Students;
import com.example.tpcell.Service.HrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Hr")

public class HrController {
    private HrService hrService;
    @Autowired
    public HrController(HrService hrService) {
        this.hrService = hrService;
    }

    @PostMapping
    public ResponseEntity<Hrs> saveHr(@RequestBody Hrs hrs){
        return new ResponseEntity<Hrs>(hrService.saveHrs(hrs), HttpStatus.CREATED);
    }
    @GetMapping
    public List<Hrs> getAllHrs(){
        return hrService.getAll();
    }
    @GetMapping("{id}")
    public ResponseEntity<Hrs> getHrs(@PathVariable ("id")long hrid){
        return new ResponseEntity<Hrs>(hrService.getHrById(hrid),HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<String> updatehr(@RequestBody Hrs hrs, @PathVariable("id")long hrid){
        hrService.updateHrById(hrs,hrid);
        return new ResponseEntity<String>("Successfully Updated", HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String > deleteHrs(@RequestBody String hrs, @PathVariable("id")long hrid){
        hrService.deleteHr(hrs,hrid);
        return new ResponseEntity<String>("Deleted Successfully",HttpStatus.OK);
    }

}
