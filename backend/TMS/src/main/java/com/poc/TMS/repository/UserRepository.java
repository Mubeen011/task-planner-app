package com.poc.TMS.repository;

import com.poc.TMS.DTO.UserListDTO;
import com.poc.TMS.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    @Query("SELECT u FROM User u WHERE u.email=:email")
    User findByEmail(String email);


    @Query("SELECT new com.poc.TMS.DTO.UserListDTO(u.userId, CONCAT(u.firstName, ' ', u.lastName)) FROM User u")
    List<UserListDTO> getAllUsers();

}
