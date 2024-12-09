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

    public boolean addUser(AexceaUser user){
        aexceaUserRepository.save(user);
        return true;
    }

    public AexceaUser getUser(long id){
        Optional<AexceaUser> user = aexceaUserRepository.findById(id);
        return user.orElse(new AexceaUser());
    }

    public boolean deleteUser(long id){
        aexceaUserRepository.deleteById(id);
        return true;
    }

    public boolean modifyUser(long id, AexceaUser user){
        Optional<AexceaUser> opUser = aexceaUserRepository.findById(id);
        if(opUser.isEmpty()){
            return false;
        }
        AexceaUser existingUser = opUser.get();
        if(user.getName() != null && !user.getName().isEmpty()){
            existingUser.setName(user.getName());
        }
        if(user.getAge()!=null && user.getAge()!=0){
            existingUser.setAge(user.getAge());
        }
        return addUser(existingUser);
    }

}
