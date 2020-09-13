package com.hawkills.source.data.mult.service.impl;

import com.hawkills.source.data.mult.mapper.secondary.TeacherMapper;
import com.hawkills.source.data.mult.pojo.Teacher;
import com.hawkills.source.data.mult.service.TeacherService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hawkills
 */
@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherMapper teacherMapper;

    public TeacherServiceImpl(TeacherMapper teacherMapper) {
        this.teacherMapper = teacherMapper;
    }

    @Override
    public Teacher findById(Integer id) {
        return teacherMapper.findById(id);
    }

    @Override
    public List<Teacher> findAll() {
        return teacherMapper.findAll();
    }

    @Override
    public int add(Teacher teacher) {
        return teacherMapper.add(teacher);
    }

    @Override
    public int modify(Teacher teacher) {
        return teacherMapper.modify(teacher);
    }

    @Override
    public int remove(Integer id) {
        return teacherMapper.remove(id);
    }

}
