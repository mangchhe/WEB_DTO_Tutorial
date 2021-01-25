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
public class Member {

    Name name;
    String phoneNumber;
    int height;
    int weight;
    LocalDateTime createdDate;

}