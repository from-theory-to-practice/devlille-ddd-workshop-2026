package com.devlille.dddworkshop.marketplace.domain.models;

import com.devlille.dddworkshop.marketplace.domain.models.exceptions.UnknownAdProposalException;
import com.devlille.dddworkshop.shared.domain.MusicianId;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Proposals {

  private List<Proposal> value;

  public Proposals(List<Proposal> proposals) {
    this.value = proposals;
  }

  public static Proposals empty(){
    return new Proposals(List.of());
  }

  public Proposals addProposal(Proposal proposal){
    Predicate<Proposal> isMusicianOtherProposal = (p) -> !p.getMusicianId().equals(proposal.getMusicianId());

    return new Proposals(this.value = Stream.concat(
      // Remove old musician proposals
      value.stream().filter(isMusicianOtherProposal),
      // Add new proposal
      Stream.of(proposal)
    ).toList());
  }

  public Proposal ofMusician(MusicianId musicianId) throws UnknownAdProposalException {
    return value.stream()
      .filter(proposal -> proposal.getMusicianId().equals(musicianId))
      .findFirst()
      .orElseThrow(()-> new UnknownAdProposalException("Musician doesn't have any proposal"));
  }

  public int size(){
    return value.size();
  }
}
