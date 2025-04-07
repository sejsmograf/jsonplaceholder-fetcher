# JsonFetcher
JsonFetcher to prosta aplikacja, która służy do pobierania danych z publicznego API 
[jsonplaceholder](https://jsonplaceholder.typicode.com).

## Spis treści

- [Opis](#opis)
- [Tryby działania](#tryby-działania)
- [Instalacja](#instalacja)
- [Uruchomienie](#uruchomienie)
	- [Interaktywny tryb REPL (zalecany)](#interaktywny-tryb-repl-zalecany)
	- [Pojedyncza komenda](#pojedyncza-komenda)
- [Użycie](#użycie)
- [Przykłady](#przykłady)

### Opis 
Prosta aplikacji CLI, utworzona z wykorzystaniem 
spring-shell. Oferuje 2 tryby:
- interaktywny REPL (zalecany)
- pojedyncza komenda

### Tryby działania
Aplikacja może działać w dwóch trybach:
- **Interaktywny REPL** - uruchamia się w trybie interaktywnym,
pozwalającym na korzystanie z autouzupełniania i podpowiedzi.
- **Pojedyncza komenda** - uruchamia się w trybie pojedynczej komendy,
pozwalającym na uruchomienie aplikacji z linii poleceń z jedną komendą.


### Instalacja
W celu zbudowania projektu uruchom w terminalu:

```bash
./mvnw clean package
```

### Uruchomienie

#### Interaktywny tryb REPL (zalecany)
Uruchomienie w trybie interaktywnym wymaga zmiany profilu 
konfiguracji springa.

```bash
SPRING_PROFILES_ACTIVE=interactive java -jar target/json-fetcher-0.0.1-SNAPSHOT.jar
```
Po uruchomieniu aplikacji zalecane jest użycie 'help' 
aby zapoznać się ze środowiskiem.

#### Pojedyncza komenda
Po zbudowaniu aplikacji, można uruchomić ją w celu wykonania jednej komendy.
Posiada to pewien narzut (uruchamianie kontekstu springa za każdym razem), dlatego zalecany jest tryb interaktywny.

```bash
java -jar target/json-fetcher-0.0.1-SNAPSHOT.jar <komenda>
```
np.
```bash
java -jar target/json-fetcher-0.0.1-SNAPSHOT.jar help
```

### Użycie

Aplikacja na razie udostępnia jedną komendę

##### Pobierz posty
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

# or interactive mode
shell:>help
```

```bash
# Print help for 'posts download'
java -jar target/json-fetcher-0.0.1-SNAPSHOT.jar posts download --help

# or interactive mode
shell:>posts download --help
```

```bash
# Download posts to current directory
java -jar target/json-fetcher-0.0.1-SNAPSHOT.jar posts download

# or interactive mode
shell:>posts download
```

```bash
# Download posts to specified directory
java -jar target/json-fetcher-0.0.1-SNAPSHOT.jar posts download --directory /home/tomek/posty

# or interactive mode
shell:>posts download --directory /home/tomek/posty
```

