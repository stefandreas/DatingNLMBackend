package com.example.datingnlmbackend.User;

import com.example.datingnlmbackend.Qualification.Qualification;
import com.example.datingnlmbackend.Qualification.QualificationRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserService implements UserServiceInterface {

    private final UserRepository userRepository;

    private final QualificationRepository qualificationRepository;

    public UserService(UserRepository userRepository, QualificationRepository qualificationRepository) {
        this.userRepository = userRepository;
        this.qualificationRepository = qualificationRepository;
    }

    @Override
    public User saveUserWithQualifications(UserDTO userDTO) {
        User user = new User();
        user.setFirstname(userDTO.getFirstname());
        user.setLastname(userDTO.getLastname());
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setGender(userDTO.getGender());
        user.setCity(userDTO.getCity());
        user.setDescription(userDTO.getDescription());

        List<Qualification> qualifications = new ArrayList<>();
        List<Qualification> prefferedQualifications = new ArrayList<>();
        for (String qual : userDTO.getQualifications()) {
            Qualification qualification = qualificationRepository.findByQualification(qual);
            if (qualification != null) {
                qualifications.add(qualification);
            }
        }
        for (String prefferdQual: userDTO.getPreferredQualifications()) {
            Qualification prefferedQualification = qualificationRepository.findByQualification(prefferdQual);
            if(prefferedQualification != null) {
                prefferedQualifications.add(prefferedQualification);
            }
        }
        user.setQualifications(qualifications);
        user.setPreferredQualifications(prefferedQualifications);
        return userRepository.save(user);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User findUserById(Long userId){
       return userRepository.findUserById(userId);
    }
    public User findUserByFirstnameAndLastname(String firstname, String lastname){
        return userRepository.findUserByFirstnameAndLastname(firstname,lastname);
    }
    public void save(User user){
        userRepository.save(user);
    }
    public ResponseEntity<User> updateUser(User updatedUser){
        return new ResponseEntity<>(userRepository.save(updatedUser), HttpStatus.ACCEPTED);
    }
    public String deleteUser(User user){
        User userToDelete = findUserById(user.getId());
        userRepository.delete(userToDelete);
        return "User "+user.getFirstname()+" "+user.getLastname()+" was deleted!";
    }
}
