package com.codingdojo.DojoandNinjas.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.DojoandNinjas.models.Dojo;
import com.codingdojo.DojoandNinjas.models.Ninja;
import com.codingdojo.DojoandNinjas.repositories.DojoRepo;
import com.codingdojo.DojoandNinjas.repositories.Ninjarepo;
@Service
public class AppServices {
	private final DojoRepo dojoRepository;
	private final Ninjarepo ninjaRepository;
    public AppServices(DojoRepo dojoRepository,Ninjarepo ninjaRepository) {
        this.dojoRepository = dojoRepository;
        this.ninjaRepository = ninjaRepository;
        
    }
    public Dojo createDojo(Dojo d) {
        return dojoRepository.save(d);
    }
    public List<Dojo> findall(){
    	 return dojoRepository.findAll();
    }
    public Ninja createninja(Ninja n) {
        return ninjaRepository.save(n);
    }
    
    public Dojo findDojo(long id){
    	if (dojoRepository.findById(id).isPresent()) {
    		return dojoRepository.findById(id).get();
   }
    	else {
    		return null;
    	}
    }
}
    
  

