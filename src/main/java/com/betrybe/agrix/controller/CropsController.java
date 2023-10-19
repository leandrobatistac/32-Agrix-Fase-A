package com.betrybe.agrix.controller;

import com.betrybe.agrix.dto.CropDto;
import com.betrybe.agrix.model.entities.Crop;
import com.betrybe.agrix.service.CropService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Javadoc.
 */
@RestController
@RequestMapping("/crops")
public class CropsController {

  public final CropService cropService;

  @Autowired
  public CropsController(CropService cropsService) {
    this.cropService = cropsService;
  }

  /**
   * Javadoc.
   */
  @GetMapping()
  public ResponseEntity<?> findAll() {
    List<Crop> allCrops = cropService.findAll();
    return ResponseEntity.status(HttpStatus.OK).body(allCrops.stream()
            .map(crop -> new CropDto(
                    crop.getId(),
                    crop.getName(),
                    crop.getPlantedArea(),
                    crop.getFarm().getId())));
  }
}