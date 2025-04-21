/* ai - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
package main;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public final class ai {

    private static main.ObjectArt[] objectsArt = new main.ObjectArt[6];
    private static javax.microedition.lcdui.Image[][] images = new javax.microedition.lcdui.Image[6][];
    private static main.eExtendsAr[] eExtendsArs = new main.eExtendsAr[6];
    private static main.Point[] points = new main.Point[6];
    private static int[] intArray1 = new int[6];
    private static int[] intArray2 = new int[6];
    private static int[] intArray3 = new int[6];
    private static int[] intArray4 = new int[6];
    private static int[] intArray5 = new int[6];
    private static int[] intArray6 = new int[6];
    private static int[] intArray7 = new int[6];
    private static boolean[] boolArray1 = new boolean[6];
    private static int[] intArray8 = new int[6];
    private static int[] intArray9 = new int[6];
    private static int[] intArray10 = new int[6];
    private static int[] intArray11 = new int[6];
    private static boolean[] boolArray2 = new boolean[6];
    private static int[] intArray12 = new int[6];
    private static int endingState1;
    private static int int2;
    private static int int3 = 0;
    private static int int4 = 1;
    private static int int5 = 150;
    private static int int6 = 10;
    private static int[][][] int3dMatrix
            = {{{1, 92, 198, 60, 194, 0, 32, int4, int4, -1, 1, 2, 2, 10},
            {2, 211, 198, 185, 194, 0, 43, 0, 0, 16, 0, 2, 2, 21},
            {3, 155, 166, 127, 162, 0, 14, 0, 0, 7, 1, 2, 2, 4}},
            {{4, 164, 162, 136, 74, 0, 26, int4, int4, -1, 0, 4, 4},
            {4, 213, 195, 186, 198, 1, 26, 0, int4, -1, 1, 6, 6},
            {4, 98, 207, 49, 179, 2, 26, int4, 0, -1, 3, 8, 8}},
            {{5, 159, 188, 132, 193, 0, 17, int4, int4, 15, 0, 2, 2},
            {5, 237, 187, 220, 96, 1, 17, 0, 0, 15, 0, 2, 2},
            {5, 91, 195, 44, 96, 2, 17, 0, 0, 15, 0, 2, 2}},
            {{7, 78, 217, 96, 192, 0, 16, 0, 0, -1, 0, 1, 1},
            {7, 210, 167, 218, 75, 1, 16, 0, 0, 4, 0, 1, 1},
            {7, 163, 167, 92, 83, 2, 16, int4, int4, 4, 0, 1, 1}},
            {{6, 245, 222, 211, 140, 0, 19, 0, int4, 4, 0, 4, 17},
            {6, 137, 210, 116, 89, 1, 19, int4, 0, 12, 0, 3},
            {6, 61, 203, 43, 109, 2, 19, int4, 0, 11, 0, 2}},
            {{8, 68, 172, 59, 86, 0, 18, int4, 0, -1, 0, 3, 3, 3},
            {8, 171, 219, 103, 133, 1, 18, 0, int4, -1, 0, 3, 3, 3},
            {8, 254, 175, 221, 90, 2, 18, 0, int4, -1, 0, 3, 3, 3}},
            {{9, 153, 210, 125, 100, 0, 22, int4, 0, 13, 0, 2},
            {9, 222, 216, 218, 125, 1, 22, 0, int4, 3, 0, 4, 4},
            {9, 78, 216, 45, 114, 2, 22, int4, 0, 10, 0, 3}},
            {{10, 150, 173, 164, 70, 0, 18, 0, 0, -1, 0, 15},
            {11, 219, 198, 221, 159, 0, 14, 0, int4, 18, 0, 2},
            {12, 100, 213, 73, 121, 0, 20, int4, 0, -1, 0, 5}},
            {{13, 245, 190, 224, 100, 1, 43, int4, int4, 9, 0, 41},
            {14, 68, 200, 74, 105, 1, 43, 0, 0, 9, 0, 42},
            {15, 160, 212, 153, 190, 0, 19, 0, 0, -1, 0, 5}},
            {{17, 150, 210, 119, 104, 0, 28, int4, 0, 99, 3, 7, 7, 7, 7, 7, 7,
                7, 7, 7, 7, 7, 7, 7, 7, 7, 8}}};
    private static int int7;
    private static int int8;
    private static int endingState2;
    private static int int10;
    private static int int11;

    private static void a(int i, int i_0_, int i_1_, int i_2_, int i_3_,
            int i_4_) {
        if (eExtendsArs[i] != null) {
            if (points[i] == null) {
                points[i] = new main.Point();
            }
            if (i_0_ != -999) {
                points[i].x = i_0_;
            }
            if (i_1_ != -999) {
                points[i].z = i_1_;
            }
            if (i_2_ != -999) {
                points[i].y = i_2_;
            }
            if (i_3_ != -999) {
                intArray1[i] = i_3_;
            }
            if (i_4_ != -999) {
                intArray2[i] = i_4_;
            }
        }
    }

    public static void a() {
        endingState1 = 0;
        int8 = 0;
        int7 = 0;
        endingState2 = 0;
        int10 = 0;
        int11 = 0;
        for (int i = 0; i < 6; i++) {
            main.ai.a(i);
        }
    }

    private static void a(int i) {
        if (images[i] != null) {
            main.ImageUtils.releaseImages(images[i]);
            images[i] = null;
        }
        if (objectsArt[i] != null) {
            objectsArt[i].clearData();
            objectsArt[i] = null;
        }
        if (eExtendsArs[i] != null) {
            eExtendsArs[i] = null;
        }
    }

    public static void showGameEnding() {
        switch (endingState1) {
            case 0:
                // load level to display characters
                main.MainCanvas.d();
                main.GameManager.loadLevel(1, 0, false, 0);
                main.GameManager.screenLockX = 3031040;
                main.GameManager.screenLockY = 491520;
                endingState1++;
                int2 = 0;
                main.AudioController.loadLevelMidi(13, true);
                break;
            case 1:
                switch (endingState2) {
                    case 0:
                        if (32 <= int8 - int10) {
                            int10 = int8;
                            endingState2++;
                        }
                        break;
                    case 1:
                        for (int i = 0; i < int3dMatrix[int7].length; i++) {
                            int i_5_ = i;
                            int i_6_ = int3dMatrix[int7][i][0];
                            int i_7_ = int3dMatrix[int7][i][5];
                            int i_8_ = int3dMatrix[int7][i][6];
                            int i_9_ = i_7_;
                            int i_10_ = i_6_;
                            int i_11_;
                            main.ai.a(i_11_ = i_5_);
                            switch (i_9_) {
                                default:
                                    images[i_11_] = main.ImageUtils.createImages(main.GameManager.characterArtFiles[i_10_]);
                                    break;
                                case 1:
                                    images[i_11_] = main.ImageUtils.applyPalettesForImagesGroup(
                                            main.GameManager.characterArtFiles[i_10_],
                                            main.GameManager.characterPaletteBFiles[i_10_]
                                    );
                                    break;
                                case 2:
                                    images[i_11_] = main.ImageUtils.applyPalettesForImagesGroup(
                                            main.GameManager.characterArtFiles[i_10_],
                                            main.GameManager.characterPaletteCFiles[i_10_]
                                    );
                            }
                            java.lang.String string = "/" + main.GameManager.characterAtlasFiles[i_10_];
                            objectsArt[i_11_] = main.GameManager.loadObjectData(string, images[i_11_]);
                            eExtendsArs[i_11_] = new main.eExtendsAr(0, objectsArt[i_11_], i_8_);
                            eExtendsArs[i_11_].b = 0;
                            intArray3[i_11_] = i_10_;
                            intArray4[i_11_] = i_9_;
                            intArray10[i] = int3dMatrix[int7][i][3];
                            intArray11[i] = int3dMatrix[int7][i][4];
                            main.ai.intArray5[i] = int3dMatrix[int7][i][7];
                            intArray12[i] = int3dMatrix[int7][i][8];
                            boolArray1[i] = false;
                            boolArray2[i] = false;
                            intArray6[i] = 0;
                            intArray2[i] = 0;
                            intArray7[i] = int3dMatrix[int7][i].length - int6;
                            i_11_ = int3dMatrix[int7][i][int3dMatrix[int7][i].length - 1];
                            eExtendsArs[i].a(0, 0, 0, i_11_, 0, intArray12[i] == 0 ? 0 : 65536);
                            intArray8[i] = int3dMatrix[int7][i][int6 - 1];
                            if (99 != intArray8[i] && (intArray8[i] < 0 || eExtendsArs[i].a() - 1 < intArray8[i])) {
                                intArray8[i] = eExtendsArs[i].a() - 1;
                            }
                            main.ai.a(i, int3dMatrix[int7][i][1] << 12,
                                    int3dMatrix[int7][i][2] << 12, int5 << 12,
                                    int3dMatrix[int7][i][intArray6[i] + int6], intArray2[i]);
                        }
                        intArray9[0] = 0;
                        endingState2++;
                        break;
                    case 2: {
                        int i = int8 - int10;
                        for (int i_12_ = 0; i_12_ < int3dMatrix[int7].length; i_12_++) {
                            int i_13_ = (int) ((long) (int5 << 12)
                                    - ((((long) i + 1L << 24) / 20480L
                                    * (long) (int5 << 12))
                                    >> 12));
                            main.ai.a(i_12_, points[i_12_].x, points[i_12_].z,
                                    i_13_, intArray1[i_12_], intArray2[i_12_]);
                        }
                        if (i == 4) {
                            int10 = int8;
                            endingState2++;
                        }
                        break;
                    }
                    case 3: {
                        int i_14_;
                        int i = ((i_14_ = int8 - int10) << 24) / 40960;
                        if (4096 <= i) {
                            i = 4096;
                            int10 = int8;
                            endingState2++;
                        }
                        i = 4096 - i;
                        for (int i_15_ = 0; i_15_ < 6; i_15_++) {
                            if (eExtendsArs[i_15_] != null) {
                                intArray9[i_15_] = (int) ((long) (intArray10[i_15_] << 12)
                                        + ((1310720L * (long) i >> 12)
                                        * (long) ((main.ai.intArray5[i_15_]) == 0
                                        ? -1 : 1))) >> 12;
                            }
                        }
                        break;
                    }
                    case 4:
                        if (10 <= int8 - int10) {
                            int10 = int8;
                            endingState2++;
                            for (int i = 0; i < int3dMatrix[int7].length; i++) {
                                boolArray1[i] = true;
                                intArray6[i]++;
                                intArray2[i] = 0;
                                intArray1[i] = int3dMatrix[int7][i][intArray6[i] + int6];
                            }
                        }
                        break;
                    case 5: {
                        int i = 0;
                        int i_16_ = 0;
                        for (int i_17_ = 0; i_17_ < 6; i_17_++) {
                            if (eExtendsArs[i_17_] != null) {
                                i_16_++;
                                if (boolArray2[i_17_]) {
                                    i++;
                                }
                            }
                        }
                        if (int7 < int3dMatrix.length - 1) {
                            if (i == i_16_) {
                                int10 = int8;
                                endingState2++;
                            }
                        } else if (80 < int8) {
                            endingState2 = 9;
                            int10 = int8;
                        }
                        break;
                    }
                    case 6:
                        if (16 < int8 - int10) {
                            int10 = int8;
                            endingState2++;
                        }
                        break;
                    case 7: {
                        int i = int8 - int10;
                        for (int i_18_ = 0; i_18_ < int3dMatrix[int7].length; i_18_++) {
                            int i_19_
                                    = (int) ((((long) i << 24) / 40960L * 1310720L
                                    * (long) ((main.ai.intArray5[i_18_]
                                    == 0)
                                    ? 1 : -1))
                                    >> 12);
                            main.ai.a(i_18_, points[i_18_].x + i_19_,
                                    points[i_18_].z, points[i_18_].y, intArray1[i_18_],
                                    intArray2[i_18_]);
                        }
                        int i_20_ = (i << 24) / 40960;
                        if (4096 <= i_20_) {
                            i_20_ = 4096;
                            int10 = int8;
                            endingState2++;
                        }
                        for (int i_21_ = 0; i_21_ < 6; i_21_++) {
                            if (eExtendsArs[i_21_] != null) {
                                intArray9[i_21_] = (int) ((long) (intArray10[i_21_] << 12)
                                        + ((1310720L * (long) i_20_ >> 12)
                                        * (long) ((main.ai.intArray5[i_21_]) == 0
                                        ? -1 : 1))) >> 12;
                            }
                        }
                        break;
                    }
                    case 8:
                        for (int i = 0; i < 6; i++) {
                            if (eExtendsArs[i] != null) {
                                main.ai.a(i);
                                boolArray1[i] = false;
                                boolArray2[i] = false;
                            }
                        }
                        int10 = int8;
                        endingState2 = 0;
                        int7++;
                        break;
                    case 9:
                        if (80 < int8 - int10) {
                            int10 = int8;
                            endingState1++;
                        }
                        break;
                }
                if (++int11 > 32 && main.InputController.pressedAnyOf(InputController.ACTION_RIGHT_SOFT_KEY)) {
                    endingState1 = 2;
                }
                break;
            case 2:
                int2 = 40;
                endingState1++;
                break;
            case 3:
                if (int2 < 0) {
                    endingState1++;
                }
                int2--;
                break;
            case 4:
                for (int i = 0; i < 6; i++) {
                    main.ai.a(i);
                }
                main.GameManager.clearData();
                main.MainCanvas.n = true;
                main.MainCanvas.m = true;
                main.MainCanvas.setState(6);
                break;
        }
        for (int i = 0; i < 6; i++) {
            if (eExtendsArs[i] != null) {
                eExtendsArs[i].a(main.AbstractObject.c(points[i].z, points[i].y),
                        (main.MainCanvas.drawPosX << 12) - (655360 - points[i].x),
                        points[i].z - points[i].y, intArray1[i], intArray2[i], intArray12[i] == 0 ? 0 : 65536);
                if (!boolArray2[i]) {
                    if (eExtendsArs[i].b()) {
                        intArray2[i] = 0;
                        if (boolArray1[i] && intArray6[i] < intArray7[i] - 1) {
                            intArray1[i] = int3dMatrix[int7][i][++intArray6[i] + int6];
                            if (17 == int3dMatrix[int7][i][0] && intArray6[i] % 4 == 0) {
                                intArray12[i] ^= 0x1;
                            }
                            if (5 == int3dMatrix[int7][i][0]) {
                                intArray12[i] ^= 0x1;
                            }
                        }
                    } else {
                        intArray2[i]++;
                    }
                    if (boolArray1[i] && intArray6[i] == intArray7[i] - 1 && intArray2[i] == intArray8[i]) {
                        boolArray2[i] = true;
                    }
                }
            }
        }
        int8++;
    }

    public static void draw(javax.microedition.lcdui.Graphics graphics) {
        main.ar.clearVector1();
        if (main.GameManager.G != null) {
            main.GameManager.G.a(main.GameManager.screenLockX,
                    main.GameManager.screenLockY);
            main.GameManager.G.a();
        }
        for (int i = 0; i < 6; i++) {
            if (eExtendsArs[i] != null) {
                main.ar.addElementToVector1(eExtendsArs[i]);
            }
        }
        main.MainCanvas.setRegionRotation(0);
        graphics.setClip(0, 0, main.MainCanvas.screenClipWidth, main.MainCanvas.screenClipHeigh);
        graphics.setColor(main.MainCanvas.rgbValue(0, 0, 0));
        graphics.fillRect(0, 0, main.MainCanvas.screenClipWidth, main.MainCanvas.screenClipWidth);
        switch (endingState1) {
            case 1:
                main.ar.b(graphics);
                for (int i = 0; i < 6; i++) {
                    if (eExtendsArs[i] != null && intArray9[0] != 0) {
                        main.GameManager.a(graphics,
                                (main.MainCanvas.drawPosX
                                - (160 - intArray9[i]) + 30),
                                intArray11[i] + 10, intArray3[i], intArray4[i]);
                    }
                }
                graphics.setColor(main.MainCanvas.rgbValue(0, 0, 0));
                graphics.fillRect(0, 0, main.MainCanvas.screenClipWidth, 20);
                graphics.fillRect(0, main.MainCanvas.screenClipHeigh - 20,
                        main.MainCanvas.screenClipWidth, 20);
                break;
            case 2:
            case 3:
                main.MainCanvas.drawRegion(
                        graphics,
                        main.MainCanvas.imageStatusAll,
                        main.MainCanvas.drawPosX - 22,
                        105, 40, 337, 45, 10
                );
        }
    }
}
