package tech.inno100.tryjesusapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.inno100.tryjesusapp.model.Devotion;
import tech.inno100.tryjesusapp.model.Offering;

import java.util.List;
import java.util.Optional;

public interface OfferingRepository extends JpaRepository<Offering, Long> {
//    Optional<Offering> findByOfferingId(Long offeringId);
//    List<Offering> findByMemberId(Long memberId);
    Optional <List<Offering>> findByMemberId(Long memberId);

}