package br.floreia.parking.model;

import java.time.LocalDateTime;

public class Parking {

  private String id;
  private String license;
  private String state;
  private String model;
  private String color;
  private LocalDateTime entryDate;
  private LocalDateTime exiteDate;
  private Double bill;

  public Parking() {
  };

  public Parking(String id, String license, String state, String model, String color) {
    this.id = id;
    this.license = license;
    this.state = state;
    this.model = model;
    this.color = color;
  }


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

  public LocalDateTime getExiteDate() {
    return this.exiteDate;
  }

  public void setExiteDate(LocalDateTime exiteDate) {
    this.exiteDate = exiteDate;
  }

  public Double getBill() {
    return this.bill;
  }

  public void setBill(Double bill) {
    this.bill = bill;
  }
  


  
}
