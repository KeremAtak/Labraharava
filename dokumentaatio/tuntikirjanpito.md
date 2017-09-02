### Tuntikirjanpito
Päivä | Tunnit | Kuvaus
--------------- | ----- | ------
30.07.2017 | 2,50h | Aiheen suunnittelu, repon ja dokumentaation luominen. Pitestien luominen epäonnistui.
30.07.2017 | 0,25h | Pitest-error korjattu lisäämällä toiminnallisuutta main-luokkaan.
01.08.2017 | 8,50h | Pelin oleellisin logiikka koodattu, ja se vaikuttaisi kaikinpiirtein toimivan moitteettomasti. Pelilauta luodaan, peli avaa oikeat ruudut ja numerot kertovat kuinka monta miinaa ympäröivät avattua nappia. Pelin luominen ja loppuminen toistaiseksi on puutteellista. Logiikka vaatii staattisuuden poistamista kun annan pelaajille mahdollisuuden säätää asetuksia. Koodi vaatii siistimistä. Lisäksi pelin ulkoasu on karu ja vaatii työstöä.
02.08.2017 | 4,00h | Peli nyt alkaa ja päättyy oikein. Peli päättyy välittömästi kun pelaaja astuu miinaan tai hän avaa kaikki ruudut missä ei ole miinoja, jolloin hänen täytyy aloittaa uusi peli. Lisäksi pelaaja näkee montako lippua hän on käyttänyt, ja hän voi asettaa niitä kentälle enintään sen verran mitä pelissä on miinoja.
05.08.2017 | 6,00h | Pelaaja voi nyt luoda haluamansa kokoisen pelikentän, koko on vähintään 2x2 ja enintään 20x20. Pelaaja voi myös päättää montako miinaa pelissä on, ja näitän on vähintään yksi ja enintään puolet pelikentän koosta (10x10 kentässä enintään 50 miinaa.) Pelin toiminnallisuutta myös korjattu, mutta peli ei toimi oikein jos pelikenttä ei ole neliö.
05.08.2017 | 2,50h | Alustavat testit luotu. Koodia siistitty hieman.
06.08.2017 | 0,5h | Pit-raportti ja checkstyle luotu. Checkstylen mukaan koodi on siistitty, Logiikka-luokka on kuitenkin liian pitkä.
06.08.2017 | 0,25h | Luokkakaavio luotu.
06.08.2017 | 0,25h | Pit-raportti ja checkstyle siirretty dokumentaatioon.
13.08.2017 | 1,75h | Uusia komponentteja luotu koodin selkeyden vuoksi.
13.08.2017 | 2,00h | Logiikkaan liittyviä testejä luotu.
13.08.2017 | 1,50h | Luokkakaavio päivitetty, Checkstyle ja Pit lisätty readme:n.
20.08.2017 | 4,00h | JavaDoc luotu. Yritin myös purkaa projektin purkkamaisuutta mutta jokin virhe koodissa teki siitä kelvottoman. Myös monia muita deadlinen tavoitteita jäi tällä viikolla suorittamatta.
26.08.2017 | 1,50h | Kun ruudukkoa painetaan ensimmäisen kerran niin miinat generoidaan niin että painettuun ruutuun ja sen ympärille ei generoidu miinoja. Pelikenttään siis avautuu iso alue ja peliä on mukavampi pelata.
26.08.2017 | 0,25h | Lippu ei enää häviä jos ruudussa ei ollut miinaa ja sen pitäisi muuten avautua.
27.08.2017 | 2,50h | Logiikkaa on hajautettu ja testejä luotu.
27.08.2017 | 4,00h | Mielestäni testit ovat nyt tarpeeksi kattavia. Loin Ruudukkologiikka-metodin minkä pitäisi käsitellä ruudukon logiikka mutta en saanut sitä heti toimimaan, joten logiikka toimii edelleen Ruudukko-metodissa. Pit, Javadoc ja Checkstyle päivitetty ohjeiden mukaan.
27.08.2017 | 1,00h | Turhia yhteyksiä poistettu luokkien väliltä. Luokkakaavio päivitetty. Pit ja Checkstyle päivitetty uudestaan.
02.09.2017 | 1,00h | Ruudukkologiikka toimii, logiikkaa ei enää ole Ruudukko-metodissa. Testejä siirretty eri luokkiin, Pit-raportissa näytetään vain logiikka.
02.09.2017 | 0,75h | Tarkasteltuani koodia löysin syyn miksi ei-neliöruudukot eivät toimineet. Bugi korjattu.
