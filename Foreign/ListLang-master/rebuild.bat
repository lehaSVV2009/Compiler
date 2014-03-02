@ECHO OFF

SET ANTLR_JAR_FILE=C:\antlr\antlr-3.1.3.jar
SET JDK_HOME=c:\Program Files\Java\jdk1.7.0_07\bin\

rmdir /s /q build
mkdir build\adds build\examples build\llcompiler build\tmp

ECHO rebuild: antlr grammar
java -jar %ANTLR_JAR_FILE% -fo src\llcompiler -make src\ListLang.g
java -jar %ANTLR_JAR_FILE% -fo src\llcompiler -make src\ListLangWalker.g

ECHO rebuild: java List
CALL "%JDK_HOME%javac.exe" -d build\adds src\List.java

ECHO rebuild: make llcompiler
copy jasmin.jar build\
copy src\listlang.py build\
copy src\readme.txt build\
xcopy src\adds build\adds\ /e /y
IF ERRORLEVEL 1 GOTO EXIT
for /R src\llcompiler %%f in (*.py) do copy "%%f" build\llcompiler\

ECHO rebuild: copy examples
for /R examples %%f in (*.ll) do copy "%%f" build\examples\

:EXIT