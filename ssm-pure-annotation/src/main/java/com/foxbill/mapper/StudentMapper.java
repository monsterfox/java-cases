package com.foxbill.mapper;

import com.foxbill.pojo.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface StudentMapper {
    @Insert("insert into student values(null,#{name},#{age})")
    int insertStudent(Student student);
    @Update("update student set name = #{name},age = #{age} where id = #{id}")
    int updateStudent(Student student);
    @Delete("delete from student where id = #{id}")
    int deleteStudent(int id);

    @Select("select * from student where id = #{id}")
    Student selectStudentById(int id);

    @Select("select * from student")
    List<Student> selectAllStudents();

}
