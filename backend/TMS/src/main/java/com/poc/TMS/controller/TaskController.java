package com.poc.TMS.controller;


import com.poc.TMS.DTO.CreateTaskDTO;
import com.poc.TMS.DTO.TaskDTO;
import com.poc.TMS.DTO.UpdateTaskDTO;
import com.poc.TMS.DTO.UserListDTO;
import com.poc.TMS.service.TaskService;
import com.poc.TMS.DTO.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
@CrossOrigin(origins = "*")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("createTask")
    public ResponseEntity<ResponseDTO> createTask(@RequestBody CreateTaskDTO createTaskDTO){
        return taskService.createTaskService(createTaskDTO);
    }
//    @GetMapping("getAllTasks")
//    public List<TaskDTO> getAllTasks(@RequestParam String userId){
//        return taskService.getAllTasks(userId);
//    }

    @GetMapping("/getAllTasks")
    public Page<TaskDTO> getAllTasks(
            @RequestParam String userId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "25") int size,
            @RequestParam(defaultValue = "dueDate") String sortBy,
            @RequestParam(defaultValue = "asc") String sortOrder) {
        Page<TaskDTO> result = taskService.getAllTasks(userId, sortBy, sortOrder, page, size);
        System.out.println(result);
        return result;
    }

//    @GetMapping("getUserCreatedTasks")
//    public List<TaskDTO> getUserCreatedTasks(@RequestParam String userId){
//        return taskService.getUserCreatedTasks(userId);
//    }
    @GetMapping("getUserCreatedTasks")
    public Page<TaskDTO> getUserCreatedTasks(@RequestParam String userId,
                                             @RequestParam(defaultValue = "0") int page,
                                             @RequestParam(defaultValue = "25") int size,
                                             @RequestParam(defaultValue = "dueDate") String sortBy,
                                             @RequestParam(defaultValue = "asc") String sortOrder){
        return taskService.getUserCreatedTasks(userId,sortBy,sortOrder,page,size);
    }
    @GetMapping("getUserCompletedTasks")
    public Page<TaskDTO> getUserCompletedTasks(@RequestParam String userId,
                                               @RequestParam(defaultValue = "0") int page,
                                               @RequestParam(defaultValue = "25") int size,
                                               @RequestParam(defaultValue = "dueDate") String sortBy,
                                               @RequestParam(defaultValue = "asc") String sortOrder){
        return taskService.getUserCompletedTasks(userId, sortBy, sortOrder, page, size);
    }


    @PostMapping("UpdateTasks")
    public ResponseEntity<ResponseDTO> updateTasks(@RequestBody UpdateTaskDTO updateTaskDTO){
        return taskService.updateTaskService(updateTaskDTO);
    }
    @DeleteMapping("deleteTask")
    public ResponseEntity<ResponseDTO> deleteTask(@RequestParam Integer taskId){
        return taskService.deleteTaskService(taskId);
    }
    @GetMapping("getAllUsers")
    public List<UserListDTO> getAllUsers(){
        return taskService.getAllUsers();
    }

}
