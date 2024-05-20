package Projectbike.Bikedetails;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class bikeservice 
{
    @Autowired
    bikerepository bikerepo;

    public bikeentity add_bike(bikeentity bikedetails)
    {
        return bikerepo.save(bikedetails);
    }

    public List<bikeentity> listall_bikes()
    {
        return bikerepo.findAll();
    }

    // public String findbymodel(bikeentity bike_data)
    // {
    //     return  bikerepo.findall(bike_data) +" has been founded...!";
    // }
}
