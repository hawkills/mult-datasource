package com.hawkills.source.data.mult.mapper.primary;

import com.hawkills.source.data.mult.pojo.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author hawkills
 */
@Repository
public interface StudentMapper {

    /**
     * 根据学生信息查询学生详细信息
     * @param student 学生信息
     * @return Student
     */
    public Student find(Student student);

    /**
     * 查询所有学生信息
     * @return List<Student>
     */
    public List<Student> findAll();

    /**
     * 添加学生信息
     * @param student 学生信息
     * @return 受影响行数
     */
    public int add(Student student);

    /**
     * 更新学生信息
     * @param student 学生信息
     * @return 受影响行数
     */
    public int modify(Student student);

    /**
     * 删除学生信息
     * @param student 学生信息
     * @return 受影响行数
     */
    public int remove(Student student);
}
