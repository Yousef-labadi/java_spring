package com.example.ProjectManager.Services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.example.ProjectManager.Models.LoginUser;
import com.example.ProjectManager.Models.Project;
import com.example.ProjectManager.Models.User;
import com.example.ProjectManager.Repository.ProjectRepo;
import com.example.ProjectManager.Repository.UserRepo;

@Service
public class AppServices {
		private final UserRepo userRepo;
		private final ProjectRepo projRepo;
		public AppServices(UserRepo userRepo,ProjectRepo projRepo) {
			this.userRepo=userRepo;
			this.projRepo=projRepo;
		}
		
    
    // TO-DO: Write register and login methods!
    public User register(User newUser, BindingResult result) {
        // TO-DO: Additional validations!
    	if (userRepo.findByEmail(newUser.getEmail()).isPresent()) {
    		result.rejectValue("email","unique","this is already in user");
    	}
    	if(result.hasErrors()) {
        return null;
    }
    	else {
    		String hashed=BCrypt.hashpw(newUser.getPassword(),BCrypt.gensalt());
    		newUser.setPassword(hashed);
    		return userRepo.save(newUser);
    	}
    }
    public User login(LoginUser newLogin, BindingResult result) {
        // TO-DO: Additional validations!
        if (result.hasErrors()) {
        	return null;
        }
        Optional <User> potentialUser=userRepo.findByEmail(newLogin.getEmail());
        if(!potentialUser.isPresent()) {
        	result.rejectValue("email","Unique","invalid input");
        	return null;
        }
        User user=potentialUser.get();
        if (!BCrypt.checkpw(newLogin.getPassword(),user.getPassword())) {
        result.rejectValue ("password","Matches","invalid input");
        }
        
        if(result.hasErrors()) {
            return null;
    }
        else {
        	return user;
        }
}
    public User findUserById(Long id) {
    	Optional <User> u=userRepo.findById(id);
    	if (u.isPresent()) {
    		return u.get();
    	}
    	else {
    		return null;
    	}
    }
    public Project createproject(Project  proj) {
    	
    	return projRepo.save(proj);
    }
    public List<Project> findAll(){
    	return projRepo.findAll();
    }
    
    public List<Project> notcontain(User user){
    	return projRepo.findByUsersNotContains(user);
    }
    public List<Project> contain(User user){
    	return projRepo.findAllByUsers(user);
    }
    public Project findProjectById(Long id) {
    	Optional <Project> p=projRepo.findById(id);
    	if (p.isPresent()) {
    		return p.get();
    	}
    	else {
    		return null;
    	}
    }
    public Project join(Project proj){
    	return projRepo.save(proj);
    }
    public Project leave(Project proj){
    	return projRepo.save(proj);
    }
    
    public Project editproject(Project  proj) {
    	return projRepo.save(proj);
    }
    public void delete(Long id) {
    	 projRepo.deleteById(id);
    }
    }


