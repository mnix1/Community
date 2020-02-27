echo "Building front"
call npm run build
echo "Copying front to static resources"
del /F/Q/S ..\src\main\resources\static\*.* > NUL
rmdir /Q/S ..\src\main\resources\static
Xcopy /E /I build ..\src\main\resources\static
echo "Done"
