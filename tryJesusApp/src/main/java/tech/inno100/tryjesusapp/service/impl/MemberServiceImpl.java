package tech.inno100.tryjesusapp.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.inno100.tryjesusapp.dto.MemberDto;
import tech.inno100.tryjesusapp.dto.UserDto;
import tech.inno100.tryjesusapp.model.Member;
import tech.inno100.tryjesusapp.model.User;
import tech.inno100.tryjesusapp.repository.MemberRepository;
import tech.inno100.tryjesusapp.service.MemberService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;

//    @Override
//    public Optional<MemberDto> addNewMember(MemberDto memberDto){
//        Member newMember = new Member();
//        newMember.setFirstName(memberDto.getFirstName());
//        newMember.setPrimaryUser(
//                new User(
//                        memberDto.getUserDto().
//                )
//        );
//
//    }
    @Override
    public Optional<MemberDto> addNewMember(MemberDto memberDto) {
        Member newMember = new Member();
        newMember.setMemberId(memberDto.getMemberId());
        newMember.setPrimaryUser(
                new User(
                        memberDto.getUserDto().getUsername(),
                        memberDto.getUserDto().getPassword(),
                        memberDto.getUserDto().getStatus())
        );
        Member member = memberRepository.save(newMember);
        MemberDto responseDto = new MemberDto();
        responseDto.setMemberId(member.getMemberId());
        responseDto.setFirstName(member.getFirstName());
        responseDto.setUserDto(new UserDto(member.getPrimaryUser().getUsername(), member.getPrimaryUser().getPassword(), member.getPrimaryUser().getStatus()));
        return Optional.of(responseDto);
    }

    @Override
    public Optional<MemberDto> findByMemberId(Long id) {

        return Optional.empty();
    }
}
