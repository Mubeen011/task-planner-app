package com.poc.TMS.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDTO {
    Integer taskId;
    String title;
    String description;
    String status;
    LocalDate dueDate;
    Integer userId;
    String firstName;
    String lastName;
}
