package com.codingdojo.BookClub.Service;


import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.BookClub.Repositories.BookRepo;
import com.codingdojo.BookClub.Repositories.UserRepo;
import com.codingdojo.BookClub.models.Book;
import com.codingdojo.BookClub.models.LoginUser;
import com.codingdojo.BookClub.models.User;



@Service
public class AppService {
	
    private UserRepo userRepo;
	private BookRepo bookRepo;
	
	public AppService(UserRepo userRepo ,BookRepo bookRepo) {
		this.userRepo=userRepo;
		this.bookRepo=bookRepo;
		
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
    public Book Creatbook(Book b) {
    	return bookRepo.save(b);
    	
    }
   
    	
    public List<Book> allBooks(){
		return bookRepo.findAll();
	}
    public Book findBookById(Long id) {
    	Optional <Book> b=bookRepo.findById(id);
    	if (b.isPresent()) {
    		return b.get();
    	}
    	else {
    		return null;
    	}
    }
    public Book editbook(Book b) {
    	return bookRepo.save(b);
    	
    }
    public void deleteBook(long id) {
    	bookRepo.deleteById(id);
	   }
}

