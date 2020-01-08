package controller;

import com.spring.example.SpringTutorial;
import com.spring.example.exception.StorageFileNotFoundException;
import com.spring.example.service.StorageService;
import java.nio.file.Paths;
import java.util.stream.Stream;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.hamcrest.Matchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;

/**
 *
 * @author Tanawit Aeabsakul
 */
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest(classes = SpringTutorial.class)
public class FileUploadTests {
    
    @Autowired
    private MockMvc mvc;
    
    @MockBean
    private StorageService storageService;
    
    @Test
    public void shouldListAllFiles() throws Exception {
        BDDMockito.given(storageService.loadAll())
                .willReturn(Stream.of(Paths.get("first.txt"), Paths.get("second.txt")));
        
        this.mvc.perform(get("/upload-files/")).andExpect(status().isOk())
                .andExpect(model().attribute("files", Matchers.contains("http://localhost/upload-files/files/first.txt", "http://localhost/upload-files/files/second.txt")));
    }
    
    @Test
    public void shouldSaveUploadedFile() throws Exception {
        MockMultipartFile multipartFile = new MockMultipartFile("file", "test.txt", "text/plain", "Spring Framework".getBytes());
        this.mvc.perform(fileUpload("/upload-files/").file(multipartFile))
                .andExpect(status().isFound())
                .andExpect(header().string("Location", "/api/upload-files/"));
        
        BDDMockito.then(this.storageService).should().store(multipartFile);
    }
    
    @SuppressWarnings("unchecked")
    @Test
    public void should404WhenMissingFile() throws Exception {
        BDDMockito.given(this.storageService.loadAsResource("text.txt"))
                .willThrow(StorageFileNotFoundException.class);
        
        this.mvc.perform(get("files/text.txt")).andExpect(status().isNotFound());
    }
}
