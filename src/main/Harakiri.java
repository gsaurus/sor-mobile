/* ap - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
package main;

public final class Harakiri extends main.AbstractObject {

    public static final int[] W = {40000, 20000};
    private static final int[] X = {14336, 8192, 8192};
    private static final int[] Y = {14336, 8192, 8192};
    private static final int[] Z = {11468, 11468, 11468};
    private static final int[] aa = {6553, 6553, 6553};
    private static final int[][][] ab
            = {{{50, 50, 50}, {60, 50}, {80}},
            {{50, 50, 50}, {60, 50}, {80}}};
    private static final int[][][] ac;
    private static final int[][][] ad;
    private static final int[] ae;
    private boolean af;
    private int ag;
    private main.eExtendsAr[] ah;
    private main.Point[] ai;
    private int[] aj;
    private int[] ak;
    private boolean[] al;
    private boolean[] am;
    private boolean an;
    private static main.ObjectArt ao;
    private int ap;
    private boolean aq;
    private boolean ar;
    private boolean as;
    private int at;
    private static final int[][] au;
    private static final int[][] av;
    private static final int[][] aw;
    private static final int[][] ax;
    private static final int[][] ay;

    static {
        (new int[][]{{25, 40, 60}, null})[1] = new int[]{25, 40, 60};
        (new int[][]{{30, 50, 70}, null})[1] = new int[]{30, 50, 70};
        (new int[][]{{10, 20, 20}, null})[1] = new int[]{10, 20, 35};
        ac = new int[][][]{{{5, 15, 20}, {5, 15, 35}},
        {{5, 15, 20}, {5, 15, 35}}};
        ad = new int[][][]{{{10, 15, 25}, {10, 20, 50}},
        {{15, 30, 60}, {10, 20, 50}}};
        ae = new int[]{3, 2, 1};
        au = new int[][]{{1300, 1300, 1300}, {1300, 1300, 1300}};
        av = new int[][]{{1500, 1500, 1500}, {1800, 1800, 1800}};
        aw = new int[][]{{1200, 1200, 1200}, {1400, 1400, 1400}};
        ax = new int[][]{{2000, 2000, 2000}, {2100, 2100, 2100}};
        ay = new int[][]{{600, 600, 600}, {600, 600, 600}};
    }

    public Harakiri(main.ObjectArt var_ad, int i, int i_0_, int i_1_,
            int i_2_, int i_3_, int i_4_) {
        super(15, i, i_0_, i_1_, i_2_, i_3_, i_4_);
        this.stateFlags |= 0x8401;
        this.r = new main.eExtendsAr(0, var_ad, 19);
        this.collisionBox
                = new main.CollisionBox(this.position,
                        new main.Point(65536,
                                32768,
                                131072));
        this.nextFrameToMove = 0;
        this.Q = 0;
        this.D = false;
        this.K = new main.Point(this.position.x, this.position.z, this.position.y);
        this.O = 0;
        this.aq = false;
        this.at = -1;
        this.af = false;
        if (this.ah == null) {
            this.ah = new main.eExtendsAr[3];
        }
        this.ai = new main.Point[3];
        this.aj = new int[3];
        this.ak = new int[3];
        this.al = new boolean[3];
        this.am = new boolean[3];
        for (i = 0; i < 3; i++) {
            this.ah[i] = new main.eExtendsAr(0, var_ad, 19);
            this.ah[i].d = 383;
            this.ai[i] = new main.Point(0, 0, 0);
        }
        ao = var_ad;
        this.energy = W[this.difficultyAi];
        this.maxEnergy = this.energy;
        this.visualEnergy = main.GameManager.f(this.energy);
        this.name = "HARAKIRI";
    }

    public final void update() {
        super.update();
        java.lang.Object object = null;
        if (object != null) {
            /* empty */
        }
        if (!main.GameManager._a0()) {
            main.AbstractObject target = getPlayerTarget();
            int i = main.GameManager.getRandomNumber(100);
            int i_5_ = 0;
            int i_6_ = 0;
            int i_7_ = 0;
            if (target == null) {
                if (this.state != 23 && !this.j()) {
                    this.setState(3);
                    this.q = 10;
                }
            } else {
                i_6_ = this.getDistanceX(target);
                i_7_ = this.getDistanceZ(target);
                i_5_ = this.getDirectionTowardObject(target);
            }
            this.D = false;
            if (this.state != 3 && this.q > 0 && this.state != 23) {
                this.setState(3);
            }
            if (5 <= this.state && this.state <= 22) {
                this.a(this.state, V, target);
            } else {
                main.AbstractObject var_af_9_ = target;
                int i_10_ = i_5_;
                int i_11_ = i;
                int i_12_ = i_6_;
                int i_13_ = i_7_;
                i_7_ = i_12_;
                i_6_ = i_11_;
                i_5_ = i_10_;
                main.AbstractObject var_af_14_ = var_af_9_;
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
                    case 3:
                        this.A = 0;
                        this.B = 0;
                        this.g.set(0, 0, 0);
                        if (this.q > 0) {
                            this.q--;
                        } else if (var_af_14_ != null) {
                            if (!var_af_14_.u() && this.aq && i_7_ < 245760
                                    && this.j(0) > i_6_) {
                                this.p = 16;
                                this.setState(29);
                                this.aq = false;
                            } else {
                                this.aq = false;
                                if (this.as) {
                                    this.as = false;
                                    this.setState(37);
                                } else {
                                    this.setState(24);
                                }
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
                        }
                        break;
                    case 24:
                        if ((var_af_14_.stateFlags & 0x20000) != 0 && i_7_ < 409600
                                && i_13_ < 65536) {
                            this.setState(35);
                        } else if (i_7_ < 245760) {
                            this.setState(60 > i_6_ ? 28 : 26);
                        } else {
                            if (i_7_ < 552960 && i_13_ < 40960) {
                                if (!var_af_14_.u()) {
                                    if (50 > i_6_) {
                                        this.setState(33);
                                    } else {
                                        this.setState(26);
                                    }
                                } else {
                                    this.setState(37);
                                }
                                if (this.state != 24) {
                                    break;
                                }
                            }
                            if ((this.currAnimFrame & 0x3) == 0) {
                                this.direction = i_5_;
                            }
                            if (this.currAnimFrame % 6 == 0) {
                                if ((i = main.GameManager.getRandomNumber(4))
                                        == this.ap) {
                                    if (main.GameManager.getRandomNumber(2) == 0 || i == 0) {
                                        this.ap = (i + 1) % 4;
                                    } else {
                                        this.ap = i - 1;
                                    }
                                }
                                this.g.set(0, 0, 0);
                                this.velocityX = 0;
                                this.velocityZ = 0;
                                if ((this.ap & 0x10) == 0) {
                                    this.velocityZ = (this.S()
                                            * ((this.ap & 0x1) == 0
                                            ? -1 : 1));
                                } else {
                                    this.velocityX = (this.R()
                                            * ((this.ap & 0x1) == 0
                                            ? -1 : 1));
                                }
                            }
                            this.position.x += this.velocityX;
                            this.position.z += this.velocityZ;
                            if (this.nextFrameToMove < this.currAnimFrame) {
                                if (this.j(0) > i_6_) {
                                    this.setState(37);
                                } else if (this.j(1) > i_6_) {
                                    this.setState(27);
                                } else if (this.j(2) > i_6_) {
                                    this.setState(28);
                                }
                                if (this.state == 24) {
                                    this.setState(30);
                                }
                            } else if (!this.isInsideScreen(-40, 0)) {
                                this.setState(7);
                            }
                        }
                        break;
                    case 32:
                        if (i_7_ < 409600 && i_13_ < 204800) {
                            main.Point2D var_m = this.targetPosition;
                            var_m.y = (var_m.y
                                    + 12288 * (this.position.z < var_af_14_.position.z
                                    ? -1 : 1));
                            this.D();
                        }
                        main.Harakiri.moveToTarget(this, target);
                        if (this.e(0, 0)) {
                            this.setState(3);
                        }
                        break;
                    case 26:
                        this.position.x += this.velocityX;
                        if (16 < this.currAnimFrame) {
                            this.setState(3);
                        } else if (!this.x()) {
                            if (this.as) {
                                this.setState(3);
                            } else {
                                this.setState(32);
                            }
                        }
                        break;
                    case 37:
                        if (8 == this.currAnimFrame) {
                            main.Harakiri.playSound(8);
                        }
                        if (this.currAnimFrame - 7 == 0) {
                            if (W[this.difficultyAi] / 3 << 1 < this.energy) {
                                main.GameManager.enemyObjects.addElement(new main.PickableObject(ao, this, 19,
                                        19, 0,
                                        this.P()));
                            } else if (W[this.difficultyAi] / 3 < this.energy) {
                                for (i = 0; i < 3; i++) {
                                    main.GameManager.enemyObjects.addElement(new main.PickableObject(ao, this,
                                            19, 19, i,
                                            this
                                            .P()));
                                }
                            } else {
                                for (i = 0; i < 6; i++) {
                                    if (i != 3) {
                                        main.GameManager.enemyObjects.addElement(new main.PickableObject(ao,
                                                this,
                                                19, 19, i,
                                                this
                                                .P()));
                                    }
                                }
                            }
                        }
                        if (this.loopMovement) {
                            this.at++;
                            i = 0;
                            if (this.energy < W[this.difficultyAi] / 3) {
                                i = 2;
                            } else if (this.energy < W[this.difficultyAi] / 3 << 1) {
                                i = 1;
                            }
                            if (this.at < ae[i] && this.j(0) > i_6_) {
                                this.setState(37);
                            } else {
                                this.at = -1;
                                this.setState(3);
                            }
                        }
                        break;
                    case 27:
                        if (this.currAnimFrame % 16 == 0) {
                            this.targetPosition.x
                                    = var_af_14_.position.x + 552960 * (i_5_ == 0 ? -1 : 1);
                            this.targetPosition.y = var_af_14_.position.z;
                        }
                        main.AbstractObject.moveToTarget(this, target);
                        if (i_7_ <= 552960 && i_13_ <= 40960 || 48 < this.currAnimFrame) {
                            this.setState(33);
                        } else if (this.nextFrameToMove == 0) {
                            if (7 > main.GameManager.getRandomNumber(11)) {
                                this.setState(33);
                            } else {
                                this.setState(3);
                            }
                        } else {
                            this.R = 2;
                        }
                        break;
                    case 33:
                        if (8 == this.currAnimFrame) {
                            main.Harakiri.playSound(0);
                        }
                        if (7 == this.currAnimFrame) {
                            main.Harakiri.playSound(43);
                        }
                        this.Q();
                        break;
                    case 28:
                        this.position.x += this.velocityX;
                        this.position.z += this.velocityZ;
                        this.d(-30, 0, 0);
                        if (this.currAnimFrame - 10 > 0) {
                            this.g.set(0, 0, 0);
                            this.setState(34);
                        }
                        break;
                    case 34:
                        this.an = true;
                        this.Q();
                        break;
                    case 29:
                        this.targetPosition.x
                                = var_af_14_.position.x + 163840 * (i_5_ == 0 ? -1 : 1);
                        this.targetPosition.y = var_af_14_.position.z;
                        main.Harakiri.moveToTarget(this, target);
                        if ((var_af_14_
                                = main.Harakiri.getEnemyInFront(this, 256, 163840,
                                        20480))
                                != null) {
                            this.grabbedObject = var_af_14_;
                            this.setState(36);
                            this.g.set(0, 0, 0);
                        } else {
                            this.R = 1;
                        }
                        break;
                    case 30:
                        main.Harakiri.moveToTarget(this, target);
                        if (this.e(0, 0)) {
                            this.setState(31);
                        } else if (48 < this.currAnimFrame) {
                            this.setState(3);
                        } else {
                            this.R = 1;
                        }
                        break;
                    case 31:
                        main.Harakiri.moveToTarget(this, target);
                        if ((var_af_14_
                                = main.Harakiri.getEnemyInFront(this, 256, 163840,
                                        20480))
                                != null) {
                            this.grabbedObject = var_af_14_;
                            this.setState(36);
                            this.g.set(0, 0, 0);
                        } else if (this.e(0, 0)) {
                            this.setState(3);
                        }
                        break;
                    case 36:
                        if (this.checkIfReleaseGrab()) {
                            this.setState(3);
                        } else {
                            if (this.state == 36 && 3 == this.u) {
                                this.grabbedObject.direction ^= 0x1;
                                this.grabbedObject.onAttackContact(this, this.A, 9,
                                        this.direction, this.P());
                                this.ar = true;
                            }
                            this.Q();
                        }
                        break;
                    case 35:
                        if (10 == this.currAnimFrame) {
                            main.Harakiri.playSound(43);
                        }
                        if (this.loopMovement) {
                            this.setState(24);
                        }
                        break;
                }
            }
            super.i();
            this.h();
        }
    }

    private int P() {
        int i = 2 == main.GameManager.currentDifficulty ? 1 : 0;
        int i_16_;
        switch (this.state) {
            default:
                return 1000;
            case 34:
                i_16_ = au[i][this.difficultyAi];
                break;
            case 33:
                i_16_ = av[i][this.difficultyAi];
                break;
            case 35:
                i_16_ = aw[i][this.difficultyAi];
                break;
            case 36:
                i_16_ = ax[i][this.difficultyAi];
                break;
            case 37:
                i_16_ = ay[i][this.difficultyAi];
        }
        return i_16_ + (2 == main.GameManager.currentDifficulty ? 100 : 0);
    }

    public final void checkHammerSmash() {
        if (this.checkAttackObjects(P(), 0)) {
            this.ar = true;
        }
    }

    public final void onAttackContact(main.AbstractObject var_af, int i, int i_17_,
            int i_18_, int i_19_) {
        this.af = false;
        this.at = -1;
        int i_20_;
        if ((i_20_ = this.onBeingAttacked(var_af, i, i_17_, i_18_, i_19_)) > 0) {
            this.setState(i_20_);
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
        if (this.af) {
            for (int i = 0; i < 3; i++) {
                if (this.al[i]) {
                    main.ar.addElementToVector1(this.ah[i]);
                    if (this.am[i]) {
                        this.al[i] = false;
                    }
                }
            }
            if (!this.al[2]) {
                this.af = false;
            }
        }
    }

    public final void clearData() {
        this.clearAbstractData();
        for (int i = 0; i < 3; i++) {
            if (this.ah[i] != null) {
                this.ah[i] = null;
            }
        }
    }

    public final boolean d() {
        java.lang.Object object = null;
        if (object != null) {
            /* empty */
        }
        if (main.GameManager._a1()) {
            return false;
        }
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
            case 7:
            case 8:
            case 24:
            case 25:
            case 26:
            case 32:
            case 37:
                return true;
        }
        return false;
    }

    public final void g() {
        java.lang.Object object = null;
        if (object != null) {
            /* empty */
        }
        if (!main.GameManager._a1()) {
            super.g();
            main.Harakiri var_ap_21_;
            if ((var_ap_21_ = this).af) {
                if (var_ap_21_.currAnimFrame % 2 == 0) {
                    for (int i = 2; i > 0; i--) {
                        var_ap_21_.ai[i].set(var_ap_21_.ai[i - 1]);
                        var_ap_21_.aj[i] = var_ap_21_.aj[i - 1];
                        var_ap_21_.ak[i] = var_ap_21_.ak[i - 1];
                        var_ap_21_.am[i] = var_ap_21_.am[i - 1];
                    }
                    if (var_ap_21_.al[0]) {
                        var_ap_21_.ai[0].set(var_ap_21_.position);
                        var_ap_21_.ak[0] = var_ap_21_.t;
                        var_ap_21_.aj[0] = var_ap_21_.u;
                    }
                    if (var_ap_21_.an) {
                        var_ap_21_.am[0] = true;
                    }
                }
                var_ap_21_.ag++;
            }
        }
    }

    protected final void h() {
        super.h();
        if (this.af) {
            for (int i = 0; i < 3; i++) {
                int i_22_ = (this.ai[i].x - main.GameManager.screenLockX
                        + main.GameManager.halfScreenWidth12Left);
                int i_23_
                        = (this.ai[i].z - this.ai[i].y - main.GameManager.screenLockY
                        + main.GameManager.halfScreenHeight12Left);
                this.ah[i].a(this.s() - i - 1, i_22_, i_23_, this.ak[i],
                        this.aj[i], this.direction == 0 ? 0 : 65536);
            }
        }
    }

    public final void setState(int i) {
        int i_24_ = main.GameManager.getRandomNumber(100);
        main.AbstractObject var_af = getPlayerTarget();
        int i_25_ = 0;
        if (var_af != null) {
            i_25_ = this.getDirectionTowardObject(var_af);
            this.getDistanceX(var_af);
            this.getDistanceZ(var_af);
        }
        this.state = i;
        this.ar = false;
        this.w();
        main.Harakiri var_ap_26_ = this;
        main.AbstractObject var_af_27_ = var_af;
        int i_28_ = i_25_;
        int i_29_ = i;
        i_25_ = i_24_;
        int i_30_ = i_29_;
        i_24_ = i_28_;
        main.AbstractObject var_af_31_ = var_af_27_;
        main.Harakiri var_ap_32_ = var_ap_26_;
        int i_33_ = main.GameManager.h + 655360;
        switch (i_30_) {
            case 23:
                var_ap_32_.c(1);
                break;
            case 3:
                if (var_af_31_ != null && var_ap_32_.as && var_af_31_.u()) {
                    var_ap_32_.q = 24;
                }
            /* fall through */
            case 4:
                var_ap_32_.c(0);
                break;
            case 5:
                var_ap_32_.aq = true;
                var_ap_32_.g.set(0, 0, var_ap_32_.g.y);
                var_ap_32_.c(13);
                break;
            case 14:
                var_ap_32_.g.set(0, 0, var_ap_32_.g.y);
                var_ap_32_.n = 32;
                var_ap_32_.c(11);
                break;
            case 12:
            case 13:
                var_ap_32_.g.set(0, 0, var_ap_32_.g.y);
                var_ap_32_.c(8);
                break;
            case 15:
                var_ap_32_.g.set(0, 0, var_ap_32_.g.y);
                switch (var_ap_32_.y) {
                    default:
                        if (var_ap_32_.aq) {
                            if (var_ap_32_.j(0) > i_25_) {
                                var_ap_32_.setState(35);
                                break;
                            }
                        } else if (W[var_ap_32_.difficultyAi] / 2 > var_ap_32_.energy
                                && var_ap_32_.j(0) > i_25_) {
                            var_ap_32_.setState(35);
                            break;
                        }
                        var_ap_32_.direction = var_ap_32_.C;
                        var_ap_32_.c(9);
                        break;
                    case 2:
                        var_ap_32_.F();
                        var_ap_32_.c(14);
                        break;
                }
                break;
            case 20:
                var_ap_32_.g.set(0, 0, var_ap_32_.g.y);
                var_ap_32_.c(10);
                break;
            case 19:
                var_ap_32_.g.set(0, 0, var_ap_32_.g.y);
                var_ap_32_.c(17);
                break;
            case 16:
                var_ap_32_.g.set(0, 0, var_ap_32_.g.y);
                var_ap_32_.c(18);
                break;
            case 17:
                var_ap_32_.g.set(0, 0, var_ap_32_.g.y);
                var_ap_32_.y = 9;
                var_ap_32_.c(16);
                break;
            case 18:
                var_ap_32_.E();
                var_ap_32_.c(15);
                break;
            case 7:
                main.AbstractObject.i(var_ap_32_);
                var_ap_32_.c(0);
                break;
            case 8:
                main.AbstractObject.h(var_ap_32_);
                var_ap_32_.c(0);
                break;
            case 24:
                var_ap_32_.direction = i_24_;
                var_ap_32_.nextFrameToMove = 32 + main.GameManager.getRandomNumber(17);
                if ((i = main.GameManager.getRandomNumber(4)) == var_ap_32_.ap) {
                    if (main.GameManager.getRandomNumber(2) == 0 || i == 0) {
                        var_ap_32_.ap = (i + 1) % 4;
                    } else {
                        var_ap_32_.ap = i - 1;
                    }
                }
                var_ap_32_.g.set(0, 0, 0);
                var_ap_32_.velocityX = 0;
                var_ap_32_.velocityZ = 0;
                if ((var_ap_32_.ap & 0x10) == 0) {
                    var_ap_32_.velocityZ
                            = var_ap_32_.S() * ((var_ap_32_.ap & 0x1) == 0 ? -1 : 1);
                } else {
                    var_ap_32_.velocityX
                            = var_ap_32_.R() * ((var_ap_32_.ap & 0x1) == 0 ? -1 : 1);
                }
                var_ap_32_.c(0);
                break;
            case 32:
                var_ap_32_.direction = i_24_;
                var_ap_32_.velocityX = var_ap_32_.R();
                var_ap_32_.velocityZ = var_ap_32_.S();
                var_ap_32_.targetPosition.x
                        = i_33_ + 102400 * (var_ap_32_.position.x < i_33_ ? 1 : -1);
                var_ap_32_.targetPosition.y = var_ap_32_.position.z;
                var_ap_32_.c(0);
                break;
            case 25:
                var_ap_32_.c(1);
                break;
            case 37:
                var_ap_32_.as = false;
                var_ap_32_.direction = i_24_;
                if (var_ap_32_.at < 0) {
                    var_ap_32_.at = 0;
                }
                var_ap_32_.c(7);
                break;
            case 26:
                var_ap_32_.direction = i_24_;
                var_ap_32_.velocityX = var_ap_32_.R() * (i_24_ == 0 ? -1 : 1);
                var_ap_32_.velocityZ = var_ap_32_.S();
                var_ap_32_.c(0);
                break;
            case 27:
                var_ap_32_.direction = i_24_;
                var_ap_32_.targetPosition.x = var_af_31_.position.x + 552960 * (i_24_ == 0 ? -1 : 1);
                var_ap_32_.targetPosition.y = var_af_31_.position.z;
                var_ap_32_.nextFrameToMove = 16 + main.GameManager.getRandomNumber(25);
                var_ap_32_.velocityX = var_ap_32_.R();
                var_ap_32_.velocityZ = var_ap_32_.S();
                var_ap_32_.c(0);
                break;
            case 33:
                var_ap_32_.direction = i_24_;
                var_ap_32_.x = 2;
                var_ap_32_.c(2);
                break;
            case 28:
                var_ap_32_.velocityX = (var_ap_32_.R() + 8192) * (i_24_ == 0 ? 1 : -1);
                var_ap_32_.velocityZ
                        = (int) (((long) var_af_31_.position.z - (long) var_ap_32_.position.z << 12)
                        / (((long) var_af_31_.position.x - (long) var_ap_32_.position.x
                        << 12)
                        / (long) var_ap_32_.velocityX));
                if (var_ap_32_.S()
                        < java.lang.Math.abs(var_ap_32_.velocityZ)) {
                    var_ap_32_.velocityZ = var_ap_32_.S() * (var_ap_32_.velocityZ < 0 ? -1 : 1);
                }
                var_ap_32_.direction = i_24_;
                var_ap_32_.af = true;
                var_ap_32_.an = false;
                for (i = 0; i < 3; i++) {
                    var_ap_32_.al[i] = true;
                    var_ap_32_.am[i] = false;
                    var_ap_32_.ak[i] = 4;
                    var_ap_32_.aj[i] = 0;
                    var_ap_32_.ai[i].set(var_ap_32_.position);
                }
                var_ap_32_.c(4);
                break;
            case 34:
                main.Harakiri.playSound(0);
                main.Harakiri.playSound(55);
                var_ap_32_.x = 2;
                var_ap_32_.direction = i_24_;
                var_ap_32_.c(5);
                break;
            case 35:
                var_ap_32_.direction = i_24_;
                var_ap_32_.aq = false;
                var_ap_32_.x = 2;
                var_ap_32_.c(3);
                break;
            case 29:
                var_ap_32_.direction = i_24_;
                var_ap_32_.velocityX = var_ap_32_.R();
                var_ap_32_.velocityZ = var_ap_32_.S();
                var_ap_32_.targetPosition.x = var_af_31_.position.x + 147456 * (i_24_ == 0 ? -1 : 1);
                var_ap_32_.targetPosition.y = var_af_31_.position.z;
                break;
            case 30:
                var_ap_32_.velocityX = var_ap_32_.R();
                var_ap_32_.velocityZ = 0;
                var_ap_32_.targetPosition.x = var_af_31_.position.x + 147456 * (i_24_ == 0 ? -1 : 1);
                var_ap_32_.targetPosition.y = var_ap_32_.position.z;
                var_ap_32_.D();
                var_ap_32_.c(0);
                break;
            case 31:
                var_ap_32_.velocityX = 0;
                var_ap_32_.velocityZ = var_ap_32_.S();
                var_ap_32_.targetPosition.x = var_ap_32_.position.x;
                var_ap_32_.targetPosition.y = var_af_31_.position.z;
                var_ap_32_.c(0);
                break;
            case 36:
                if (var_ap_32_.grabbedObject == null) {
                    var_ap_32_.setState(3);
                    break;
                }
                var_ap_32_.direction = i_24_;
                var_ap_32_.w = 6;
                var_ap_32_.x = 10;
                var_ap_32_.grabbedObject.onAttackContact(var_ap_32_, var_ap_32_.A, 10, var_ap_32_.direction, 0);
                var_ap_32_.grabbedObject.p = 16;
                var_ap_32_.position.set(var_ap_32_.grabbedObject.position.x + (var_ap_32_.direction == 0 ? -147456
                        : 147456),
                        var_ap_32_.grabbedObject.position.z, var_ap_32_.position.y);
                var_ap_32_.G();
                var_ap_32_.grabbedObject.direction = var_ap_32_.direction == 0 ? 1 : 0;
                main.Harakiri.playSound(55);
                var_ap_32_.c(6);
        }
    }

    private void Q() {
        if (this.loopMovement) {
            if (this.state == 36) {
                this.releaseGrabbedObj();
            }
            if (this.ar) {
                this.as = true;
                this.setState(26);
            } else {
                this.setState(3);
            }
        }
    }

    private int R() {
        java.lang.Object object = null;
        if (object != null) {
            /* empty */
        }
        if (main.GameManager._a0()) {
            return 0;
        }
        int i = 0;
        switch (this.state) {
            case 0:
                break;
            case 24:
            case 26:
            case 27:
            case 29:
            case 30:
            case 32:
                i = X[this.difficultyAi];
                break;
            case 28:
                i = Z[this.difficultyAi];
                break;
        }
        if (4096 != main.GameManager.enemyVelocityFactor) {
            i = (int) ((long) i * (long) main.GameManager.bossVelocityFactor >> 12);
        }
        return i * 7372 >> 12;
    }

    private int S() {
        int i = 0;
        switch (this.state) {
            case 0:
                break;
            case 24:
            case 26:
            case 27:
            case 29:
            case 30:
            case 31:
            case 32:
                i = Y[this.difficultyAi];
                break;
            case 28:
                i = aa[this.difficultyAi];
                break;
        }
        if (4096 != main.GameManager.enemyVelocityFactor) {
            i = (int) ((long) i * (long) main.GameManager.bossVelocityFactor >> 12);
        }
        return i * 7372 >> 12;
    }

    private int j(int i) {
        int i_34_ = 2 == main.GameManager.currentDifficulty ? 1 : 0;
        int i_35_
                = W[this.difficultyAi] / 2 < this.energy ? 0 : W[this.difficultyAi] / 5 < this.energy ? 1 : 2;
        main.Harakiri var_ap_36_ = this;
        int i_37_ = i_34_;
        int i_38_ = i_35_;
        i_35_ = i;
        i_34_ = i_38_;
        i = i_37_;
        main.Harakiri var_ap_39_ = var_ap_36_;
        int i_40_ = 0;
        switch (var_ap_39_.state) {
            case 0:
                break;
            case 3:
                i_40_ = ad[i][var_ap_39_.difficultyAi][i_34_];
                break;
            case 15:
                i_40_ = ac[i][var_ap_39_.aq ? 0 : 1][i_34_];
                break;
            case 24:
                switch (i_35_) {
                    case 0:
                        i_40_ = 15;
                        break;
                    case 1:
                        i_40_ = 40;
                        break;
                    case 2:
                        i_40_ = 80;
                }
                break;
            case 37:
                i_40_ = ab[i][i_34_][var_ap_39_.at - 1];
                break;
        }
        int i_41_;
        return i_41_ = i_40_;
    }
}
