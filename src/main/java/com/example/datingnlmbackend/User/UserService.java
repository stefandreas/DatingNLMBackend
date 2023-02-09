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
        List<String> arrayPreferences = userPreferences.getAllPreferences();
        int matchScore = 0;

        if(arrayPreferences.contains(userQualifications.getQ1())){
            matchScore += 20;
        }
        if(arrayPreferences.contains(userQualifications.getQ2())){
            matchScore += 20;
        }
        if(arrayPreferences.contains(userQualifications.getQ3())){
            matchScore += 20;
        }
        if(arrayPreferences.contains(userQualifications.getQ4())){
            matchScore += 20;
        }
        if(arrayPreferences.contains(userQualifications.getQ5())){
            matchScore += 20;
        }
        /*
        if(userQualifications.getQ1().equals(userPreferences.getP1()) || userQualifications.getQ1().equals(userPreferences.getP2()) ||
                userQualifications.getQ1().equals(userPreferences.getP3()) || userQualifications.getQ1().equals(userPreferences.getP4()) ||
                        userQualifications.getQ1().equals(userPreferences.getP5())){
            matchScore += 20;
        }
         */
        return matchScore;
    }

    public Long save(User user){
            return userRepository.save(user).getId();
    }
    public String updateUser(User updatedUser){
        User user = findUserById(updatedUser.getId());
        user.update(updatedUser);
        userRepository.save(user);
        return "User have  been updated";
    }
    public String deleteUser(User user){
        User userToDelete = userRepository.findUserById(user.getId());
        userRepository.delete(userToDelete);
            return "User "+user.getFirstname()+" "+user.getLastname()+" was deleted!";
    }

    @Override
    public Long findUserIdByEmail(String email) {
        User user = userRepository.findUserByEmail(email);
        return user.getId();
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }
}
