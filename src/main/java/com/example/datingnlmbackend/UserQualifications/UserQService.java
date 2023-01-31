package com.example.datingnlmbackend.UserQualifications;

import com.example.datingnlmbackend.User.User;
import com.example.datingnlmbackend.User.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserQService implements UserQServiceInterface{
    UserQRepository userQRepository;
    UserRepository userRepository;

    public UserQService(UserQRepository userQRepository, UserRepository userRepository) {
        this.userQRepository = userQRepository;
        this.userRepository = userRepository;
    }

    public UserQualifications findUserQualificationsByUserId(Long userId){
        return userQRepository.findUserQualificationsByUserId(userId);
    }

    @Override
    public String save(UserQualifications userQualifications) {
        userQRepository.save(userQualifications);
            return "User Qualification saved";
    }

    @Override
    public List<UserQualifications> findAll() {
        return userQRepository.findAll();
    }
/*
    @Override
    public ArrayList<User> findAllUsersWithSpecificQualification(String q) {
        ArrayList<UserQualifications> arrayList = (ArrayList<UserQualifications>) userQRepository.findAll();
        ArrayList<User> userArrayList = new ArrayList<>();
        for (UserQualifications userQualifications:arrayList) {
            if(userQualifications.q1.equals(q) || userQualifications.q2.equals(q) || userQualifications.q3.equals(q) ||
                    userQualifications.q4.equals(q) || userQualifications.q5.equals(q)){
                userArrayList.add(userRepository.findUserById(userQualifications.userId));
            }
        }
        return userArrayList;
    }
*/
@Override
public List<User> findAllUsersWithSpecificQualification(String q) {
    List<UserQualifications> arrayList = userQRepository.findAll();
    List<User> userArrayList = new ArrayList<>();
    for (UserQualifications userQualifications:arrayList) {
        if(userQualifications.q1.equals(q) || userQualifications.q2.equals(q) || userQualifications.q3.equals(q) ||
                userQualifications.q4.equals(q) || userQualifications.q5.equals(q)){
            User user = userRepository.findUserById(userQualifications.userId);
            userArrayList.add(user);
        }
    }
    return userArrayList;
}
    @Override
    public List<User> findAllUsersWithXNrQualifications(ArrayList<String> qualificationArray) {
        ArrayList<User> userArrayListTotal = new ArrayList<>();
        int size = qualificationArray.size();
        for(int i = 0; i < size; i++){
            List<User> userArrayList = findAllUsersWithSpecificQualification(qualificationArray.get(i));
            userArrayListTotal.addAll(userArrayList);
        }
        ArrayList<User> returnArrayList = new ArrayList<>();
        int nrTimes = 0;
        if(size == 2){
            for (User user: userArrayListTotal) {
                for (User user1: userArrayListTotal) {
                    if(user.equals(user1)){
                        nrTimes++;
                        if(nrTimes == 2){
                            returnArrayList.add(user);
                        }
                    }
                }
            }
        }
        if(size == 3){
            for (User user: userArrayListTotal) {
                for (User user1: userArrayListTotal) {
                    if(user.equals(user1)){
                        nrTimes++;
                        if(nrTimes == 3){
                            returnArrayList.add(user);
                        }
                    }
                }
            }
        }
        if(size == 4){
            for (User user: userArrayListTotal) {
                for (User user1: userArrayListTotal) {
                    if(user.equals(user1)){
                        nrTimes++;
                        if(nrTimes == 4){
                            returnArrayList.add(user);
                        }
                    }
                }
            }
        }
        if(size == 5){
            for (User user: userArrayListTotal) {
                for (User user1: userArrayListTotal) {
                    if(user.equals(user1)){
                        nrTimes++;
                        if(nrTimes == 5){
                            returnArrayList.add(user);
                        }
                    }
                }
            }
        }
        return returnArrayList;
    }
}
