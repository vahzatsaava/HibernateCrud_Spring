package com.example.hibernatecrud_spring.controller;

import com.example.hibernatecrud_spring.model.File;
import com.example.hibernatecrud_spring.service.FileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/files")
@Slf4j
public class FileController {
    private final FileService fileService;

    @Autowired
    public FileController(FileService fileService) {
        this.fileService = fileService;
    }
    @GetMapping("/{id}")
    public File find(@PathVariable Integer id) {
        return fileService.getOneFile(id);
    }
    @GetMapping()
    public List<File> getAll() {
        return fileService.getAllFiles();
    }

    @PostMapping
    public File create(@RequestBody File file) {
        return fileService.save(file);
    }

    @PutMapping
    public File update(@RequestBody File file) {
        return fileService.update(file);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        fileService.deleteFile(id);
        log.info("User was deleted ");
    }
}
