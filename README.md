# JsonFetcher
JsonFetcher to prosta aplikacja, która służy do pobierania danych z publicznego API 
[jsonplaceholder](https://jsonplaceholder.typicode.com).

### Opis 
Prosta aplikacji CLI, utworzona z wykorzystaniem 
spring-shell. 

### Instalacja
W celu zbudowania projektu uruchom w terminalu:

```bash
./mvnw clean package
```


### Uruchomienie aplikacji

Po zbudowaniu aplikacji, można uruchomić ją w terminalu poleceniem:

```bash
java -jar target/json-fetcher-0.0.1-SNAPSHOT.jar <komenda>
```

### Użycie

Aplikacja na razie udostępnia jedną komendę
```
posts download
posts download --help
```

Pobiera dane z API i zapisuje je do plików json w określonym katalogu. 
Domyślnie zapisuje w katalogu bieżącym.

Opcje:
```
-d / --directory: Określa katalog do którego zostaną zapisane pliki
```

### Przykłady

```bash
# Print top-level help
java -jar target/json-fetcher-0.0.1-SNAPSHOT.jar help
```

```bash
# Print help for 'posts download'
java -jar target/json-fetcher-0.0.1-SNAPSHOT.jar posts download --help
```

```bash
# Download to current directory
java -jar target/json-fetcher-0.0.1-SNAPSHOT.jar posts download
```

```bash
# Download into specified directory
java -jar target/json-fetcher-0.0.1-SNAPSHOT.jar posts download --directory /home/tomek/posty
```

