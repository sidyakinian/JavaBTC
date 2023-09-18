JAVAC=javac
JAVA=java
SOURCE_DIR=src
BUILD_DIR=build
LIBS_DIR=libs
LIBS=$(shell find $(LIBS_DIR) -name '*.jar' | tr '\n' ':')
MAIN_CLASS=src.main.Main

all: compile

compile:
	mkdir -p $(BUILD_DIR)/main
	mkdir -p $(BUILD_DIR)/test
	$(JAVAC) -cp "$(LIBS)" -d $(BUILD_DIR)/main $(SOURCE_DIR)/main/*.java
	$(JAVAC) -cp "$(BUILD_DIR)/main:$(LIBS)" -d $(BUILD_DIR)/test $(SOURCE_DIR)/test/*.java

run: compile
	$(JAVA) -cp "$(BUILD_DIR)/main:$(LIBS)" $(MAIN_CLASS)

test: compile
	$(JAVA) -cp "$(BUILD_DIR)/main:$(BUILD_DIR)/test:$(LIBS)" org.junit.platform.console.ConsoleLauncher --scan-classpath --class-path=$(BUILD_DIR)/test

clean:
	rm -rf $(BUILD_DIR)

.PHONY: all compile run test clean