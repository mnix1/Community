package community.game.match.metadata.wisie;

import community.game.RandomHelper;
import community.game.match.metadata.wisie.interaction.controller.DefaultInteractionController;
import community.game.match.metadata.wisie.interaction.controller.InteractionController;

public enum WisieType {
    ALI(new DefaultInteractionController()),//Ali
    ANTON(new DefaultInteractionController()),//Mrówkacz
    BIZ_ON(new DefaultInteractionController()),//Żubrowar
    BEELLIE(new DefaultInteractionController()),//Żądłolot
    TEDDO(new DefaultInteractionController()),//Dźwiedzior
    BULLO(new DefaultInteractionController()),//Byku
    ATHLETE(new DefaultInteractionController()),//Pudziuś
    CAMELEOMAN(new DefaultInteractionController()),//Wielobłąd
    FRISKY(new DefaultInteractionController()),//Mruczka
    KIT_O(new DefaultInteractionController()),//Kituś
    KITTY(new DefaultInteractionController()),//Kicia
    SHYRIEK(new DefaultInteractionController()),//Piskacz
    GATOR(new DefaultInteractionController()),//Kroczek
    SMARTIE(new DefaultInteractionController()),//Bystruś
    CUDDLE(new DefaultInteractionController()),//Pulszek
    CUTIE(new DefaultInteractionController()),//Słodzik
    SCARY_GARY(new DefaultInteractionController()),//Pikełło
    KINK_KNOT(new DefaultInteractionController()),//Supełło
    CHUBBO(new DefaultInteractionController()),//Grubełło
    FOODIE(new DefaultInteractionController()),//Smakełło
    TOMEAGLE(new DefaultInteractionController()),//Orłuś
    BUGBER(new DefaultInteractionController()),//Trąbcia
    ELLIE(new DefaultInteractionController()),//Słoniu
    FOXY_ROXY(new DefaultInteractionController()),//Lisiczka
    BROWNOSIE(new DefaultInteractionController()),//Lizuś
    MISSFROGGIE(new DefaultInteractionController()),//Żabcia
    GIRALLA(new DefaultInteractionController()),//Rafcia
    STRONGIE(new DefaultInteractionController()),//Goruś
    PONY(new DefaultInteractionController()),//Rumo
    CHEERFUL(new DefaultInteractionController()),//Skoczka
    BRO(new DefaultInteractionController()),//Kolo
    LURK(new DefaultInteractionController()),//Pardzio
    LUX_MANE(new DefaultInteractionController()),//Bujnogrzyw
    SHORTIE(new DefaultInteractionController()),//Mały
    OCTOPUSH(new DefaultInteractionController()),//Ośmiornik
    OST_RICH(new DefaultInteractionController()),//Strusior
    OWLIE(new DefaultInteractionController()),//Sowcia
    BIGHEAD(new DefaultInteractionController()),//Mądruś
    PANDICE(new DefaultInteractionController()),//Pandziu
    SLOPPY(new DefaultInteractionController()),//Zgapka
    PENGPONG(new DefaultInteractionController()),//Pinguś
    LITTLEBEAR(new DefaultInteractionController()),//Misiaczek
    KITTER(new DefaultInteractionController()),//Kicek
    RACCO(new DefaultInteractionController()),//Szopuś
    WALKER(new DefaultInteractionController()),//Wędrek
    BITTERO(new DefaultInteractionController()),//Ząbek
    WOOLLY(new DefaultInteractionController()),//Wełnuś
    SNAKIEE(new DefaultInteractionController()),//Jaduś
    STORKIE(new DefaultInteractionController()),//Bociek
    SPEEDO(new DefaultInteractionController()),//Wiewcia
    PETIGER(new DefaultInteractionController()),//Zdzigrys
    TURK(new DefaultInteractionController()),//Induś
    SHELLO(new DefaultInteractionController()),//Skorupny
    WALRUS(new DefaultInteractionController()),//Morsu
    ROBO(new DefaultInteractionController()),//Robcio
    WOLFART(new DefaultInteractionController());//Wilku

    private final InteractionController interactionController;

    WisieType(InteractionController interactionController) {
        this.interactionController = interactionController;
    }

    public static WisieType random() {
        return RandomHelper.randomElement(values());
    }

    public InteractionController getInteractionController() {
        return interactionController;
    }
}
