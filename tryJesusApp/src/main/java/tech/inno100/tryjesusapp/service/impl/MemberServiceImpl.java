package tech.inno100.tryjesusapp.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.inno100.tryjesusapp.dto.MemberDto;
import tech.inno100.tryjesusapp.model.Member;
import tech.inno100.tryjesusapp.model.User;
import tech.inno100.tryjesusapp.repository.MemberRepository;
import tech.inno100.tryjesusapp.service.MemberService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;

    @Override
    public Optional<MemberDto> addNewMember(MemberDto memberDto){
        Member newMember = new Member();
        newMember.setFirstName(memberDto.getFirstName());
        newMember.setPrimaryUser(
                new User(
                        memberDto.getUserDto().
                )
        );

    }
}
