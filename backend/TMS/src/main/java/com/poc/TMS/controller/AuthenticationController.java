package com.poc.TMS.controller;


import com.poc.TMS.DTO.LoginDTO;
import com.poc.TMS.DTO.RegistrationDTO;
import com.poc.TMS.service.AuthenticationService;
import com.poc.TMS.DTO.LoginResponseDTO;
import com.poc.TMS.DTO.ResponseDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/registration")
    public ResponseEntity<ResponseDTO> Registration(@RequestBody RegistrationDTO registrationDTO) {
            return authenticationService.registerUserService(registrationDTO);
}

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> Login(@RequestBody LoginDTO loginDTO, HttpSession httpSession, HttpServletRequest request, HttpServletResponse response){
        return authenticationService.loginService(loginDTO,httpSession,request,response);
    }
}
