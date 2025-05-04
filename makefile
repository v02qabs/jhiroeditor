install:
	javac com/hiro/editor/Main.java -d ./bin/.
	
all:
	make -C ./bin/
		
javaexec:
	make -C ./bin/.
