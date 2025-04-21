package extra;

/* b - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
final class ImageBuildHelper // ImageBuildHelper
{

    private static int[] staticBytes;

    static int interpolateBytes(byte[] is, int i, int i_0_) {
        byte[] is_1_ = is;
        int i_2_ = i;
        i_0_ = i_0_;
        i = i_2_;
        is = is_1_;
        int i_3_ = -1;
        if (staticBytes == null) {
            staticBytes = new int[256];
            for (int i_4_ = 0; i_4_ < 256; i_4_++) {
                int i_5_ = i_4_;
                for (int i_6_ = 0; i_6_ < 8; i_6_++) {
                    if ((i_5_ & 0x1) == 1) {
                        i_5_ = ~0x12477cdf ^ i_5_ >>> 1;
                    } else {
                        i_5_ >>>= 1;
                    }
                }
                staticBytes[i_4_] = i_5_;
            }
        }
        for (int i_7_ = i; i_7_ < i_0_ + i; i_7_++) {
            i_3_ = staticBytes[(i_3_ ^ is[i_7_]) & 0xff] ^ i_3_ >>> 8;
        }
        return i_3_ ^ 0xffffffff;
    }
}
