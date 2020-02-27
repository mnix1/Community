echo "Installing front"
del /F/Q/S build\*.* > NUL
rmdir /Q/S build
call npm install
call build.cmd
