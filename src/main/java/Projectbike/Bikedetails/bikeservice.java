package Projectbike.Bikedetails;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class bikeservice implements UserDetailsService
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

    public bikeentity findbybike(String Bikebrand)
    {
        return bikerepo.findById(Bikebrand).orElse(new bikeentity());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        bikeentity bike = bikerepo.findByBikeBrand(username);
        if(bike == null)
        {
            throw new UsernameNotFoundException(username);
        }
        return bike;   
    }   
}