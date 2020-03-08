package community.game.match.metadata.wisie;

import community.game.RandomHelper;
import community.game.match.metadata.wisie.interaction.controller.DefaultInteractionController;
import community.game.match.metadata.wisie.interaction.controller.InteractionController;

public enum WisieType {
    ALI(new DefaultInteractionController(), new DefaultDelay()),//Ali
    ANTON(new DefaultInteractionController(), new DefaultDelay()),//Mrówkacz
    BIZ_ON(new DefaultInteractionController(), new DefaultDelay()),//Żubrowar
    BEELLIE(new DefaultInteractionController(), new DefaultDelay()),//Żądłolot
    TEDDO(new DefaultInteractionController(), new DefaultDelay()),//Dźwiedzior
    BULLO(new DefaultInteractionController(), new DefaultDelay()),//Byku
    ATHLETE(new DefaultInteractionController(), new DefaultDelay()),//Pudziuś
    CAMELEOMAN(new DefaultInteractionController(), new DefaultDelay()),//Wielobłąd
    FRISKY(new DefaultInteractionController(), new DefaultDelay()),//Mruczka
    KIT_O(new DefaultInteractionController(), new DefaultDelay()),//Kituś
    KITTY(new DefaultInteractionController(), new DefaultDelay()),//Kicia
    SHYRIEK(new DefaultInteractionController(), new DefaultDelay()),//Piskacz
    GATOR(new DefaultInteractionController(), new DefaultDelay()),//Kroczek
    SMARTIE(new DefaultInteractionController(), new DefaultDelay()),//Bystruś
    CUDDLE(new DefaultInteractionController(), new DefaultDelay()),//Pulszek
    CUTIE(new DefaultInteractionController(), new DefaultDelay()),//Słodzik
    SCARY_GARY(new DefaultInteractionController(), new DefaultDelay()),//Pikełło
    KINK_KNOT(new DefaultInteractionController(), new DefaultDelay()),//Supełło
    CHUBBO(new DefaultInteractionController(), new DefaultDelay()),//Grubełło
    FOODIE(new DefaultInteractionController(), new DefaultDelay()),//Smakełło
    TOMEAGLE(new DefaultInteractionController(), new DefaultDelay()),//Orłuś
    BUGBER(new DefaultInteractionController(), new DefaultDelay()),//Trąbcia
    ELLIE(new DefaultInteractionController(), new DefaultDelay()),//Słoniu
    FOXY_ROXY(new DefaultInteractionController(), new DefaultDelay()),//Lisiczka
    BROWNOSIE(new DefaultInteractionController(), new DefaultDelay()),//Lizuś
    MISSFROGGIE(new DefaultInteractionController(), new DefaultDelay()),//Żabcia
    GIRALLA(new DefaultInteractionController(), new DefaultDelay()),//Rafcia
    STRONGIE(new DefaultInteractionController(), new DefaultDelay()),//Goruś
    PONY(new DefaultInteractionController(), new DefaultDelay()),//Rumo
    CHEERFUL(new DefaultInteractionController(), new DefaultDelay()),//Skoczka
    BRO(new DefaultInteractionController(), new DefaultDelay()),//Kolo
    LURK(new DefaultInteractionController(), new DefaultDelay()),//Pardzio
    LUX_MANE(new DefaultInteractionController(), new DefaultDelay()),//Bujnogrzyw
    SHORTIE(new DefaultInteractionController(), new DefaultDelay()),//Mały
    OCTOPUSH(new DefaultInteractionController(), new DefaultDelay()),//Ośmiornik
    OST_RICH(new DefaultInteractionController(), new DefaultDelay()),//Strusior
    OWLIE(new DefaultInteractionController(), new DefaultDelay()),//Sowcia
    BIGHEAD(new DefaultInteractionController(), new DefaultDelay()),//Mądruś
    PANDICE(new DefaultInteractionController(), new DefaultDelay()),//Pandziu
    SLOPPY(new DefaultInteractionController(), new DefaultDelay()),//Zgapka
    PENGPONG(new DefaultInteractionController(), new DefaultDelay()),//Pinguś
    LITTLEBEAR(new DefaultInteractionController(), new DefaultDelay()),//Misiaczek
    KITTER(new DefaultInteractionController(), new DefaultDelay()),//Kicek
    RACCO(new DefaultInteractionController(), new DefaultDelay()),//Szopuś
    WALKER(new DefaultInteractionController(), new DefaultDelay()),//Wędrek
    BITTERO(new DefaultInteractionController(), new DefaultDelay()),//Ząbek
    WOOLLY(new DefaultInteractionController(), new DefaultDelay()),//Wełnuś
    SNAKIEE(new DefaultInteractionController(), new DefaultDelay()),//Jaduś
    STORKIE(new DefaultInteractionController(), new DefaultDelay()),//Bociek
    SPEEDO(new DefaultInteractionController(), new DefaultDelay()),//Wiewcia
    PETIGER(new DefaultInteractionController(), new DefaultDelay()),//Zdzigrys
    TURK(new DefaultInteractionController(), new DefaultDelay()),//Induś
    SHELLO(new DefaultInteractionController(), new DefaultDelay()),//Skorupny
    WALRUS(new DefaultInteractionController(), new DefaultDelay()),//Morsu
    ROBO(new DefaultInteractionController(), new DefaultDelay()),//Robcio
    WOLFART(new DefaultInteractionController(), new DefaultDelay());//Wilku

    private final InteractionController interactionController;
    private final Delay delay;

    WisieType(InteractionController interactionController, Delay delay) {
        this.interactionController = interactionController;
        this.delay = delay;
    }

    public static WisieType random() {
        return RandomHelper.randomElement(values());
    }

    public InteractionController getInteractionController() {
        return interactionController;
    }

    public Delay getDelay() {
        return delay;
    }
}
