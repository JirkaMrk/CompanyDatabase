package cz.uun.companydatabase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import cz.uun.companydatabase.entity.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    

    //Template:

    //Optional<Company> findByIco(String ico);

    //@Query("SELECT c.ico FROM Company c WHERE c.id = :id")
    //String getIco(@Param("id") Long id);

    //@Query("SELECT c.name FROM Company c WHERE c.id = :id")
    //String getName(@Param("id") Long id);
}
