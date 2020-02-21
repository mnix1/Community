echo "Performing a clean Maven build"
call mvnw.cmd clean package -DskipTests=true
echo "Setting the default builder for pack"
pack set-default-builder cloudfoundry/cnb:bionic
echo "Packing the Registry"
cd registry
pack build mnix-game-registry --env "BP_JAVA_VERSION=13.*"
cd ..
echo "Packing the Gateway"
cd gateway
pack build mnix-game-gateway --env "BP_JAVA_VERSION=13.*"
cd ..
echo "Packing the Presenter"
cd presenter
pack build mnix-game-presenter --env "BP_JAVA_VERSION=13.*"
cd ..
echo "Packing the Stats"
cd stats
pack build mnix-game-stats --env "BP_JAVA_VERSION=13.*"
cd ..
echo "Packing the Simple"
cd simple
pack build mnix-game-simple --env "BP_JAVA_VERSION=13.*"
cd ..
echo "Build finished"

