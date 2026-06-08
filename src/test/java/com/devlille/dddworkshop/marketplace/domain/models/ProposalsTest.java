package com.devlille.dddworkshop.marketplace.domain.models;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.devlille.dddworkshop.marketplace.domain.models.exceptions.UnknownAdProposalException;
import com.devlille.dddworkshop.shared.domain.MusicianId;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class ProposalsTest {

  private static final Currency EUR = Currency.getInstance("EUR");

  @Nested
  class Empty {

    @Test
    @DisplayName("An empty proposals have no size")
    void success() {
      Proposals cut = Proposals.empty();

      assertThat(cut.size()).isZero();
      assertThatThrownBy(() -> cut.ofMusician(new MusicianId(UUID.randomUUID())))
        .isInstanceOf(UnknownAdProposalException.class)
        .hasMessage("Musician doesn't have any proposal");
    }
  }

  @Nested
  class AddProposal {

    @Test
    @DisplayName("Adding a new proposal allow to find by musician")
    void add_new_proposal() throws Exception {
      MusicianId musicianId = new MusicianId(UUID.randomUUID());
      Proposals cut = Proposals.empty();
      Proposal proposal = Proposal.makeProposal(
        musicianId,
        new Price(BigDecimal.valueOf(120), EUR),
        new Price(BigDecimal.valueOf(150), EUR)
      );

      cut.addProposal(proposal);

      assertThat(cut.size()).isEqualTo(1);
      assertThat(cut.ofMusician(musicianId)).isEqualTo(proposal);
    }

    @Test
    @DisplayName("Adding a new proposal for a musician replace the old one")
    void replace_existing_proposal_for_same_musician() throws Exception {
      MusicianId musicianId = new MusicianId(UUID.randomUUID());
      MusicianId anotherMusicianId = new MusicianId(UUID.randomUUID());
      Proposals cut = Proposals.empty();
      Proposal firstProposal = Proposal.makeProposal(
        musicianId,
        new Price(BigDecimal.valueOf(120), EUR),
        new Price(BigDecimal.valueOf(150), EUR)
      );
      Proposal replacementProposal = Proposal.makeProposal(
        musicianId,
        new Price(BigDecimal.valueOf(130), EUR),
        new Price(BigDecimal.valueOf(150), EUR)
      );
      Proposal otherMusicianProposal = Proposal.makeProposal(
        anotherMusicianId,
        new Price(BigDecimal.valueOf(125), EUR),
        new Price(BigDecimal.valueOf(150), EUR)
      );

      cut.addProposal(firstProposal);
      cut.addProposal(otherMusicianProposal);
      cut.addProposal(replacementProposal);

      assertThat(cut.size()).isEqualTo(2);
      assertThat(cut.ofMusician(musicianId)).isEqualTo(replacementProposal);
      assertThat(cut.ofMusician(anotherMusicianId)).isEqualTo(otherMusicianProposal);
      assertThat(cut.ofMusician(musicianId).getDesiredPrice()).isEqualTo(replacementProposal.getDesiredPrice());
    }
  }
}


