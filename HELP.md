# Help

## Quick start

You can either run the application natively or with Docker/Podman.

Native (only works if a PostgreSQL database is running locally with port 5439 opened):

```sh
./gradlew bootRun
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

### Load testing with Artillery

A load test can be run by [Artillery](https://www.artillery.io/) using

```sh
artillery run client/artillery_test.yml
```

or when a report should be generated

```sh
artillery run --output report.json client/artillery_test.yml
```

A html report can be generated using the command

```sh
artillery report report.json
```

If you want to specify a different target, you can use the argument `--target` or `-t`:

```sh
artillery run client/artillery_test.yml -t $MODULITH_URL
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

## Publish Container Image

Container Registry: GitLab

Login (generate a [personal access token](https://docs.gitlab.com/user/profile/personal_access_tokens/) first):

```sh
docker login registry.gitlab.com
```

Push:

```sh
docker push registry.gitlab.com/envite-consulting/sustainable-software-architecture/spring-rest-clean-football-modulith:0.0.1-SNAPSHOT
```

Image is published to: <https://gitlab.com/envite-consulting/sustainable-software-architecture/spring-rest-clean-football-modulith/container_registry>

## Pre-built database image

DB migrations are taking a long time during startup. Therefore we use a pre-built container image that already contains the data.

See for more information: <https://gitlab.com/envite-consulting/sustainable-software-architecture/football-databases>
