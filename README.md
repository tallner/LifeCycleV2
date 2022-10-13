# LifeCycleV2 Kravspec  
## Godkänt kriterier  

### Första Activiten  
Login
- [x] Credentials Namn + Lösen. Hårdkodat Lösen ok  
- [x] Gå vidare till nästa Activity/fragment  
  

### Andra Activiten/fragment  
Formulär
- [x] 5 olika typer av data/ui componenter  
- [ ] Skicka/submita datan med button

### Meny  
Valfri typ  
- [x] Navigare alla Activities/fragment
- [x] Custom icon

## Väl godkänt kriterier  
Uppfyll 2 av 4 punkterna

- [x] Tredje Activiten/fragment:  visa upp nuvarande sparad data från den andra activityn  
- [x] Kotlin  
- [ ] Sparar de saker man har fyllt i om man skulle pausa. (hint:SavedInstanceState)  
- [ ] Spara data även när man stänger appen (hint: SharedPreferences)  


## Egna krav   
Login
- [ ] Spara lösenordet så att det inte försvinner när Activity ändras  
- [ ] Skapa en user class som hanterar datan man fyller i  
- [ ] Lägg in olika users så att man får deras data när man loggar in med rätt credentials (ArrayList OK)
