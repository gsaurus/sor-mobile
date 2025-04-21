/* au - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
package main;

import javax.microedition.lcdui.Image;

public final class CollisionMap {

    private static javax.microedition.lcdui.Image[] collisionMaskImages;
    private int e;
    public int a;
    private int f;
    public main.Point b;
    private main.Point g;
    private int h;
    private int i;
    private main.oExtendsAr j;
    private javax.microedition.lcdui.Image k;
    private main.CollisionBox l;
    private static final short[][] m;
    private static final short[][] n;
    private static final short[][] o;
    private static main.Point2D p;
    public static int c;

    static {
        (new short[][]{{102, 44, 13, 11, 0, 0, 2},
        {220, 41, 23, 24, 1, 1, 3}, null})[2]
                = new short[]{-1, -1, 0, 0, 0, 0, -1};
        m = new short[][]{{196, 222, 13, 11, 0, 0, 2},
        {197, 233, 23, 24, 1, 1, 3},
        {-1, -1, 0, 0, 0, 0, -1}};
        n = (new short[][]{{0, 30, 12, 10, 0, 0, 1}, {0, 30, 12, 10, 0, -1, 1},
        {12, 0, 25, 20, 0, -2, 1}, {12, 0, 25, 20, 0, -3, 1},
        {12, 20, 25, 20, 0, -4, 1}, {12, 20, 25, 20, 0, -5, 1},
        {12, 20, 25, 20, 0, -5, 0}, {-1, -1, 0, 0, 0, -6, 0}});
        (new short[][]{{-1, -1}, {235, 199, 16, 16, 0, 0, 0},
        {219, 215, 30, 17, 0, 0, 0}, {182, 169, 21, 6, 0, 0, 0},
        {160, 174, 57, 9, 0, 0, 0}, {245, 240, 8, 15, 0, 0, 0},
        {219, 199, 16, 16, 0, 0, 0}, {219, 232, 26, 23, 0, 0, 0},
        {219, 176, 28, 23, 0, 0, 0}, {219, 159, 26, 17, 0, 0, 0},
        null})[10]
                = new short[]{220, 20, 26, 21, 0, 0, 0};
        o = (new short[][]{{-1, -1}, {175, 283, 16, 16, 0, 0, 0},
        {160, 299, 30, 17, 0, 0, 0}, {176, 209, 21, 5, 0, 0, 0},
        {160, 213, 57, 9, 0, 0, 0}, {186, 324, 8, 15, 0, 0, 0},
        {159, 283, 16, 16, 0, 0, 0}, {160, 316, 26, 23, 0, 0, 0},
        {160, 260, 28, 23, 0, 0, 0}, {160, 243, 26, 17, 0, 0, 0},
        {160, 222, 26, 21, 0, 0, 0}});
        p = new main.Point2D();
    }

    public static void loadCollisionMasks() {
        if (collisionMaskImages == null) {
            collisionMaskImages = new javax.microedition.lcdui.Image[6];
            collisionMaskImages[0] = main.ImageUtils.loadImage("colli_img00");
            collisionMaskImages[1] = main.ImageUtils.loadImage("colli_img01");
            collisionMaskImages[2] = main.ImageUtils.loadImage("colli_img02");
            collisionMaskImages[3] = main.ImageUtils.loadImage("colli_img03");
        }
    }

    public CollisionMap(int i, int posX, int posZ, int posY, int i_3_) {
        this.e = i;
        this.a = 0;
        this.f = 0;
        this.h = 0;
        this.i = i_3_;
        this.b = new main.Point(posX, posZ, posY);
        main.CollisionMap.loadCollisionMasks();
        try {
            this.b();
        } catch (java.lang.Exception exception) {
            exception.printStackTrace();
        }
    }

    private static int a(int i) {
        if ((i = (i - main.GameManager.E[ main.GameManager.currentLevel]
                >> 12) + 8)
                > 127) {
            i = 127;
        } else if (i < 8) {
            i = 8;
        }
        return i;
    }

    private void b(int i) {
        switch (this.f) {
            case 0:
                this.j = new main.oExtendsAr(127, main.MainCanvas.imageStatusAll, m);
                this.h = 4;
                if (i == 1) {
                    this.h = 5;
                    this.j.a(3);
                } else if (i == 2) {
                    this.h = 6;
                    this.j.a(2);
                }
                this.f++;
                break;
            case 1:
                if (this.h == 0) {
                    this.a |= ~0x7fffffff;
                }
        }
    }

    private void c(int i) {
        switch (this.f) {
            case 0:
                this.j = new main.oExtendsAr(
                        main.AbstractObject.c(this.b.z, this.b.y),
                        main.MainCanvas.imageStatusAll, o
                );
                this.j.a(i);
                this.a |= 0x100;
                this.h = 12;
                this.f++;
                if ((this.e == 9 || this.e == 8) && this.i <= 0) {
                    this.h = 40;
                    this.f = 3;
                }
                break;
            case 1:
                if (this.b.y > 0 && (this.b.y -= 40960) < 0) {
                    this.b.y = 0;
                }
                if ((this.e == 9 || this.e == 8 || this.e == 10)
                        && main.GameManager.n > 0) {
                    this.h = 24;
                    this.f = 3;
                } else {
                    // custom code
                    int pickAction;
                    if (InputController.useSor2Controlls) pickAction = InputController.ACTION_ATTACK;
                    else pickAction = InputController.ACTION_PICK_ITEM;
                    
                    AbstractObject player;
                    InputController controller;
                    // extra adam helper wont pick items
                    for (int k = 0 ; k < 2 ; ++k) {
                        player = GameManager.players[k];
                        if (player != null) {
                            controller = player.getController();
                            // allow AI to pick too...
                            if (this.h <= 0 && (controller == null || main.InputController.pressedAnyOf(
                                        InputController.ACTION_OK
                                        | pickAction
                                    ) // 65792
                                )
                                && !main.GameManager.copsBeingCalled
                                && java.lang.Math.abs(player.position.x - this.b.x) < 98304
                                && java.lang.Math.abs(player.position.z - this.b.z) < 81920
                                && (player.state == 3 || player.state == 4)
                            ){
                                player.pickItem(k, i, this.i);
                                player.setState(6);
                                this.f++;
                            }
                        }
                    }
                    break;
                }
                break;
            case 2:
                this.a |= ~0x7fffffff;
                break;
            case 3:
                if (this.b.y == 0) {
                    this.j.a |= 0x8;
                } else if (this.b.y > 0 && (this.b.y -= 40960) < 0) {
                    this.b.y = 0;
                }
                if (this.h > 0) {
                    this.h--;
                } else {
                    this.a |= ~0x7fffffff;
                    break;
                }
                break;
        }
    }

    public final void b() {
        switch (this.e) {
            case 1:
                b(0);
                break;
            case 2:
                b(1);
                break;
            case 4: {
                main.CollisionMap var_au_5_;
                switch ((var_au_5_ = this).f) {
                    case 0:
                        var_au_5_.j
                                = new main.oExtendsAr(main.CollisionMap
                                        .a(var_au_5_.b.z),
                                        main.GameManager.L[1],
                                        n);
                        var_au_5_.j.d = 160;
                        var_au_5_.h = 7;
                        var_au_5_.f++;
                        break;
                    case 1:
                        if (var_au_5_.h == 0) {
                            var_au_5_.a |= ~0x7fffffff;
                        }
                }
                break;
            }
            case 5: {
                main.CollisionMap var_au_6_;
                switch ((var_au_6_ = this).f) {
                    case 0: {
                        var_au_6_.j
                                = new main.oExtendsAr(main.CollisionMap
                                        .a(var_au_6_.b.z),
                                        main.GameManager.L[1],
                                        n);
                        var_au_6_.j.d = 160;
                        var_au_6_.g = new main.Point();
                        int i = -5 - main.GameManager.getRandomNumber(20) << 12;
                        switch (var_au_6_.i) {
                            case 0:
                                var_au_6_.g.set(-20480, i, 0);
                                var_au_6_.b.x += -131072;
                                break;
                            case 1:
                                var_au_6_.g.set(-16384, i, 0);
                                var_au_6_.b.x += -65536;
                                break;
                            case 2:
                                var_au_6_.g.set(-8192, i, 0);
                                var_au_6_.b.x += -24576;
                                break;
                            case 3:
                                var_au_6_.g.set(8192, i, 0);
                                var_au_6_.b.x += 32768;
                                break;
                            case 4:
                                var_au_6_.g.set(16384, i, 0);
                                var_au_6_.b.x += 73728;
                                break;
                            default:
                                var_au_6_.g.set(20480, i, 0);
                                var_au_6_.b.x += 122880;
                        }
                        var_au_6_.h = 16;
                        var_au_6_.f++;
                        break;
                    }
                    case 1:
                        var_au_6_.b.x += var_au_6_.g.x;
                        var_au_6_.b.z += var_au_6_.g.z;
                        var_au_6_.g.x = var_au_6_.g.x * 85 / 100;
                        var_au_6_.g.z = var_au_6_.g.z * 55 / 100;
                        var_au_6_.j.d -= 5;
                        if (var_au_6_.h == 0) {
                            var_au_6_.a |= ~0x7fffffff;
                            var_au_6_.g = null;
                        }
                }
                break;
            }
            case 6:
                c(1);
                break;
            case 7:
                c(2);
                break;
            case 8:
                c(3);
                break;
            case 9:
                c(4);
                break;
            case 10:
                c(5);
                break;
            case 11:
                c(6);
                break;
            case 12:
                c(7);
                break;
            case 13:
                c(8);
                break;
            case 14:
                c(9);
                break;
            case 15:
                c(10);
                break;
            case 16:
            case 17:
            case 18: {
                main.CollisionMap var_au_7_ = this;
                if (!main.GameManager.copsBeingCalled) {
                    switch (var_au_7_.f) {
                        case 0:
                            if (var_au_7_.e == 16) {
                                var_au_7_.k = collisionMaskImages[0];
                            } else if (var_au_7_.e == 17) {
                                var_au_7_.l
                                        = (new main.CollisionBox(var_au_7_.b,
                                                new main.Point(245760, 163840,
                                                        0)));
                            } else {
                                var_au_7_.k = collisionMaskImages[1];
                            }
                            var_au_7_.f++;
                            break;
                        case 1:
                            if (var_au_7_.e == 17) {
                                main.CollisionMap.a(var_au_7_.l, 0, 2);
                            } else if (var_au_7_.e == 18) {
                                main.CollisionMap.a(var_au_7_.k, 0,
                                        var_au_7_.b.x, var_au_7_.b.z,
                                        2);
                            } else {
                                main.CollisionMap.a(var_au_7_.k, 0,
                                        var_au_7_.b.x, var_au_7_.b.z,
                                        1);
                                break;
                            }
                            break;
                    }
                }
                break;
            }
            case 19:
            case 20: {
                main.CollisionMap var_au_8_;
                switch ((var_au_8_ = this).f) {
                    case 0:
                        if (var_au_8_.e == 19) {
                            var_au_8_.k = collisionMaskImages[0];
                        } else {
                            var_au_8_.k = collisionMaskImages[5];
                            var_au_8_.l
                                    = (new main.CollisionBox(var_au_8_.b,
                                            new main.Point(557056, 524288, 0)));
                        }
                        var_au_8_.f++;
                        break;
                    case 1:
                        if (var_au_8_.e == 20) {
                            main.CollisionMap.a(var_au_8_.l, 2, 0);
                            break;
                        }
                        main.CollisionMap.a(var_au_8_.k, 2, var_au_8_.b.x,
                                var_au_8_.b.z, 0);
                }
                break;
            }
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28: {
                main.CollisionMap var_au_9_ = this;
                if (!main.GameManager.copsBeingCalled) {
                    switch (var_au_9_.f) {
                        case 0:
                            if (var_au_9_.e == 25 || var_au_9_.e == 21) {
                                var_au_9_.k = collisionMaskImages[0];
                            } else if (var_au_9_.e == 26 || var_au_9_.e == 22) {
                                var_au_9_.l
                                        = (new main.CollisionBox(var_au_9_.b,
                                                new main.Point(245760, 163840,
                                                        0)));
                            } else if (var_au_9_.e == 27 || var_au_9_.e == 23) {
                                var_au_9_.l
                                        = (new main.CollisionBox(var_au_9_.b,
                                                new main.Point(655360, 163840,
                                                        0)));
                            } else {
                                var_au_9_.k = collisionMaskImages[1];
                            }
                            var_au_9_.f++;
                            break;
                        case 1:
                            if (var_au_9_.e == 26 || var_au_9_.e == 27) {
                                main.CollisionMap.a(var_au_9_.l, 0, 3);
                            } else if (var_au_9_.e == 25 || var_au_9_.e == 28) {
                                main.CollisionMap.a(var_au_9_.k, 0,
                                        var_au_9_.b.x, var_au_9_.b.z,
                                        3);
                            } else if (var_au_9_.e == 22 || var_au_9_.e == 23) {
                                main.CollisionMap.a(var_au_9_.l, 0, 4);
                            } else {
                                main.CollisionMap.a(var_au_9_.k, 0,
                                        var_au_9_.b.x, var_au_9_.b.z,
                                        4);
                                break;
                            }
                            break;
                    }
                }
                break;
            }
            case 29: {
                main.CollisionMap var_au_10_;
                switch ((var_au_10_ = this).f) {
                    case 0:
                        var_au_10_.f++;
                        break;
                    case 1:
                        for (int i = 0; i < main.GameManager.collidableObjects.size(); i++) {
                            main.AbstractObject obj;
                            if (((obj = ((main.AbstractObject) main.GameManager.collidableObjects.elementAt(i))).energy
                                    > 0)
                                    && (obj.stateFlags & ~0x7fffffff) == 0
                                    && (obj.stateFlags & 0x700) != 0 && obj.position.y >= 0) {
                                int i_11_
                                        = main.ImageUtils.a(65536, 614400, 286720,
                                                491520, obj.position.x,
                                                obj.position.z, true);
                                obj.position.x += i_11_;
                                i_11_ = main.ImageUtils.a(573440, 835584,
                                        1122304, 450560,
                                        obj.position.x,
                                        obj.position.z, false);
                                obj.position.x += i_11_;
                                if ((i_11_
                                        = main.ImageUtils.a(507904, 835584,
                                                1056768, 450560,
                                                obj.position.x,
                                                obj.position.z, false))
                                        != 0) {
                                    if (main.GameManager.copsBeingCalled) {
                                        obj.position.x += i_11_;
                                    } else if (obj.state == 15 && obj.currAnimFrame < 3
                                            && obj.y != 1 && obj.C == 1) {
                                        obj.g.x = 8192;
                                        if (obj.position.y >= 0) {
                                            obj.playDyingSound();
                                            obj.position.y = -1;
                                        }
                                    }
                                }
                            }
                        }
                        break;
                    default:
                        break;
                }
                break;
            }
        }
        if (this.h > 0) {
            this.h--;
        }
        if (this.j != null) {
            this.j.a(this.b.x, this.b.z, this.b.y);
        }
        if (main.MainCanvas.mainState == 14) {
            boolean bool;
            do {
                main.CollisionMap var_au_12_;
                if (((var_au_12_ = this).a & ~0x7fffffff) == 0
                        && !main.GameManager.copsBeingCalled) {
                    if (main.GameManager.currentLevel == 7) {
                        bool = (main.GameManager.g + 262144
                                < var_au_12_.b.x);
                        break;
                    }
                    if (var_au_12_.b.x < main.GameManager.h - 262144) {
                        bool = true;
                        break;
                    }
                }
                bool = false;
            } while (false);
            if (bool) {
                this.a |= ~0x7fffffff;
            }
        }
    }

    public final void c() {
        if (this.j != null && (this.a & ~0x7fffffff) == 0) {
            main.ar.addElementToVector1(this.j);
        }
    }

    public final void d() {
        if (this.k != null) {
            this.k = null;
        }
        if (this.j != null) {
            this.j = null;
        }
        if (this.l != null) {
            this.l.clearData();
            this.l = null;
        }
        if (this.b != null) {
            this.b = null;
        }
        if (this.g != null) {
            this.g = null;
        }
    }

    private static void a(main.AbstractObject obj, int i) {
        switch (i) {
            case 3:
                obj.h.x = -12288;
                break;
            case 4:
                obj.h.x = 12288;
                break;
            case 1:
            case 2:
                if ((obj.stateFlags & 0x10000) == 0) {
                    boolean bool = obj.state >= 14 && obj.state <= 19;
                    if ((obj.stateFlags & 0x100) != 0 || obj.N > 0 || bool) {
                        if (obj.position.y == 0 && (obj.stateFlags & 0x10000) == 0) {
                            obj.o();
                            break;
                        }
                    } else {
                        if (i == 2) {
                            obj.stateFlags |= 0x10000000;
                            break;
                        }
                        if (i == 1) {
                            obj.stateFlags |= 0x20000000;
                        }
                    }
                }
        }
    }

    private static void a(main.CollisionBox collisionBox, int i, int i_13_) {
        int i_14_ = collisionBox.size.x / 2 + 8192;
        p.set(0, 0);
        for (int i_15_ = 0; i_15_< main.GameManager.collidableObjects.size(); i_15_++) {
            main.AbstractObject obj;
            if (((obj = ((main.AbstractObject) main.GameManager.collidableObjects.elementAt(i_15_))).stateFlags
                    & 0x700) != 0
                    && (java.lang.Math.abs(collisionBox.position.x - obj.position.x)
                    <= i_14_)) {
                main.CollisionBox var_a_16_ = collisionBox;
                int i_17_ = i;
                int i_18_ = obj.position.x >> 12;
                int i_19_ = obj.position.z >> 12;
                main.Point2D var_m = p;
                int i_20_ = i_19_;
                int i_21_ = i_18_;
                int i_22_ = i_17_;
                main.CollisionBox var_a_24_;
                int i_23_ = (var_a_24_ = var_a_16_).size.x >> 12;
                int i_25_ = var_a_24_.size.z >> 12;
                int i_26_ = var_a_24_.position.x - var_a_24_.size.x / 2 >> 12;
                int i_27_ = var_a_24_.position.z - var_a_24_.size.z >> 12;
                int i_28_ = i_21_ - i_26_;
                int i_29_ = i_20_ - i_27_;
                boolean bool;
                if (i_28_ < 0 || i_28_ > i_23_ || i_29_ < 0 || i_29_ > i_25_) {
                    bool = false;
                } else {
                    var_m.set(0, 0);
                    switch (i_22_) {
                        case 0:
                            bool = true;
                            break;
                        case 1:
                            var_m.y = i_27_ - i_20_;
                            bool = true;
                            break;
                        case 2:
                            var_m.y = i_27_ + i_25_ - i_20_;
                            bool = true;
                            break;
                        case 3:
                            var_m.x = i_26_ - i_21_;
                            bool = true;
                            break;
                        case 4:
                            var_m.x = i_26_ + i_23_ - i_21_;
                            bool = true;
                            break;
                        default:
                            bool = false;
                    }
                }
                if (bool) {
                    obj.position.x += p.x << 12;
                    obj.position.z += p.y << 12;
                    main.CollisionMap.a(obj, i_13_);
                }
            }
        }
    }

    private static void a(javax.microedition.lcdui.Image image,
            int i, int i_30_, int i_31_, int i_32_) {
        int i_33_ = image.getWidth() / 2;
        int i_34_ = image.getHeight() / 2;
        int i_35_ = i_33_ << 12;
        i_34_ <<= 12;
        i_33_ = (i_30_ >> 12) - i_33_;
        int i_36_ = (i_31_ >> 12) - image.getHeight();
        int[] is = new int[image.getWidth() * image.getHeight()];
        image.getRGB(is, 0, image.getWidth(), 0, 0, image.getWidth(),
                image.getHeight());
        for (int i_37_ = 0; i_37_ < main.GameManager.collidableObjects.size(); i_37_++) {
            main.AbstractObject obj;
            if (((obj = ((main.AbstractObject) main.GameManager.collidableObjects.elementAt(i_37_))).stateFlags
                    & 0x700) != 0
                    && java.lang.Math
                    .abs(i_31_ - i_34_ - obj.position.z) <= i_34_
                    && (java.lang.Math.abs(i_30_ - obj.position.x)
                    <= i_35_)
                    && ((obj.stateFlags & 0x100) != 0 || c >= 6
                    || main.GameManager.currentLevel != 5)) {
                int[] is_38_ = is;
                int i_39_ = i;
                int i_40_ = (obj.position.x >> 12) - i_33_;
                int i_41_ = (obj.position.z >> 12) - i_36_;
                int i_42_ = image.getWidth();
                int i_43_ = image.getHeight();
                main.Point2D var_m = p;
                int i_44_ = i_43_;
                int i_45_ = i_42_;
                int i_46_ = i_41_;
                int i_47_ = i_40_;
                int i_48_ = i_39_;
                int[] is_49_ = is_38_;
                var_m.set(0, 0);
                boolean bool;
                while_5_:
                do {
                    if (i_47_ < 0 || i_47_ >= i_45_ || i_46_ < 0
                            || i_46_ >= i_44_) {
                        bool = false;
                    } else {
                        if ((is_49_[i_46_ * i_45_ + i_47_] & 0xffffff) != 0) {
                            switch (i_48_) {
                                case 0:
                                    bool = true;
                                    break while_5_;
                                case 1:
                                    for (i_48_ = i_46_ - 1; i_48_ >= 0; i_48_--) {
                                        if ((is_49_[i_48_ * i_45_ + i_47_]
                                                & 0xffffff)
                                                == 0) {
                                            var_m.y = i_46_ - i_48_;
                                            bool = true;
                                            break while_5_;
                                        }
                                    }
                                    var_m.y = -i_46_ - 1;
                                    bool = true;
                                    break while_5_;
                                case 2:
                                    for (i_48_ = i_46_ + 1; i_48_ < i_44_;
                                            i_48_++) {
                                        if ((is_49_[i_48_ * i_45_ + i_47_]
                                                & 0xffffff)
                                                == 0) {
                                            var_m.y = i_48_ - i_46_;
                                            bool = true;
                                            break while_5_;
                                        }
                                    }
                                    var_m.y = i_44_ - i_46_;
                                    bool = true;
                                    break while_5_;
                                case 3:
                                    for (i_48_ = i_47_ - 1; i_48_ >= 0; i_48_--) {
                                        if ((is_49_[i_46_ * i_45_ + i_48_]
                                                & 0xffffff)
                                                == 0) {
                                            var_m.x = i_47_ - i_48_;
                                            bool = true;
                                            break while_5_;
                                        }
                                    }
                                    var_m.x = -i_47_ - 1;
                                    bool = true;
                                    break while_5_;
                                case 4:
                                    for (i_48_ = i_47_ + 1; i_48_ < i_45_;
                                            i_48_++) {
                                        if ((is_49_[i_46_ * i_45_ + i_48_]
                                                & 0xffffff)
                                                == 0) {
                                            var_m.x = i_48_ - i_47_;
                                            bool = true;
                                            break while_5_;
                                        }
                                    }
                                    var_m.x = i_45_ - i_47_;
                                    bool = true;
                                    break while_5_;
                            }
                        }
                        bool = false;
                    }
                } while (false);
                if (bool) {
                    c++;
                    obj.position.x += p.x << 12;
                    obj.position.z += p.y << 12;
                    main.CollisionMap.a(obj, i_32_);
                }
            }
        }
    }
}
