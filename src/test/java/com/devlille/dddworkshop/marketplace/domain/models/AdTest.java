package com.devlille.dddworkshop.marketplace.domain.models;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatException;

import com.devlille.dddworkshop.marketplace.domain.models.exceptions.InvalidAdException;
import com.devlille.dddworkshop.marketplace.domain.models.exceptions.InvalidAdStatusException;
import com.devlille.dddworkshop.shared.domain.MusicianId;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class AdTest {

  private static final MusicianId MUSICIAN_ID = new MusicianId(UUID.randomUUID());
  private static final BigDecimal PRICE = new BigDecimal("1999.99");
  private static final Currency EUR = Currency.getInstance("EUR");

  @Nested
  class Publish {

    @Test
    @DisplayName("When publishing an Ad with invalid Instrument, it throws an exception")
    void invalid_instrument() {
      assertThatException()
        .isThrownBy(() -> Ad.publish(MUSICIAN_ID, "", PRICE, EUR))
        .isInstanceOf(InvalidAdException.class)
        .withMessageContaining("Instrument cannot be blank");
    }

    @Test
    @DisplayName("When publishing an Ad, the status is Available")
    void success() throws InvalidAdException {
      Ad cut = Ad.publish(MUSICIAN_ID, "Fender American Professional 2", PRICE, EUR);

      assertThat(cut.getStatus()).isEqualTo(AdStatus.AVAILABLE);
    }

  }

  @Nested
  class Sell {

    @Test
    @DisplayName("When successfully selling an Ad, it is now SOLD_OUT")
    void success() throws InvalidAdStatusException, InvalidAdException {
      Ad cut = Ad.publish(MUSICIAN_ID, "Fender American Professional 2", PRICE, EUR);

      cut.sell();

      assertThat(cut.getStatus()).isEqualTo(AdStatus.SOLD_OUT);
    }

    @Test
    @DisplayName("When selling a non-available Ad, it throws an exception")
    void nonAvailableAd() throws InvalidAdStatusException, InvalidAdException {
      Ad cut = Ad.publish(MUSICIAN_ID, "Fender American Professional 2", PRICE, EUR);

      cut.sell();

      assertThatException()
        .isThrownBy(cut::sell)
        .isInstanceOf(InvalidAdStatusException.class)
        .withMessageContaining("Cannot sell a non-available Ad");
    }
  }
}
