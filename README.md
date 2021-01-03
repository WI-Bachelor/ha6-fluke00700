# Hausaufgabe 6

Lesen Sie als Vorbereitung die Dokumentation zu Spring Shell: https://docs.spring.io/spring-shell/docs/2.0.0.RELEASE/reference/htmlsingle/

1.	Fügen Sie in der Datei `build.gradle` die Implementierungs-Abhängigkeit `spring-shell-starter` in der Version `2.0.0.RELEASE` hinzu. Lassen Sie `gradle build` laufen und führen Sie dann `java -jar ./build/libs/burger-shell-0.0.1-SNAPSHOT.jar` aus. Nutzen Sie das `help` Kommando, um zu sehen, welche Befehle es gibt.
2.	Fügen Sie in der Klasse `BurgerBotCommands` die Annotations `@ShellComponent`, `@ShellCommand` und `@ShellOption` hinzu und testen Sie wieder mit `gradle build` und `java -jar ...`, ob neue Befehle hinzugekommen sind.
3.	Implementieren Sie die Methode `order()` entsprechend dem weiter unten spezifizierten Verhalten, sodass die entsprechenden Tests grün werden. Nutzen Sie dafür Code aus der `ChatbotUI` Klasse aus den vorherigen Hausaufgaben. 
4.	Implementieren Sie die Methode `confirm()` ebenfalls und probieren Sie die Befehle im Shell-Programm aus.
5.	Erstellen Sie eine neue Klasse `BurgerBotPromptProvider` (in etwa wie hier beschrieben: https://docs.spring.io/spring-shell/docs/2.0.0.RELEASE/reference/htmlsingle/#_promptprovider) und nutzen Sie dann die Klassen `InputEvent` und `InputEventPublisher` um aus der `order()`-Methode Nachrichten an den `BurgerBotPromptProvider` zu senden, sodass der Prompt rot wird, wenn der Burgerbot etwas nicht verstanden hat und wieder grün, wenn doch. 

Pushen Sie Ihre Lösung auf GitHub UND demonstrieren Sie die Lösung in der Übung im Abgabezeitraum, die Sie im LSF belegt haben, indem Sie per Screenshare einmal `gradle build` und `java -jar ...` ausführen und dann zeigen, wie der Prompt je nach Eingabe die Farbe ändert.

# Anleitung 
...zur Benutzung des Burgerbot Shell-Programms (erwartetes Verhalten).

Nach dem Start der Anwendung kann eine Bestellung wie folgt aufgegeben werden:

```bash
BURGER-BOT:>order --text 'Ich hätte gernen einen Burger mit Burgerbrot, Rindfleisch und Tomate'
In Ordnung. Dein 1. Burger mit [Burgerbrot, Rindfleisch, Tomate als Gemuesebeilage] kostet 6.70 EUR.
Gib <confirm> ein, um die Bestellung abzuschliessen oder bestelle einen weiteren Burger mit <order -t '...'>
BURGER-BOT:>order -t 'Ich hätte gernen einen weiteren Burger mit Ciabatte, Falafel, Eisbergsalat und Ketchup'
In Ordnung. Dein 2. Burger mit [Falafel, Eisbergsalat als Salatbeilage, Ketchup als Sauce] kostet 4.15 EUR.
Gib <confirm> ein, um die Bestellung abzuschliessen oder bestelle einen weiteren Burger mit <order -t '...'>
BURGER-BOT:>order 'Ich hätte gernen noch einen Burger mit Burgerbrot und Rindfleisch, Rindfleisch, Rindfleisch. Yummy'
In Ordnung. Dein 3. Burger mit [Burgerbrot, Rindfleisch, Rindfleisch, Rindfleisch] kostet 15.00 EUR. 
Gib <confirm> ein, um die Bestellung abzuschliessen oder bestelle einen weiteren Burger mit <order -t '...'>
BURGER-BOT:>
```

Zum Abschluss der Bestellung ist das Kommando `confirm` zu verwenden:

```
BURGER-BOT:>confirm
Vielen Dank fuer deine Bestellung. Du hast 3 Burger bestellt. Die Gesamtsumme betraegt 25.85 EUR.
```

Das Programm kann mit `exit` beendet werden:

```bash
BURGER-BOT:>exit
```