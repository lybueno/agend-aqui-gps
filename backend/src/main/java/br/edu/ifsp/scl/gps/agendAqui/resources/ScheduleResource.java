package br.edu.ifsp.scl.gps.agendAqui.resources;

import br.edu.ifsp.scl.gps.agendAqui.dto.*;
import br.edu.ifsp.scl.gps.agendAqui.services.ScheduleService;
import br.edu.ifsp.scl.gps.agendAqui.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/schedule")
public class ScheduleResource {

    @Autowired
    private ScheduleService service;

    @Autowired
    private UserService userService;

    @GetMapping("/availables")
    public ResponseEntity<List<ScheduleDTO>> findAll(){
        List<ScheduleDTO> listDto = service.findAll();
        List<ScheduleDTO> availables = listDto.stream().filter(x -> x.getClient() == null).collect(Collectors.toList());
        return ResponseEntity.ok().body(availables);
    }

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
    	LocalDateTime date = LocalDateTime.parse(instant);
        ScheduleDTO dto = service.findByDate(date);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping("/add")
    public ResponseEntity<ScheduleDTO> insert(@RequestBody ScheduleDTO dto){
        //UserDTO providerDto = userService.findById(dto.getProvider().getId());
        //ScheduleDTO newSchedule = new ScheduleDTO(dto.getId(), dto.getDate().toString(), providerDto);
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

    @DeleteMapping(value = "/update/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
