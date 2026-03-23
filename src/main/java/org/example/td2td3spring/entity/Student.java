package org.example.td2td3spring.entity;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private String reference;
    private String firstName;
    private String lastName;
    private int age;
}
