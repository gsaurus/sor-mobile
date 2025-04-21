/* e - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
package main;

import javax.microedition.lcdui.Graphics;

public final class eExtendsAr extends main.ar {

    private main.ObjectArt objArt = null;
    private int f;
    private int g;
    private int currFrameNum;
    private boolean i;

    public eExtendsAr(int i, main.ObjectArt var_ad, int i_0_) {
        this.objArt = var_ad;
        this.currFrameNum = 0;
        this.i = false;
        this.f = i_0_;
        super.setH(0);
        super.setC(0);
    }

    public final void a(int i, int i_1_, int i_2_, int i_3_, int i_4_,
            int i_5_) {
        if (i >= 0) {
            super.setC(i);
        }
        super.b(i_1_, i_2_);
        this.a(i_4_);
        this.setB(i_5_);
        this.b(i_3_);
    }

    public final int a() {
        main.eExtendsAr var_e_6_;
        (var_e_6_ = this).objArt.setAnimationId((var_e_6_.b & 0x10000) == 0 ? var_e_6_.g
                : var_e_6_.f + var_e_6_.g);
        return this.objArt.currentAnimTotalTime();
    }

    public final void a(int i) {
        this.currFrameNum = i;
        if ((i = this.objArt.currentAnimTotalTime()) < 1 || this.currFrameNum >= i - 1) {
            this.i = true;
        } else {
            this.i = false;
        }
    }

    public final boolean b() {
        return this.i;
    }

    public final void b(int i) {
        this.g = i;
        this.objArt.setAnimationId((this.b & 0x10000) == 0 ? this.g : this.f + this.g);
    }

    public final boolean a(main.eExtendsAr var_e_7_, int i, int i_8_) {
        main.ObjectArt var_ad = this.objArt;
        main.ObjectArt var_ad_9_ = var_e_7_.objArt;
        main.Point2D var_m = this.e();
        main.Point2D var_m_10_ = var_e_7_.e();
        int i_11_ = (this.b & 0x10000) == 0 ? this.g : this.f + this.g;
        int i_12_ = ((var_e_7_.b & 0x10000) == 0 ? var_e_7_.g
                : var_e_7_.f + var_e_7_.g);
        if (var_ad.a(var_m.x >> 12, var_m.y >> 12, i_11_, this.currFrameNum, 1, var_ad_9_,
                var_m_10_.x >> 12, var_m_10_.y >> 12, i_12_, var_e_7_.currFrameNum,
                0)
                != null) {
            return true;
        }
        return false;
    }

    public final void a(int i, int i_13_, main.Point2D var_m) {
        main.IntPair var_an = new main.IntPair();
        this.objArt.a(i, i_13_, var_an);
        var_m.x = var_an.first << 12;
        var_m.y = var_an.second << 12;
    }

    public final void a(javax.microedition.lcdui.Graphics graphics) {
        if ((this.a & 0x8) == 0 || (main.GameManager.i & 0x2) == 0) {
            main.ObjectArt.screenGraphics = graphics;
            this.objArt.setAnimationId((this.b & 0x10000) == 0 ? this.g : this.f + this.g);
            main.Point2D var_m = this.f();
            this.objArt.draw(var_m.x >> 12, var_m.y >> 12, this.currFrameNum);
        }
    }

    public final main.FrameData[] c() {
        return this.objArt.a(this.g, this.currFrameNum);
    }
}
