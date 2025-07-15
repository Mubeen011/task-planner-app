package com.poc.TMS.DTO;

import lombok.Data;

@Data
public class LoginResponseDTO {
    String statusCode;
    String statusMsg;
    Integer userId;
    String role;
    String name;
}
