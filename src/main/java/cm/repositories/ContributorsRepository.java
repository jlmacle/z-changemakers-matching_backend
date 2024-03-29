package cm.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import cm.models.Contributor;

/**
 * Repository interface used to access the data related to the contributors
 * 
 */
public interface ContributorsRepository extends JpaRepository<Contributor, Integer>{
    
    public List<Contributor> findByUsername(String name);
}
