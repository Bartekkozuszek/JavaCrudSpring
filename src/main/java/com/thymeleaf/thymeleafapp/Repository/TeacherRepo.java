package com.thymeleaf.thymeleafapp.Repository;

import com.thymeleaf.thymeleafapp.Models.Teacher;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TeacherRepo extends CrudRepository<Teacher, Integer> {
    @Query(value = "select count(*) from teacher u where u.name =:name AND u.department = :department AND u.updated_by = :updatedBy AND u.updated_on = :updatedOn", nativeQuery = true)
    int countTeacher(@Param("department") String department, @Param("name") String name, @Param("updatedBy") String updatedBy, @Param("updatedOn") String updatedOn);

    @Query(value = "select id from teacher u where u.name =:name  AND u.department = :department AND u.updated_by = :updatedBy AND u.updated_on = :updatedOn", nativeQuery = true)
    int findTeacher(@Param("department") String department, @Param("name") String name, @Param("updatedBy") String updatedBy, @Param("updatedOn") String updatedOn);

    @Query(value = "select * from teacher u where u.name LIKE %:search% OR u.department LIKE %:search% OR u.updated_by LIKE %:search%", nativeQuery = true)
    List<Teacher> search(@Param("search") String search);
}
