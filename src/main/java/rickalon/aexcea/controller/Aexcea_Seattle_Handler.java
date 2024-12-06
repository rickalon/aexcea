package rickalon.aexcea.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/aexcea/a")
public class Aexcea_Seattle_Handler {

    @Value("${api.facegeneration.url}")
    private String faceGeneratorUrl;
    
    @GetMapping("/faces")
    public ResponseEntity<byte[]> GetFaceGenerator(RestTemplate restTemplate){
        byte[] response = restTemplate.getForObject(faceGeneratorUrl, byte[].class);
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(response);
    }

    @GetMapping("/users")
    public void GetUser(){
        System.out.println("Get user");
    }

    @PostMapping("/users")
    public void AddUser(RestTemplate restTemplate){
        System.out.println("Add user");
    }

    @PatchMapping("/users")
    public void UpdateUser(){
        System.out.println("Update user");
    }

    @DeleteMapping("/users")
    public void DeleteUser(){
        System.out.println("Delete user");
    }
}
