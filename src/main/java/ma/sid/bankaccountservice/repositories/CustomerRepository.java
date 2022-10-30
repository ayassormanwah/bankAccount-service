package ma.sid.bankaccountservice.repositories;

import ma.sid.bankaccountservice.entites.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "client")
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
