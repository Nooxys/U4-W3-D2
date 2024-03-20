package CiroVitiello.enums;

import java.util.Random;

public enum StatoPartecipazione {
    CONFERMTA, DA_CONFERMARE;

    private static final Random random = new Random();

    public static StatoPartecipazione randomStatus() {
        StatoPartecipazione[] tipoStato = values();
        return tipoStato[random.nextInt(tipoStato.length)];
    }
}
