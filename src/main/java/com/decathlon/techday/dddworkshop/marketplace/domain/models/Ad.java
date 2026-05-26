package com.decathlon.techday.dddworkshop.marketplace.domain.models;

import com.decathlon.techday.dddworkshop.marketplace.domain.models.exceptions.InvalidAdException;
import com.decathlon.techday.dddworkshop.marketplace.domain.models.exceptions.InvalidAdStatusException;
import com.decathlon.techday.dddworkshop.shared.domain.MusicianId;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.UUID;

public class Ad {

  private final AdId id;
  private final MusicianId musicianId;
  private final String instrument;
  private final BigDecimal price;
  private final Currency currency;
  private AdStatus status;

  private Ad(MusicianId musicianId, String instrument, BigDecimal price, Currency currency) {
    this.id = new AdId(UUID.randomUUID());
    this.musicianId = musicianId;
    this.instrument = instrument;
    this.price = price;
    this.currency = currency;
    this.status = AdStatus.AVAILABLE;
  }

  public static Ad publish(MusicianId musicianId, String instrument, BigDecimal price, Currency currency)
    throws InvalidAdException {

    if (instrument.isBlank()) {
      throw new InvalidAdException("Instrument cannot be blank");
    }

    return new Ad(musicianId, instrument, price, currency);
  }

  public void sell() throws InvalidAdStatusException {
    if (status != AdStatus.AVAILABLE) {
      throw new InvalidAdStatusException("Cannot sell a non-available Ad");
    }

    this.status = AdStatus.SOLD_OUT;
  }

  public AdId getId() {
    return id;
  }

  public String getInstrument() {
    return instrument;
  }

  public AdStatus getStatus() {
    return status;
  }

  public MusicianId getMusicianId() {
    return musicianId;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public Currency getCurrency() {
    return currency;
  }
}
