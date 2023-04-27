package org.example.cars.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.Check;

import javax.persistence.*;

@Entity(name = "cars")
@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String brand;
    String model;
    String number;

    @Column(name = "release_year")
    @Check(constraints = "release_year > 1900 and release_year <= extract(year from now())")
    int releaseYear;
}
