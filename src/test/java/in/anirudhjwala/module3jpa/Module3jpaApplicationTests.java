package in.anirudhjwala.module3jpa;

import in.anirudhjwala.module3jpa.entities.ProductEntity;
import in.anirudhjwala.module3jpa.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class Module3jpaApplicationTests {

	@Autowired
	ProductRepository productRepository;

	@Test
	void testRepository() {
		productRepository.deleteAll();

		ProductEntity productEntity = ProductEntity.builder()
				.sku("nestle234")
				.title("Nestle Chocolate")
				.price(new BigDecimal("23.45"))
				.quantity(4)
				.createdAt(LocalDateTime.of(2024, 1, 1, 0,0,0))
				.build();

		productRepository.save(productEntity);
	}

	@Test
	void getRepository() {
		testRepository();

		List<ProductEntity> entities = productRepository.findAll();
		System.out.println(entities);
	}

	@Test
	void getByXRepository() {
		testRepository();

		List<ProductEntity> productEntities = productRepository.findByTitle("Nestle Chocolate");
		System.out.println(productEntities);
	}

	@Test
	void getAfterRepository() {
		testRepository();

		List<ProductEntity> productEntities = productRepository.findByCreatedAtAfter(LocalDateTime.of(2023, 12, 31, 23,59,59));
		System.out.println(productEntities);
	}

	@Test
	void getQuantityRepository() {
		testRepository();

		List<ProductEntity> productEntities = productRepository.findByQuantityAndPrice(4, new BigDecimal("23.45"));
		System.out.println(productEntities);
	}

	@Test
	void getQuantityLessThanRepository() {
		testRepository();

		List<ProductEntity> productEntities = productRepository.findByQuantityAndPriceLessThan(4, new BigDecimal("23.45"));
		System.out.println(productEntities);
	}

	@Test
	void getQuantityOrLessThanRepository() {
		testRepository();

		List<ProductEntity> productEntities = productRepository.findByQuantityOrPriceLessThan(4, new BigDecimal("23.45"));
		System.out.println(productEntities);
	}

	@Test
	void getTitleLikeRepository() {
		testRepository();

		List<ProductEntity> productEntities = productRepository.findByTitleLike("%Choco%");
		System.out.println(productEntities);
	}

	@Test
	void getTitleContainingRepository() {
		testRepository();

		List<ProductEntity> productEntities = productRepository.findByTitleContaining("Choco");
		System.out.println(productEntities);
	}

	@Test
	void getTitleContainingIgoreCaseRepository() {
		testRepository();

		List<ProductEntity> productEntities = productRepository.findByTitleContainingIgnoreCase("choco");
		System.out.println(productEntities);
	}

	@Test
	void getSingleByTitleAndPriceRepository() {
		testRepository();

		Optional<ProductEntity> productEntity = productRepository.findByTitleAndPrice("choco", BigDecimal.valueOf(23.45));
		productEntity.ifPresent(System.out::println);
	}

	@Test
	void getSingleByTitleAndPriceCustomRepository() {
		testRepository();

		Optional<ProductEntity> productEntity = productRepository.findByTitleAndPriceCustom("choco", BigDecimal.valueOf(23.45));
		productEntity.ifPresent(System.out::println);
	}
}
