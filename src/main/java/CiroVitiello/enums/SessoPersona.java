package CiroVitiello.enums;

import java.util.Random;

public enum SessoPersona {
    M, F;
    private static final Random random = new Random();

    public static SessoPersona randomSex() {
        SessoPersona[] tipoSex = values();
        return tipoSex[random.nextInt(tipoSex.length)];
    }
}
