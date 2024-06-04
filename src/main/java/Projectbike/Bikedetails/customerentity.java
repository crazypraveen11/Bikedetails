package Projectbike.Bikedetails;

import java.math.BigDecimal;
import java.util.Date;

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
@Table(name = "Customerdetails")
public class customerentity 
{
    @Id
    private Long transactionNumber;
    private String customerName;
    private String panNo;
    @Column(name = "contactno")
    private Long customerContactno;
    private Long customerAccountno;
    private String customerPlace;
    private String customerTransactiontype;
    private BigDecimal transactionAmount;
    private Date transactionDate;
    
}
