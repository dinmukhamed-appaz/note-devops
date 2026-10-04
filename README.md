A simple REST note service built with Spring Boot. Notes are stored in memory, so no database is required.

## What it does

* `GET /api/notes/get` — get a list of notes
* `POST /api/notes/create` — create a note (`{"title":"...","content":"..."}`)
* `DELETE /api/notes/delete/{id}` — delete a note by index

## How to run

```bash
scripts/run.sh
```

## How to test

```bash
scripts/test.sh
```
