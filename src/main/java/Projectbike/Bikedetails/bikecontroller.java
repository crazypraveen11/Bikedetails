package Projectbike.Bikedetails;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class bikecontroller 
{
    @Autowired
    bikeservice bikeserv;

    @PostMapping("/addbikes")
    public String addnew(@RequestBody bikeentity bikedata)
    {
        return bikeserv.add_bike(bikedata).getBike_brand()+" brand has been created successfully...!";
    }

    @GetMapping("/listbikes")
    public List<bikeentity> listbikedetails()
    {
        return bikeserv.listall_bikes();
    }

    // @GetMapping("/findbike/{bikedetails}")
    // public String findbike(@RequestBody bikeentity bikedetails)
    // {
    //     return bikeserv.findbymodel(bikedetails);
    // }
    
}
