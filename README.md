# Gaming Cafe Manager

A JavaFX desktop application for managing a gaming cafe - clients, staff, and workstations (desktop PCs, consoles, VR setups).

Built with Java, JavaFX, and PostgreSQL using an MVC + Repository architecture. Dark-themed UI powered by [AtlantaFX](https://github.com/mkpaz/atlantafx).

## Tech Stack

- Java 21
- JavaFX 21
- PostgreSQL
- Maven

## Prerequisites

- JDK 21+
- Maven
- PostgreSQL running locally

## Setup

**1. Clone the repository**

```bash
git clone https://github.com/MrGegaz/java-gamingcafe.git
cd java-gamingcafe
```

**2. Create the database**

Create a PostgreSQL database, then run the SQL scripts to set up the schema:

```bash
psql -U your_username -d your_database_name -f src/main/resources/db/users.sql
psql -U your_username -d your_database_name -f src/main/resources/db/workstations.sql
```

**3. Configure database connection**

Copy the template and fill in your credentials:

```bash
cp src/main/resources/database.properties.template src/main/resources/com/example/gamingcafe/database.properties
```

Edit `database.properties`:

```properties
db.url=jdbc:postgresql://localhost:5432/your_database_name
db.user=your_username
db.password=your_password
```

**4. Run the application**

```bash
mvn clean javafx:run
```
