package com.betrybe.agrix.service;

import com.betrybe.agrix.model.entities.Farm;
import com.betrybe.agrix.model.repositories.FarmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Javadoc.
 */
@Service
public class FarmService {
  private final FarmRepository farmRepository;

  @Autowired
  public FarmService(FarmRepository farmRepository) {
    this.farmRepository = farmRepository;
  }

  public Farm insert(Farm farm) {
    return farmRepository.save(farm);
  }
}