package CiroVitiello.enums;

import java.util.Random;

public enum TipoEventoE {
    PUBBLICO, PRIVATO;

    private static final Random random = new Random();

    public static TipoEventoE randomTipoEvento() {
        TipoEventoE[] tipoEventoES = values();
        return tipoEventoES[random.nextInt(tipoEventoES.length)];
    }
}
