# Help

## Creating the keystore for ssl enabled calls
```sh
keytool -genkeypair -alias envite -keyalg RSA -keysize 4096 -storetype PKCS12 -keystore envite.p12 -validity 3650
```

## Quick start

You can either run the application natively or with Docker/Podman.

Native (only works if a PostgreSQL database is running locally with port 5439 opened):

```sh
  ./gradlew bootRun --args='--spring.profiles.active=local'
```

Docker:

```sh
docker compose -f docker/compose.yml up
```

Podman:

```sh
podman-compose -f docker/compose.yml up
```

## Usage

### API requests using curl

Example API requests:

```sh
# Get player by id
curl localhost:8088/players/1

# Get player record by id
curl localhost:8088/players/record/1
```

### Load testing with k6

A load test can be run by [k6](https://k6.io//) using

```sh
k6 run -e TARGET_HOSTNAME=localhost -e TARGET_PORT=8088 ./k6_match_http_gmt_load.js
```

## Build

Build jar file:

```sh
./gradlew bootJar
```

Build container image:

```sh
./gradlew bootBuildImage
```

Build container image for ARM:

```sh
./gradlew bootBuildImage --imagePlatform=linux/arm64 --imageName=registry.gitlab.com/envite-consulting/sustainable-software-architecture/isaqb-green/spring-clean-football-service:0.0.1-SNAPSHOT-arm64
```

## Publish Container Image

Container Registry: GitLab

Login (generate a [personal access token](https://docs.gitlab.com/user/profile/personal_access_tokens/) first):

```sh
docker login registry.gitlab.com
```

Push:

```sh
docker push registry.gitlab.com/envite-consulting/sustainable-software-architecture/isaqb-green/spring-clean-football-service:0.0.1-SNAPSHOT
```

Image is published to: <https://gitlab.com/envite-consulting/sustainable-software-architecture/spring-clean-football-service/container_registry>

## Pre-built database image

DB migrations are taking a long time during startup. Therefore we use a pre-built container image that already contains the data.

See for more information: <https://gitlab.com/envite-consulting/sustainable-software-architecture/football-databases>
