SHELL := /bin/bash
# Instala prerrequisitos
all: install

install:
	sudo apt update
	sudo apt install maven
	sudo apt install default-jdk



