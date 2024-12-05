package rickalon.aexcea.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/seattle")
public class Aexcea_Seattle_Handler {
    
    @GetMapping("/users")
    public void GetUser(){
        System.out.println("Get user");
    }

    @PostMapping("/users")
    public void AddUser(){
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
