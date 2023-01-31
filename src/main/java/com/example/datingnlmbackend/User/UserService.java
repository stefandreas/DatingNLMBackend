package com.example.datingnlmbackend.User;

import com.example.datingnlmbackend.Qualification.Qualification;
import com.example.datingnlmbackend.Qualification.QualificationRepository;

import com.example.datingnlmbackend.UserPreferences.UserPrefRepository;
import com.example.datingnlmbackend.UserPreferences.UserPreferences;
import com.example.datingnlmbackend.UserQualifications.UserQRepository;
import com.example.datingnlmbackend.UserQualifications.UserQualifications;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserService implements UserServiceInterface {

    private final UserRepository userRepository;
    private final QualificationRepository qualificationRepository;
    private final UserQRepository userQRepository;
    private final UserPrefRepository userPrefRepository;

    public UserService(UserRepository userRepository, QualificationRepository qualificationRepository,
        UserQRepository userQRepository, UserPrefRepository userPrefRepository) {
        this.userRepository = userRepository;
        this.qualificationRepository = qualificationRepository;
        this.userQRepository = userQRepository;
        this.userPrefRepository = userPrefRepository;
    }

    @Override
    public User saveUserWithQualifications(UserDTO userDTO) {
        User user = new User();
        user.setFirstname(userDTO.getFirstname());
        user.setLastname(userDTO.getLastname());
        List<Qualification> qualifications = new ArrayList<>();
        for (String qual : userDTO.getQualifications()) {
            Qualification qualification = qualificationRepository.findByQualification(qual);
            if (qualification != null) {
                qualifications.add(qualification);
            }
        }
       // user.setQualifications(qualifications);
        return userRepository.save(user);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User findUserById(Long id){
        return userRepository.findUserById(id);
    }
    public User findUserByFirstnameAndLastname(String firstname, String lastname){
        return userRepository.findUserByFirstnameAndLastname(firstname,lastname);
    }

    public int matchWithProfile(Long userId, Long visitedProfileId){
        UserQualifications userQualifications = userQRepository.findUserQualificationsByUserId(userId);
        UserPreferences userPreferences = userPrefRepository.findUserPreferencesByUserId(visitedProfileId);
        int matchScore = 0;

        if(userQualifications.getQ1().equals(userPreferences.getP1()) || userQualifications.getQ1().equals(userPreferences.getP2()) ||
                userQualifications.getQ1().equals(userPreferences.getP3()) || userQualifications.getQ1().equals(userPreferences.getP4()) ||
                        userQualifications.getQ1().equals(userPreferences.getP5())){
            matchScore += 20;
        }
        if(userQualifications.getQ2().equals(userPreferences.getP1()) || userQualifications.getQ2().equals(userPreferences.getP2()) ||
                userQualifications.getQ2().equals(userPreferences.getP3()) || userQualifications.getQ2().equals(userPreferences.getP4()) ||
                userQualifications.getQ2().equals(userPreferences.getP5())){
            matchScore += 20;
        }
        if(userQualifications.getQ3().equals(userPreferences.getP1()) || userQualifications.getQ3().equals(userPreferences.getP2()) ||
                userQualifications.getQ3().equals(userPreferences.getP3()) || userQualifications.getQ3().equals(userPreferences.getP4()) ||
                userQualifications.getQ3().equals(userPreferences.getP5())){
            matchScore += 20;
        }
        if(userQualifications.getQ4().equals(userPreferences.getP1()) || userQualifications.getQ4().equals(userPreferences.getP2()) ||
                userQualifications.getQ4().equals(userPreferences.getP3()) || userQualifications.getQ4().equals(userPreferences.getP4()) ||
                userQualifications.getQ4().equals(userPreferences.getP5())){
            matchScore += 20;
        }
        if(userQualifications.getQ5().equals(userPreferences.getP1()) || userQualifications.getQ5().equals(userPreferences.getP2()) ||
                userQualifications.getQ5().equals(userPreferences.getP3()) || userQualifications.getQ5().equals(userPreferences.getP4()) ||
                userQualifications.getQ5().equals(userPreferences.getP5())){
            matchScore += 20;
        }
        return matchScore;
    }

    public String save(User user){
        userRepository.save(user);
            return "User saved";
    }
    public ResponseEntity<User> updateUser(User updatedUser){
        return new ResponseEntity<>(userRepository.save(updatedUser), HttpStatus.ACCEPTED);
    }
    public String deleteUser(User user){
        User userToDelete = userRepository.findUserById(user.getId());
        userRepository.delete(userToDelete);
            return "User "+user.getFirstname()+" "+user.getLastname()+" was deleted!";
    }
}
