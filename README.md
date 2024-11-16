## INOP - Biblioteka

#### Maven

Maven to narzędzie do tworzenia projektów. Wszystkie ustawienia znajdują się w pliku pom.xml (POM – Project Object Model) zawiera m.in.:
- nazwę projektu
- wykorzystywane zależności 
- dostępne pluginy

#### Stream

- Metoda *stream()* wywołana dla zbioru (lista, zbiór lub tablica) zwraca strumień (obiekt typu *Stream*) z elementami tego zbioru.
- Potok składa się ze strumienia utworzonego na podstawie źródła danych, dowolnej liczby metod pośrednich i metody końcowej. [Przykład](src/main/java/com/github/mako321/Repositories/CallSlipInMemoryRepository.java)
    - operacje pośrednie np. *skip, limit, filter, distinct, sorted, map, matToInt*
    - operacje końcowej np. *count, sum, average, max, min, forEach, findFirst, firstAny, anyMatch, allMatch, noneMatch, toArray*
- Strumienie wykonywane są dopiero po zainicjowaniu ostatniej metody końcowej.
- Strumienie są obiektami tymczasowymi. PO wykonaniu metody końcowej są usuwane.

#### Faker 

- JavaFaker to biblioteka do generowania losowych dancyh
- https://javastart.pl/baza-wiedzy/frameworki/javafaker

#### Junit

- *JUnit* jest główną platformą do testowania programów w Javie
- https://www.jetbrains.com/help/idea/testing.html#add-testing-libraries
- https://junit.org/junit5/docs/current/user-guide/#running-tests-ide-intellij-idea


