package com.poc.TMS.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateTaskDTO {
    Integer taskId;
    String title;
    String description;
    String status;
    LocalDate dueDate;
    Integer userId;
    Integer loggedInUserId;

}
