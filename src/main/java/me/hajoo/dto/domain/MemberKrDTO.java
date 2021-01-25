package me.hajoo.dto.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MemberKrDTO {

    String name; /* nameFirstName */
    String sung; /* nameLastName */
    String phoneNumber;
    int cm;
    int kg;
    int age;
    LocalDateTime createdDate;

}
