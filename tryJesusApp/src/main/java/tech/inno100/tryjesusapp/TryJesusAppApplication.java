package tech.inno100.tryjesusapp;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tech.inno100.tryjesusapp.dto.MemberDto;
import tech.inno100.tryjesusapp.dto.UserDto;
import tech.inno100.tryjesusapp.service.impl.MemberServiceImpl;

import java.time.LocalDate;
import java.util.Optional;

@RequiredArgsConstructor
@SpringBootApplication
public class TryJesusAppApplication {

//    private final MemberServiceImpl memberServiceImpl;

    public static void main(String[] args) {
        SpringApplication.run(TryJesusAppApplication.class, args);
    }

//    @Bean
//    CommandLineRunner commandLineRunner(){
//        return args -> {
//            UserDto userDto = new UserDto("inno", "pasoiioiword", "true");
//            MemberDto memberDto = new MemberDto("firstName", "lastName", "email", "phoneNumber", LocalDate.of(1996,5,13), "status", "matrimonialStatus", "password", true);
////            PublisherDto publisherDto = new PublisherDto(" ");//ConstraintViolationException
//            memberDto.setUserDto(userDto);
//            addMember(memberDto).ifPresent(
//                    member -> {
//                        System.out.println(member.getMemberId()+": "+member.getUserDto()+" is saved");
//                    }
//            );
//
//        };
//    }
//
//    private Optional<MemberDto> addMember(MemberDto memberDto) {
//        return memberServiceImpl.addNewMember(memberDto);
//    }
}




