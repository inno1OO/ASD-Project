package tech.inno100.tryjesusapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.inno100.tryjesusapp.model.Devotion;
import tech.inno100.tryjesusapp.model.PrayerRequest;

import java.util.List;
import java.util.Optional;

public interface PrayerRequestRepository extends JpaRepository<PrayerRequest, Long> {
//    Optional<PrayerRequest> findByPrayerRequestId(Long prayerRequestId);
//    List<PrayerRequest> findByMemberId(Long memberId);
    Optional <List<PrayerRequest>> findByMemberId(Long memberId);
}