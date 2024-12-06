package rickalon.aexcea.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import rickalon.aexcea.model.AexceaUser;
import rickalon.aexcea.repository.AexceaUserRepository;

@Service
public class AexceaA {
    
    private AexceaUserRepository aexceaUserRepository;

    public AexceaA(AexceaUserRepository aexceaUserRepository){
        this.aexceaUserRepository = aexceaUserRepository;
    }

    public void addUser(AexceaUser user){
        aexceaUserRepository.save(user);
    }

    public AexceaUser getUser(long id){
        Optional<AexceaUser> user = aexceaUserRepository.findById(id);
        return user.orElse(new AexceaUser());
    }

    public void deleteUser(long id){
        aexceaUserRepository.deleteById(id);
    }

    public void modifyUser(){
    }

}
