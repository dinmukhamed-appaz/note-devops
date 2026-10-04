# note-devops

A simple REST note service built with Spring Boot. Notes are stored in memory, so no database is required.

## What it does

* `GET /` — check that the service is running
* `GET /healthz` — health check, returns `OK`
* `GET /notes` — get a list of notes
* `POST /create` — create a note (`{"title":"...","content":"..."}`)
* `DELETE /delete/{id}` — delete a note by index

## How to run

```bash
scripts/run.sh
```

## How to test

```bash
scripts/test.sh
```

The script prints a line like `TESTS: 5/5` at the end.

## Port

The service listens on the port from the `PORT` environment variable. The default is `8080`.

```bash
PORT=5123 scripts/run.sh
```