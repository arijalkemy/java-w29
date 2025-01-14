package com.thiagoschreck.local.symptom_finder.model;

import java.util.List;

public record Person(int id, String name, String lastname, int age, List<Symptom> symptoms) {
}
