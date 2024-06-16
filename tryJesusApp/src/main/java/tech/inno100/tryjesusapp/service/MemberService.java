package tech.inno100.tryjesusapp.service;

import tech.inno100.tryjesusapp.dto.MemberDto;

import java.util.Optional;

public interface MemberService {
    Optional<MemberDto> findById(Long id);
}
