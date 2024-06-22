package tech.inno100.tryjesusapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.inno100.tryjesusapp.model.Address;
import tech.inno100.tryjesusapp.model.Member;

import java.util.List;
import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address, Integer> {
//    Optional<Address> findByAddressId(Integer addressId);
//    List<Address> findByMemberMemberId(Long memberId);
}
