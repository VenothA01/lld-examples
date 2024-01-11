package com.dailycoder.file.uploader.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.core.io.Resource;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.UrlResource;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class FilesStorageServiceImplTest {

    private FilesStorageServiceImpl filesStorageService;

    @Mock
    private MultipartFile mockFile;

    private Path testRoot;

    @BeforeEach
    void setUp() throws IOException {
        MockitoAnnotations.initMocks(this);
        testRoot = Files.createTempDirectory("test-uploads");
        filesStorageService = new FilesStorageServiceImpl();
    }

    @Test
    void init_shouldCreateDirectories() {
        assertTrue(Files.exists(testRoot));
        filesStorageService.init();
        assertTrue(Files.isDirectory(testRoot));
    }

    @Test
    void save_shouldCopyFile() throws IOException {
        when(mockFile.getInputStream()).thenReturn(getClass().getResourceAsStream("/test-file.txt"));
        String fileName = "test-file.txt";

        filesStorageService.save(mockFile);

        Path savedFilePath = testRoot.resolve(fileName);
        assertTrue(Files.exists(savedFilePath));
    }

    @Test
    void save_shouldThrowExceptionOnDuplicateFile() throws IOException {
        when(mockFile.getInputStream()).thenReturn(getClass().getResourceAsStream("/test-file.txt"));
        String fileName = "test-file.txt";

        filesStorageService.save(mockFile);

        // Attempt to save the same file again
        assertThrows(RuntimeException.class, () -> filesStorageService.save(mockFile));
    }

    @Test
    void load_shouldLoadResource() throws IOException {
        String fileName = "test-file.txt";
        Path filePath = testRoot.resolve(fileName);
        Files.createFile(filePath);

        Resource resource = filesStorageService.load(fileName);

        assertNotNull(resource);
        assertTrue(resource.exists());
        assertTrue(resource.isReadable());
    }

    @Test
    void load_shouldThrowExceptionForNonExistentFile() {
        String fileName = "non-existent-file.txt";

        assertThrows(RuntimeException.class, () -> filesStorageService.load(fileName));
    }

    @Test
    void delete_shouldDeleteFile() throws IOException {
        String fileName = "test-file.txt";
        Path filePath = testRoot.resolve(fileName);
        Files.createFile(filePath);

        assertTrue(filesStorageService.delete(fileName));
        assertFalse(Files.exists(filePath));
    }

    @Test
    void delete_shouldReturnFalseForNonExistentFile() {
        String fileName = "non-existent-file.txt";
        assertFalse(filesStorageService.delete(fileName));
    }

    @Test
    void deleteAll_shouldDeleteAllFiles() throws IOException {
        Files.createFile(testRoot.resolve("file1.txt"));
        Files.createFile(testRoot.resolve("file2.txt"));

        filesStorageService.deleteAll();

        assertFalse(Files.exists(testRoot.resolve("file1.txt")));
        assertFalse(Files.exists(testRoot.resolve("file2.txt")));
        assertFalse(Files.exists(testRoot));
    }

    @Test
    void loadAll_shouldReturnStreamOfFiles() throws IOException {
        Files.createFile(testRoot.resolve("file1.txt"));
        Files.createFile(testRoot.resolve("file2.txt"));

        Stream<Path> fileStream = filesStorageService.loadAll();

        assertNotNull(fileStream);
        assertEquals(2, fileStream.count());
    }
}
