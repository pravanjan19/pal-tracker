package io.pivotal.pal.tracker;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/entries")
public class TimeEntryController {

    private TimeEntryRepository timeEntryRepository;

    public TimeEntryController(TimeEntryRepository timeEntryRepository){
     this.timeEntryRepository=timeEntryRepository;

}

@PostMapping
public ResponseEntity<TimeEntry> create(@RequestBody TimeEntry timeEntry ){
    TimeEntry timeEntry1 = timeEntryRepository.create(timeEntry);
    return new ResponseEntity<>(timeEntry1, HttpStatus.CREATED);

}














}
