echo "Performing a clean Maven build"
call mvnw.cmd clean package -DskipTests=true
echo "Setting the default builder for pack"
pack set-default-builder cloudfoundry/cnb:bionic
echo "Packing the Registry"
cd registry
pack build community-registry --env "BP_JAVA_VERSION=13.*"
cd ..
echo "Packing the Gateway"
cd gateway
call front\install-build.cmd
pack build community-gateway --env "BP_JAVA_VERSION=13.*"
cd ..
echo "Packing the Presenter"
cd presenter
pack build community-presenter --env "BP_JAVA_VERSION=13.*"
cd ..
echo "Packing the Stats"
cd stats
pack build community-stats --env "BP_JAVA_VERSION=13.*"
cd ..
echo "Packing the Simple"
cd simple
pack build community-simple --env "BP_JAVA_VERSION=13.*"
cd ..
echo "Build finished"

