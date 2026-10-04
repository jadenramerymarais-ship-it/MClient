@echo off
setlocal
title MClient Settings
set "CONFIG=%APPDATA%\.minecraft\config\mclient.properties"

if not exist "%APPDATA%\.minecraft\config" mkdir "%APPDATA%\.minecraft\config"

:menu
cls
echo ==============================
echo          MClient Settings
echo ==============================
echo.
echo 1. Reimagined Intro ON
echo 2. Reimagined Intro OFF
echo 3. Quit
echo.
choice /c 123 /n /m "Choose: "

if errorlevel 3 exit /b
if errorlevel 2 goto off
if errorlevel 1 goto on

:on
> "%CONFIG%" echo # MClient settings
>>"%CONFIG%" echo reimagined_intro=true
echo.
echo Reimagined Intro: ON
pause
goto menu

:off
> "%CONFIG%" echo # MClient settings
>>"%CONFIG%" echo reimagined_intro=false
echo.
echo Reimagined Intro: OFF
pause
goto menu
