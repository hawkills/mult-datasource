package com.hawkills.source.data.mult.mapper.secondary;

import com.hawkills.source.data.mult.pojo.Teacher;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author hawkills
 */
@Repository
public interface TeacherMapper {

    /**
     * 根据id查询教师信息
     * @param id 教师id
     * @return Teacher
     */
    public Teacher findById(Integer id);

    /**
     * 查询所有教师信息
     * @return List<Teacher>
     */
    public List<Teacher> findAll();

    /**
     * 新增教师信息
     * @param teacher 教师信息
     * @return 受影响行数
     */
    public int add(Teacher teacher);

    /**
     * 更新教师信息
     * @param teacher 教师信息
     * @return 受影响行数
     */
    public int modify(Teacher teacher);

    /**
     * 根据id删除教师信息
     * @param id 教师id
     * @return 受影响行数
     */
    public int remove(Integer id);

}
