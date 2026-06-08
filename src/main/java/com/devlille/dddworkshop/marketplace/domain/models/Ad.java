package com.devlille.dddworkshop.marketplace.domain.models;

import com.devlille.dddworkshop.marketplace.domain.models.exceptions.InvalidAdException;
import com.devlille.dddworkshop.marketplace.domain.models.exceptions.InvalidAdStatusException;
import com.devlille.dddworkshop.marketplace.domain.models.exceptions.InvalidProposalStatusException;
import com.devlille.dddworkshop.marketplace.domain.models.exceptions.NonDecentProposalException;
import com.devlille.dddworkshop.marketplace.domain.models.exceptions.UnknownAdProposalException;
import com.devlille.dddworkshop.marketplace.domain.models.exceptions.InvalidDiscountPercentException;
import com.devlille.dddworkshop.shared.domain.MusicianId;
import java.util.UUID;

public class Ad {

  private final AdId id;
  private final MusicianId owner;
  private final String instrument;
  private Proposals proposals;
  private Price price;
  private AdStatus status;

  private Ad(MusicianId owner, String instrument, Price price) {
    this.id = new AdId(UUID.randomUUID());
    this.owner = owner;
    this.instrument = instrument;
    this.status = AdStatus.AVAILABLE;
    this.price = price;
    this.proposals = Proposals.empty();
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

  /**
   * Ensure there is only one proposal per musician
   */
  public void makeProposal(MusicianId musicianId, Price desiredPrice)
    throws InvalidAdStatusException, NonDecentProposalException {
    if (status != AdStatus.AVAILABLE) {
      throw new InvalidAdStatusException("Cannot make a proposal for a non-available Ad");
    }

    Proposal newProposal = Proposal.makeProposal(musicianId, desiredPrice, price);
    this.proposals = proposals.addProposal(newProposal);
  }

  public void acceptMusicianProposal(MusicianId musicianId)
    throws InvalidAdStatusException, InvalidProposalStatusException, UnknownAdProposalException {
    if (status != AdStatus.AVAILABLE) {
      throw new InvalidAdStatusException("Cannot accept a proposal for a non-available Ad");
    }

    Proposal proposal = proposals.ofMusician(musicianId);

    proposal.accept();
    this.price = proposal.getDesiredPrice();

    this.sell();
  }

  public void rejectMusicianProposal(MusicianId musicianId)
    throws InvalidAdStatusException, InvalidProposalStatusException, UnknownAdProposalException {
    if (status != AdStatus.AVAILABLE) {
      throw new InvalidAdStatusException("Cannot reject a proposal for a non-available Ad");
    }

    proposals.ofMusician(musicianId).reject();
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

  public Proposals getProposals() {
    return proposals;
  }
}
