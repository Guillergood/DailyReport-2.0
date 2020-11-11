SHELL := /bin/bash
# Instala prerrequisitos
all: install package

install:
	sudo apt update
	sudo apt install maven
	sudo apt install default-jdk
	sudo apt install -y mongodb

#Instala las dependencias y genera los jar
compile: install
	cd ./src/Animal && mvn clean compile
	cd ./src/Burocratico && mvn clean compile
	cd ./src/Cuidador && mvn clean compile
	cd ./src/API && mvn clean compile

# Prueba los componentes del proyecto
test: install compile
	cd ./src/Animal && mvn test
	cd ./src/Burocratico && mvn test
	cd ./src/Cuidador && mvn test
	cd ./src/API && mvn test

#Instala las dependencias y genera los jar, y además ejecuta los test
package: install
	cd ./src/Animal && mvn clean package
	cd ./src/Burocratico && mvn clean package
	cd ./src/Cuidador && mvn clean package
	cd ./src/API && mvn clean package



