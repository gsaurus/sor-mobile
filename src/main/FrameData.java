/* aw - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
package main;

import java.io.DataInputStream;
import java.io.IOException;

// Probably frame information such as attack, weapon point?...
public final class FrameData {

    private static int a;
    private static int b;
    private static int c;
    private static int d;
    private byte e;
    private short f;
    private short g;
    private short h;
    private short i;

    public final void readFromInputStream(java.io.DataInputStream datainputstream) {
        try {
            this.e = datainputstream.readByte();
            this.f = datainputstream.readShort();
            this.g = datainputstream.readShort();
            this.h = (short) (0xff & datainputstream.readByte());
            this.i = (short) (0xff & datainputstream.readByte());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public final short[] asShortArray() {
        return new short[]{this.f, this.g, this.h, this.i};
    }

    public final byte getE() {
        return this.e;
    }

    public final boolean a(int i, int i_0_, int i_1_, int i_2_, main.FrameData var_aw_3_) {
        a = java.lang.Math.abs(this.f + i - (var_aw_3_.f + i_1_));
        b = java.lang.Math.abs(this.g + i_0_ - (var_aw_3_.g + i_2_));
        c = (var_aw_3_.h + this.h) / 2;
        d = (var_aw_3_.i + this.i) / 2;
        if (a <= c && b <= d) {
            return true;
        }
        return false;
    }
}
