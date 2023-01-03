package com.example.hibernatecrud_spring.service;

import com.example.hibernatecrud_spring.model.File;
import com.example.hibernatecrud_spring.model.Status;
import com.example.hibernatecrud_spring.repository.FileRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class FileServiceTest {
    @Autowired
    private FileService fileService;

    @MockBean
    private FileRepository fileRepository;

    private final File file = new File("name", "www.file", Status.ACTIVE);

    @Test
    void getOneFile_Successful() {
        when(fileRepository.find(10L)).thenReturn(file);
        assertEquals(fileService.getOneFile(10L).getFileName(),"name");
    }

    @Test
    void getOneFile_unSuccessful() {
        when(fileRepository.find(10L)).thenReturn(file);
        assertNotEquals(fileService.getOneFile(10L).getFileName(),"names");
    }

    @Test
    void save_Successful() {
        when(fileRepository.add(any(File.class))).thenReturn(file);
        assertEquals(fileService.save(file).getFileName(),"name");
    }
    @Test
    void save_UnSuccessful() {
        when(fileRepository.add(any(File.class))).thenReturn(file);
        assertNotEquals(fileService.save(file).getFileName(),"names");
    }

    @Test
    void update_Successful() {
        when(fileRepository.update(any(File.class))).thenReturn(file);
        assertEquals(fileService.update(file).getFileName(),"name");
    }
    @Test
    void update_UnSuccessful() {
        when(fileRepository.update(any(File.class))).thenReturn(file);
        assertNotEquals(fileService.update(file).getFileName(),"names");
    }

    @Test
    void getAllFiles_Successful() {
        when(fileRepository.getAll()).thenReturn(List.of(file));
        assertEquals(fileService.getAllFiles(),List.of(file));
    }
    @Test
    void getAllFiles_UnSuccessful() {
        when(fileRepository.getAll()).thenReturn(List.of(file));
        assertNotEquals(fileService.getAllFiles(),null);
    }
}