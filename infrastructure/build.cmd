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
echo "Build infrastructure finished"

