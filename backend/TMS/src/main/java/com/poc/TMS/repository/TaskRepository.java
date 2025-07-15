package com.poc.TMS.repository;

import com.poc.TMS.DTO.TaskDTO;
import com.poc.TMS.DTO.UserListDTO;
import com.poc.TMS.entity.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task,Integer> {


    @Query("SELECT new com.poc.TMS.DTO.TaskDTO(t.taskId,t.title,t.description,t.status,t.dueDate,u.userId,u.firstName,u.lastName) FROM Task t JOIN User u ON t.user.userId=u.userId WHERE (t.createdBy.userId=:userId OR t.user.userId=:userId)")
    Page<TaskDTO> findAllUserTasks(String userId,Pageable pageable);

    @Query("SELECT new com.poc.TMS.DTO.TaskDTO(t.taskId,t.title,t.description,t.status,t.dueDate,u.userId,u.firstName,u.lastName) FROM Task t LEFT JOIN User u ON t.user.userId=u.userId")
    Page<TaskDTO> findAllTasks(String userId,Pageable pageable);

    @Query("SELECT new com.poc.TMS.DTO.TaskDTO(t.taskId, t.title, t.description, t.status, t.dueDate, u.userId, u.firstName, u.lastName) FROM Task t JOIN User u ON t.user.userId = u.userId ")
    Page<TaskDTO> getPageTasks(@Param("userId") String userId, Pageable pageable);


//    @Query("SELECT new com.poc.TMS.DTO.TaskDTO(t.taskId,t.title,t.description,t.status,t.dueDate,u.userId,u.firstName,u.lastName) FROM Task t JOIN User u ON t.user.userId=u.userId WHERE t.createdBy.userId=:userId")
//    List<TaskDTO> getUserCreatedTasks(String userId);
@Query("SELECT new com.poc.TMS.DTO.TaskDTO(t.taskId,t.title,t.description,t.status,t.dueDate,u.userId,u.firstName,u.lastName) FROM Task t JOIN User u ON t.user.userId=u.userId WHERE t.createdBy.userId=:userId")
Page<TaskDTO> getUserCreatedTasks(String userId,Pageable pageable);

    @Query("SELECT new com.poc.TMS.DTO.TaskDTO(t.taskId,t.title,t.description,t.status,t.dueDate,u.userId,u.firstName,u.lastName) FROM Task t JOIN User u ON t.user.userId=u.userId WHERE (t.createdBy.userId=:userId OR t.user.userId=:userId) AND t.status='completed'")
    Page<TaskDTO> getUserCompletedTasks(String userId,Pageable pageable);



}
