cmake_minimum_required(VERSION 3.8)

#set(Kotlin_BIN_PATH /Users/benny/Github/kotlin-native/dist/bin)
#set(CMAKE_Kotlin_COMPILER /Users/benny/Github/kotlin-native/dist/bin/konanc)

set(CMAKE_MODULE_PATH ${CMAKE_CURRENT_LIST_DIR}/KotlinCMakeModule)
set(TENSORFLOW_HOME $ENV{HOME}/.konan/third-party/tensorflow)

project(TensorflowKonan Kotlin)

cinterop(
        NAME tensorflow
        TARGET macbook
        DEF_FILE src/main/cinterop/tensorflow.def
        COMPILER_OPTS "-I ${TENSORFLOW_HOME}/include"
)

konanc_executable(
        NAME HelloWorld
        TARGET macbook
        SOURCES src/main/kotlin
        LIBRARIES tensorflow
        LINKER_OPTS "-L${TENSORFLOW_HOME}/lib -ltensorflow"
)

