package community.game.match.metadata.wisie;

import community.game.RandomHelper;

public enum WisieType {
    ALI,//Ali
    ANTON,//Mrówkacz
    BIZ_ON,//Żubrowar
    BEELLIE,//Żądłolot
    TEDDO,//Dźwiedzior
    BULLO,//Byku
    ATHLETE,//Pudziuś
    CAMELEOMAN,//Wielobłąd
    FRISKY,//Mruczka
    KIT_O,//Kituś
    KITTY,//Kicia
    SHYRIEK,//Piskacz
    GATOR,//Kroczek
    SMARTIE,//Bystruś
    CUDDLE,//Pulszek
    CUTIE,//Słodzik
    SCARY_GARY,//Pikełło
    KINK_KNOT,//Supełło
    CHUBBO,//Grubełło
    FOODIE,//Smakełło
    TOMEAGLE,//Orłuś
    BUGBER,//Trąbcia
    ELLIE,//Słoniu
    FOXY_ROXY,//Lisiczka
    BROWNOSIE,//Lizuś
    MISSFROGGIE,//Żabcia
    GIRALLA,//Rafcia
    STRONGIE,//Goruś
    PONY,//Rumo
    CHEERFUL,//Skoczka
    BRO,//Kolo
    LURK,//Pardzio
    LUX_MANE,//Bujnogrzyw
    SHORTIE,//Mały
    OCTOPUSH,//Ośmiornik
    OST_RICH,//Strusior
    OWLIE,//Sowcia
    BIGHEAD,//Mądruś
    PANDICE,//Pandziu
    SLOPPY,//Zgapka
    PENGPONG,//Pinguś
    LITTLEBEAR,//Misiaczek
    KITTER,//Kicek
    RACCO,//Szopuś
    WALKER,//Wędrek
    BITTERO,//Ząbek
    WOOLLY,//Wełnuś
    SNAKIEE,//Jaduś
    STORKIE,//Bociek
    SPEEDO,//Wiewcia
    PETIGER,//Zdzigrys
    TURK,//Induś
    SHELLO,//Skorupny
    WALRUS,//Morsu
    ROBO,//Robcio
    WOLFART;//Wilku

    public static WisieType random() {
        return RandomHelper.randomElement(values());
    }
}
