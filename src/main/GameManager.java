/* r - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
package main;

import java.io.IOException;

public final class GameManager
        extends javax.microedition.lcdui.Canvas
        implements java.lang.Runnable
{
    
    public static int partnerMode;
    
    public static int screenWidth;
    public static int screenHeight;
    private static int screenWidth12Left;
    public static int halfScreenWidth12Left;
    public static int halfScreenHeight12Left;
    public static int screenLockX;
    public static int screenLockY;
    private static int S;
    public static int g;
    private static int T;
    public static int h;
    public static int i;
    private static int U;
    private static boolean V;
    private static boolean W;
    private static boolean isNormalEnemy;
    private static boolean Y;
    public static boolean j;
    private static boolean Z;
    public static int k;
    private static int aa;
    public static boolean copsBeingCalled;
    public static boolean isCopcallAllowed;
    public static int n;
    public static boolean adamExitScene;
    private static boolean ab;
    private static int ac;
    private static int ad;
    private static int ae;
    private static int af;
    public static int currentLevel;
    public static int currentDifficulty;
    public static int enemyVelocityFactor;
    public static int bossVelocityFactor;
    private static int ag;
    private static int levelTriggerId;
    public static int t;
    public static int u;
    private static int ai;
    private static int aj;
    public static int v;
    public static int w;
    public static int extraLevelBonus;
    public static main.AbstractObject[] players; // 0 == pl1, 1 == pl2, 2 == Adam helper
    public static java.util.Vector bossObjects;
    public static java.util.Vector enemyObjects;
    public static java.util.Vector miscObjects;
    public static java.util.Vector collidableObjects;
    public static java.util.Vector collisionMapObjects;
    private static java.util.Random random;
    private static final java.lang.String[] am;
    private static final int[][] an;
    private static final int[][] ao;
    private static final int[] ap;
    public static final int[] E;
    public static final int[] F;
    private static int[][] aq;
    private static final int[] ar;
    private static final java.lang.String[] as;
    private static final java.lang.String[][] at;
    private static javax.microedition.lcdui.Image[] au;
    public static main.AmbFileData G;
    private static javax.microedition.lcdui.Image[] av;
    private static main.oExtendsAr[] aw;
    private static java.lang.String[] ax;
    private static short[][] ay;
    private static short[][] az;
    public static javax.microedition.lcdui.Image[][] charSpriteImages;
    public static javax.microedition.lcdui.Image[][] I;
    public static javax.microedition.lcdui.Image[][] J;
    public static main.ObjectArt[] charsArt;
    private static main.ObjectArt[] aA;
    private static main.ObjectArt[] aB;
    private static javax.microedition.lcdui.Image[] aC;
    private static main.ObjectArt[] aD;
    public static javax.microedition.lcdui.Image[] L;
    private static main.ObjectArt[] aE;
    private static final java.lang.String[] aF;
    private static final java.lang.String[] aG;
    private static javax.microedition.lcdui.Image[] aH;
    private static main.ObjectArt[] aI;
    private static final java.lang.String[] aJ;
    private static final java.lang.String[] copCallArtFiles;
    public static final java.lang.String[][] characterArtFiles;
    public static final java.lang.String[][] characterPaletteBFiles;
    public static final java.lang.String[][] characterPaletteCFiles;
    public static final java.lang.String[] characterAtlasFiles;
    private static final java.lang.String[][] levelObjArtFiles;
    private static final java.lang.String[][] levelObjAtlasFiles;
    private static final int[][] aN;
    private static final int[][] aO;
    private static final int[][] objNameOffsets;
    private static int aQ;
    private static int aR;
    private static final int[] aS;
    private static int gameOverContinueState;
    private static int gameOverContinueVisualState;
    public static int gameOveredPlayer;
    private static int playerSelection;
    private static final int[][] aW;
    private static int lvl6ElevatorState;
    private static int aY;
    private static int aZ;
    private static int ba;
    private static boolean bb;
    private static boolean bc;
    private static main.Point2D enforcedScreenPos;
    private static boolean be;
    private static main.Point2D bfPt;
    private static int bg;
    private static int bh;
    private static int bi;
    private static int bj;
    private static int bk;
    private static int bl;
    private static final int[] bm;
    private static int bn;
    private static final int[][] bo;
    private static final boolean[] bp;
    private static int bq;
    private static int br;
    private static int bs;
    private static final int[] bt;
    private static final int[] bu;
    private static final main.AbstractObject[] objsInHUD = new AbstractObject[2];
    private static int bw;
    public static int Q;
    private static java.lang.Class bx;
    private static java.lang.String[] _BB;
    private static byte[] data;
    private int _CC = 0;
    private int _a;
    private long _b;
    private static long _c;
    private static javax.microedition.midlet.MIDlet mMidlet;
    private javax.microedition.lcdui.Image _e;
    private byte _f = 2;
    private final byte[] _g;
    private int _h;
    private int _i;
    private int _j;
    private int _k;
    private int _l;
    private int _m;
    private int _n;
    private long _o;
    private int _p;
    private byte[] _q;
    private int[] _r;
    private static int _s;
    private static int _DD0 = -270746416;
    private static long _DD1 = (long) -1531294774;
    private static int _DD2 = -1923128348;
    private static long _DD3 = (long) -1571181280;
    private static int _DD4 = -1923128348;
    private static long _DD5 = (long) -1923128348;
    private static int _DD6 = 1788025160;
    private static long _DD7 = (long) 19526;
    private static int _DD8 = -1464659359;
    private static long _DD9 = (long) -925001499;
    private static int _DD10 = 831618647;
    private static long _DD11 = (long) 19526;
    private static int _DD12 = 1402502940;
    private static long _DD13 = (long) -925001499;
    private static int _DD14 = -1357843586;
    private static long _DD15 = (long) -267394043;
    private static int _DD16 = -1634563036;
    private static long _DD17 = (long) -72193853;
    private static int _DD18 = 423502028;
    private static long _DD19 = (long) -925001499;

    static {
        _BB = new java.lang.String[20];
        data = new byte[1925];
        _s = 0;
        players = new main.AbstractObject[3];
        collidableObjects = new java.util.Vector(64, 64);
        random = (new java.util.Random(new java.util.Date().getTime()));
        am = new java.lang.String[]{"01", "01", "02", "03",
            "04", "05", "06", "07"};
        an = new int[][]{{1, 0, 0, 0}, {1, 2, 125, 126},
        {1, 2, 3, 125, 126}, {1, 2, 7, 125, 126},
        {1, 2, 3, 4, 5}, {1, 2, 3, 4, 5},
        {1, 2, 124, 125, 126}, {1, 7}};
        ao = new int[][]{new int[5], new int[5], {1, 0, 0, 0, 0},
        {1, 0, 0, 0, 0}, {1, 1, 1, 0, 0},
        {1, 0, 0, 0, 0}, {1, 0, 0, 0, 0}, new int[5]};
        ap = new int[]{0, 0, 2, 1, 3, 1, 2, 0};
        E = new int[]{622592, 622592, 655360, 655360, 688128, 696320, 491520,
            696320};
        F = new int[]{950272, 950272, 950272, 950272, 983040, 942080, 819200,
            901120};
        aq = (new int[][]{{1966080, -1}, {5120000, 9953280, 14499840, -1},
        {4096000, 8601600, 12697600, 14745600, -1},
        {5120000, 9666560, 13844480, 15810560, -1},
        {5120000, 9216000, 12001280, 16793600, 18759680, -1},
        {4300800, 10649600, 13189120, 17530880, 22732800, 23183360,
            -1},
        {19054592, 16220160, 11632640, 7045120, 663552, -1},
        {17489920, 14663680, 12042240, 10895360, 7208960, 5816320,
            2949120, 1720320, 0, -1}});
        ar = new int[]{14909440, 14909440, 15155200, 16220160, 19169280,
            23592960, 19251200, 20480000};
        as = new java.lang.String[]{"01", "01", "02", "03",
            "04", "05", "06", "07"};
        at = (new java.lang.String[][]{{"st_chip_1_No0", "st_chip_1_No1", "st_obj_1"},
        {"st_chip_1_No0", "st_chip_1_No1", "st_obj_1"},
        {"st_chip_2_No0", "st_chip_2_No2", "st_chip_2_No1"},
        {"st_3_chip_No0", "st_3_chip_No1", "st_3_chip_No2"},
        {"st_4_chip_No1", "st_4_chip_No2", "st_4_chip_No3",
            "st_4_chip_No0"},
        {"st_5_chip_No2", "st_5_chip_No1", "st_5_chip_No0"},
        {"st_6_chip_No0", "st_6_chip_No1", "st_6_chip_No3",
            "st_6_chip_No2", "st_6_chip_No4", "st_6_chip_No5"},
        {"st_7_chip_No1a", "st_7_chip_No2", "st_7_chip_No1b"}});
        ax = new java.lang.String[]{"st2_hama", "st2_nami"};
        ay = new short[][]{{-1, -1, 0, 0, 0, 0, 40},
        {0, 0, 160, 40, 0, 0, 20},
        {0, 40, 160, 40, 0, 0, 4}};
        az = (new short[][]{{-1, -1, 0, 0, 0, 0, 16}, {0, 128, 160, 32, 0, 16, 4},
        {0, 0, 160, 32, 0, 0, 4}, {0, 32, 160, 32, 0, 0, 4},
        {0, 64, 160, 32, 0, 0, 4}, {0, 96, 160, 32, 0, 0, 4},
        {0, 128, 160, 32, 0, 0, 8}, {0, 128, 160, 32, 0, 1, 2},
        {0, 128, 160, 32, 0, 2, 2}, {0, 128, 160, 32, 0, 4, 2},
        {0, 128, 160, 32, 0, 7, 2}, {0, 128, 160, 32, 0, 11, 2},
        {0, 128, 160, 32, 0, 16, 2}, {0, 128, 160, 32, 0, 22, 2},
        {0, 128, 160, 32, 0, 29, 2}, {-1, -1, 0, 0, 0, 0, 4}});
        charSpriteImages = new javax.microedition.lcdui.Image[18][];
        I = new javax.microedition.lcdui.Image[18][];
        J = new javax.microedition.lcdui.Image[18][];
        charsArt = new main.ObjectArt[18];
        aA = new main.ObjectArt[18];
        aB = new main.ObjectArt[18];
        aC = new javax.microedition.lcdui.Image[8];
        aD = new main.ObjectArt[8];
        L = new javax.microedition.lcdui.Image[2];
        aE = new main.ObjectArt[2];
        aF = new java.lang.String[]{"item_H_00", "hokori"};
        aG = new java.lang.String[]{"koshow_all", "sairui_all"};
        aH = new javax.microedition.lcdui.Image[1];
        aI = new main.ObjectArt[3];
        aJ = new java.lang.String[]{"bom_H_00"};
        copCallArtFiles = (new java.lang.String[]{"bom_pato_all", "bom_tama_all", "bom_fire_all"});
        characterArtFiles = (new java.lang.String[][]{
                 new java.lang.String[1],
                {"axel_H_00", "axel_H_01", "axel_H_02", "axel_H_03"},
                {"blaze_H_00", "blaze_H_01", "blaze_H_02", "blaze_H_03"},
                {"adam"},
                {"zako02"},
                {"zako00"},
                {"zako01"},
                {"zako03"},
                {"zako04"},
                {"zako05"},
                {"stitch"},
                {"jack"},
                {"isao"},
                {"blaze_H_00", "blaze_H_01", "blaze_H_02", "blaze_H_03"},
                {"blaze_H_00", "blaze_H_01", "blaze_H_02", "blaze_H_03"},
                {"harakiri"},
                {"shiva_H_00", "shiva_H_01", "shiva_H_02"},
                {"mrx"}
        }
                );
        characterPaletteBFiles = (new java.lang.String[][]{
                new java.lang.String[1],
                new java.lang.String[4],
                new java.lang.String[4],
                new java.lang.String[1],
                {"zako02_pal_b"},
                {"zako00_pal_b"},
                {"zako01_pal_b"},
                {"zako03_pal_b"},
                {"zako04_pal_b"},
                {"zako05_pal_b"},
                {"stitch_pal_b"},
                {"jack_pal_b"},
                new java.lang.String[2],
                {"yaksa_0_pal_b", "yaksa_1_pal_b", "yaksa_2_pal_b", "yaksa_3_pal_b"},
                {"onihime_0_pal_b", "onihime_1_pal_b", "onihime_2_pal_b", "onihime_3_pal_b"},
                {"harakiri_pal_b"},
                new java.lang.String[3],
                new java.lang.String[3]
            }
        );
        characterPaletteCFiles = (new java.lang.String[][]{
                new java.lang.String[1],
                new java.lang.String[4],
                new java.lang.String[4],
                new java.lang.String[1],
                {"zako02_pal_c"},
                {"zako00_pal_c"},
                {"zako01_pal_c"},
                {"zako03_pal_c"},
                {"zako04_pal_c"},
                {"zako05_pal_c"},
                {"stitch_pal_c"},
                {"jack_pal_c"},
                new java.lang.String[2],
                {"yaksa_0_pal_c", "yaksa_1_pal_c", "yaksa_2_pal_c", "yaksa_3_pal_c"},
                {"onihime_0_pal_c", "onihime_1_pal_c", "onihime_2_pal_c", "onihime_3_pal_c"},
                {"harakiri_pal_c"},
                new java.lang.String[3],
                new java.lang.String[3]
            }
        );
        characterAtlasFiles = (new java.lang.String[]{
            null, "axel_all", "blaze_all", "adam_all", "04_zako_all",
            "00_zako_all", "05_zako_all", "03_zako_all", "06_zako_all",
            "07_zako_all", "stitch_all", "jack_all", "isao_all",
            "blaze_all", "blaze_all", "harakiri_all", null, "mrx_all"}
        );
        levelObjArtFiles = (new java.lang.String[][]{{"st1_H_00"}, {"st1_H_00"}, {"st2_H_00"}, {"st3_H_00"},
        {"st4_H_00"}, {"st5_H_01"}, {"st6_H_00"},
        {"st7_H_00"}});
        levelObjAtlasFiles = (new java.lang.String[][]{{"st1_obj110_all", "st1_obj111_all", "st1_obj112_all"},
        {"st1_obj110_all", "st1_obj111_all", "st1_obj112_all"},
        {"st2_obj_120", "st2_obj_121", "st2_obj_122"},
        {"st3_obj_130", "st3_obj_131", "st3_obj_132", "st3_obj_133"},
        {"st4_obj_140"},
        {"st5_obj_150", "st5_obj_151", null, null},
        new java.lang.String[1],
        {"st7_obj_170", "st7_obj_171", "st7_obj_172", "st7_obj_173",
            "st7_obj_174"}});
        aN = new int[][]{new int[2], {120, 0}, {140, 0}, {160, 0},
        {200, 0}, {180, 0}, {120, 20}, {160, 20},
        {140, 20}, {220, 0}, {180, 20}, {120, 40},
        {200, 20}, {200, 40}, {200, 40}, {140, 40},
        {160, 40}, {180, 40}};
        (new int[][]{new int[1], {0, 65, 25}, {50, 65, 31}, {100, 65, 26},
        {50, 83, 36}, {100, 92, 46}, {0, 101, 38}, {150, 101, 44},
        {200, 83, 31}, {50, 110, 43}, {150, 65, 36}, {200, 65, 25},
        {0, 74, 23}, {100, 74, 33}, {50, 74, 42}, {150, 74, 46},
        {200, 74, 30}, {0, 83, 24}, {100, 83, 37}, {200, 92, 46},
        {50, 101, 50}, {200, 101, 34}, {0, 92, 50}, {100, 110, 47},
        {150, 83, 37}, {150, 92, 46}, {100, 101, 37}, {0, 110, 29},
        {50, 92, 32}, {150, 110, 43}, {150, 65, 36}, {200, 65, 25},
        {0, 74, 23}, {100, 74, 33}, null})[34]
                = new int[]{50, 74, 42};
        aO = new int[][]{new int[2], {120, 0}, {140, 0}, {160, 0},
        {200, 0}, {180, 0}, {120, 20}, {160, 20},
        {140, 20}, {160, 40}, {180, 20}, {120, 40},
        {200, 20}, {200, 40}, {200, 40}, {140, 40},
        {160, 40}, {180, 40}};
        
        
        objNameOffsets = (
                new int[][]{
                    new int[1],
                    {0, 67, 33},    // Axel
                    {34, 67, 41},   // Blaze
                    {76, 67, 33},   // Adam
                    {0, 93, 45},    // Garcia
                    {0, 106, 53},   // Y.Signal
                    {0, 119, 61},   // Ryokuchi
                    {162, 106, 57}, // Electra
                    {179, 80, 41},  // Brash
                    {162, 119, 57}, // Abadede
                    {110, 67, 45},  // Stitch
                    {156, 67, 31},  // Jack
                    {188, 67, 29},  // Isao
                    {50, 80, 41},   // Yasha
                    {0, 80, 49},    // Onihime
                    {92, 80, 57},   // Harakiri
                    {0, 0, 0},      // ---- (Shiva)
                    {150, 80, 28},  // Mr.X
                    {46, 93, 47},   // Joseph
                    {108, 106, 53}, // R.Signal
                    {62, 119, 49},  // Hakuyo
                    {42, 132, 40},  // L.Lisa
                    {152, 93, 63},  // Jonathan
                    {125, 132, 60}, // Z.Kusano
                    {94, 93, 57},   // Souther
                    {54, 106, 53},  // G.Signal
                    {112, 119, 49}, // Suzaku
                    {83, 132, 41},  // Suzy.Q
                    {0, 132, 41},   // Garam
                    {186, 132, 33}, // Kong
                    {110, 67, 45},  // Stitch
                    {156, 67, 31},  // Jack
                    {188, 67, 29},  // ISAO
                    {50, 80, 41},   // Yasha
                    {0, 80, 49}     // Onihime
                }
        );
        /* old font
        objNameOffsets = (
                new int[][]{
                    new int[1],
                    {0, 0, 17}, // Axel
                    {1, 0, 21}, // Blaze
                    {2, 0, 19}, // Adam
                    {1, 2, 25}, // Garcia
                    {2, 3, 31}, // Y.Signal
                    {0, 4, 34}, // Ryokuchi
                    {3, 4, 29}, // Electra
                    {4, 2, 21}, // Brash
                    {1, 5, 29}, // Abadede
                    {3, 0, 25}, // Stitch
                    {4, 0, 17}, // Jack
                    {0, 1, 17}, // Isao
                    {2, 1, 21}, // Yasha
                    {1, 1, 32}, // Onihime
                    {3, 1, 33}, // Harakiri
                    {4, 1, 30}, // ---- (Shiva)
                    {0, 2, 17}, // Mr.X
                    {2, 2, 25}, // Joseph
                    {4, 3, 31}, // R.Signal
                    {1, 4, 26}, // Hakuyo
                    {4, 4, 23}, // L.Lisa
                    {0, 3, 35}, // Jonathan
                    {2, 5, 33}, // Z.Kusano
                    {3, 2, 30}, // Souther
                    {3, 3, 31}, // G.Signal
                    {2, 4, 27}, // Suzaku
                    {0, 5, 24}, // Suzy.Q
                    {1, 3, 23}, // Garam
                    {3, 5, 18}, // Kong
                    {3, 0, 25}, // Stitch
                    {4, 0, 17}, // Jack
                    {0, 1, 17}, // ISAO
                    {2, 1, 21}, // Yasha
                    {1, 1, 32}  // Onihime
                }
        );
        */
        /* Originals
        objNameOffsets = (
                new int[][]{
                    new int[1],
                    {0, 0, 42},
                    {1, 0, 33},
                    {2, 0, 21},
                    {1, 2, 32},
                    {2, 3, 43},
                    {0, 4, 22},
                    {3, 4, 35},
                    {4, 2, 34},
                    {1, 5, 33},
                    {3, 0, 32},
                    {4, 0, 21},
                    {0, 1, 21},
                    {2, 1, 22},
                    {1, 1, 23},
                    {3, 1, 34},
                    {4, 1, 30},
                    {0, 2, 30},
                    {2, 2, 33},
                    {4, 3, 43},
                    {1, 4, 22},
                    {4, 4, 33},
                    {0, 3, 33},
                    {2, 5, 32},
                    {3, 2, 34},
                    {3, 3, 43},
                    {2, 4, 22},
                    {0, 5, 34},
                    {1, 3, 22},
                    {3, 5, 22},
                    {3, 0, 32},
                    {4, 0, 21},
                    {0, 1, 21},
                    {2, 1, 22},
                    {1, 1, 23}
                }
        );
        */
        aS = new int[]{901120, 901120, 737280, 737280, 901120, 901120,
            19054592, 901120, 901120};
        (new int[][]{{0, 210, 33, 9}, {73, 201, 49, 9}, null})[2]
                = new int[]{0, 228, 33, 9};
        aW = new int[][]{{40, 218, 26, 13}, {80, 218, 26, 13},
        {120, 218, 26, 13}};
        enforcedScreenPos = null;
        be = false;
        bfPt = null;
        bm = new int[]{0, 1, 0, 1, 0, 1, 0, 1, 0, 2, 0, 2, 0, 3, 0, 3, 0, 1,
            3, 1, 3, 1};
        bo = new int[][]{null, {10, 10, 11}, {10, 10, 11},
        {10, 20, 20}, {20, 20, 20}, {20, 20, 21},
        null, {30, 30, 31}, null};
        bp = new boolean[]{false, true, true, false, true, true, false,
            false};
        bt = new int[]{144, 112, 80};
        bu = new int[]{3, 4, 5};
        java.lang.Object object = null;
        if (new byte[1925] != null) {
            /* empty */
        }
        try {
            java.io.InputStream inputstream
                    = "".getClass().getResourceAsStream("/_bb");
            inputstream.read(data);
            inputstream.close();
        } catch (java.lang.Exception exception) {
            /* empty */
        }
    }

    public GameManager() {
        this._g = new byte[256];
    }

    public static void a() {
        main.Main.vibrateLow();
    }

    public static void b() {
        main.Main.vibrateHigh();
    }

    private static void u() {
        ac = 2;
        af = -1;
    }

    public static void c() {
        ac = 5;
        af = 5324;
    }

    public static void d() {
        ac = 7;
        main.Main.vibrateLow();
        af = 8192;
    }

    public static void e() {
        ac = 14;
        main.Main.vibrateHigh();
        af = 11878;
    }

    public static int getRandomNumber(int i) {
        return random.nextInt(i);
    }

    public static main.AbstractObject getPlayer1() {
        return players[0];
    }

    public static main.AbstractObject getPlayer2() {
        return players[1];
    }

    public static main.AbstractObject getPlayer3() {
        return players[2];
    }

    public static int capToOneOrTwo(int i) {
        if (i == 1) {
            return 1;
        }
        if (i == 2) {
            return 2;
        }
        return 0;
    }

    private static void deactivate3rdAdam() {
        if (players[0] != null && players[0].grabbedObject != null
                && players[0].grabbedObject.objectType == 3) {
            players[0].q(); // drop adam
        }
        if (players[1] != null && players[1].grabbedObject != null
                && players[0].grabbedObject.objectType == 3) {
            players[1].q(); // drop adam
        }
        adamExitScene = true;
    }

    public static void spawnPlayer(int playerId, int posZ, int posY, int i_2_, int slotId) {
        //if (slotId == 0) return; // DEBUG
        i_2_ = currentLevel == 7 ? 1 : 0;
        main.AbstractObject player;
        InputController controller = slotId == 1 ? InputController.pl2 : InputController.pl1;
        //i = 3; // Debug
        switch (playerId) {
            case 3:
                //if (playerSlots[1] != null){ // Debug
                //    main.GameManager.loadCharacterArt(13, 0, false); // Debug
                //    player = new main.Adam(K[13], 0, e, posZ, posY, i_2_, 0); // Debug
                //}else{ // Debug
                    main.GameManager.loadCharacterArt(3, 0, false);
                    player = new main.Adam(charsArt[3], 0, screenLockX, posZ, posY, i_2_, 0, slotId);
                    // force helper adam to have half energy
                    if (slotId == 2)
                        player.energy = 5000;
                //} // Debug
                break;
            case 2:
                main.GameManager.loadCharacterArt(2, 0, false);
                player = new main.Blaze(charsArt[2], 0, screenLockX, posZ, posY, i_2_, 0, controller, slotId);
                break;
            default:
                main.GameManager.loadCharacterArt(1, 0, false);
                player = new main.Axel(charsArt[1], 0, screenLockX, posZ, posY, i_2_, 0, controller, slotId);
                //main.GameManager.loadCharacterArt(10, 0, false); // Debug
                //player = new main.Antonio(K[10], 0, e, posZ, posY, i_2_, 0); // Debug
                break;
        }
        // Adam is stored in 3rd "players" slot
        if (playerId == 3 && slotId == 2) {
            adamExitScene = false;
            int adamSlot = 2;
            if (partnerMode == 1) {
                if (players[1] == null) adamSlot = 1; // Debug
            }
            if (players[adamSlot] != null) {
                players[adamSlot].clearData();
                players[adamSlot] = null;
            }
            players[adamSlot] = player;
            player.stateFlags |= 0x8101;
            if (currentLevel != 7) {
                bs = 9 + currentDifficulty * 3;
            }
        } else {
            if (players[slotId] != null) {
                players[slotId].clearData();
                players[slotId] = null;
            }
            players[slotId] = player;
            player.g.y = -40960;
            player.stateFlags |= 0x109;
        }
    }

    private static void clearPl2AndPl3() {
        if (charsArt[1] != null) {
            charsArt[1].clearData();
            charsArt[1] = null;
        }
        if (charsArt[2] != null) {
            charsArt[2].clearData();
            charsArt[2] = null;
        }
        if (charSpriteImages[1] != null) {
            main.ImageUtils.releaseImages(charSpriteImages[1]);
            charSpriteImages[1] = null;
        }
        if (charSpriteImages[2] != null) {
            main.ImageUtils.releaseImages(charSpriteImages[2]);
            charSpriteImages[2] = null;
        }
    }

    public static java.lang.Object spawnObject(int objectId, int posX, int posZ, int posY, int direction, int spawnMode, int i_8_) {
        main.AbstractObject newObject = null;
        //objectId = 10 + new Random().nextInt(46); // Debug
        //spawnMode = 1; // Debug
        switch (objectId) {
            case 10:
            case 39:
            case 40:
                main.GameManager.loadCharacterArt(4, 0, false);
                newObject = new main.Garcia(charsArt[4], 0, posX, posZ, posY, direction, spawnMode, 0);
                if (objectId == 39) {
                    newObject.stateFlags |= 0x800000;
                }
                if (objectId == 40) {
                    newObject.stateFlags |= 0x1000000;
                }
                enemyObjects.addElement(newObject);
                break;
            case 20:
                main.GameManager.loadCharacterArt(4, 1, false);
                newObject = new main.Garcia(aA[4], 1, posX, posZ, posY, direction, spawnMode, 0);
                enemyObjects.addElement(newObject);
                break;
            case 30:
            case 41:
                main.GameManager.loadCharacterArt(4, 2, false);
                newObject = new main.Garcia(aB[4], 2, posX, posZ, posY, direction, spawnMode, 0);
                if (objectId == 41) {
                    newObject.stateFlags |= 0x2000000;
                }
                enemyObjects.addElement(newObject);
                break;
            case 36:
                if (currentLevel > 5) {
                    main.GameManager.loadCharacterArt(4, 2, false);
                    newObject = new main.Garcia(aB[4], 0, posX, posZ, posY, direction, spawnMode, 3);
                } else if (currentLevel > 3) {
                    main.GameManager.loadCharacterArt(4, 1, false);
                    newObject = new main.Garcia(aA[4], 0, posX, posZ, posY, direction, spawnMode, 3);
                } else {
                    main.GameManager.loadCharacterArt(4, 0, false);
                    newObject = new main.Garcia(charsArt[4], 0, posX, posZ, posY, direction, spawnMode, 3);
                }
                enemyObjects.addElement(newObject);
                break;
            case 37:
                if (currentLevel > 5) {
                    main.GameManager.loadCharacterArt(4, 2, false);
                    newObject = new main.Garcia(aB[4], 0, posX, posZ, posY, direction, spawnMode, 2);
                } else if (currentLevel > 3) {
                    main.GameManager.loadCharacterArt(4, 1, false);
                    newObject = new main.Garcia(aA[4], 0, posX, posZ, posY, direction, spawnMode, 2);
                } else {
                    main.GameManager.loadCharacterArt(4, 0, false);
                    newObject = new main.Garcia(charsArt[4], 0, posX, posZ, posY, direction, spawnMode, 2);
                }
                enemyObjects.addElement(newObject);
                break;
            case 38:
                if (currentLevel > 5) {
                    main.GameManager.loadCharacterArt(4, 2, false);
                    newObject = new main.Garcia(aB[4], 0, posX, posZ, posY, direction, spawnMode, 1);
                } else if (currentLevel > 3) {
                    main.GameManager.loadCharacterArt(4, 1, false);
                    newObject = new main.Garcia(aA[4], 0, posX, posZ, posY, direction, spawnMode, 1);
                } else {
                    main.GameManager.loadCharacterArt(4, 0, false);
                    newObject = new main.Garcia(charsArt[4], 0, posX, posZ, posY, direction, spawnMode, 1);
                }
                enemyObjects.addElement(newObject);
                break;
            case 11:
                main.GameManager.loadCharacterArt(5, 0, false);
                newObject = new main.Signal(charsArt[5], 0, posX, posZ, posY, direction, spawnMode);
                enemyObjects.addElement(newObject);
                break;
            case 21:
                main.GameManager.loadCharacterArt(5, 1, false);
                newObject = new main.Signal(aA[5], 1, posX, posZ, posY, direction, spawnMode);
                enemyObjects.addElement(newObject);
                break;
            case 31:
                main.GameManager.loadCharacterArt(5, 2, false);
                newObject = new main.Signal(aB[5], 2, posX, posZ, posY, direction, spawnMode);
                enemyObjects.addElement(newObject);
                break;
            case 12:
                main.GameManager.loadCharacterArt(6, 0, false);
                newObject = new main.Hakuyo(charsArt[6], 0, posX, posZ, posY, direction, spawnMode);
                enemyObjects.addElement(newObject);
                break;
            case 22:
                main.GameManager.loadCharacterArt(6, 1, false);
                newObject = new main.Hakuyo(aA[6], 1, posX, posZ, posY, direction, spawnMode);
                enemyObjects.addElement(newObject);
                break;
            case 32:
                main.GameManager.loadCharacterArt(6, 2, false);
                newObject = new main.Hakuyo(aB[6], 2, posX, posZ, posY, direction, spawnMode);
                enemyObjects.addElement(newObject);
                break;
            case 13:
                main.GameManager.loadCharacterArt(7, 0, false);
                newObject = new main.Electra(charsArt[7], 0, posX, posZ, posY, direction, spawnMode);
                enemyObjects.addElement(newObject);
                break;
            case 23:
                main.GameManager.loadCharacterArt(7, 1, false);
                newObject = new main.Electra(aA[7], 1, posX, posZ, posY, direction, spawnMode);
                enemyObjects.addElement(newObject);
                break;
            case 33:
                main.GameManager.loadCharacterArt(7, 2, false);
                newObject = new main.Electra(aB[7], 2, posX, posZ, posY, direction, spawnMode);
                enemyObjects.addElement(newObject);
                break;
            case 14:
                main.GameManager.loadCharacterArt(8, 0, false);
                newObject = new main.Juggler(charsArt[8], 0, posX, posZ, posY, direction, spawnMode);
                enemyObjects.addElement(newObject);
                break;
            case 24:
                main.GameManager.loadCharacterArt(8, 1, false);
                newObject = new main.Juggler(aA[8], 1, posX, posZ, posY, direction, spawnMode);
                enemyObjects.addElement(newObject);
                break;
            case 34:
                main.GameManager.loadCharacterArt(8, 2, false);
                newObject = new main.Juggler(aB[8], 2, posX, posZ, posY, direction, spawnMode);
                enemyObjects.addElement(newObject);
                break;
            case 15:
                main.GameManager.loadCharacterArt(9, 0, false);
                newObject = new main.Abadede(charsArt[9], 0, posX, posZ, posY, direction, spawnMode);
                enemyObjects.addElement(newObject);
                break;
            case 25:
                main.GameManager.loadCharacterArt(9, 1, false);
                newObject = new main.Abadede(aA[9], 1, posX, posZ, posY, direction, spawnMode);
                enemyObjects.addElement(newObject);
                break;
            case 35:
                main.GameManager.loadCharacterArt(9, 2, false);
                newObject = new main.Abadede(aB[9], 2, posX, posZ, posY, direction, spawnMode);
                enemyObjects.addElement(newObject);
                break;
            case 50:
                main.GameManager.loadCharacterArt(10, 0, false);
                newObject = new main.Antonio(charsArt[10], 0, posX, posZ, posY, direction, spawnMode);
                bossObjects.addElement(newObject);
                isNormalEnemy = false;
                break;
            case 55:
                main.GameManager.loadCharacterArt(10, 1, false);
                newObject = new main.Antonio(aA[10], 1, posX, posZ, posY, direction, spawnMode);
                enemyObjects.addElement(newObject);
                break;
            case 51:
                main.GameManager.loadCharacterArt(11, 0, false);
                newObject = new main.Souther(charsArt[11], 0, posX, posZ, posY, direction, spawnMode);
                bossObjects.addElement(newObject);
                isNormalEnemy = false;
                break;
            case 56:
                main.GameManager.loadCharacterArt(11, 1, false);
                newObject = new main.Souther(aA[11], 1, posX, posZ, posY, direction, spawnMode);
                enemyObjects.addElement(newObject);
                break;
            case 52:
                main.GameManager.loadCharacterArt(12, 0, false);
                newObject = new main.Bongo(charsArt[12], 0, posX, posZ, posY, direction, spawnMode);
                bossObjects.addElement(newObject);
                isNormalEnemy = false;
                break;
            case 57:
                main.GameManager.loadCharacterArt(12, 1, false);
                newObject = new main.Bongo(aA[12], 1, posX, posZ, posY, direction, spawnMode);
                enemyObjects.addElement(newObject);
                break;
            case 53:
                main.GameManager.loadCharacterArt(13, 1, false);
                newObject = new main.Onihime(aA[13], 0, posX, posZ, posY, direction, spawnMode, 2);
                bossObjects.addElement(newObject);
                isNormalEnemy = false;
                break;
            case 54:
                main.GameManager.loadCharacterArt(14, 1, false);
                newObject = new main.Onihime(aA[14], 0, posX, posZ, posY, direction, spawnMode, 1);
                bossObjects.addElement(newObject);
                isNormalEnemy = false;
                break;
            case 58:
                main.GameManager.loadCharacterArt(13, 2, false);
                newObject = new main.Onihime(aB[13], 1, posX, posZ, posY, direction, spawnMode, 2);
                enemyObjects.addElement(newObject);
                break;
            case 59:
                main.GameManager.loadCharacterArt(14, 2, false);
                newObject = new main.Onihime(aB[14], 1, posX, posZ, posY, direction, spawnMode, 2);
                enemyObjects.addElement(newObject);
                break;
            case 60:
                main.GameManager.loadCharacterArt(15, 0, false);
                newObject = new main.Harakiri(charsArt[15], 0, posX, posZ, posY, direction, spawnMode);
                bossObjects.addElement(newObject);
                isNormalEnemy = false;
                break;
            case 61:
                main.GameManager.loadCharacterArt(15, 1, false);
                newObject = new main.Harakiri(aA[15], 1, posX, posZ, posY, direction, spawnMode);
                enemyObjects.addElement(newObject);
                break;
            case 108:
                newObject = new main.PickableObject(aE[0], 1, 21, posX, posZ, posY, direction, 0);
                miscObjects.addElement(newObject);
                break;
            case 109:
                newObject = new main.PickableObject(aE[1], 1, 20, posX, posZ, posY, direction, 0);
                miscObjects.addElement(newObject);
                break;
            case 107:
                newObject = new main.MiscObject(aI[1], 1, posX, posZ, 491520, direction, 0, 0);
                miscObjects.addElement(newObject);
                break;
            case 106:
                newObject = new main.PickableObject(aI[2], 1, 23, posX, posZ, posY, direction, 0);
                miscObjects.addElement(newObject);
                break;
            case 110:
                main.GameManager.i(1);
                newObject = new main.MiscObject(aD[0], 3, posX, posZ, posY, 0, spawnMode, i_8_);
                miscObjects.addElement(newObject);
                break;
            case 111:
                main.GameManager.i(1);
                newObject = new main.MiscObject(aD[1], 4, posX, posZ, posY, 0, spawnMode, i_8_);
                miscObjects.addElement(newObject);
                break;
            case 112:
            case 113:
            case 114:
                main.GameManager.i(1);
                newObject = new main.MiscObject(aD[2], 5, posX, posZ, posY, 0, spawnMode, objectId - 112);
                miscObjects.addElement(newObject);
                break;
            case 120:
                main.GameManager.i(2);
                newObject = new main.MiscObject(aD[0], 6, posX, posZ, posY, 0, spawnMode, i_8_);
                miscObjects.addElement(newObject);
                break;
            case 121:
                main.GameManager.i(2);
                newObject = new main.MiscObject(aD[1], 7, posX, posZ, posY, 0, spawnMode, i_8_);
                miscObjects.addElement(newObject);
                break;
            case 122:
                main.GameManager.i(2);
                newObject = new main.MiscObject(aD[1], 8, posX, posZ, posY, 0, spawnMode, i_8_);
                miscObjects.addElement(newObject);
                break;
            case 130:
                main.GameManager.i(3);
                newObject = new main.MiscObject(aD[0], 9, posX, posZ, posY, 0, spawnMode, i_8_);
                miscObjects.addElement(newObject);
                break;
            case 131:
                main.GameManager.i(3);
                newObject = new main.MiscObject(aD[1], 10, posX, posZ, posY, 0, spawnMode, i_8_);
                miscObjects.addElement(newObject);
                break;
            case 132:
                main.GameManager.i(3);
                newObject = new main.MiscObject(aD[2], 11, posX, posZ, posY, 0, spawnMode, i_8_);
                miscObjects.addElement(newObject);
                break;
            case 133:
                main.GameManager.i(3);
                newObject = new main.MiscObject(aD[3], 12, posX, posZ, posY, 0, spawnMode, i_8_);
                miscObjects.addElement(newObject);
                break;
            case 140:
                main.GameManager.i(4);
                newObject = new main.MiscObject(aD[0], 13, posX, posZ, posY, 0, spawnMode, i_8_);
                miscObjects.addElement(newObject);
                break;
            case 150:
                main.GameManager.i(5);
                newObject = new main.MiscObject(aD[0], 14, posX, posZ, posY, 0, spawnMode, i_8_);
                miscObjects.addElement(newObject);
                break;
            case 151:
                main.GameManager.i(5);
                posX += -81920;
                miscObjects.addElement(new main.MiscObject(aD[1], 15, posX, posZ, posY, 0, spawnMode, i_8_));
                break;
            case 170:
                main.GameManager.i(7);
                newObject = new main.MiscObject(aD[0], 18, posX, posZ, posY, 0, spawnMode, i_8_);
                miscObjects.addElement(newObject);
                break;
            case 171:
                main.GameManager.i(7);
                newObject = new main.PickableObject(aD[1], 2, 19, posX, posZ, posY, 0, spawnMode);
                miscObjects.addElement(newObject);
                break;
            case 172:
                main.GameManager.i(7);
                newObject = new main.MiscObject(aD[2], 20, posX, posZ, posY, 0, spawnMode, i_8_);
                miscObjects.addElement(newObject);
                break;
            case 173:
                main.GameManager.i(7);
                newObject = new main.MiscObject(aD[3], 21, posX, posZ, posY, 0, spawnMode, i_8_);
                miscObjects.addElement(newObject);
                break;
            case 174:
                main.GameManager.i(7);
                newObject = new main.MiscObject(aD[4], 22, posX, posZ, posY, 0, spawnMode, i_8_);
                miscObjects.addElement(newObject);
                break;
            case 134:
                collisionMapObjects.addElement(new main.CollisionMap(16, posX, posZ, 0, 0));
                break;
            case 135:
                collisionMapObjects.addElement(new main.CollisionMap(17, posX, posZ, 0, 0));
                break;
            case 136:
                collisionMapObjects.addElement(new main.CollisionMap(18, posX, posZ, 0, 0));
                break;
            case 154:
                collisionMapObjects.addElement(new main.CollisionMap(19, posX, posZ, 0, 0));
                break;
            case 155:
                collisionMapObjects.addElement(new main.CollisionMap(20, posX, posZ, 0, 0));
                break;
            case 156:
                collisionMapObjects.addElement(new main.CollisionMap(25, posX, posZ, 0, 0));
                break;
            case 157:
                collisionMapObjects.addElement(new main.CollisionMap(26, posX, posZ, 0, 0));
                break;
            case 158:
                collisionMapObjects.addElement(new main.CollisionMap(28, posX, posZ, 0, 0));
                break;
            case 159:
                collisionMapObjects.addElement(new main.CollisionMap(21, posX, posZ, 0, 0));
                break;
            case 160:
                collisionMapObjects.addElement(new main.CollisionMap(22, posX, posZ, 0, 0));
                break;
            case 161:
                collisionMapObjects.addElement(new main.CollisionMap(24, posX, posZ, 0, 0));
                break;
            case 162:
                collisionMapObjects.addElement(new main.CollisionMap(27, posX, posZ, 0, 0));
                break;
            case 163:
                collisionMapObjects.addElement(new main.CollisionMap(23, posX, posZ, 0, 0));
                break;
            default:
                main.GameManager.loadCharacterArt(4, 0, false);
                newObject = new main.Garcia(charsArt[4], 0, posX, posZ, posY, direction, spawnMode, 0);
                if (objectId == 39) {
                    newObject.stateFlags |= 0x800000;
                }
                if (objectId == 40) {
                    newObject.stateFlags |= 0x1000000;
                }
                enemyObjects.addElement(newObject);
             break;
        }
        //isNormalEnemy = true; // Debug
        return newObject;
    }

    public static void dropWeaponOnTheFloor(int itemId, int posX, int posZ, int i_11_, int i_12_) {
        itemId = itemId - 1 + 6;
        collisionMapObjects.addElement(new main.CollisionMap(itemId, posX, posZ, i_11_, i_12_));
    }

    public static void g() {
        if (main.MainCanvas.mainState == 14 && main.MainCanvas.holdedMainState == -1  && !Z) {
            main.MainCanvas.setState(21);
        }
    }

    public static void loadLevel(int levelNum, int difficulty, boolean spawnPlayers, int i_14_) {
        //levelNum = 7; // Debug
        main.GameManager.i = 0;
        U = 0;
        t = 4752;
        u = -1;
        ai = 0;
        aj = 80;
        currentLevel = levelNum;
        currentDifficulty = difficulty;
        if (currentDifficulty < 0) {
            currentDifficulty = 0;
        } else if (currentDifficulty > 2) {
            currentDifficulty = 2;
        }
        switch (currentDifficulty) {
            case 1:
                enemyVelocityFactor = 5324;
                bossVelocityFactor = 4615;
                break;
            case 2:
                enemyVelocityFactor = 7692;
                bossVelocityFactor = 4915;
                break;
            default:
                enemyVelocityFactor = 4096;
                bossVelocityFactor = 4096;
        }
//        if (currentDifficulty == 2) {
//            enemyVelocityFactor = 5324; //8192;
//            bossVelocityFactor = 4915;
//        } else {
//            enemyVelocityFactor = 4096;
//            bossVelocityFactor = 4096;
//        }
        ag = 0;
        levelTriggerId = 1;
        v = levelNum == 7 ? 30000 : 10000;
        w = 9900;
        if (currentDifficulty == 2) {
            extraLevelBonus = 20000;
        } else if (currentDifficulty == 1) {
            extraLevelBonus = 5000;
        } else {
            extraLevelBonus = 0;
        }
        V = false;
        W = false;
        isNormalEnemy = true;
        Y = false;
        j = false;
        Z = false;
        k = 0;
        aa = 0;
        bw = 0;
        Q = 0;
        ac = 0;
        copsBeingCalled = false;
        isCopcallAllowed = false;
        n = 0;
        adamExitScene = false;
        ab = false;
        bq = 0;
        br = 0;
        bs = 0;
        main.MainCanvas.displayLoadingScreen();
        main.CollisionMap.loadCollisionMasks();
        main.ar.c(128);
        main.GameManager.clearData();
        main.MainCanvas.displayLoadingScreen();
        if (aH == null) {
            aH = main.ImageUtils.createImages(aJ);
        }
        for (int i = 0; i < copCallArtFiles.length; i++) {
            if (aI[i] == null) {
                java.lang.String string = "/" + copCallArtFiles[i];
                aI[i] = main.GameManager.loadObjectData(string, aH);
            }
        }
        main.MainCanvas.displayLoadingScreen();
        if (L == null) {
            L = main.ImageUtils.createImages(aF);
        }
        for (int i = 0; i < aG.length; i++) {
            if (aE[i] == null) {
                java.lang.String string = "/" + aG[i];
                aE[i] = main.GameManager.loadObjectData(string, L);
            }
        }
        screenWidth = main.MainCanvas.screenClipWidth;
        screenHeight = main.MainCanvas.screenClipHeigh;
        halfScreenWidth12Left = screenWidth / 2 << 12;
        halfScreenHeight12Left = screenHeight / 2 << 12;
        screenWidth12Left = screenWidth << 12;
        main.GameManager.b(0, 0);
        switch (levelNum) {
            default:
                h = 1310720;
                g = aq[levelNum][0];
                T = 983040;
                screenLockX = h + halfScreenWidth12Left;
                screenLockY = halfScreenHeight12Left;
                break;
            case 0:
                h = 0;
                g = aq[levelNum][0];
                T = 983040;
                screenLockX = h + halfScreenWidth12Left;
                screenLockY = halfScreenHeight12Left;
                break;
            case 6:
                j = true;
                main.MainCanvas.displayLoadingScreen();
                h = 0;
                g = 1310720;
                T = 983040;
                screenLockX = h + halfScreenWidth12Left;
                screenLockY = halfScreenHeight12Left;
                lvl6ElevatorState = 0;
                break;
            case 7:
                main.MainCanvas.displayLoadingScreen();
                h = aq[levelNum][0];
                g = 20480000;
                T = 983040;
                screenLockX = 20480000 - halfScreenWidth12Left;
                screenLockY = halfScreenHeight12Left;
        }
        if (levelNum == 1) {
            main.MainCanvas.displayLoadingScreen();
            av = new javax.microedition.lcdui.Image[3];
            av[0] = main.ImageUtils.applyPalette(at[1][1], "st_chip_1_pal_b");
            av[1] = main.ImageUtils.applyPalette(at[1][1], "st_chip_1_pal_c");
            av[2] = main.ImageUtils.applyPalette(at[1][1], "st_chip_1_pal_d");
        } else if (levelNum == 2) {
            main.MainCanvas.displayLoadingScreen();
            av = main.ImageUtils.createImages(ax);
            aw = new main.oExtendsAr[6];
            aw[0] = new main.oExtendsAr(6, av[0], ay);
            aw[1] = new main.oExtendsAr(6, av[0], ay);
            aw[2] = new main.oExtendsAr(6, av[0], ay);
            aw[3] = new main.oExtendsAr(7, av[1], az);
            aw[4] = new main.oExtendsAr(7, av[1], az);
            aw[5] = new main.oExtendsAr(7, av[1], az);
        } else if (levelNum == 6) {
            collisionMapObjects.addElement(new main.CollisionMap(29, 0, 0, 0, 0));
        }
        au = main.ImageUtils.createImages(at[levelNum]);
        G = new main.AmbFileData("/BN_st" + am[levelNum], au, an[levelNum], ao[levelNum],
                ap[levelNum]);
        if (levelNum == 7) {
            G.a(au[2], 0, 1, 20, 20);
        }
        if (spawnPlayers) {
            if (players[0] != null) {
                players[0].clearData();
                players[0] = null;
            }
            main.MainCanvas.displayLoadingScreen();
            
            if (MainCanvas.playerLives[0] > 0 || MainCanvas.mainState == 5) {
                main.GameManager.spawnPlayer(main.MainCanvas.playerIds[0], 0, 0, 0, 0);
                if (players[0] != null){
                    players[0].stateFlags |= 0x8000108;
                    players[0].energy = 10000;
                }
            }
            
            if (GameManager.partnerMode != 0) {
                
                if (players[1] != null) {
                    players[1].clearData();
                    players[1] = null;
                }
                if (MainCanvas.playerLives[1] > 0){
                    main.GameManager.spawnPlayer(main.MainCanvas.playerIds[1], 0, 0, 0, 1);
                    players[1].stateFlags |= 0x8000108;
                    players[1].energy = 10000;
                }
            }
            
            if (i_14_ <= 0 && levelNum != 0) {
                java.lang.String string;
                if (!(string = string = "/BN_st" + as[levelNum]).endsWith(".mod")) {
                    string += ".mod";
                }
                try {
                    java.lang.Class var_class = bx;
                    if (var_class == null) {
                        java.lang.Class var_class_15_;
                        try {
                            var_class_15_ = java.lang.Class.forName("java.lang.Object");
                        } catch (java.lang.ClassNotFoundException classnotfoundexception) {
                            java.lang.NoClassDefFoundError noclassdeffounderror
                                    = new java.lang.NoClassDefFoundError(classnotfoundexception.getMessage());
                            throw noclassdeffounderror;
                        }
                        var_class = bx = var_class_15_;
                    }
                    java.lang.String string_16_ = string;
                    java.lang.Class var_class_17_ = var_class;
                    java.lang.Object object = null;
                    java.lang.Object object_18_ = null;
                    if (object_18_ != null) {
                        /* empty */
                    }
                    java.io.InputStream inputstream = main.GameManager.openInputStreamForFile(var_class_17_, string_16_);
                    java.io.InputStream inputstream_19_ = inputstream;
                    java.io.DataInputStream datainputstream;
                    main.GameManager.readLevelObjects(datainputstream = (new java.io.DataInputStream(inputstream_19_)));
                    datainputstream.close();
                } catch (java.lang.Exception exception) {
                    java.lang.Exception exception_20_;
                    (exception_20_ = exception).printStackTrace();
                }
            }
            if (levelNum == 0) {
                main.AudioController.loadLevelMidi(1, true);
            } else {
                main.AudioController.loadLevelMidi(levelNum + 1 - 1, true);
            }
        }
        
        //if (partnerMode == 1 && main.MainCanvas.mainState == 14){
        //    main.GameManager.spawnPlayer(3, 0, 983040, 0, 2); // Debug
        //}
    }

    public static void clearData() {
        main.MainCanvas.a();
        for (int i = 0 ; i < objsInHUD.length ; ++i) {
            if (objsInHUD[i] != null) {
                objsInHUD[i].clearData();
                objsInHUD[i] = null;
            }
        }
        if (collisionMapObjects != null) {
            for (int i = 0; i < collisionMapObjects.size(); i++) {
                ((main.CollisionMap) collisionMapObjects.elementAt(i)).d();
            }
        }
        collisionMapObjects = new java.util.Vector(32, 32);
        main.ImageUtils.releaseImages(au);
        au = null;
        main.ImageUtils.releaseImages(av);
        av = null;
        if (aw != null) {
            for (int i = 0; i < aw.length; i++) {
                if (aw[i] != null) {
                    aw[i] = null;
                }
            }
            aw = null;
        }
        if (G != null) {
            G.b();
            G = null;
        }
        main.ImageUtils.releaseImagesArray(charSpriteImages);
        main.ImageUtils.releaseImagesArray(I);
        main.ImageUtils.releaseImagesArray(J);
        main.ImageUtils.releaseImages(aC);
        aC = null;
        main.ImageUtils.releaseImages(aH);
        aH = null;
        main.ImageUtils.releaseImages(L);
        L = null;
        for (int i = 0; i < charsArt.length; i++) {
            if (charsArt[i] != null) {
                charsArt[i].clearData();
                charsArt[i] = null;
            }
        }
        for (int i = 0; i < aA.length; i++) {
            if (aA[i] != null) {
                aA[i].clearData();
                aA[i] = null;
            }
        }
        for (int i = 0; i < aB.length; i++) {
            if (aB[i] != null) {
                aB[i].clearData();
                aB[i] = null;
            }
        }
        for (int i = 0; i < aD.length; i++) {
            if (aD[i] != null) {
                aD[i].clearData();
                aD[i] = null;
            }
        }
        for (int i = 0; i < aI.length; i++) {
            if (aI[i] != null) {
                aI[i].clearData();
                aI[i] = null;
            }
        }
        for (int i = 0; i < aE.length; i++) {
            if (aE[i] != null) {
                aE[i].clearData();
                aE[i] = null;
            }
        }
        for (int i = 0; i < players.length; i++) {
            if (players[i] != null) {
                players[i].clearData();
                players[i] = null;
            }
        }
        if (enemyObjects != null) {
            for (int i = 0; i < enemyObjects.size(); i++) {
                ((main.AbstractObject) enemyObjects.elementAt(i)).clearData();
            }
        }
        enemyObjects = new java.util.Vector(64, 64);
        if (bossObjects != null) {
            for (int i = 0; i < bossObjects.size(); i++) {
                ((main.AbstractObject) bossObjects.elementAt(i)).clearData();
            }
        }
        bossObjects = new java.util.Vector(2, 2);
        if (miscObjects != null) {
            for (int i = 0; i < miscObjects.size(); i++) {
                ((main.AbstractObject) miscObjects.elementAt(i)).clearData();
            }
        }
        miscObjects = new java.util.Vector(64, 64);
        java.lang.System.gc();
    }

    public static void handleCharsCollisionAgainstEnvironmentObjects() {
        if (k <= 0) {
            // For each environment obstacle
            for (int i = 0; i < collidableObjects.size(); i++) {
                main.AbstractObject obstacleObject;
                obstacleObject = (main.AbstractObject) collidableObjects.elementAt(i);
                if ((obstacleObject.stateFlags & 0x800) != 0 && obstacleObject.collisionBox != null) {
                    // Check collision with each player
                    for (int j = 0; j < players.length; j++) {
                        main.AbstractObject player;
                        player = players[j];
                        if (player != null
                            && (obstacleObject.stateFlags & 0x1) != 0 && obstacleObject.collisionBox != null
                            && player.collisionBox.checkCollision(obstacleObject.collisionBox, false) != null
                        )
                        {
                            player.position.add(player.collisionBox.lastCollisionAdjustment);
                        }
                    }
                    // Check collision with each enemy
                    for (int j = 0; j < enemyObjects.size(); j++) {
                        main.AbstractObject enemyObj;
                        enemyObj = (main.AbstractObject) enemyObjects.elementAt(j);
                        if ((enemyObj.stateFlags & 0x1) != 0
                             && enemyObj.collisionBox != null
                             && enemyObj.collisionBox.checkCollision(obstacleObject.collisionBox, false) != null
                           )
                        {
                            enemyObj.position.add(enemyObj.collisionBox.lastCollisionAdjustment);
                        }
                    }
                }
            }
        }
    }

    public static void respawnPlayer(int slotId) {
        if (main.MainCanvas.mainState != 14) {
            main.MainCanvas.setState(14);
        }
        if (main.MainCanvas.playerLives[slotId] > 0) {
            main.MainCanvas.playerLives[slotId]--;
        }
        
        //main.MainCanvas.playerLives[0] = 9; // Debug
        
        main.MainCanvas.playerCopCalls[slotId] = currentDifficulty == 0 ? 2 : 1;
        int i = E[currentLevel] + (currentLevel == 7 ? 16384 : 65536);
        main.GameManager.spawnPlayer(main.MainCanvas.playerIds[slotId], i, 983040, 0, slotId);
        main.AbstractObject player = players[slotId];
        //if (player == null) return; // DEBUG..
        if (player.objectType == 1) {
            main.AbstractObject.playSound(41);
        } else if (player.objectType == 2) {
            main.AbstractObject.playSound(45);
        } else if (player.objectType == 3) {
            main.AbstractObject.playSound(43);
        }
        player.visualEnergy = 0;
        player.g.y = -49152;
        player.q = 14;
        player.p = 32;
        t = 4752;
        aa = 1000;
    }

    // TODO: is this continue from gameover? let's do separate method for any player
    public static void onGameOverState() {
        boolean bool = false;
        collidableObjects.removeAllElements();
        V = true;
        if (k > 0) {
            V = false;
        }
        
        main.Point var_q = new main.Point(screenLockX, screenLockY, 0);
        int someVar = 1310720;
        if (players[0] == null && main.MainCanvas.mainState == 14 && !copsBeingCalled && MainCanvas.playerContinues[0] > 0) {
            main.GameManager.respawnPlayer(0);
        }
        
        if (GameManager.partnerMode != 0 && players[1] == null && main.MainCanvas.mainState == 14 && !copsBeingCalled && MainCanvas.playerContinues[1] > 0) {
            main.GameManager.respawnPlayer(1);
        }
        
        // Respawn Adam
        //if (partnerMode == 1) {
        //    if (players[1] == null && main.MainCanvas.mainState == 14 && !l){
        //        main.GameManager.spawnPlayer(3, 0, 983040, 0, 2);             
        //    }                                                                 
        //}
        for (int i = 0 ; i < (GameManager.partnerMode != 0 ? 2 : 1) ; ++i) {
            int otherPlayer = i == 1 ? 0 : 1;
            if (players[i] != null && (players[i].stateFlags & ~0x7fffffff) != 0) {
                players[i].clearData();
                players[i] = null;
                if (main.MainCanvas.playerLives[i] < 1) {
                    gameOveredPlayer = i;
                    if (main.MainCanvas.playerContinues[i] > 0) {
                        if (main.MainCanvas.mainState != 18) {
                            main.MainCanvas.setState(18); // select gameover / continue
                        }
                    } else if (main.MainCanvas.mainState != 19) {
                        if (MainCanvas.playerLives[otherPlayer] > 0) {
                            // there's still one player playing
                            //MainCanvas.setState(14);
                            // No need to change state
                        }else {
                            main.MainCanvas.setState(19); // game over!
                        }
                    }
                    //main.GameManager.clearPl2AndPl3();
                } else if (main.MainCanvas.mainState == 14 && !copsBeingCalled) {
                    main.GameManager.respawnPlayer(i);
                }
            }
        }
        // kill every player that was marked to die
        for (int i = 1; i < players.length; i++) {
            if (players[i] != null && (players[i].stateFlags & ~0x7fffffff) != 0) {
                players[i].clearData();
                players[i] = null;
            }
        }
        
        for (int i = 0; i < players.length; i++) {
            if (players[i] != null) {
                collidableObjects.addElement(players[i]);
            }
        }
        // Check bosses alive
        for (int i = bossObjects.size() - 1; i >= 0; i--) {
            main.AbstractObject obj;
            if ((obj = (main.AbstractObject) bossObjects.elementAt(i)).j == levelTriggerId
                    && (obj.stateFlags & 0x1) == 0) {
                obj.stateFlags |= 0x1;
            }
            if ((obj.stateFlags & ~0x7fffffff) != 0) {
                obj.clearData();
                bossObjects.removeElementAt(i);
            } else {
                if (obj.energy > 0) {
                    bool = true;
                }
                if ((obj.stateFlags & 0x40000000) != 0) {
                    collidableObjects.addElement(obj);
                } else if ((obj.stateFlags & 0x1) != 0
                        && java.lang.Math
                        .abs(obj.position.x - var_q.x) < someVar) {
                    collidableObjects.addElement(obj);
                    V = false;
                }
            }
        }
        u = 0;
        ai = 0;
        for (int i_28_ = enemyObjects.size() - 1; i_28_ >= 0; i_28_--) {
            main.AbstractObject obj
                    = (main.AbstractObject) enemyObjects.elementAt(i_28_);
            do {
                if (!j && obj.j == levelTriggerId && (obj.stateFlags & 0x1) == 0) {
                    obj.stateFlags |= 0x1;
                    int int1 = 24;
                    int int2 = 40;
                    int2 = int1 + random.nextInt(int2) << 12;
                    if (currentLevel == 6) {
                        if (obj.direction == 0) {
                            main.Point pt = obj.position;
                            int int3 = 0;
                            int2 = 16;
                            pt.x = int3 - random.nextInt(int2) << 12;
                            main.Point pt2 = obj.position;
                            int int4 = 170;
                            int2 = 24;
                            pt2.z = int4 + random.nextInt(int2) << 12;
                        } else {
                            main.Point var_q_35_ = obj.position;
                            int i_36_ = 80;
                            int2 = 64;
                            var_q_35_.x = i_36_ + random.nextInt(int2) << 12;
                            main.Point var_q_37_ = obj.position;
                            int i_38_ = obj.position.z;
                            int2 = 100;
                            var_q_37_.z = i_38_ + (random.nextInt(int2) << 12);
                            main.Point var_q_39_ = obj.position;
                            int i_40_ = 150;
                            int2 = 16;
                            var_q_39_.y = i_40_ + random.nextInt(int2) << 12;
                        }
                    } else {
                        main.Point var_q_41_;
                        int i_42_;
                        if (currentLevel == 7) {
                            if (levelTriggerId % 10 == 1) {
                                break;
                            }
                            var_q_41_ = obj.position;
                            i_42_ = g + int2;
                        } else {
                            if ((obj.stateFlags & 0x400) != 0) {
                                break;
                            }
                            var_q_41_ = obj.position;
                            i_42_ = (obj.direction == 0 ? h - int2
                                    : h + 1310720 + int2);
                        }
                        var_q_41_.x = i_42_;
                    }
                }
            } while (false);
            if ((obj.stateFlags & ~0x7fffffff) != 0) {
                obj.clearData();
                enemyObjects.removeElementAt(i_28_);
            } else if ((obj.stateFlags & 0x40000000) != 0) {
                collidableObjects.addElement(obj);
            } else if ((obj.stateFlags & 0x1) != 0
                    && java.lang.Math
                    .abs(obj.position.x - var_q.x) < someVar) {
                if (obj.energy > 0 && obj.position.y >= 0) {
                    ai++;
                }
                u++;
                collidableObjects.addElement(obj);
                V = false;
            }
        }
        for (int i_43_ = miscObjects.size() - 1; i_43_ >= 0; i_43_--) {
            main.AbstractObject var_af;
            if (((var_af = (main.AbstractObject) miscObjects.elementAt(i_43_)).stateFlags
                    & ~0x7fffffff)
                    != 0) {
                var_af.clearData();
                miscObjects.removeElementAt(i_43_);
            } else if ((var_af.stateFlags & 0x40000000) != 0) {
                collidableObjects.addElement(var_af);
            } else if ((var_af.stateFlags & 0x1) != 0
                    && java.lang.Math
                    .abs(var_af.position.x - var_q.x) < 983040) {
                collidableObjects.addElement(var_af);
            }
        }
        for (int i_44_ = collisionMapObjects.size() - 1; i_44_ >= 0; i_44_--) {
            main.CollisionMap var_au;
            if (((var_au = (main.CollisionMap) collisionMapObjects.elementAt(i_44_)).a
                    & ~0x7fffffff)
                    != 0) {
                var_au.d();
                collisionMapObjects.removeElementAt(i_44_);
            }
        }
        if (!Z && !isNormalEnemy && !bool && main.MainCanvas.holdedMainState == -1) {
            main.Main.b = 24;
            if (currentLevel == 7) {
                main.Main.b = 48;
            }
            if (players[0] != null) players[0].w = 6;
            if (players[1] != null) players[1].w = 6; 
            main.GameManager.x();
        }
    }

    public static void c(int i) {
        for (i = 0; i < collidableObjects.size(); i++) {
            main.AbstractObject var_af;
            if (((var_af = (main.AbstractObject) collidableObjects.elementAt(i)).stateFlags
                    & 0x600) != 0
                    && var_af.energy > 0 && (var_af.stateFlags & ~0x7fffffff) == 0) {
                var_af.q = 2;
                var_af.g.set(0, 0, 0);
                var_af.h.set(0, 0, 0);
            }
        }
    }

    private static void x() {
        Z = true;
        aa = 99999;
        k = 64;
        isNormalEnemy = true;
        w = main.GameManager.B() * 100;
        Q = 0;
        bw = 0;
        main.MainCanvas.c();
    }

    public static boolean copCall(int playerId) {
        if (!isCopcallAllowed) {
            return false;
        }
        main.MainCanvas.playerCopCalls[playerId]--;
        if (currentLevel == 6) {
            main.GameManager.b(screenLockX, aq[6][0]);
        } else if (screenLockX > 4587520) {
            main.GameManager.b(screenLockX - 3932160, 491520);
        } else {
            main.GameManager.b(655360, 491520);
        }
        aQ = 0;
        copsBeingCalled = true;
        k = 2;
        aj = 160;
        main.MainCanvas.setState(16);
        return true;
    }

    public static void m() {
        k = 2;
        switch (aQ) {
            case 0:
                aQ++;
            /* fall through */
            case 1:
                if (enforcedScreenPos == null) {
                    int i = currentLevel == 6 ? bi : aS[currentLevel];
                    miscObjects.addElement(new main.MiscObject(aI[0], 0, 655360, i, 0,
                            0, 0, 0));
                    aR = 60;
                    aQ++;
                }
                break;
            case 2:
                if (--aR <= 0) {
                    main.AbstractObject.playSound(24);
                    main.GameManager.b(-1, -1);
                    aQ++;
                }
                break;
            case 3:
                if (enforcedScreenPos == null) {
                    main.GameManager.spawnObject(107, screenLockX - 98304, E[currentLevel] + 131072, 0, 0,
                            0, 0);
                    aR = 44;
                    aQ++;
                }
                break;
            case 4:
                if (aR <= 14) {
                    k = 0;
                }
                if (aR == 14) {
                    aa = -1;
                }
                if (--aR <= 0) {
                    main.GameManager.b(0, 0);
                    copsBeingCalled = false;
                    main.MainCanvas.setState(14);
                    InputController.pl1.resetInput();
                    if (players[0] != null) {
                        players[0].setState(3);
                    }
                    if (players[1] != null) {
                        players[1].setState(3);
                    }
                }
                break;
        }
        boolean bool = aQ < 4 || aQ == 4 && aR > 14;
        for (int i = 0; i < collidableObjects.size(); i++) {
            main.AbstractObject var_af;
            if (((var_af = (main.AbstractObject) collidableObjects.elementAt(i)).stateFlags
                    & 0x700) != 0
                    && var_af.energy > 0 && (var_af.stateFlags & ~0x7fffffff) == 0) {
                if (bool | (var_af.stateFlags & 0x100) != 0) {
                    var_af.q = 2;
                    if (var_af.position.y < 0) {
                        var_af.position.y = 0;
                    }
                    var_af.s = 0;
                    var_af.g.set(0, 0, 0);
                } else {
                    var_af.q = 0;
                }
            }
        }
    }

    public static void initiateGameOverContinueState() {
        gameOverContinueState = 0;
        playerSelection = 0;
        bw = 0;
        Q = 0;
        main.AbstractObject.playSound(17);
    }

    public static void continueSelectionMode() {
        InputController ctrl = (partnerMode != 2 || gameOveredPlayer == 0) ? InputController.pl1 : InputController.pl2;
        int otherPlayer = gameOveredPlayer == 0 ? 1 : 0;
        switch (gameOverContinueState) {
            case 0:
                if (main.MainCanvas.playerContinues[gameOveredPlayer] > 0) {
                    //main.GameManager.clearPl2AndPl3();
                    gameOverContinueVisualState = 0;
                    gameOverContinueState++;
                } else {
                    if (MainCanvas.playerLives[otherPlayer] > 0) {
                        // there's still one player playing
                        MainCanvas.setState(14);
                    }else {
                        main.MainCanvas.setState(19); // game over!
                    }
                    break;
                }
                break;
            case 1: // select gameover / continue
                if (ctrl.pressedExceptSpecials(InputController.ACTION_UP)) {
                    main.AbstractObject.playSound(12);
                    if (--playerSelection < 0) {
                        playerSelection = 1;
                    }
                } else if (ctrl.pressedExceptSpecials(InputController.ACTION_DOWN)) {
                    main.AbstractObject.playSound(12);
                    if (++playerSelection > 1) {
                        playerSelection = 0;
                    }
                } else if (ctrl.pressedExceptSpecials(
                        InputController.ACTION_JUMP
                        | InputController.ACTION_DEF_SPECIAL
                        | InputController.ACTION_PICK_ITEM
                        | InputController.ACTION_SOMETHING_2
                        | InputController.ACTION_STAR
                        | InputController.ACTION_OK
                    ) // 66913
                        || (playerSelection == 0 && MainCanvas.playerIds[gameOveredPlayer] == 3 && random.nextInt(35) == 4) 
                ){
                    if (playerSelection == 0) {
                        main.AbstractObject.playSound(13);
                        playerSelection = main.MainCanvas.playerIds[gameOveredPlayer]-1;
                        gameOverContinueVisualState = 1;
                        gameOverContinueState++;
                    } else {
                        MainCanvas.playerContinues[gameOveredPlayer] = 0;
                        if (MainCanvas.playerLives[otherPlayer] > 0) {
                            // there's still one player playing
                            MainCanvas.setState(14);
                        }else {
                            main.MainCanvas.setState(19); // game over!
                        }
                    }
                }
                break;
            case 2: // select player)
                if (ctrl.pressedExceptSpecials(InputController.ACTION_LEFT)) {
                    main.AbstractObject.playSound(12);
                    if (--playerSelection < 0) {
                        playerSelection = 2;
                    }
                } else if (ctrl.pressedExceptSpecials(InputController.ACTION_RIGHT)) {
                    main.AbstractObject.playSound(12);
                    if (++playerSelection > 2) {
                        playerSelection = 0;
                    }
                }
//                if (partnerMode == 1 && gameOveredPlayer == 1){
//                    playerSelection = 2;
//                }
                if (ctrl.pressedExceptSpecials(
                        InputController.ACTION_JUMP
                        | InputController.ACTION_DEF_SPECIAL
                        | InputController.ACTION_PICK_ITEM
                        | InputController.ACTION_SOMETHING_2
                        | InputController.ACTION_STAR
                        | InputController.ACTION_OK
                    ) // 66913
                    || (playerSelection == 2 && MainCanvas.playerIds[gameOveredPlayer] == 3 && random.nextInt(35) == 4)
                ) {
                    main.MainCanvas.playerIds[gameOveredPlayer] = playerSelection + 1;
                    if (main.MainCanvas.playerContinues[gameOveredPlayer] > 0) {
                        main.MainCanvas.playerScores[gameOveredPlayer] = 0;
                        main.MainCanvas.playerContinues[gameOveredPlayer]--;
                        main.MainCanvas.playerLives[gameOveredPlayer] = 3;
                        main.GameManager.respawnPlayer(gameOveredPlayer);
                        main.MainCanvas.setState(14);
                    } else {
                        if (MainCanvas.playerLives[otherPlayer] > 0) {
                            // there's still one player playing
                            MainCanvas.setState(14);
                        }else {
                            main.MainCanvas.setState(19); // game over!
                        }
                    }
                }
                break;
        }
    }

    public static void drawPlayerSelectHUD(javax.microedition.lcdui.Graphics graphics, int initialTotalOffset) {
        int intVars = main.MainCanvas.playerContinues[gameOveredPlayer];
        switch (gameOverContinueVisualState) {
            case 0:
                main.MainCanvas.drawRegion(graphics, main.MainCanvas.imageStatusAll,
                        initialTotalOffset - 101 + 16, 12, 120, 270, 26, 13);
                main.MainCanvas.drawRegion(graphics, main.MainCanvas.imageStatusAll,
                        initialTotalOffset - 50 + 16, 14, 9 + intVars % 10 * 9, 9,
                        9, 9);
                main.MainCanvas.drawRegion(graphics, main.MainCanvas.imageStatusAll,
                        initialTotalOffset - 101 + 16, 30, 80, 283, 26, 13);
                main.MainCanvas.drawRegion(graphics, main.MainCanvas.imageStatusAll,
                        initialTotalOffset - 62 + 16, 30, 120, 283, 26, 13);
                if (main.GameManager.i % 12 < 8) {
                    main.MainCanvas.drawOptionSelectionFlipped(graphics, initialTotalOffset - 132 + 16,
                            playerSelection == 0 ? 15 : 31);
                }
                break;
            case 1: {
                intVars = playerSelection + 1; //playerSelection == 0 ? 1 : 2;
                int srcX1 = aN[intVars][0];
                int srcY1 = aN[intVars][1];
                int srcX2 = objNameOffsets[intVars][0]; //* 43;
                int srcY2 = objNameOffsets[intVars][1]; //* 13 + 67;
                int width = objNameOffsets[intVars][2];
                // icon
                main.MainCanvas.drawRegion(graphics, main.MainCanvas.imageStatusAll,
                        initialTotalOffset - 86, 21, srcX1, srcY1, 20, 20);
                // name
                main.MainCanvas.drawRegion(graphics, main.MainCanvas.imageStatusAll,
                        initialTotalOffset - 90, 43, srcX2, srcY2, width, 13);
                if (main.GameManager.i % 12 < 8) {
                    main.MainCanvas.setRegionRotation(1);
                    main.MainCanvas.drawRegion(graphics, main.MainCanvas.imageStatusAll,
                            initialTotalOffset - 102, 28, 204, 185, 8, 7);
                    main.MainCanvas.setRegionRotation(0);
                    main.MainCanvas.drawRegion(graphics, main.MainCanvas.imageStatusAll,
                            initialTotalOffset - 60, 28, 204, 185, 8, 7);
                }
                break;
            }
        }
    }

    public static void a(javax.microedition.lcdui.Graphics graphics, int i,
            int i_51_, int i_52_, int i_53_, int i_54_, int i_55_, int destY) {
        int destX = aN[destY][0];
        destY = aN[destY][1];
        if (i_55_ < 0) {
            i_55_ = 0;
        } else if (i_55_ > 2) {
            i_55_ = 2;
        }
        main.GameManager.drawScore(graphics, i - 88, i_51_, i_52_, false, false,
                2);
        main.GameManager.drawScore(graphics, i - 20, i_51_, i_53_, false, false,
                7);
        main.GameManager.drawScore(graphics, i - -8, i_51_, i_54_, false, false,
                1);
        main.MainCanvas.drawRegion(graphics, main.MainCanvas.imageStatusAll,
                i - -45 - aW[i_55_][2] / 2, i_51_ - 2,
                aW[i_55_][0], aW[i_55_][1], aW[i_55_][2], aW[i_55_][3]);
        main.MainCanvas.drawRegion(graphics, main.MainCanvas.imageStatusAll, i - -80,
                i_51_ - 8, destX, destY, 20, 20);
    }

    private static void a(int i, int i_58_) {
        for (int i_59_ = 0; i_59_ < enemyObjects.size(); i_59_++) {
            main.AbstractObject var_af;
            if ((var_af = (main.AbstractObject) enemyObjects.elementAt(i_59_)) != null
                    && (var_af.objectType == i || var_af.objectType == i_58_)) {
                var_af.markToDie();
            }
        }
    }

    private static void removeSubBossesInvincibility() {
        for (int i = 0; i < collidableObjects.size(); i++) {
            main.AbstractObject obj;
            (obj = (main.AbstractObject) collidableObjects.elementAt(i)).stateFlags &= ~AbstractObject.INVINCIBILITY_FLAG;
        }
    }

    public static void releaseDataForCharacter(int i) {
        main.ImageUtils.releaseImages(charSpriteImages[i]);
        main.ImageUtils.releaseImages(I[i]);
        main.ImageUtils.releaseImages(J[i]);
    }

    private static void clearDataForCharacter(int i) {
        if (charSpriteImages[i] != null) {
            main.ImageUtils.releaseImages(charSpriteImages[i]);
            charSpriteImages[i] = null;
        }
        if (charsArt[i] != null) {
            charsArt[i].clearData();
            charsArt[i] = null;
        }
        if (I[i] != null) {
            main.ImageUtils.releaseImages(I[i]);
            I[i] = null;
        }
        if (aA[i] != null) {
            aA[i].clearData();
            aA[i] = null;
        }
        if (J[i] != null) {
            main.ImageUtils.releaseImages(J[i]);
            J[i] = null;
        }
        if (aB[i] != null) {
            aB[i].clearData();
            aB[i] = null;
        }
    }

    private static void z() {
        ag++;
        Y = false;
        h = aq[7][ag];
        Q = 32;
        if ((t += 1439) > 4752) {
            t = 4752;
        }
    }

    private static void b(int i, int i_60_) {
        if (i == -1 && i_60_ == -1) {
            enforcedScreenPos = new main.Point2D(bfPt.x, bfPt.y);
            bfPt = null;
            bg = bh;
            bh = -1;
        } else if (i == 0 && i_60_ == 0) {
            enforcedScreenPos = null;
            bfPt = null;
            bg = -1;
            bh = -1;
        } else {
            bfPt = new main.Point2D(screenLockX, screenLockY);
            bh = S;
            if (currentLevel == 6) {
                enforcedScreenPos = new main.Point2D(screenLockX, screenLockY + (i_60_ - S));
                bg = aq[6][0];
                bi = enforcedScreenPos.y + 565248;
            } else {
                enforcedScreenPos = new main.Point2D(i, i_60_);
            }
        }
        be = false;
    }

    public static void update() {
        main.AbstractObject pl1 = players[0];
        main.AbstractObject pl2 = players[1];
        main.AbstractObject obj;
        isCopcallAllowed = (currentLevel == 6 && !bc ? false : copsBeingCalled || currentLevel > 6 ? false
                : main.MainCanvas.mainState != 14 ? false
                : (pl1 == null && pl2 == null ? false
                : (pl1 != null && pl1.energy > 0 && pl1.position.y == 0 && (pl1.stateFlags & ~0x7fffffff) == 0)
                || (pl2 != null && pl2.energy > 0 && pl2.position.y == 0 && (pl2.stateFlags & ~0x7fffffff) == 0)
                )
        );
        if (!be) {
            if (enforcedScreenPos != null) {
                if (currentLevel == 6) {
                    screenLockY = main.ImageUtils.a(screenLockY, enforcedScreenPos.y, 3, 327680);
                    S = main.ImageUtils.a(S, bg, 3, 327680);
                    if (screenLockY == enforcedScreenPos.y) {
                        be = true;
                        enforcedScreenPos = null;
                    }
                } else if ((screenLockX = main.ImageUtils.a(screenLockX, enforcedScreenPos.x, 3, 327680)) == enforcedScreenPos.x) {
                    be = true;
                    enforcedScreenPos = null;
                }
            } else {
                int currLevel = currentLevel;
                if (main.Main.b > 1) {
                    for (int i = 0; i < collidableObjects.size(); i++) {
                        if (((obj
                                = (main.AbstractObject) collidableObjects.elementAt(i)).stateFlags
                                & 0x400) != 0
                                && (obj.stateFlags & ~0x7fffffff) == 0) {
                            pl1 = obj; // pick dying boss to use as screen scroll
                        }
                    }
                }
                if (pl1 != null || pl2 != null) {
                    
                    // Screen lock based on players positions
                    int posX = 0;
                    int posY = 0;
                    
                    if (pl1 != null){
                        posX += pl1.position.x;
                        posY += pl1.position.y;
                    }
                    if (pl2 != null){
                        posX += pl2.position.x;
                        posY += pl2.position.y;
                        if (pl1 != null) {
                            posX *= 0.5;
                            posY *= 0.5;
                        }
                    }
                    
                    if (enforcedScreenPos != null) {
                        posX = enforcedScreenPos.x;
                        posY = enforcedScreenPos.y;
                    }
                    int i_66_ = 0;
                    int i_67_ = -65536;
                    if (screenWidth < 320) {
                        if (currentLevel == 7) {
                            i_66_ = 131072;
                            i_67_ = 65536;
                        } else if (currentLevel == 6) {
                            i_66_ = 0;
                            i_67_ = 0;
                        } else {
                            i_66_ = -65536;
                            i_67_ = -131072;
                        }
                    }
                    if (isNormalEnemy) {
                        i_66_ = 0;
                        i_67_ = 0;
                    }
                    i_66_ += screenLockX;
                    i_67_ += screenLockX;
                    int i_68_ = 0 + screenLockY;
                    if (pl1 != null || pl2 != null) {
                        if (posX > i_66_) {
                            int i_69_;
                            if ((i_69_ = (posX - i_66_) / 6) > 327680) {
                                i_69_ = 327680;
                            }
                            screenLockX += i_69_;
                        }
                        if (posX < i_67_) {
                            int i_70_;
                            if ((i_70_ = (posX - i_67_) / 6) > 327680) {
                                i_70_ = 327680;
                            }
                            screenLockX += i_70_;
                        }
                        if (i_68_ < posY) {
                            screenLockY += (posY - i_68_) / 5;
                        }
                    }
                    if (currentLevel == 7 && levelTriggerId < 92 && screenLockX < 655360) {
                        screenLockX = 655360;
                    }
                    int i_71_ = halfScreenWidth12Left;
                    posX = halfScreenHeight12Left;
                    if (currLevel == 7) {
                        if (g > screenLockX + 655360) {
                            g = screenLockX + 655360;
                        }
                        if (g < h + 1310720) {
                            g = h + 1310720;
                        }
                    } else {
                        if (h < screenLockX - 655360) {
                            h = screenLockX - 655360;
                        }
                        if (h > g - 1310720) {
                            h = g - 1310720;
                        }
                    }
                    if (main.Main.b > 1 && currLevel < 6) {
                        h = 0;
                        g = ar[currentLevel];
                    }
                    if (screenLockX < i_71_) {
                        screenLockX = i_71_;
                    }
                    if (screenLockX + i_71_ > g) {
                        if (currLevel != 7) {
                            Y = true;
                        }
                        screenLockX = g - i_71_;
                    }
                    if (screenLockX - i_71_ < h) {
                        if (currLevel == 7) {
                            Y = true;
                        }
                        screenLockX = h + i_71_;
                    }
                    if (screenLockY < posX) {
                        screenLockY = posX;
                    }
                    if (screenLockY + posX > T) {
                        screenLockY = T - posX;
                    }
                }
            }
        }
        G.a(screenLockX, screenLockY);
        if (currentLevel == 4) {
            G.a(0, false);
            G.a(1, false);
            G.a(2, false);
            bj += 2048;
            bk += 4096;
            bl += 8192;
            G.a(0, 655360 + bj % 2867200, -1);
            G.a(1, 655360 + bk % 163840, -1);
            G.a(2, 655360 + bl % 163840, -1);
        } else if (currentLevel == 6) {
            bc = false;
            switch (lvl6ElevatorState) {
                case 0:
                    aY = 0;
                    aZ = 0;
                    ba = 48;
                    bb = false;
                    bc = false;
                    S = aq[6][aZ];
                    lvl6ElevatorState++;
                    break;
                case 1:
                    if (--ba > 0) {
                        break;
                    }
                    lvl6ElevatorState++;
                /* fall through */
                case 2:
                    main.GameManager.c();
                    if (pl1 != null) {
                        pl1.stateFlags |= 0x400000;
                    }
                    if (pl2 != null) {
                        pl2.stateFlags |= 0x400000;
                    }
                    main.AbstractObject.playSound(18);
                    aZ++;
                    ba = 5;
                    lvl6ElevatorState++;
                    break;
                case 3:
                    if (ba <= 0 || --ba <= 0) {
                        if ((aY -= 10240) < -65536) {
                            aY = -65536;
                            lvl6ElevatorState++;
                        }
                        S += aY;
                        main.GameManager.u();
                    }
                    break;
                case 4: {
                    int i;
                    if (java.lang.Math.abs(i = aq[6][aZ] - S)
                            < 2048) {
                        S = aq[6][aZ];
                        main.AbstractObject.playSound(19);
                        if (pl1 != null) {
                            pl1.stateFlags &= ~0x400000;
                        }
                        if (pl2 != null) {
                            pl2.stateFlags &= ~0x400000;
                        }
                        j = false;
                        lvl6ElevatorState++;
                    } else {
                        aY = i / 8;
                        if (java.lang.Math.abs(i) > 32768) {
                            main.GameManager.u();
                        }
                        if (aY < -65536) {
                            aY = -65536;
                        }
                        S += aY;
                    }
                    break;
                }
                case 5:
                    if (bb) {
                        n = 2;
                        bb = false;
                        if (aq[6][aZ + 1] > 0) {
                            lvl6ElevatorState = 2;
                        } else {
                            lvl6ElevatorState++;
                        }
                    } else if (ai == 0) {
                        bc = false;
                    } else {
                        bc = true;
                    }
                    break;
                case 6:
                    if (main.GameManager.C()) {
                        lvl6ElevatorState++;
                    }
                    break;
                case 7:
                    // Elevator end
                    if (!Z && V && main.MainCanvas.holdedMainState == -1) {
                        main.GameManager.x();
                        for (int i = 0 ; i < players.length ; ++i){
                            if ((players[i]) != null) {
                                players[i].setTargetPosition(-196608, 614400 - 100000*i);
                            }
                        }
                    }
                    break;
            }
            G.a(0, -1, S);
        }
        for (int i = 0; i < collisionMapObjects.size(); i++) {
            main.CollisionMap var_au;
            if ((java.lang.Math.abs((var_au = (main.CollisionMap) collisionMapObjects.elementAt(i)).b.x - screenLockX))
                    <= 1179648) {
                try {
                    var_au.b();
                } catch (java.lang.Exception exception) {
                    java.lang.Exception exception_73_;
                    (exception_73_ = exception).printStackTrace();
                }
            }
        }
        for (int i = 0; i < collidableObjects.size(); i++) {
            obj = (main.AbstractObject) collidableObjects.elementAt(i);
            try {
                obj.update(); // update character controller
            } catch (java.lang.Exception exception) {
                java.lang.Exception exception_74_;
                (exception_74_ = exception).printStackTrace();
            }
        }
        for (int i = 0 ; i < 2 ; ++i) { // do not check this for pl3
            if (players[i] != null) {
                players[i].checkScreenBoundsAndCopCall(i);
                if (i == 0) InputController.pl1.setCharacterDirection(players[i].direction);
                else if (i == 1) InputController.pl2.setCharacterDirection(players[i].direction);
            }
        }
    }

    private static boolean b(main.AbstractObject var_af) {
        if ((var_af.stateFlags & 0x600) == 0) {
            return false;
        }
        if (var_af.energy <= 0) {
            return false;
        }
        if ((var_af.stateFlags & ~0x77fffffb) != 0) {
            return false;
        }
        if ((var_af.stateFlags & 0x40000000) != 0 && var_af.t() > 745472) {
            return false;
        }
        return true;
    }

    public static void q() {
        int levelDirection = currentLevel == 6 ? 1 : 0;
        if (aa == -1) {
            for (int i = 0; i < collidableObjects.size(); i++) {
                main.AbstractObject obj;
                if (main.GameManager.b(obj = ((main.AbstractObject) collidableObjects.elementAt(i)))) {
                    if ((obj.stateFlags & 0x400) != 0) {
                        obj.onAttackContact(null, 9, 2, levelDirection, 3000);
                        obj.y = 2;
                    } else if ((obj.stateFlags & 0x200) != 0) {
                        obj.onAttackContact(null, 9, 2, levelDirection, 99999);
                    }
                }
            }
            aa = 0;
        } else if (aa > 0) {
            for (int i = 0; i < collidableObjects.size(); i++) {
                main.AbstractObject obj;
                if (main.GameManager.b(obj = ((main.AbstractObject) collidableObjects.elementAt(i)))) {
                    if ((obj.stateFlags & 0x400) != 0 && obj.energy <= aa) {
                        obj.onAttackContact(null, 9, 2, levelDirection, 0);
                    } else {
                        obj.onAttackContact(null, 9, 2, levelDirection, aa);
                    }
                }
            }
            aa = 0;
        } else if (!copsBeingCalled) {
            for (int i = 0; i < collidableObjects.size(); i++) {
                main.AbstractObject obj = (main.AbstractObject) collidableObjects.elementAt(i);
                try {
                    if (obj.energy > 0) {
                        obj.checkHammerSmash();
                    }
                } catch (java.lang.Exception exception) {
                    exception.printStackTrace();
                }
            }
        }
    }

    public static void r() {
        bq = 0;
        br = 0;
        bs = 0;
        aj = 0;
    }

    public static void e(int i) {
        br = i;
        bq = 0;
    }

    private static void A() {
        int i;
        if (currentLevel == 7) {
            i = g + 98304;
        } else {
            boolean bool = (bq & 0x1) == 0;
            if (!Y) {
                bool = true;
            }
            i = bool ? h + 1409024 : h - 98304;
        }
        int i_79_ = i;
        int i_80_ = E[currentLevel] + (bq % 4 * 40 << 12);
        int i_81_ = bo[currentLevel].length;
        main.AbstractObject var_af
                = ((main.AbstractObject) main.GameManager.spawnObject(i_81_ = bo[currentLevel][++bq % i_81_], i_79_,
                        i_80_, 0, 1, 0, 0));
        if (currentDifficulty == 0 && var_af != null && var_af.objectType == 4) {
            var_af.stateFlags |= 0x800000;
        }
        aj = bt[currentDifficulty];
    }

    private static int B() {
        return (t + 47) / 48;
    }

    // This method is some sort of update
    public static void s() {
        main.GameManager.i++;
        U++;
        if (n > 0) {
            n--;
        }
        boolean bool = currentLevel == 6 && j;

        if (players[0] != null || players[1] != null) {
            int int1 = main.GameManager.B();
            if (k > 0) {
                k--;
            } else if (!copsBeingCalled && t > 0 && !Z && !bool) {
                t--;
            }
            int i_82_;
            if ((i_82_ = main.GameManager.B()) < 10 && int1 != i_82_
                    && i_82_ > 0) {
                main.AbstractObject.playSound(12);
            }
            if (t == 0 && players[0] != null && players[0].energy > 0) {
                main.AbstractObject.playSound(17);
                players[0].onAttackContact(null, -9, 2, players[0].direction, 99999);
            }
            if (t == 0 && players[1] != null && players[1].energy > 0) {
                main.AbstractObject.playSound(17);
                players[1].onAttackContact(null, -9, 2, players[1].direction, 99999);
            }
        }
        if (bw > 0) {
            bw--;
        }
        if (Q > 0) {
            Q--;
        }
        if (bw > 0 || Q > 0) {
            if ((main.GameManager.i & 0x7) == 0) {
                main.AbstractObject.playSound(14);
            }
            n = 2;
            aj = 160;
        }
        for (int i = 0; i < collidableObjects.size(); i++) {
            main.AbstractObject var_af;
            (var_af = (main.AbstractObject) collidableObjects.elementAt(i)).g();
        }
        if (k <= 0 && !copsBeingCalled && bo[currentLevel] != null && main.MainCanvas.mainState == 14) {
            if (bs > 0) {
                if ((aj -= 4) < 0 && u < 3 + bu[currentDifficulty]) {
                    bs--;
                    main.GameManager.A();
                }
            } else if (br > 0) {
                if ((aj -= 3) < 0 && u < bu[currentDifficulty]) {
                    br--;
                    main.GameManager.A();
                }
            } else if (bp[currentLevel] && !Y && u < 2 && --aj < 0) {
                main.GameManager.A();
            }
        }
        ae += 1263;
        ad = 5 - ae % 10 << 12;
        if (af > 0) {
            af = af * 97 / 100;
        }
        main.Point2D var_m = new main.Point2D(0, 0);
        if (ac > 0) {
            var_m.x = 0;
            if (af < 0) {
                var_m.y = (main.GameManager.i & 0x2) << 11;
            } else {
                var_m.y = ad;
            }
            ac--;
        }
        main.ar.setPair(0, var_m);
        if (currentLevel == 1) {
            if ((main.GameManager.i & 0x7) == 0) {
                bn++;
            }
            int i;
            switch (i = bm[bn % bm.length]) {
                case 0:
                    G.a(au[1], 1, 20, 20);
                    break;
                case 1:
                    G.a(av[0], 1, 20, 20);
                    break;
                case 2:
                    G.a(av[1], 1, 20, 20);
                    break;
                case 3:
                    G.a(av[2], 1, 20, 20);
                    break;
            }
        }
        if (currentLevel == 7) {
            // stage 7 triggers
            switch (levelTriggerId) {
                case 0:
                    Y = false;
                /* fall through */
                default:
                    if (V) {
                        levelTriggerId++;
                    }
                    break;
                case 9:
                    if (Y) {
                        main.GameManager.loadCharacterArt(10, 1, false);
                        main.Antonio var_al;
                        (var_al
                                = new main.Antonio(aA[10], 1, screenLockX + 819200,
                                        901120, 0, 0, 10)).stateFlags
                                |= 0x40000200;
                        enemyObjects.addElement(var_al);
                        levelTriggerId++;
                    }
                    break;
                case 10:
                    if (!main.GameManager.c(10, -1)) {
                        main.GameManager.clearDataForCharacter(10);
                        main.GameManager.spawnObject(35, 16322560, 729088, 0, 1, 11,
                                0);
                        main.GameManager.spawnObject(35, 10612736, 942080, 0, 1, 42,
                                0);
                        main.GameManager.loadCharacterArt(11, 1, false);
                        main.Souther var_ac;
                        (var_ac = new main.Souther(aA[11], 1, 14827520,
                                770048, 0, 0, 19)).stateFlags
                                |= 0x48000200;
                        enemyObjects.addElement(var_ac);
                        main.GameManager.z();
                        levelTriggerId++;
                    }
                    break;
                case 19:
                    // Activate lvl7 Souther
                    if (Y && V) {
                        main.GameManager.removeSubBossesInvincibility();
                        levelTriggerId++;
                    }
                    break;
                case 20:
                    if (!main.GameManager.c(11, -1)
                            && !main.GameManager.k(20)) {
                        main.GameManager.clearDataForCharacter(11);
                        main.GameManager.z();
                        levelTriggerId++;
                    }
                    break;
                case 29:
                    if (Y && V) {
                        Q = 32;
                        levelTriggerId++;
                    }
                    break;
                case 30:
                    if (!main.GameManager.k(30)) {
                        main.GameManager.loadCharacterArt(12, 0, false);
                        main.Bongo var_h;
                        (var_h = new main.Bongo(charsArt[12], 1, screenLockX - 819200,
                                737280, 0, 0, 40)).stateFlags
                                |= 0x40000200;
                        enemyObjects.addElement(var_h);
                        levelTriggerId++;
                    }
                    break;
                case 40:
                    if (!main.GameManager.c(12, -1)) {
                        main.GameManager.clearDataForCharacter(12);
                        main.GameManager.z();
                        levelTriggerId++;
                    }
                    break;
                case 42:
                    if (Y && V) {
                        main.GameManager.a(5, 9);
                        main.GameManager.a(8, 8);
                        main.GameManager.clearDataForCharacter(9);
                        main.GameManager.clearDataForCharacter(5);
                        main.GameManager.clearDataForCharacter(8);
                        java.lang.System.gc();
                        main.GameManager.z();
                        levelTriggerId++;
                    }
                    break;
                case 50:
                    if (!main.GameManager.k(50)) {
                        main.GameManager.loadCharacterArt(13, 2, false);
                        main.Onihime var_z;
                        (var_z = new main.Onihime(aB[13], 1, 6021120,
                                778240, 0, 0, 58, 2)).stateFlags
                                |= 0x48000200;
                        enemyObjects.addElement(var_z);
                        main.GameManager.loadCharacterArt(14, 2, false);
                        (var_z = new main.Onihime(aB[14], 1, 5857280,
                                901120, 0, 0, 59, 1)).stateFlags
                                |= 0x48000200;
                        enemyObjects.addElement(var_z);
                        main.GameManager.z();
                        levelTriggerId++;
                    }
                    break;
                case 59:
                    // lvl7 Activate Yasha / Onihime
                    if (Y) {
                        main.GameManager.removeSubBossesInvincibility();
                        levelTriggerId++;
                    }
                    break;
                case 60:
                    if (!main.GameManager.c(14, 13)) {
                        main.GameManager.deactivate3rdAdam();
                    }
                    if (!main.GameManager.k(60)) {
                        main.GameManager.clearDataForCharacter(13);
                        main.GameManager.clearDataForCharacter(14);
                        main.GameManager.spawnObject(35, 5255168, 696320, 0, 1, 61, 0);
                        main.GameManager.spawnObject(35, 4161536, 897024, 0, 1, 61, 0);
                        main.GameManager.spawnObject(34, 3420160, 933888, 0, 0, 62, 0);
                        main.GameManager.spawnObject(34, 2437120, 847872, 0, 0, 62, 0);
                        main.GameManager.deactivate3rdAdam();
                        main.GameManager.z();
                        levelTriggerId++;
                    }
                    break;
                case 70: // spawn Harakiri
                    if (V) {
                        main.GameManager.loadCharacterArt(15, 1, false);
                        main.Harakiri var_ap;
                        (var_ap = new main.Harakiri(aA[15], 1, 1925120,
                                901120, 0, 0, 71)).stateFlags
                                |= 0x48000200;
                        enemyObjects.addElement(var_ap);
                        main.GameManager.z();
                        levelTriggerId++;
                    }
                    break;
                case 79:
                    // Stage 7 Activate Harakiri
                    if (Y && V) {
                        main.GameManager.removeSubBossesInvincibility();
                        levelTriggerId++;
                    }
                    break;
                case 80: // Spawn Mr.X
                    if (!main.GameManager.k(80)) {
                        main.GameManager.clearDataForCharacter(15);
                        java.lang.System.gc();
                        main.GameManager.loadCharacterArt(17, 0, false);
                        main.MrX mrX;
                        (mrX = new main.MrX(charsArt[17], 0, 655360, 688128, 0, 0, 99)).stateFlags |= 0x48080001;
                        bossObjects.addElement(mrX);
                        isNormalEnemy = false;
                        main.GameManager.z();
                        levelTriggerId++;
                    }
                    break;
                case 85: { // Mr.X entrance
                    k = 2;
                    for (int i = 0 ; i < 2 ; ++i) {
                        if (players[i] != null) {
                            players[i].setTargetPosition(532480 + 100000 * i, 778240);
                        }
                    }
                    if (players[0] != null || players[1] != null){
                        levelTriggerId++;
                    }
                    break;
                }
                case 86:
                    k = 2;
                    levelTriggerId++;
                    break;
                case 87: {
                    // Mr.X triggered here
                    boolean triggerCondition = false;
                    if (players[0] != null && players[0].position.x <= 536576) {
                        players[0].direction = 0;
                        triggerCondition = true;
                    }
                    if (players[1] != null && players[1].position.x <= 636576) {
                        players[1].direction = 0;
                        triggerCondition = true;
                    }
                    if (triggerCondition) {
                        main.MainCanvas.initializeMrX();
                        levelTriggerId++;
                    }
                    break;
                }
                case 99:
                /* empty */
            }
        } else if (currentLevel != 0) {
            if (aq[currentLevel][ag] < 0) {
                if (!W && main.GameManager.C()) {
                    n = 2;
                    for (int i = 0; i < bossObjects.size(); i++) {
                        ((main.AbstractObject) bossObjects.elementAt(i)).stateFlags |= 0x1;
                    }
                    main.AudioController.loadLevelMidi(8, true);
                    aj = 96;
                    W = true;
                }
            } else if (V && !j && (currentLevel > 5 || levelTriggerId % 10 != 0 || Y)) {
                levelTriggerId++;
                if (currentLevel == 2 && levelTriggerId == 31) {
                    main.GameManager.deactivate3rdAdam();
                } else if (currentLevel == 5 && levelTriggerId == 21) {
                    main.GameManager.deactivate3rdAdam();
                }
                if (levelTriggerId % 10 == 1) {
                    ag++;
                    Y = false;
                    int i;
                    if ((i = aq[currentLevel][ag]) != -1) {
                        if (currentLevel == 6) {
                            bb = true;
                            j = true;
                        } else {
                            if ((t += 1439) > 4752) {
                                t = 4752;
                            }
                            g = i;
                            bw = 32;
                        }
                    }
                }
            }
        }
        main.CollisionMap.c = 0;
    }

    public static void drawHUD(javax.microedition.lcdui.Graphics graphics) {
        main.ar.clearVector1();
        if (G != null) {
            G.a();
        }
        if (currentLevel == 2) {
            int i = screenWidth / 2 - 80 - (screenLockX >> 12) % 160;
            int i_83_ = screenHeight / 2 - 20 + 240 - (screenLockY >> 12);
            aw[0].b(i << 12, i_83_ << 12);
            aw[1].b(i + 160 << 12, i_83_ << 12);
            aw[2].b(i + 320 << 12, i_83_ << 12);
            i_83_ = screenHeight / 2 - 16 + 240 - (screenLockY >> 12);
            aw[3].b(i << 12, i_83_ << 12);
            aw[4].b(i + 160 << 12, i_83_ << 12);
            aw[5].b(i + 320 << 12, i_83_ << 12);
            for (i = 0; i < aw.length; i++) {
                if (aw[i] != null) {
                    main.ar.addElementToVector1(aw[i]);
                }
            }
        }
        for (int i = 0; i < collidableObjects.size(); i++) {
            ((main.AbstractObject) collidableObjects.elementAt(i)).b();
        }
        for (int i = 0; i < collisionMapObjects.size(); i++) {
            main.CollisionMap var_au;
            if ((java.lang.Math.abs((var_au = (main.CollisionMap) collisionMapObjects.elementAt(i)).b.x - screenLockX))
                    < 1179648) {
                var_au.c();
            }
        }
        main.MainCanvas.setRegionRotation(0);
        graphics.setClip(0, 0, screenWidth, screenHeight);
        if (currentLevel == 2) {
            graphics.setColor(36, 42, 61);
            graphics.fillRect(0, 0, screenWidth, 150);
        }
        if (currentLevel == 6) {
            int i = ((S >> 12) - 162) / au[4].getHeight();
            int i_84_ = (java.lang.Math.min((((S >> 12) - 162 + main.MainCanvas.screenClipHeigh - 1)
                    / au[4].getHeight()),
                    18));
            for (i = i; i <= i_84_; i++) {
                if (i == 0) {
                    graphics.drawImage(au[5], 80 - (screenLockX - halfScreenWidth12Left >> 12),
                            -(S >> 12) + 162, 0);
                } else {
                    graphics.drawImage(au[4], 80 - (screenLockX - halfScreenWidth12Left >> 12),
                            i * au[4].getHeight() - (S >> 12) + 162,
                            0);
                }
            }
        }
        if (currentLevel == 7) {
            graphics.setColor(main.MainCanvas.rgbValue(0, 0, 0));
            graphics.fillRect(0, screenHeight - 3, screenWidth, 3);
        }
        main.ar.b(graphics);
        javax.microedition.lcdui.Graphics graphics_85_
                = graphics;
        int int1 = screenWidth / 2 - 120;
        int int2 = 4;
        int offsetX = int1;
        graphics = graphics_85_;
        
        
        // central Clock
        main.MainCanvas.drawRegion(graphics, main.MainCanvas.imageStatusAll,
                offsetX + 105, 16, 0, 35, 30, 32);
        int i_88_;
        if ((i_88_ = main.GameManager.B()) > 9
                || main.GameManager.i % 8 < 7 || i_88_ == 0) {
            int i_89_ = i_88_ / 10;
            i_88_ %= 10;
            main.MainCanvas.drawRegion(graphics, main.MainCanvas.imageStatusAll,
                    offsetX + 109, 27, 0 + i_89_ * 12, 18,
                    12, 17);
            main.MainCanvas.drawRegion(graphics, main.MainCanvas.imageStatusAll,
                    offsetX + 119, 27, 0 + i_88_ * 12, 18,
                    12, 17);
        }
        
        // Player 1 HUD
        if (players[0] != null) {
            // cop calls
            if (currentLevel != 7) {
                main.MainCanvas.drawRegion(graphics, main.MainCanvas.imageStatusAll,
                        offsetX + 4, 7, 99, 2, 20, 16);
                main.MainCanvas.drawRegion(graphics, main.MainCanvas.imageStatusAll,
                        offsetX + 24, 14,
                        9 + main.MainCanvas.playerCopCalls[0] * 9,
                        9, 9, 9);
            }
            // score
            main.GameManager.drawScore(graphics, offsetX + 104, 4,
                    main.MainCanvas.playerScores[0], true, false,
                    7);
            main.MainCanvas.drawRegion(graphics, main.MainCanvas.imageStatusAll,
                    offsetX + 70, 26, 91, 2, 7, 7);
            main.MainCanvas.drawRegion(graphics, main.MainCanvas.imageStatusAll,
                    offsetX + 77, 18, 0 + main.MainCanvas.playerLives[0] * 12,
                    18, 12, 17);
            if (bw > 0 && (main.GameManager.i & 0x4) != 0) {
                main.MainCanvas.drawRegion(graphics, main.MainCanvas.imageStatusAll,
                        offsetX + 193, 68, 30, 48, 37, 19);
            }
            if (Q > 0 && (main.GameManager.i & 0x4) != 0) {
                main.MainCanvas.drawRegion(graphics, main.MainCanvas.imageStatusAll,
                        offsetX + 11, 68, 67, 48, 35, 19);
            }
            if (objsInHUD[0] != null) {
                if ((objsInHUD[0].stateFlags & 0x1) == 0) {
                    objsInHUD[0] = null;
                } else if ((objsInHUD[0].stateFlags & ~0x7fffffff) != 0) {
                    objsInHUD[0] = null;
                } else {
                    if (partnerMode == 0){
                        main.GameManager.drawHudEnergy(graphics, offsetX, 4, true, objsInHUD[0]);
                    }else {
                        main.GameManager.drawHudEnergy(graphics, offsetX, 24, false, objsInHUD[0]);
                    }
                }
            }
            main.GameManager.drawHudEnergy(graphics, offsetX, 4, false, players[0]);
        }
        
        
        // Player 2 HUD

        if (players[1] != null) {
            //int rightOffset = 135;
            int width = 240;

            if (currentLevel != 7) {
                // Cop calls
                main.MainCanvas.drawRegion(graphics, main.MainCanvas.imageStatusAll,
                        width - offsetX - 33, 7, 99, 2, 20, 16);
                main.MainCanvas.drawRegion(graphics, main.MainCanvas.imageStatusAll,
                        width - offsetX - 13, 14,
                        9 + main.MainCanvas.playerCopCalls[1] * 9,
                        9, 9, 9);
            }
            main.GameManager.drawScore(graphics, offsetX + 196, 4,
                    main.MainCanvas.playerScores[1], true, false,
                    7);
            // lives:
            main.MainCanvas.drawRegion(graphics, main.MainCanvas.imageStatusAll,
                    width - (offsetX + 77 + 7), 26, 91, 2, 7, 7);
            main.MainCanvas.drawRegion(graphics, main.MainCanvas.imageStatusAll,
                    width - (offsetX + 70 + 7), 18, 0 + main.MainCanvas.playerLives[1] * 12, 18, 12, 17);
            /*
            if (bw > 0 && (main.GameManager.i & 0x4) != 0) {
                main.MainCanvas.drawRegion(graphics, main.MainCanvas.imageStatusAll,
                        width - (offsetX + 193), 68, 30, 48, 37, 19);
            }
            if (Q > 0 && (main.GameManager.i & 0x4) != 0) {
                main.MainCanvas.drawRegion(graphics, main.MainCanvas.imageStatusAll,
                        width - (offsetX + 11), 68, 67, 48, 35, 19);
            }*/
            // TODO: obj for pl2
            if (objsInHUD[1] != null) {
                if ((objsInHUD[1].stateFlags & 0x1) == 0) {
                    objsInHUD[1] = null;
                } else if ((objsInHUD[1].stateFlags & ~0x7fffffff) != 0) {
                    objsInHUD[1] = null;
                } else {
                    main.GameManager.drawHudEnergy(graphics, offsetX, 24, true, objsInHUD[1]);
                }
            }
            main.GameManager.drawHudEnergy(graphics, offsetX, 4, true, players[1]);
        }
        
    }

    private static int drawScore(javax.microedition.lcdui.Graphics graphics, int i,
            int i_90_, int i_91_, boolean bool, boolean bool_92_, int i_93_) {
        if (bool_92_) {
            i -= 13;
            main.MainCanvas.drawRegion(graphics, main.MainCanvas.imageStatusAll, i,
                    i_90_ - 2, 0, 244, 13, 13);
            i -= 5;
        }
        int i_94_ = i;
        int i_95_;
        for (i_95_ = 0; i_95_ < i_93_; i_95_++) {
            i -= 9;
            int i_96_ = i_91_ % 10;
            i_91_ /= 10;
            main.MainCanvas.drawRegion(graphics, main.MainCanvas.imageStatusAll, i,
                    i_90_, 9 + i_96_ * 9, 9, 9, 9);
            if (i_91_ == 0) {
                break;
            }
        }
        if (bool) {
            for (i_91_ = 0; i_91_ < i_93_ - 1 - i_95_; i_91_++) {
                i -= 9;
                main.MainCanvas.drawRegion(graphics, main.MainCanvas.imageStatusAll,
                        i, i_90_, 0, 9, 9, 9);
            }
        }
        return i_94_ - i_93_ * 9 - 5;
    }

    public static int a(javax.microedition.lcdui.Graphics graphics, int i,
            int i_97_, int i_98_) {
        if (i_98_ == 0) {
            for (i_97_ = 0; i_97_ < 7; i_97_++) {
                javax.microedition.lcdui.Graphics graphics_99_
                        = graphics;
                javax.microedition.lcdui.Image image
                        = main.MainCanvas.imageStatusAll;
                i -= 9;
                main.MainCanvas.drawRegion(graphics_99_, image, i, 5, 0, 9, 9,
                        9);
            }
            return i;
        }
        return main.GameManager.drawScore(graphics, i, 5, i_98_, true, false, 7);
    }

    private static int a(javax.microedition.lcdui.Graphics graphics, int i,
            int i_100_) {
        i -= 26;
        main.MainCanvas.drawRegion(graphics, main.MainCanvas.imageStatusAll, i,
                i_100_, 120, 231, 26, 13);
        return i - 5;
    }

    public static void b(javax.microedition.lcdui.Graphics graphics, int i,
            int i_101_, int i_102_) {
        if (i_102_ >= 0) {
            i = main.GameManager.drawScore(graphics, i, 140, i_102_, false, true,
                    5);
        }
        main.MainCanvas.drawRegion(graphics, main.MainCanvas.imageStatusAll,
                (main.GameManager.a(graphics, i, 138)
                - 26),
                138, 40, 231, 26, 13);
    }

    public static void c(javax.microedition.lcdui.Graphics graphics, int i,
            int i_103_, int i_104_) {
        if (i_104_ >= 0) {
            i = main.GameManager.drawScore(graphics, i, 161, i_104_, false, true,
                    5);
        }
        main.MainCanvas.drawRegion(graphics, main.MainCanvas.imageStatusAll,
                (main.GameManager.a(graphics, i, 159)
                - 26),
                159, 0, 231, 26, 13);
    }

    public static void d(javax.microedition.lcdui.Graphics graphics, int i,
            int i_105_, int i_106_) {
        if (i_106_ >= 0) {
            i = main.GameManager.drawScore(graphics, i, 182, i_106_, false, true,
                    5);
        }
        main.MainCanvas.drawRegion(graphics, main.MainCanvas.imageStatusAll,
                (main.GameManager.a(graphics, i, 180)
                - 26),
                180, 0, 218, 26, 13);
    }

    public static void setObjInHUD(main.AbstractObject obj, int hudId) {
        objsInHUD[hudId] = obj;
    }

    public static int f(int i) {
        int i_107_ = i;
        if (i > 10000) {
            i_107_ = (i - 1) % 10000 + 1;
        }
        if (i_107_ < 125) {
            i_107_ = 125;
        }
        return i_107_ / 125;
    }

    public static void a(javax.microedition.lcdui.Graphics graphics, int i,
            int i_108_, int destX, int destY) {
        int destWidth = destX;
        if (destX >= 4 && destX <= 9) {
            if (destY == 1) {
                destWidth += 14;
            } else if (destY == 2) {
                destWidth += 20;
            }
        }
        destX = objNameOffsets[destWidth][0]; // * 43;
        destY = objNameOffsets[destWidth][1]; // * 13 + 67;
        destWidth = objNameOffsets[destWidth][2];
        main.MainCanvas.drawRegion(graphics, main.MainCanvas.imageStatusAll,
                i - destWidth / 2, i_108_ - 6, destX, destY,
                destWidth, 13);
    }

    private static void drawHudEnergy(
            javax.microedition.lcdui.Graphics graphics,
            int offsetX,
            int offsetY,
            boolean isRightSide,
            main.AbstractObject obj
    ) {
        final int barOffsetY = 32;
        if (obj != null) {
            int destY1 = obj.objectType;
            int maxEnergy = obj.maxEnergy;
            int srcWidth = obj.objectType;
            int destX1 = obj.difficultyAi;
            if (destY1 >= 4 && destY1 <= 9) {
                if (destX1 == 1) {
                    srcWidth += 14;
                } else if (destX1 == 2) {
                    srcWidth += 20;
                }
            }
            destX1 = aO[destY1][0];
            destY1 = aO[destY1][1];
            int srcX = objNameOffsets[srcWidth][0]; //* 43;
            int srcY = objNameOffsets[srcWidth][1]; //* 13 + 67;
            srcWidth = objNameOffsets[srcWidth][2];
            if (!isRightSide) { // Left side
                // icon
                main.MainCanvas.drawRegion(graphics, main.MainCanvas.imageStatusAll,
                        offsetX + 1, offsetY + 21, destX1, destY1,
                        20, 20);
                // name
                main.MainCanvas.drawRegion(graphics, main.MainCanvas.imageStatusAll,
                        offsetX + 22, offsetY + 21, srcX, srcY,
                        srcWidth, 13);
                // bar
                int barWidth;
                if (maxEnergy <= 2500) {
                    barWidth = 22;
                } else if (maxEnergy <= 5000) {
                    barWidth = 42;
                } else if (maxEnergy <= 7500) {
                    barWidth = 62;
                } else {
                    barWidth = 84;
                }
                main.MainCanvas.drawRegion(graphics, main.MainCanvas.imageStatusAll,
                        offsetX + 21, offsetY + barOffsetY, 0, 0, barWidth, 9);
                if (barWidth != 84) {
                    main.MainCanvas.drawRegion(graphics, main.MainCanvas.imageStatusAll,
                                offsetX + 21 + barWidth, offsetY + barOffsetY, 82, 0, 2, 9);
                }
                
                // Energy
                if (obj.energy > 0) {
                    int objM = obj.visualEnergy;
                    int color = ((maxEnergy = obj.energy) > 40000
                            ? main.MainCanvas.rgbValue(255, 255, 255)
                            : maxEnergy > 30000
                            ? main.MainCanvas.rgbValue(102, 0, 255)
                            : maxEnergy > 20000
                            ? main.MainCanvas.rgbValue(0, 204, 255)
                            : maxEnergy > 10000
                            ? main.MainCanvas.rgbValue(51, 255, 0)
                            : main.MainCanvas.rgbValue(255, 255, 0));
                    int secondColor;
                    if ((secondColor
                            = ((maxEnergy = obj.energy) > 30000
                            ? main.MainCanvas.rgbValue(0, 204, 255)
                            : maxEnergy > 20000
                            ? main.MainCanvas.rgbValue(51, 255, 0)
                            : maxEnergy > 10000
                            ? main.MainCanvas.rgbValue(255, 255, 0) : 0))
                            != 0) {
                        graphics.setColor(secondColor);
                        graphics.fillRect(offsetX + 23 + objM, offsetY + barOffsetY + 2, 80 - objM, 5);
                    }
                    graphics.setColor(color);
                    graphics.fillRect(offsetX + 23, offsetY + barOffsetY + 2, objM, 5);
                    //graphics.setColor(main.MainCanvas.rgbValue(255, 255, 0));
                    //graphics.fillRect(offsetX + 23, offsetY + barOffsetY + 2, obj.m, 5);
                }
            }
            
            
            else { // Right side
                // icon
                main.MainCanvas.drawRegion(graphics, main.MainCanvas.imageStatusAll,
                        offsetX + 220, offsetY + 21, destX1, destY1,
                        20, 20);
                // name
                main.MainCanvas.drawRegion(graphics, main.MainCanvas.imageStatusAll,
                        offsetX + 217 - srcWidth, offsetY + 21,
                        srcX, srcY, srcWidth, 13);
                // bar
                if (maxEnergy <= 2500) {
                    main.MainCanvas.drawRegion(graphics,
                            main.MainCanvas.imageStatusAll,
                            offsetX + 197, offsetY + barOffsetY, 62, 0, 22, 9);
                    main.MainCanvas.drawRegion(graphics,
                            main.MainCanvas.imageStatusAll,
                            offsetX + 197 - 2, offsetY + barOffsetY, 0, 0, 2, 9);
                } else if (maxEnergy <= 5000) {
                    main.MainCanvas.drawRegion(graphics,
                            main.MainCanvas.imageStatusAll,
                            offsetX + 177, offsetY + barOffsetY, 42, 0, 42, 9);
                    main.MainCanvas.drawRegion(graphics,
                            main.MainCanvas.imageStatusAll,
                            offsetX + 177 - 2, offsetY + barOffsetY, 0, 0, 2, 9);
                } else if (maxEnergy <= 7500) {
                    main.MainCanvas.drawRegion(graphics,
                            main.MainCanvas.imageStatusAll,
                            offsetX + 157, offsetY + barOffsetY, 22, 0, 62, 9);
                    main.MainCanvas.drawRegion(graphics,
                            main.MainCanvas.imageStatusAll,
                            offsetX + 157 - 2, offsetY + barOffsetY, 0, 0, 2, 9);
                } else {
                    main.MainCanvas.drawRegion(graphics,
                            main.MainCanvas.imageStatusAll,
                            offsetX + 135, offsetY + barOffsetY, 0, 0, 84, 9);
                }
                if (obj.energy > 0) {
                    int objM = obj.visualEnergy;
                    destY1 = ((maxEnergy = obj.energy) > 40000
                            ? main.MainCanvas.rgbValue(255, 255, 255)
                            : maxEnergy > 30000
                            ? main.MainCanvas.rgbValue(102, 0, 255)
                            : maxEnergy > 20000
                            ? main.MainCanvas.rgbValue(0, 204, 255)
                            : maxEnergy > 10000
                            ? main.MainCanvas.rgbValue(51, 255, 0)
                            : main.MainCanvas.rgbValue(255, 255, 0));
                    int i_120_;
                    if ((i_120_
                            = ((maxEnergy = obj.energy) > 30000
                            ? main.MainCanvas.rgbValue(0, 204, 255)
                            : maxEnergy > 20000
                            ? main.MainCanvas.rgbValue(51, 255, 0)
                            : maxEnergy > 10000
                            ? main.MainCanvas.rgbValue(255, 255, 0) : 0))
                            != 0) {
                        graphics.setColor(i_120_);
                        graphics.fillRect(offsetX + 137, offsetY + barOffsetY + 2, 80 - objM, 5);
                    }
                    graphics.setColor(destY1);
                    graphics.fillRect(offsetX + (217 - objM), offsetY + barOffsetY + 2, objM, 5);
                }
            }
        }
    }

    private static void i(int i) {
        java.lang.String[] strings;
        if (aC == null && (strings = levelObjArtFiles[i]) != null) {
            aC = main.ImageUtils.createImages(strings);
        }
        for (int i_121_ = 0; i_121_ < levelObjAtlasFiles[i].length; i_121_++) {
            if (aD[i_121_] == null && levelObjAtlasFiles[i][i_121_] != null) {
                java.lang.String string = "/" + levelObjAtlasFiles[i][i_121_];
                aD[i_121_] = main.GameManager.loadObjectData(string, aC);
            }
        }
    }

    public static void loadCharacterArt(int characterId, int paletteId, boolean bool) {
        main.MainCanvas.displayLoadingScreen();
        switch (paletteId) {
            default:
                if (charSpriteImages[characterId] == null) {
                    if (bool) {
                        charSpriteImages[characterId] = main.ImageUtils.createImages(characterArtFiles[characterId]);
                    } else {
                        charSpriteImages[characterId] = (new javax.microedition.lcdui.Image[characterArtFiles[characterId].length]);
                    }
                }
                if (charsArt[characterId] == null) {
                    java.lang.String string = "/" + characterAtlasFiles[characterId];
                    charsArt[characterId] = main.GameManager.loadObjectData(string, charSpriteImages[characterId]);
                }
                break;
            case 1:
                if (I[characterId] == null) {
                    if (bool) {
                        I[characterId] = main.ImageUtils.applyPalettesForImagesGroup(characterArtFiles[characterId], characterPaletteBFiles[characterId]);
                    } else {
                        I[characterId] = (new javax.microedition.lcdui.Image[characterArtFiles[characterId].length]);
                    }
                }
                if (aA[characterId] == null) {
                    java.lang.String string = "/" + characterAtlasFiles[characterId];
                    aA[characterId] = main.GameManager.loadObjectData(string, I[characterId]);
                }
                break;
            case 2:
                if (J[characterId] == null) {
                    if (bool) {
                        J[characterId] = main.ImageUtils.applyPalettesForImagesGroup(characterArtFiles[characterId], characterPaletteCFiles[characterId]);
                    } else {
                        J[characterId] = (new javax.microedition.lcdui.Image[characterArtFiles[characterId].length]);
                    }
                }
                if (aB[characterId] == null) {
                    java.lang.String string = "/" + characterAtlasFiles[characterId];
                    aB[characterId] = main.GameManager.loadObjectData(string, J[characterId]);
                }
        }
    }

    public static main.ObjectArt loadObjectData(
            java.lang.String string,
            javax.microedition.lcdui.Image[] images) {
        main.ObjectArt var_ad = new main.ObjectArt();
        if (!(string = string).endsWith(".rad")) {
            string += ".rad";
        }
        if (images == null || images.length < 1) {
            return null;
        }
        try {
            java.lang.Class var_class = bx;
            if (var_class == null) {
                java.lang.Class var_class_123_;
                try {
                    var_class_123_ = java.lang.Class
                            .forName("java.lang.Object");
                } catch (java.lang.ClassNotFoundException classnotfoundexception) {
                    java.lang.NoClassDefFoundError noclassdeffounderror
                            = new java.lang.NoClassDefFoundError(classnotfoundexception.getMessage());
                    throw noclassdeffounderror;
                }
                var_class = bx = var_class_123_;
            }
            java.lang.String string_124_ = string;
            java.lang.Class var_class_125_ = var_class;
            java.lang.Object object = null;
            java.lang.Object object_126_ = null;
            if (object_126_ != null) {
                /* empty */
            }
            java.io.InputStream inputstream
                    = main.GameManager.openInputStreamForFile(var_class_125_, string_124_);
            java.io.InputStream inputstream_127_ = inputstream;
            java.io.DataInputStream datainputstream
                    = (new java.io.DataInputStream(inputstream_127_));
            var_ad.readFromInputStream(datainputstream);
            var_ad.setImagesArray(images);
            datainputstream.close();
        } catch (java.lang.Exception exception) {
            java.lang.Exception exception_128_;
            (exception_128_ = exception).printStackTrace();
        }
        return var_ad;
    }

    private static void readLevelObjects(java.io.DataInputStream datainputstream) {
        try {
            int i = datainputstream.readShort() & 0xffff;
            int i_129_ = datainputstream.readShort() & 0xffff;
            datainputstream.readByte();
            i += i_129_;
            for (i_129_ = 0; i_129_ < i; i_129_++) {
                int[] is;
                int i_130_ = (is = main.GameManager.b(datainputstream))[0];
                int i_132_;
                int i_131_ = (i_132_ = is[1]) < 200 ? 0 : i_132_ - 200;
                int i_133_ = is[3] == 1 ? 0 : 1;
                int i_134_ = is[12] << 12;
                int i_135_ = is[13] << 12;
                try {
                    main.GameManager.spawnObject(i_130_, i_134_, i_135_, 0, i_133_,
                            i_132_, i_131_);
                } catch (java.lang.Exception exception) {
                    java.lang.Exception exception_136_;
                    (exception_136_ = exception).printStackTrace();
                }
            }
            for (i_129_ = 0; i_129_ < enemyObjects.size(); i_129_++) {
                main.AbstractObject var_af;
                if ((var_af = (main.AbstractObject) enemyObjects.elementAt(i_129_)).j
                        != 1) {
                    var_af.stateFlags &= ~0x1;
                }
                if (currentLevel == 6 || currentLevel == 8) {
                    var_af.stateFlags &= ~0x1;
                }
            }
            for (i_129_ = 0; i_129_ < bossObjects.size(); i_129_++) {
                main.AbstractObject var_af;
                if ((var_af = (main.AbstractObject) bossObjects.elementAt(i_129_)).j != 1) {
                    var_af.stateFlags &= ~0x1;
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static int[] b(java.io.DataInputStream datainputstream) {
        int[] is = new int[20];
        try {
            is[0] = datainputstream.readByte() & 0xff;
            is[1] = datainputstream.readByte() & 0xff;
            is[2] = datainputstream.readByte() & 0xff;
            is[3] = datainputstream.readByte() & 0xff;
            is[4] = datainputstream.readByte() & 0xff;
            int i = datainputstream.readByte() & 0xff;
            is[5] = i % 10;
            is[6] = i / 10;
            is[7] = datainputstream.readByte() & 0xff;
            if (is[7] == 0) {
                is[8] = (short) datainputstream.readShort();
                if (is[8] < 0) {
                    is[7] = -1;
                }
                is[9] = 0;
            } else {
                is[8] = (short) datainputstream.readShort();
                is[9] = (short) datainputstream.readShort();
            }
            is[10] = datainputstream.readByte() & 0xff;
            is[11] = (short) datainputstream.readShort();
            is[12] = datainputstream.readInt() / 100;
            is[13] = datainputstream.readInt() / 100;
        } catch (java.lang.Throwable throwable) {
            return null;
        }
        return is;
    }

    private static boolean j(int i) {
        for (int i_137_ = 0; i_137_ < enemyObjects.size(); i_137_++) {
            main.AbstractObject var_af;
            if ((var_af = (main.AbstractObject) enemyObjects.elementAt(i_137_)).j
                    == i) {
                return true;
            }
        }
        return false;
    }

    private static boolean k(int i) {
        for (int i_138_ = 0; i_138_ < miscObjects.size(); i_138_++) {
            main.AbstractObject var_af;
            if ((var_af = (main.AbstractObject) miscObjects.elementAt(i_138_)).j
                    == i) {
                return true;
            }
        }
        return false;
    }

    public static boolean g(int i) {
        for (int i_139_ = 0; i_139_ < enemyObjects.size(); i_139_++) {
            main.AbstractObject var_af;
            if ((var_af = (main.AbstractObject) enemyObjects.elementAt(i_139_)).j < i) {
                return true;
            }
        }
        return false;
    }

    private static boolean c(int i, int i_140_) {
        for (int i_141_ = 0; i_141_ < enemyObjects.size(); i_141_++) {
            main.AbstractObject var_af;
            if ((var_af = (main.AbstractObject) enemyObjects.elementAt(i_141_)).objectType == i
                    || var_af.objectType == i_140_) {
                return true;
            }
        }
        for (int i_142_ = 0; i_142_ < bossObjects.size(); i_142_++) {
            main.AbstractObject var_af;
            if ((var_af = (main.AbstractObject) bossObjects.elementAt(i_142_)).objectType == i
                    || var_af.objectType == i_140_) {
                return true;
            }
        }
        return false;
    }

    private static boolean l(int i) {
        if (Y && !main.GameManager.j(i) && u == 0) {
            return true;
        }
        return false;
    }

    private static boolean C() {
        switch (currentLevel) {
            default:
                return false;
            case 1:
                return main.GameManager.l(30);
            case 2:
                return main.GameManager.l(40);
            case 3:
                return main.GameManager.l(40);
            case 4:
                return main.GameManager.l(50);
            case 5:
                return main.GameManager.l(60);
            case 6:
                if (main.GameManager.j(40)) {
                    return false;
                }
                return true;
        }
    }

    public static void t() {
        aa = 99999;
    }

    private void _z(byte[] is) {
        for (int i = 0; i < 256; i++) {
            this._g[i] = (byte) i;
        }
        int i = 0;
        int i_143_ = 0;
        for (/**/; i < 256; i++) {
            i_143_ = i_143_ + this._g[i] + is[i % is.length] & 0xff;
            byte i_144_ = this._g[i];
            this._g[i] = this._g[i_143_];
            this._g[i_143_] = i_144_;
        }
        this._h = 0;
        this._i = 0;
    }

    private static final int _l(java.lang.String string) {
        byte[] is = string.getBytes();
        int i = 147;
        try {
            int i_145_ = is.length;
            while (i_145_ > 0) {
                i = i * 147 ^ is[--i_145_];
            }
            return i;
        } catch (java.lang.Exception exception) {
            return i;
        }
    }

    public static long _n() {
        if (_s >= 1) {
            return java.lang.System.currentTimeMillis();
        }
        return 0L;
    }

    public static java.io.InputStream openInputStreamForFile(java.lang.Class var_class, java.lang.String ambFileName) {
        if (_s >= 1) {
            if (var_class != null) {
                return var_class.getResourceAsStream(ambFileName);
            }
            if (!ambFileName.startsWith("/")) {
                ambFileName = "/" + ambFileName;
            }
            return "".getClass().getResourceAsStream(ambFileName);
        }
        return null;
    }

    private java.lang.String _o(java.lang.String string) {
        char[] cs = new char[string.length()];
        string.getChars(0, string.length(), cs, 0);
        int i = (char) 0;
        for (int i_146_ = 0; i_146_ < cs.length; i_146_++) {
            cs[i_146_] = (char) (cs[i_146_] - 1 ^ i++);
        }
        return new java.lang.String(cs);
    }

    private void _y(byte[] is, int i, byte[] is_147_, int i_148_, int i_149_) {
        int i_150_ = this._h;
        int i_151_ = this._i;
        for (int i_152_ = 0; i_152_ < i_149_; i_152_++) {
            i_150_ = i_150_ + 1 & 0xff;
            i_151_ = i_151_ + this._g[i_150_] & 0xff;
            byte i_153_ = this._g[i_150_];
            this._g[i_150_] = this._g[i_151_];
            this._g[i_151_] = i_153_;
            is_147_[i_148_ + i_152_]
                    = (byte) (is[i + i_152_]
                    ^ this._g[this._g[i_150_] + this._g[i_151_] & 0xff]);
        }
        this._h = i_150_;
        this._i = i_151_;
    }

    private final void _x() {
        this._j = 1732584193;
        this._k = -271733879;
        this._l = -1732584194;
        this._m = 271733878;
        this._n = 0;
        this._o = 0L;
        this._p = 0;
        this._n = -1009589776;
        this._q = new byte[64];
        this._r = new int[80];
    }

    private static void _s(byte[] is, int i, int i_154_) {
        is[i] = (byte) (i_154_ >>> 24);
        is[i + 1] = (byte) (i_154_ >>> 16);
        is[i + 2] = (byte) (i_154_ >>> 8);
        is[i + 3] = (byte) i_154_;
    }

    private void _t(byte[] is, int i) {
        int[] is_155_ = this._r;
        int i_156_ = 0;
        while (i_156_ < 16) {
            is_155_[i_156_] = (is[i] << 24 | (is[i + 1] & 0xff) << 16
                    | (is[i + 2] & 0xff) << 8 | is[i + 3] & 0xff);
            i_156_++;
            i += 4;
        }
        for (int i_157_ = 16; i_157_ < 80; i_157_++) {
            int i_158_ = (is_155_[i_157_ - 3] ^ is_155_[i_157_ - 8]
                    ^ is_155_[i_157_ - 14] ^ is_155_[i_157_ - 16]);
            is_155_[i_157_] = i_158_ << 1 | i_158_ >>> 31;
        }
        int i_159_ = this._j;
        int i_160_ = this._k;
        int i_161_ = this._l;
        int i_162_ = this._m;
        int i_163_ = this._n;
        int i_164_;
        for (i_164_ = 0; i_164_ < 20; i_164_++) {
            int i_165_ = ((i_159_ << 5 | i_159_ >>> 27)
                    + (i_160_ & i_161_ | (i_160_ ^ 0xffffffff) & i_162_)
                    + i_163_ + is_155_[i_164_] + 1518500249);
            i_163_ = i_162_;
            i_162_ = i_161_;
            i_161_ = i_160_ << 30 | i_160_ >>> 2;
            i_160_ = i_159_;
            i_159_ = i_165_;
        }
        for (/**/; i_164_ < 40; i_164_++) {
            int i_166_
                    = ((i_159_ << 5 | i_159_ >>> 27) + (i_160_ ^ i_161_ ^ i_162_)
                    + i_163_ + is_155_[i_164_] + 1859775393);
            i_163_ = i_162_;
            i_162_ = i_161_;
            i_161_ = i_160_ << 30 | i_160_ >>> 2;
            i_160_ = i_159_;
            i_159_ = i_166_;
        }
        for (/**/; i_164_ < 60; i_164_++) {
            int i_167_
                    = ((i_159_ << 5 | i_159_ >>> 27)
                    + (i_160_ & i_161_ | i_160_ & i_162_ | i_161_ & i_162_)
                    + i_163_ + is_155_[i_164_] + -1894007588);
            i_163_ = i_162_;
            i_162_ = i_161_;
            i_161_ = i_160_ << 30 | i_160_ >>> 2;
            i_160_ = i_159_;
            i_159_ = i_167_;
        }
        for (/**/; i_164_ < 80; i_164_++) {
            int i_168_
                    = ((i_159_ << 5 | i_159_ >>> 27) + (i_160_ ^ i_161_ ^ i_162_)
                    + i_163_ + is_155_[i_164_] + -899497514);
            i_163_ = i_162_;
            i_162_ = i_161_;
            i_161_ = i_160_ << 30 | i_160_ >>> 2;
            i_160_ = i_159_;
            i_159_ = i_168_;
        }
        this._j += i_159_;
        this._k += i_160_;
        this._l += i_161_;
        this._m += i_162_;
        this._n += i_163_;
        this._o += 512L;
    }

    private final void _u(byte[] is, int i) {
        byte[] is_169_ = this._q;
        if (is_169_ != null) {
            int i_170_ = this._p;
            long l = this._o + (long) (i_170_ << 3);
            is_169_[i_170_++] = (byte) -128;
            if (i_170_ > 56) {
                while (i_170_ < 64) {
                    is_169_[i_170_++] = (byte) 0;
                }
                _t(is_169_, 0);
                i_170_ = 0;
            }
            while (i_170_ < 56) {
                is_169_[i_170_++] = (byte) 0;
            }
            main.GameManager._s(is_169_, 56, (int) (l >> 32));
            main.GameManager._s(is_169_, 60, (int) l);
            _t(is_169_, 0);
            this._q = null;
            this._r = null;
        }
        main.GameManager._s(is, i, this._j);
        main.GameManager._s(is, i + 4, this._k);
        main.GameManager._s(is, i + 8, this._l);
        main.GameManager._s(is, i + 12, this._m);
        main.GameManager._s(is, i + 16, this._n);
    }

    private final byte[] _v() {
        byte[] is = new byte[20];
        _u(is, 0);
        return is;
    }

    private final void _w(byte[] is, int i, int i_171_) {
        if (this._p > 0) {
            int i_172_ = 64 - this._p;
            if (i_171_ >= i_172_) {
                java.lang.System.arraycopy(is, i, this._q,
                        this._p, i_172_);
                _t(this._q, 0);
                this._p = 0;
                i += i_172_;
                i_171_ -= i_172_;
            }
        }
        for (/**/; i_171_ >= 64; i_171_ -= 64) {
            _t(is, i);
            i += 64;
        }
        java.lang.System.arraycopy(is, i, this._q, this._p,
                i_171_);
        this._p += i_171_;
    }

    public static javax.microedition.lcdui.Displayable _b() {
        javax.microedition.lcdui.Displayable displayable
                = (javax.microedition.lcdui.Display.getDisplay(mMidlet).getCurrent() == null
                ? null : _s < 1 ? null
                : javax.microedition.lcdui.Display.getDisplay(mMidlet).getCurrent());
        return displayable;
    }

    private void _f() {
        _s++;
    }

    private static int _p(byte[] is, int i) {
        return ((is[i] & 0xff) << 24 | (is[i + 1] & 0xff) << 16
                | (is[i + 2] & 0xff) << 8 | is[i + 3] & 0xff);
    }

    private byte[] _q(byte[] is, byte[] is_173_) {
        int i = is_173_.length;
        if (i < 36 || is_173_[0] != this._f) {
            throw new java.lang.IllegalArgumentException();
        }
        _x();
        _w(is_173_, 1, 7);
        _w(is, 0, is.length);
        _z(_v());
        byte[] is_174_ = new byte[i - 8];
        _y(is_173_, 8, is_174_, 0, i - 8);
        _x();
        _w(is_173_, 0, 8);
        _w(is_174_, 0, i - 28);
        byte[] is_175_ = _v();
        for (int i_176_ = 0; i_176_ < 20; i_176_++) {
            if (is_175_[i_176_] != is_174_[i - 28 + i_176_]) {
                throw new java.lang.IllegalArgumentException();
            }
        }
        int i_177_ = main.GameManager._p(is_174_, 0);
        int i_178_ = main.GameManager._p(is_174_, 4);
        byte[] is_179_ = new byte[i_177_];
        if (i_178_ == -1) {
            java.lang.System.arraycopy(is_174_, 8, is_179_, 0,
                    i - 36);
        } else {
            throw new java.lang.IllegalArgumentException();
        }
        return is_179_;
    }

    private byte[] _r() {
        try {
            byte[] is = new byte[16];
            java.lang.System
                    .arraycopy(_o("353b8a5@").getBytes(), 0, is, 0, 8);
            java.lang.System
                    .arraycopy(_o("92g63>7g").getBytes(), 0, is, 8, 8);
            byte[] is_180_ = _q(is, data);
            return is_180_;
        } catch (java.lang.Exception exception) {
            return null;
        }
    }

    private void _g() {
        try {
            data = _r();
            int i = 0;
            for (int i_181_ = 0; i_181_ < _BB.length; i_181_++) {
                _BB[i_181_]
                        = "" + ((data[i] & 0xff) << 24 | (data[i + 1] & 0xff) << 16
                        | (data[i + 2] & 0xff) << 8 | data[i + 3] & 0xff);
                i += 4;
            }
            this._e = javax.microedition.lcdui.Image
                    .createImage(data, 80, data.length - 80);
            data = null;
            if (this._e == null) {
                mMidlet.notifyDestroyed();
            }
        } catch (java.lang.Exception exception) {
            data = null;
            mMidlet.notifyDestroyed();
        }
    }

    private static final void DrawEffect(javax.microedition.lcdui.Graphics graphics,
            java.lang.String string, int i, int i_182_) {
        graphics.setColor(0);
        graphics.drawString(string, i, i_182_ - 1, 20);
        graphics.drawString(string, i - 1, i_182_, 20);
        graphics.drawString(string, i + 1, i_182_, 20);
        graphics.drawString(string, i, i_182_ + 1, 20);
        graphics.setColor(16777215);
        graphics.drawString(string, i, i_182_, 20);
    }

    public void _i() throws java.lang.Exception {
        ((main.Main) mMidlet).anotherEmptyFunction();
        ((main.Main) mMidlet).anotherCreateEmptyMainCanvas();
    }

    private void _h() {
        /* empty */
    }

    public GameManager(javax.microedition.midlet.MIDlet midlet) {
        this._g = new byte[256];
        this._a = 64;
        this._b = 2048L;
        _c = 0L;
        mMidlet = midlet;
        _g();
        this.setFullScreenMode(true);
        javax.microedition.lcdui.Display.getDisplay(mMidlet).setCurrent(this);
    }

    public void run() {
        while (_c < this._b) {
            if (this.isShown()) {
                long l = java.lang.System.currentTimeMillis();
                _h();
                this.repaint();
                this.serviceRepaints();
                int i = (int) (java.lang.System
                        .currentTimeMillis()
                        - l);
                if (i < this._a) {
                    try {
                        java.lang.Thread.sleep((long) (this._a
                                - i));
                    } catch (java.lang.Exception exception) {
                        /* empty */
                    }
                    _c += (long) this._a;
                } else {
                    _c += (long) this._a;
                }
            }
        }
        _f();
        try {
            this._i();
        } catch (java.lang.Exception exception) {
            /* empty */
        }
    }

    public void start() {
        new java.lang.Thread(this).start();
    }

    public void paint(javax.microedition.lcdui.Graphics graphics) {
        if (_s < 1) {
            if (this._CC < 20) {
                _BB[this._CC] = _o(_BB[this._CC]);
                this._CC++;
            }
            graphics.setColor(0);
            graphics.fillRect(0, 0, this.getWidth(), this.getHeight());
            graphics.setColor(16777215);
            if (this._e != null) {
                graphics.drawImage(this._e, this.getWidth() / 2,
                        this.getHeight() / 2, 3);
            }
        }
    }

    public static boolean _a0() {
        return (long) _DD14 != (long) main.GameManager._l(_BB[14]) - _c;
    }

    public static boolean _a1() {
        return _DD17 != (long) main.GameManager._l(_BB[17]) - _c;
    }

    public static boolean _a2() {
        return _DD9 != (long) main.GameManager._l(_BB[9]) - _c;
    }
    
    
}
