<h2>Labraharava</h2>

<h3>Aihe:</h3> 
Toteutetaan peli mikä imitoi klassista miinaharavaa. Pelissä raivataan miinoja ja merkataan oletettuja miinoja lipuilla.
Lisätietoa oheisesta linkistä:
https://fi.wikipedia.org/wiki/Miinaharava_(peli)
<h4>Ominaisuudet:</h4>
Peliin luodaan graafinen käyttöliittymä Swingillä, ja pelikenttä koostuu napeista ja tekstikentistä raivatuilta alueilta. Pelaaja etsii miinoja, ja peli päättyy kun pelialue on raivattu (pelaaja voittaa) tai pelaaja astuu miinaan (pelaaja häviää.)
<h4>Toiminnallisuus</h4>
Pelaaja pelaa painamalla vasemmalla hiiren näppäimellä raivaamattomia nappeja millä hän raivaa aluetta tai astuu miinaan. Pelaaja voi merkitä hiiren oikealla näppäimellä napin lipulla jos hän epäilee sitä miinaksi.

<h3>Luokkakaavio</h3>

![Luokkakaavio](/dokumentaatio/luokkakaavio.jpg)

<h3>Rakennekuvaus</h3>

<b>Käynnistys</b> luo Alustus-luokan ja käynnistää tämän run()-metodin.

<b>Alustus</b> luo pelin paneelit ja kutsuu metodeja millä peli luodaan. Alustuksella luodaan aina uusi peli.

<b>Ylapaneeli</b> sisältää komponentit millä uusi peli luodaan.

<b>Pelipaneeli</b> on paneeli missä peliä pelataan. Se sisältää pelin ruudukon.

<b>Ruudukko</b>ssa sijaitsee pelin ruudut ja tiedon esimerkiksi pelin korkeudesta. Logiikat kommunikoivat pääsääntöisesti
tämän luokan kautta.

<b>Ruutu</b> on JButtonin alaluokka. Sillä on painettava nappi millä pelaaja pelaa peliä ja tieto siitä onko ruutu miina.

<b>Nappi</b> sisältää hiiren kuuntelijan. Luokka kommunikoi Logiikan kanssa.

<b>Logiikka</b> sisältää olennaisen pelin logiikan. Se säätelee esimerkiksi pelin kulkua.

<b>Numeropari</b> on Logiikan apumetodi.

<b>Ruudukkologiikka</b> on ruudukon toiminnallisuutta varten luotu logiikkametodi.

<b>Koordinaattilaskuri</b>n tehtävä on laskea koordinaatin ruudun ympäröivät ruudut.


<h3>Uuden pelin luonti</h3>

![luoPeli](/dokumentaatio/LuoPeli.jpg)

<h3>Ruudun painaminen vasemmalla hiiren näppäimellä</h3>

![painaVasenta](/dokumentaatio/painaVasenta.jpg)
