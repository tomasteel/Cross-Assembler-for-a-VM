@echo Compiling Programs ...
@echo off
C:
CD "C:\Users\Luca-Desktop\Desktop\FALL-2020\SOEN341\Project B Documentation-20201115\Soen341ProjectB"
"C:\Program Files\Java\jdk-15\bin\javac.exe" TestOne.java
"C:\Program Files\Java\jdk-15\bin\javac.exe" TestTwo.java
@echo Running Programs ...
@if exist Tests.txt                                       del Tests.txt
"C:\Program Files\Java\jdk-15\bin\java.exe"  TestOne >  Tests.txt
"C:\Program Files\Java\jdk-15\bin\java.exe"  TestTwo >> Tests.txt
"C:\Program Files\Java\jdk-15\bin\java.exe"  TestOne >> Tests.txt
type Tests.txt
@echo on
@echo Checking test result...
"C:\Program Files\Java\jdk-15\bin\java.exe"  aunit Tests.txt
pause
