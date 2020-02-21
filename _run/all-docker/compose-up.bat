docker-compose build
:: docker-compose up
docker stack deploy -c ../docker-compose-common.yml -c ../docker-compose-presenter.yml game-stack