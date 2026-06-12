package com.devlille.dddworkshop.marketplace.domain.models;

import com.devlille.dddworkshop.marketplace.domain.models.exceptions.InvalidDiscountPercentException;
import java.math.BigDecimal;
import java.util.Currency;

public record Price(BigDecimal amount, Currency currency) {

  public Price {
    if (amount.compareTo(BigDecimal.ZERO) < 0) {
      throw new IllegalArgumentException("Amount must be positive");
    }
  }

  public Price discount(float percentage) throws InvalidDiscountPercentException {
    if (percentage <= 0) {
      throw new InvalidDiscountPercentException("Discount percent must be greater than 0");
    }
    if (percentage > 100) {
      throw new InvalidDiscountPercentException("Discount percent must be lower than 100");
    }

    float discountedAmount = amount.floatValue() * (100 - percentage) / 100.0f;

    return new Price(new BigDecimal(discountedAmount), currency);
  }
}
