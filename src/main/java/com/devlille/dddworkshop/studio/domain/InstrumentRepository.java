package com.devlille.dddworkshop.studio.domain;

import com.devlille.dddworkshop.shared.domain.MusicianId;
import java.util.List;

public interface InstrumentRepository {

  List<InstrumentDbEntity> getByMusician(MusicianId musicianId);

  void save(InstrumentDbEntity instrument);

}
