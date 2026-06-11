package com.devlille.dddworkshop.marketplace.domain.models;

import com.devlille.dddworkshop.marketplace.domain.models.exceptions.InvalidAdException;
import com.devlille.dddworkshop.marketplace.domain.models.exceptions.InvalidAdStatusException;
import com.devlille.dddworkshop.marketplace.domain.models.exceptions.InvalidDiscountPercentException;
import com.devlille.dddworkshop.shared.domain.MusicianId;
import java.util.UUID;

public class Ad {

  private final AdId id;
  private final MusicianId owner;
  private final String instrument;
  private Price price;
  private AdStatus status;

  private Ad(MusicianId owner, String instrument, Price price) {
    this.id = new AdId(UUID.randomUUID());
    this.owner = owner;
    this.instrument = instrument;
    this.status = AdStatus.AVAILABLE;
    this.price = price;
  }

  public static Ad publish(MusicianId owner, String instrument, Price price)
      throws InvalidAdException {

    if (instrument.isBlank()) {
      throw new InvalidAdException("Instrument cannot be blank");
    }

    return new Ad(owner, instrument, price);
  }

  public void sell() throws InvalidAdStatusException {
    if (status != AdStatus.AVAILABLE) {
      throw new InvalidAdStatusException("Cannot sell a non-available Ad");
    }

    this.status = AdStatus.SOLD_OUT;
  }

  public void applyDiscount(float percentage) throws InvalidDiscountPercentException {
    price = price.discount(percentage);
  }

  public AdId getId() {
    return id;
  }

  public String getInstrument() {
    return instrument;
  }

  public Price getPrice() {
    return price;
  }

  public AdStatus getStatus() {
    return status;
  }

  public MusicianId getOwner() {
    return owner;
  }
}
