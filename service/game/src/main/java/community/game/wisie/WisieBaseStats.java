package community.game.wisie;

public class WisieBaseStats {
    private final int delay;
    private final int maxHealth;
    private final int startHealth;
    private final int attack;
    private final int attackRange;
    private final int defend;
    private final int heal;
    private final int healRange;
    private final int cost;
    private final int moveRange;
    private final int playRange;

    public WisieBaseStats(int delay, int maxHealth, int startHealth, int attack, int attackRange, int defend, int heal, int healRange, int cost, int moveRange, int playRange) {
        this.delay = delay;
        this.maxHealth = maxHealth;
        this.startHealth = startHealth;
        this.attack = attack;
        this.attackRange = attackRange;
        this.defend = defend;
        this.heal = heal;
        this.healRange = healRange;
        this.cost = cost;
        this.moveRange = moveRange;
        this.playRange = playRange;
    }

    public int getDelay() {
        return delay;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getStartHealth() {
        return startHealth;
    }

    public int getAttack() {
        return attack;
    }

    public int getAttackRange() {
        return attackRange;
    }

    public int getDefend() {
        return defend;
    }

    public int getHeal() {
        return heal;
    }

    public int getHealRange() {
        return healRange;
    }

    public int getCost() {
        return cost;
    }

    public int getMoveRange() {
        return moveRange;
    }

    public int getPlayRange() {
        return playRange;
    }
}
