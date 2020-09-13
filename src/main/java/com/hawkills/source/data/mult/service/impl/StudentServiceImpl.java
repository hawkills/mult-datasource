package com.hawkills.source.data.mult.service.impl;

import com.hawkills.source.data.mult.mapper.primary.StudentMapper;
import com.hawkills.source.data.mult.pojo.Student;
import com.hawkills.source.data.mult.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hawkills
 */
@Service
public class StudentServiceImpl implements StudentService {

    private final StudentMapper studentMapper;

    public StudentServiceImpl(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    @Override
    public Student find(Student student) {
        return studentMapper.find(student);
    }

    @Override
    public List<Student> findAll() {
        return studentMapper.findAll();
    }

    @Override
    public int add(Student student) {
        return studentMapper.add(student);
    }

    @Override
    public int modify(Student student) {
        return studentMapper.modify(student);
    }

    @Override
    public int remove(Student student) {
        return studentMapper.remove(student);
    }

}
