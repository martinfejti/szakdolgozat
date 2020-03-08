Testing Operator

Az elkészülendő program egy tesztelés nyilvántartó alkalmazás, mely nagyban megkönnyítheti a különbőző programok tesztelését. Átláthatóbbá teszi a folyamatot, lehetőséget biztosít a módosításra és könnyen létrehozhatunk vagy törölhetünk teszteseteket is. 

Működés szempontjából az alkalmazás legkisebb egysége a 'step', azaz egy tesztlépés. Ez egy egyszerűbb feladatot jelöl, mint például töltsünk ki egy input mezőt. Egy lépésnek van leírása (mit kell tennie a tesztelőnek), várható eredménye (minek kell történnie a leírásban végrehajtott utasítás után), sorszáma, megjegyzése, valamint státusza is (sikeres, hiba történt, nem működik tökéletesen).

Az összetartozó lépéseket egy 'case'-be, azaz tesztesetbe rendezhetjük. Ez már egy összetettebb lépés, mint például egy bejelentkezés menete. Ebben az esetben a case a bejelentkezés, a hozzá tartozó lépések pedig az ehhez szükséges apró lépések sorozata (input mezők helyes kitöltése, bejelentkezés gomb megnyomása). Egy tesztesetnek van neve, leírása és a hozzá tartozó lépések.

Az összetartozó lépéseket egy 'component'-be rendezhetjük. Ez az egység egy projekt nagyobb egységét reprezentálja. Egy ilyen komponensnek szintén van neve és leírása, valamint megadható, hogy melyik tesztelő hajtotta végre a tesztelést, és, hogy az alkalmazás melyik verzióját tesztelte. 

Az utolsó és egyben legnagyobb egység a 'structure', mely gyakorlatilag egy teljes projektet jelent. Van leírása, neve, a hozzá tartozó komponensek listája, verziószáma.

Amint összeáll egy nagyobb egység, lehetőség van egy tesztelés 'lefuttatására'. Ilyenkor egy új oldalon megjelennek a lépések és a tesztelőnek kell kitöltenie a státusz és megjegyzés mezőket a természetesen a teszt eredményétől függően. Ha ez megvan, a teszt eredménye lementődik az adatbázisban. 

Ha módosítani szeretnénk a létrehozott egységeken, azt értelemszerűen megtehetjük. Kiemelendő, hogy ha a lépéseket szeretnénk módosítani, akkor ahhoz az azt tartalmazó tesztesetet kell módosítani. Pontosabban azon belül kell végrehajtani a módosításokat. Erre azért van szükség, mert ha esetleg törölni szeretnénk egy lépést, vagy megváltoztatni a sorrendjüket, akkor ahhoz egyszerre több lépést kell kezelni, és ezt célszerűbb egy magasabb szinten végrehajtani. 

Opcionális lehetőséggént belekerülhet egy import-export mechanizmus, amely egy már meglévő excel dokumentumban lévő tesztelés eredményét importálja az adatbázisba, illetve egy kiválasztott 'structure', vagy 'component'-ből is generálható egy hasonló dokumentum. 

Egy másik opcionális lehetőség lehet még egy bejelentkeztető felület létrehozása (regisztrációval együtt). Ebben az esetben az alkalmazás használata során automatikusan kitöltődnének az olyan mezők, amik a tesztelő személlyel kapcsolatosak. 
