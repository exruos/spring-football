# Spring Microservice unter Einsatz einer Clean Architecture - Fußball Szenario

Diese Spring Boot Fußball Demo-Anwendung wurde auf Basis des Spring-Frameworks und einer Clean Architecture umgesetzt.

Variante ohne Clean Architecture: <https://gitlab.com/envite-consulting/sustainable-software-architecture/spring-rest-simple-football-service>

## Informationen zum Setup

Die Applikation stellt 2 HTTP API-Endpunkte sowie 2 gRPC API-Endpunkte bereit.

REST-Endpunkte:

- `/players/{id}`: get player by id
- `/players/record/{id}`: get player records by id (statistical player information on a yearly basis)

gRPC-Endpunkte:

- `Player.GetPlayerById`
- `Player.GetPlayerRecordById`

Für die Erfassung der Energieeffizienz wird das [Green Metrics Tool](https://github.com/green-coding-solutions/green-metrics-tool) (GMT) eingesetzt.
Hierfür wird ein Lastszenario auf einer Maschine im [Measurement Cluster von Green Coding Solutions](https://docs.green-coding.io/docs/measuring/measurement-cluster/) ausgeführt.
Wie eine Ausführung mit GMT möglich ist, wird unten im Abschnitt [Energiemessung mit dem Green Metrics Tool](#energiemessung-mit-dem-green-metrics-tool) erklärt.

[Das Paketo Buildpack for Health Checker](https://github.com/paketo-buildpacks/health-checker) wird genutzt, um den Health-Status der Applikation zu überwachen.
Für die Messung mit GMT ist das wichtig, damit GMT weiß, ab wann die Anwendung mit dem Start fertig ist und der eigentliche Workflow beginnen kann.

## Nutzung

### Lokale Ausführung

Lokal kann die Anwendung am Einfachsten mit Docker Compose oder Podman Compose ausgeführt werden:

- Docker:
  
  ```sh
  docker compose -f docker/compose.yml up
  ```

- Podman:
  
  ```sh
  podman-compose -f docker/compose.yml up
  ```

### HTTP-Anfragen

Einzelne HTTP-Anfragen können z. B. mit [curl](https://curl.se/) bzw. [grpcurl](https://github.com/fullstorydev/grpcurl) ausgeführt werden:

```sh
# Get specific player (REST)
curl localhost:8088/players/1

# Get players record for specific player (REST)
curl localhost:8088/players/record/1

#Get specific player (grpc)
grpcurl -d '{"id":1}' -plaintext localhost:8088 Player.GetPlayerById

#Get player record for specific player (grpc)
grpcurl -d '{"id":1}' -plaintext localhost:8088 Player.GetPlayerRecordById
```

Um die Ressourceneffizienz besser testen zu können, nutzen wir ein Lasttest-Tool.
Es sind Lastszenarien für [Artillery](https://www.artillery.io/) und [K6](https://k6.io/) vorbereitet, siehe [./client/](./client/).

Ausführung eines Lasttest-Szenarios mit Artillery:

```sh
artillery run client/artillery_test.yml
```

Ausführung eines Lasttest-Szenarios für mit K6 für REST:

```sh
k6 run client/k6_http_test.js
```

Ausführung eines Lasttest-Szenarios mit K6 für gRPC:

```sh
k6 run client/k6_grpc_test.js
```

## Energiemessung mit dem Green Metrics Tool

Die Energiemessung erfolgt für ein Lastszenario, welches folgende Eigenschaften aufweist:

- Open Model Workload Szenario:
  - fixe Anzahl an Anfragen -> bessere Vergleichbarkeit möglich
  - kein Warten auf eine Antwort (möglich, da nur einzelne, unabhängige Anfragen verschickt werden)
- 2 Phasen, Warm-up und Load
  - Grund: JVM benötigt Zeit sich "aufzuwärmen"
  - Umsetzung: Aufgeteilt in zwei getrennte Skripte, um jeweils einen eigenen Flow nutzen zu können -> Ergebnisse können individuell eingesehen werden

### GMT: Lokale Messung

GMT kann lokal ausgeführt werden, jedoch muss beachtet werden, dass dies in der Regel nicht für eine repräsentative Energiemessung sinnvoll ist.
Um eine repräsentative Messung durchzuführen, siehe [GMT: Messung auf dem Measurement Cluster](#gmt-messung-auf-dem-measurement-cluster)

Vorbereitungen für eine lokale Ausführung:

- git clone: `git@github.com:green-coding-solutions/green-metrics-tool.git`
- install dependencies: `./install_linux.sh` or `./install_mac.sh`
- run GMT containers: `docker compose -f docker/compose.yml up -d`
- activate python virtual environment: `source venv/bin/activate`
- execute runner command

Offizielle Installationsanleitung: <https://docs.green-coding.io/docs/installation/>

Ausführung einer Messung (simples Szenario mit curl wird als Beispiel genutzt):

```sh
python3 runner.py --name "Spring REST Football service Clean - REST Endpoints" --uri "https://gitlab.com/envite-consulting/sustainable-software-architecture/spring-rest-clean-football-service" --filename "usage_scenario-curl.yml" --skip-system-checks --dev-no-optimizations --skip-unsafe
```

Bemerkungen:

- Erklärungen zu allen Runner-Argumenten finden Sie in den [GMT Docs](https://docs.green-coding.io/docs/measuring/runner-switches/).
- `--skip-unsafe` ist nur erforderlich, weil die Compose-Datei ein Port Mapping enthält. Die Port-Zuordnung ist nicht erforderlich, da die gesamte Kommunikation direkt zwischen den Diensten stattfindet. Auf dem Measurement Cluster wird die Messung ebenfalls mit `--skip-unsafe` ausgeführt.

### GMT: Messung auf dem Measurement Cluster

Eine neue Messung kann [hier](https://metrics.green-coding.io/request.html) eingereicht werden.

Für den Vergleich der Energieeffizienz nutzen wir die Maschine "CO2 Benchmarking (DVFS OFF, TB OFF, HT OFF) - TX1330 M2" (Details gibt es [hier](https://docs.green-coding.io/docs/measuring/measurement-cluster/)).

Alternativ kann auch das Skript [./gmt/submit.sh](./gmt/submit.sh) genutzt werden (Variablen müssen angepasst werden).
