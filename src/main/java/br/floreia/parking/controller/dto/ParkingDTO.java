package br.floreia.parking.controller.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ParkingDTO {

  private String id;
  private String license;
  private String state;
  private String model;
  private String color;
  @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
  private LocalDateTime entryDate;
  @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
  private LocalDateTime exitDate;
  private Double bill;

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

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

  public LocalDateTime getEntryDate() {
    return this.entryDate;
  }

  public void setEntryDate(LocalDateTime entryDate) {
    this.entryDate = entryDate;
  }

  public LocalDateTime getExitDate() {
    return this.exitDate;
  }

  public void setExitDate(LocalDateTime exitDate) {
    this.exitDate = exitDate;
  }

  public Double getBill() {
    return this.bill;
  }

  public void setBill(Double bill) {
    this.bill = bill;
  }

}
