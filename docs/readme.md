# Byznys Model pro Databázi Firem s Ověřením IČO

## 1. Vize

Cílem je vytvořit aplikaci, která umožňuje uživatelům zadávat IČO firmy a získávat aktuální informace o této firmě prostřednictvím REST API. Uživatel bude mít možnost uložit vybrané informace o firmě do vlastní databáze pro pozdější použití. Tato služba je zaměřena na podnikatele, státní instituce a další organizace, které potřebují spolehlivá a aktuální data o firmách.

## 2. Entity

- **Company**: Hlavní entita obsahující základní informace o firmě.
- **Audit Log**: Záznamy změn provedených v databázi (vytvoření, aktualizace, smazání).

## 3. Datový Model

Databáze bude vytvořena v PostgreSQL a bude obsahovat následující tabulky:

### 3.1. Company

- id (serial, primární klíč)
- ico (varchar(8), unikátní, not null)
- name (varchar(255), not null)
- adress (text, not null)
- created (timestamp, default now())
- updated (timestamp, default now())

### 3.2. Audit Log

- id (serial, primary key)
- action (varchar(50))
- company_id (integer, foreign key on Company)
- timestamp (timestamp, default now())

## 4. Endpoints (API)

### 4.1. - POST /company

Tělo requestu:

```json
{
  "ico": "23469247",
  "name": "Super Firma s.r.o.",
  "adress": "Praha - Nové Město, Česko"
}
```

HTTP status 201 CREATED

### 4.2. - GET /company/{ico}

Získá firmu z databáze podle ICO.

Path proměnná - ico (varchar(8))

Odpověď:

```json
{
  "id": 2344776445375356,
  "ico": "23469247",
  "name": "Super Firma s.r.o.",
  "adress": "Praha - Nové Město, Česko",
  "created": "2024-05-21 09:48:33",
  "updated": "2024-05-24 23:12:56"
}
```

HTTP status 200 OK
HTTP status 404 NOT FOUND

### 4.3. - POST /company/searchByName

Vyhledá firmu podle jejího názvu

Tělo requestu:

```json
{
  "name": "Super"
}
```

Odpověď:

```json
[
  {
    "id": 2344776445375356,
    "ico": "23469247",
    "name": "Super Firma s.r.o.",
    "adress": "Praha - Nové Město, Česko",
    "created": "2024-05-21 09:48:33",
    "updated": "2024-05-24 23:12:56"
  }
]
```

HTTP status 200 OK
HTTP status 404 NOT FOUND

### 4.4. - DELETE /company/{ico}

Smaže firmu z databáze podle ICO.

Path proměnná - ico (varchar(8))

Odpověď:

```json
{
  "id": 2344776445375356,
  "ico": "23469247",
  "name": "Super Firma s.r.o.",
  "adress": "Praha - Nové Město, Česko",
  "created": "2024-05-21 09:48:33",
  "updated": "2024-05-24 23:12:56"
}
```

HTTP status 200 OK
HTTP status 404 NOT FOUND

### 4.5. - PUT /company/{ico}

Edituje firmu vstupními daty podle ICO.

Path proměnná - ico (varchar(8))

Tělo requestu:

```json
{
  "id": 2344776445375356,
  "ico": "23469247",
  "name": "Ne Tak Super Firma s.r.o.",
  "adress": "Praha - Nové Město, Česko"
}
```

Odpověď:

```json
{
  "id": 2344776445375356,
  "ico": "23469247",
  "name": "Ne Tak Super Firma s.r.o.",
  "adress": "Praha - Nové Město, Česko",
  "created": "2024-05-21 09:48:33",
  "updated": "2024-05-26 15:34:21"
}
```

HTTP status 200 OK
HTTP status 404 NOT FOUND

### 4.6. - EXTERNÍ - GET /ekonomicke-subjekty-vr/{ico} - (ARES API)

- API URL [https://ares.gov.cz/ekonomicke-subjekty-v-be/rest/ekonomicke-subjekty-vr/](https://ares.gov.cz/ekonomicke-subjekty-v-be/rest/ekonomicke-subjekty-vr/25194798)
- Lze otestovat za pomocí curl:

```c
curl -X 'GET' \
  'https://ares.gov.cz/ekonomicke-subjekty-v-be/rest/ekonomicke-subjekty-vr/25194798' \
  -H 'accept: application/json'
```

Zpátky se získává JSON obsahující veškerá data o firmě podle ICO.

## 5. Detailní Datový Model

```sql
CREATE TABLE Company (
id SERIAL PRIMARY KEY,
ico VARCHAR(8) UNIQUE NOT NULL,
name VARCHAR(255) NOT NULL,
adress TEXT NOT NULL,
created TIMESTAMP DEFAULT NOW(),
updated TIMESTAMP DEFAULT NOW()
);

CREATE TABLE AuditLog (
id SERIAL PRIMARY KEY,
action VARCHAR(50),
company_id INTEGER REFERENCES Firma(id),
timestamp TIMESTAMP DEFAULT NOW()
);
```

## 6. Implementační Detaily

- **Logging a monitorování**: Implementace audit logů pro sledování změn v databázi

## 7. Technologie

- **Backend**: JAVA spring
- **Build tool**: Maven
- **Databáze**: PostgreSQL
- **API call tool**: Insomnia
