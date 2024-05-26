# Byznys Model pro Databázi Firem s Ověřením IČO

## 1. Vize

Cílem je vytvořit aplikaci, která umožňuje uživatelům zadávat IČO firmy a získávat aktuální informace o této firmě prostřednictvím REST API. Uživatel bude mít možnost uložit vybrané informace o firmě do vlastní databáze pro pozdější použití. Tato služba je zaměřena na podnikatele, státní instituce a další organizace, které potřebují spolehlivá a aktuální data o firmách.

## 2. Entity

- **Company**: Hlavní entita obsahující základní informace o firmě.
- **Audit Log**: Záznamy změn provedených v databázi (vytvoření, aktualizace, smazání).

## 3. Datový Model

Databáze bude vytvořena v PostgreSQL a bude obsahovat následující tabulky:

### 1. Company

- id (serial, primární klíč)
- ico (varchar(8), unikátní, not null)
- název (varchar(255), not null)
- adresa (text, not null)
- vytvořeno (timestamp, default now())
- aktualizováno (timestamp, default now())

### 3. Audit Log

- id (serial, primární klíč)
- akce (varchar(50))
- firma_id (integer, foreign key na Firma)
- timestamp (timestamp, default now())

## 4. Endpoints (API)

## 5. Detailní Datový Model

```sql
CREATE TABLE Company (
id SERIAL PRIMARY KEY,
ico VARCHAR(8) UNIQUE NOT NULL,
název VARCHAR(255) NOT NULL,
adresa TEXT NOT NULL,
vytvořeno TIMESTAMP DEFAULT NOW(),
aktualizováno TIMESTAMP DEFAULT NOW()
);

CREATE TABLE AuditLog (
id SERIAL PRIMARY KEY,
akce VARCHAR(50),
firma_id INTEGER REFERENCES Firma(id),
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
