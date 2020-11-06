package com.gbv.dailyreport.burocratico;


import org.springframework.data.mongodb.repository.MongoRepository;

/*
     Interfaz que define los metodos que se utilizaran para el repositorio de mongo
     Mongo Repository se encarga del acceso a la base de datos
     Asi, el usuario no tiene que hacer las consultas manualmente
     Esta interfaz esta para definir las acciones con la base de datos y la inyeccion de dependencias
     Ademas, autoimplementa las funciones dependiendo del nombre que estas tengan y del dato que devuelvan.
     Esto es debido al analisis del nomnbre de los metodos de la interfaz
     Tambien, proporciona otros metodos como save() y update() que forman parte del CRUD

*/
public interface ReportRepository extends MongoRepository<Report,Integer> {
    Report findReportById(int id);
    void deleteReportById(int id);
}