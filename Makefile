SHELL := /bin/bash
# Instala prerrequisitos
all: install package

install:
	sudo apt update
	sudo apt install maven
	sudo apt install openjdk-11-jdk
	sudo apt install -y mongodb

#Instala las dependencias y genera los jar
compile:
	cd ./src/Animal && mvn clean compile
	cd ./src/Burocratico && mvn clean compile
	cd ./src/Cuidador && mvn clean compile
	cd ./src/API && mvn clean compile

# Prueba los componentes del proyecto
test:
	cd ./src/Animal && mvn test
	cd ./src/Burocratico && mvn test
	cd ./src/Cuidador && mvn test
	cd ./src/API && mvn test

#Instala las dependencias y genera los jar, y además ejecuta los test
package:
	cd ./src/Animal && mvn clean package
	cd ./src/Burocratico && mvn clean package
	cd ./src/Cuidador && mvn clean package
	cd ./src/API && mvn clean package



