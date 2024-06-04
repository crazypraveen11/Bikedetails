package Projectbike.Bikedetails;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("indianbank")
public class bikecontroller 
{
    @Autowired
    bikeservice bikeserv;

    public PasswordEncoder coder()
    {
        return new BCryptPasswordEncoder();
    }

    @PostMapping("/addbikes")
    public String addnewbike(@RequestBody bikeentity bikedata)
    {
        bikedata.setPassword(coder().encode(bikedata.getPassword()));
        return bikeserv.add_bike(bikedata).getBikeBrand()+" brand has been created successfully...!";
    }

    @GetMapping("/listbikes")
    public List<bikeentity> listbikedetails()
    {
        return bikeserv.listall_bikes();
    }

    @PutMapping("/updatebikes")
    public String updatebikes(@RequestBody bikeentity bikedata)
    {
        bikeentity bike = bikeserv.add_bike(bikedata);
        return bike.getBikeBrand()+" your brand has been updated successfully...!";
    }

    @GetMapping("/findbike/{bike}")
    public bikeentity find(@PathVariable("bike") String bike)
    {
        return bikeserv.findbybike(bike);
    }


    @Autowired
    customerservice cservice;

    @PostMapping("/createcustomer")
    public customerentity customercreate(@RequestBody customerentity customer)
    {
        return cservice.addcustomer(customer);
    }

    @GetMapping("/listallcustomer")
    public List<customerentity> listallcust()
    {
        return cservice.listcustomer();
    }

    @GetMapping("/findbytransactionnumber/{transno}")
    public customerentity findcustomer(@PathVariable("transno") Long transno)
    {
        return cservice.findbytransno(transno);
    }

    @PutMapping("/updatecustomer")
    public String updatecustomer(@RequestBody customerentity cust)
    {
        customerentity customer = cservice.addcustomer(cust);
        return customer.getCustomerName()+" customer has been updated successfully...!";
    }
}
