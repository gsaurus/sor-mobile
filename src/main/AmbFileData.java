/* aa - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
package main;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.microedition.lcdui.Image;

public final class AmbFileData {

    private main.j[] a;
    private javax.microedition.lcdui.Image[] imagesArray;
    private main.bExtendsAr[] c;
    private int d;
    private int e;
    private int f;
    private int g;
    private static java.lang.Class h;

    public AmbFileData(java.lang.String string, javax.microedition.lcdui.Image[] images, int[] is, int[] is_0_, int i) {
        if (!(string = string).endsWith(".amb")) {
            string += ".amb";
        }
        this.d = 0;
        this.f = 983040;
        this.g = 983040;
        this.e = i;
        this.imagesArray = images;
        try {
            java.lang.Class var_class = h;
            if (var_class == null) {
                java.lang.Class var_class_1_;
                try {
                    var_class_1_ = java.lang.Class
                            .forName("java.lang.Object");
                } catch (java.lang.ClassNotFoundException classnotfoundexception) {
                    java.lang.NoClassDefFoundError noclassdeffounderror
                            = new java.lang.NoClassDefFoundError(classnotfoundexception.getMessage());
                    throw noclassdeffounderror;
                }
                var_class = h = var_class_1_;
            }
            java.lang.String string_2_ = string;
            java.lang.Class var_class_3_ = var_class;
            java.lang.Object object = null;
            java.lang.Object object_4_ = null;
            if (object_4_ != null) {
                /* empty */
            }
            java.io.InputStream inputstream = main.GameManager.openInputStreamForFile(var_class_3_, string_2_);
            java.io.InputStream inputstream_5_ = inputstream;
            java.io.DataInputStream datainputstream = new java.io.DataInputStream(inputstream_5_);
            readAmbFileFromDataStream(datainputstream);
            datainputstream.close();
        } catch (java.lang.Exception exception) {
            java.lang.Exception exception_6_;
            (exception_6_ = exception).printStackTrace();
        }
        if (this.d > 0) {
            this.c = new main.bExtendsAr[this.d];
            for (int i_7_ = 0; i_7_ < this.d; i_7_++) {
                main.MainCanvas.displayLoadingScreen();
                this.c[i_7_]
                        = new main.bExtendsAr(is[i_7_], this.a[i_7_],
                                this.imagesArray[i_7_], this.a[i_7_].c,
                                this.a[i_7_].c,
                                main.GameManager.screenWidth,
                                main.GameManager.screenHeight
                        );
                this.c[i_7_].setH(is_0_[i_7_]);
            }
        }
    }

    public final void a() {
        for (int i = 0; i < this.c.length; i++) {
            if (this.c[i] != null) {
                main.ar.addElementToVector1(this.c[i]);
            }
        }
    }

    public final void b() {
        if (this.c != null) {
            this.c = null;
        }
    }

    private void readAmbFileFromDataStream(java.io.DataInputStream dis) {
        try {
            this.d = dis.readByte();
            this.a = new main.j[this.d];
            for (int i = 0; i < this.d; i++) {
                this.a[i] = new main.j();
                main.j var_j = this.a[i];
                var_j.a = dis.readShort();
                var_j.b = dis.readShort();
                var_j.c = dis.readByte();
                var_j.d = dis.readByte();
                int i_10_ = dis.readShort();
                int i_11_ = 0;
                if (i_10_ != 0) {
                    i_11_ = i_10_;
                }
                if (i_11_ > 0) {
                    // Apparently all this reading code does nothing, data is all discarded
                    // nothing comes out from this scope, so whatever this was supposed to be,
                    // this seems to be here just to skip unused data from the input stream
                    short[][] is = new short[i_10_][];
                    int i_12_ = 0;
                    int i_13_ = 0;
                    for (/**/; i_12_ < i_10_; i_12_++) {
                        byte i_14_;
                        switch (i_14_ = dis.readByte()) {
                            case 0:
                            case 1:
                            case 4:
                                is[i_13_] = new short[4];
                                is[i_13_][0] = (short) i_14_;
                                is[i_13_][1] = (short) dis.readByte();
                                is[i_13_][2] = dis.readShort();
                                is[i_13_][3] = dis.readShort();
                                i_13_++;
                                break;
                            case 2:
                                // discard one byte
                                dis.readByte();
                                break;
                            case 3:
                                // discarrd 3 bytes
                                dis.readByte();
                                dis.readByte();
                                dis.readByte();
                                break;
                        }
                    }
                }
                var_j.g = new main.ShortArray[var_j.b][var_j.a];
                for (int i_15_ = 0; i_15_ < var_j.b; i_15_++) {
                    for (int i_16_ = 0; i_16_ < var_j.a; i_16_++) {
                        main.ShortArray[] var_ahs = var_j.g[i_15_];
                        int i_17_ = i_16_;
                        byte i_18_ = dis.readByte();
                        int i_20_;
                        main.ShortArray var_ah;
                        if ((i_20_ = dis.readShort()) <= 0) {
                            if ((i_18_ & 0x4) != 0) {
                                dis.readByte();
                                dis.readByte();
                            }
                            var_ah = null;
                        } else {
                            main.ShortArray var_ah_21_;
                            (var_ah_21_ = new main.ShortArray()).array
                                    = new short[i_20_];
                            for (int i_22_ = 0; i_22_ < i_20_; i_22_++) {
                                var_ah_21_.array[i_22_]
                                        = dis.readShort();
                            }
                            if ((i_18_ & 0x4) != 0) {
                                dis.readByte();
                                dis.readByte();
                            }
                            var_ah = var_ah_21_;
                        }
                        var_ahs[i_17_] = var_ah;
                    }
                }
                if (i == 0 || i == this.e) {
                    int i_23_ = this.a[i].a * this.a[i].c << 12;
                    this.f = i_23_;
                    i_23_ = this.a[i].b * this.a[i].d << 12;
                    this.g = i_23_;
                }
            }
            for (int i = 0; i < this.d; i++) {
                main.j var_j = this.a[i];
                int i_24_ = this.f;
                int i_25_ = this.g;
                int i_26_ = i_24_;
                main.j var_j_28_;
                int i_27_ = (var_j_28_ = var_j).a * var_j_28_.c << 12;
                if (i_26_ == 0) {
                    i_26_ = 983040;
                }
                main.j var_j_29_;
                int i_30_;
                if (i_27_ == i_26_) {
                    var_j_29_ = var_j_28_;
                    i_30_ = 4096;
                } else if (i_27_ < 1310720 || i_26_ < 1310720) {
                    var_j_29_ = var_j_28_;
                    i_30_ = 0;
                } else {
                    int i_31_ = i_27_ - 1310720;
                    int i_32_ = i_26_ - 1310720;
                    var_j_29_ = var_j_28_;
                    int i_33_ = i_31_;
                    int i_34_ = i_32_;
                    int i_35_;
                    boolean bool = (((i_35_ = i_33_) ^ i_34_) & ~0x7fffffff) != 0;
                    i_25_ = 12;
                    if (i_34_ == 0) {
                        i_30_ = 2147483647;
                    } else if (i_34_ == 4096) {
                        i_30_ = i_35_;
                    } else if ((i_34_ & 0xfff) == 0) {
                        i_30_ = i_35_ / (i_34_ >> 12);
                    } else {
                        i_35_ = i_35_ < 0 ? -i_35_ : i_35_;
                        for (i_34_ = i_34_ < 0 ? -i_34_ : i_34_;
                                (i_35_ >= i_34_ ? i_35_ : i_34_) >= 1 << 31 - i_25_;
                                i_25_--) {
                            i_35_ >>= 1;
                            i_34_ >>= 1;
                        }
                        i_25_ = (i_35_ << i_25_) / i_34_ << 12 - i_25_;
                        i_30_ = bool ? -i_25_ : i_25_;
                    }
                }
                var_j_29_.e = i_30_;
                var_j_28_.f = 4096;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public final void a(javax.microedition.lcdui.Image image, int i, int i_36_, int i_37_) {
        this.c[1].setImage(image, 0, 20, 20);
    }

    public final void a(javax.microedition.lcdui.Image image, int i, int i_38_, int i_39_, int i_40_) {
        this.c[0].setImage(image, 1, 20, 20);
    }

    public final void a(int i, int i_41_) {
        for (int i_42_ = 0; i_42_ < this.c.length; i_42_++) {
            this.c[i_42_].a(i, i_41_);
        }
    }

    public final void a(int i, int i_43_, int i_44_) {
        if (i_43_ < 0) {
            i_43_ = this.c[i].getJ();
        }
        if (i_44_ < 0) {
            i_44_ = this.c[i].getK();
        }
        this.c[i].a(i_43_, i_44_);
    }

    public final void a(int i, boolean bool) {
        this.c[i].a(false);
    }
}
