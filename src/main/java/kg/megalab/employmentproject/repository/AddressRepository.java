package kg.megalab.employmentproject.repository;

import kg.megalab.employmentproject.model.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
