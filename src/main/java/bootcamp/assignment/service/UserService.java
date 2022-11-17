package bootcamp.assignment.service;

import bootcamp.assignment.entity.User;
import bootcamp.assignment.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    public User addUser(User user){
        return userRepository.save(user);
    }

    public User updateUser(Long id, User userDetails){
       Optional<User> user = userRepository.findById(id);

       user.get().setFirstName(userDetails.getFirstName());
       user.get().setLastName(userDetails.getFirstName());
       user.get().setEmail(userDetails.getFirstName());
       user.get().setPhoneNumber(userDetails.getFirstName());

       User updatedUser = userRepository.save(user.get());

       return updatedUser;
    }

    public User deleteUser(Long id){

        Optional<User> user = userRepository.findById(id);
        userRepository.deleteById(id);

        return user.get();
    }

}
