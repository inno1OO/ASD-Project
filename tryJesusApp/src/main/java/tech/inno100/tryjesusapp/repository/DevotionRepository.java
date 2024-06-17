package tech.inno100.tryjesusapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.inno100.tryjesusapp.model.Address;
import tech.inno100.tryjesusapp.model.Devotion;

import java.util.List;
import java.util.Optional;

public interface DevotionRepository extends JpaRepository<Devotion, Long> {
    Optional<Devotion> findByDevotionId(Long devotionId);
//    List<Devotion> findByMemberId(Long memberId);
}
