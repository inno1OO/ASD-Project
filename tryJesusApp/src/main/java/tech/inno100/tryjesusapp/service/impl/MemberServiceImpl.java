package tech.inno100.tryjesusapp.service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import tech.inno100.tryjesusapp.dto.MemberDto;
import tech.inno100.tryjesusapp.model.Member;
import tech.inno100.tryjesusapp.repository.MemberRepository;
import tech.inno100.tryjesusapp.service.MemberService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;
    private final ModelMapper modelMapper;

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
        Member member = modelMapper.map(memberDto, Member.class);
        Member savedMember = memberRepository.save(member);
        MemberDto memberResponseDto = modelMapper.map(savedMember, MemberDto.class);
        return Optional.of(memberResponseDto);
    }

    @Override
    public Optional<MemberDto> getMember(Long id) {
        Optional<Member> foundMember = memberRepository.findById(id);
        if (foundMember.isPresent()) {
            MemberDto customerResponseDto = modelMapper.map(foundMember.get(), MemberDto.class);
            return Optional.of(customerResponseDto);
        }
        return Optional.empty();
    }

    @Override
    public Optional<MemberDto> updateMember(Long id, MemberDto memberDto) {
        Optional<Member> foundMember = memberRepository.findById(id);
        if (foundMember.isPresent()) {
           modelMapper.map(memberDto, foundMember.get());
            Member savedMember = memberRepository.save(foundMember.get());
            MemberDto memberResponseDto = modelMapper.map(savedMember, MemberDto.class);
            return Optional.of(memberResponseDto);
        }
        return Optional.empty();
    }

    @Override
    public Optional<MemberDto> deleteMember(Long id) {
        Optional<Member> foundMember = memberRepository.findById(id);
        if (foundMember.isPresent()) {
            memberRepository.delete(foundMember.get());
            MemberDto memberResponseDto = modelMapper.map(foundMember.get(), MemberDto.class);
            return Optional.of(memberResponseDto);
        }
        return Optional.empty();
    }

    @Override
    public Optional<List<MemberDto>> getAllMembers() {
        List<Member> members = memberRepository.findAll();
        if (members.isEmpty()) {
            return Optional.empty();
        }
        List<MemberDto> memberDtos = modelMapper.map(members, new TypeToken<List<MemberDto>>() {}.getType());
        return Optional.of(memberDtos);
//        return Optional.of(members);
    }

}
