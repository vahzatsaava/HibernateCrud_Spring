package com.example.hibernatecrud_spring.controller;

import com.example.hibernatecrud_spring.model.File;
import com.example.hibernatecrud_spring.service.FileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasAnyRole('ADMIN','MODERATOR')")
    public File find(@PathVariable Long id) {
        return fileService.getOneFile(id);
    }

    @GetMapping()
    @PreAuthorize("hasAnyRole('ADMIN','MODERATOR')")
    public List<File> getAll() {
        return fileService.getAllFiles();
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public File create(@RequestBody File file) {
        return fileService.save(file);
    }

    @PreAuthorize("hasAnyRole('ADMIN','MODERATOR')")
    public File update(@RequestBody File file) {
        return fileService.update(file);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','MODERATOR')")
    public void delete(@PathVariable Long id) {
        fileService.deleteFile(id);
        log.info("User was deleted ");
    }
}
