package com.mercadolibre.final_project_bootcamp_esp_32.unit.beans;

import com.mercadolibre.final_project_bootcamp_esp_32.beans.RandomSampleBean;
import com.mercadolibre.final_project_bootcamp_esp_32.dtos.SampleDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class RandomSampleBeanTest {

  @Test
  void randomPositiveTestOK() {
    RandomSampleBean randomSample = new RandomSampleBean();

    SampleDTO sample = randomSample.random();

    assertTrue(sample.getRandom() >= 0);
  }
}
