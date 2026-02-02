package in.anirudhjwala.module3jpa.repository;

import in.anirudhjwala.module3jpa.entities.ProductEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    List<ProductEntity> findByTitle(String pepsi);

    // Find all elements and order by price
    List<ProductEntity> findByOrderByPrice();

    // Find all elements with sort parameter on any field
    List<ProductEntity> findBy(Sort sort);

    // Find all elements by title with pagination
    List<ProductEntity> findByTitleContainingIgnoreCase(String title, Pageable pageable);

    // Find elements after a certain date
    List<ProductEntity> findByCreatedAtAfter(LocalDateTime after);

    // Find elements by quantity and price equal to
    List<ProductEntity> findByQuantityAndPrice(int quantity, BigDecimal price);

    // Find elements by quantity and price less than
    List<ProductEntity> findByQuantityAndPriceLessThan(int quantity, BigDecimal price);

    // Find elements by quantity or price less than
    List<ProductEntity> findByQuantityOrPriceLessThan(int quantity, BigDecimal price);

    // Find elements by product title like
    List<ProductEntity> findByTitleLike(String title);

    // Find elements by product containing
    List<ProductEntity> findByTitleContaining(String title);

    // Find elements by product containing ignoring case
    List<ProductEntity> findByTitleContainingIgnoreCase(String title);

    // Find single element by title and price
    Optional<ProductEntity> findByTitleAndPrice(String title, BigDecimal price);

    // Custom query to find single element by title and price
    @Query("SELECT p.title FROM ProductEntity p WHERE p.title=?1 AND p.price=?2")
    Optional<ProductEntity> findByTitleAndPriceCustom(String title, BigDecimal price);

    // Another format --> SELECT p.title FROM ProductEntity p WHERE p.title=:title AND p.price=:price
}
