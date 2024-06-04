package Projectbike.Bikedetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "BikeDetails")
public class bikeentity implements UserDetails
{
   
   private Long bikeChasisno;
   @Id
   private String bikeBrand;
   private String bikeModel;
   private String bikePrice;
   private String bikeCc;
   @Column(name = "version")
   private String bikeVersion;
   @Column(name = "weight")
   private String bikeWeight;
   @Column(name = "mileage")
   private String bikeMileage;
   @Column(name = "brake system")
   private String bikeBrakesystem;
   private String password;
   @Override
   public Collection<? extends GrantedAuthority> getAuthorities() {
      return null;   }
   @Override
   public String getUsername() {
      return bikeBrand;
        }

   public String getPassword()
   {
      return password;
   }
   @Override
   public boolean isAccountNonExpired() 
   {
      return true;
        }
   @Override
   public boolean isAccountNonLocked() {
      return true;
        }
   @Override
   public boolean isCredentialsNonExpired() {
      return true;
        }
   @Override
   public boolean isEnabled() {
      return true;
        }
}