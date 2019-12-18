package utile;

public final class Constante {

    //Constante Pyromancer
    public static final int HP_INITIAL_P = 500;
    public static final float P_LUPTA_K = 1.2f;
    public static final int HP_NIVEL_P = 50;
    public static final float P_LUPTA_R = 0.8f;
    public static final float P_LUPTA_P = 0.9f;
    public static final float P_LUPTA_W = 1.05f;
    public static final int DMG_ABL_1_P = 350;
    public static final int DMG_NIVEL_ABL_1_P = 50;
    public static final int DMG_ABL_2_P = 150;
    public static final int DMG_NIVEL_ABL_2_P = 20;
    public static final float BONUS_TEREN_P = 1.25f;
    public static final int OVERTIME_P = 50;
    public static final int OVERTIME_NIVEL_P = 30;
    public static final int OVERTIME_TIMP_P = 2;

    //Constante Knight
    public static final float K_LUPTA_P_ABL_1 = 1.1f;
    public static final float K_LUPTA_P_ABL_2 = 0.9f;
    public static final int HP_NIVEL_K = 80;
    public static final int HP_INITIAL_K = 900;
    public static final float K_LUPTA_K_ABL_1 = 1f;
    public static final float K_LUPTA_K_ABL_2 = 1.2f;
    public static final float K_LUPTA_R_ABL_1 = 1.15f;
    public static final float K_LUPTA_R_ABL_2 = 0.8f;
    public static final float K_LUPTA_W_ABL_1 = 0.8f;
    public static final float K_LUPTA_W_ABL_2 = 1.05f;
    public static final int DMG_ABL_1_K = 200;
    public static final int DMG_NIVEL_ABL_1_K = 30;
    public static final int DMG_ABL_2_K = 100;
    public static final int DMG_NIVEL_ABL_2_K = 40;
    public static final float BONUS_TEREN_K = 1.15f;
    public static final float PROCENT_K = 0.2f;
    public static final float PROCENT_NIVEL_K = 0.01f;
    public static final float PROCENT_MAX_K = 0.4f;
    public static final int PARALIZAT_TIMP_K = 1;

    //Constante Rouge
    public static final float R_LUPTA_P_ABL_1 = 1.25f;
    public static final float R_LUPTA_P_ABL_2 = 1.2f;
    public static final int HP_NIVEL_R = 40;
    public static final float R_LUPTA_K_ABL_1 = 0.9f;
    public static final float R_LUPTA_K_ABL_2 = 0.8f;
    public static final float R_LUPTA_W_ABL_1 = 1.25f;
    public static final float R_LUPTA_W_ABL_2 = 1.25f;
    public static final int HP_INITIAL_R = 600;
    public static final float R_LUPTA_R_ABL_1 = 1.2f;
    public static final float R_LUPTA_R_ABL_2 = 0.9f;
    public static final float CRITICA_NORMALA_R = 1f;
    public static final int OVERTIME_TIMP_R = 3;
    public static final float BONUS_TEREN_R = 1.15f;
    public static final int CRITICA_PER_RUNDE = 3;
    public static final float CRITICA_BONUS_R = 1.5f;
    public static final int OVERTIME_TIMP_BONUS_R = 6;
    public static final int DMG_ABL_1_R = 200;
    public static final int DMG_NIVEL_ABL_1_R = 20;
    public static final int DMG_ABL_2_R = 40;
    public static final int DMG_NIVEL_ABL_2_R = 10;

    //Constante Wizard
    public static final float W_LUPTA_P_ABL_1 = 0.9f;
    public static final float W_LUPTA_P_ABL_2 = 1.3f;
    public static final int HP_NIVEL_W = 30;
    public static final float W_LUPTA_K_ABL_1 = 1.2f;
    public static final float W_LUPTA_K_ABL_2 = 1.4f;
    public static final int HP_INITIAL_W = 400;
    public static final float W_LUPTA_R_ABL_1 = 0.8f;
    public static final float W_LUPTA_R_ABL_2 = 1.2f;
    public static final float W_LUPTA_W_ABL_1 = 1.05f;
    public static final float W_LUPTA_W_ABL_2 = 0f;
    public static final float PROCENT_W = 0.2f;
    public static final float PROCENT_NIVEL_W = 0.05f;
    public static final float PROCENT_ABL_1_W = 0.3f;
    public static final float BONUS_TEREN_W = 1.1f;
    public static final float PROCENT_ABL_2_W = 0.35f;
    public static final float PROCENT_ALB_2_NIVEL_W = 0.02f;
    public static final float PROCENT_MAX_ABL_2_W = 0.7f;

    //Constante generale
    public static final float BONUS_TEREN_NEUTRU = 1f;
    public static final float ZERO = 0f;
    public static final int XP_NIVEL_0 = 200;
    public static final int XP_PER_NIVEL = 50;
    public static final int XP = 200;
    public static final int XP_NIVEL = 40;
    public static String out = null;

    public void out(final String str) {
        out = str;
    }

    public Constante() { }
}
