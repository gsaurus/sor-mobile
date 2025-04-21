/* ar - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
package main;

import java.util.Vector;

import javax.microedition.lcdui.Graphics;

public abstract class ar {

    private static main.Point2D[] pairsArray = new main.Point2D[10];
    private static java.util.Vector vectorOfArObjects;
    private static java.util.Vector[] vectorOfVectorsOfArObjects;
    protected int a = 0;
    protected int b;
    protected int c = 0;
    protected int d;
    private int h;
    private int i;
    private int j;

    static {
        //new main.IntPair2(0, 0); nonsense
    }

    public abstract void a(javax.microedition.lcdui.Graphics graphics);

    public ar() {
        this.b = 0;
        this.d = 255;
        this.h = 0;
    }

    public static void d() {
        /* empty */
    }

    public static void c(int i) {
        pairsArray = new main.Point2D[10];
        for (i = 0; i < pairsArray.length; i++) {
            pairsArray[i] = new main.Point2D(0, 0);
        }
        vectorOfArObjects = new java.util.Vector(128, 128);
        vectorOfVectorsOfArObjects = new java.util.Vector[128];
    }

    public final void b(int i, int i_0_) {
        this.i = i;
        this.j = i_0_;
    }

    public final void a(int i, int i_1_, int i_2_) {
        this.i = i - main.GameManager.screenLockX + main.GameManager.halfScreenWidth12Left;
        this.j = (i_1_ - i_2_ - main.GameManager.screenLockY
                + main.GameManager.halfScreenHeight12Left);
    }

    public final main.Point2D e() {
        return new main.Point2D(this.i, this.j);
    }

    public final void setB(int i) {
        this.b = i;
    }

    public final void setC(int i) {
        this.c = i;
    }

    public final void setH(int i) {
        this.h = i;
    }

    public static void setPair(int i, main.Point2D var_m) {
        pairsArray[0].set(var_m.x, var_m.y);
    }

    public final main.Point2D f() {
        main.Point2D var_m_3_;
        main.Point2D var_m = var_m_3_ = new main.Point2D(this.i, this.j);
        main.Point2D var_m_4_ = pairsArray[this.h];
        main.Point2D var_m_5_;
        (var_m_5_ = var_m).x += var_m_4_.x;
        var_m_5_.y += var_m_4_.y;
        return var_m_3_;
    }

    public static void b(javax.microedition.lcdui.Graphics graphics) {
        int i = vectorOfVectorsOfArObjects.length;
        for (int i_6_ = 0; i_6_ < i; i_6_++) {
            vectorOfVectorsOfArObjects[i_6_] = null;
        }
        for (int i_7_ = 0; i_7_ < vectorOfArObjects.size(); i_7_++) {
            main.ar var_ar;
            main.ar var_ar_9_;
            int i_8_ = ((var_ar = var_ar_9_
                    = (main.ar) vectorOfArObjects.elementAt(i_7_)).c);
            if ((var_ar_9_.a & 0x2) != 0) {
                i_8_++;
            }
            if (i_8_ >= i) {
                i_8_ = i - 1;
            }
            if (vectorOfVectorsOfArObjects[i_8_] == null) {
                vectorOfVectorsOfArObjects[i_8_] = new java.util.Vector(0, 16);
            }
            vectorOfVectorsOfArObjects[i_8_].addElement(var_ar_9_);
        }
        for (int i_10_ = 0; i_10_ < i; i_10_++) {
            if (vectorOfVectorsOfArObjects[i_10_] != null) {
                for (int i_11_ = 0; i_11_ < vectorOfVectorsOfArObjects[i_10_].size(); i_11_++) {
                    main.ar var_ar;
                    main.ar var_ar_12_;
                    if (((var_ar = var_ar_12_ = ((main.ar) vectorOfVectorsOfArObjects[i_10_].elementAt(i_11_))).a
                            & 0x1)
                            == 0) {
                        try {
                            var_ar_12_.a(graphics);
                        } catch (java.lang.Exception exception) {
                            exception.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public static void clearVector1() {
        vectorOfArObjects.removeAllElements();
    }

    public static void addElementToVector1(java.lang.Object object) {
        vectorOfArObjects.addElement(object);
    }
}
