/* h - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
package main;

public final class Bongo extends main.AbstractObject {

    private static final int[] W = {30000, 20000};
    private static final int[] X = {14336, 14336, 14336};
    private static final int[] Y = {14336, 14336, 14336};
    private static final int[] Z = {23756, 23756, 23756};
    private static final int[] aa = {9830, 9830, 9830};
    private static final int[][][] ab
            = {{{0, 50}, {0, 50}, {0, 50}},
            {{0, 50}, {0, 50}, {0, 50}}};
    private static final int[][][] ac
            = {{{100, 50}, {100, 50}, {100, 50}},
            {{100, 50}, {100, 50}, {100, 50}}};
    private int ad;
    private int ae;
    private int af;
    private boolean ag;
    private int ah;
    private int ai;
    private int aj;
    private main.eExtendsAr ak;
    private main.AbstractObject al;
    private static final int[][] am
            = {{1200, 1200, 1200}, {2500, 2500, 2500}};
    private static final int[][] an
            = {{1500, 1500, 1500}, {2200, 2200, 2200}};
    private static final int[][] ao
            = {{1000, 1000, 1000}, {1800, 1800, 1800}};

    public Bongo(main.ObjectArt var_ad, int i, int i_0_, int i_1_,
            int i_2_, int i_3_, int i_4_) {
        super(12, i, i_0_, i_1_, i_2_, i_3_, i_4_);
        this.stateFlags |= 0x8401;
        this.r = new main.eExtendsAr(0, var_ad, 20);
        this.collisionBox
                = new main.CollisionBox(this.position,
                        new main.Point(131072,
                                131072,
                                131072));
        this.nextFrameToMove = 0;
        this.Q = 0;
        this.ad = 0;
        this.ae = 0;
        this.ak = new main.eExtendsAr(0, var_ad, 20);
        this.ak.d = 480;
        this.D = false;
        this.energy = W[this.difficultyAi];
        this.maxEnergy = this.energy;
        this.visualEnergy = main.GameManager.f(this.energy);
        this.name = "ISAO";
    }

    public final void update() {
        super.update();
        java.lang.Object object = null;
        if (object != null) {
            /* empty */
        }
        if (!main.GameManager._a0()) {
            main.AbstractObject target;
            int i = ((target = getPlayerTarget()) != null
                    ? this.getDirectionTowardObject(target) : -1);
            int i_5_ = main.GameManager.getRandomNumber(100);
            int i_6_ = 0;
            int i_7_ = 0;
            if (target == null) {
                if (this.state != 23 && !this.j()) {
                    this.setState(3);
                }
            } else {
                i_6_ = this.getDistanceX(target);
                i_7_ = this.getDistanceZ(target);
            }
            this.D = false;
            if (this.state != 3 && this.q > 0) {
                this.setState(3);
            }
            if (5 < this.state && this.state <= 22
                    && !main.Bongo.j(this.state)) {
                this.a(this.state, V, target);
            } else {
                main.AbstractObject var_af_9_ = target;
                int i_10_ = i;
                int i_11_ = i_6_;
                int i_12_ = i_7_;
                int i_13_ = i_5_;
                i_7_ = i_12_;
                i_6_ = i_11_;
                i_5_ = i_10_;
                main.AbstractObject var_af_14_ = var_af_9_;
                int i_16_ = 655360;
                int i_17_ = 491520;
                switch (this.state) {
                    case 23:
                        if ((this.stateFlags & INVINCIBILITY_FLAG) == 0) {
                            this.setState(3);
                        }
                        break;
                    case 0:
                        if ((this.stateFlags & INVINCIBILITY_FLAG) != 0) {
                            this.setState(23);
                            break;
                        }
                        this.setState(3);
                    /* fall through */
                    case 16:
                        if (6 == this.currAnimFrame) {
                            this.P();
                        }
                        break;
                    case 17:
                        if (2 == this.currAnimFrame) {
                            this.P();
                        }
                        break;
                    case 19:
                        if (1 == this.currAnimFrame) {
                            this.P();
                        }
                        break;
                    case 3:
                        this.A = 0;
                        this.B = 0;
                        this.g.set(0, 0, 0);
                        if (this.q > 0) {
                            this.q--;
                        } else if (var_af_14_ != null) {
                            if (96 < this.ad) {
                                this.setState(27);
                            } else {
                                this.setState(25);
                            }
                        } else {
                            this.q = 10;
                        }
                        break;
                    case 4:
                        this.A = 0;
                        this.B = 0;
                        break;
                    case 5:
                        if (this.loopMovement) {
                            this.setState(3);
                            this.p = 16;
                        }
                        break;
                    case 34:
                        this.position.x += this.velocityX;
                        this.position.z += this.velocityZ;
                        if (main.GameManager.i % 3 == 0) {
                            this.e(-20, 0, 0);
                        }
                        if (main.GameManager.i % 5 == 0) {
                            main.Bongo.playSound(32);
                        }
                        main.GameManager.c();
                        if (this.velocityX < 0) {
                            if (i_17_ < ((main.GameManager.currentLevel == 7
                                    ? main.GameManager.g - i_16_
                                    : main.GameManager.h + i_16_)
                                    - this.position.x)) {
                                this.setState(31);
                            }
                        } else if (((main.GameManager.currentLevel == 7
                                ? main.GameManager.g - i_16_
                                : main.GameManager.h + i_16_)
                                - this.position.x)
                                < -i_17_) {
                            this.setState(31);
                        }
                        if (80 < this.currAnimFrame) {
                            this.setState(31);
                        }
                        break;
                    case 31:
                        if (this.loopMovement) {
                            this.setState(3);
                        }
                        break;
                    case 24:
                        main.AbstractObject.moveToTarget(this, target);
                        if (this.e(0, 0)) {
                            this.setState(3);
                        }
                        break;
                    case 25:
                        if (450560 > i_6_) {
                            this.setState(245760 > i_7_ && 50 <= i_13_
                                    ? this.k(0) > i_13_ ? 34 : 30 : 24);
                        } else {
                            this.position.z += this.velocityZ;
                            if ((this.Q & 0x3) == 0) {
                                this.direction = this.getDirectionTowardObject(var_af_14_);
                            }
                            if (this.nextFrameToMove > 0) {
                                this.nextFrameToMove--;
                            } else {
                                this.nextFrameToMove = main.GameManager.getRandomNumber(16) + 16;
                                this.velocityZ
                                        = this.S() * (this.velocityZ < 0 ? 1 : -1);
                            }
                            if (this.af < this.currAnimFrame) {
                                this.setState(this.k(1) > i_13_ ? 30 : 26);
                            } else if (!this.x()) {
                                this.setState(7);
                            }
                        }
                        break;
                    case 26:
                        if (30 < this.currAnimFrame) {
                            this.setState(3);
                        }
                        break;
                    case 27:
                        this.p++;
                        if (30 < this.currAnimFrame) {
                            this.setState(409600 < i_6_ ? 25 : 24);
                        }
                        break;
                    case 28:
                    case 29:
                        if ((this.state == 28 ? 30 : 60) < this.currAnimFrame) {
                            this.setState(3);
                        }
                        break;
                    case 30:
                        if (this.loopMovement) {
                            this.setState(32);
                        }
                        break;
                    case 32:
                        this.position.x += this.velocityX;
                        this.position.z += this.velocityZ;
                        if (2 == this.ah && this.nextFrameToMove < this.currAnimFrame) {
                            this.setState(31);
                        } else {
                            boolean bool;
                            if (this.velocityX < 0) {
                                bool
                                        = i_16_ < ((main.GameManager.currentLevel == 7
                                        ? main.GameManager.g - i_16_
                                        : main.GameManager.h + i_16_)
                                        - this.position.x);
                            } else {
                                bool = ((main.GameManager.currentLevel == 7
                                        ? main.GameManager.g - i_16_
                                        : main.GameManager.h + i_16_)
                                        - this.position.x) < -i_16_;
                            }
                            if (bool) {
                                this.direction = i_5_;
                                if (this.ag) {
                                    this.setState(3 == this.ae ? 29 : 28);
                                } else {
                                    this.ah++;
                                    this.nextFrameToMove
                                            = main.GameManager.getRandomNumber(30) + 16;
                                    this.setState(32);
                                }
                            }
                        }
                        break;
                    case 35:
                        if (3 == this.currAnimFrame) {
                            main.GameManager.e();
                        }
                        if (3 < this.currAnimFrame) {
                            this.e(0, 0, 0);
                            this.e(-20, 0, 0);
                            this.e(20, 0, 0);
                        }
                        if (this.loopMovement) {
                            this.setState(3);
                        }
                        break;
                }
            }
            this.ad = main.GameManager.u > 0 ? 0 : this.ad + 1;
            super.i();
            this.h();
        }
    }

    private void P() {
        if (this.al != null) {
            this.al.playDyingSound();
            this.al.onAttackContact(this, 0, 2, this.direction, Q());
            this.al = null;
            if (this.state != 16) {
                this.direction ^= 0x1;
            }
            this.setState(35);
        }
    }

    public final boolean a(main.AbstractObject var_af, int i) {
        if (this.state - 32 != 0) {
            return super.a(var_af, i);
        }
        if (var_af.p > 0 || this.getDistanceZ(var_af) > 16384 || this == var_af) {
            return false;
        }
        if (this.A != 0 && this.A == var_af.B) {
            return false;
        }
        main.eExtendsAr var_e = this.ak;
        main.eExtendsAr var_e_18_ = var_af.r;
        var_af.h();
        boolean bool = false;
        try {
            bool = var_e.a(var_e_18_, 1, 0);
        } catch (java.lang.Exception exception) {
            java.lang.Exception exception_19_;
            (exception_19_ = exception).printStackTrace();
        }
        return bool;
    }

    private int Q() {
        int i = 2 == main.GameManager.currentDifficulty ? 1 : 0;
        int i_20_;
        switch (this.state) {
            default:
                return 1000;
            case 34:
                i_20_ = am[i][this.difficultyAi];
                break;
            case 32:
            case 33:
                i_20_ = an[i][this.difficultyAi];
                break;
            case 16:
            case 17:
            case 19:
            case 35:
                i_20_ = ao[i][this.difficultyAi];
        }
        return i_20_ + (2 == main.GameManager.currentDifficulty ? 100 : 0);
    }

    public final void checkHammerSmash() {
        if (this.checkAttackObjects(Q(), 0)) {
            this.ag = true;
            if (this.state == 32) {
                this.ae++;
            }
        }
    }

    public final void onAttackContact(main.AbstractObject var_af, int i, int i_21_,
            int i_22_, int i_23_) {
        java.lang.Object object = null;
        if (object != null) {
            /* empty */
        }
        if (!main.GameManager._a0()) {
            if (main.Bongo.j(i = this.onBeingAttacked(var_af, i, i_21_, i_22_,
                    i_23_))) {
                this.al = var_af;
            }
            if (i > 0) {
                this.setState(i);
            }
        }
    }

    public final void e() {
        if (this.N()) {
            this.y = 2;
            this.setState(15);
        }
    }

    public final void b() {
        main.ar.addElementToVector1(this.r);
        if (this.state - 32 == 0) {
            main.ar.addElementToVector1(this.ak);
        }
    }

    public final void clearData() {
        this.clearAbstractData();
        if (this.ak != null) {
            this.ak = null;
        }
    }

    public final boolean d() {
        if (this.p > 0 || this.G) {
            return false;
        }
        switch (this.state) {
            case 15:
                if (this.y != 1) {
                    break;
                }
            /* fall through */
            case 3:
            case 4:
            case 24:
            case 25:
            case 26:
            case 30:
            case 31:
                return true;
        }
        return false;
    }

    public final void g() {
        super.g();
        if (this.ak != null) {
            if (this.n > 0) {
                this.ak.a |= 0x8;
            } else {
                this.ak.a &= ~0x8;
            }
            if (++this.aj >= this.ak.a()) {
                this.aj = 0;
            }
        }
    }

    protected final void h() {
        super.h();
        super.a(this.ak, this.ai, this.aj);
    }

    public final void setState(int i) {
        main.AbstractObject var_af = getPlayerTarget();
        int i_24_ = 0;
        main.GameManager.getRandomNumber(100);
        this.state = i;
        this.w();
        if (var_af != null) {
            this.getDistanceX(var_af);
            this.getDistanceZ(var_af);
            i_24_ = this.getDirectionTowardObject(var_af);
        }
        i = main.GameManager.h + 655360;
        main.Bongo var_h_25_ = this;
        main.AbstractObject var_af_26_ = var_af;
        int i_27_ = i_24_;
        i_24_ = i;
        int i_28_ = i_27_;
        main.AbstractObject var_af_29_ = var_af_26_;
        main.Bongo var_h_30_ = var_h_25_;
        int i_31_ = main.GameManager.h + 655360;
        switch (var_h_30_.state) {
            case 23:
                var_h_30_.c(1);
                break;
            case 3:
            case 4:
                var_h_30_.c(0);
                break;
            case 5:
                var_h_30_.d(9);
                break;
            case 14:
                var_h_30_.n = 32;
                var_h_30_.d(8);
                break;
            case 12:
            case 13:
                var_h_30_.d(6);
                break;
            case 15:
                switch (var_h_30_.y) {
                    default:
                        var_h_30_.direction = var_h_30_.C;
                        var_h_30_.d(5);
                        break;
                    case 2:
                        var_h_30_.F();
                        var_h_30_.c(10);
                        break;
                }
                break;
            case 20:
                var_h_30_.d(5);
                break;
            case 19:
                var_h_30_.d(12);
                break;
            case 16:
                var_h_30_.d(17);
                break;
            case 17:
                var_h_30_.y = 9;
                var_h_30_.d(11);
                break;
            case 18:
                var_h_30_.E();
                var_h_30_.c(12);
                break;
            case 7:
                main.AbstractObject.i(var_h_30_);
                var_h_30_.c(0);
                break;
            case 34:
                var_h_30_.velocityX = var_h_30_.R() * (var_h_30_.position.x < i_31_ ? 1 : -1);
                if (var_af_29_.u() || var_h_30_.velocityX < 0 && i_28_ == 0
                        || var_h_30_.velocityX > 0 && i_28_ != 0) {
                    var_h_30_.setState(24);
                } else {
                    var_h_30_.velocityX
                            = (var_h_30_.velocityX == 0
                            ? var_h_30_.R() * (var_h_30_.position.x < i_24_ ? 1 : -1)
                            : var_h_30_.velocityX);
                    var_h_30_.velocityZ = var_af_29_.position.z - var_h_30_.position.z;
                    if (var_h_30_.velocityZ != 0) {
                        var_h_30_.velocityZ = (int) (((long) var_h_30_.velocityZ << 12)
                                / ((((long) var_af_29_.position.x
                                - (long) var_h_30_.position.x)
                                << 12)
                                / (long) var_h_30_.velocityX));
                    }
                    if (var_h_30_.S()
                            < java.lang.Math.abs(var_h_30_.velocityZ)) {
                        var_h_30_.velocityZ = var_h_30_.S() * (var_h_30_.velocityZ >= 0 ? 1 : -1);
                    }
                    var_h_30_.direction = var_h_30_.velocityX < 0 ? 1 : 0;
                    var_h_30_.x = 2;
                    var_h_30_.c(18);
                    break;
                }
                break;
            case 31:
                var_h_30_.c(19);
                break;
            case 24:
                var_h_30_.p = 10;
                var_h_30_.velocityX = var_h_30_.R();
                var_h_30_.velocityZ = var_h_30_.S();
                i_28_ = main.GameManager.h;
                var_h_30_.targetPosition.x = i_28_ + ((var_h_30_.position.x < i_24_ ? 270 : 50) << 12);
                var_h_30_.targetPosition.y
                        = (var_h_30_.position.z < var_af_29_.position.z ? main.Bongo.z()
                        : main.Bongo.A());
                var_h_30_.c(0);
                break;
            case 25:
                var_h_30_.af = main.GameManager.getRandomNumber(16) + 16;
                var_h_30_.nextFrameToMove = main.GameManager.getRandomNumber(16) + 16;
                var_h_30_.velocityZ
                        = var_h_30_.S() * (main.GameManager.getRandomNumber(2) == 0 ? 1 : -1);
                var_h_30_.c(0);
                break;
            case 26:
            case 27:
                i = (main.GameManager.currentLevel == 7
                        ? main.GameManager.g - 655360
                        : main.GameManager.h + 655360);
                i_28_ = ((main.GameManager.currentLevel == 7 ? 1
                        : 2 == main.GameManager.currentDifficulty ? 3 : 2)
                        - main.GameManager.u);
                for (i_24_ = 0; i_24_ < i_28_; i_24_++) {
                    i_31_ = i;
                    int i_32_ = (main.Bongo.z()
                            + (main.GameManager.getRandomNumber(100) << 12));
                    i_31_ = i_31_ + 737280 * (main.GameManager.getRandomNumber(2) == 0 ? 1
                            : -1);
                    if (main.GameManager.currentLevel != 7) {
                        main.GameManager.spawnObject((main.GameManager.getRandomNumber(2) == 0
                                ? 10
                                : (main.GameManager.getRandomNumber(2)
                                == 0)
                                ? 12 : 14),
                                i_31_, i_32_, 0, 1, 0, 0);
                    } else {
                        main.GameManager.spawnObject((main.GameManager.getRandomNumber(2) == 0
                                ? 30
                                : (main.GameManager.getRandomNumber(2)
                                == 0)
                                ? 32 : 34),
                                i_31_, i_32_, 0, 1, 0, 0);
                    }
                }
            /* fall through */
            case 28:
            case 29:
                if (var_h_30_.state == 29) {
                    var_h_30_.ae = 0;
                }
                main.Bongo.playSound(55);
                var_h_30_.g.set(0, 0, 0);
                var_h_30_.c(2);
                break;
            case 30:
                var_h_30_.ah = 0;
                var_h_30_.g.set(0, 0, 0);
                var_h_30_.c(3);
                break;
            case 32:
            case 33:
                main.Bongo.playSound(15);
                var_h_30_.ag = false;
                var_h_30_.direction = var_h_30_.getDirectionTowardObject(var_af_29_);
                var_h_30_.targetPosition.x = var_af_29_.position.x;
                var_h_30_.velocityX = var_h_30_.R() * (i_28_ == 0 ? 1 : -1);
                i_28_ = (int) (((long) java.lang.Math
                        .abs(var_af_29_.position.x - var_h_30_.position.x)
                        << 12)
                        / (long) var_h_30_.R());
                var_h_30_.velocityZ = (int) ((long) (var_af_29_.position.z - var_h_30_.position.z)
                        << 12) / i_28_;
                if (var_h_30_.S() + (2 == main.GameManager.currentDifficulty ? 12288 : 0)
                        < java.lang.Math.abs(var_h_30_.velocityZ)) {
                    var_h_30_.velocityZ = var_h_30_.S() * (var_h_30_.velocityZ < 0 ? -1 : 1);
                }
                var_h_30_.aj = 0;
                var_h_30_.ai = 4096 < var_h_30_.velocityZ ? 15 : 14;
                var_h_30_.state = 32;
                var_h_30_.ak.a(var_h_30_.aj);
                var_h_30_.ak.setB(var_h_30_.direction == 0 ? 0 : 65536);
                var_h_30_.ak.b(var_h_30_.t);
                var_h_30_.x = 2;
                var_h_30_.c(4);
                break;
            case 35:
                var_h_30_.x = 2;
                var_h_30_.c(13);
        }
    }

    private int R() {
        int i = 0;
        switch (this.state) {
            case 0:
                break;
            case 24:
                i = X[this.difficultyAi] * 6144 >> 12;
                break;
            case 34:
                i = X[this.difficultyAi];
                break;
            case 32:
            case 33:
                i = Z[this.difficultyAi];
                break;
        }
        if (4096 != main.GameManager.enemyVelocityFactor) {
            i = (int) ((long) i * (long) main.GameManager.bossVelocityFactor >> 12);
        }
        return i;
    }

    private int S() {
        int i = 0;
        switch (this.state) {
            case 0:
                break;
            case 24:
                i = Y[this.difficultyAi] * 6144 >> 12;
                break;
            case 25:
            case 34:
                i = Y[this.difficultyAi];
                break;
            case 32:
            case 33:
                i = aa[this.difficultyAi];
                break;
        }
        if (4096 != main.GameManager.enemyVelocityFactor) {
            i = (int) ((long) i * (long) main.GameManager.bossVelocityFactor >> 12);
        }
        return i;
    }

    private static boolean j(int i) {
        boolean bool = false;
        if (16 <= i && i <= 19) {
            bool = true;
        }
        return bool;
    }

    private int k(int i) {
        int i_33_ = 0;
        int i_34_ = 2 == main.GameManager.currentDifficulty ? 1 : 0;
        int i_35_ = W[this.difficultyAi] / 2 < this.energy ? 0 : 1;
        switch (this.state) {
            case 25:
                i_33_
                        = i == 0 ? ac[i_34_][this.difficultyAi][i_35_] : ab[i_34_][this.difficultyAi][i_35_];
            /* fall through */
            default:
                return i_33_;
        }
    }
}
