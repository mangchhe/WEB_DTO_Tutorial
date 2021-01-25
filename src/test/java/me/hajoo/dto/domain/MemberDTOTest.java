package me.hajoo.dto.domain;

import me.hajoo.dto.util.MemberMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class MemberDTOTest {

    @Autowired
    private ModelMapper modelMapper;

    @Test
    public void ModelMapperTest() throws Exception {
        //given
        Member member = Member.builder()
                .name(Name.builder()
                        .firstName("길동")
                        .lastName("홍")
                        .build())
                .phoneNumber("010-1234-5678")
                .height(180)
                .weight(70)
                .createdDate(LocalDateTime.now())
                .build();
        //when
        MemberDTO result = modelMapper.map(member, MemberDTO.class);
        Member result2 = modelMapper.map(result, Member.class);
        //then
        System.out.println(result.toString());
        Assertions.assertThat(result.getFirstName()).isEqualTo(member.getName().getFirstName());
        Assertions.assertThat(result.getLastName()).isEqualTo(member.getName().getLastName());
        Assertions.assertThat(result.getPhoneNumber()).isEqualTo(member.getPhoneNumber());
        Assertions.assertThat(result.getHeight()).isEqualTo(member.getHeight());
        Assertions.assertThat(result.getWeight()).isEqualTo(member.getWeight());
        Assertions.assertThat(result.getCreatedDate()).isEqualTo(member.getCreatedDate());

        System.out.println(result2.toString());
        Assertions.assertThat(result2.getName().getFirstName()).isEqualTo(member.getName().getFirstName());
        Assertions.assertThat(result2.getName().getLastName()).isEqualTo(member.getName().getLastName());
        Assertions.assertThat(result2.getPhoneNumber()).isEqualTo(member.getPhoneNumber());
        Assertions.assertThat(result2.getHeight()).isEqualTo(member.getHeight());
        Assertions.assertThat(result2.getWeight()).isEqualTo(member.getWeight());
        Assertions.assertThat(result2.getCreatedDate()).isEqualTo(member.getCreatedDate());
    }

    @Test
    public void MapStructTest() throws Exception {
        //given
        Member member = Member.builder()
                .name(Name.builder()
                        .firstName("길동")
                        .lastName("홍")
                        .build())
                .phoneNumber("010-1234-5678")
                .height(180)
                .weight(70)
                .createdDate(LocalDateTime.now())
                .build();
        //when
        MemberDTO result = MemberMapper.INSTANCE.entityToMemberDTO(member);
        Member result2 = MemberMapper.INSTANCE.dtoToMember(result);
        MemberKrDTO result3 = MemberMapper.INSTANCE.entityToMemberKrDTO(member);
        //then
        System.out.println(result.toString());
        Assertions.assertThat(result.getFirstName()).isEqualTo(member.getName().getFirstName());
        Assertions.assertThat(result.getLastName()).isEqualTo(member.getName().getLastName());
        Assertions.assertThat(result.getPhoneNumber()).isEqualTo(member.getPhoneNumber());
        Assertions.assertThat(result.getHeight()).isEqualTo(member.getHeight());
        Assertions.assertThat(result.getWeight()).isEqualTo(member.getWeight());
        Assertions.assertThat(result.getCreatedDate()).isEqualTo(member.getCreatedDate());

        System.out.println(result2.toString());
        Assertions.assertThat(result2.getName().getFirstName()).isEqualTo(member.getName().getFirstName());
        Assertions.assertThat(result2.getName().getLastName()).isEqualTo(member.getName().getLastName());
        Assertions.assertThat(result2.getPhoneNumber()).isEqualTo(member.getPhoneNumber());
        Assertions.assertThat(result2.getHeight()).isEqualTo(member.getHeight());
        Assertions.assertThat(result2.getWeight()).isEqualTo(member.getWeight());
        Assertions.assertThat(result2.getCreatedDate()).isEqualTo(member.getCreatedDate());

        System.out.println(result3.toString());
        Assertions.assertThat(result3.getName()).isEqualTo(member.getName().getFirstName());
        Assertions.assertThat(result3.getSung()).isEqualTo(member.getName().getLastName());
        Assertions.assertThat(result3.getPhoneNumber()).isEqualTo(member.getPhoneNumber());
        Assertions.assertThat(result3.getCm()).isEqualTo(member.getHeight());
        Assertions.assertThat(result3.getKg()).isEqualTo(member.getWeight());
        Assertions.assertThat(result3.getCreatedDate()).isEqualTo(member.getCreatedDate());
        Assertions.assertThat(result3.getAge()).isEqualTo(25);

    }

    @Test
    public void ModelMapperVSMapStruct() throws Exception {
        //given
        Member member = Member.builder()
                .name(Name.builder()
                        .firstName("길동")
                        .lastName("홍")
                        .build())
                .phoneNumber("010-1234-5678")
                .height(180)
                .weight(70)
                .createdDate(LocalDateTime.now())
                .build();
        //when
        long start = System.currentTimeMillis();
        for (int i = 0; i < 500000; i++) {
            modelMapper.map(member, MemberDTO.class);
        }
        long modelMapperDelayTime = System.currentTimeMillis() - start;
        start = System.currentTimeMillis();
        for (int i = 0; i < 500000; i++) {
            MemberMapper.INSTANCE.entityToMemberDTO(member);
        }
        long mapStructDelayTime = System.currentTimeMillis() - start;
        //then
        System.out.println(modelMapperDelayTime / 1000.0);
        System.out.println(mapStructDelayTime / 1000.0);
        System.out.println(modelMapperDelayTime / mapStructDelayTime);
    }

}