/* b - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
package main;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public final class bExtendsAr extends main.ar {

    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private boolean l;
    private final javax.microedition.lcdui.Image[] arrayWith2Images = new javax.microedition.lcdui.Image[2];
    private final main.j n;

    public bExtendsAr(int i, main.j var_j, javax.microedition.lcdui.Image image, int i_0_, int i_1_, int i_2_, int i_3_) {
        this.c = i;
        this.n = var_j;
        this.setImage(image, 0, i_0_, i_1_);
        main.bExtendsAr var_b_4_ = this;
        int i_5_ = i_2_;
        int i_6_ = i_3_;
        int i_7_ = i_5_;
        main.bExtendsAr var_b_8_;
        (var_b_8_ = var_b_4_).g = i_7_;
        var_b_8_.h = i_6_;
        this.a(491520, 491520);
        this.l = false;
    }

    public final void setImage(javax.microedition.lcdui.Image image, int index, int i_9_, int i_10_) {
        if (image != null) {
            this.arrayWith2Images[index] = image;
            this.e = i_9_;
            this.f = i_10_;
            this.i = this.arrayWith2Images[index].getWidth() / this.e;
            this.arrayWith2Images[index].getHeight();
        }
    }

    public final void a(int i, int i_11_) {
        this.j = i;
        this.k = i_11_;
    }

    public final void a(boolean bool) {
        this.l = !bool;
    }

    public final int getJ() {
        return this.j;
    }

    public final int getK() {
        return this.k;
    }

    public final void a(javax.microedition.lcdui.Graphics graphics) {
        main.j var_j;
        main.ShortArray[][] var_ahs = (var_j = this.n).g;
        if (this.arrayWith2Images != null && this.n != null && var_ahs != null) {
            main.Point2D var_m;
            if (this.l) {
                var_m = new main.Point2D(this.j, this.k);
            } else {
                main.bExtendsAr var_b_12_ = this;
                int i = this.j;
                int i_13_ = this.k;
                int i_14_ = i;
                main.bExtendsAr var_b_16_;
                int i_15_ = (var_b_16_ = var_b_12_).g / 2 << 12;
                int i_17_ = var_b_16_.h / 2 << 12;
                i_14_ = i_14_ < i_15_ ? i_15_ : i_14_ - i_15_;
                i_13_ = i_13_ < i_17_ ? i_17_ : i_13_ - i_17_;
                main.j var_j_19_;
                int i_18_ = (var_j_19_ = var_b_16_.n).e;
                int i_20_ = (var_j_19_ = var_b_16_.n).f;
                if (i_18_ != 4096) {
                    i_14_ = main.ImageUtils.a(i_14_, i_18_);
                }
                if (i_20_ != 4096) {
                    i_13_ = main.ImageUtils.a(i_13_, i_20_);
                }
                i_14_ += i_15_;
                i_13_ += i_17_;
                var_m = new main.Point2D(i_14_, i_13_);
            }
            int i = var_m.x >> 12;
            int i_21_ = var_m.y >> 12;
            int i_22_ = this.g / 2;
            int i_23_ = this.h / 2;
            int i_24_ = this.g / this.e + 1;
            int i_25_ = this.h / this.f + 1;
            if (i_24_ > this.n.a) {
                i_24_ = this.n.a;
            }
            if (i_25_ > this.n.b) {
                i_25_ = this.n.b;
            }
            int i_26_ = (i - i_22_) / this.e;
            int i_27_ = (i_21_ - i_23_) / this.f;
            if (i_26_ < 0) {
                i_26_ = 0;
            }
            if (i_27_ < 0) {
                i_27_ = 0;
            }
            if (i_26_ + i_24_ >= this.n.a) {
                i_24_ = this.n.a - i_26_;
            }
            if (i_27_ + i_25_ >= this.n.b) {
                i_25_ = this.n.b - i_27_;
            }
            main.Point2D var_m_28_;
            i = ((var_m_28_ = this.f()).x >> 12) - (i - i_22_) % this.e;
            i_21_ = (var_m_28_.y >> 12) - (i_21_ - i_23_) % this.f;
            javax.microedition.lcdui.Image image = this.arrayWith2Images[0];
            for (i_22_ = 0; i_22_ < i_25_; i_22_++) {
                for (i_23_ = 0; i_23_ < i_24_; i_23_++) {
                    main.ShortArray var_ah;
                    int i_29_;
                    if (((var_ah = var_ahs[i_27_ + i_22_][i_26_ + i_23_]).array).length
                            > 1) {
                        i_29_ = (var_ah.array[ main.GameManager.i % var_ah.array.length]);
                    } else {
                        i_29_ = var_ah.array[0];
                    }
                    if (i_29_ != 0) {
                        if (this.arrayWith2Images[1] != null) {
                            image = this.arrayWith2Images[i_29_ / 192];
                            i_29_ %= 192;
                        }
                        int i_30_ = i_29_ % this.i * this.e;
                        i_29_ = i_29_ / this.i * this.f;
                        int i_31_ = i_23_ * this.e + i;
                        int i_32_ = i_22_ * this.f + i_21_;
                        main.MainCanvas.drawRegion(graphics, image, i_31_,
                                i_32_, i_30_, i_29_, this.e,
                                this.f);
                    }
                }
            }
        }
    }
}
