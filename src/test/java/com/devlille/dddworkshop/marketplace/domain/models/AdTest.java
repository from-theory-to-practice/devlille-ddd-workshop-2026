package com.devlille.dddworkshop.marketplace.domain.models;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatException;

import com.devlille.dddworkshop.marketplace.domain.models.exceptions.InvalidAdException;
import com.devlille.dddworkshop.marketplace.domain.models.exceptions.InvalidAdStatusException;
import com.devlille.dddworkshop.marketplace.domain.models.exceptions.InvalidDiscountPercentException;
import com.devlille.dddworkshop.shared.domain.MusicianId;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class AdTest {

  private final MusicianId musicianId = new MusicianId(UUID.randomUUID());

  @Nested
  class Publish {

    @Test
    @DisplayName("When publishing an Ad with invalid Instrument, it throws an exception")
    void invalid_instrument() {
      assertThatException()
        .isThrownBy(() -> Ad.publish(musicianId, "", new Price(new BigDecimal("1999.99"), Currency.getInstance("EUR"))))
        .isInstanceOf(InvalidAdException.class)
        .withMessageContaining("Instrument cannot be blank");
    }

    @Test
    @DisplayName("When publishing an Ad, the status is Available")
    void success() throws InvalidAdException {
      Ad cut = Ad.publish(musicianId, "Fender American Professional 2", new Price(new BigDecimal("1999.99"), Currency.getInstance("EUR")));

      assertThat(cut.getStatus()).isEqualTo(AdStatus.AVAILABLE);
    }
  }


  @Nested
  class Discount {

    @Test
    @DisplayName("When applying discount, the price is updated")
    void applyDiscount() throws InvalidAdException, InvalidDiscountPercentException {
      Price originalPrice = new Price(new BigDecimal("1999.99"), Currency.getInstance("EUR"));
      Ad cut = Ad.publish(musicianId, "Fender American Professional 2", originalPrice);

      cut.applyDiscount(20f);

      assertThat(cut.getPrice()).isNotEqualTo(originalPrice);
    }
  }


  @Nested
  class Sell {

    @Test
    @DisplayName("When successfully selling an Ad, it is now SOLD_OUT")
    void success() throws InvalidAdStatusException, InvalidAdException {
      Ad cut = Ad.publish(musicianId, "Fender American Professional 2", new Price(new BigDecimal("1999.99"),
        Currency.getInstance("EUR")));

      cut.sell();

      assertThat(cut.getStatus()).isEqualTo(AdStatus.SOLD_OUT);
    }

    @Test
    @DisplayName("When selling a non-available Ad, it throws an exception")
    void nonAvailableAd() throws InvalidAdStatusException, InvalidAdException {
      Ad cut = Ad.publish(musicianId, "Fender American Professional 2", new Price(new BigDecimal("1999.99"),
        Currency.getInstance("EUR")));

      cut.sell();

      assertThatException()
        .isThrownBy(cut::sell)
        .isInstanceOf(InvalidAdStatusException.class)
        .withMessageContaining("Cannot sell a non-available Ad");
    }
  }
}
