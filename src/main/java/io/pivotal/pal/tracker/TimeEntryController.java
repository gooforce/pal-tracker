package io.pivotal.pal.tracker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;
import java.time.LocalDate;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class TimeEntryController {

    @Autowired
    private TimeEntryRepository timeEntryRepository;

    public TimeEntryController(){
    }

    public TimeEntryController(TimeEntryRepository tmR){
        this.timeEntryRepository = tmR;
    }

    @PostMapping("/time-entries")
    public ResponseEntity<TimeEntry> create(@RequestBody TimeEntry te){
        TimeEntry _timeentry = timeEntryRepository.create(te);
        return new ResponseEntity<>(_timeentry,HttpStatus.CREATED);
    }

    @GetMapping("/time-entries/{id}")
    public ResponseEntity<TimeEntry> read(@PathVariable("id") long id){
        TimeEntry _timeentry = timeEntryRepository.find(id);
        if(_timeentry == null) {
            return new ResponseEntity<>(_timeentry, HttpStatus.NOT_FOUND);
        }
        else
        {
            return new ResponseEntity<>(_timeentry, HttpStatus.OK);
        }
    }

    @PutMapping("/time-entries/{id}")
    public ResponseEntity<TimeEntry> update(@PathVariable("id") long id,@RequestBody TimeEntry te){
        TimeEntry _timeentry = timeEntryRepository.update(id, te);
        if(_timeentry == null) {
            return new ResponseEntity<>(_timeentry,HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<>(_timeentry, HttpStatus.OK);
        }
    }

    @GetMapping("/time-entries")
    public ResponseEntity<List<TimeEntry>> list(){

        List<TimeEntry> _timeentrylist = timeEntryRepository.list();
        return new ResponseEntity<>(_timeentrylist ,HttpStatus.OK);
    }

    @DeleteMapping("/time-entries/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") long id){
        timeEntryRepository.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}