rem @echo off
C:
CD "C:\Users\Luca-Desktop\Desktop\FALL-2020\SOEN341\Project B Documentation-20201115\Soen341ProjectB"
"C:\Program Files\Java\jdk-15\bin\javac.exe" TestOne.java
rem pause
"C:\Program Files\Java\jdk-15\bin\java.exe"  TestOne > TestOne.txt
type TestOne.txt
"C:\Program Files\Java\jdk-15\bin\java.exe"  aunit     TestOne.txt
pause
