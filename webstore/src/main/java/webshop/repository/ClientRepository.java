package webshop.repository;

import org.springframework.data.repository.CrudRepository;
import webshop.model.Client;

public interface ClientRepository extends CrudRepository<Client, Long> {
}
