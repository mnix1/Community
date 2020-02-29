echo "Building front"
call npm run build
echo "Copying front to static resources"
del /F/Q/S ..\src\main\resources\static\*.* > NUL
rmdir /Q/S ..\src\main\resources\static
rmdir /Q/S ..\src\main\resources\templates
Xcopy /E /I build ..\src\main\resources\static
del /f ..\src\main\resources\static\index.html
mkdir ..\src\main\resources\templates
copy build\index.html ..\src\main\resources\templates\index.html
echo "Done"
