package Projectbike.Bikedetails;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class customerservice 
{
    @Autowired
    customerrepository crepo;


    public customerentity addcustomer(customerentity customer)
    {
        return crepo.save(customer);
    }

    public List<customerentity> listcustomer()
    {
        return crepo.findAll();
    }

    public customerentity findbytransno(Long transno)
    {
        return crepo.findById(transno).orElse(new customerentity());
    }
    
    public void deletecustomer(Long id)
    {
        crepo.deleteById(id);
    }
}
