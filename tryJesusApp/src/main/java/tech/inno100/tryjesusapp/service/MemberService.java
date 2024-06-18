package tech.inno100.tryjesusapp.service;


import tech.inno100.tryjesusapp.dto.MemberDto;


import java.util.List;
import java.util.Optional;

public interface MemberService {
//    Optional<MemberDto> findById(Long id);
    Optional<MemberDto> addNewMember(MemberDto member);
    Optional<MemberDto> getMember(Long id);
    Optional<MemberDto> updateMember(Long id, MemberDto member);
    Optional<MemberDto> deleteMember(Long id);
    Optional<List<MemberDto>> getAllMembers();
}
