JC = javac
JVM = java

all: compile

compile:
	$(JC) Main.java Componentes/*.java Entidades/*.java Mapa/*.java

run: compile
	$(JVM) Main

clean:
	rm -f *.class Componentes/*.class Entidades/*.class Mapa/*.class