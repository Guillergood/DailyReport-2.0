package com.gbv.dailyreport.repositories;


import com.gbv.dailyreport.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

/*
     Interfaz que define los metodos que se utilizaran para el repositorio de mongo
     JPA se encarga del acceso a los datos
     Asi, el usuario no tiene que hacer las consultas manualmente
     Esta interfaz esta para definir las acciones con los datos guardados en memoria y la inyeccion de dependencias
     Ademas, autoimplementa las funciones dependiendo del nombre que estas tengan y del dato que devuelvan.
     Esto es debido al analisis del nomnbre de los metodos de la interfaz
     Tambien, proporciona otros metodos como save() y update() que forman parte del CRUD

*/

public interface AnimalRepository extends JpaRepository<Animal,Integer> {
}
