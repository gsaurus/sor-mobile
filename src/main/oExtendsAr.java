/* o - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
package main;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public final class oExtendsAr extends main.ar {

    private static boolean e = false;
    private javax.microedition.lcdui.Image f;
    private int g;
    private int h;
    private int i;
    private short[][] j;

    public oExtendsAr(int i, javax.microedition.lcdui.Image image,
            short[][] is) {
        this.f = image;
        this.j = is;
        this.h = 0;
        this.i = 0;
        this.g = 1;
        super.setC(i);
    }

    public final void a(javax.microedition.lcdui.Graphics graphics) {
        short[] is;
        int i = (is = this.j[this.i])[0];
        int i_0_ = is[1];
        int i_1_ = is[2];
        int i_2_ = is[3];
        int i_3_ = is[4];
        int i_4_ = is[5];
        int i_5_ = is[6];
        if ((this.b & 0x10000) != 0) {
            i_3_ = -i_3_;
        }
        boolean bool = true;
        if ((this.a & 0x8) != 0 && (main.GameManager.i & 0x1) != 0) {
            bool = false;
        }
        if ((this.a & 0x1) == 0 && i >= 0 && i_0_ >= 0 && bool) {
            switch (this.g) {
                case 2:
                    i_3_ -= i_1_ / 2;
                    i_4_ -= i_2_;
                    break;
                case 3:
                    i_3_ = i_3_;
                    i_4_ = i_4_;
                /* fall through */
                case 1:
                    i_3_ -= i_1_ / 2;
                    i_4_ -= i_2_ / 2;
                    break;
            }
            main.Point2D var_m = this.f();
            if (this.d != 0 || this.b != 0) {
                int i_6_ = 0;
                if ((this.b & 0x10000) != 0) {
                    i_6_ = 1;
                }
                main.MainCanvas.setRegionRotation(i_6_);
                main.MainCanvas.drawRegion(graphics, this.f,
                        (var_m.x >> 12) + i_3_,
                        (var_m.y >> 12) + i_4_, i, i_0_,
                        i_1_, i_2_);
                main.MainCanvas.setRegionRotation(0);
            } else {
                main.MainCanvas.drawRegion(graphics, this.f,
                        (var_m.x >> 12) + i_3_,
                        (var_m.y >> 12) + i_4_, i, i_0_,
                        i_1_, i_2_);
            }
        }
        if (this.j.length > 1 && i_5_ > 0 && ++this.h >= i_5_) {
            this.h = 0;
            if (++this.i >= this.j.length) {
                this.i = 0;
            }
        }
    }

    public final void a(int i) {
        if (i >= 0 && i < this.j.length) {
            this.i = i;
        }
    }

    public final void a(javax.microedition.lcdui.Image image) {
        this.f = image;
    }
}
