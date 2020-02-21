echo "Building front"
cd front
call npm run build
cd ..
echo "Copying front to static resources"
del /F/Q/S src\main\resources\static\*.* > NUL
rmdir /Q/S src\main\resources\static
Xcopy /E /I front\build src\main\resources\static
echo "Done"
