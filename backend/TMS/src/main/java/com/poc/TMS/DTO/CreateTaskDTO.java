package com.poc.TMS.DTO;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CreateTaskDTO {
    String title;
    String description;
    Integer assignedUser;
    LocalDate dueDate;
    String status;
    Integer createdBy;
}
