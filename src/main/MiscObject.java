/* s - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
package main;

public final class MiscObject extends main.AbstractObject {

    private static final int[] W = {11, 10, 0, 2, 3, 4, 1, 5, 5, 1, 1, 1, 6, 1, 2, 7, 0, 0, 2, 0, 6, 8, 8, 0};
    private static final int[] X = {
        999999, 999999, 999999, 100, 1200, 999999, 10, 999999, 999999, 100,
        100, 100, 999999, 100, 500, 999999, 999999, 999999, 100, 999999,
        999999, 1500, 1500, 999999
    };
    private static final int[][] Y
            = {null, null, null, {221184, 65536, 131072},
            {131072, 65536, 131072}, null, {131072, 65536, 131072}, null,
            null, {131072, 65536, 131072}, {131072, 65536, 131072},
            {65536, 65536, 196608}, null, {131072, 65536, 131072},
            {221184, 65536, 131072}, null, {131072, 65536, 131072},
            {131072, 65536, 131072}, {131072, 32768, 131072}, null, null,
            null, null, null};
    private boolean Z;
    private boolean aa;
    private int ab;
    private final int ac;
    private final int ad;
    private main.AbstractObject ae;
    private int af;
    private int ag;
    private static final int[][][] ah
            = {{{0, 33}}, {{-25, 33}, {25, 33}},
            {{-50, 30}, {50, 30}}, {{-75, 24}, {75, 24}},
            {{-95, 12}, {95, 12}}, {{-107, 0}, {107, 0}},
            {{-95, -12}, {95, -12}}, {{-75, -25}, {75, -25}},
            {{-50, -30}, {50, -30}}, {{-25, -33}, {25, -33}},
            {{0, -33}}, {new int[2]}, null};

    public MiscObject(main.ObjectArt var_ad, int i, int i_0_, int i_1_,
            int i_2_, int i_3_, int i_4_, int i_5_) {
        super(100, i, i_0_, i_1_, i_2_, i_3_, i_4_);
        this.stateFlags |= 0x801;
        if (i == 0 || i == 1) {
            this.stateFlags |= 0x40000000;
        }
        this.r = new main.eExtendsAr(0, var_ad, 8);
        if (Y[i] != null) {
            this.collisionBox = (new main.CollisionBox(this.position,
                    new main.Point(Y[i][0], Y[i][1], Y[i][2])));
        }
        this.ac = W[i];
        this.direction = 0;
        this.Z = false;
        this.aa = false;
        this.energy = X[i];
        this.ad = i_5_;
        this.ag = 0;
        this.ae = null;
        this.s = 0;
        this.c(0);
        this.r.b(i_0_, i_1_ - i_2_);
        this.r.setC(this.s());
    }

    public final void setState(int i) {
        this.w();
        this.x = 2;
        this.y = 0;
        this.B = 0;
        this.ag = 0;
        this.state = i;
    }

    public final void update() {
        switch (this.ac) {
            case 1: {
                main.MiscObject var_s_6_;
                switch ((var_s_6_ = this).state) {
                    case 0:
                        var_s_6_.y = 0;
                        var_s_6_.A = 0;
                        if (var_s_6_.Z) {
                            var_s_6_.setState(1);
                            var_s_6_.c(1);
                        } else if (var_s_6_.aa) {
                            var_s_6_.h(2, 3);
                            var_s_6_.setState(2);
                        }
                        break;
                    case 1:
                        if (var_s_6_.aa) {
                            var_s_6_.h(2, 3);
                            var_s_6_.setState(2);
                        } else if (var_s_6_.loopMovement || var_s_6_.currAnimFrame > 5) {
                            var_s_6_.setState(0);
                            var_s_6_.c(0);
                            var_s_6_.Z = false;
                        }
                        break;
                    case 2:
                        if (var_s_6_.loopMovement) {
                            var_s_6_.markToDie();
                        }
                        break;
                }
                if (var_s_6_.position.y > 0 && (var_s_6_.position.y -= 131072) < 0) {
                    var_s_6_.position.y = 0;
                }
                break;
            }
            case 5: {
                main.MiscObject theThis;
                switch ((theThis = this).state) {
                    case 0:
                        theThis.c(0);
                        theThis.setState(1);
                        theThis.nextFrameToMove = 0;
                        break;
                    case 1:
                        if (theThis.difficultyAi == 7
                                && theThis.position.x - 131072 < main.GameManager.screenLockX) {
                            theThis.c(1);
                            theThis.setState(2);
                        }
                        break;
                    case 2:
                        if (++theThis.nextFrameToMove > 32) {
                            theThis.setState(3);
                        }
                        theThis.position.x -= 9102;
                        break;
                    case 3:
                        theThis.c(0);
                        break;
                }
                break;
            }
            case 2: {
                main.MiscObject var_s_8_;
                switch ((var_s_8_ = this).state) {
                    case 0:
                        var_s_8_.y = 0;
                        var_s_8_.A = 0;
                        if (var_s_8_.Z) {
                            var_s_8_.setState(1);
                            var_s_8_.c(1);
                        } else {
                            if (var_s_8_.aa) {
                                var_s_8_.h(2, 2);
                                var_s_8_.setState(2);
                            }
                            break;
                        }
                        break;
                    case 1:
                        if (var_s_8_.aa) {
                            var_s_8_.h(2, 2);
                            var_s_8_.setState(2);
                        } else {
                            if (var_s_8_.loopMovement || var_s_8_.currAnimFrame > 5) {
                                var_s_8_.setState(0);
                                var_s_8_.c(0);
                                var_s_8_.Z = false;
                            }
                            break;
                        }
                        break;
                    case 2:
                        if (var_s_8_.loopMovement) {
                            var_s_8_.markToDie();
                        }
                        break;
                }
                break;
            }
            case 3: {
                main.MiscObject theThis3;
                switch ((theThis3 = this).state) {
                    case 0:
                        theThis3.y = 0;
                        theThis3.A = 0;
                        if (theThis3.Z) {
                            theThis3.setState(1);
                            theThis3.c(1);
                        } else {
                            if (theThis3.aa) {
                                theThis3.destroyScenaryObj();
                            }
                            break;
                        }
                        break;
                    case 1:
                        if (theThis3.loopMovement) {
                            theThis3.Z = false;
                            theThis3.setState(0);
                            theThis3.c(0);
                        } else {
                            if (theThis3.aa) {
                                theThis3.destroyScenaryObj();
                            }
                            break;
                        }
                        break;
                    case 2:
                        if (theThis3.loopMovement) {
                            theThis3.setState(3);
                            theThis3.c(3);
                        }
                        break;
                }
                break;
            }
            case 4: {
                main.MiscObject theThis2 = this;
                boolean bool = false;
                switch (theThis2.state) {
                    case 0:
                        theThis2.y = 0;
                        theThis2.A = 0;
                        theThis2.c(0);
                        theThis2.setState(1);
                        theThis2.s = 7;
                        theThis2.nextFrameToMove = 0;
                        theThis2.af = 0;
                        break;
                    case 1:
                        if (main.GameManager.screenLockX > theThis2.position.x - 262144) {
                            theThis2.c(1);
                            theThis2.ae
                                    = ((main.AbstractObject) main.GameManager.spawnObject(10, theThis2.position.x,
                                            theThis2.position.z - 24576, 0,
                                            1, 0, 0));
                            theThis2.ae.stateFlags |= 0x80000;
                            theThis2.ae.p = 32;
                            theThis2.setState(2);
                        }
                        break;
                    case 2:
                        if (theThis2.loopMovement) {
                            theThis2.r.a |= 0x1;
                            if (++theThis2.af > 32) {
                                bool = true;
                            }
                        }
                        break;
                }
                if (theThis2.ae != null && theThis2.ae.energy > 0
                        && (theThis2.ae.stateFlags & ~0x7fffffff) == 0) {
                    theThis2.ae.s = 6;
                    theThis2.ae.t = 0;
                    theThis2.ae.q = 6;
                    theThis2.ae.p = 6;
                    if ((theThis2.nextFrameToMove += 10) > 256) {
                        theThis2.nextFrameToMove = 256;
                    }
                    if (theThis2.nextFrameToMove == 256) {
                        theThis2.ae.r.d = 0;
                    } else {
                        theThis2.ae.r.d = theThis2.nextFrameToMove;
                    }
                    if (theThis2.ae.position.z < main.GameManager.E[1]) {
                        theThis2.ae.position.z += 3235;
                    } else {
                        bool = true;
                    }
                }
                if (theThis2.position.x < main.GameManager.h - 81920) {
                    bool = true;
                }
                if (bool) {
                    if (theThis2.ae != null) {
                        theThis2.ae.s = 0;
                        theThis2.ae.r.d = 0;
                        theThis2.ae.stateFlags &= ~0x80000;
                        theThis2.ae = null;
                    }
                    theThis2.stateFlags |= ~0x7fffffff;
                }
                break;
            }
            case 6: {
                main.MiscObject theThis = this;
                main.AbstractObject pl1 = main.GameManager.getPlayer1();
                main.AbstractObject pl2 = main.GameManager.getPlayer2();
                boolean bool = false;
                int i = theThis.position.x + (theThis.difficultyAi == 20 ? 0 : 16384);
                int i_12_ = theThis.position.z + (theThis.difficultyAi == 20 ? 0 : 40960);
                int i_13_ = theThis.difficultyAi == 20 ? 131072 : 155648;
                int i_14_ = theThis.difficultyAi == 20 ? 24576 : 65536;
                if (pl1 != null || pl2 != null) {
                    if (theThis.getDistanceX(pl1) <= i_13_
                            && theThis.getDistanceZ(pl1) <= i_14_
                            && (theThis.stateFlags & 0x10000) == 0) {
                        bool = true;
                        theThis.nextFrameToMove++;
                    }else if (theThis.getDistanceX(pl2) <= i_13_
                            && theThis.getDistanceZ(pl2) <= i_14_
                            && (theThis.stateFlags & 0x10000) == 0) {
                        bool = true;
                        theThis.nextFrameToMove++;
                    }
                    switch (theThis.state) {
                        case 0:
                            theThis.y = 0;
                            theThis.A = 0;
                            theThis.s = 5;
                            theThis.c(0);
                            theThis.setState(1);
                            theThis.nextFrameToMove = 0;
                            break;
                        case 1:
                            if (theThis.difficultyAi == 20) {
                                if (theThis.nextFrameToMove > 5 && bool) {
                                    theThis.c(1);
                                    main.MiscObject.playSound(31);
                                    main.GameManager.c();
                                    theThis.setState(4);
                                    theThis.af = 0;
                                }
                            } else if (theThis.nextFrameToMove > 14) {
                                theThis.c(1);
                                main.MiscObject.playSound(30);
                                main.GameManager.d();
                                theThis.setState(2);
                            }
                            break;
                        case 2:
                            if (theThis.nextFrameToMove > 30) {
                                theThis.c(3);
                                main.MiscObject.playSound(30);
                                main.GameManager.d();
                                theThis.setState(3);
                            }
                            break;
                        case 3:
                            theThis.nextFrameToMove++;
                            if (theThis.t == 3 && theThis.loopMovement) {
                                main.MiscObject.addPlayerScore(0, 5000);
                                if (GameManager.partnerMode != 0) main.MiscObject.addPlayerScore(1, 5000);
                                theThis.c(2);
                            }
                            if (theThis.t == 2) {
                                main.MiscObject.b(i, i_12_, i_13_, i_14_);
                            }
                            break;
                        case 4:
                            if (theThis.loopMovement) {
                                theThis.setState(5);
                            }
                            break;
                        case 5:
                            main.MiscObject.b(i, i_12_, i_13_, i_14_);
                            if (++theThis.af > 8) {
                                main.MiscObject.playSound(31);
                                theThis.c(0);
                                theThis.setState(1);
                            }
                            break;
                    }
                }
                break;
            }
            case 7: {
                main.MiscObject var_s_15_;
                (var_s_15_ = this).stateFlags &= ~0x2;
                if (var_s_15_.state > 0 && main.MainCanvas.mainState == 16) {
                    var_s_15_.stateFlags |= 0x2;
                } else {
                    switch (var_s_15_.state) {
                        case 0:
                            var_s_15_.y = 0;
                            var_s_15_.A = 0;
                            var_s_15_.c(0);
                            var_s_15_.setState(1);
                            var_s_15_.nextFrameToMove = 0;
                            var_s_15_.s = 121;
                            break;
                        case 1: {
                            main.AbstractObject player;
                            if ((player = main.GameManager.getPlayer1()) != null
                                    && var_s_15_.getDistanceX(player) <= 491520
                                    && ++var_s_15_.nextFrameToMove > 32) {
                                var_s_15_.c(1);
                                var_s_15_.setState(2);
                                var_s_15_.nextFrameToMove = 0;
                            } else if ((player = main.GameManager.getPlayer2()) != null
                                    && var_s_15_.getDistanceX(player) <= 491520
                                    && ++var_s_15_.nextFrameToMove > 32) {
                                var_s_15_.c(1);
                                var_s_15_.setState(2);
                                var_s_15_.nextFrameToMove = 0;
                            }
                            break;
                        }
                        case 2:
                            if (++var_s_15_.nextFrameToMove == 15) {
                                main.MiscObject.playSound(31);
                                main.GameManager.e();
                                var_s_15_.f(32, 0, -100);
                            }
                            if (var_s_15_.loopMovement) {
                                var_s_15_.c(0);
                                var_s_15_.setState(0);
                            }
                            break;
                    }
                }
                break;
            }
            case 8: {
                main.MiscObject var_s_16_;
                switch ((var_s_16_ = this).state) {
                    case 0:
                        var_s_16_.y = 0;
                        var_s_16_.A = 0;
                        var_s_16_.c(0);
                        var_s_16_.setState(1);
                        var_s_16_.nextFrameToMove = 0;
                        var_s_16_.s = 7;
                        break;
                    case 1: {
                        main.AbstractObject var_af;
                        boolean bool;
                        if ((var_af = main.GameManager.getPlayer1()) != null
                                && var_s_16_.getDistanceX(var_af) <= 983040
                                && (bool = !main.GameManager.g(var_s_16_.j))) {
                            var_s_16_.c(1);
                            var_s_16_.setState(2);
                            main.GameManager.Q = 24;
                            var_s_16_.nextFrameToMove = 0;
                        }else if ((var_af = main.GameManager.getPlayer2()) != null
                                && var_s_16_.getDistanceX(var_af) <= 983040
                                && (bool = !main.GameManager.g(var_s_16_.j))) {
                            var_s_16_.c(1);
                            var_s_16_.setState(2);
                            main.GameManager.Q = 24;
                            var_s_16_.nextFrameToMove = 0;
                        }
                        break;
                    }
                    case 2:
                        if (var_s_16_.aa) {
                            main.MiscObject.playSound(4);
                            var_s_16_.c(2);
                            var_s_16_.setState(3);
                        }
                        break;
                    case 3:
                        if (var_s_16_.loopMovement) {
                            var_s_16_.stateFlags |= ~0x7fffffff;
                        }
                        break;
                }
                for (int i = 0; i < main.GameManager.collidableObjects.size(); i++) {
                    main.AbstractObject var_af;
                    if (((var_af = ((main.AbstractObject) main.GameManager.collidableObjects.elementAt(i))).stateFlags
                            & 0x700) != 0
                            && var_af.position.y <= 0) {
                        int i_17_
                                = main.ImageUtils.a(var_s_16_.position.x - 196608,
                                        var_s_16_.position.z + 196608,
                                        var_s_16_.position.x + 589824,
                                        var_s_16_.position.z - 196608,
                                        var_af.position.x, var_af.position.z,
                                        true);
                        if ((var_af.stateFlags & 0x600) != 0) {
                            if (i_17_ > 32768) {
                                i_17_ = 32768;
                            } else if (i_17_ < -32768) {
                                i_17_ = -32768;
                            }
                        }
                        var_af.position.x += i_17_;
                    }
                }
                break;
            }
            case 9: {
                main.MiscObject var_s_18_;
                switch ((var_s_18_ = this).state) {
                    case 0:
                        var_s_18_.y = 0;
                        var_s_18_.A = 0;
                        var_s_18_.c(0);
                        var_s_18_.setState(1);
                        break;
                    case 1:
                        if (var_s_18_.loopMovement) {
                            var_s_18_.setState(2);
                        }
                        break;
                    case 2:
                        var_s_18_.stateFlags |= ~0x7fffffff;
                        break;
                }
                break;
            }
            case 10: {
                main.MiscObject var_s_19_;
                int i = (var_s_19_ = this).ad == 0 ? 1 : 0;
                switch (var_s_19_.state) {
                    case 0:
                        var_s_19_.y = 0;
                        var_s_19_.A = 0;
                        var_s_19_.g.y = -24576;
                        var_s_19_.g.x = i == 1 ? 8192 : -8192;
                        var_s_19_.c(i);
                        var_s_19_.setState(1);
                    /* fall through */
                    case 1:
                        if (var_s_19_.position.y > 0) {
                            var_s_19_.g.y -= 4096;
                            var_s_19_.position.x += var_s_19_.g.x;
                            if ((var_s_19_.position.y += var_s_19_.g.y) > 0) {
                                break;
                            }
                        }
                        main.GameManager.e();
                        main.MiscObject.playSound(25);
                        var_s_19_.position.y = 0;
                        var_s_19_.nextFrameToMove = 0;
                        var_s_19_.setState(2);
                        break;
                    case 2:
                        for (int i_20_ = 0; i_20_ < ah[var_s_19_.nextFrameToMove].length; i_20_++) {
                            int i_21_
                                    = var_s_19_.position.x + (ah[var_s_19_.nextFrameToMove][i_20_][0] << 12);
                            int i_22_
                                    = var_s_19_.position.z + (ah[var_s_19_.nextFrameToMove][i_20_][1] << 12);
                            main.GameManager.spawnObject(106, i_21_, i_22_, 0, 0, 0, 0);
                        }
                        if (var_s_19_.nextFrameToMove > 6) {
                            main.GameManager.d();
                            main.MiscObject.playSound(25);
                        }
                        if (ah[++var_s_19_.nextFrameToMove] == null) {
                            var_s_19_.setState(3);
                            main.MiscObject.playSound(9);
                        }
                        break;
                    case 3:
                        var_s_19_.stateFlags |= ~0x7fffffff;
                        break;
                }
                break;
            }
            case 11: {
                main.MiscObject var_s_23_;
                int i = (var_s_23_ = this).ad == 0 ? 0 : 1;
                switch (var_s_23_.state) {
                    case 0:
                        var_s_23_.y = 0;
                        var_s_23_.A = 0;
                        var_s_23_.c(i);
                        main.MiscObject.playSound(22);
                        var_s_23_.position.x = main.GameManager.screenLockX - 1146880;
                        if (main.GameManager.currentLevel == 6) {
                            var_s_23_.s = 127;
                        }
                        var_s_23_.setState(1);
                        var_s_23_.af = 0;
                        break;
                    case 1:
                        var_s_23_.u = 0;
                        var_s_23_.currAnimFrame = 0;
                        if (++var_s_23_.af >= 16) {
                            var_s_23_.setState(2);
                        }
                        break;
                    case 2:
                        var_s_23_.position.x
                                += (main.GameManager.screenLockX - var_s_23_.position.x) / 4;
                        if (var_s_23_.currAnimFrame <= 12 && var_s_23_.currAnimFrame >= 6) {
                            var_s_23_.d(64, 0, -8);
                        }
                        if (var_s_23_.currAnimFrame == 35) {
                            main.GameManager.e();
                            main.MiscObject.playSound(23);
                        }
                        if (var_s_23_.currAnimFrame == 39) {
                            var_s_23_.state++;
                        }
                        break;
                    case 3:
                        if (var_s_23_.loopMovement) {
                            var_s_23_.setState(4);
                        }
                        break;
                    case 4:
                        var_s_23_.stateFlags |= ~0x7fffffff;
                        break;
                    default:
                        break;
                }
                break;
            }
        }
        this.direction = 0;
        this.h();
        if (--this.ag < 0) {
            this.A = -1;
            this.B = -1;
        }
        if (main.MainCanvas.mainState == 14 && this.y()) {
            this.markToDie();
        }
    }

    private boolean checkObjectBehindHammer(main.AbstractObject obj, int maxZ, int minZ) {
        if ((obj.stateFlags & ~0x77ffffff) != 0 || (this.stateFlags & ~0x7fffffff) != 0) {
            return false;
        }
        if (obj.p > 0 || obj.position.z < maxZ || obj.position.z > minZ || this == obj) {
            return false;
        }
        if (this.A != 0 && this.A == obj.B) {
            return false;
        }
        main.eExtendsAr var_e = this.r;
        main.eExtendsAr var_e_25_ = obj.r;
        obj.h();
        boolean bool = false;
        try {
            bool = var_e.a(var_e_25_, 1, 0);
        } catch (java.lang.Exception exception) {
            java.lang.Exception exception_26_;
            (exception_26_ = exception).printStackTrace();
        }
        return bool;
    }

    public final void checkHammerSmash() {
        if (this.ac == 7) {
            int maxZ = 819200;
            int minZ = main.GameManager.F[5];
            for (int i = 0; i < main.GameManager.players.length; i++) {
                main.AbstractObject player;
                if ((player = main.GameManager.players[i]) != null && checkObjectBehindHammer(player, maxZ, minZ)) {
                    // lvl 5 hammers gets here
                    this.e(0);
                    player.onAttackContact(this, this.A, this.x, player.getDirectionTowardObject(this), 2500);
                    player.c(0, 0, 40);
                }
            }
            for (int i = 0; i < main.GameManager.enemyObjects.size(); i++) {
                main.AbstractObject enemy = ((main.AbstractObject) main.GameManager.enemyObjects.elementAt(i));
                if (checkObjectBehindHammer(enemy, maxZ, minZ)) {
                    this.e(0);
                    enemy.onAttackContact(this, this.A, this.x, enemy.getDirectionTowardObject(this), 2500);
                    enemy.c(0, 0, 40);
                }
            }
        }
    }

    public final void onAttackContact(main.AbstractObject var_af, int i, int i_30_,
            int i_31_, int i_32_) {
        if (this.ac != 8 || var_af != null) {
            this.B = i;
            this.y = i_30_;
            this.ab = i_31_;
            this.ag = 6;
            this.Z = true;
            if (this.energy < i_32_) {
                this.energy = 0;
            } else {
                this.energy -= i_32_;
            }
        }
    }

    public final void e() {
        this.aa = true;
    }

    public final void b() {
        if ((this.stateFlags & ~0x7fffffff) == 0 && this.r != null) {
            main.ar.addElementToVector1(this.r);
        }
    }

    public final void clearData() {
        this.clearAbstractData();
        if (this.ae != null) {
            this.ae = null;
        }
    }

    public final boolean d() {
        return false;
    }

    private void h(int i, int i_33_) {
        this.c(this.ab == 0 ? 2 : i_33_);
        switch (this.difficultyAi) {
            case 3:
                main.MiscObject.playSound(9);
                main.GameManager.e();
                this.f(0, 0, 0);
                break;
            case 6:
                main.MiscObject.playSound(31);
                main.GameManager.e();
                this.f(0, 0, 0);
                break;
            case 9:
                main.MiscObject.playSound(29);
                break;
            case 10:
                main.MiscObject.playSound(35);
                break;
            case 11:
                main.MiscObject.playSound(34);
                break;
            case 13:
                main.MiscObject.playSound(32);
                main.GameManager.d();
                break;
            case 18:
                main.MiscObject.playSound(35);
                break;
            default:
                main.MiscObject.playSound(29);
                main.GameManager.d();
        }
        if (this.ad > 0 && this.ad < 11) {
            main.GameManager.dropWeaponOnTheFloor(this.ad, this.position.x, this.position.z + 12288,
                    131072, 3);
        }
    }

    private void destroyScenaryObj() {
        java.lang.Object object = null;
        if (object != null) {
            /* empty */
        }
        if (!main.GameManager._a0()) {
            h(2, 2);
            this.setState(2);
            main.MiscObject.playSound(29);
            main.MiscObject.addPlayerScore(0, 3000);
            if (GameManager.partnerMode != 0) main.MiscObject.addPlayerScore(1, 3000);
        }
    }

    private static void b(int i, int i_34_, int distX, int distZ) {
        if (!main.GameManager.copsBeingCalled) {
            for (int i_37_ = 0; i_37_ < main.GameManager.collidableObjects.size(); i_37_++) {
                main.AbstractObject obj;
                if (((obj = ((main.AbstractObject) main.GameManager.collidableObjects.elementAt(i_37_))).stateFlags
                        & 0x700) != 0
                        && (java.lang.Math.abs(i - obj.position.x) <= distX)
                        && (java.lang.Math.abs(i_34_ - obj.position.z) <= distZ)
                        && obj.position.y == 0 && (obj.stateFlags & 0x10000) == 0) {
                    obj.o();
                }
            }
        }
    }
}
