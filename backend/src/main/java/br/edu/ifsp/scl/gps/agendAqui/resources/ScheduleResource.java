package br.edu.ifsp.scl.gps.agendAqui.resources;

import br.edu.ifsp.scl.gps.agendAqui.dto.*;
import br.edu.ifsp.scl.gps.agendAqui.services.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "/schedule")
public class ScheduleResource {

    @Autowired
    private ScheduleService service;

    @GetMapping("/{id}")
    public ResponseEntity<ScheduleDTO> findById(@PathVariable Long id){
        ScheduleDTO dto  = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping("/provider/{id}")
    public ResponseEntity<List<ScheduleDTO>> findByProviderId(@PathVariable Long id){
        List<ScheduleDTO> listDto  = service.findByProviderId(id);
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping("/client/{id}")
    public ResponseEntity<List<ScheduleDTO>> findByClientId(@PathVariable("id") Long id){
        List<ScheduleDTO> listDto  = service.findByClientId(id);
        return ResponseEntity.ok().body(listDto);
    }

    @RequestMapping(value="/date/{instant}", method=RequestMethod.GET)
    public ResponseEntity<ScheduleDTO> findByDate(@PathVariable String instant){
    	Instant date = Instant.parse(instant);
        ScheduleDTO dto = service.findByDate(date);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping("/{id}")
    public ResponseEntity<ScheduleDTO> insert(@Valid @RequestBody ScheduleInsertDTO dto){
        ScheduleDTO newDto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newDto.getId()).toUri();
        return ResponseEntity.created(uri).body(newDto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ScheduleDTO> update(@PathVariable Long id, @Valid @RequestBody ScheduleUpdateDTO dto){
        ScheduleDTO newDto = service.update(id, dto);
        return ResponseEntity.ok().body(newDto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
