package com.devlille.dddworkshop.marketplace.domain;

import com.devlille.dddworkshop.marketplace.domain.models.Ad;
import com.devlille.dddworkshop.shared.domain.MusicianId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AdRepository {

  void save(Ad ad);

  Optional<Ad> findById(UUID id);

  List<Ad> findByMusicianId(MusicianId musicianId);

}
