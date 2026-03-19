package org.example.td2td3spring.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Student {
    private String reference;
    private String firstName;
    private String lastName;
    private int age;
}