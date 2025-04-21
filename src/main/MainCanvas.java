/* am - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
package main;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;

import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.GameCanvas;
import javax.microedition.rms.RecordStore;
import extra.IntroScreens;
import extra.ImageData;
import extra.IntArray;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Vector;
import javax.microedition.io.Connector;
import javax.microedition.io.file.FileConnection;
import javax.microedition.io.file.FileSystemRegistry;
import javax.microedition.lcdui.game.Sprite;

public final class MainCanvas extends javax.microedition.lcdui.game.GameCanvas {

    // Custom options
    private static final int NUM_OPTIONS = 4; // 2;    

    private static boolean o = false;
    private static boolean p = false;
    private static final int colorWhite = main.MainCanvas.rgbValue(255, 255, 255);
    private static final int colorBlack = main.MainCanvas.rgbValue(0, 0, 0);
    private static final int colorGray = main.MainCanvas.rgbValue(150, 150, 150);
    private static final int colorRed = main.MainCanvas.rgbValue(252, 30, 28);
    private static int screenWidth;
    private static int screenHeight;
    private static final javax.microedition.lcdui.Font font1 = javax.microedition.lcdui.Font.getFont(0, 0, 16);
    private static final javax.microedition.lcdui.Font font2 = javax.microedition.lcdui.Font.getFont(0, 0, 8);
    private static final javax.microedition.lcdui.Font font3 = javax.microedition.lcdui.Font.getFont(0, 0, 8);
    private static javax.microedition.lcdui.Graphics screenGraphics;
    private static javax.microedition.lcdui.Image screenImage;
    public static int screenClipWidth;
    public static int screenClipHeigh;
    public static int drawPosX;
    private static int drawPosY;
    private static int screenClipX;
    private static int screenClipY;
    //private static int E; // Unused field
    private static long F;
    private static int G;
    public static javax.microedition.lcdui.Image imageStatusAll;
    private static javax.microedition.lcdui.Image imageAdd0;
    private static javax.microedition.lcdui.Image imageAdd1;
    private static javax.microedition.lcdui.Image imageOpening;
    private static javax.microedition.lcdui.Image imageBkTitle;
    private static final int[] selectScreenAnimIds = new int[2];
    private static final int[] selectScreenAnimTimes = new int[2];
    private static final int[] N = new int[2];
    private static final int[] lowScreenOptionsIndexes = new int[2];
    private static final int[] audioVolumeLevels = {0, 50, 75, 100}; // mute, low, medium, high
    public static int mainState;
    public static int holdedMainState;
    private static int levelSelectOption = 1;
    private static int level;
    private static int difficulty;
    //private static int T; // Unused field
    private static boolean U;
    public static int[] playerIds = new int[2];
    public static int[] playerContinues = new int[2];
    public static int[] playerLives = new int[2];
    public static int[] playerCopCalls = new int[2];
    public static int[] playerScores = new int[2];
    private static int currentAudioVolume;
    public static int optionVibration;
    private static int optionsDifficulty;
    private static int maxLevelDiscovered;
    private static int Y;
    private static int Z;
    private static int savePl1Continues;
    private static int saveDifficulty;
    private static int saveLevel;
    private static int savePl1Id;
    private static int savePl1Lives;
    private static int savePl1CopCalls;
    private static int savePl1Score;
    
    private static int savePl2Continues;
    private static int savePl2Id;
    private static int savePl2Lives;
    private static int savePl2CopCalls;
    private static int savePl2Score;
    private static int[][] ah = new int[2][5];
    private static byte[][] ai = new byte[2][5];
    private static byte[][] aj = new byte[2][5];
    private IntroScreens introScreens;
    private static int al;
    private static boolean am;
    private static final int colorBlackBlue = main.MainCanvas.rgbValue(80, 80, 190);
    private static final int colorBrightGray = main.MainCanvas.rgbValue(220, 220, 240);
    private static int ap;
    private static int aq;
    private static int ar;
    private static int as;
    private static int at;
    private static int au;
    private static int av;
    private static int aw;
    private static int ax;
    //private static int ay; unused field
    private static int az;
    private static int aA;
    private static int menuScreenId;
    private static int aC;
    private static int aD;
    private static int aE;
    private static int aF;
    private static int mainMenuSelectedOption;
    private static int aH;
    private static int aI;
    private static int aJ;
    public static boolean m;
    public static boolean n;
    private static boolean aK;
    private static boolean aL;
    private static int aM;
    private static int optionScreenSelectedOption;
    private static int aO;
    private static int aP;
    private static int aQ;
    private static final int aR = 10;
    private static javax.microedition.lcdui.Image[] aS;
    // Probably the Title Screen colloring effect
    private static final byte[] aT = {0, 0, 0, 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5,
        6, 6, 5, 5, 4, 4, 3, 3, 2, 2, 1, 1};
    private static javax.microedition.lcdui.Image[] aU;
    private static final byte[] aV = {0, 1, 2, 3, 4, 3, 2, 1};
    private static int aW;
    private static int aX;
    private static final int[][] aY = {{0, 0, 0, 0, 2, 3, 5}, {44, 45, 45, 47, 44, 44}};
    private static final int[][] aZ = {{1, 3, 10}, {43, 45, 64}};
    private static final int[][] ba = {{2, 2, 3, 4, 5}, {45, 45, 46, 47, 48}};
    private static int bb;
    private static int bc;
    private static int bd;
    private static int player1Selection;
    private static int player2Selection;
    private static final int[] bf = new int[7];
    private static final int[][] bg
            = {{57, 46, 0, 151, 96, 16}, {169, 46, 96, 151, 96, 16},
            {140, 125, 146, 228, 41, 9}, {124, 141, 146, 237, 73, 9},
            {140, 157, 73, 219, 41, 9}, {140, 173, 73, 228, 32, 9},
            {132, 188, 73, 237, 57, 9}};
    private static final int[][] bh
            = {{50, 46, 0, 165, 40, 20}, {-10, 46, 40, 165, 40, 20},
            {13, 125, 120, 244, 26, 13}, {13, 141, 120, 257, 26, 13},
            {13, 157, 0, 257, 26, 13}, {13, 173, 40, 257, 26, 13},
            {13, 188, 80, 257, 26, 13}};
    private static final int[][] bi
            = {{116, 126}, {108, 126}, {100, 126}, {116, 142},
            {108, 142}, {116, 158}, {108, 158}, {116, 174},
            {116, 190}, {108, 190}, {100, 190}, null};
    private static final int[][] bj
            = {{198, 126}, {206, 126}, {198, 142}, {206, 142},
            {214, 142}, {198, 158}, {206, 158}, {214, 158},
            {198, 174}, {206, 174}, {198, 190}, {206, 190}};
    private static final short[][] bk;
    private static int bl;
    private static int bm;
    private static int bn;
    private static int bo;
    private static int mrXState;
    private static int bq;
    private static int br;
    private static int tutorialStepMode;
    private static int bt;
    private static int numTutorialConesToSpawn;
    private static boolean bv;
    private static int tutorialSpeachIndex;
    private static int tutorialSpeachLineIndex;
    private static int by;
    private static final java.lang.String[] tutorialSpeachLines;
    private static int tutorialPlayingStep;
    private static int regionRotationTransform;
    private static java.lang.Class bC;

    static {
        (new short[][]{new short[2], {192, 159}, {200, 159},
        {208, 159}, {216, 151}, {224, 151},
        {232, 151}, {192, 151}, {200, 151}, null})[9]
                = new short[]{208, 151};
        bk = new short[][]{new short[2], {180, 193}, {188, 193},
        {196, 193}, {180, 201}, {188, 201},
        {196, 201}, {180, 185}, {188, 185},
        {196, 185}};
        tutorialSpeachLines = new java.lang.String[2];
    }

    private static byte[] getSaveGameByteArray() {
        byte[] is = null;
        java.lang.Object object = null;
        try {
            javax.microedition.rms.RecordStore recordstore;
            is = (recordstore
                    = javax.microedition.rms.RecordStore
                    .openRecordStore("BareKunckle", false))
                    .getRecord(1);
            recordstore.closeRecordStore();
        } catch (javax.microedition.rms.RecordStoreNotFoundException recordstorenotfoundexception) {
            try {
                javax.microedition.rms.RecordStore recordstore;
                (recordstore
                        = javax.microedition.rms.RecordStore
                        .openRecordStore("BareKunckle", true))
                        .addRecord(null, 0, 0);
                recordstore.closeRecordStore();
            } catch (java.lang.Exception exception) {
                java.lang.Exception exception_0_;
                (exception_0_ = exception).printStackTrace();
                return null;
            }
        } catch (java.lang.Exception exception) {
            java.lang.Exception exception_1_;
            (exception_1_ = exception).printStackTrace();
        }
        return is;
    }

    private static void writeOptions() {
        while_3_:
        do {
            do {
                try {
                    java.io.ByteArrayOutputStream bytearrayoutputstream = new java.io.ByteArrayOutputStream();
                    java.io.DataOutputStream dataoutputstream = new java.io.DataOutputStream(bytearrayoutputstream);
                    dataoutputstream.writeInt(currentAudioVolume);
                    dataoutputstream.writeInt(optionVibration);
                    dataoutputstream.writeInt(optionsDifficulty);
                    dataoutputstream.writeBoolean(InputController.useSor2Controlls);
                    dataoutputstream.writeInt(GameManager.partnerMode);
                    dataoutputstream.writeInt(maxLevelDiscovered);
                    dataoutputstream.writeInt(Y);
                    dataoutputstream.writeInt(Z);
                    dataoutputstream.writeInt(savePl1Continues);
                    dataoutputstream.writeInt(saveDifficulty);
                    dataoutputstream.writeInt(saveLevel);
                    dataoutputstream.writeInt(savePl1Id);
                    dataoutputstream.writeInt(savePl1Lives);
                    dataoutputstream.writeInt(savePl1CopCalls);
                    dataoutputstream.writeInt(savePl1Score);
                    
                    if (GameManager.partnerMode != 0) {
                        dataoutputstream.writeInt(savePl2Continues);
                        dataoutputstream.writeInt(savePl2Id);
                        dataoutputstream.writeInt(savePl2Lives);
                        dataoutputstream.writeInt(savePl2CopCalls);
                        dataoutputstream.writeInt(savePl2Score);
                    }
                    
                    for (int i = 0; i < ah.length; i++) {
                        for (int i_2_ = 0; i_2_ < ah[i].length; i_2_++) {
                            dataoutputstream.writeInt(ah[i][i_2_]);
                        }
                    }
                    for (int i = 0; i < ai.length; i++) {
                        for (int i_3_ = 0; i_3_ < ai[i].length; i_3_++) {
                            dataoutputstream.writeByte(ai[i][i_3_]);
                        }
                    }
                    for (int i = 0; i < aj.length; i++) {
                        for (int i_4_ = 0; i_4_ < aj[i].length; i_4_++) {
                            dataoutputstream.writeByte(aj[i][i_4_]);
                        }
                    }
                    byte[] is = bytearrayoutputstream.toByteArray();
                    dataoutputstream.close();
                    if ((is = is) != null) {
                        java.lang.Object object = null;
                        try {
                            javax.microedition.rms.RecordStore recordstore;
                            (recordstore
                                    = javax.microedition.rms.RecordStore
                                    .openRecordStore("BareKunckle", false))
                                    .setRecord(1, is, 0, is.length);
                            recordstore.closeRecordStore();
                        } catch (java.lang.Exception exception) {
                            java.lang.Exception exception_5_;
                            (exception_5_ = exception).printStackTrace();
                            break;
                        }
                        break while_3_;
                    }
                } catch (java.lang.Exception exception) {
                    java.lang.Exception exception_6_;
                    (exception_6_ = exception).printStackTrace();
                    break while_3_;
                }
            } while (false);
            break;
        } while (false);
    }

    private static void a(int i, byte i_7_, byte i_8_, byte i_9_) {
        if (Y < i) {
            Y = i;
        }
        int i_10_ = -1;
        if (i_7_ == 1) {
            i_10_ = 0;
        } else if (i_7_ == 2) {
            i_10_ = 1;
        }
        if (i_10_ >= 0) {
            int[] is = new int[5];
            byte[] is_11_ = new byte[5];
            byte[] is_12_ = new byte[5];
            int i_13_ = 0;
            int i_14_ = 0;
            for (/**/; i_13_ < is.length; i_13_++) {
                if (ah[i_10_][i_14_] < i) {
                    is[i_13_] = i;
                    is_11_[i_13_] = i_8_;
                    is_12_[i_13_] = i_9_;
                    i = 0;
                } else {
                    is[i_13_] = ah[i_10_][i_14_];
                    is_11_[i_13_] = ai[i_10_][i_14_];
                    is_12_[i_13_] = aj[i_10_][i_14_];
                    i_14_++;
                }
            }
            ah[i_10_] = is;
            ai[i_10_] = is_11_;
            aj[i_10_] = is_12_;
            main.MainCanvas.writeOptions();
        }
    }

    public static void a() {
        if (imageBkTitle != null) {
            imageBkTitle = null;
        }
        aS = null;
        if (imageOpening != null) {
            imageOpening = null;
        }
        aU = null;
        java.lang.System.gc();
    }

    public MainCanvas() {
        super(false);
        this.setFullScreenMode(true);
    }

    public final void initStuff() {
        try {
            o = false;
            java.lang.System.gc();
            mainState = 0;
            holdedMainState = -1;
            //E = 0; unused field
            //java.lang.Object object = null; unused variable
            long l = 0L;
            java.lang.Object object_15_ = null;
            if (object_15_ != null) {
                /* empty */
            }
            l = main.GameManager._n();
            F = l;
            G = 0;
            screenWidth = this.getWidth();
            screenHeight = this.getHeight();
            javax.microedition.lcdui.Graphics graphics;
            main.ObjectArt.screenGraphics = graphics = screenGraphics = (screenImage = javax.microedition.lcdui.Image.createImage(screenWidth, screenHeight)).getGraphics();
            if (imageStatusAll == null) {
                imageStatusAll = main.ImageUtils.createImage("status_all");
            }
            if (imageAdd0 == null) {
                imageAdd0 = main.ImageUtils.createImage("add0.png");
            }
            if (imageAdd1 == null) {
                imageAdd1 = main.ImageUtils.createImage("add1.png");
            }
            currentAudioVolume = 2;
            main.AudioController.setVolume(audioVolumeLevels[currentAudioVolume]);
            main.MainCanvas.optionVibration = 3;
            optionsDifficulty = 1;
            maxLevelDiscovered = 1;
            Z = 0;
            saveLevel = 0;
            saveDifficulty = 0;
            savePl1Continues = 3;
            savePl1Id = 1;
            savePl1Lives = 2;
            savePl1CopCalls = 1;
            savePl1Score = 0;
            
            savePl2Continues = 3;
            savePl2Id = 2;
            savePl2Lives = 2;
            savePl2CopCalls = 1;
            savePl2Score = 0;
            Y = 10000;
            for (int i = 0; i < ah.length; i++) {
                ah[i] = new int[]{10000, 8000, 5000, 3000, 1000};
                for (int i_16_ = 0; i_16_ < ah[i].length; i_16_++) {
                    ai[i][i_16_] = (byte) 1;
                    aj[i][i_16_] = (byte) 1;
                }
            }
            level = 1;
            levelSelectOption = 1;
            difficulty = 0;
            //T = 0; unused field
            //main.MainCanvas var_am_17_ = this; unused variable
            main.MainCanvas.setLowScreenOptions(0, 0);
            byte[] is;
            if ((is = main.MainCanvas.getSaveGameByteArray()) == null) {
                main.MainCanvas.writeOptions();
            } else {
                try {
                    java.io.ByteArrayInputStream bytearrayinputstream = new java.io.ByteArrayInputStream(is);
                    java.io.DataInputStream datainputstream = (new java.io.DataInputStream(bytearrayinputstream));
                    
                    
                    currentAudioVolume = datainputstream.readInt();
                    main.MainCanvas.optionVibration = datainputstream.readInt();
                    optionsDifficulty = datainputstream.readInt();
                    InputController.useSor2Controlls = datainputstream.readBoolean();
                    GameManager.partnerMode = datainputstream.readInt();
                    maxLevelDiscovered = datainputstream.readInt();
                    if (maxLevelDiscovered > 7) maxLevelDiscovered = 7;
                    Y = datainputstream.readInt();
                    Z = datainputstream.readInt();
                    savePl1Continues = datainputstream.readInt();
                    saveDifficulty = datainputstream.readInt();
                    saveLevel = datainputstream.readInt();
                    savePl1Id = datainputstream.readInt();
                    savePl1Lives = datainputstream.readInt();
                    savePl1CopCalls = datainputstream.readInt();
                    savePl1Score = datainputstream.readInt();
                    
                    if (GameManager.partnerMode != 0){
                        savePl2Continues = datainputstream.readInt();
                        savePl2Id = datainputstream.readInt();
                        savePl2Lives = datainputstream.readInt();
                        savePl2CopCalls = datainputstream.readInt();
                        savePl2Score = datainputstream.readInt();
                    }
                        
                    
                    int[][] is_19_ = new int[2][5];
                    byte[][] is_20_ = new byte[2][5];
                    byte[][] is_21_ = new byte[2][5];
                    
                    for (int i = 0; i < is_19_.length; i++) {
                        for (int i_22_ = 0; i_22_ < is_19_[i].length; i_22_++) {
                            is_19_[i][i_22_] = datainputstream.readInt();
                        }
                    }
                    for (int i = 0; i < is_20_.length; i++) {
                        for (int i_23_ = 0; i_23_ < is_20_[i].length; i_23_++) {
                            is_20_[i][i_23_] = datainputstream.readByte();
                        }
                    }
                    for (int i = 0; i < is_21_.length; i++) {
                        for (int i_24_ = 0; i_24_ < is_21_[i].length; i_24_++) {
                            is_21_[i][i_24_] = datainputstream.readByte();
                        }
                    }
                    ah = is_19_;
                    ai = is_20_;
                    aj = is_21_;
                    datainputstream.close();
                } catch (java.lang.Exception exception) {
                    java.lang.Exception exception_25_;
                    (exception_25_ = exception).printStackTrace();
                }
            }
            screenClipWidth = 240;
            screenClipHeigh = 240;
            drawPosX = screenClipWidth / 2;
            drawPosY = screenClipHeigh / 2;
            screenClipX = screenWidth / 2 - drawPosX;
            screenClipY = screenHeight / 2 - drawPosY;
            if (screenClipX < 0) {
                screenClipX = 0;
            }
            if (screenClipY < 0) {
                screenClipY = 0;
            }
            InputController.reset();
            main.MainCanvas.j();
        } catch (java.lang.Exception exception) {
            java.lang.Exception exception_26_;
            (exception_26_ = exception).printStackTrace();
        }
    }

    public static void c() {
        main.MainCanvas.a(null, true, false);
        main.MainCanvas.setState(15);
    }

    private static void j() {
        regionRotationTransform = main.MainCanvas.rotationToImageTransform(0);
        screenGraphics.setClip(0, 0, screenWidth, screenHeight);
        screenGraphics.setColor(colorBlack);
        screenGraphics.fillRect(0, 0, screenWidth, screenHeight);
    }

    public static void d() {
        main.MainCanvas.j();
    }

    public static void setState(int newState) {
        if (newState == 21) {
            bo = mainState;
        }
        holdedMainState = newState;
    }

    public final void update() {

        if (!main.GameManager._a1()) {
            if (o) {
                main.AudioController.stopAllAudioWithoutResetingCurrentLevelMusic();
            } else {
                if (p) {
                    if (mainState != 21) {
                        main.AudioController.reloadLevelMusicIfNotPlaying();
                    }
                    main.InputController.reset();
                    if (mainState >= 13 && mainState <= 19) {
                        main.GameManager.g();
                    }
                    p = false;
                }
                main.MainCanvas.j();
                do {
                    try {
                        InputController.update();
                        boolean wasMainStateRestored;
                        if (holdedMainState != -1) {
                            mainState = holdedMainState;
                            holdedMainState = -1;
                            wasMainStateRestored = true;
                        } else {
                            wasMainStateRestored = false;
                        }
                        switch (mainState) {
                            case 0:
                                main.InputController.reinitControls();
                                am = false;
                                main.MainCanvas.writeOptions();
                                if (this.introScreens == null) {
                                    this.introScreens = new IntroScreens();
                                }
                                main.MainCanvas.setState(2);
                                break;
                            case 2: {
                                if (main.InputController.pressedIgnoringSpecials(
                                        InputController.ACTION_DEF_SPECIAL
                                        | InputController.ACTION_OK
                                        | InputController.ACTION_LEFT_SOFT_KEY
                                ) // 196640
                                        ) {
                                    extra.IntroScreens.activateA();
                                } else if (main.InputController.pressedIgnoringSpecials(InputController.ACTION_RIGHT_SOFT_KEY)) {
                                    extra.IntroScreens.activateB();
                                }
                                int i;
                                if ((i = extra.IntroScreens.updateState()) == 1) {
                                    if (currentAudioVolume == 0) {
                                        currentAudioVolume = 2;
                                    }
                                    main.AudioController.setVolume(audioVolumeLevels[currentAudioVolume]);
                                } else if (i == 2) {
                                    currentAudioVolume = 0;
                                    main.AudioController.setVolume(audioVolumeLevels[currentAudioVolume]);
                                } else if (i == 3) {
                                    main.MainCanvas.setState(1);
                                }
                                break;
                            }
                            case 1: {
                                if (wasMainStateRestored) {
                                    main.MainCanvas.m();
                                    //ay = 0; unused field
                                    az = 0;
                                    aA = 250;
                                    main.AudioController.closeMidiPlayer();
                                    main.AudioController.loadLevelMidi(0, false);
                                }
                                az = (az - 1) % imageOpening.getWidth();
                                if (--aA < (-main.GameTexts.intro.length * font2.getHeight()) - 10) {
                                    main.MainCanvas.setState(6);
                                }
                                main.MainCanvas.setLowScreenOption(0, 0);
                                main.MainCanvas.setLowScreenOption(1, 17);
                                if (main.InputController.pressedIgnoringSpecials(InputController.ACTION_RIGHT_SOFT_KEY | InputController.ACTION_OK)) {
                                    main.MainCanvas.setState(6);
                                }
                                javax.microedition.lcdui.Graphics graphics
                                        = screenGraphics;
                                if (imageOpening != null) {
                                    graphics.setClip(0, 0, screenClipWidth, screenClipHeigh);
                                    graphics.setColor(0);
                                    graphics.fillRect(0, 0, screenClipWidth, screenClipHeigh);
                                    imageOpening = aU[aV[(main.Main.a / 4
                                            % aV.length)]];
                                    for (int i = screenClipWidth / imageOpening.getWidth() + 1; i >= 0; i--) {
                                        graphics.drawImage(imageOpening,
                                                az + i * imageOpening.getWidth(),
                                                0, 0);
                                    }
                                    graphics.setFont(font2);
                                    graphics.setColor(255, 255, 255);
                                    int tabSize = font2.stringWidth(main.GameTexts.lowScreenOptions[17]);
                                    for (int introLine = 0; introLine < main.GameTexts.intro.length; introLine++) {
                                        int linePosY = (introLine * font2.getHeight() + aA) + font2.getHeight();
                                        if (linePosY > 0 && linePosY < screenClipHeigh) {
                                            // Edit.. for now let's just ignore spacing, always use tabSize, fits better
                                            if (main.GameTexts.intro[introLine].startsWith("\u3010")) { // if starts with "【"
                                                graphics.drawString(main.GameTexts.intro[introLine].substring(1), tabSize, linePosY, 0);
                                            } else {
                                                graphics.drawString((main.GameTexts.intro[introLine]), tabSize, linePosY, 0);
                                            }
                                        }
                                    }
                                }
                                break;
                            }
                            case 3:
                                if (main.InputController.pressedIgnoringSpecials(
                                        InputController.ACTION_DEF_SPECIAL
                                        | InputController.ACTION_OK
                                        | InputController.ACTION_LEFT_SOFT_KEY
                                ) // 196640
                                        ) {
                                    extra.IntroScreens.activateA();
                                } else if (main.InputController.pressedIgnoringSpecials(InputController.ACTION_RIGHT_SOFT_KEY)) {
                                    extra.IntroScreens.activateB();
                                }
                                main.Main.finishEmptyCanvas();
                                break;
                            case 6: {
                                if (wasMainStateRestored) {
                                    main.GameManager.loadCharacterArt(1, 0, true);
                                    main.GameManager.loadCharacterArt(2, 0, true);
                                    main.GameManager.loadCharacterArt(3, 0, true);
                                    main.MainCanvas.m();
                                    menuScreenId = 0;
                                    aC = -1;
                                    aD = -1;
                                    mainMenuSelectedOption = 0;
                                    aF = 0;
                                    aI = 0;
                                    m = false;
                                    InputController.reset();
                                }
                                processMenuInput();
                                javax.microedition.lcdui.Graphics graphics
                                        = screenGraphics;
                                int theDrawPosXAgain = drawPosX;
                                int theDrawPosY = drawPosY;
                                int theDrawPosX = theDrawPosXAgain;
                                boolean bool_32_ = true;
                                boolean bool_33_ = true;
                                boolean bool_34_ = true;
                                int destX = 0;
                                graphics.setClip(0, 0, screenClipWidth, screenClipHeigh);
                                graphics.setColor(colorBlack);
                                graphics.fillRect(0, 0, 320, 240);
                                if (imageOpening != null) {
                                    imageOpening = aU[aV[(main.Main.a / 4
                                            % aV.length)]];
                                    for (int i_36_ = screenClipWidth / imageOpening.getWidth() + 1;
                                            i_36_ >= 0; i_36_--) {
                                        graphics.drawImage(imageOpening, az + i_36_ * imageOpening.getWidth(), 0, 0);
                                    }
                                }
                                switch (aI) {
                                    default:
                                        if (aF > 5 && imageBkTitle != null) {
                                            if (aF > 40) {
                                                imageBkTitle = aS[aT[(aF - 40) % aT.length]];
                                            }
                                            main.MainCanvas.drawFullImage(graphics, imageBkTitle,
                                                    theDrawPosX - 134, 30);
                                        }
                                        if (aF < 10) {
                                            if (imageBkTitle != null) {
                                                main.MainCanvas.drawRegion(graphics, imageBkTitle,
                                                        -imageBkTitle.getWidth() / 2 + aF * 40, 30,
                                                        0, 0, imageBkTitle.getWidth() / 2,
                                                        imageBkTitle.getHeight());
                                                main.MainCanvas.drawRegion(graphics, imageBkTitle, screenClipWidth - aF * 40, 30,
                                                        imageBkTitle.getWidth() / 2, 0,
                                                        imageBkTitle.getWidth() / 2, imageBkTitle.getHeight());
                                            }
                                            if (aF > 7) {
                                                graphics.setColor(255, 255, 255);
                                                graphics.setClip(0, 0, screenClipWidth, screenClipHeigh);
                                                graphics.fillRect(0, 0, screenClipWidth, screenClipHeigh);
                                            }
                                        }
                                        if (aF > 11) {
                                            main.MainCanvas.drawRegion(graphics, imageStatusAll,
                                                    theDrawPosX - 22, 205,
                                                    40, 337, 45, 10);
                                            if (++aE % 16 < 14) {
                                                main.MainCanvas.drawRegion(graphics,
                                                        imageStatusAll,
                                                        (theDrawPosX - 7
                                                        - 26),
                                                        166, 0, 296,
                                                        13, 13);
                                                main.MainCanvas.drawRegion(graphics,
                                                        imageStatusAll,
                                                        (theDrawPosX - 7
                                                        - 13),
                                                        166, 40, 296,
                                                        13, 13);
                                                main.MainCanvas.drawRegion(graphics,
                                                        imageStatusAll, theDrawPosX - 7,
                                                        166, 120,
                                                        309, 26, 13);
                                                main.MainCanvas.drawRegion(graphics,
                                                        imageStatusAll,
                                                        (theDrawPosX - 7
                                                        + 26),
                                                        166, 40, 322,
                                                        13, 13);
                                            }
                                            if (aF < 40) {
                                                int i_37_
                                                        = (0xffffff
                                                        | (java.lang.Math
                                                        .max(255 - (aF - 11) * 10,
                                                                0)) << 24);
                                                int[] is = new int[screenClipWidth * screenClipHeigh];
                                                for (int i_38_ = 0; i_38_ < is.length;
                                                        i_38_++) {
                                                    is[i_38_] = i_37_;
                                                }
                                                graphics.setClip(0, 0, screenClipWidth, screenClipHeigh);
                                                graphics.drawRGB(is, 0, screenClipWidth, 0, 0, screenClipWidth,
                                                        screenClipHeigh, true);
                                            }
                                        }
                                        break;
                                    case 2: {
                                        if (imageBkTitle != null) {
                                            imageBkTitle = aS[aT[aF % aT.length]];
                                            main.MainCanvas.drawFullImage(graphics, imageBkTitle, theDrawPosX - 134, 30);
                                        }
                                        main.MainCanvas.drawFullImage(graphics, imageAdd1, theDrawPosX - 52, 136);
                                        regionRotationTransform = main.MainCanvas.rotationToImageTransform(theDrawPosY = 1);
                                        main.MainCanvas.drawFullImage(graphics, imageAdd1, theDrawPosX, 136);
                                        regionRotationTransform = main.MainCanvas.rotationToImageTransform(theDrawPosY = 2);
                                        main.MainCanvas.drawFullImage(graphics, imageAdd1, theDrawPosX - 52, 178);
                                        regionRotationTransform = main.MainCanvas.rotationToImageTransform(theDrawPosY = 3);
                                        main.MainCanvas.drawFullImage(graphics, imageAdd1, theDrawPosX, 178);
                                        regionRotationTransform = main.MainCanvas.rotationToImageTransform(theDrawPosY = 0);
                                        // Axel and Blaze side by side
                                        main.MainCanvas.draw(graphics, main.GameManager.charsArt[1], theDrawPosX - 96 << 12, 860160, selectScreenAnimIds[0], selectScreenAnimTimes[0], 0);
                                        main.MainCanvas.draw(graphics, main.GameManager.charsArt[2], theDrawPosX + 96 << 12, 860160, selectScreenAnimIds[1], selectScreenAnimTimes[1], 0);
                                        main.GameManager.a(graphics, drawPosX + 32,
                                                5, Y);
                                        if (menuScreenId == 10) {
                                            if (aJ == 1) {
                                                bool_32_ = (aE & 0x2) == 0;
                                            } else if (aJ == 2) {
                                                bool_33_ = (aE & 0x2) == 0;
                                            } else if (aJ == 3) {
                                                bool_34_ = (aE & 0x2) == 0;
                                            }
                                        }
                                        if (mainMenuSelectedOption < aH) {
                                            aH = mainMenuSelectedOption;
                                        } else if (mainMenuSelectedOption - 1 < aH && aH > 0) {
                                            aH = mainMenuSelectedOption - 1;
                                        }
                                        if (mainMenuSelectedOption - 4 > aH) {
                                            aH = mainMenuSelectedOption - 4;
                                        } else if (mainMenuSelectedOption - 3 > aH && aH < 2) {
                                            aH = mainMenuSelectedOption - 3;
                                        }
                                        if (bool_32_ && aH < 1) {
                                            main.MainCanvas.drawRegion(graphics, imageStatusAll,
                                                    theDrawPosX - 27, 140,
                                                    80, 283, 26, 13);
                                            main.MainCanvas.drawRegion(graphics, imageStatusAll,
                                                    theDrawPosX, 140, 80,
                                                    296, 26, 13);
                                        }
                                        if (bool_33_ && aH < 2) {
                                            if (maxLevelDiscovered > 1) {
                                                main.MainCanvas.drawRegion(graphics,
                                                        imageStatusAll,
                                                        theDrawPosX - 27,
                                                        156 - (aH
                                                        << 4),
                                                        40, 270, 26,
                                                        13);
                                                main.MainCanvas.drawRegion(graphics,
                                                        imageStatusAll, theDrawPosX,
                                                        156 - (aH
                                                        << 4),
                                                        80, 270, 26,
                                                        13);
                                                main.MainCanvas.drawRegion(graphics, imageStatusAll, theDrawPosX + 27,
                                                        156 - (aH << 4) + 2,
                                                        9 + levelSelectOption % 10 * 9, 9, 9, 9);
                                            } else {
                                                main.MainCanvas.drawRegion(graphics,
                                                        imageStatusAll,
                                                        theDrawPosX - 27,
                                                        156 - (aH
                                                        << 4),
                                                        0, 309, 26,
                                                        13);
                                                main.MainCanvas.drawRegion(graphics,
                                                        imageStatusAll, theDrawPosX,
                                                        156 - (aH
                                                        << 4),
                                                        40, 309, 26,
                                                        13);
                                            }
                                        }
                                        if (bool_34_ && aH < 4) {
                                            main.MainCanvas.drawRegion(graphics, imageStatusAll,
                                                    theDrawPosX - 13,
                                                    172 - (aH << 4),
                                                    80, 322, 26, 13);
                                        }
                                        if (aH < 5) {
                                            main.MainCanvas.drawRegion(graphics, imageStatusAll,
                                                    theDrawPosX - 19,
                                                    188 - (aH << 4),
                                                    0, 322, 39, 13);
                                        }
                                        if (aH < 6) {
                                            main.MainCanvas.drawRegion(graphics, imageStatusAll,
                                                    theDrawPosX - 13,
                                                    204 - (aH << 4),
                                                    0, 205, 26, 13);
                                        }
                                        if (aH < 7 && aH > 0) {
                                            main.MainCanvas.drawRegion(graphics, imageStatusAll,
                                                    theDrawPosX - 13,
                                                    220 - (aH << 4),
                                                    0, 270, 26, 13);
                                        }
                                        if (aH < 8 && aH > 1) {
                                            main.MainCanvas.drawRegion(graphics, imageStatusAll,
                                                    theDrawPosX - 13,
                                                    236 - (aH << 4),
                                                    120, 335, 26,
                                                    13);
                                        }
                                        int i_39_ = 141 + (mainMenuSelectedOption - aH << 4);
                                        switch (mainMenuSelectedOption) {
                                            case -20:
                                            case 0:
                                                destX = 37;
                                                break;
                                            case 1:
                                                destX = 37;
                                                break;
                                            case 2:
                                            case 4:
                                                destX = 37;
                                                break;
                                            case 3:
                                            case 5:
                                            case 6:
                                                destX = 37;
                                                break;
                                        }
                                        if (mainMenuSelectedOption == 1 && maxLevelDiscovered > 1) {
                                            boolean bool_40_;
                                            if (menuScreenId == 2) {
                                                bool_40_
                                                        = (main.Main.a % 12
                                                        < 8);
                                            } else {
                                                bool_40_ = bool_33_;
                                            }
                                            if (bool_40_) {
                                                main.MainCanvas.drawOptionSelection(graphics,
                                                        (theDrawPosX - 41
                                                        - 4),
                                                        i_39_,
                                                        false);
                                                javax.microedition.lcdui.Graphics graphics_41_
                                                        = graphics;
                                                int i_42_ = theDrawPosX + 41 - 4;
                                                theDrawPosX = i_39_;
                                                int i_43_ = i_42_;
                                                javax.microedition.lcdui.Graphics graphics_44_;
                                                main.MainCanvas.drawOptionSelection(graphics_44_ = graphics_41_,
                                                        i_43_, theDrawPosX, true);
                                            }
                                        } else {
                                            javax.microedition.lcdui.Graphics graphics_45_
                                                    = graphics;
                                            int i_46_ = theDrawPosX - destX;
                                            theDrawPosX = i_39_;
                                            int i_47_ = i_46_;
                                            javax.microedition.lcdui.Graphics graphics_48_;
                                            main.MainCanvas.drawOptionSelection((graphics_48_
                                                    = graphics_45_),
                                                    i_47_, theDrawPosX,
                                                    true);
                                        }
                                        break;
                                    }
                                    // Draw opntions screen
                                    case 3: {
                                        // Difficulty
                                        main.MainCanvas.drawMenuBounds(graphics, theDrawPosX,
                                                theDrawPosY, 29, 29);
                                        main.MainCanvas.drawRegion(graphics, imageStatusAll,
                                                theDrawPosX - 13, 55, 0,
                                                205, 26, 13);
                                        main.MainCanvas.drawRegion(graphics, imageStatusAll,
                                                theDrawPosX - 36, 77, 0,
                                                218, 26, 13);
                                        if (optionsDifficulty == 0) {
                                            main.MainCanvas.drawRegion(graphics, imageStatusAll,
                                                    theDrawPosX + 10, 77,
                                                    40, 218, 26, 13);
                                        } else if (optionsDifficulty == 1) {
                                            main.MainCanvas.drawRegion(graphics, imageStatusAll,
                                                    theDrawPosX + 10, 77,
                                                    80, 218, 26, 13);
                                        } else {
                                            main.MainCanvas.drawRegion(graphics, imageStatusAll,
                                                    theDrawPosX + 17, 77,
                                                    120, 218, 13,
                                                    13);
                                        }
                                        // Vibration ON/OFF
                                        main.MainCanvas.drawRegion(graphics, imageStatusAll,
                                                theDrawPosX - 36, 102, 80,
                                                231, 26, 13);
                                        if ((main.MainCanvas.optionVibration & 0x1) == 0) {
                                            main.MainCanvas.drawRegion(graphics, imageStatusAll,
                                                    theDrawPosX + 17, 102,
                                                    80, 244, 13, 13);
                                        } else {
                                            main.MainCanvas.drawRegion(graphics, imageStatusAll,
                                                    theDrawPosX + 17, 102,
                                                    40, 244, 13, 13);
                                        }

                                        // Custom code
                                        graphics.setFont(font3);
                                        graphics.setColor(colorWhite);
        
                                        // Custom code
                                        // SOR2 Controls ON/OFF
                                        drawStringAlignedLeft(graphics, "SOR2 control", theDrawPosX - 56, 127);
                                        //main.MainCanvas.drawRegion(graphics, imageStatusAll,
                                        //        theDrawPosX - 36, 127, 80,
                                        //        231, 26, 13);
                                        if (InputController.useSor2Controlls) {
                                            drawStringAlignedLeft(graphics, "ON", theDrawPosX + 27, 127);
                                            //main.MainCanvas.drawRegion(graphics, imageStatusAll,
                                            //        theDrawPosX + 17, 127,
                                            //        40, 244, 13, 13);
                                        } else {
                                            drawStringAlignedLeft(graphics, "OFF", theDrawPosX + 27, 127);
                                            //main.MainCanvas.drawRegion(graphics, imageStatusAll,
                                            //        theDrawPosX + 17, 127,
                                            //        80, 244, 13, 13);
                                        }

                                        // Custom code
                                        // Adam Always on ON/OFF
                                        drawStringAlignedLeft(graphics, "Extra partner", theDrawPosX - 56, 152);
                                        //main.MainCanvas.drawRegion(graphics, imageStatusAll,
                                        //        theDrawPosX - 36, 152, 80,
                                        //        231, 26, 13);
                                        switch (GameManager.partnerMode) {
                                            case 1:
                                                //drawStringAlignedLeft(graphics, "CPU", theDrawPosX + 20, 152);
                                                break;
                                            case 2:
                                                //drawStringAlignedLeft(graphics, "LOCAL", theDrawPosX + 20, 152);
                                                drawStringAlignedLeft(graphics, "ON", theDrawPosX + 20, 152);
                                                break;
                                            default:
                                                drawStringAlignedLeft(graphics, "OFF", theDrawPosX + 20, 152);
                                                break;
                                        }

                                        int destY;
                                        switch (optionScreenSelectedOption) {
                                            case 0:
                                                destX = 70;
                                                destY = 77;
                                                break;
                                            case 1:
                                                destX = 70;
                                                destY = 102;
                                                break;
                                            // custom code
                                            case 2:
                                                destX = 70;
                                                destY = 127;
                                                break;
                                            case 3:
                                                destX = 70;
                                                destY = 152;
                                                break;
                                            default:
                                                destX = 32;
                                                destY = 177;
                                        }
                                        if (optionScreenSelectedOption < NUM_OPTIONS) {
                                            if (main.Main.a % 12
                                                    < 10) {
                                                main.MainCanvas.drawOptionSelection(
                                                        graphics,
                                                        (theDrawPosX - destX),
                                                        destY,
                                                        false
                                                );
                                                int i_51_ = theDrawPosX - -60;
                                                theDrawPosX = destY;
                                                int i_52_ = i_51_;
                                                main.MainCanvas.drawOptionSelection(graphics,
                                                        i_52_, theDrawPosX, true);
                                            }
                                        } else {
                                            int i_55_ = theDrawPosX - destX;
                                            theDrawPosX = destY;
                                            int i_56_ = i_55_;
                                            main.MainCanvas.drawOptionSelection(graphics,
                                                    i_55_, theDrawPosX,
                                                    true);
                                        }
                                        break;
                                    }
                                    case 4:
                                        main.MainCanvas.drawMenuBounds(graphics, theDrawPosX,
                                                theDrawPosY, 29, 29);
                                        main.MainCanvas.drawHelpPage(graphics, theDrawPosX,
                                                theDrawPosY, aO);
                                        break;
                                    case 5: {
                                        if (imageBkTitle != null) {
                                            imageBkTitle = aS[aT[aF % aT.length]];
                                            main.MainCanvas.drawFullImage(graphics, imageBkTitle, theDrawPosX - 134, 30);
                                        }
                                        main.MainCanvas.drawFullImage(graphics, imageAdd1, theDrawPosX - 52, 136);
                                        regionRotationTransform = main.MainCanvas.rotationToImageTransform(theDrawPosY = 1);
                                        main.MainCanvas.drawFullImage(graphics, imageAdd1, theDrawPosX, 136);
                                        regionRotationTransform = main.MainCanvas.rotationToImageTransform(theDrawPosY = 2);
                                        main.MainCanvas.drawFullImage(graphics, imageAdd1, theDrawPosX - 52, 178);
                                        regionRotationTransform = main.MainCanvas.rotationToImageTransform(theDrawPosY = 3);
                                        main.MainCanvas.drawFullImage(graphics, imageAdd1, theDrawPosX, 178);
                                        regionRotationTransform = main.MainCanvas.rotationToImageTransform(theDrawPosY = 0);
                                        // Axel and Blaze side by side
                                        main.MainCanvas.draw(graphics, main.GameManager.charsArt[1], theDrawPosX - 96 << 12, 860160, selectScreenAnimIds[0], selectScreenAnimTimes[0], 0);
                                        main.MainCanvas.draw(graphics, main.GameManager.charsArt[2], theDrawPosX + 96 << 12, 860160, selectScreenAnimIds[1], selectScreenAnimTimes[1], 0);
                                        main.GameManager.a(graphics, drawPosX + 32,
                                                5, Y);
                                        if (menuScreenId == 10) {
                                            if (aJ == 5) {
                                                bool_32_ = (aE & 0x2) == 0;
                                            } else if (aJ == 6) {
                                                bool_33_ = (aE & 0x2) == 0;
                                            }
                                        }
                                        if (bool_32_) {
                                            main.MainCanvas.drawRegion(graphics, imageStatusAll,
                                                    theDrawPosX - 20, 145,
                                                    80, 309, 13, 13);
                                            main.MainCanvas.drawRegion(graphics, imageStatusAll,
                                                    theDrawPosX - 7, 145,
                                                    80, 283, 26, 13);
                                        }
                                        if (bool_33_) {
                                            main.MainCanvas.drawRegion(graphics, imageStatusAll,
                                                    theDrawPosX - 13, 161,
                                                    120, 322, 26,
                                                    13);
                                        }
                                        // retry option
                                        if (mainMenuSelectedOption == 1) {
                                            java.lang.String string = "";
                                            
                                            if (savePl1Lives > 0) {
                                                if (savePl1Id == 1)
                                                    string = main.GameTexts.miscInformation[1];
                                                else if (savePl1Id == 2)
                                                    string = main.GameTexts.miscInformation[2];
                                                else if (savePl1Id == 3) // Adam
                                                    string = main.GameTexts.miscInformation[19];
                                            }else {
                                                string = "-";
                                            }
                                            
                                            string += " / ";
                                            if (savePl2Lives > 0) {
                                                if (savePl2Id == 1)
                                                    string += main.GameTexts.miscInformation[1];
                                                else if (savePl2Id == 2)
                                                    string += main.GameTexts.miscInformation[2];
                                                else if (savePl2Id == 3) // Adam
                                                    string += main.GameTexts.miscInformation[19];
                                            }else {
                                                string += "-";
                                            }
                                            
                                            
                                            java.lang.String string_58_
                                                    = (main.GameTexts.miscInformation[3] + saveLevel
                                                    + main.GameTexts.miscInformation[4]
                                                    + string
                                                    + main.GameTexts.miscInformation[5]);
                                            graphics.setFont(font3);
                                            graphics.setColor(main.MainCanvas.rgbValue(190, 190,
                                                    230));
                                            main.MainCanvas.drawStringWith17Anchor(graphics,
                                                    string_58_,
                                                    theDrawPosX, 220);
                                        }
                                        int i_59_ = 145 + (mainMenuSelectedOption << 4);
                                        javax.microedition.lcdui.Graphics graphics_60_
                                                = graphics;
                                        int i_61_ = theDrawPosX - 37;
                                        theDrawPosX = i_59_;
                                        int i_62_ = i_61_;
                                        javax.microedition.lcdui.Graphics graphics_63_;
                                        main.MainCanvas.drawOptionSelection((graphics_63_
                                                = graphics_60_),
                                                i_62_, theDrawPosX, true);
                                        break;
                                    }
                                    case 6:
                                        main.MainCanvas.drawHighScores(graphics, theDrawPosX,
                                                theDrawPosY, aM);
                                        break;
                                    case 7:
                                        main.MainCanvas.drawMenuBounds(graphics, theDrawPosX,
                                                theDrawPosY, 29, 29);
                                        main.MainCanvas.drawCreditsPage(graphics, theDrawPosX,
                                                theDrawPosY, aQ);
                                        break;
                                    case 8: {
                                        main.MainCanvas.drawMenuBounds(graphics, theDrawPosX,
                                                theDrawPosY, 26, 14);
                                        graphics.setFont(font3);
                                        graphics.setColor(255, 255, 0);
                                        main.MainCanvas.drawStringWith17Anchor(graphics,
                                                main.GameTexts.miscInformation[6], theDrawPosX,
                                                theDrawPosY - 40);
                                        main.MainCanvas.drawStringWith17Anchor(graphics,
                                                main.GameTexts.miscInformation[7], theDrawPosX,
                                                theDrawPosY - 20);
                                        if (aP == 0) {
                                            graphics.setColor(colorWhite);
                                        } else {
                                            graphics.setColor(colorGray);
                                        }
                                        main.MainCanvas.drawStringWith17Anchor(graphics,
                                                main.GameTexts.miscInformation[8], theDrawPosX,
                                                theDrawPosY + 20 - 10);
                                        if (aP == 1) {
                                            graphics.setColor(colorWhite);
                                        } else {
                                            graphics.setColor(colorGray);
                                        }
                                        main.MainCanvas.drawStringWith17Anchor(graphics,
                                                main.GameTexts.miscInformation[9], theDrawPosX,
                                                theDrawPosY + 40 - 10);
                                        javax.microedition.lcdui.Graphics graphics_64_
                                                = graphics;
                                        int i_65_ = theDrawPosX - 52 + 16 + 4;
                                        theDrawPosX = theDrawPosY + 20 - 5 + aP * 20;
                                        int i_66_ = i_65_;
                                        javax.microedition.lcdui.Graphics graphics_67_;
                                        main.MainCanvas.drawOptionSelection((graphics_67_
                                                = graphics_64_),
                                                i_66_, theDrawPosX, true);
                                    }
                                }
                                break;
                            }
                            case 9:
                                if (wasMainStateRestored) {
                                    main.GameManager.loadCharacterArt(1, 0, true);
                                    main.GameManager.loadCharacterArt(2, 0, true);
                                    main.GameManager.loadCharacterArt(3, 0, true);
                                    main.MainCanvas.m();
                                    bb = 0;
                                    bd = 0;
                                    bc = 0;
                                    player1Selection = 0;
                                    player2Selection = 0;
                                    bf[0] = 983040;
                                    bf[1] = -983040;
                                    bf[2] = 819200;
                                    bf[3] = -819200;
                                    bf[4] = 819200;
                                    bf[5] = -819200;
                                    bf[6] = 819200;
                                    selectScreenAnimIds[0] = aY[0][0];
                                    selectScreenAnimIds[1] = aY[1][0];
                                    selectScreenAnimTimes[0] = 0;
                                    selectScreenAnimTimes[1] = 0;
                                    N[0] = 0;
                                    N[1] = 0;
                                    main.AudioController.loadLevelMidi(12, true);
                                }
                                o();
                                main.MainCanvas.drawSelectScreen(screenGraphics, drawPosX, drawPosY);
                                break;
                            case 10:
                            case 11: {
                                main.MainCanvas var_am_68_ = this;
                                main.MainCanvas.setLowScreenOptions(0, 0);
                                if (mainState == 10) {
                                    for (int i = 0 ; i < (GameManager.partnerMode != 0 ? 2 : 1) ; ++i) {
                                        playerContinues[i] = 3;
                                        difficulty = optionsDifficulty;
                                        if (U) {
                                           level = levelSelectOption;
                                        } else {
                                            level = 1;
                                        }
                                        playerLives[i] = 2;
                                        playerCopCalls[i] = (difficulty == 0) ? 2 : 1;
                                        playerScores[i] = 0;
                                    }
                                } else {
                                    playerContinues[0] = savePl1Continues;
                                    difficulty = saveDifficulty;
                                    level = saveLevel;
                                    playerIds[0] = savePl1Id;
                                    playerLives[0] = savePl1Lives;
                                    playerCopCalls[0] = savePl1CopCalls;
                                    playerScores[0] = savePl1Score;
                                    
                                    // Restore pl2 to
                                    if (GameManager.partnerMode != 0) {
                                        playerContinues[1] = savePl2Continues;
                                        playerIds[1] = savePl2Id;
                                        playerLives[1] = savePl2Lives;
                                        playerCopCalls[1] = savePl2CopCalls;
                                        playerScores[1] = savePl2Score;
                                    }
                                }
                            }
                            /* fall through */
                            case 12:
                                main.MainCanvas.k();
                                main.GameManager.loadLevel(level, difficulty, true, 0);
                                if (GameManager.partnerMode != 2) {
                                    // Clear sprites data for unused player
                                    if (playerIds[0] == 1) {
                                        if (main.GameManager.charSpriteImages[2] != null) {
                                            main.ImageUtils.releaseImages(main.GameManager.charSpriteImages[2]);
                                            main.GameManager.charSpriteImages[2] = null;
                                        }
                                        if (main.GameManager.charsArt[2] != null) {
                                            main.GameManager.charsArt[2].clearData();
                                            main.GameManager.charsArt[2] = null;
                                        }
                                    } else if (playerIds[0] == 2) {
                                        if (main.GameManager.charSpriteImages[1] != null) {
                                            main.ImageUtils.releaseImages(main.GameManager.charSpriteImages[1]);
                                            main.GameManager.charSpriteImages[1] = null;
                                        }
                                        if (main.GameManager.charsArt[1] != null) {
                                            main.GameManager.charsArt[1].clearData();
                                            main.GameManager.charsArt[1] = null;
                                        }
                                    }
                                }
                                am = false;
                                main.MainCanvas.j();
                                main.MainCanvas.a(null, true, true);
                                main.MainCanvas.setState(13);
                                break;
                            case 13:
                            case 14: // Start gameplay loop
                                main.GameManager.onGameOverState();
                                main.GameManager.update();
                                main.GameManager.handleCharsCollisionAgainstEnvironmentObjects();
                                main.GameManager.q();
                                main.GameManager.drawHUD(screenGraphics);
                                main.GameManager.s();
                                if (mainState == 13 && main.MainCanvas.a(screenGraphics, false,
                                        true) < 0) {
                                    main.MainCanvas.setState(14);
                                }
                                if (mainState == 13) {
                                    main.MainCanvas var_am_69_ = this;
                                    main.MainCanvas.setLowScreenOptions(0, 0);
                                } else {
                                    main.MainCanvas.setLowScreenOption(1, 7);
                                    if (main.InputController.pressedIgnoringSpecials(InputController.ACTION_RIGHT_SOFT_KEY)) {
                                        main.MainCanvas.setState(21);
                                    } else if (main.GameManager.isCopcallAllowed && playerCopCalls[0] > 0) {
                                        main.MainCanvas.setLowScreenOption(0, 16);
                                    } else {
                                        main.MainCanvas.setLowScreenOption(0, 15);
                                    }
                                }
                                break;
                            case 17:
                                if (wasMainStateRestored) {
                                    InputController.reset();
                                }
                            /* fall through */
                            case 16: {
                                main.MainCanvas var_am_70_ = this;
                                main.MainCanvas.setLowScreenOptions(0, 0);
                                main.GameManager.onGameOverState();
                                if (mainState == 16) {
                                    main.GameManager.m();
                                }
                                main.GameManager.update();
                                if (mainState == 16) {
                                    main.GameManager.q();
                                }
                                main.GameManager.drawHUD(screenGraphics);
                                main.GameManager.s();
                                if (mainState == 17) {
                                    main.MainCanvas.mrXState();
                                }
                                break;
                            }
                            case 15: {
                                main.MainCanvas var_am_71_ = this;
                                main.MainCanvas.setLowScreenOptions(0, 0);
                                main.GameManager.k = 3;
                                main.GameManager.onGameOverState();
                                main.GameManager.update();
                                main.GameManager.drawHUD(screenGraphics);
                                if (main.MainCanvas.a(screenGraphics, false, false) < 0) {
                                    main.MainCanvas.setState(20);
                                } else {
                                    main.GameManager.s();
                                }
                                break;
                            }
                            case 20: {
                                main.MainCanvas var_am_72_ = this;
                                main.MainCanvas.setLowScreenOptions(0, 0);
                                main.GameManager.k = 2;
                                main.GameManager.onGameOverState();
                                main.GameManager.update();
                                main.GameManager.drawHUD(screenGraphics);
                                main.MainCanvas.j();
                                main.GameManager.clearData();
                                if (U) {
                                    n = false;
                                    aK = true;
                                    main.MainCanvas.setLowScreenOption(0, 0);
                                    main.MainCanvas.setLowScreenOption(1, 0);
                                    main.MainCanvas.setState(6);
                                } else if (level > 0 && level < 7) {
                                    if (maxLevelDiscovered < level) {
                                        maxLevelDiscovered = level;
                                        main.MainCanvas.writeOptions();
                                    }
                                    level++;
                                    savePl1Continues = playerContinues[0];
                                    saveDifficulty = main.GameManager.currentDifficulty;
                                    saveLevel = level;
                                    savePl1Id = playerIds[0];
                                    savePl1Lives = playerLives[0];
                                    savePl1CopCalls = playerCopCalls[0];
                                    savePl1Score = playerScores[0];
                                    
                                    // Store pl2 too
                                    if (GameManager.partnerMode != 0) {
                                        savePl2Continues = playerContinues[1];
                                        savePl2Id = playerIds[1];
                                        savePl2Lives = playerLives[1];
                                        savePl2CopCalls = playerCopCalls[1];
                                        savePl2Score = playerScores[1];
                                    }
                                    
                                    main.MainCanvas.writeOptions();
                                    main.MainCanvas.setState(12);
                                } else if (level == 7) {
                                    maxLevelDiscovered = 7;
                                    Z++;
                                    main.MainCanvas.a(playerScores[0],
                                            (byte) main.GameManager.capToOneOrTwo(playerIds[0]),
                                            (byte) main.GameManager.currentLevel,
                                            (byte) main.GameManager.currentDifficulty);
                                    main.MainCanvas.writeOptions();
                                    main.MainCanvas.setState(4);
                                } else {
                                    n = false;
                                    main.MainCanvas.setLowScreenOption(0, 0);
                                    main.MainCanvas.setLowScreenOption(1, 0);
                                    main.MainCanvas.setState(6);
                                }
                                break;
                            }
                            case 21:
                                if (wasMainStateRestored) {
                                    bm = 0;
                                    bn = 0;
                                    main.AudioController.stopAllAudioWithoutResetingCurrentLevelMusic();
                                    main.AbstractObject.playSound(14);
                                }
                                main.MainCanvas.updateAudioVolume();
                                if (main.InputController.pressedIgnoringSpecials(InputController.ACTION_RIGHT_SOFT_KEY)) {
                                    if ((main.MainCanvas.optionVibration & 0x1) == 0) {
                                        main.MainCanvas.optionVibration |= 0x1;
                                        main.Main.vibrateHigh();
                                    } else {
                                        main.MainCanvas.optionVibration &= ~0x1;
                                    }
                                    G = 8;
                                }
                                main.MainCanvas.setLowScreenOption(1, 18 + ((main.MainCanvas.optionVibration & 0x1) > 0
                                        ? 0 : 1));
                                switch (bm) {
                                    case 0:
                                        if (main.InputController.pressedIgnoringSpecials(InputController.ACTION_UP)) {
                                            main.AbstractObject.playSound(12);
                                            if (--bn < 0) {
                                                bn = 2;
                                            }
                                        } else if (main.InputController.pressedIgnoringSpecials(InputController.ACTION_DOWN)) {
                                            main.AbstractObject.playSound(12);
                                            if (++bn > 2) {
                                                bn = 0;
                                            }
                                        }
                                        if (main.InputController.pressedIgnoringSpecials(
                                                InputController.ACTION_JUMP
                                                | InputController.ACTION_DEF_SPECIAL
                                                | InputController.ACTION_PICK_ITEM
                                                | InputController.ACTION_SOMETHING_2
                                                | InputController.ACTION_STAR
                                                | InputController.ACTION_OK
                                        ) // 66913
                                                ) {
                                            switch (bn) {
                                                case 0:
                                                    main.AbstractObject.playSound(19);
                                                    main.AudioController.updateMidiState();
                                                    main.AudioController.updateMidiState();
                                                    main.AudioController.reloadLevelMusicIfNotPlaying();
                                                    main.MainCanvas.setState(bo);
                                                    break;
                                                case 1:
                                                    main.AbstractObject.playSound(13);
                                                    bm = 1;
                                                    bn = 1;
                                                    break;
                                                case 2:
                                                    main.AbstractObject.playSound(13);
                                                    bm = 2;
                                                    bn = 0;
                                            }
                                        }
                                        break;
                                    case 1:
                                        if (main.InputController.pressedIgnoringSpecials(InputController.ACTION_UP)) {
                                            main.AbstractObject.playSound(12);
                                            if (--bn < 0) {
                                                bn = 1;
                                            }
                                        } else if (main.InputController.pressedIgnoringSpecials(InputController.ACTION_DOWN)) {
                                            main.AbstractObject.playSound(12);
                                            if (++bn > 1) {
                                                bn = 0;
                                            }
                                        }
                                        if (main.InputController.pressedIgnoringSpecials(
                                                InputController.ACTION_JUMP
                                                | InputController.ACTION_DEF_SPECIAL
                                                | InputController.ACTION_PICK_ITEM
                                                | InputController.ACTION_SOMETHING_2
                                                | InputController.ACTION_STAR
                                                | InputController.ACTION_OK
                                        ) // 66913
                                                ) {
                                            switch (bn) {
                                                case 0:
                                                    main.AbstractObject.playSound(13);
                                                    main.AudioController.updateMidiState();
                                                    main.AudioController.updateMidiState();
                                                    main.GameManager.clearData();
                                                    n = false;
                                                    aK = false;
                                                    aL = false;
                                                    main.MainCanvas.setLowScreenOption(0, 0);
                                                    main.MainCanvas.setLowScreenOption(1, 0);
                                                    main.MainCanvas.setState(6);
                                                    break;
                                                case 1:
                                                    main.AbstractObject.playSound(19);
                                                    bm = 0;
                                                    bn = 0;
                                            }
                                        }
                                        break;
                                    case 2:
                                        if (main.InputController.pressedIgnoringSpecials(InputController.ACTION_LEFT)) {
                                            if (--bn < 0) {
                                                bn = 0;
                                            } else {
                                                main.AbstractObject.playSound(12);
                                            }
                                        } else if (main.InputController.pressedIgnoringSpecials(InputController.ACTION_RIGHT)) {
                                            if (++bn
                                                    > main.GameTexts.help.length - 1) {
                                                bn = (main.GameTexts.help.length
                                                        - 1);
                                            } else {
                                                main.AbstractObject.playSound(12);
                                            }
                                        } else if (main.InputController.pressedIgnoringSpecials(
                                                InputController.ACTION_JUMP
                                                | InputController.ACTION_DEF_SPECIAL
                                                | InputController.ACTION_PICK_ITEM
                                                | InputController.ACTION_SOMETHING_2
                                                | InputController.ACTION_STAR
                                                | InputController.ACTION_OK
                                        ) // 66913
                                                ) {
                                            main.AbstractObject.playSound(19);
                                            bm = 0;
                                            bn = 2;
                                        }
                                        break;
                                }
                                if (mainState == 21 && holdedMainState != 6) {
                                    javax.microedition.lcdui.Graphics graphics
                                            = screenGraphics;
                                    int halfWidth1 = main.GameManager.screenWidth / 2;
                                    int i_73_ = main.GameManager.screenHeight / 2;
                                    int i_74_ = bm;
                                    int i_75_ = bn;
                                    int i_76_ = i_74_;
                                    int i_77_ = i_73_;
                                    int halfWidth2 = halfWidth1;
                                    javax.microedition.lcdui.Graphics graphics_79_;
                                    main.GameManager
                                            .drawHUD(graphics_79_ = graphics);
                                    graphics_79_.setFont(font3);
                                    graphics_79_.setColor(colorWhite);
                                    switch (i_76_) {
                                        case 0: {
                                            main.MainCanvas.drawMenuBounds(graphics_79_, halfWidth2, i_77_, 16, 10);
                                            if (i_75_ == 0) {
                                                graphics_79_.setColor(colorWhite);
                                            } else {
                                                graphics_79_.setColor(colorGray);
                                            }
                                            main.MainCanvas.drawStringAlignedLeft(graphics_79_,
                                                    main.GameTexts.miscInformation[12],
                                                    halfWidth2 - 36, i_77_ - 28);
                                            if (i_75_ == 1) {
                                                graphics_79_.setColor(colorWhite);
                                            } else {
                                                graphics_79_.setColor(colorGray);
                                            }
                                            main.MainCanvas.drawStringAlignedLeft(graphics_79_,
                                                    main.GameTexts.miscInformation[13],
                                                    halfWidth2 - 36, i_77_ - 8);
                                            if (i_75_ == 2) {
                                                graphics_79_.setColor(colorWhite);
                                            } else {
                                                graphics_79_.setColor(colorGray);
                                            }
                                            main.MainCanvas.drawStringAlignedLeft(graphics_79_,
                                                    main.GameTexts.miscInformation[14],
                                                    halfWidth2 - 36, i_77_ + 12);
                                            javax.microedition.lcdui.Graphics graphics_80_
                                                    = graphics_79_;
                                            int i_81_ = halfWidth2 - 52;
                                            halfWidth2 = i_77_ - 24 + i_75_ * 20;
                                            int i_82_ = i_81_;
                                            javax.microedition.lcdui.Graphics graphics_83_;
                                            main.MainCanvas.drawOptionSelection((graphics_83_
                                                    = graphics_80_),
                                                    i_82_, halfWidth2,
                                                    true);
                                            break;
                                        }
                                        case 1: {
                                            main.MainCanvas
                                                    .drawMenuBounds(graphics_79_, halfWidth2, i_77_, 26, 10);
                                            graphics_79_.setColor(255, 255, 0);
                                            main.MainCanvas.drawStringWith17Anchor(graphics_79_,
                                                    main.GameTexts.miscInformation[15], halfWidth2,
                                                    i_77_ - 25);
                                            if (i_75_ == 0) {
                                                graphics_79_.setColor(colorWhite);
                                            } else {
                                                graphics_79_.setColor(colorGray);
                                            }
                                            main.MainCanvas.drawStringWith17Anchor(graphics_79_,
                                                    main.GameTexts.miscInformation[8], halfWidth2,
                                                    i_77_ - 5);
                                            if (i_75_ == 1) {
                                                graphics_79_.setColor(colorWhite);
                                            } else {
                                                graphics_79_.setColor(colorGray);
                                            }
                                            main.MainCanvas.drawStringWith17Anchor(graphics_79_,
                                                    main.GameTexts.miscInformation[9], halfWidth2,
                                                    i_77_ + 15);
                                            javax.microedition.lcdui.Graphics graphics_84_
                                                    = graphics_79_;
                                            int i_85_ = halfWidth2 - 52 + 16 + 8;
                                            halfWidth2 = i_77_ + i_75_ * 20;
                                            int i_86_ = i_85_;
                                            javax.microedition.lcdui.Graphics graphics_87_;
                                            main.MainCanvas.drawOptionSelection((graphics_87_
                                                    = graphics_84_),
                                                    i_86_, halfWidth2,
                                                    true);
                                            break;
                                        }
                                        case 2:
                                            main.MainCanvas
                                                    .drawMenuBounds(graphics_79_, halfWidth2, i_77_, 29, 29);
                                            main.MainCanvas
                                                    .drawHelpPage(graphics_79_, halfWidth2, i_77_, i_75_);
                                    }
                                }
                                break;
                            case 18: { // Game over, continue?
                                if (wasMainStateRestored) {
                                    main.GameManager.initiateGameOverContinueState();
                                }
                                main.MainCanvas var_am_88_ = this;
                                main.MainCanvas.setLowScreenOptions(0, 0);
                                main.GameManager.onGameOverState();
                                main.GameManager.c(1536);
                                //main.GameManager.update(); // Do not update if waiting gameover-continue
                                main.GameManager.drawHUD(screenGraphics);
                                main.GameManager.s();
                                main.GameManager.continueSelectionMode();
                                main.GameManager.drawPlayerSelectHUD(screenGraphics, (GameManager.gameOveredPlayer == 0 ? main.GameManager.screenWidth / 2 : main.GameManager.screenWidth + 12) );
                                break;
                            }
                            case 19: { // Game over!!
                                if (wasMainStateRestored) {
                                    aW = 0;
                                }
                                main.MainCanvas var_am_89_ = this;
                                main.MainCanvas.setLowScreenOptions(0, 0);
                                main.GameManager.onGameOverState();
                                main.GameManager.c(1536);
                                main.GameManager.update();
                                main.GameManager.drawHUD(screenGraphics);
                                main.MainCanvas.drawRegion(screenGraphics, imageStatusAll,
                                        (main.GameManager.screenWidth
                                        / 2) - 34,
                                        102, 0, 283, 68, 13);
                                main.GameManager.s();
                                switch (aW) {
                                    case 0:
                                        if (!U) {
                                            main.MainCanvas.a(playerScores[0],
                                                    (byte) main.GameManager.capToOneOrTwo(playerIds[0]),
                                                    (byte) main.GameManager.currentLevel,
                                                    (byte) main.GameManager.currentDifficulty
                                            );
                                            if (GameManager.partnerMode != 0) {
                                                main.MainCanvas.a(playerScores[1],
                                                    (byte) main.GameManager.capToOneOrTwo(playerIds[1]),
                                                    (byte) main.GameManager.currentLevel,
                                                    (byte) main.GameManager.currentDifficulty
                                            );
                                            }
                                        }
                                        main.AudioController.loadLevelMidi(11, false);
                                        aX = 0;
                                        aW++;
                                        break;
                                    case 1:
                                        if (main.InputController.pressedAnyOf(
                                                InputController.ACTION_JUMP
                                                | InputController.ACTION_DEF_SPECIAL
                                                | InputController.ACTION_PICK_ITEM
                                                | InputController.ACTION_SOMETHING_2
                                                | InputController.ACTION_STAR
                                                | InputController.ACTION_OK
                                        ) // 66913
                                                || ++aX > 50) {
                                            aW++;
                                        }
                                        break;
                                    case 2:
                                        main.GameManager.clearData();
                                        n = true;
                                        m = true;
                                        main.MainCanvas.setLowScreenOption(0, 0);
                                        main.MainCanvas.setLowScreenOption(1, 0);
                                        main.MainCanvas.setState(6);
                                        break;
                                }
                                break;
                            }
                            case 4:
                                if (wasMainStateRestored) {
                                    main.ai.a();
                                }
                                main.MainCanvas.updateAudioVolume();
                                main.MainCanvas.setLowScreenOption(1, 17);
                                main.ai.showGameEnding();
                                main.ai.draw(screenGraphics);
                                break;
                            case 5:
                                if (wasMainStateRestored) {
                                    main.MainCanvas.k();
                                    main.AudioController.loadSounds(main.AudioController.soundFileNames);
                                    playerIds[0] = 1; // Use Axel on tutorial
                                    main.GameManager.loadLevel(0, 0, true, 0);
                                    am = false;
                                    tutorialStepMode = 0;
                                    bv = false;
                                }
                                main.MainCanvas.updateAudioVolume();
                                if (aJ == 1) {
                                    main.MainCanvas.setLowScreenOption(1, 17);
                                } else if (aJ == 3) {
                                    main.MainCanvas.setLowScreenOption(1, 9);
                                }
                                if (!main.MainCanvas.updateTutorialStep()) {
                                    main.GameManager.j = true;
                                    main.GameManager.onGameOverState();
                                    if (!bv) {
                                        main.GameManager.update();
                                        main.GameManager.handleCharsCollisionAgainstEnvironmentObjects();
                                        main.GameManager.q();
                                    }
                                    main.MainCanvas.updateTutorialHintsDisplay(screenGraphics);
                                    if (!bv) {
                                        main.GameManager.s();
                                    }
                                }
                                break;
                        }
                        this.repaint();
                        this.serviceRepaints();
                        main.AudioController.updateMidiState();
                        //E++; unused field
                        //java.lang.Object object_90_ = null; unused variable
                        long l = 0L;
                        java.lang.Object object_91_ = null;
                        if (object_91_ != null) {
                            /* empty */
                        }
                        l = main.GameManager._n();
                        if (l - F >= 1000L) {
                            //E = 0; unused field
                            //object_90_ = null; unused variable
                            l = 0L;
                            object_91_ = null;
                            if (object_91_ != null) {
                                /* empty */
                            }
                            l = main.GameManager._n();
                            F = l;
                        }
                        if (G <= 0 || --G != 0) {
                            break;
                        }
                        main.MainCanvas.writeOptions();
                    } catch (java.lang.Exception exception) {
                        java.lang.Exception exception_92_;
                        (exception_92_ = exception).printStackTrace();
                        break;
                    }
                    break;
                } while (false);
            }
        }
    }

    public final void paint(javax.microedition.lcdui.Graphics graphics) {
        graphics.setColor(0);
        graphics.setClip(0, 0, screenWidth, screenHeight);
        graphics.fillRect(0, 0, screenWidth, screenHeight);
        switch (mainState) {
            case 2:
                extra.IntroScreens.draw(graphics, screenWidth, screenHeight);
                break;
            case 3:
                break;
            default: {
                if (screenImage != null) {
                    graphics.setClip(screenClipX, screenClipY, screenClipWidth, screenClipHeigh);
                    graphics.drawImage(screenImage, screenClipX, screenClipY, 0);
                }
                javax.microedition.lcdui.Graphics graphics_93_;
                (graphics_93_ = graphics).setColor(255, 255, 255);
                graphics_93_.setClip(0, 0, screenWidth, screenHeight);
                graphics_93_.setFont(font2);
                graphics_93_.drawString(main.GameTexts.lowScreenOptions[lowScreenOptionsIndexes[0]], 0, screenHeight, 36);           // left option
                graphics_93_.drawString(main.GameTexts.lowScreenOptions[lowScreenOptionsIndexes[1]], screenWidth, screenHeight, 40); // right option
            }
        }
    }

    private static void k() {
        selectScreenAnimIds[0] = ba[0][0];
        selectScreenAnimIds[1] = ba[1][0];
        selectScreenAnimTimes[0] = 0;
        selectScreenAnimTimes[1] = 0;
        N[0] = 0;
        N[1] = 0;
        ap = main.Main.a % 2;
        am = true;
    }

    public static void displayLoadingScreen() {
        if (am) {
            main.AudioController.closeMidiPlayer();
            javax.microedition.lcdui.Graphics graphics = screenGraphics;
            java.lang.String string
                    = main.GameTexts.miscInformation[0];
            main.MainCanvas.setLowScreenOption(0, 0);
            main.MainCanvas.setLowScreenOption(1, 0);
            graphics.setColor(colorBlack);
            graphics.fillRect(0, 0, 320, 320);
            graphics.setFont(font3);
            for (int i = 0; i < al / 2 % 5; i++) {
                string += ".";
            }
            graphics.setColor(colorBlackBlue);
            int i = drawPosX - font3.stringWidth(main.GameTexts.miscInformation[0]) / 2;
            main.MainCanvas.drawStringAlignedLeft(graphics, string, i + 1, 215);
            main.MainCanvas.drawStringAlignedLeft(graphics, string, i - 1, 215);
            main.MainCanvas.drawStringAlignedLeft(graphics, string, i, 216);
            main.MainCanvas.drawStringAlignedLeft(graphics, string, i, 214);
            graphics.setColor(colorBrightGray);
            main.MainCanvas.drawStringAlignedLeft(graphics, string, i, 215);
            if (ap == 0) {
                if (main.GameManager.charsArt[1] == null) {
                    am = false;
                    main.GameManager.loadCharacterArt(1, 0, true);
                    am = true;
                }
                main.MainCanvas.controlSelectScreenCharsAnims(main.GameManager.charsArt[1], 0, ba[0]);
                main.MainCanvas.draw(graphics, main.GameManager.charsArt[1], drawPosX << 12, 614400, selectScreenAnimIds[0], selectScreenAnimTimes[0], 0);
            } else {
                if (main.GameManager.charsArt[2] == null) {
                    am = false;
                    main.GameManager.loadCharacterArt(2, 0, true);
                    am = true;
                }
                main.MainCanvas.controlSelectScreenCharsAnims(main.GameManager.charsArt[2], 1, ba[1]);
                main.MainCanvas.draw(graphics, main.GameManager.charsArt[2], drawPosX << 12, 614400, selectScreenAnimIds[1], selectScreenAnimTimes[1], 0);
            }
            main.Main.canvas.repaint();
            main.Main.canvas.serviceRepaints();
            al++;
        }
    }

    private static void updateAudioVolume() {
        int previousAudioVolume = currentAudioVolume;
        if (main.InputController.pressedIgnoringSpecials(InputController.ACTION_LEFT_SOFT_KEY)) {
            if (++currentAudioVolume > 3) {
                currentAudioVolume = 0;
            }
            G = 8;
        }
        main.MainCanvas.setLowScreenOption(0, 3 + currentAudioVolume);
        main.AudioController.setVolume(audioVolumeLevels[currentAudioVolume]);
        if (previousAudioVolume == 0 && currentAudioVolume > 0) {
            if (mainState == 4) {
                main.AudioController.loadLevelMidi(13, true);
            } else if (mainState == 5) {
                main.AudioController.loadLevelMidi(1, true);
            } else if (mainState == 1) {
                main.AudioController.loadLevelMidi(0, false);
            } else if (mainState == 9) {
                main.AudioController.loadLevelMidi(12, true);
            } else if (mainState == 6) {
                main.AudioController.loadLevelMidi(0, true);
            }
        }
    }

    public static void addPlayerScore(int playerId, int score) {
        if (playerId > 1) return; // ignore pl3..
        if (playerLives[playerId] == 0) return; // ignore dead players
        if (mainState != 5) {
            int extraLiveScore = main.GameManager.currentDifficulty == 0 ? 100000 : 200000;
            int previousLivesMultiplier = playerScores[playerId] / extraLiveScore;
            playerScores[playerId] += score;
            if (playerScores[playerId] > 9999999) {
                playerScores[playerId] = 9999999;
            }
            if (playerScores[playerId] / extraLiveScore != previousLivesMultiplier && main.MainCanvas.playerLives[playerId] < 9) {
                main.MainCanvas.playerLives[playerId]++;
                main.AbstractObject.playSound(6);
            }
        }
    }

    private static int a(javax.microedition.lcdui.Graphics graphics,
            boolean bool, boolean bool_96_) {
        int i = (screenClipWidth - 240) / 2;
        if (bool) {
            aw = 0;
            return 0;
        }
        if (main.Main.b > 0) {
            return 0;
        }
        if (!bool_96_) {
            main.GameManager.k = 2;
        }
        switch (aw) {
            case 0:
                main.GameManager.k = 2;
                aq = 1310720;
                ar = -983040;
                as = -1310720;
                at = 1310720;
                au = -1310720;
                av = 1310720;
                ax = 0;
                aw = 1;
            /* fall through */
            case 1:
                main.GameManager.k = 2;
                if (bool_96_) {
                    graphics.setColor(colorBlack);
                    graphics.fillRect(0, 0, 320, 240);
                }
                aq = main.ImageUtils.a(aq, 0, 3, 163840);
                ar = main.ImageUtils.a(ar, 0, 3, 163840);
                as = main.ImageUtils.a(as, 0, 3, 163840);
                if (ax > 18) {
                    if (!bool_96_) {
                        main.AudioController.loadLevelMidi(10, false);
                    }
                    ax = 0;
                    aw++;
                }
                break;
            case 2: {
                main.AbstractObject var_af;
                int i_97_;
                if (!bool_96_ && (var_af = main.GameManager.getPlayer1()) != null
                        && (i_97_ = var_af.state) != 3 && i_97_ != 4) {
                    main.GameManager.k = 2;
                }else if (!bool_96_ && (var_af = main.GameManager.getPlayer2()) != null
                        && (i_97_ = var_af.state) != 3 && i_97_ != 4) {
                    main.GameManager.k = 2;
                }
                if (ax > 36) {
                    ax = 0;
                    if (bool_96_) {
                        aw++;
                    } else {
                        aw += 2;
                    }
                }
                break;
            }
            case 3:
                aq += 131072;
                ar -= 131072;
                as -= 131072;
                if (ax > 8) {
                    return -1;
                }
                break;
            case 4:
                at = main.ImageUtils.a(at, 0, 3, 163840);
                au = main.ImageUtils.a(au, 0, 3, 163840);
                av = main.ImageUtils.a(av, 0, 3, 163840);
                if (ax > 20) {
                    main.AbstractObject.playSound(11);
                    ax = 0;
                    aw++;
                }
                break;
            case 5:
                if (main.GameManager.v > 1000) {
                    main.MainCanvas.addPlayerScore(0, 1000);
                    if (GameManager.partnerMode != 0)
                        main.MainCanvas.addPlayerScore(1, 1000);
                    main.GameManager.v -= 1000;
                } else {
                    main.MainCanvas.addPlayerScore(0, main.GameManager.v);
                    if (GameManager.partnerMode != 0)
                        main.MainCanvas.addPlayerScore(1, main.GameManager.v);
                    main.GameManager.v = 0;
                    main.AbstractObject.playSound(12);
                    aw++;
                }
                if (main.InputController.pressedIgnoringSpecials(
                        InputController.ACTION_JUMP
                        | InputController.ACTION_DEF_SPECIAL
                        | InputController.ACTION_PICK_ITEM
                        | InputController.ACTION_SOMETHING_2
                        | InputController.ACTION_STAR
                        | InputController.ACTION_OK
                ) // 66913
                        ) {
                    aw = 8;
                }
                break;
            case 6:
                if (main.GameManager.w > 1000) {
                    main.MainCanvas.addPlayerScore(0, 1000);
                    if (GameManager.partnerMode != 0)
                        main.MainCanvas.addPlayerScore(1, 1000);
                    main.GameManager.w -= 1000;
                } else {
                    main.MainCanvas.addPlayerScore(0, main.GameManager.w);
                    if (GameManager.partnerMode != 0)
                        main.MainCanvas.addPlayerScore(1, main.GameManager.w);
                    main.GameManager.w = 0;
                    main.AbstractObject.playSound(12);
                    aw++;
                }
                if (main.InputController.pressedIgnoringSpecials(
                        InputController.ACTION_JUMP
                        | InputController.ACTION_DEF_SPECIAL
                        | InputController.ACTION_PICK_ITEM
                        | InputController.ACTION_SOMETHING_2
                        | InputController.ACTION_STAR
                        | InputController.ACTION_OK
                ) // 66913
                        ) {
                    aw = 8;
                }
                break;
            case 7:
                if (main.GameManager.extraLevelBonus > 1000) {
                    main.MainCanvas.addPlayerScore(0, 1000);
                    if (GameManager.partnerMode != 0)
                        main.MainCanvas.addPlayerScore(1, 1000);
                    main.GameManager.extraLevelBonus -= 1000;
                } else {
                    main.MainCanvas.addPlayerScore(0, main.GameManager.extraLevelBonus);
                    if (GameManager.partnerMode != 0)
                        main.MainCanvas.addPlayerScore(1, main.GameManager.extraLevelBonus);
                    main.GameManager.extraLevelBonus = 0;
                    aw++;
                }
                if (main.InputController.pressedIgnoringSpecials(
                        InputController.ACTION_JUMP
                        | InputController.ACTION_DEF_SPECIAL
                        | InputController.ACTION_PICK_ITEM
                        | InputController.ACTION_SOMETHING_2
                        | InputController.ACTION_STAR
                        | InputController.ACTION_OK
                ) // 66913
                        ) {
                    aw = 8;
                }
                break;
            case 8:
                main.MainCanvas.addPlayerScore(0, main.GameManager.v);
                if (GameManager.partnerMode != 0) MainCanvas.addPlayerScore(1, main.GameManager.v);
                main.GameManager.v = 0;
                main.MainCanvas.addPlayerScore(0, main.GameManager.w);
                if (GameManager.partnerMode != 0) MainCanvas.addPlayerScore(1, main.GameManager.w);
                main.GameManager.w = 0;
                main.MainCanvas.addPlayerScore(0, main.GameManager.extraLevelBonus);
                if (GameManager.partnerMode != 0) MainCanvas.addPlayerScore(1, main.GameManager.extraLevelBonus);
                main.AudioController.stopAllAudio();
                main.AbstractObject.playSound(12);
                main.GameManager.extraLevelBonus = 0;
                ax = 0;
                aw++;
                break;
            case 9:
                if (ax > 32 || main.InputController.pressedIgnoringSpecials(
                        InputController.ACTION_JUMP
                        | InputController.ACTION_DEF_SPECIAL
                        | InputController.ACTION_PICK_ITEM
                        | InputController.ACTION_SOMETHING_2
                        | InputController.ACTION_STAR
                        | InputController.ACTION_OK
                ) // 66913
                        ) {
                    aw++;
                }
                break;
            case 10:
                return -1;
        }
        main.MainCanvas.drawRegion(screenGraphics, imageStatusAll, i + (aq >> 12) + 60, 95, 40, 145, 40,
                20);
        main.MainCanvas.drawRegion(screenGraphics, imageStatusAll, i + 112, (ar >> 12) + 95,
                40 + (level - 1) * 20, 185, 20, 20);
        main.MainCanvas.drawRegion(screenGraphics, imageStatusAll, i + (as >> 12) + 145, 95, 0,
                bool_96_ ? 185 : 145, 40, 20);
        if (!bool_96_) {
            main.GameManager.b(graphics, i + (at >> 12) + 120 + 65, 140,
                    main.GameManager.v);
            main.GameManager.c(graphics, i + (au >> 12) + 120 + 65, 161,
                    main.GameManager.w);
            main.GameManager.d(graphics, i + (av >> 12) + 120 + 65, 182,
                    main.GameManager.extraLevelBonus);
        }
        ax++;
        return aw;
    }

    private static void m() {
        main.MainCanvas.k();
        main.AudioController.loadSounds(main.AudioController.soundFileNames);
        if (imageBkTitle == null) {
            imageBkTitle = main.ImageUtils.createImage("bk_title");
        }
        if (imageOpening == null) {
            imageOpening = main.ImageUtils.createImage("opening");
        }
        if (aS == null) {
            byte[] is = new byte[3];
            java.io.DataInputStream datainputstream = null;
            java.lang.Class var_class = bC;
            if (var_class == null) {
                java.lang.Class var_class_98_;
                try {
                    var_class_98_ = java.lang.Class
                            .forName("java.lang.Object");
                } catch (java.lang.ClassNotFoundException classnotfoundexception) {
                    java.lang.NoClassDefFoundError noclassdeffounderror
                            = new java.lang.NoClassDefFoundError(classnotfoundexception.getMessage());
                    throw noclassdeffounderror;
                }
                var_class = bC = var_class_98_;
            }
            datainputstream = new java.io.DataInputStream(var_class.getResourceAsStream("/bk_title.bin"));
            java.io.DataInputStream datainputstream_99_
                    = datainputstream;
            try {
                ImageData var_c
                        = main.ImageUtils.loadImageData("bk_title");
                (aS = (new javax.microedition.lcdui.Image[datainputstream_99_.readByte()]))[0]
                        = var_c.getImage();
                for (int i = 1; i < aS.length; i++) {
                    main.MainCanvas.displayLoadingScreen();
                    IntArray var_d
                            = new IntArray(datainputstream_99_
                                    .readByte());
                    for (int i_100_ = 0; i_100_ < var_d.length(); i_100_++) {
                        datainputstream_99_.read(is);
                        var_d.set(i_100_,
                                ((is[0] & 0xff) << 16 | (is[1] & 0xff) << 8
                                | is[2] & 0xff));
                    }
                    var_c.setPaletteData(var_d);
                    aS[i] = var_c.getImage();
                }
                datainputstream_99_.close();
            } catch (java.lang.Exception exception) {
                java.lang.Exception exception_101_;
                (exception_101_ = exception).printStackTrace();
            }
            java.io.DataInputStream datainputstream_102_ = null;
            java.lang.Class var_class_103_ = bC;
            if (var_class_103_ == null) {
                java.lang.Class var_class_104_;
                try {
                    var_class_104_ = java.lang.Class
                            .forName("java.lang.Object");
                } catch (java.lang.ClassNotFoundException classnotfoundexception) {
                    java.lang.NoClassDefFoundError noclassdeffounderror
                            = new java.lang.NoClassDefFoundError(classnotfoundexception.getMessage());
                    throw noclassdeffounderror;
                }
                var_class_103_ = bC = var_class_104_;
            }
            datainputstream_102_ = new java.io.DataInputStream(var_class_103_.getResourceAsStream("/opening.bin"));
            datainputstream_99_ = datainputstream_102_;
            try {
                ImageData var_c = main.ImageUtils.loadImageData("opening");
                (aU = (new javax.microedition.lcdui.Image[datainputstream_99_.readByte()]))[0]
                        = var_c.getImage();
                for (int i = 1; i < aU.length; i++) {
                    main.MainCanvas.displayLoadingScreen();
                    IntArray var_d
                            = new IntArray(datainputstream_99_
                                    .readByte());
                    for (int i_105_ = 0; i_105_ < var_d.length(); i_105_++) {
                        datainputstream_99_.read(is);
                        var_d.set(i_105_,
                                ((is[0] & 0xff) << 16 | (is[1] & 0xff) << 8
                                | is[2] & 0xff));
                    }
                    var_c.setPaletteData(var_d);
                    aU[i] = var_c.getImage();
                }
                datainputstream_99_.close();
            } catch (java.lang.Exception exception) {
                java.lang.Exception exception_106_;
                (exception_106_ = exception).printStackTrace();
            }
        }
        am = false;
        java.lang.System.gc();
    }

    private static void d(int i) {
        aC = 2;
        aL = false;
        aK = false;
        aI = 2;
        mainMenuSelectedOption = i;
        main.AudioController.loadLevelMidi(0, true);
    }

    private void processMenuInput() {
        boolean bool = false;
        if (aC != -1 && selectScreenAnimIds[0] != aZ[0][2] && selectScreenAnimIds[1] != aZ[1][2]) {
            menuScreenId = aC;
            aC = -1;
            bool = true;
        }
        switch (menuScreenId) {
            case 0:
                mainMenuSelectedOption = 0;
                aI = 1;
                aC = -1;
                aD = -1;
                m = false;
                bool = true;
                if (aK) {
                    main.MainCanvas.d(1);
                    break;
                }
                if (aL) {
                    main.MainCanvas.d(2);
                    break;
                }
                if (n) {
                    m = true;
                    main.AudioController.loadLevelMidi(10, false);
                    if (playerIds[0] == 1) {
                        aC = 8;
                    } else {
                        aC = 9;
                    }
                    processMenuInput();
                    break;
                }
                menuScreenId = 1;
            /* fall through */
            case 1:
                if (bool) {
                    mainMenuSelectedOption = 0;
                    aF = 0;
                    main.MainCanvas.setLowScreenOption(0, 0);
                    main.MainCanvas.setLowScreenOption(1, 0);
                    imageBkTitle = aS[0];
                    main.AudioController.loadLevelMidi(0, true);
                }
                az = (az - 1) % imageOpening.getWidth();
                aI = 1;
                if (++aF > 192) {
                    aE = 0;
                    aM = 0;
                    m = true;
                    aC = 12;
                } else {
                    if (aF == 45) {
                        java.lang.System.gc();
                    }
                    if (aF > 11) {
                        if (aF == 12) {
                            main.AbstractObject.playSound(41);
                        }
                        main.MainCanvas.updateAudioVolume();
                        main.MainCanvas.setLowScreenOption(1, 14);
                        if (main.InputController.pressedIgnoringSpecials(InputController.ACTION_RIGHT_SOFT_KEY)) {
                            main.AbstractObject.playSound(19);
                            aC = 5;
                            java.lang.System.gc();
                        } else if (main.InputController.pressedIgnoringSpecials(
                                InputController.ACTION_JUMP
                                | InputController.ACTION_DEF_SPECIAL
                                | InputController.ACTION_PICK_ITEM
                                | InputController.ACTION_SOMETHING_2
                                | InputController.ACTION_STAR
                                | InputController.ACTION_OK
                        ) // 66913
                                ) {
                            main.AbstractObject.playSound(13);
                            aE = 0;
                            aC = 2;
                            aJ = 0;
                            java.lang.System.gc();
                        }
                    }
                    break;
                }
                break;
            case 2:
                if (selectScreenAnimIds[0] == aZ[0][2] || selectScreenAnimIds[1] == aZ[1][2]) {
                    main.MainCanvas.a(main.GameManager.charsArt[1], 0);
                    main.MainCanvas.a(main.GameManager.charsArt[2], 1);
                } else {
                    main.MainCanvas.a(main.GameManager.charsArt[1], 0);
                    main.MainCanvas.a(main.GameManager.charsArt[2], 1);
                    if (bool) {
                        main.MainCanvas.e(0);
                    }
                    aF++;
                    aI = 2;
                    main.MainCanvas.updateAudioVolume();
                    main.MainCanvas.setLowScreenOption(1, 11);
                    if (main.InputController.pressedIgnoringSpecials(InputController.ACTION_RIGHT_SOFT_KEY)) {
                        main.AbstractObject.playSound(19);
                        aC = 1;
                    } else {
                        if (main.InputController.pressedIgnoringSpecials(InputController.ACTION_UP)) {
                            main.AbstractObject.playSound(12);
                            if (--mainMenuSelectedOption < 0) {
                                mainMenuSelectedOption = 6;
                            }
                            main.MainCanvas.e(1);
                        } else {
                            if (main.InputController.pressedIgnoringSpecials(InputController.ACTION_DOWN)) {
                                main.AbstractObject.playSound(12);
                                if (++mainMenuSelectedOption > 6) {
                                    mainMenuSelectedOption = 0;
                                }
                                main.MainCanvas.e(1);
                            } else {
                                if (main.InputController.pressedIgnoringSpecials(InputController.ACTION_RIGHT)) {
                                    if (mainMenuSelectedOption == 1 && maxLevelDiscovered > 1) {
                                        if (++levelSelectOption > maxLevelDiscovered) {
                                            levelSelectOption = 1;
                                        }
                                        main.AbstractObject.playSound(12);
                                        main.MainCanvas.e(1);
                                    }
                                } else if (main.InputController.pressedIgnoringSpecials(InputController.ACTION_LEFT)) {
                                    if (mainMenuSelectedOption == 1 && maxLevelDiscovered > 1) {
                                        if (--levelSelectOption < 1) {
                                            levelSelectOption = maxLevelDiscovered;
                                        }
                                        main.AbstractObject.playSound(12);
                                        main.MainCanvas.e(1);
                                    }
                                } else if (main.InputController.pressedIgnoringSpecials(
                                        InputController.ACTION_JUMP
                                        | InputController.ACTION_DEF_SPECIAL
                                        | InputController.ACTION_PICK_ITEM
                                        | InputController.ACTION_SOMETHING_2
                                        | InputController.ACTION_STAR
                                        | InputController.ACTION_OK
                                ) // 66913
                                        ) {
                                    aK = false;
                                    aL = false;
                                    switch (mainMenuSelectedOption) {
                                        case 0:
                                            if ((optionVibration & 0x2) != 0) {
                                                aD = 5;
                                            } else {
                                                aD = 9;
                                            }
                                            aJ = 1;
                                            aE = 12;
                                            if (saveLevel > 0) {
                                                aC = 6;
                                            } else {
                                                levelSelectOption = 1;
                                                aC = 10;
                                            }
                                            U = false;
                                            main.AbstractObject.playSound(13);
                                            main.MainCanvas.e(2);
                                            break;
                                        case 1:
                                            if (maxLevelDiscovered > 1) {
                                                U = true;
                                                aK = true;
                                                aD = 9;
                                                aJ = 2;
                                                aE = 12;
                                                aC = 10;
                                                main.AbstractObject.playSound(13);
                                                main.MainCanvas.e(2);
                                            }
                                            break;
                                        case -20:
                                            aC = 14;
                                            main.AbstractObject.playSound(13);
                                            main.MainCanvas.e(2);
                                            break;
                                        case 2:
                                            aL = true;
                                            aD = 5;
                                            aJ = 3;
                                            aE = 12;
                                            aC = 10;
                                            main.AbstractObject.playSound(13);
                                            main.MainCanvas.e(2);
                                            break;
                                        case 3:
                                            aC = 8;
                                            m = false;
                                            aM = 0;
                                            main.AbstractObject.playSound(13);
                                            main.MainCanvas.e(2);
                                            break;
                                        case 4:
                                            aC = 3;
                                            aJ = 4;
                                            optionScreenSelectedOption = 0;
                                            main.AbstractObject.playSound(13);
                                            main.MainCanvas.e(2);
                                            break;
                                        case 5:
                                            main.AbstractObject.playSound(13);
                                            main.MainCanvas.e(2);
                                            aC = 4;
                                            break;
                                        case 6:
                                            main.AbstractObject.playSound(13);
                                            main.MainCanvas.e(2);
                                            aC = 13;
                                    }
                                }
                                break;
                            }
                            break;
                        }
                        break;
                    }
                    break;
                }
                break;
            case 14:
                main.Main.finishEmptyCanvas();
                break;
            case 3: // Options screen
                if (bool) {
                    mainMenuSelectedOption = 0;
                }
                aI = 3;
                main.MainCanvas.setLowScreenOption(0, 0);
                main.MainCanvas.setLowScreenOption(1, 9);
                if (main.InputController.pressedIgnoringSpecials(InputController.ACTION_UP)) {
                    main.AbstractObject.playSound(12);
                    if (--optionScreenSelectedOption < 0) {
                        optionScreenSelectedOption = NUM_OPTIONS - 1;
                    }
                } else if (main.InputController.pressedIgnoringSpecials(InputController.ACTION_DOWN)) {
                    main.AbstractObject.playSound(12);
                    if (++optionScreenSelectedOption >= NUM_OPTIONS) {
                        optionScreenSelectedOption = 0;
                    }
                } else if (main.InputController.pressedIgnoringSpecials(
                        InputController.ACTION_LEFT
                        | InputController.ACTION_RIGHT
                ) // 20480
                        ) {
                    switch (optionScreenSelectedOption) {
                        case 0:
                            main.AbstractObject.playSound(12);
                            if (main.InputController.pressedIgnoringSpecials(InputController.ACTION_RIGHT)) {
                                if (++optionsDifficulty > 2) {
                                    optionsDifficulty = 0;
                                }
                            } else if (main.InputController.pressedIgnoringSpecials(InputController.ACTION_LEFT) && --optionsDifficulty < 0) {
                                optionsDifficulty = 2;
                            }
                            break;
                        case 1:
                            main.AbstractObject.playSound(12);
                            if ((optionVibration & 0x1) == 0) {
                                optionVibration |= 0x1;
                                main.Main.vibrateHigh();
                                break;
                            }
                            optionVibration &= ~0x1;
                            break;
                        // Custom code
                        case 2:
                            InputController.useSor2Controlls = !InputController.useSor2Controlls;
                            break;
                        case 3:
                            if (main.InputController.pressedIgnoringSpecials(InputController.ACTION_LEFT | InputController.ACTION_RIGHT)){
                                GameManager.partnerMode = (GameManager.partnerMode == 0) ? 2 : 0;
                                //if (--GameManager.partnerMode < 0) GameManager.partnerMode = 2;
                            //}else if (main.InputController.pressedIgnoringSpecials(InputController.ACTION_RIGHT)){
                                //if (++GameManager.partnerMode > 2) GameManager.partnerMode = 0;
                            }
                            break;
                    }
                } else if (main.InputController.pressedIgnoringSpecials(InputController.ACTION_RIGHT_SOFT_KEY | InputController.ACTION_OK)) {
                    main.AbstractObject.playSound(19);
                    G = 5;
                    n = false;
                    mainMenuSelectedOption = 4;
                    aC = 2;
                }
                break;
            case 13:
                if (bool) {
                    aQ = 0;
                }
                main.MainCanvas.setLowScreenOptions(0, 9);
                aI = 7;
                if (main.InputController.holdedIgnoringSpecials(InputController.ACTION_DOWN)) {
                    if (++aQ > main.GameTexts.credits.length - aR) {
                        aQ = main.GameTexts.credits.length - aR;
                    }
                } else if (main.InputController.holdedIgnoringSpecials(InputController.ACTION_UP) && --aQ < 0) {
                    aQ = 0;
                }
                if (main.InputController.pressedIgnoringSpecials(
                        InputController.ACTION_JUMP
                        | InputController.ACTION_DEF_SPECIAL
                        | InputController.ACTION_PICK_ITEM
                        | InputController.ACTION_SOMETHING_2
                        | InputController.ACTION_STAR
                        | InputController.ACTION_OK
                        | InputController.ACTION_RIGHT_SOFT_KEY
                ) // 329057
                        ) {
                    main.AbstractObject.playSound(19);
                    mainMenuSelectedOption = 6;
                    aC = 2;
                }
                break;
            case 4:
                if (bool) {
                    aO = 0;
                }
                main.MainCanvas.setLowScreenOptions(0, 9);
                aI = 4;
                if (main.InputController.pressedIgnoringSpecials(InputController.ACTION_RIGHT)) {
                    if (++aO > main.GameTexts.help.length - 1) {
                        aO = main.GameTexts.help.length - 1;
                    } else {
                        main.AbstractObject.playSound(12);
                    }
                } else {
                    if (main.InputController.pressedIgnoringSpecials(InputController.ACTION_LEFT)) {
                        if (--aO < 0) {
                            aO = 0;
                        } else {
                            main.AbstractObject.playSound(12);
                        }
                    } else {
                        if (main.InputController.pressedIgnoringSpecials(
                                InputController.ACTION_JUMP
                                | InputController.ACTION_DEF_SPECIAL
                                | InputController.ACTION_PICK_ITEM
                                | InputController.ACTION_SOMETHING_2
                                | InputController.ACTION_STAR
                                | InputController.ACTION_OK
                                | InputController.ACTION_RIGHT_SOFT_KEY
                        ) // 329057
                                ) {
                            main.AbstractObject.playSound(19);
                            mainMenuSelectedOption = 5;
                            aC = 2;
                        }
                        break;
                    }
                    break;
                }
                break;
            case 6:
                if (selectScreenAnimIds[0] == aZ[0][2] || selectScreenAnimIds[1] == aZ[1][2]) {
                    main.MainCanvas.a(main.GameManager.charsArt[1], 0);
                    main.MainCanvas.a(main.GameManager.charsArt[2], 1);
                } else {
                    main.MainCanvas.a(main.GameManager.charsArt[1], 0);
                    main.MainCanvas.a(main.GameManager.charsArt[2], 1);
                    if (bool) {
                        mainMenuSelectedOption = 1;
                        main.MainCanvas.e(0);
                    }
                    main.MainCanvas.setLowScreenOptions(0, 9);
                    aI = 5;
                    aF++;
                    if (main.InputController.pressedIgnoringSpecials(InputController.ACTION_UP)) {
                        main.AbstractObject.playSound(12);
                        if (--mainMenuSelectedOption < 0) {
                            mainMenuSelectedOption = 1;
                        }
                        main.MainCanvas.e(1);
                    } else {
                        if (main.InputController.pressedIgnoringSpecials(InputController.ACTION_DOWN)) {
                            main.AbstractObject.playSound(12);
                            if (++mainMenuSelectedOption > 1) {
                                mainMenuSelectedOption = 0;
                            }
                            main.MainCanvas.e(1);
                        } else {
                            if (main.InputController.pressedIgnoringSpecials(InputController.ACTION_RIGHT_SOFT_KEY)) {
                                main.AbstractObject.playSound(19);
                                aC = 2;
                                mainMenuSelectedOption = 0;
                                aI = 2;
                            } else {
                                if (main.InputController.pressedIgnoringSpecials(
                                        InputController.ACTION_JUMP
                                        | InputController.ACTION_DEF_SPECIAL
                                        | InputController.ACTION_PICK_ITEM
                                        | InputController.ACTION_SOMETHING_2
                                        | InputController.ACTION_STAR
                                        | InputController.ACTION_OK
                                ) // 66913
                                        ) {
                                    switch (mainMenuSelectedOption) {
                                        case 0:
                                            aD = 9;
                                            aJ = 5;
                                            main.MainCanvas.e(2);
                                            break;
                                        default:
                                            aD = 11;
                                            aJ = 6;
                                            main.MainCanvas.e(2);
                                    }
                                    aE = 12;
                                    aC = 10;
                                    main.AbstractObject.playSound(13);
                                }
                                break;
                            }
                            break;
                        }
                        break;
                    }
                    break;
                }
                break;
            case 8:
            case 9:
                if (bool) {
                    mainMenuSelectedOption = 0;
                    aM = menuScreenId == 8 ? 0 : 1;
                    aE = 0;
                }
                aI = 6;
                main.MainCanvas.setLowScreenOption(0, 0);
                if (n) {
                    main.MainCanvas.setLowScreenOption(1, 11);
                    if (main.InputController.pressedIgnoringSpecials(
                            InputController.ACTION_JUMP
                            | InputController.ACTION_DEF_SPECIAL
                            | InputController.ACTION_PICK_ITEM
                            | InputController.ACTION_SOMETHING_2
                            | InputController.ACTION_STAR
                            | InputController.ACTION_OK
                            | InputController.ACTION_RIGHT_SOFT_KEY
                    ) // 329057
                            ) {
                        main.AbstractObject.playSound(13);
                        n = false;
                        aC = 1;
                        break;
                    }
                } else {
                    main.MainCanvas.setLowScreenOption(1, 9);
                    if (main.InputController.pressedIgnoringSpecials(
                            InputController.ACTION_JUMP
                            | InputController.ACTION_DEF_SPECIAL
                            | InputController.ACTION_PICK_ITEM
                            | InputController.ACTION_SOMETHING_2
                            | InputController.ACTION_STAR
                            | InputController.ACTION_OK
                            | InputController.ACTION_RIGHT_SOFT_KEY
                    ) // 329057
                            ) {
                        main.AbstractObject.playSound(19);
                        mainMenuSelectedOption = 3;
                        aC = 2;
                        break;
                    }
                }
                if (m) {
                    if (++aE > 128) {
                        if (!n && menuScreenId == 8) {
                            aC = 9;
                        } else if (!n && menuScreenId == 9) {
                            main.MainCanvas.setState(1);
                        } else {
                            aC = 1;
                        }
                        n = false;
                    }
                } else if (main.InputController.pressedIgnoringSpecials(
                        InputController.ACTION_LEFT
                        | InputController.ACTION_RIGHT
                ) // 20480
                        ) {
                    main.AbstractObject.playSound(12);
                    n = false;
                    aC = menuScreenId == 8 ? 9 : 8;
                }
                break;
            case 5: {
                if (bool) {
                    aP = 1;
                }
                main.MainCanvas var_am_107_ = this;
                main.MainCanvas.setLowScreenOptions(0, 0);
                aI = 8;
                if (main.InputController.pressedIgnoringSpecials(InputController.ACTION_UP)) {
                    if (aP != 0) {
                        main.AbstractObject.playSound(12);
                        aP = 0;
                    }
                } else if (main.InputController.pressedIgnoringSpecials(InputController.ACTION_DOWN)) {
                    if (aP != 1) {
                        main.AbstractObject.playSound(12);
                        aP = 1;
                    }
                } else if (main.InputController.pressedIgnoringSpecials(
                        InputController.ACTION_JUMP
                        | InputController.ACTION_DEF_SPECIAL
                        | InputController.ACTION_PICK_ITEM
                        | InputController.ACTION_SOMETHING_2
                        | InputController.ACTION_STAR
                        | InputController.ACTION_OK
                ) // 66913
                        ) {
                    switch (aP) {
                        case 1:
                            main.AbstractObject.playSound(19);
                            main.AudioController.updateMidiState();
                            main.AudioController.updateMidiState();
                            aC = 1;
                            break;
                        default:
                            main.AbstractObject.playSound(13);
                            main.AudioController.updateMidiState();
                            main.AudioController.updateMidiState();
                            main.MainCanvas.writeOptions();
                            try {
                                java.lang.Thread.sleep(750L);
                            } catch (java.lang.Exception exception) {
                                java.lang.Exception exception_108_;
                                (exception_108_ = exception).printStackTrace();
                            }
                            main.AudioController.closeMidiPlayer();
                            main.MainCanvas.setState(3);
                    }
                }
                break;
            }
            case 10: {
                main.MainCanvas var_am_109_ = this;
                main.MainCanvas.setLowScreenOptions(0, 0);
                if (aJ < 5) {
                    aI = 2;
                } else {
                    aI = 5;
                }
                if (--aE <= 0) {
                    main.MainCanvas.setState(aD);
                }
                break;
            }
            case 12:
                aC = 8;
                aE = 0;
                break;
        }
    }

    private static void drawHighScores(javax.microedition.lcdui.Graphics graphics, int i, int i_110_, int i_111_) {
        int i_112_ = i_111_ == 0 ? 1 : 2;
        boolean bool = true;
        boolean bool_113_ = n;
        graphics.setFont(font3);
        graphics.setColor(colorWhite);
        main.MainCanvas.drawStringWith17Anchor(graphics, main.GameTexts.miscInformation[10], i, i_110_ - 105);
        main.MainCanvas.drawStringAlignedLeft(graphics, main.GameTexts.miscInformation[11], i - 110, i_110_ - 105 + 24);
        for (int i_114_ = 4; i_114_ >= 0; i_114_--) {
            boolean bool_115_ = true;
            if (bool_113_ && ah[i_111_][i_114_] == playerScores[0]) {
                bool_115_ = main.Main.a % 12 < 8;
                bool_113_ = false;
            }
            if (bool_115_) {
                main.GameManager.a(graphics, drawPosX,
                        i_110_ - 105 + 53 + i_114_ * 20,
                        i_114_ + 1, ah[i_111_][i_114_],
                        ai[i_111_][i_114_],
                        aj[i_111_][i_114_], i_112_);
            }
        }
        graphics.setColor(colorRed);
        graphics.drawLine(i - 60, i_110_ - 84, i + 60, i_110_ - 84);
        graphics.drawLine(i - 108, i_110_ - -45, i + 108, i_110_ - -45);
        if (main.Main.a % 12 > 8) {
            bool = false;
        }
        if (i_111_ == 0) {
            main.MainCanvas.drawRegion(graphics, imageStatusAll, i - 40, i_110_ - -92, 80,
                    145, 80, 20);
        } else if (i_111_ == 1) {
            main.MainCanvas.drawRegion(graphics, imageStatusAll, i - 30, i_110_ - -92, 160,
                    145, 60, 20);
        }
        if (!m && bool) {
            javax.microedition.lcdui.Graphics graphics_116_
                    = graphics;
            int i_117_ = i - -51;
            int i_118_ = i_110_ - -97;
            i_112_ = i_117_;
            javax.microedition.lcdui.Graphics graphics_119_;
            main.MainCanvas.drawOptionSelection(graphics_119_ = graphics_116_, i_112_,
                    i_118_, true);
            main.MainCanvas.drawOptionSelection(graphics, i - 59, i_110_ - -97, false);
        }
    }

    private static void drawOptionSelection(javax.microedition.lcdui.Graphics graphics, int destX, int destY, boolean flipped) {
        if (!flipped) {
            int i_121_;
            regionRotationTransform = main.MainCanvas.rotationToImageTransform(i_121_ = 1);
        }
        main.MainCanvas.drawRegion(graphics, imageStatusAll, destX, destY + 2, 204, 185, 8, 7);
        int i_122_;
        regionRotationTransform = main.MainCanvas.rotationToImageTransform(i_122_ = 0);
    }

    public static void drawOptionSelectionFlipped(javax.microedition.lcdui.Graphics graphics, int destX, int destY) {
        main.MainCanvas.drawOptionSelection(graphics, destX, destY, true);
    }

    private static void controlSelectScreenCharsAnims(main.ObjectArt obj, int i, int[] is) {
//        selectScreenAnimTime[i]++;
//        if (main.MainCanvas.b(obj, selectScreenAnimTime[i])) {
//            selectScreenAnimTime[i] = 0;
//            if (++N[i] > is.length - 1) {
//                N[i] = 0;
//            }
//            L[i] = is[N[i]];
//        }
    }

    private static void e(int i) {
        selectScreenAnimIds[0] = aZ[0][i];
        selectScreenAnimIds[1] = aZ[1][i];
        selectScreenAnimTimes[0] = 0;
        selectScreenAnimTimes[1] = 0;
    }

    private static boolean a(main.ObjectArt var_ad, int i) {
        selectScreenAnimTimes[i]++;
        if (main.MainCanvas.b(var_ad, selectScreenAnimTimes[i])) {
            selectScreenAnimTimes[i] = 0;
            selectScreenAnimIds[i] = aZ[i][0];
        }
        return false;
    }

    private void o() {
        if (bb == 2) {
            main.MainCanvas.updateAudioVolume();
            main.MainCanvas.setLowScreenOption(1, 11);
        } else {
            main.MainCanvas var_am_124_ = this;
            main.MainCanvas.setLowScreenOptions(0, 0);
        }
        switch (bb) {
            case 0:
                bf[0] = main.ImageUtils.a(bf[0], 0, 5, 0);
                bf[1] = main.ImageUtils.a(bf[1], 0, 5, 0);
                for (int i = 2; i < bf.length; i++) {
                    bf[i] = main.ImageUtils.a(bf[i], 0, 2, 0);
                }
                if (java.lang.Math.abs(bf[0]) < 32768
                        && ++bd >= bi.length) {
                    bd = bi.length;
                }
                if (bf[0] == 0 && bf[2] == 0) {
                    bb++;
                }
                break;
            case 1:
                if (++bd >= bi.length) {
                    bd = bi.length;
                    bb++;
                }
                break;
            case 2:
                
                if (main.InputController.pl1.pressedExceptSpecials(InputController.ACTION_RIGHT | InputController.ACTION_DOWN)) {
//                    if (player1Selection != 1) {
//                        N[1] = 0;
//                        L[1] = aY[1][0];
//                        selectScreenAnimTime[1] = 0;
//                        player1Selection = 1;
//                        main.AbstractObject.playSound(12);
//                    }
                    if (++player1Selection > 2) player1Selection = 0;
                    main.AbstractObject.playSound(12);
                } else if (main.InputController.pl1.pressedExceptSpecials(InputController.ACTION_LEFT | InputController.ACTION_UP)) {
//                    if (player1Selection != 0) {
//                        N[0] = 0;
//                        L[0] = aY[0][0];
//                        selectScreenAnimTime[0] = 0;
//                        player1Selection = 0;
//                        main.AbstractObject.playSound(12);
//                    }
                    if (--player1Selection < 0) player1Selection = 2;
                    main.AbstractObject.playSound(12);
                } 
                
                // Check pl2 selection
                if (GameManager.partnerMode != 0) {
                    if (main.InputController.pl2.pressedExceptSpecials(InputController.ACTION_RIGHT | InputController.ACTION_DOWN)) {
                        if (++player2Selection > 2) player2Selection = 0;
                        main.AbstractObject.playSound(12);
                    } else if (main.InputController.pl2.pressedExceptSpecials(InputController.ACTION_LEFT | InputController.ACTION_UP)) {
                        if (--player2Selection < 0) player2Selection = 2;
                        main.AbstractObject.playSound(12);
                    }
                }
                
                
                if (main.InputController.pressedIgnoringSpecials(InputController.ACTION_RIGHT_SOFT_KEY)) {
                    n = false;
                    aK = false;
                    U = false;
                    main.AbstractObject.playSound(19);
                    main.MainCanvas.setState(6);
                } else if (main.InputController.pressedIgnoringSpecials(
                        InputController.ACTION_JUMP
                        | InputController.ACTION_DEF_SPECIAL
                        | InputController.ACTION_PICK_ITEM
                        | InputController.ACTION_SOMETHING_2
                        | InputController.ACTION_STAR
                        | InputController.ACTION_OK
                ) // 66913
                        ) {
                    playerIds[0] = player1Selection + 1;
                    if (GameManager.partnerMode != 0)
                        playerIds[1] = player2Selection + 1;
//                    switch (player1Selection) {
//                        default:
//                            playerIds[0] = 1;
//                            if (GameManager.partnerMode == 2)
//                                playerIds[1] = 2;
//                            main.AbstractObject.playSound(41);
//                            break;
//                        case 1:
//                            playerIds[0] = 2;
//                            if (GameManager.partnerMode == 2)
//                                playerIds[1] = 1;
//                            main.AbstractObject.playSound(46);
//                    }
//                    if (GameManager.partnerMode == 1)
//                        playerIds[1] = 3;
                    level = levelSelectOption;
                    bb++;
                    bc = 12;
                }
                break;
            case 3:
                if (--bc <= 0) {
                    bb++;
                }
                break;
            case 4:
                main.AudioController.stopAllAudio();
                main.MainCanvas.setState(10);
                break;
        }
        main.MainCanvas.controlSelectScreenCharsAnims(main.GameManager.charsArt[3], 0, aY[0]);
        main.MainCanvas.controlSelectScreenCharsAnims(main.GameManager.charsArt[2], 1, aY[1]);
    }

    private static void draw(
            javax.microedition.lcdui.Graphics graphics,
            main.ObjectArt objArt, int x, int y, int animId,
            int frameNum, int unusedParam
    ) {
        main.ObjectArt.screenGraphics = graphics;
        objArt.setAnimationId(animId);
        objArt.draw(x >> 12, y >> 12, frameNum);
    }

    private static boolean b(main.ObjectArt obj, int animTime) {
        int time;
        if ((time = obj.currentAnimTotalTime()) >= 1 && animTime < time - 1) {
            return false;
        }
        return true;
    }

    private static void drawSelectScreen(javax.microedition.lcdui.Graphics graphics, int i, int i_130_) {
        boolean axelSelected = player1Selection == 0;
        boolean blazeSelected = player1Selection == 1;
        graphics.setColor(colorBlack);
        graphics.fillRect(0, 0, 320, 240);
        if (imageOpening != null) {
            imageOpening = aU[aV[ main.Main.a / 4 % aV.length]];
            for (int i_132_ = screenClipWidth / imageOpening.getWidth() + 1; i_132_ >= 0; i_132_--) {
                graphics.drawImage(imageOpening, az + i_132_ * imageOpening.getWidth(), 0, 0);
            }
        }
        for (int i_133_ = 0; i_133_ < bg.length; i_133_++) {
            int[] is = bh[i_133_];
            main.MainCanvas.drawRegion(graphics, imageStatusAll, i - is[0] + (bf[i_133_] >> 12), is[1], is[2], is[3], is[4], is[5]);
        }
        // Draw player selection
        if (bd >= bi.length) {
            main.MainCanvas.draw(graphics, main.GameManager.charsArt[player1Selection + 1], i - 96 << 12, 819200, 0,0,0);//selectScreenAnimIds[0], selectScreenAnimTimes[0], 0);
            if (GameManager.partnerMode != 0) {
                main.MainCanvas.draw(graphics, main.GameManager.charsArt[player2Selection + 1], i + 96 << 12, 819200, 0,0,0);//selectScreenAnimIds[1], selectScreenAnimTimes[1], 0);
            }
//            else {
//                main.MainCanvas.draw(graphics, main.GameManager.charsArt[player2Selection + 1], i + 96 << 12, 819200, 28, 0, 128);
//            }
//            if (player1Selection == 0) {
//                main.MainCanvas.draw(graphics, main.GameManager.charsArt[1], i - 96 << 12, 819200, L[0], selectScreenAnimTime[0], 0);
//                main.MainCanvas.draw(graphics, main.GameManager.charsArt[2], i + 96 << 12, 819200, 28, 0, 128);
//            } else {
//                main.MainCanvas.draw(graphics, main.GameManager.charsArt[1], i - 96 << 12, 819200, 27, 0, 128);
//                main.MainCanvas.draw(graphics, main.GameManager.charsArt[2], i + 96 << 12, 819200, L[1], selectScreenAnimTime[1], 0);
//            }
            if (bb == 3 && (bc & 0x1) != 0) {
                axelSelected = false;
                blazeSelected = false;
            }
            // Draw Character Name
            // TODO: Axel, Blaze, Adam
            main.MainCanvas.drawRegion(graphics, imageStatusAll, i - 70 - 32, i_130_ - 40 + 16, 80, axelSelected ? 145 : 165, 80, 20);
            main.MainCanvas.drawRegion(graphics, imageStatusAll, i + 70 - 40, i_130_ - 40 + 16, 160, blazeSelected ? 145 : 165, 60, 20);
        }
        // Draw Star status
//        for (int i_134_ = 0; i_134_ < bd; i_134_++) {
//            int[] is;
//            if ((is = bi[i_134_]) != null) {
//                main.MainCanvas.drawRegion(graphics, imageStatusAll, i - (160 - is[0]), is[1], player1Selection == 0 ? 204 : 211, 192, 7, 7);
//            }
//            if ((is = bj[i_134_]) != null) {
//                main.MainCanvas.drawRegion(graphics, imageStatusAll, i - (160 - is[0]), is[1], player1Selection == 1 ? 204 : 211, 192, 7, 7);
//            }
//        }
    }

    private static int drawMenuCorner(javax.microedition.lcdui.Graphics graphics, int i, int i_135_, int i_136_) {
        main.MainCanvas.drawRegion(graphics, imageAdd0, i, i_135_,
                bk[i_136_][0] - bk[7][0],
                bk[i_136_][1] - bk[7][1], 8, 8);
        return i + 8;
    }

    private static void drawMenuBounds(javax.microedition.lcdui.Graphics graphics, int i, int i_137_, int i_138_, int i_139_) {
        i -= (i_138_ << 3) / 2;
        i_137_ -= (i_139_ << 3) / 2;
        int i_140_ = main.MainCanvas.drawMenuCorner(graphics, i, i_137_, 7);
        for (int i_141_ = 0; i_141_ < i_138_ - 2; i_141_++) {
            i_140_ = main.MainCanvas.drawMenuCorner(graphics, i_140_, i_137_, 8);
        }
        main.MainCanvas.drawMenuCorner(graphics, i_140_, i_137_, 9);
        i_137_ += 8;
        for (int i_142_ = 0; i_142_ < i_139_ - 2; i_142_++) {
            i_140_ = main.MainCanvas.drawMenuCorner(graphics, i, i_137_, 4);
            for (int i_143_ = 0; i_143_ < i_138_ - 2; i_143_++) {
                i_140_
                        = main.MainCanvas.drawMenuCorner(graphics, i_140_, i_137_, 5);
            }
            main.MainCanvas.drawMenuCorner(graphics, i_140_, i_137_, 6);
            i_137_ += 8;
        }
        i_140_ = main.MainCanvas.drawMenuCorner(graphics, i, i_137_, 1);
        for (int i_144_ = 0; i_144_ < i_138_ - 2; i_144_++) {
            i_140_ = main.MainCanvas.drawMenuCorner(graphics, i_140_, i_137_, 2);
        }
        main.MainCanvas.drawMenuCorner(graphics, i_140_, i_137_, 3);
    }

    private static void drawOptionsScreen(javax.microedition.lcdui.Graphics graphics, int i, int posY, int posX, java.lang.String[] strings, boolean bool) {
        int stringIndex = strings.length * 18 / 8 + 3;
        main.MainCanvas.drawMenuBounds(graphics, i, posY, posX, stringIndex);
        graphics.setFont(font3);
        graphics.setColor(colorWhite);
        posX = i - posX * 8 / 2 + 16;
        posY -= strings.length * 18 / 2;
        for (stringIndex = 0; stringIndex < strings.length; stringIndex++) {
            if (strings[stringIndex] != null) {
                if (bool) {
                    posX = i - font3.stringWidth(strings[stringIndex]) / 2;
                }
                main.MainCanvas.drawStringAlignedLeft(graphics, strings[stringIndex], posX, posY);
            }
            posY += 18;
        }
    }

    private static void drawMrXOptionSpeaches(javax.microedition.lcdui.Graphics graphics, int posX, int posY, int mrXSelectedOption) {
        graphics = screenGraphics;
        switch (mrXSelectedOption) {
            case 0:
            case 1: {
                main.MainCanvas.drawOptionsScreen(graphics, posX, posY - 80, 30, main.GameTexts.mrXBecomeRightHandQuestion, false);
                javax.microedition.lcdui.Graphics graphics_150_ = graphics;
                int i_151_ = posX;
                int i_152_ = posY + 80;
                java.lang.String[] confirmationStrings = main.GameTexts.confirmation;
                int selectedOption = mrXSelectedOption == 0 ? 0 : 1;
                posY = i_152_;
                posX = i_151_;
                graphics = graphics_150_;
                boolean bool = true;
                int i_155_ = confirmationStrings.length * 18 / 8 + 3;
                main.MainCanvas.drawMenuBounds(graphics, posX, posY, 10, i_155_);
                graphics.setFont(font3);
                graphics.setColor(colorWhite);
                i_155_ = posY -= confirmationStrings.length * 18 / 2;
                for (int optionIndex = 0; optionIndex < confirmationStrings.length; optionIndex++) {
                    if (selectedOption == optionIndex) {
                        graphics.setColor(colorWhite);
                    } else {
                        graphics.setColor(colorGray);
                    }
                    main.MainCanvas.drawStringAlignedLeft(graphics, confirmationStrings[optionIndex], posX - 40 + 22 + 2, posY);
                    posY += 18;
                }
                if (selectedOption < 0) {
                    bool = (++bl & 0x2) != 0;
                    selectedOption = -selectedOption;
                } else {
                    bl = 0;
                }
                if (bool) {
                    int i_158_ = posX - 40 + 8 + 2;
                    posY = i_155_ + selectedOption * 18 + 6;
                    posX = i_158_;
                    main.MainCanvas.drawOptionSelection(graphics, posX, posY, true);
                }
                break;
            }
            case 2:
                main.MainCanvas.drawOptionsScreen(graphics, posX, posY - 80, 30, main.GameTexts.mrXHappyToOblige, false);
                break;
            case 3:
                main.MainCanvas.drawOptionsScreen(graphics, posX, posY - 80, 30, main.GameTexts.mrXPromising, false);
                break;
            case 4: {
                main.AbstractObject pl1 = main.GameManager.getPlayer1();
                if (pl1 == null) pl1 = GameManager.getPlayer2();
                java.lang.String string
                        = main.GameTexts.miscInformation[16];
                if (pl1 != null) {
                    if (pl1.objectType == 1) {
                        string = main.GameTexts.miscInformation[1];
                    } else if (pl1.objectType == 2) {
                        string = main.GameTexts.miscInformation[2];
                    }
                }
                main.MainCanvas.drawOptionsScreen(graphics, posX, posY - 80, 30,
                        (new java.lang.String[]{(string
                            + main.GameTexts.miscInformation[17]),
                            main.GameTexts.miscInformation[18]}),
                        false);
                break;
            }
            case 5:
                main.MainCanvas.drawOptionsScreen(graphics, posX, posY - 80, 30,
                        main.GameTexts.mrXKneel, false);
                break;
            case 6:
                main.MainCanvas.drawOptionsScreen(graphics, posX, posY - 80, 30,
                        main.GameTexts.finalBloodOnHands, false);
        }
    }

    public static void initializeMrX() {
        mrXState = 0;
        main.MainCanvas.setState(17);
    }

    private static void mrXState() {
        main.GameManager.k = 2;
        main.AbstractObject pl1 = main.GameManager.players[0];
        main.AbstractObject pl2 = main.GameManager.players[1];
        
        boolean onlyCPU = true;
        if (GameManager.players[0] != null && GameManager.players[0].objectType != 3)
            onlyCPU = false;
        else if (GameManager.players[1] != null && GameManager.players[1].objectType != 3)
            onlyCPU = false;
        
        for (int i = 0; i < main.GameManager.collidableObjects.size(); i++) {
            main.AbstractObject var_af_159_;
            if (((var_af_159_ = ((main.AbstractObject) main.GameManager.collidableObjects.elementAt(i))).stateFlags
                    & 0x700) != 0
                    && var_af_159_.energy > 0 && (var_af_159_.stateFlags & ~0x7fffffff) == 0) {
                var_af_159_.q = 16;
            }
        }
        if (mrXState >= 4){
            if (pl1 != null) {
                if (pl1.objectType == 1) {
                    pl1.t = 27;
                    pl1.u = 0;
                } else if (pl1.objectType == 2) {
                    pl1.t = 28;
                    pl1.u = 0;
                }
            }
            if (pl2 != null) {
                if (pl2.objectType == 1) {
                    pl2.t = 27;
                    pl2.u = 0;
                } else if (pl2.objectType == 2) {
                    pl2.t = 28;
                    pl2.u = 0;
                }
            }
        }
        switch (mrXState) {
            case 0:
                bq = 1;
                br = 0;
                mrXState++;
                main.AbstractObject.playSound(54);
                InputController.reset();
            /* fall through */
            case 1:
                main.MainCanvas.drawMrXOptionSpeaches(null, drawPosX, drawPosY, bq);
                if (++br >= 6) {
                    if (main.InputController.pressedIgnoringSpecials(InputController.ACTION_UP)) {
                        if (bq != 0) {
                            main.AbstractObject.playSound(28);
                            bq = 0;
                        }
                    } else if (main.InputController.pressedIgnoringSpecials(InputController.ACTION_DOWN)) {
                        if (bq != 1) {
                            main.AbstractObject.playSound(28);
                            bq = 1;
                        }
                    } else if ((onlyCPU & GameManager.getRandomNumber(40) == 4)
                            || 
                            main.InputController.pressedIgnoringSpecials(
                            InputController.ACTION_JUMP
                            | InputController.ACTION_DEF_SPECIAL
                            | InputController.ACTION_PICK_ITEM
                            | InputController.ACTION_SOMETHING_2
                            | InputController.ACTION_STAR
                            | InputController.ACTION_OK
                    ) // 66913
                            ) {
                        if (bq == 1) {
                            mrXState++;
                            main.AudioController.loadLevelMidi(9, true);
                        } else {
                            mrXState += 2;
                        }
                    }
                }
                break;
            case 2:
                main.MainCanvas.drawMrXOptionSpeaches(null, drawPosX, drawPosY, 2);
                if ((onlyCPU & GameManager.getRandomNumber(40) == 4)
                    || main.InputController.pressedIgnoringSpecials(
                        InputController.ACTION_JUMP
                        | InputController.ACTION_DEF_SPECIAL
                        | InputController.ACTION_PICK_ITEM
                        | InputController.ACTION_SOMETHING_2
                        | InputController.ACTION_STAR
                        | InputController.ACTION_OK
                ) // 66913
                        ) {
                    // This code remove invincibility from Mr.X, even though he's not activated here
                    // Invincibility flag works for Mr.X as trigger to bring more punks..
                    for (int i = 0; i < main.GameManager.bossObjects.size(); i++) {
                        main.AbstractObject var_af_160_;
                        if ((var_af_160_ = ((main.AbstractObject) main.GameManager.bossObjects.elementAt(i)))
                                != null) {
                            var_af_160_.stateFlags &= ~AbstractObject.INVINCIBILITY_FLAG;
                        }
                    }
                    main.MainCanvas.setState(14);
                }
                break;
            case 3:
                main.MainCanvas.drawMrXOptionSpeaches(null, drawPosX, drawPosY, 3);
                if ((onlyCPU & GameManager.getRandomNumber(40) == 4)
                    || main.InputController.pressedIgnoringSpecials(
                        InputController.ACTION_JUMP
                        | InputController.ACTION_DEF_SPECIAL
                        | InputController.ACTION_PICK_ITEM
                        | InputController.ACTION_SOMETHING_2
                        | InputController.ACTION_STAR
                        | InputController.ACTION_OK
                ) // 66913
                        ) {
                    mrXState++;
                }
                break;
            case 4:
                main.MainCanvas.drawMrXOptionSpeaches(null, drawPosX, drawPosY, 4);
                if ((onlyCPU & GameManager.getRandomNumber(40) == 4)
                    || main.InputController.pressedIgnoringSpecials(
                        InputController.ACTION_JUMP
                        | InputController.ACTION_DEF_SPECIAL
                        | InputController.ACTION_PICK_ITEM
                        | InputController.ACTION_SOMETHING_2
                        | InputController.ACTION_STAR
                        | InputController.ACTION_OK
                ) // 66913
                        ) {
                    mrXState++;
                }
                break;
            case 5:
                main.MainCanvas.drawMrXOptionSpeaches(null, drawPosX, drawPosY, 5);
                if ((onlyCPU & GameManager.getRandomNumber(40) == 4)
                    || main.InputController.pressedIgnoringSpecials(
                        InputController.ACTION_JUMP
                        | InputController.ACTION_DEF_SPECIAL
                        | InputController.ACTION_PICK_ITEM
                        | InputController.ACTION_SOMETHING_2
                        | InputController.ACTION_STAR
                        | InputController.ACTION_OK
                ) // 66913
                        ) {
                    mrXState++;
                }
                break;
            case 6:
                main.MainCanvas.drawMrXOptionSpeaches(null, drawPosX, drawPosY, 6);
                if ((onlyCPU & GameManager.getRandomNumber(40) == 4)
                    || main.InputController.pressedIgnoringSpecials(
                        InputController.ACTION_JUMP
                        | InputController.ACTION_DEF_SPECIAL
                        | InputController.ACTION_PICK_ITEM
                        | InputController.ACTION_SOMETHING_2
                        | InputController.ACTION_STAR
                        | InputController.ACTION_OK
                ) // 66913
                        ) {
                    mrXState++;
                }
                break;
            case 7: // submit to Mr.X
                main.MainCanvas.j();
                main.MainCanvas.setState(19);
                break;
        }
    }

    private static boolean updateTutorialStep() {
        switch (tutorialStepMode) {
            case 0:
                main.MainCanvas.j();
                playerCopCalls[0] = 0;
                playerContinues[0] = 0;
                playerScores[0] = 0;
                main.GameManager.screenLockX = 1966080;
                main.GameManager.screenLockY = 491520;
                bt = 0;
                numTutorialConesToSpawn = 0;
                tutorialSpeachIndex = 0;
                tutorialSpeachLineIndex = 0;
                by = 0;
                tutorialSpeachLines[0] = null;
                tutorialSpeachLines[1] = null;
                tutorialPlayingStep = 0;
                main.GameManager.players[0].stateFlags |= 0x600000;
                tutorialStepMode++;
                break;
            case 1:
                if (++bt >= 10) {
                    bt = 0;
                    tutorialStepMode++;
                }
                break;
            case 2: {
                java.lang.String[] strings;
                String[][][] tutorialDoc = InputController.useSor2Controlls ? GameTexts.tutorialSpeechesSor2 : GameTexts.tutorialSpeeches;
                if (tutorialDoc.length > tutorialSpeachIndex
                        && tutorialDoc[tutorialSpeachIndex].length > tutorialSpeachLineIndex
                        && (strings = tutorialDoc[tutorialSpeachIndex][tutorialSpeachLineIndex]) != null) {
                    if (strings[1] != null) {
                        main.AbstractObject.playSound(0);
                    }
                    by = 13;
                    tutorialSpeachLines[0] = strings[0];
                    tutorialSpeachLines[1] = strings[1];
                    tutorialStepMode++;
                } else {
                    tutorialSpeachLines[0] = null;
                    tutorialSpeachLines[1] = null;
                    tutorialSpeachIndex++;
                    tutorialSpeachLineIndex = 0;
                    tutorialPlayingStep++;
                    tutorialStepMode += 2;
                    if (tutorialSpeachIndex >= tutorialDoc.length || tutorialDoc[tutorialSpeachIndex] == null) {
                        tutorialStepMode = -1;
                    }
                }
                break;
            }
            case 3:
                bv = true;
                if (main.InputController.pressedIgnoringSpecials(
                        InputController.ACTION_JUMP
                        | InputController.ACTION_DEF_SPECIAL
                        | InputController.ACTION_PICK_ITEM
                        | InputController.ACTION_SOMETHING_2
                        | InputController.ACTION_STAR
                        | InputController.ACTION_OK
                ) // 66913
                        ) {
                    tutorialSpeachLineIndex++;
                    tutorialStepMode--;
                }
                break;
            case 4: {
                bv = false;
                main.AbstractObject pl1;
                if ((pl1 = main.GameManager.getPlayer1()) != null) {
                    bv = false;
                    switch (tutorialPlayingStep) {
                        case 1:
                            if (numTutorialConesToSpawn > 3 && main.GameManager.miscObjects.isEmpty()) {
                                pl1.direction = 0;
                                tutorialStepMode -= 2;
                            }
                            break;
                        case 2:
                            if (pl1.t == 5 && pl1.u > 4) {
                                tutorialStepMode -= 2;
                            }
                            break;
                        case 3:
                            if (pl1.t != 10 || pl1.u <= 10) {
                                break;
                            }
                            tutorialStepMode -= 2;
                    }
                }
                break;
            }
            default:
                playerScores[0] = 0;
                bv = true;
                main.GameManager.clearData();
                if ((optionVibration & 0x2) != 0) {
                    main.AudioController.closeMidiPlayer();
                    main.MainCanvas.setLowScreenOption(0, 0);
                    main.MainCanvas.setLowScreenOption(1, 0);
                    if (aJ == 1) {
                        main.MainCanvas.setState(9);
                    } else if (aJ == 3) {
                        main.MainCanvas.setState(6);
                    }
                    optionVibration &= ~0x2;
                    main.MainCanvas.writeOptions();
                } else {
                    main.AudioController.closeMidiPlayer();
                    main.MainCanvas.setLowScreenOption(0, 0);
                    main.MainCanvas.setLowScreenOption(1, 0);
                    main.MainCanvas.setState(6);
                }
                return true;
        }
        if (main.InputController.pressedIgnoringSpecials(InputController.ACTION_RIGHT_SOFT_KEY)) {
            tutorialStepMode = -2;
        }
        if (main.GameManager.players[0] == null) {
            main.GameManager.respawnPlayer(0);
        }
        if (main.GameManager.players[0].energy < 7500) {
            main.GameManager.players[0].energy = 10000;
        }
        if (main.GameManager.miscObjects.isEmpty() && tutorialPlayingStep == 1) {
            if (numTutorialConesToSpawn++ < 3) {
                // spawn cone
                main.GameManager.spawnObject(130, 1572864, 819200, 983040, 0, 0, 0);
            }
        } else if (main.GameManager.enemyObjects.isEmpty() && tutorialPlayingStep == 2) {
            main.AbstractObject var_af;
            // spawn garcia
            (var_af = ((main.AbstractObject) main.GameManager.spawnObject(10, 884736, 819200, 983040, 0, 0, 0))).stateFlags |= 0x1000000;
            var_af.energy = 2900;
        } else if (main.GameManager.enemyObjects.size() < 8 && tutorialPlayingStep == 3) {
            // Spawn a bunch of garcias
            main.GameManager.players[0].stateFlags &= ~0x400000;
            int neededGarcias = 8 - main.GameManager.enemyObjects.size();
            for (int i = 0; i < neededGarcias; i++) {
                int spawnX = (main.GameManager.players[0].position.x + (24 - main.GameManager.getRandomNumber(48) << 12));
                int spawnY = (main.GameManager.players[0].position.z + (24 - main.GameManager.getRandomNumber(48) << 12));
                main.AbstractObject var_af;
                (var_af = ((main.AbstractObject) main.GameManager.spawnObject(10, spawnX, spawnY, 983040,
                        1, 0, 0))).stateFlags
                        |= 0x800000;
                var_af.energy = 1000;
            }
        }
        main.GameManager.t = 4752;
        if (by > 0) {
            by--;
        }
        return false;
    }

    private static void updateTutorialHintsDisplay(javax.microedition.lcdui.Graphics graphics) {
        main.ar.clearVector1();
        if (main.GameManager.G != null) {
            main.GameManager.G.a(main.GameManager.screenLockX, main.GameManager.screenLockY);
            main.GameManager.G.a();
        }
        for (int i = 0; i < main.GameManager.collidableObjects.size(); i++) {
            ((main.AbstractObject) main.GameManager.collidableObjects.elementAt(i)).b();
        }
        for (int i = 0; i < main.GameManager.collisionMapObjects.size(); i++) {
            ((main.CollisionMap) main.GameManager.collisionMapObjects.elementAt(i)).c();
        }
        int i = 0;
        regionRotationTransform = main.MainCanvas.rotationToImageTransform(0);
        graphics.setClip(0, 0, screenClipWidth, screenClipHeigh);
        graphics.setColor(main.MainCanvas.rgbValue(0, 0, 0));
        graphics.fillRect(0, 0, screenClipWidth, screenClipWidth);
        main.ar.b(graphics);
        if (!bv) {
            if (tutorialPlayingStep > 0 && tutorialPlayingStep < 4) {
                String[][] hintsDoc = InputController.useSor2Controlls ? GameTexts.tutorialHintsSor2 : GameTexts.tutorialHints;
                main.MainCanvas.drawOptionsScreen(graphics, drawPosX, 40, 28, hintsDoc[tutorialPlayingStep], true);
            }
        } else if (tutorialSpeachLines[0] != null) {
            i = 0;
            int i_164_ = 0;
            if (by > 0) {
                i = main.GameManager.getRandomNumber(4) - 2;
                i_164_ = main.GameManager.getRandomNumber(4) - 2;
            }
            if (tutorialSpeachLines[1] != null) {
                main.MainCanvas.drawOptionsScreen(graphics, drawPosX, 40, 28, tutorialSpeachLines, false);
            } else {
                javax.microedition.lcdui.Graphics graphics_165_
                        = graphics;
                int i_166_ = drawPosX + i;
                int i_167_ = i_164_ + 40;
                java.lang.String string = tutorialSpeachLines[0];
                int i_168_ = i_167_;
                int i_169_ = i_166_;
                javax.microedition.lcdui.Graphics graphics_170_;
                main.MainCanvas.drawMenuBounds(graphics_170_ = graphics_165_,
                        i_169_, i_168_, 28, 7);
                graphics_170_.setFont(font1);
                i_169_ = i_169_ - 120 + 16 + 12;
                i_168_ -= 18;
                graphics_170_.setColor(colorBlack);
                main.MainCanvas.drawStringAlignedLeft(graphics_170_, string, i_169_ + 1,
                        i_168_ + 1);
                graphics_170_.setColor(colorWhite);
                main.MainCanvas.drawStringAlignedLeft(graphics_170_, string, i_169_,
                        i_168_);
            }
            main.MainCanvas.drawRegion(graphics, imageStatusAll, drawPosX - 118 + i, i_164_ + 8, 160, 0, 20, 20);
        }
    }

    private static void drawCreditsPage(javax.microedition.lcdui.Graphics graphics, int destX, int destY, int pageIndex) {
        int i_173_ = 0;
        regionRotationTransform = main.MainCanvas.rotationToImageTransform(0);
        main.MainCanvas.drawRegion(graphics, imageStatusAll, destX - 13, destY - 135 + 28, 120,
                335, 26, 13);
        graphics.setFont(font3);
        graphics.setColor(colorWhite);
        i_173_ = destY - 110;
        for (int i = 0; i < aR; i++) {
            main.MainCanvas.drawStringWith17Anchor(graphics,
                    (main.GameTexts.credits[pageIndex + i]),
                    destX, i_173_ + font3.getHeight());
            i_173_ += 18;
        }
        if (pageIndex != main.GameTexts.credits.length - aR) {
            main.MainCanvas.drawRegion(graphics, imageStatusAll, destX + 100, destY + 90, 205,
                    200, 7, 8);
        }
        if (pageIndex != 0) {
            regionRotationTransform = main.MainCanvas.rotationToImageTransform(i_173_ = 2);
            main.MainCanvas.drawRegion(graphics, imageStatusAll, destX + 100, destY - 90, 205,
                    200, 7, 8);
        }
        regionRotationTransform = main.MainCanvas.rotationToImageTransform(i_173_ = 0);
    }

    private static void drawHelpPage(javax.microedition.lcdui.Graphics graphics, int destX, int destY, int pageIndex) {
        int drawingY = 0;
        regionRotationTransform = main.MainCanvas.rotationToImageTransform(0);
        main.MainCanvas.drawRegion(graphics, imageStatusAll, destX - 16 - 4, destY - 135 + 28,
                0, 270, 26, 13);
        main.MainCanvas.drawRegion(graphics, imageStatusAll, destX + 16, destY - 135 + 29,
                9 + (pageIndex + 1) * 9, 9, 9, 9);
        graphics.setFont(font3);
        graphics.setColor(colorWhite);
        drawingY = destY - 110;
        
        String[][] helpDoc = InputController.useSor2Controlls ? GameTexts.helpSor2 : GameTexts.help;
        for (int i = 0; i < helpDoc[pageIndex].length; i++) {
            if (helpDoc[pageIndex][i].startsWith("[")) { // Starts with "["
                // Draw string centered
                main.MainCanvas.drawStringWith17Anchor(graphics,
                        (helpDoc[pageIndex][i]),
                        destX, drawingY + font3.getHeight()
                );
            } else {
                // Draw string aligned to left
                main.MainCanvas.drawStringAlignedLeft(graphics,
                        (helpDoc[pageIndex][i]),
                        destX - 110, drawingY + font3.getHeight());
            }
            drawingY += 18;
        }
        if (pageIndex != helpDoc.length - 1) {
            main.MainCanvas.drawRegion(graphics, imageStatusAll, destX + 100 - 4,
                    destY + 120 - 16, 204, 185, 8, 7);
        }
        if (pageIndex != 0) {
            regionRotationTransform = main.MainCanvas.rotationToImageTransform(1);
            main.MainCanvas.drawRegion(
                    graphics, imageStatusAll, destX - 100 - 4,
                    destY + 120 - 16, 204, 185, 8, 7
            );
        }
        regionRotationTransform = main.MainCanvas.rotationToImageTransform(0);
    }

    private static void setLowScreenOption(int key, int value) {
        if (lowScreenOptionsIndexes[key] != value) {
            lowScreenOptionsIndexes[key] = value; // key == 0 means left option, key == 1 means right option
        }
    }

    private static void setLowScreenOptions(int unusedParam, int rightValue) {
        main.MainCanvas.setLowScreenOption(0, 0); // unusedParam was supposed to be the value for left option
        main.MainCanvas.setLowScreenOption(1, rightValue);
    }

    public static int rgbValue(int r, int g, int b) {
        return ((r & 0xff) << 16) + ((g & 0xff) << 8) + (b & 0xff);
    }

    public static void setRegionRotation(int i) {
        regionRotationTransform = main.MainCanvas.rotationToImageTransform(i);
    }

    private static int rotationToImageTransform(int rotationId) {
        int resultingTransform = 0;
        switch (rotationId) {
            case 0:
                resultingTransform = Sprite.TRANS_NONE;
                break;
            case 1:
                resultingTransform = Sprite.TRANS_MIRROR; // vertical mirror
                break;
            case 2:
                resultingTransform = Sprite.TRANS_MIRROR_ROT180; // horizontal mirror
                break;
            case 3:
                resultingTransform = Sprite.TRANS_ROT180;
                break;
            case 4:
                resultingTransform = Sprite.TRANS_ROT270;
                break;
            case 5:
                resultingTransform = Sprite.TRANS_MIRROR_ROT270;
                break;
            case 6:
                resultingTransform = Sprite.TRANS_MIRROR_ROT90;
                break;
            case 7:
                resultingTransform = Sprite.TRANS_ROT90;
                break;
        }
        return resultingTransform;
    }

    public final void pointerPressed(int x, int y) {
        if (x > 0 && x < 30 && y < 320 && y > 300) {
            InputController.pl1.onKeyDown(InputController.ACTION_LEFT_SOFT_KEY);
        }
        if (x < 240 && x > 210 && y < 320 && y > 300) {
            InputController.pl1.onKeyDown(InputController.ACTION_RIGHT_SOFT_KEY);
        }
        
    }

    public final void pointerReleased(int x, int y) {
        InputController.pl1.onKeyUp(InputController.ACTION_LEFT_SOFT_KEY);
        InputController.pl1.onKeyUp(InputController.ACTION_RIGHT_SOFT_KEY);
    }
    
    
   
    private int mapKeyForSinglePlayer(int key) {
        // translate key to game keys...
        if (InputController.useSor2Controlls) {
            if (key == KEY_NUM0 || key == KEY_NUM3 || key == 99  || key == 101) {
                return main.InputController.ACTION_JUMP;
            } else if (key == KEY_NUM2 || key == 120 || key == 119) {
                return main.InputController.ACTION_ATTACK;
            } else if (key == KEY_NUM1 || key == 122 || key == 113) {
                return main.InputController.ACTION_DEF_SPECIAL;
            } else if (key == KEY_NUM4 || key == 118 || key == 114) {
                return main.InputController.ACTION_STAR;
            }
        }else {
            if (key == KEY_NUM0) {
                return main.InputController.ACTION_JUMP;
            } else if (key == KEY_NUM1) {
                return main.InputController.ACTION_NUM1;
            } else if (key == KEY_NUM2) {
                return main.InputController.ACTION_NUM2;
            } else if (key == KEY_NUM3) {
                return main.InputController.ACTION_NUM3;
            } else if (key == KEY_NUM4) {
                return main.InputController.ACTION_NUM4;
            } else if (key == KEY_NUM5) {
                return main.InputController.ACTION_NUM5;
            } else if (key == KEY_NUM6) {
                return main.InputController.ACTION_NUM6;
            } else if (key == KEY_NUM7) {
                return main.InputController.ACTION_NUM7;
            } else if (key == KEY_NUM8) {
                return main.InputController.ACTION_NUM8;
            } else if (key == KEY_NUM9) {
                return main.InputController.ACTION_NUM9;
            }
        }
        if (key == KEY_STAR) {
            return main.InputController.ACTION_STAR;
        } else if (key == KEY_POUND) {
            return main.InputController.ACTION_POUND;
        } else if (key == -1) { // UP
            return main.InputController.ACTION_UP;
        } else if (key == -2) { // DOWN
            return main.InputController.ACTION_DOWN;
        } else if (key == -3) { // LEFT
            return main.InputController.ACTION_LEFT;
        } else if (key == -4) { // RIGHT
            return main.InputController.ACTION_RIGHT;
        } else if (key == -6 || key == 97) { // Left soft key
            return main.InputController.ACTION_LEFT_SOFT_KEY;
        } else if (key == -7 || key == 115) { // Right soft key
            return main.InputController.ACTION_RIGHT_SOFT_KEY;
        } else if (key == -5) { // OK
            return main.InputController.ACTION_OK;
        }
        return 0;
    }
    
    
    
    private int mapKeyForMultiPlayer(int key) {
        // translate key to game keys...
        if (InputController.useSor2Controlls) {
            // PL1 attack
            if (key == KEY_NUM0 || key == 120 || key == 119) {
                return main.InputController.ACTION_ATTACK;
            }
            // PL2 attack
            else if (key == KEY_NUM8 || key == 111) {
                return main.InputController.ACTION_ATTACK | main.InputController.ACTION_PL2;
            }
        }
        
        // PL1 keys
        if (key == KEY_NUM4 || key == 99  || key == 101) {
            return main.InputController.ACTION_JUMP;
        } else if (key == KEY_NUM6 || key == 122 || key == 113) {
            return main.InputController.ACTION_DEF_SPECIAL;
        } else if (key == KEY_NUM7 || key == 100) {
            return main.InputController.ACTION_STAR;
        }
        // PL2 Keys
        else if (key == KEY_NUM9 || key == 112) {
            return main.InputController.ACTION_JUMP | main.InputController.ACTION_PL2;
        } else if (key == FIRE || key == 105) {
            return main.InputController.ACTION_DEF_SPECIAL | main.InputController.ACTION_PL2;
        } else if (key == KEY_STAR || key == 108) {
            return main.InputController.ACTION_STAR | main.InputController.ACTION_PL2;
        }
        
        // Directional
        // PL1 keys
        if (key == KEY_NUM1 || key == 102) {
            return main.InputController.ACTION_LEFT;
        } else if (key == KEY_NUM2 || key == 103) {
            return main.InputController.ACTION_DOWN;
        } else if (key == KEY_NUM3 || key == 104) {
            return main.InputController.ACTION_RIGHT;
        } else if (key == KEY_NUM5 || key == 116) {
            return main.InputController.ACTION_UP;
        }
        // PL2 keys
        else if (key == -3) {
            return main.InputController.ACTION_LEFT | main.InputController.ACTION_PL2;
        } else if (key == -2) {
            return main.InputController.ACTION_DOWN | main.InputController.ACTION_PL2;
        } else if (key == -4) {
            return main.InputController.ACTION_RIGHT | main.InputController.ACTION_PL2;
        } else if (key == -1) {
            return main.InputController.ACTION_UP | main.InputController.ACTION_PL2;
        }
        
        else if (key == -6) { // Left soft key
            return main.InputController.ACTION_LEFT_SOFT_KEY;
        } else if (key == -7) { // Right soft key
            return main.InputController.ACTION_RIGHT_SOFT_KEY;
        } else if (key == -5) { // OK
            return main.InputController.ACTION_OK;
        }
        return 0;
    }
    

    public final void keyPressed(int key) {
        
        if (GameManager.partnerMode == 2) {
            int keyMapped = mapKeyForMultiPlayer(key);
            if ((keyMapped & InputController.ACTION_PL2) != 0){
                InputController.pl2.onKeyDown(keyMapped & ~InputController.ACTION_PL2);
            }else {
                InputController.pl1.onKeyDown(keyMapped);
            }
        }else {
            InputController.pl1.onKeyDown(mapKeyForSinglePlayer(key));
        }
    }

    public final void keyReleased(int key) {
        if (GameManager.partnerMode == 2) {
            int keyMapped = mapKeyForMultiPlayer(key);
            if ((keyMapped & InputController.ACTION_PL2) != 0){
                InputController.pl2.onKeyUp(keyMapped & ~InputController.ACTION_PL2);
            }else {
                InputController.pl1.onKeyUp(keyMapped);
            }
        }else {
            InputController.pl1.onKeyUp(mapKeyForSinglePlayer(key));
        }
    }

    private static void drawStringAlignedLeft(javax.microedition.lcdui.Graphics graphics, java.lang.String string, int x, int y) {
        graphics.drawString(string, x, y, 0);
    }

    private static void drawStringWith17Anchor(javax.microedition.lcdui.Graphics graphics, java.lang.String string, int x, int y) {
        graphics.drawString(string, x, y, 17);
    }

    public static void drawRegion(javax.microedition.lcdui.Graphics graphics,
            javax.microedition.lcdui.Image image,
            int destX, int destY, int srcX, int srcY, int srcW, int srcH
    ) {
        graphics.drawRegion(image, srcX, srcY, srcW, srcH, regionRotationTransform, destX, destY, 0);
        
        // DEBUG
        if (dumpStatusAllAreasToFile && image == imageStatusAll) {
            addArea(srcX, srcY, srcW, srcH);
        }
    }

    public static void drawRegion(
            javax.microedition.lcdui.Graphics graphics,
            javax.microedition.lcdui.Image image, int destX,
            int destY, int srcX, int srcY, int srcWidth, int srcHeight,
            int transformId
    ) {
        graphics.drawRegion(image, srcX, srcY, srcWidth, srcHeight, main.MainCanvas.rotationToImageTransform(transformId), destX, destY, 0);
    }

    private static void drawFullImage(javax.microedition.lcdui.Graphics graphics,
            javax.microedition.lcdui.Image image,
            int destX, int destY
    ) {
        graphics.drawRegion(image, 0, 0, image.getWidth(), image.getHeight(), regionRotationTransform, destX, destY, 0);
    }

    public final void showNotify() {
        o = false;
    }

    public final void hideNotify() {
        o = true;
        p = true;
    }
    
    
    ///////////////////////////////////////////
    ///                DEBUG
    ///////////////////////////////////////////
    
    static class RectArea{

        public RectArea(int x, int y, int width, int height) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }
        public int x, y, width, height;

        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final RectArea other = (RectArea) obj;
            return x == other.x && y == other.y && width == other.width && height == other.height;
        }

        public int hashCode() {
            int hash = 3;
            hash = 97 * hash + this.x;
            hash = 97 * hash + this.y;
            hash = 97 * hash + this.width;
            hash = 97 * hash + this.height;
            return hash;
        }


    }
    
    private static boolean dumpStatusAllAreasToFile = false;
    private static Vector areas = new Vector(50);
    
    private static void addArea(int x, int y, int width, int height) {
        RectArea newRect = new RectArea(x, y, width, height);
        for (int i = 0 ; i < areas.size() ; ++i) {
            if (newRect.equals(areas.elementAt(i))) return; // already added, ignore
        }
        areas.addElement(newRect);
    }
    
    private static void dumpToFile() throws IOException{
        
        String dir = FileSystemRegistry.listRoots().nextElement().toString();

        // file for areas
        FileConnection areasFileConnection = (FileConnection)Connector.open("file:///" + dir + "areas.txt");
        if (areasFileConnection.exists()){
            areasFileConnection.delete();
        }
        areasFileConnection.create();
        OutputStream areasStream = areasFileConnection.openOutputStream();
        PrintStream areasPrintStream = new PrintStream(areasStream);
        
        // Create image
        Image image = Image.createImage(imageStatusAll.getWidth(), imageStatusAll.getHeight());
        Graphics graphics = image.getGraphics();
        graphics.setColor(0, 0, 0);
        graphics.fillRect(0, 0, imageStatusAll.getWidth(), imageStatusAll.getHeight());
        graphics.drawImage(imageStatusAll, 0, 0, 0);
        graphics.setColor(255, 0, 0);
        
        RectArea rect;
        for (int i = 0 ; i < areas.size() ; ++i) {
            rect = (RectArea) areas.elementAt(i);
            areasPrintStream.println(rect.x + ", " + rect.y + ", " + rect.width + ", " + rect.height);
            graphics.drawRect(rect.x, rect.y, rect.width, rect.height);
        }
      
        areasPrintStream.flush();
        areasPrintStream.close();
        
        byte[] bytes = ObjectArt.imageToByteArray(image);
        
        if (bytes != null) {
        
            // file for image
            FileConnection imageFileConnection = (FileConnection)Connector.open("file:///" + dir + "image.bin");
            if (imageFileConnection.exists()){
                imageFileConnection.delete();
            }
            imageFileConnection.create();
            OutputStream imageStream = imageFileConnection.openOutputStream();

            imageStream.write(bytes);

            imageStream.flush();
            imageStream.close();
            
        }
    }
    
}
