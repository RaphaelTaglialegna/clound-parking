package br.floreia.parking.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.floreia.parking.controller.dto.ParkingCreateDTO;
import br.floreia.parking.controller.dto.ParkingDTO;
import br.floreia.parking.controller.mapper.ParkingMapper;
import br.floreia.parking.model.Parking;
import br.floreia.parking.sevice.ParkingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/parking")
@Api(tags = "Parking Controller")
public class ParkingController {

  private final ParkingService parkingService;
  private final ParkingMapper parkingMapper;

  public ParkingController(ParkingService parkingService, ParkingMapper parkingMapper) {
    this.parkingService = parkingService;
    this.parkingMapper = parkingMapper;
  }
  
  @GetMapping
  @ApiOperation("Find all parkings")
  public ResponseEntity<List<ParkingDTO>> findAll() {
    List<Parking> parkingList = parkingService.findAll();
    List<ParkingDTO> result = parkingMapper.toParkingDTOList(parkingList);
    return ResponseEntity.ok(result);
  }
  
  @GetMapping("/{id}")
  @ApiOperation("Find a parking by id")
  public ResponseEntity<ParkingDTO> findById(@PathVariable String id) {
    Parking parking = parkingService.findById(id);
    ParkingDTO result = parkingMapper.toParkingDTO(parking);
    return ResponseEntity.ok(result);
  }
  
  @PostMapping
  @ApiOperation("Create a parking")
  public ResponseEntity<ParkingDTO> create(@RequestBody ParkingCreateDTO dto) {
    var parkingCreate = parkingMapper.toParkingCreate(dto);
    var parking = parkingService.create(parkingCreate);
    var result = parkingMapper.toParkingDTO(parking);
    return ResponseEntity.status(HttpStatus.CREATED).body(result);
  }

  @PutMapping("/{id}")
  @ApiOperation("Update a parking")
  public ResponseEntity<ParkingDTO> update(@PathVariable String id, @RequestBody ParkingCreateDTO dto) {
    var parkingCreate = parkingMapper.toParkingCreate(dto);
    var parking = parkingService.update(id, parkingCreate);
    var result = parkingMapper.toParkingDTO(parking);
    return ResponseEntity.status(HttpStatus.OK).body(result);
  }
  
  @DeleteMapping("/{id}")
  @ApiOperation("Delete a parking by id")
  public ResponseEntity delete(@PathVariable String id) {
    parkingService.delete(id);
    return ResponseEntity.noContent().build();
  }
  
  @PostMapping("/{id}/exit")
  @ApiOperation("Exit a parking")
  public ResponseEntity<ParkingDTO> exit(@PathVariable String id) {
    Parking parking = parkingService.exit(id);
    return ResponseEntity.ok(parkingMapper.toParkingDTO(parking));
  }
}
