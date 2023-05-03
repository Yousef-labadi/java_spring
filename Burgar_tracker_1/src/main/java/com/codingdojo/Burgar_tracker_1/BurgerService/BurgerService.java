package com.codingdojo.Burgar_tracker_1.BurgerService;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.codingdojo.Burgar_tracker_1.models.Burger;
import com.codingdojo.Burgar_tracker_1.BurgerRepository.BurgerRepository;

@Service
public class BurgerService {
	
	
	private final BurgerRepository burgerRepository;
	public BurgerService(BurgerRepository burgerRepository) {
        this.burgerRepository = burgerRepository;
        
    }
	public Burger createBurger(Burger b) {
        return burgerRepository.save(b);
    }
	public List<Burger> allBurgers() {
        return burgerRepository.findAll();
    }
}
