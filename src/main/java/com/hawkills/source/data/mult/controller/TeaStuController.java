package com.hawkills.source.data.mult.controller;

import com.hawkills.source.data.mult.pojo.Student;
import com.hawkills.source.data.mult.pojo.Teacher;
import com.hawkills.source.data.mult.service.StudentService;
import com.hawkills.source.data.mult.service.TeacherService;
import org.springframework.web.bind.annotation.*;

/**
 * @author hawkills
 */
@RestController
@RequestMapping("sys")
public class TeaStuController {

    private final StudentService studentService;
    private final TeacherService teacherService;

    public TeaStuController(StudentService studentService, TeacherService teacherService) {
        this.studentService = studentService;
        this.teacherService = teacherService;
    }
    @GetMapping("stu/find")
    public Object find(Student student) {
        return studentService.find(student);
    }

    @GetMapping("tea/all")
    public Object findTeaAll() {
        return teacherService.findAll();
    }
    @GetMapping("tea/find/{id}")
    public Object findTea(@PathVariable Integer id) {
        return teacherService.findById(id);
    }

    @GetMapping("tea/add")
    public Object addTea(Teacher teacher) {
        return teacherService.add(teacher);
    }

    @GetMapping("tea/modify")
    public Object modifyTea(Teacher teacher) {
        return teacherService.modify(teacher);
    }
}
