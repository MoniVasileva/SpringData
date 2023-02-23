package bg.softuni.advancedqueries.services;

import bg.softuni.advancedqueries.entities.Shampoo;
import bg.softuni.advancedqueries.entities.Size;
import bg.softuni.advancedqueries.repositories.ShampooRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShampooServiceImpl implements ShampooService {

    private final ShampooRepository shampooRepository;

    public ShampooServiceImpl(ShampooRepository shampooRepository){
        this.shampooRepository=shampooRepository;
    }


    @Override
    public List<Shampoo> findByBrand(String brand) {
        return this.shampooRepository.findByBrand(brand);
    }

    @Override
    public List<Shampoo> findByBrandAndSize(String brand, Size size) {
        return this.shampooRepository.findByBrandAndSize(brand,size);
    }

    @Override
    public List<Shampoo> findByIngredient(String ingredient) {
        return this.shampooRepository.findByIngredient(ingredient);
    }
}
