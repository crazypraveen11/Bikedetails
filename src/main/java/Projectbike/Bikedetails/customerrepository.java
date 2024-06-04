package Projectbike.Bikedetails;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface customerrepository extends JpaRepository<customerentity,Long>
{
    
}
