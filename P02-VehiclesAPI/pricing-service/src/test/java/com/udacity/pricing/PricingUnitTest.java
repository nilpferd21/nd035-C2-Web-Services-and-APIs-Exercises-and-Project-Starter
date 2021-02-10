package com.udacity.pricing;

import com.udacity.pricing.domain.price.Price;
import com.udacity.pricing.domain.price.PriceRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.jupiter.api.*;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PricingUnitTest {
    @Autowired
    private PriceRepository priceRepository;

    @Test
    public void shouldGetAllPrices() {
        Iterable<Price> prices = priceRepository.findAll();

        assertThat(prices).hasSize(20);
    }

    @Test
    public void shouldGetSpecificPrice() {
        Optional<Price> price = priceRepository.findById(4L);
        if (price.isPresent()) {
            Price thisPrice = price.get();
            Assertions.assertEquals(thisPrice.getPrice().intValue(), 80990);
        }
    }
}
