package com.ra.controller;

import com.ra.entity.StudentEntity;
import com.ra.entity.StudentRequest;
import com.ra.service.impl.FileStorageService;
import com.ra.service.impl.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    private StudentService studentService;
    private FileStorageService fileStorageService;
    private ModelMapper modelMapper;
    public StudentController(StudentService studentService,FileStorageService fileStorageService,ModelMapper modelMapper) {
        this.studentService = studentService;
        this.fileStorageService = fileStorageService;
        this.modelMapper = modelMapper;
    }


    @GetMapping("/list")
    public String list(Model model) {
        List<StudentEntity> data = studentService.findAll();
        model.addAttribute("students", data);
        return "student/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("student", new StudentRequest());
        return "student/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute ("student")StudentRequest student,Model model) {
        student.setImageUrl(fileStorageService.uploadFile(student.getAvatar()));
        StudentEntity studentEntity = modelMapper.map(student, StudentEntity.class);
        studentService.save(studentEntity);
        return "redirect:/student/list";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") int id, Model model) {
        StudentEntity student = studentService.f(id);
        StudentRequest studentRequest = modelMapper.map(student, StudentRequest.class);
        model.addAttribute("student", studentRequest);
        return "student/edit";
    }

    @PostMapping("/edit/{id}")
    public String edit(@PathVariable("id") int id, @ModelAttribute("student") StudentRequest student, Model model) {
        StudentEntity studentEntity = modelMapper.map(student, StudentEntity.class);
        studentEntity.setStudentId(id);
        studentEntity.setImageUrl(fileStorageService.uploadFile(student.getAvatar()));
        studentService.edit(studentEntity);
        return "redirect:/student/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        studentService.delete(id);
        return "redirect:/student/list";
    }
}
