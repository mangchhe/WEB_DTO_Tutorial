package me.hajoo.dto.util;

import me.hajoo.dto.domain.Member;
import me.hajoo.dto.domain.MemberDTO;
import me.hajoo.dto.domain.MemberKrDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MemberMapper {

    MemberMapper INSTANCE = Mappers.getMapper(MemberMapper.class);

    @Mapping(target = "name.firstName", expression = "java(memberDTO.getFirstName())")
    @Mapping(target = "name.lastName", expression = "java(memberDTO.getLastName())")
    Member dtoToMember(MemberDTO memberDTO);

    @Mapping(target = "firstName", expression = "java(member.getName().getFirstName())")
    @Mapping(target = "lastName", expression = "java(member.getName().getLastName())")
    MemberDTO entityToMemberDTO(Member member);

    @Mapping(target = "name", expression = "java(member.getName().getFirstName())")
    @Mapping(target = "sung", expression = "java(member.getName().getLastName())")
    @Mapping(source = "height", target = "cm")
    @Mapping(source = "weight", target = "kg")
    @Mapping(target = "age", constant = "25")
    MemberKrDTO entityToMemberKrDTO(Member member);

}
