package br.floreia.parking.sevice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.floreia.parking.controller.dto.ParkingDTO;
import br.floreia.parking.model.Parking;

@Service
public class ParkingService {
  
  private static Map<String, Parking> parkingMap = new HashMap();

  static {
    var id  = getUUID(); 
    Parking parking = new Parking(id, "DMS-111", "SC", "CELTA", "PRETO");
    parkingMap.put(id, parking);
  }

  private static String getUUID() {
    return UUID.randomUUID().toString().replace("-", "");
  }

  public List<Parking> findAll() {
    return parkingMap.values().stream().collect(Collectors.toList());
  }
}
