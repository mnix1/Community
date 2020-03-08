package community.game.match;

import community.game.match.metadata.wisie.Wisie;
import community.game.match.metadata.wisie.WisieBaseStats;
import community.game.match.metadata.wisie.WisieType;

public class TestWisieBuilder {
    private WisieType type;
    private WisieBaseStats baseStats;
    private int delay = 4;
    private int maxHealth = 10;
    private int startHealth = 10;
    private int attack = 3;
    private int attackRange = 1;
    private int defend = 1;
    private int heal = 0;
    private int healRange = 0;
    private int cost = 3;
    private int moveRange = 1;

    public TestWisieBuilder(WisieType type) {
        this.type = type;
    }

    TestWisieBuilder baseStats(WisieBaseStats baseStats) {
        this.baseStats = baseStats;
        return this;
    }

    TestWisieBuilder delay(int delay) {
        this.delay = delay;
        return this;
    }

    TestWisieBuilder maxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
        return this;
    }

    TestWisieBuilder startHealth(int startHealth) {
        this.startHealth = startHealth;
        return this;
    }

    TestWisieBuilder attack(int attack) {
        this.attack = attack;
        return this;
    }

    TestWisieBuilder attackRange(int attackRange) {
        this.attackRange = attackRange;
        return this;
    }

    TestWisieBuilder defend(int defend) {
        this.defend = defend;
        return this;
    }

    TestWisieBuilder heal(int heal) {
        this.heal = heal;
        return this;
    }

    TestWisieBuilder healRange(int healRange) {
        this.healRange = healRange;
        return this;
    }

    TestWisieBuilder cost(int cost) {
        this.cost = cost;
        return this;
    }

    TestWisieBuilder moveRange(int moveRange) {
        this.moveRange = moveRange;
        return this;
    }

    Wisie build() {
        if (baseStats == null) {
            baseStats = new WisieBaseStats(delay, maxHealth, startHealth, attack, attackRange, defend, heal, healRange, cost, moveRange);
        }
        return new Wisie(type, baseStats);
    }
}
