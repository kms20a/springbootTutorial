package com.mskim.demo.domain;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class Member {
    @Length(min = 2, max = 20)
    @Email
    @NotBlank
    private String username;

    @Length(min = 2)
    private String password;
}