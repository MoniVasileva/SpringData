package bg.softuni.advancedqueries.repositories;

import bg.softuni.advancedqueries.entities.Shampoo;
import bg.softuni.advancedqueries.entities.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShampooRepository extends JpaRepository<Shampoo, Long> {
    List<Shampoo> findByBrand(String brand);

    List<Shampoo> findByBrandAndSize(String brand, Size size);

    @Query(value = "select s from Shampoo as s JOIN s.ingredients as i where i.name = :ingredient")
    List<Shampoo> findByIngredient(String ingredient);
}
