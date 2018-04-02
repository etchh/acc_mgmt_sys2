@echo off
:start
cls
setlocal enableDelayedExpansion

cd C:\Users\ahmed.hisham\git\account-management-service\target
for /f "delims=" %%F in ('dir /b /s "C:\Users\ahmed.hisham\git\account-management-service\target\*.jar" 2^>nul') do set JarName=%%F
call java -jar %JarName%