package com.github.monaboiste.trainrides;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;

@SpringBootTest
class TrainRidesApplicationTests {

	@Test
	void context_loads() {
		assertThatNoException()
				.describedAs("Should load the Spring Application Context")
				.isThrownBy(() -> {});
	}
}
