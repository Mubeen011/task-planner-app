package com.poc.TMS.DTO;


import lombok.Data;

@Data
public class RegistrationDTO {
    String email;
    String password;
    String firstName;
    String lastName;
}
