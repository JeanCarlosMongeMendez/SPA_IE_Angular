package cr.ac.ucr.service;

import cr.ac.ucr.Exception.LyExceptions;
import cr.ac.ucr.repository.ProvinceRepository;
import cr.ac.ucr.repository.UserProfileRepository;
import cr.ac.ucr.spa.Course;
import cr.ac.ucr.spa.Province;
import cr.ac.ucr.spa.UserProfile;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserProfileService {

    @Autowired
    private UserProfileRepository userProfileRepository;


    public List<UserProfile> listAll(){return userProfileRepository.findAll();}

    public void save(UserProfile userProfile){userProfileRepository.save(userProfile);}

    public UserProfile get(int id){return userProfileRepository.findById(id).get();}

    public void delete(int id){userProfileRepository.deleteById(id);}

    public UserProfile update(UserProfile entity) throws LyExceptions.RecordNotFoundException {
        UserProfile entityToUpdate = userProfileRepository.findById(entity.getIdUserProfile()).get();

        if(entityToUpdate != null) {
            return userProfileRepository.save(entity);
        } else throw new LyExceptions.RecordNotFoundException(UserProfile.class.getName());
    }
}
