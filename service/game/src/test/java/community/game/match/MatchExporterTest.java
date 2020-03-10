package community.game.match;

import org.junit.jupiter.api.Test;

class MatchExporterTest {
    @Test
    void export() {
        Match match = new TestMatchBuilder().build();
        for (int i = 0; i < 5; i++) {
            match.nextTick();
        }

        String export = new MatchExporter(match).export();

        System.out.println(export);
    }

}