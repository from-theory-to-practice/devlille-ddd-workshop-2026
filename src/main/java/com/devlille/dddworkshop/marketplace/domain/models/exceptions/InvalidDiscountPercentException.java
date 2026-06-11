package com.devlille.dddworkshop.marketplace.domain.models.exceptions;

public class InvalidDiscountPercentException extends Exception {

  public InvalidDiscountPercentException(String message) {
    super(message);
  }
}
