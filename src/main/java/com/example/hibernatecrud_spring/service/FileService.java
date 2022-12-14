package com.example.hibernatecrud_spring.service;

import com.example.hibernatecrud_spring.model.File;
import com.example.hibernatecrud_spring.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileService {
    private final FileRepository fileRepository;

    @Autowired
    public FileService(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    public File getOneFile(Integer id) {
        return fileRepository.find(id);
    }

    public File save(File file) {
        return fileRepository.add(file);
    }

    public File update(File file) {
        return fileRepository.update(file);
    }

    public List<File> getAllFiles() {
        return fileRepository.getAll();
    }

    public void deleteFile(Integer id) {
        fileRepository.delete(id);
    }
}
