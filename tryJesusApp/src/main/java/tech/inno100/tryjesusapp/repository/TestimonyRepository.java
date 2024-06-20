package tech.inno100.tryjesusapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.inno100.tryjesusapp.model.Devotion;
import tech.inno100.tryjesusapp.model.Offering;
import tech.inno100.tryjesusapp.model.Testimony;

import java.util.List;
import java.util.Optional;

public interface TestimonyRepository extends JpaRepository<Testimony, Long> {
//    Optional<Testimony> findByTestimonyId(Long testimonyId);
//    List<Testimony> findByMemberId(Long memberId);
    Optional <List<Testimony>> findByMemberId(Long memberId);
}