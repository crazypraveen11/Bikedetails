package Projectbike.Bikedetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Bike Details")
public class bikeentity 
{
   @Id
   private Long Bike_chasisno;
   private String Bike_brand;
   private String Bike_model;
   private String Bike_price;
   private String Bikecc;
   @Column(name = "version")
   private String Bike_version;
   @Column(name = "weight")
   private String Bike_weight;
   @Column(name = "mileage")
   private String Bike_mileage;
   @Column(name = "brake system")
   private String Bike_brake_system;
}