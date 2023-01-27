package com.example.datingnlmbackend.User;

import com.example.datingnlmbackend.Qualification.Qualification;
import com.example.datingnlmbackend.Qualification.QualificationRepository;

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
        List<Qualification> qualifications = new ArrayList<>();
        for (String qual : userDTO.getQualifications()) {
            Qualification qualification = qualificationRepository.findByQualification(qual);
            if (qualification != null) {
                qualifications.add(qualification);
            }
        }
        user.setQualifications(qualifications);
        return userRepository.save(user);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

}



    /*@Override
    public User login(String username, String password) {
        return null;
    }

     */

    //metod för registrering://
   /* public User register(User user, List<String> qualifications) {
        User savedUser = userRepository.save(user);

        List<Qualification> qualificationsList = qualificationRepository.findAll(qualifications);
        List<UserQualification> userQualifications = qualificationsList.stream()
                .map(q -> {
                    UserQualification uq = new UserQualification();
                    uq.setUser(savedUser);
                    uq.setQualification(q);
                    return uq;
                })
                .collect(Collectors.toList());
        userQualificationRepository.saveAll(userQualifications);

        return savedUser;
    }

    */







