package com.devlille.dddworkshop.marketplace.domain.models.exceptions;

public class InvalidProposalStatusException extends Exception {

  public InvalidProposalStatusException(String message) {
    super(message);
  }
}
