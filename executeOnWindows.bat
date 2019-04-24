@ECHO OFF
rem set CLASSPATH=.
rem compilando e executando o código
javac FoodUtilities.java
javac Program.java
java Program

rem  removendo o compilado java
rd FoodUtilities.class
rd Program.class

pause