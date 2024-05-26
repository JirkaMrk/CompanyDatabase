package cz.uun.companydatabase.repository;

import cz.uun.companydatabase.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
    Optional<Company> findByIco(String ico);

    List<Company> findByNameContaining(String name);
}
