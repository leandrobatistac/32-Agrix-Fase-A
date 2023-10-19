package com.betrybe.agrix.controller;

import com.betrybe.agrix.dto.FarmDto;
import com.betrybe.agrix.model.entities.Farm;
import com.betrybe.agrix.service.FarmService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Javadoc.
 */
@RestController
@RequestMapping(value = "/farms")
public class FarmController {
  private final FarmService farmService;

  @Autowired
  public FarmController(FarmService farmService) {
    this.farmService = farmService;
  }

  @PostMapping()
  public ResponseEntity<Farm> insertFarm(@RequestBody FarmDto farmDto) {
    Farm newFarm = farmService.insert(farmDto.convertToFarm());
    return ResponseEntity.status(HttpStatus.CREATED).body(newFarm);
  }

  @GetMapping()
  public ResponseEntity<Object> getAll() {
    List<Farm> allFarms = farmService.getAll();
    return ResponseEntity.status(HttpStatus.OK).body(allFarms);
  }

  /**
   * Javadoc.
   */
  @GetMapping("/{id}")
  public ResponseEntity<?> getById(@PathVariable Long id) {
    Optional<Farm> farmById = farmService.getById(id);

    if (farmById.isPresent()) {
      return ResponseEntity.ok().body(farmById);
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Fazenda não encontrada!");
  }
}
