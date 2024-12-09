package rickalon.aexcea.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import rickalon.aexcea.model.AexceaUser;
import rickalon.aexcea.service.AexceaA;

@RestController
@RequestMapping("/aexcea/a")
public class AexceaA_Handler {

    
    @Value("${api.facegeneration.url}")
    private String faceGeneratorUrl;

    private final AexceaA aexceaA;
    private final static String USER_CREATED="user created";
    private final static String USER_MODIFIED="user modified";
    private final static String USER_DELETED="user deleted";
    private final static String NOT_USER_CREATED="user not created";
    private final static String NOT_USER_MODIFIED="user not modified";
    private final static String NOT_USER_DELETED="user not deleted";

    public AexceaA_Handler(AexceaA aexceaA){
        this.aexceaA = aexceaA;
    }
    
    @GetMapping("/faces")
    public ResponseEntity<byte[]> GetFaceGenerator(RestTemplate restTemplate){
        byte[] response = restTemplate.getForObject(faceGeneratorUrl, byte[].class);
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(response);
    }

    @GetMapping("/users/{id}")
    public AexceaUser GetUser(@PathVariable("id") long id){
        return aexceaA.getUser(id);
    }

    @PostMapping("/users")
    public String AddUser(@RequestBody AexceaUser aexceaUser){
        boolean result = aexceaA.addUser(aexceaUser);
        if(result){
            return USER_CREATED;
        }else{
            return NOT_USER_CREATED;
        }
    }

    @PatchMapping("/users/{id}")
    public String UpdateUser(@RequestBody AexceaUser user, @PathVariable("id") long id){
        boolean result = aexceaA.modifyUser(id, user);
        if(result){
            return USER_MODIFIED;
        }else{
            return NOT_USER_MODIFIED;
        }
    }

    @DeleteMapping("/users/{Wid}")
    public String DeleteUser(@PathVariable("id") long id){
        boolean result = aexceaA.deleteUser(id);
        if(result){
            return USER_DELETED;
        }else{
            return NOT_USER_DELETED;
        }
    }
}
