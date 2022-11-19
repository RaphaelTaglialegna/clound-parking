package br.floreia.parking.controller.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ParkingCreateDTO {

 
  private String license;
  private String state;
  private String model;
  private String color;


  public String getLicense() {
    return this.license;
  }

  public void setLicense(String license) {
    this.license = license;
  }

  public String getState() {
    return this.state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getModel() {
    return this.model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public String getColor() {
    return this.color;
  }

  public void setColor(String color) {
    this.color = color;
  }

}
