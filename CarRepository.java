package org.example.cars.repository;

import org.example.cars.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    @Modifying
    @Query(value = "drop table if exists cars", nativeQuery = true)
    void drop();

    @Modifying
    @Query(value = "create table if not exists cars ( id bigint primary key, brand varchar(255), model varchar(255), number varchar(255), " +
            "release_year int check release_year > 1900 and release_year <= extract(year from now()));", nativeQuery = true)
    void create();
}