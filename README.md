# M223 Punchclock

Folgende Schritte sind notwendig um die Applikation zu erstellen und zu starten: 
1. Stellen Sie sicher, dass OpenJDK 11 oder höher installiert und JAVA_HOME korrekt gesetzt ist.  
2. Installieren Sie (falls noch nicht vorhanden) Apache Maven 3.8.1 oder höher
3. Wechseln Sie auf der Kommandozeile in den Ordner dieser Applikation. 
`cd m223-punchclock-quarkus/`
4. Starten Sie die Applikation mit 
```shell script
./mvnw compile quarkus:dev
```

Folgende Dienste stehen während der Ausführung im Profil dev zur Verfügung:

Swagger API: http://localhost:8080/q/swagger-ui/

H2 Console: http://localhost:8080/h2/ 
Datenquelle: jdbc:h2:mem:punchclock
Benutzername: zli
Passwort: zli

#Beschreibung der Applikation
Diese Applikation kann Zeieinträge kreieren, zusammen mit anderen Entities die mit den Entries im Backend verbunden sind (JPA ORM-Mapping).
Am besten startet man die Applikation mit quarkus:dev

#Beispieldatenskript
Es gibt kein Skript welches Beispieldaten zur Verfügung stellt. Dies geht jeodch mit einem data.sql file im Resosurce folder.

#Kommentare
- Die Kardinalitäten im Fachklassendiagramm sind vertauscht, ausserdem sind die Kardinalitäen zwischen Entry und User komplett falsch (sollte 0..*, 1 sein). Wenn Ich das Projekt genau nach dem erstelle, wird
das Projekt einfach falsch und nicht funktionsfähig, also habe Ich das Projekt nach den richtigen Kardinalitäten geschireben, des Projektes willen.
  
- Da die HTTP-Methods in meiner Schnittstelle (EntryController) alle mit @Operation Annotation beschrieben sind, wäre es redundant dort Kommentare zu schreiben
