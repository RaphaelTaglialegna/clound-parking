package br.floreia.parking.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.floreia.parking.controller.dto.ParkingDTO;
import br.floreia.parking.controller.mapper.ParkingMapper;
import br.floreia.parking.model.Parking;
import br.floreia.parking.sevice.ParkingService;

@RestController
@RequestMapping("/parking")
public class ParkingController {

  private final ParkingService parkingService;
  private final ParkingMapper parkingMapper;

  public ParkingController(ParkingService parkingService, ParkingMapper parkingMapper) {
    this.parkingService = parkingService;
    this.parkingMapper = parkingMapper;
  }
  
  @GetMapping
  public ResponseEntity<List<ParkingDTO>> findAll() {
      List<Parking> parkingList = parkingService.findAll();
      List<ParkingDTO> result = parkingMapper.toParkingDTOList(parkingList);
      return ResponseEntity.ok(result);
  }
}
