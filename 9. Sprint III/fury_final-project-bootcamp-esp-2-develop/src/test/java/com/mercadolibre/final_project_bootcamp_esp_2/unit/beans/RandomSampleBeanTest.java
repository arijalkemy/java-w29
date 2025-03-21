package com.mercadolibre.final_project_bootcamp_esp_2.unit.beans;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.mercadolibre.final_project_bootcamp_esp_2.beans.RandomSampleBean;
import com.mercadolibre.final_project_bootcamp_esp_2.dto.SampleDTO;
import org.junit.jupiter.api.Test;

class RandomSampleBeanTest {

  @Test
  void randomPositiveTestOK() {
    RandomSampleBean randomSample = new RandomSampleBean();

    SampleDTO sample = randomSample.random();

    assertTrue(sample.getRandom() >= 0);
  }
}
