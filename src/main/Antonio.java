/* al - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
package main;

public final class Antonio extends main.AbstractObject {

    private static final int[] W = {20000, 20000};
    private static final int[] X = {12288, 12288, 12288};
    private static final int[] Y = {12288, 12288, 12288};
    private static final int[] Z = {16384, 16384, 16384};
    private static final int[] aa = {8192, 8192, 4096};
    private static final int[] ab;
    private static final int[] ac;
    private static final int[] ad;
    private static final int[] ae;
    private static final int[] af;
    private static final int[] ag;
    private static final int[] ah;
    private static final int[][][] ai;
    private static final int[][] aj;
    private static final int[][] ak;
    private static final int[][] al;
    private int am;
    private boolean an;
    private int ao;
    private boolean ap;
    private static main.ObjectArt aq;
    private static final int[][] ar;
    private static final int[][] as;

    static {
        (new int[]{8192, 8192, 0})[2] = 8192;
        ab = new int[]{2457, 2457, 2457};
        ac = new int[]{8192, 8192, 8192};
        ad = new int[]{2457, 2457, 6553};
        ae = new int[]{19660, 19660, 19660};
        af = new int[]{9011, 9011, 9011};
        ag = new int[]{20480, 20480, 20480};
        ah = new int[]{10240, 10240, 10240};
        ai = new int[][][]{{{50}, {30, 50, 65}},
        {{75}, {55, 50, 65}}};
        aj = new int[][]{{50, 50, 75}, {23, 50, 75}};
        ak = new int[][]{{35, 55, 65}, {60, 65, 90}};
        al = new int[][]{{50, 50, 50}, {50, 50, 50}};
        ar = new int[][]{{700, 700, 700}, {700, 700, 700}};
        as = new int[][]{{1500, 1500, 1500}, {1500, 1500, 1500}};
    }

    public Antonio(main.ObjectArt var_ad, int i, int i_0_, int i_1_,
            int i_2_, int i_3_, int i_4_) {
        super(10, i, i_0_, i_1_, i_2_, i_3_, i_4_);
        this.stateFlags |= 0x8401;
        this.r = new main.eExtendsAr(0, var_ad, 18);
        this.collisionBox
                = new main.CollisionBox(this.position,
                        new main.Point(131072,
                                131072,
                                131072));
        this.nextFrameToMove = 0;
        this.Q = 0;
        this.ao = 0;
        this.D = false;
        this.ap = true;
        aq = var_ad;
        this.energy = W[this.difficultyAi];
        this.maxEnergy = this.energy;
        this.visualEnergy = main.GameManager.f(this.energy);
        this.name = "STITCH";
    }

    public final void update() {
        super.update();
        int i = main.GameManager.getRandomNumber(100);
        main.AbstractObject target = getPlayerTarget();
        int i_6_ = 0;
        int i_7_ = 0;
        if (target == null) {
            if (!this.j()) {
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
        if (5 < this.state && this.state <= 22) {
            this.a(this.state, V, target);
        } else {
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
                    } else if (target != null) {
                        this.setState(24);
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
                        if (81920 > i_6_ && 40960 > i_7_) {
                            this.setState(39);
                        } else {
                            this.setState(3);
                        }
                    }
                    break;
                case 24:
                    main.AbstractObject.moveToTarget(this, target);
                    if (this.e(0, 0)) {
                        this.ap = true;
                        this.setState(25);
                    }
                    break;
                case 25:
                    main.AbstractObject.moveToTarget(this, target);
                    if (this.position.z == this.targetPosition.y) {
                        if (245760 > i_6_ && 20480 > i_7_) {
                            this.setState(39);
                        } else {
                            this.setState(30);
                        }
                    } else {
                        this.R = 7;
                    }
                    break;
                case 26:
                case 27:
                case 28:
                    this.targetPosition.x = target.position.x + 614400 * (this.getDirectionTowardObject(target) == 0
                            ? -1 : 1);
                    this.targetPosition.y = target.position.z - 40960;
                    main.AbstractObject.moveToTarget(this, target);
                    if (!this.x()) {
                        this.setState(24);
                    } else {
                        if ((40960 > java.lang.Math.abs(this.targetPosition.x - this.position.x))
                                && 45056 > i_7_ && target.position.z >= this.position.z) {
                            this.setState(40 + (this.state - 26));
                        }
                    }
                    break;
                case 29:
                    this.targetPosition.x = target.position.x + 327680 * (this.getDirectionTowardObject(target) == 0
                            ? -1 : 1);
                    this.targetPosition.y = target.position.z + 122880;
                    main.AbstractObject.moveToTarget(this, target);
                    if (122880 > main.Antonio.A() - target.position.z
                            || 122880 > target.position.z - main.Antonio.z()) {
                        this.setState(24);
                    }
                    if (this.e(0, 0)) {
                        this.setState(41);
                    }
                    break;
                case 30:
                    if (245760 > i_6_) {
                        this.setState(39);
                    } else if (this.nextFrameToMove > 0) {
                        this.nextFrameToMove--;
                    } else if (this.j(0) > i) {
                        if (W[this.difficultyAi] / 2 < this.energy) {
                            this
                                    .setState(main.GameManager.getRandomNumber(2) == 0 ? 26 : 28);
                        } else {
                            i = main.GameManager.getRandomNumber(3);
                            this.setState(i == 0 ? 26 : 1 == i ? 27 : 28);
                        }
                    } else if (this.j(1) > i) {
                        this.setState(36);
                    } else {
                        this.setState(31);
                    }
                    break;
                case 31:
                    if ((this.Q & 0x3) == 0) {
                        this.direction = this.getDirectionTowardObject(target);
                    }
                    this.position.z += this.velocityZ;
                    if (this.nextFrameToMove > 0) {
                        this.nextFrameToMove--;
                    } else {
                        this.nextFrameToMove = main.GameManager.getRandomNumber(16) + 16;
                        this.velocityX = this.R() * (this.velocityZ < 0 ? 1 : -1);
                    }
                    if (245760 > i_6_ && 40960 > i_7_) {
                        this.setState(39);
                    }
                    if (this.currAnimFrame % 16 << 1 == 0) {
                        main.Antonio var_al_9_ = this;
                        int i_10_ = i;
                        main.Antonio var_al_11_;
                        if ((var_al_11_ = var_al_9_).j(0) > i_10_) {
                            if (W[var_al_11_.difficultyAi] / 2 < var_al_11_.energy) {
                                if (main.GameManager.getRandomNumber(2) == 0) {
                                    var_al_11_.setState(26);
                                } else {
                                    var_al_11_.setState(42);
                                }
                            } else {
                                switch (main.GameManager.getRandomNumber(3)) {
                                    case 0:
                                        var_al_11_.setState(26);
                                        break;
                                    case 1:
                                        var_al_11_.setState(27);
                                        break;
                                    case 2:
                                        var_al_11_.setState(42);
                                }
                            }
                        } else if (var_al_11_.j(1) > i_10_) {
                            var_al_11_.setState(36);
                        }
                        if (31 != this.state) {
                            break;
                        }
                    }
                    if (80 < this.currAnimFrame) {
                        this.setState(24);
                    }
                    break;
                case 32:
                case 33:
                case 34:
                    if (10 < this.currAnimFrame) {
                        this.position.z += this.velocityZ;
                    }
                    if (W[this.difficultyAi] / 2 > this.energy && !target.u()
                            && 614400 > i_6_ && 40960 > i_7_) {
                        this.setState(36);
                    } else if (48 < this.currAnimFrame) {
                        this.setState(3);
                    } else {
                        this.R = 7;
                    }
                    break;
                case 35:
                    main.AbstractObject.moveToTarget(this, target);
                    if (120 < this.currAnimFrame) {
                        this.setState(24);
                    }
                    this.R = 7;
                    break;
                case 36:
                    if (this.position.x < target.position.x) {
                        this.targetPosition.x = target.position.x - 286720;
                    } else {
                        this.targetPosition.x = target.position.x + 286720;
                    }
                    this.targetPosition.y = target.position.z;
                    main.AbstractObject.moveToTarget(this, target);
                    if (327680 > i_6_ && 20480 > i_7_) {
                        this.setState(39);
                    } else if (!this.x() || this.nextFrameToMove == 0) {
                        this.setState(3);
                    }
                    break;
                case 39:
                    if (this.loopMovement) {
                        this.setState(24);
                    }
                    break;
                case 40:
                case 41:
                case 42:
                case 43:
                    if (W[this.difficultyAi] / 2 > this.energy && !target.u()
                            && 614400 > i_6_ && 40960 > i_7_) {
                        this.setState(36);
                    } else {
                        if (this.currAnimFrame - 5 == 0) {
                            this.am++;
                            this.an = this.position.z >= target.position.z;
                            main.GameManager.enemyObjects.addElement(new main.PickableObject(aq, this, 18, 18,
                                    this.state - 40,
                                    this.P()));
                        }
                        if (this.loopMovement) {
                            if (W[this.difficultyAi] / 2 > this.energy
                                    && this.am < 3 && this.j(0) > i) {
                                this.setState(40);
                            } else {
                                this.setState(32 + (this.state - 40));
                            }
                        }
                    }
                    break;
                case 37:
                    this.position.x += this.velocityX;
                    this.position.z += this.velocityZ;
                    if (30 < this.currAnimFrame) {
                        main.Antonio var_al_12_ = this;
                        target = target;
                        main.Antonio var_al_13_ = var_al_12_;
                        int i_14_ = main.GameManager.getRandomNumber(100);
                        i_6_ = var_al_13_.getDistanceX(target);
                        i_7_ = var_al_13_.getDistanceZ(target);
                        int i_15_ = 2 == main.GameManager.currentDifficulty ? 1 : 0;
                        int i_16_ = W[var_al_13_.difficultyAi] / 50 < var_al_13_.energy ? 0 : 1;
                        if (409600 > i_6_ && 20480 > i_7_) {
                            var_al_13_.setState(36);
                        } else if (819200 < i_6_) {
                            var_al_13_.setState(37);
                        } else if (var_al_13_.ap) {
                            if (122880 < main.Antonio.A() - target.position.z
                                    && (122880
                                    < target.position.z - main.Antonio.z())) {
                                if (var_al_13_.getDirectionTowardObject(target) == 0) {
                                    if (614400
                                            < target.position.x - main.GameManager.h) {
                                        var_al_13_.setState(29);
                                        break;
                                    }
                                } else if (614400 < (main.GameManager.g
                                        - target.position.x)) {
                                    var_al_13_.setState(29);
                                    break;
                                }
                            }
                            if (aj[i_15_][i_16_] > i_14_) {
                                var_al_13_.setState(26);
                            } else {
                                var_al_13_.setState(24);
                            }
                        }
                    }
                    break;
            }
        }
        super.i();
        boolean bool = main.GameManager.currentLevel == 7;
        if (this.ao == 0) {
            main.GameManager.e(bool ? 2 : 4);
            this.ao++;
        } else if (this.ao == 1) {
            if (this.energy <= 13000) {
                main.GameManager.e(bool ? 2 : 3);
                this.ao++;
            }
        } else if (this.ao == 2 && this.energy <= 4000) {
            main.GameManager.e(bool ? 2 : 7);
            this.ao++;
        }
        this.h();
    }

    private int P() {
        int i = 2 == main.GameManager.currentDifficulty ? 1 : 0;
        int i_17_;
        switch (this.state) {
            default:
                return 1000;
            case 39:
                i_17_ = as[i][this.difficultyAi];
                break;
            case 40:
            case 41:
            case 42:
            case 43:
                i_17_ = ar[i][this.difficultyAi];
        }
        return i_17_ + (2 == main.GameManager.currentDifficulty ? 100 : 0);
    }

    public final void checkHammerSmash() {
        this.checkAttackObjects(P(), 0);
    }

    public final void onAttackContact(main.AbstractObject var_af, int i, int i_18_,
            int i_19_, int i_20_) {
        if (this.energy > 0) {
            if (var_af != null && 32 <= this.state && this.state <= 35
                    && var_af.objectType == this.objectType) {
                this.ap = true;
                var_af.onAttackContact(this, 0, 0, 0, 0);
                this.setState(3);
            } else {
                int i_21_;
                if ((i_21_ = this.onBeingAttacked(var_af, i, i_18_, i_19_, i_20_)) > 0) {
                    this.setState(i_21_);
                }
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
            case 24:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 36:
            case 37:
            case 38:
                return true;
        }
        return false;
    }

    public final void c(int i) {
        if (!this.ap) {
            switch (i) {
                case 0:
                case 2:
                    i++;
                    break;
            }
        }
        super.c(i);
    }

    public final void setState(int i) {
        main.Antonio var_al_22_ = this;
        i = i;
        main.Antonio var_al_23_ = var_al_22_;
        int i_24_ = main.GameManager.h + 655360;
        main.AbstractObject var_af = getPlayerTarget();
        int i_25_ = 0;
        if (var_af != null) {
            i_25_ = var_al_23_.getDirectionTowardObject(var_af);
            var_al_23_.getDistanceX(var_af);
            var_al_23_.getDistanceZ(var_af);
        }
        var_al_23_.state = i;
        var_al_23_.w();
        switch (i) {
            case 23:
                var_al_23_.d(2);
                break;
            case 3:
            case 4:
                var_al_23_.c(0);
                break;
            case 5:
                var_al_23_.d(10);
                break;
            case 14:
                var_al_23_.n = 32;
                var_al_23_.d(17);
                break;
            case 12:
            case 13:
                var_al_23_.d(5);
                break;
            case 15:
                switch (var_al_23_.y) {
                    default:
                        var_al_23_.direction = var_al_23_.C;
                        var_al_23_.d(6);
                        break;
                    case 2:
                        var_al_23_.F();
                        var_al_23_.c(8);
                        break;
                }
                break;
            case 20:
                var_al_23_.d(7);
                break;
            case 19:
                var_al_23_.d(14);
                break;
            case 16:
                var_al_23_.d(16);
                break;
            case 17:
                var_al_23_.y = 9;
                var_al_23_.d(11);
                break;
            case 18:
                var_al_23_.E();
                var_al_23_.c(12);
                break;
            case 24:
                var_al_23_.velocityX = var_al_23_.Q();
                var_al_23_.velocityZ = var_al_23_.R();
                if (var_al_23_.position.x < i_24_) {
                    var_al_23_.targetPosition.x = main.GameManager.h + 1310720 - 204800;
                } else {
                    var_al_23_.targetPosition.x = main.GameManager.h + 204800;
                }
                if (var_al_23_.position.z < var_af.position.z) {
                    var_al_23_.targetPosition.y = main.Antonio.z();
                } else {
                    var_al_23_.targetPosition.y = main.Antonio.A();
                }
                var_al_23_.c(0);
                break;
            case 25:
                var_al_23_.velocityX = var_al_23_.Q();
                var_al_23_.velocityZ = var_al_23_.R();
                var_al_23_.targetPosition.y = main.Antonio.C();
                var_al_23_.c(0);
                break;
            case 26:
            case 27:
            case 28:
                var_al_23_.am = 0;
                var_al_23_.velocityX = var_al_23_.R();
                var_al_23_.velocityZ = var_al_23_.R();
                var_al_23_.c(0);
                break;
            case 29:
                var_al_23_.velocityX = var_al_23_.Q();
                var_al_23_.velocityZ = var_al_23_.R();
                var_al_23_.c(0);
                break;
            case 30:
                var_al_23_.nextFrameToMove = main.GameManager.getRandomNumber(24);
                var_al_23_.c(0);
                break;
            case 31:
                var_al_23_.nextFrameToMove = main.GameManager.getRandomNumber(16) + 16;
                if (main.GameManager.getRandomNumber(1) == 0) {
                    var_al_23_.velocityZ = var_al_23_.R();
                } else {
                    var_al_23_.velocityZ = -var_al_23_.R();
                }
                var_al_23_.c(0);
                break;
            case 32:
            case 33:
                var_al_23_.velocityZ = -var_al_23_.R();
                var_al_23_.c(1);
                break;
            case 34:
                var_al_23_.velocityZ = var_al_23_.an ? -2048 : 2048;
                var_al_23_.c(1);
                break;
            case 36:
                var_al_23_.nextFrameToMove = 16 + main.GameManager.getRandomNumber(33);
                var_al_23_.velocityX = var_al_23_.Q();
                var_al_23_.velocityZ = var_al_23_.R();
                var_al_23_.c(0);
                break;
            case 39:
                var_al_23_.soundToPlayOnContact = 60;
                var_al_23_.x = 2;
                var_al_23_.c(4);
                break;
            case 40:
            case 41:
            case 42:
            case 43:
                main.Antonio.playSound(0);
                var_al_23_.ap = false;
                var_al_23_.x = 2;
                var_al_23_.c(15);
                break;
            case 37:
                var_al_23_.velocityX = var_al_23_.Q() * (i_25_ == 0 ? 1 : -1);
                var_al_23_.velocityZ
                        = var_al_23_.R() * (main.GameManager.getRandomNumber(2) == 0 ? 1 : -1);
                var_al_23_.c(0);
                break;
            case 38:
                var_al_23_.velocityX = var_al_23_.Q() * (i_25_ == 0 ? -1 : 1);
                var_al_23_.c(0);
        }
    }

    private int Q() {
        java.lang.Object object = null;
        if (object != null) {
            /* empty */
        }
        if (main.GameManager._a1()) {
            return 0;
        }
        int i = 0;
        switch (this.state) {
            case 0:
                break;
            case 37:
            case 38:
                i = X[this.difficultyAi];
                break;
            case 24:
            case 25:
            case 29:
                i = ag[this.difficultyAi];
                break;
            case 36:
                i = ae[this.difficultyAi];
                break;
            case 26:
            case 27:
                i = Z[this.difficultyAi];
                break;
            case 33:
                i = ac[this.difficultyAi];
                break;
        }
        if (4096 != main.GameManager.enemyVelocityFactor) {
            i = (int) ((long) i * (long) main.GameManager.enemyVelocityFactor >> 12);
        }
        return i;
    }

    private int R() {
        int i = 0;
        switch (this.state) {
            case 0:
                break;
            case 31:
            case 37:
                i = Y[this.difficultyAi];
                break;
            case 24:
            case 25:
            case 29:
                i = ah[this.difficultyAi];
                break;
            case 36:
                i = af[this.difficultyAi];
                break;
            case 26:
            case 27:
            case 28:
                i = aa[this.difficultyAi];
                break;
            case 32:
                i = ab[this.difficultyAi];
                break;
            case 33:
                i = ad[this.difficultyAi];
                break;
        }
        if (4096 != main.GameManager.enemyVelocityFactor) {
            i = (int) ((long) i * (long) main.GameManager.enemyVelocityFactor >> 12);
        }
        return i;
    }

    private int j(int i) {
        int i_26_ = 0;
        int i_27_ = 2 == main.GameManager.currentDifficulty ? 1 : 0;
        int i_28_ = W[this.difficultyAi] / 2 < this.energy ? 0 : 1;
        switch (this.state) {
            case 0:
                break;
            case 25:
                i_26_ = ak[i_27_][i_28_];
                break;
            case 39:
                i_26_ = al[i_27_][i_28_];
                break;
            case 30:
            case 31:
                switch (i) {
                    case 0:
                        i_26_ = ai[i_27_][i_28_][0];
                        break;
                    case 1:
                        i_26_ = ai[i_27_][i_28_][0] + ak[i_27_][i_28_];
                }
                break;
            case 40:
            case 41:
            case 42:
                i_26_ = ai[i_27_][i_28_][this.am];
                break;
        }
        return i_26_;
    }
}
