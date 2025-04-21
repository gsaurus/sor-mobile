/* aj - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
package main;

public final class Juggler extends main.AbstractObject {

    private static final int[] W = {2500, 5000, 5000};
    private static final int[] X = {8192, 9420, 10240};
    private static final int[] Y = {8192, 9420, 10240};
    private static final int[] Z = {19660, 20480, 21299};
    private static final int[] aa = {9011, 10240, 10649};
    private static final int[] ab = {15564, 15564, 16384};
    private static final int[] ac = {4915, 6144, 7372};
    private static final int[][][] ad
            = {{{40, 50, 50}, {65, 50, 50}, new int[3]},
            {{40, 50, 50}, {65, 50, 50}, new int[3]}};
    private static final int[][] ae = {{20, 45, 0}, {20, 45, 0}};
    private static final int[] af = {75, 75};
    private static final int[][] ag = {{60, 50, 50}, {60, 50, 50}};
    private static final int[][] ah = {{25, 25, 25}, {25, 25, 25}};
    private int ai;
    private boolean aj;
    private static main.ObjectArt ak;
    private main.eExtendsAr al;
    private int am;
    private int an;
    private boolean ao;
    private static final int[][] ap = {{300, 300, 300}, {300, 300, 300}};
    private static final int[][][] aq
            = {{{700, 500}, {700, 500}, {700, 500}},
            {{700, 500}, {700, 500}, {700, 500}}};

    public Juggler(main.ObjectArt var_ad, int i, int i_0_, int i_1_,
            int i_2_, int i_3_, int i_4_) {
        super(8, i, i_0_, i_1_, i_2_, i_3_, i_4_);
        this.stateFlags |= 0x8201;
        this.r = new main.eExtendsAr(0, var_ad, 18);
        this.collisionBox
                = new main.CollisionBox(this.position,
                        new main.Point(131072,
                                131072,
                                131072));
        this.nextFrameToMove = 0;
        this.ai = 0;
        this.Q = 0;
        this.D = false;
        this.K = new main.Point(this.position.x, this.position.z, this.position.y);
        this.O = 0;
        this.aj = i == 2;
        ak = var_ad;
        this.ao = true;
        this.an = main.GameManager.getRandomNumber(2) == 0 ? 0 : 1;
        this.al = new main.eExtendsAr(0, var_ad, 18);
        this.energy = W[this.difficultyAi];
        this.maxEnergy = this.energy;
        this.visualEnergy = main.GameManager.f(this.energy);
        this.name = "JUGGLER";
    }

    public final void update() {
        super.update();
        main.AbstractObject target = getPlayerTarget();
        int i = 0;
        int i_5_ = 0;
        int i_6_ = main.GameManager.getRandomNumber(100);
        if (target == null) {
            if (!this.j()) {
                this.setState(3);
            }
        } else {
            i = this.getDistanceX(target);
            i_5_ = this.getDistanceZ(target);
        }
        this.D = false;
        if (this.state != 3 && this.q > 0) {
            this.setState(3);
        }
        main.AbstractObject.j(this);
        if (5 <= this.state && this.state <= 22) {
            this.a(this.state, V, target);
        } else {
            main.AbstractObject var_af_8_ = target;
            int i_9_ = i;
            int i_10_ = i_5_;
            int i_11_ = i_6_;
            i_6_ = i_10_;
            i_5_ = i_9_;
            main.AbstractObject var_af_12_ = var_af_8_;
            switch (this.state) {
                case 0:
                    this.setState(3);
                /* fall through */
                case 3:
                    this.A = 0;
                    this.B = 0;
                    this.g.set(0, 0, this.g.y);
                    if (this.q > 0) {
                        this.q--;
                    } else if (var_af_12_ != null) {
                        if (this.aj) {
                            this.setState(29);
                        } else {
                            this.setState(26);
                        }
                    } else {
                        this.q = 10;
                    }
                    break;
                case 4:
                    this.A = 0;
                    this.B = 0;
                    break;
                case 26:
                    main.AbstractObject.moveToTarget(this, target);
                    if (this.e(0, 0)) {
                        if (this.aj) {
                            this.setState(29);
                        } else {
                            this.setState(27);
                        }
                    }
                    this.R = 7;
                    break;
                case 27:
                    if (this.e(0, 0)) {
                        this.targetPosition.x = this.position.x;
                        this.targetPosition.y
                                = var_af_12_.position.z + (main.GameManager.getRandomNumber(160) - 80
                                << 12);
                        this.D();
                    }
                    main.AbstractObject.moveToTarget(this, target);
                    if (this.currAnimFrame % 32 == 0 && 204800 > i_5_ && 50 > main.GameManager.getRandomNumber(100)) {
                        this.setState(26);
                    } else {
                        if (this.currAnimFrame % 24 == 0 && 20480 > i_6_) {
                            if (this.j(0) > i_11_) {
                                this.setState(34);
                            } else if (this.j(1) > i_11_) {
                                if (409600 <= i_5_) {
                                    this.setState(35);
                                }
                            } else {
                                this.setState(28);
                            }
                        }
                        this.R = 6;
                    }
                    break;
                case 28:
                    if (16 >= this.currAnimFrame) {
                        if (this.currAnimFrame % 4 == 0) {
                            this.direction ^= 0x1;
                        }
                    } else if (this.nextFrameToMove < this.currAnimFrame) {
                        this.setState(this.aj ? 29 : 26);
                    }
                    break;
                case 34:
                    if (this.currAnimFrame == 3) {
                        this.Q();
                    }
                    if (this.ai == 0) {
                        if (this.loopMovement) {
                            if (this.j(0) > i_11_) {
                                this.ai++;
                                this.setState(34);
                            } else {
                                this.setState(3);
                            }
                        }
                    } else if (5 > this.currAnimFrame) {
                        if (4 == this.currAnimFrame) {
                            this.c(3);
                        }
                    } else if (this.loopMovement) {
                        if (this.ai < 2 && this.j(0) > i_11_) {
                            this.ai++;
                            this.setState(34);
                        } else {
                            this.ai = 0;
                            this.setState(3);
                        }
                    }
                    break;
                case 35:
                    if (this.currAnimFrame == 3) {
                        this.Q();
                    }
                    if (this.loopMovement) {
                        this.setState(3);
                    }
                    break;
                case 29:
                    if (this.currAnimFrame % 7 == 0) {
                        this.d(0, 0, 0);
                    }
                    main.AbstractObject.moveToTarget(this, target);
                    if (this.e(0, 0)) {
                        this.targetPosition.x
                                = (var_af_12_.position.x + ((50 + main.GameManager.getRandomNumber(25) << 12)
                                * (this.getDirectionTowardObject(var_af_12_) == 0 ? -1 : 1)));
                        this.targetPosition.y = var_af_12_.position.z + (35 - main.GameManager.getRandomNumber(70)
                                << 12);
                    }
                    if (this.currAnimFrame % 24 == 0) {
                        if (20480 > i_6_ && this.j(0) > i_11_) {
                            this.setState(36);
                            break;
                        }
                        if (409600 <= i_5_ && this.j(1) > i_11_) {
                            this.setState(37);
                            break;
                        }
                        if (2048000 > i_5_ && this.j(2) > i_11_) {
                            this.setState(26);
                        }
                    }
                    this.R = 7;
                    break;
                case 36:
                    if (this.currAnimFrame == 3) {
                        this.Q();
                    }
                    if (this.loopMovement) {
                        if (2 > this.ai) {
                            this.ai++;
                            this.setState(36);
                        } else {
                            this.ai = 0;
                            this.setState(28);
                        }
                    }
                    break;
                case 37:
                    if (this.currAnimFrame == 3) {
                        this.Q();
                    }
                    if (this.loopMovement) {
                        if (2 > this.ai && this.j(0) > i_11_) {
                            this.ai++;
                            this.setState(37);
                        } else {
                            this.ai = 0;
                            this.setState(28);
                        }
                    }
                    break;
            }
        }
        this.i();
        this.h();
    }

    public final void checkHammerSmash() {
        this.checkAttackObjects(P(), 0);
    }

    public final void onAttackContact(main.AbstractObject var_af, int i, int i_14_,
            int i_15_, int i_16_) {
        this.ao = false;
        int i_17_ = this.onBeingAttacked(var_af, i, i_14_, i_15_, i_16_);
        if (this.state == 29) {
            this.y = this.y == 1 ? 2 : this.y;
        }
        if (i_17_ > 0) {
            this.setState(i_17_);
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
        if (this.ao) {
            main.ar.addElementToVector1(this.al);
        }
    }

    public final void clearData() {
        this.clearAbstractData();
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
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 22:
            case 26:
            case 27:
            case 28:
            case 29:
                return true;
        }
        return false;
    }

    public final void c(int i) {
        if (i == 0) {
            this.x = 2;
            this.ao = true;
            if (this.t != i) {
                this.an = main.GameManager.getRandomNumber(2) == 0 ? 0 : 1;
            }
            int i_18_ = 15 + this.an;
            this.al.a(this.u);
            this.al.setB(this.direction == 0 ? 0 : 65536);
            this.al.b(i_18_);
        } else {
            this.ao = false;
        }
        super.c(i);
    }

    public final void g() {
        if (this.w <= 0) {
            if (this.state != 33) {
                if (this.state == 26) {
                    /* empty */
                }
            } else {
                this.u++;
            }
            if (this.ao && ++this.am >= this.al.a()) {
                this.am = 0;
            }
        }
        super.g();
    }

    protected final void h() {
        super.h();
        if (this.ao) {
            int i = (this.position.x - main.GameManager.screenLockX
                    + main.GameManager.halfScreenWidth12Left);
            int i_19_ = (this.position.z - this.position.y - main.GameManager.screenLockY
                    + main.GameManager.halfScreenHeight12Left);
            this.al.a(this.s(), i, i_19_, 15 + this.an, this.u,
                    this.direction == 0 ? 0 : 65536);
        }
    }

    private int P() {
        int i = 2 == main.GameManager.currentDifficulty ? 1 : 0;
        int i_20_ = 0;
        if (23 <= this.state && this.state <= 28) {
            i_20_ = ap[i][this.difficultyAi];
        } else if (34 <= this.state && this.state <= 37) {
            i_20_ = aq[i][this.difficultyAi][this.an];
        }
        return i_20_ + (2 == main.GameManager.currentDifficulty ? 100 : 0);
    }

    public final void setState(int i) {
        main.Juggler var_aj_21_ = this;
        i = i;
        main.Juggler var_aj_22_ = var_aj_21_;
        main.AbstractObject var_af = getPlayerTarget();
        int i_23_ = main.GameManager.h + 655360;
        var_aj_22_.state = i;
        var_aj_22_.w();
        while_2_:
        do {
            switch (i) {
                case 3:
                case 4:
                    var_aj_22_.c(0);
                    return;
                case 5:
                    var_aj_22_.g.set(0, 0, var_aj_22_.g.y);
                    var_aj_22_.c(9);
                    return;
                case 14:
                    var_aj_22_.g.set(0, 0, var_aj_22_.g.y);
                    var_aj_22_.n = 32;
                    var_aj_22_.c(10);
                    return;
                case 12:
                case 13:
                    var_aj_22_.g.set(0, 0, var_aj_22_.g.y);
                    var_aj_22_.c(8);
                    return;
                case 15:
                    var_aj_22_.g.set(0, 0, var_aj_22_.g.y);
                    switch (var_aj_22_.y) {
                        default:
                            var_aj_22_.direction = var_aj_22_.C;
                            var_aj_22_.c(4);
                            break;
                        case 2:
                            var_aj_22_.F();
                            var_aj_22_.c(6);
                            return;
                    }
                    return;
                case 20:
                    var_aj_22_.g.set(0, 0, var_aj_22_.g.y);
                    var_aj_22_.c(5);
                    return;
                case 19:
                    var_aj_22_.g.set(0, 0, var_aj_22_.g.y);
                    var_aj_22_.c(13);
                    return;
                case 16:
                    var_aj_22_.g.set(0, 0, var_aj_22_.g.y);
                    var_aj_22_.c(14);
                    return;
                case 17:
                    var_aj_22_.g.set(0, 0, var_aj_22_.g.y);
                    var_aj_22_.y = 9;
                    var_aj_22_.c(12);
                    return;
                case 18:
                    var_aj_22_.E();
                    var_aj_22_.c(7);
                    return;
                case 22:
                    var_aj_22_.g.set(0, 0, var_aj_22_.g.y);
                    var_aj_22_.c(17);
                    return;
                case 7:
                    main.AbstractObject.i(var_aj_22_);
                    var_aj_22_.c(0);
                    return;
                case 8:
                    main.AbstractObject.h(var_aj_22_);
                    var_aj_22_.c(0);
                    return;
                case 9:
                    main.AbstractObject.g(var_aj_22_);
                    var_aj_22_.c(0);
                    return;
                case 10:
                    main.AbstractObject.f(var_aj_22_);
                    var_aj_22_.c(0);
                    return;
                case 11:
                    main.AbstractObject.e(var_aj_22_);
                    var_aj_22_.c(0);
                    return;
                case 23:
                    var_aj_22_.velocityX = var_aj_22_.R();
                    var_aj_22_.velocityZ = var_aj_22_.S();
                    var_aj_22_.targetPosition.x
                            = var_af.position.x + 409600 * (var_aj_22_.getDirectionTowardObject(var_af) == 0 ? -1
                            : 1);
                    var_aj_22_.targetPosition.y = var_af.position.z;
                    var_aj_22_.D();
                    var_aj_22_.c(0);
                    return;
                case 24:
                    var_aj_22_.direction = var_aj_22_.getDirectionTowardObject(var_af);
                    if (40960 < var_aj_22_.getDistanceZ(var_af)) {
                        var_aj_22_.velocityZ = var_aj_22_.S() * (var_aj_22_.getDirectionTowardObject(var_af) == 0
                                ? -1 : 1);
                    } else {
                        var_aj_22_.velocityZ = var_aj_22_.S() * (main.GameManager.getRandomNumber(2) == 0 ? -1 : 1);
                    }
                    var_aj_22_.c(0);
                    return;
                case 25:
                    var_aj_22_.direction = var_aj_22_.getDirectionTowardObject(var_af);
                    var_aj_22_.velocityX
                            = var_aj_22_.R() * (var_aj_22_.getDirectionTowardObject(var_af) == 0 ? 1 : -1);
                    var_aj_22_.c(0);
                    return;
                case 32:
                    var_aj_22_.velocityX
                            = var_aj_22_.R() * (var_aj_22_.getDirectionTowardObject(var_af) == 0 ? -1 : 1);
                    var_aj_22_.velocityZ
                            = var_aj_22_.S() * (var_aj_22_.position.z < var_af.position.z ? 1 : -1);
                    var_aj_22_.c(0);
                    return;
                case 26:
                    var_aj_22_.velocityX = var_aj_22_.R();
                    var_aj_22_.velocityZ = var_aj_22_.S();
                    var_aj_22_.targetPosition.x = (main.GameManager.h
                            + ((i_23_ < var_af.position.x ? 50 : 270) << 12));
                    var_aj_22_.targetPosition.y = (var_aj_22_.position.z < var_af.position.z
                            ? main.Juggler.z()
                            : main.Juggler.A());
                    var_aj_22_.D();
                    var_aj_22_.c(0);
                    return;
                case 27:
                    var_aj_22_.nextFrameToMove = 0;
                    var_aj_22_.velocityX = var_aj_22_.R();
                    var_aj_22_.velocityZ = var_aj_22_.S();
                    var_aj_22_.c(0);
                    return;
                case 28:
                    var_aj_22_.nextFrameToMove = main.GameManager.getRandomNumber(32);
                    var_aj_22_.g.set(0, 0, 0);
                    var_aj_22_.c(1);
                    return;
                case 33:
                    var_aj_22_.direction = var_aj_22_.getDirectionTowardObject(var_af);
                    var_aj_22_.c(0);
                    return;
                case 34:
                    if (var_aj_22_.ai == 0) {
                        var_aj_22_.direction = var_aj_22_.getDirectionTowardObject(var_af);
                    } else {
                        var_aj_22_.u = 0;
                        var_aj_22_.c(1);
                        return;
                    }
                    break;
                case 35:
                    var_aj_22_.c(3);
                    return;
                case 29:
                    var_aj_22_.velocityX = var_aj_22_.R();
                    var_aj_22_.velocityZ = var_aj_22_.S();
                    var_aj_22_.targetPosition.x
                            = var_af.position.x + ((50 + main.GameManager.getRandomNumber(25) << 12)
                            * (var_aj_22_.getDirectionTowardObject(var_af) == 0 ? -1 : 1));
                    var_aj_22_.targetPosition.y
                            = var_af.position.z + (35 - main.GameManager.getRandomNumber(70) << 12);
                    var_aj_22_.c(2);
                    return;
                case 30:
                    var_aj_22_.c(1);
                    return;
                case 31:
                    var_aj_22_.nextFrameToMove = 30;
                    var_aj_22_.c(1);
                    return;
                case 36:
                    var_aj_22_.c(3);
                    return;
                case 37:
                    break;
                default:
                    break while_2_;
            }
            var_aj_22_.c(3);
        } while (false);
    }

    private void Q() {
        java.lang.Object object = null;
        if (object != null) {
            /* empty */
        }
        if (!main.GameManager._a1()) {
            int i = 18 + this.an;
            int i_24_ = 0;
            switch (this.state) {
                case 34:
                    i_24_ = 0;
                    break;
                case 35:
                    i_24_ = 1;
                    break;
                case 36:
                    i_24_ = 2;
                    break;
                case 37:
                    i_24_ = 3;
                    break;
            }
            main.GameManager.enemyObjects.addElement(new main.PickableObject(ak, this, i, 18, i_24_, P()));
        }
    }

    private int R() {
        int i = 0;
        switch (this.state) {
            case 0:
                break;
            case 23:
            case 25:
            case 27:
            case 29:
                i = X[this.difficultyAi];
                break;
            case 32:
                i = ab[this.difficultyAi];
                break;
            case 26:
                i = Z[this.difficultyAi];
                break;
        }
        if (4096 != main.GameManager.enemyVelocityFactor) {
            i = (int) ((long) i * (long) main.GameManager.enemyVelocityFactor >> 12);
        }
        return i;
    }

    private int S() {
        int i = 0;
        switch (this.state) {
            case 0:
                break;
            case 23:
            case 24:
            case 27:
            case 29:
                i = Y[this.difficultyAi];
                break;
            case 32:
                i = ac[this.difficultyAi];
                break;
            case 26:
                i = aa[this.difficultyAi];
                break;
        }
        if (4096 != main.GameManager.enemyVelocityFactor) {
            i = (int) ((long) i * (long) main.GameManager.enemyVelocityFactor >> 12);
        }
        return i;
    }

    private int j(int i) {
        java.lang.Object object = null;
        if (object != null) {
            /* empty */
        }
        if (main.GameManager._a0()) {
            return 0;
        }
        int i_25_ = 0;
        int i_26_ = 2 == main.GameManager.currentDifficulty ? 1 : 0;
        switch (this.state) {
            case 0:
                break;
            case 27:
                switch (i) {
                    case 0:
                        i_25_ = ad[i_26_][this.difficultyAi][0];
                        break;
                    case 1:
                        i_25_ = ad[i_26_][this.difficultyAi][0] + ae[i_26_][this.difficultyAi];
                }
                break;
            case 34:
                i_25_ = ad[i_26_][this.difficultyAi][this.ai];
                break;
            case 29:
                switch (i) {
                    case 0:
                        i_25_ = af[i_26_];
                        break;
                    case 1:
                        i_25_ = ag[i_26_][0];
                        break;
                    case 2:
                        i_25_ = ah[i_26_][this.difficultyAi];
                }
                break;
            case 37:
                i_25_ = ag[i_26_][this.ai];
                break;
        }
        return i_25_;
    }
}
