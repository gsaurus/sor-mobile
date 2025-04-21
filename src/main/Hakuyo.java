/* v - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
package main;

import java.util.Enumeration;

public final class Hakuyo extends main.AbstractObject {

    private static final int[] W = {5000, 5000, 7500};
    private static final int[] X = {11468, 13926, 15564};
    private static final int[] Y = {11468, 13926, 15564};
    private static final int[] Z = {13107, 15564, 17203};
    private static final int[] aa = {9011, 10649, 12288};
    private static final int[][] ab = {{20, 35, 45}, {30, 30, 30}, {15, 20, 25}};
    private static final int[][] ac = {{25, 30, 40}, {25, 30, 40}, {25, 30, 40}};
    private static final int[][] ad = {{35, 30, 20}, {35, 30, 20}, {35, 30, 20}};
    private static final int[][] ae = {{25, 40, 55}, {30, 30, 30}, {10, 15, 20}};
    private static final int[][] af = {{80, 80, 80}, {80, 80, 80}, {90, 90, 90}};
    private static final int[][][] ag = {
        {{15, 33}, {25, 33}, {30, 33}},
        {{40, 33}, {40, 33}, {40, 33}},
        {{65, 33}, {65, 33}, {65, 33}}};
    private int ah = 60;
    private int ai = 10;
    private int aj = 90;
    private int ak = 20;
    private int al = 2;
    private int am;
    private int an;
    private boolean ao;
    private int ap;
    private static final int[][][] aq;
    private static final int[][] ar;

    static {
        (new int[][]{{33, 33, 33}, null})[1] = new int[]{30, 30, 30};
        (new int[]{33, 33, 0})[2] = 33;
        aq = (new int[][][]{{{1000, 1000}, {1000, 1000}, {1000, 1000}},
        {{1000, 1000}, {1000, 1000}, {1000, 1000}}});
        ar = new int[][]{{800, 800, 800}, {800, 800, 800}};
    }

    public Hakuyo(main.ObjectArt var_ad, int i, int i_0_, int i_1_,
            int i_2_, int i_3_, int i_4_) {
        super(6, i, i_0_, i_1_, i_2_, i_3_, i_4_);
        this.stateFlags |= 0x8201;
        this.r = new main.eExtendsAr(0, var_ad, 19);
        this.collisionBox
                = new main.CollisionBox(this.position,
                        new main.Point(65536,
                                32768,
                                131072));
        this.nextFrameToMove = 0;
        this.Q = 0;
        this.am = 0;
        this.an = 0;
        this.D = false;
        this.K = new main.Point(this.position.x, this.position.z, this.position.y);
        this.O = 0;
        this.energy = W[this.difficultyAi];
        this.maxEnergy = this.energy;
        this.visualEnergy = main.GameManager.f(this.energy);
        this.name = "KUNGFU";
    }

    public final void update() {
        super.update();
        main.AbstractObject target = getPlayerTarget();
        int i = main.GameManager.getRandomNumber(100);
        int i_5_ = 0;
        int i_6_ = 0;
        if (target == null) {
            if (!this.j()) {
                this.setState(3);
            }
        } else {
            i_5_ = this.getDistanceX(target);
            i_6_ = this.getDistanceZ(target);
        }
        this.D = false;
        if (this.state != 3 && this.q > 0) {
            this.setState(3);
        }
        main.AbstractObject.j(this);
        if (5 <= this.state && this.state <= 22) {
            this.a(this.state, V, target);
        } else {
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
                case 23:
                    if (this.position.x < (main.GameManager.screenLockX
                            + (main.GameManager.screenWidth / 2 << 12))
                            && this.position.x > (main.GameManager.screenLockX
                            - (main.GameManager.screenWidth / 2 << 12))) {
                        this.q = main.GameManager.getRandomNumber(15) + 1;
                    }
                    break;
                case 24:
                    this.targetPosition.x = target.position.x + 163840 * (this.getDirectionTowardObject(target) == 0 ? -1
                            : 1) + this.am;
                    this.targetPosition.y = target.position.z + this.an;
                    main.AbstractObject.moveToTarget(this, target);
                    if (!P()) {
                        if (204800 > this.getDistanceX(target) && 40960 > this.getDistanceZ(target)) {
                            this.setState(25);
                        } else {
                            if (this.currAnimFrame % 24 == 0) {
                                if (this.ak << 12 > i_5_ - this.aj << 12
                                        && 40960 > this.getDistanceZ(target) && getProbabilityByState(0) > i) {
                                    this.setState(34);
                                }
                                if (this.ai << 12 > i_5_ - this.ah << 12
                                        && 40960 > this.getDistanceZ(target) && getProbabilityByState(1) > i) {
                                    this.setState(31);
                                }
                            }
                            this.R = 7;
                        }
                    }
                    break;
                case 25:
                    this.targetPosition.x
                            = target.position.x + 204800 * (this.getDirectionTowardObject(target) == 0 ? -1 : 1);
                    this.targetPosition.y = target.position.z;
                    main.AbstractObject.moveToTarget(this, target);
                    if (!P()) {
                        if (this.nextFrameToMove == 0) {
                            if (245760 > i_5_ && 40960 > i_6_) {
                                this.setState(getProbabilityByState(0) > i ? 32 : getProbabilityByState(1) > i ? 27 : getProbabilityByState(2) > i
                                        ? 28 : 26);
                            } else {
                                this.setState(24);
                            }
                        }
                        this.R = 4;
                    }
                    break;
                case 31:
                    if (this.loopMovement) {
                        this.g.set(0, 0, 0);
                        this.setState(24);
                    }
                    break;
                case 26:
                    this.targetPosition.x
                            = target.position.x + 348160 * (this.getDirectionTowardObject(target) == 0 ? -1 : 1);
                    this.targetPosition.y = target.position.z;
                    main.AbstractObject.moveToTarget(this, target);
                    if (!P()) {
                        if (this.nextFrameToMove == 0) {
                            this.setState(25);
                        }
                        this.R = 4;
                    }
                    break;
                case 27:
                    if (this.currAnimFrame == 12) {
                        this.N = 4;
                    }
                    if (13 == this.currAnimFrame) {
                        this.d(-3 - main.GameManager.getRandomNumber(5), 0, 0);
                        this.d(7 - main.GameManager.getRandomNumber(5), 0, 0);
                    }
                    if (this.loopMovement) {
                        main.Hakuyo.playSound(this.al);
                        this.g.set(0, 0, 0);
                        this.direction = this.getDirectionTowardObject(target);
                        if (this.ak << 12 > (java.lang.Math.abs(java.lang.Math
                                .abs(target.position.x - this.position.x)
                                - (this.aj << 12)))
                                && getProbabilityByState(0) > i) {
                            this.setState(34);
                        } else {
                            this.setState(3);
                        }
                    }
                    break;
                case 28:
                    if (this.currAnimFrame == 12) {
                        this.N = 4;
                    }
                    if (13 == this.currAnimFrame) {
                        this.d(-3 - main.GameManager.getRandomNumber(5), 0, 0);
                        this.d(7 - main.GameManager.getRandomNumber(5), 0, 0);
                    }
                    this.position.x += this.velocityX;
                    this.position.z += this.velocityZ;
                    if (this.loopMovement) {
                        main.Hakuyo.playSound(this.al);
                        this.setState(31);
                    }
                    break;
                case 30:
                    if (this.currAnimFrame == 12) {
                        this.N = 4;
                    }
                    if (13 == this.currAnimFrame) {
                        this.d(-3 - main.GameManager.getRandomNumber(5), 0, 0);
                        this.d(7 - main.GameManager.getRandomNumber(5), 0, 0);
                    }
                    if (this.loopMovement) {
                        this.g.set(0, 0, 0);
                        this.setState(24);
                    }
                    break;
                case 32:
                    if (this.loopMovement) {
                        this.setState(getProbabilityByState(0) > i ? 33 : 26);
                    }
                    break;
                case 33:
                    if (this.loopMovement) {
                        this.setState(26);
                    }
                    break;
                case 34:
                    if (this.loopMovement) {
                        main.Point var_q = this.position;
                        var_q.x = var_q.x + 204800 * (this.direction == 0 ? 1 : -1);
                        this.setState(main.GameManager.getRandomNumber(2) == 0 ? 29 : 30);
                    }
                    break;
                case 29:
                    main.AbstractObject.moveToTarget(this, target);
                    if (this.targetPosition.x == this.position.x && this.targetPosition.y == this.position.z) {
                        this.setState(24);
                    } else {
                        this.R = 6;
                    }
                    break;
            }
        }
        super.i();
        this.h();
    }

    public final void checkHammerSmash() {
        main.Hakuyo var_v_7_ = this;
        main.Hakuyo var_v_8_ = this;
        int i = 2 == main.GameManager.currentDifficulty ? 1 : 0;
        int i_9_;
        while_10_:
        do {
            int i_10_;
            switch (var_v_8_.state) {
                default:
                    i_9_ = 1000;
                    break while_10_;
                case 32:
                case 33:
                case 34:
                    i_10_ = (aq[i][var_v_8_.difficultyAi][var_v_8_.state == 34 ? 0 : var_v_8_.state - 32]);
                    break;
                case 31:
                    i_10_ = ar[i][var_v_8_.difficultyAi];
            }
            i_9_ = i_10_ + (2 == main.GameManager.currentDifficulty ? 100 : 0);
        } while (false);
        if (var_v_7_.checkAttackObjects(i_9_, 0) && this.state == 32) {
            this.ap++;
        }
    }

    public final void onAttackContact(main.AbstractObject var_af, int i, int i_11_,
            int i_12_, int i_13_) {
        int i_14_;
        if ((i_14_ = this.onBeingAttacked(var_af, i, i_11_, i_12_, i_13_)) > 0) {
            this.setState(i_14_);
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
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 29:
                return true;
        }
        return false;
    }

    public final void setState(int i) {
        main.AbstractObject var_af;
        int i_15_ = ((var_af = getPlayerTarget()) != null
                ? this.getDirectionTowardObject(var_af) : 0);
        int i_16_ = main.GameManager.h + 655360;
        this.state = i;
        this.w();
        if (i != 27 && i != 29) {
            this.ao = false;
        }
        while_11_:
        do {
            switch (i) {
                case 3:
                    this.g.set(0, 0, this.g.y);
                    this.q = 2;
                /* fall through */
                case 4:
                case 23:
                    this.c(0);
                    return;
                case 5:
                    this.d(8);
                    return;
                case 14:
                    this.n = 32;
                    this.d(6);
                    return;
                case 12:
                case 13:
                    this.d(12);
                    return;
                case 15:
                    switch (this.y) {
                        default:
                            this.direction = this.C;
                            this.d(5);
                            break;
                        case 2:
                            this.F();
                            this.c(10);
                            return;
                    }
                    return;
                case 20:
                    this.d(14);
                    return;
                case 19:
                    this.d(15);
                    return;
                case 16:
                    this.d(16);
                    return;
                case 17:
                    this.y = 9;
                    this.d(9);
                    return;
                case 18:
                    this.E();
                    this.c(11);
                    return;
                case 22:
                    this.d(18);
                    return;
                case 7:
                    main.AbstractObject.i(this);
                    this.c(0);
                    return;
                case 8:
                    main.AbstractObject.h(this);
                    this.c(0);
                    return;
                case 9:
                    main.AbstractObject.g(this);
                    this.c(0);
                    return;
                case 10:
                    main.AbstractObject.f(this);
                    this.c(0);
                    return;
                case 11:
                    main.AbstractObject.e(this);
                    this.c(0);
                    return;
                case 24:
                    this.velocityX = Q();
                    this.velocityZ = R();
                    this.am = main.GameManager.getRandomNumber(20) - 10 << 12;
                    this.an = main.GameManager.getRandomNumber(20) - 10 << 12;
                    this.c(0);
                    return;
                case 25:
                    this.velocityX = Q();
                    this.velocityZ = R();
                    this.nextFrameToMove = main.GameManager.getRandomNumber(31) + 1;
                    this.c(0);
                    return;
                case 31:
                    this.g.x = 20480 * (this.getDirectionTowardObject(var_af) == 0 ? 1 : -1);
                    this.x = 2;
                    this.direction = this.getDirectionTowardObject(var_af);
                    main.Hakuyo.playSound(0);
                    this.c(3);
                    return;
                case 26:
                    this.velocityX = Q();
                    this.velocityZ = R();
                    this.nextFrameToMove = main.GameManager.getRandomNumber(16) + 16;
                    this.c(0);
                    return;
                case 27:
                    main.Hakuyo.playSound(0);
                    if (var_af.position.x < this.position.x) {
                        this.g.x = -37236;
                    } else {
                        this.g.x = 37236;
                    }
                    this.g.z = 0;
                    break;
                case 28:
                    main.Hakuyo.playSound(0);
                    this.velocityX = 12288 * (i_15_ == 0 ? -1 : 1);
                    this.velocityZ = 2 - main.GameManager.getRandomNumber(5) << 12;
                    break;
                case 32:
                    this.ap = 0;
                /* fall through */
                case 33:
                    main.Hakuyo.playSound(0);
                    main.Hakuyo.playSound(0);
                    this.x = 1;
                    this.c(4);
                    return;
                case 34:
                    this.x = 2;
                    this.c(17);
                    return;
                case 29:
                    this.velocityX = Q();
                    this.velocityZ = R();
                    this.targetPosition.x = i_16_ + ((main.GameManager.getRandomNumber(50) << 12)
                            * (this.getDirectionTowardObject(var_af) == 0 ? 1 : -1));
                    this.targetPosition.y = this.position.z;
                    this.c(0);
                    return;
                case 30:
                    if (var_af.position.x < this.position.x) {
                        this.g.x = (main.GameManager.screenLockX
                                + (main.GameManager.screenWidth / 2 << 12)
                                - (main.GameManager.getRandomNumber(50) << 12)
                                - this.position.x) / 11;
                    } else {
                        this.g.x = (main.GameManager.screenLockX
                                - (main.GameManager.screenWidth / 2 << 12)
                                + (main.GameManager.getRandomNumber(50) << 12)
                                - this.position.x) / 11;
                    }
                    break;
                default:
                    break while_11_;
            }
            this.c(2);
        } while (false);
    }

    private boolean P() {
        if (this.ao) {
            return false;
        }
        boolean bool = false;
        java.util.Enumeration enumeration
                = main.GameManager.collidableObjects.elements();
        while (enumeration.hasMoreElements()) {
            main.AbstractObject var_af
                    = (main.AbstractObject) enumeration.nextElement();
            if (this != var_af && var_af.objectType == 6 && 204800 > this.getDistanceX(var_af)
                    && 122880 > this.getDistanceZ(var_af)) {
                main.Hakuyo var_v_17_;
                if (!(var_v_17_ = (main.Hakuyo) var_af).ao) {
                    if (var_v_17_.state == 27) {
                        this.setState(29);
                    } else {
                        this.setState(27);
                    }
                    this.ao = true;
                    bool = true;
                } else if (this.state == 29) {
                    this.setState(24);
                    bool = true;
                } else {
                    this.setState(29);
                    bool = true;
                }
                break;
            }
        }
        return bool;
    }

    private int Q() {
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
            case 25:
            case 26:
                i = X[this.difficultyAi];
                break;
            case 29:
                i = Z[this.difficultyAi];
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
            case 24:
            case 25:
            case 26:
                i = Y[this.difficultyAi];
                break;
            case 29:
                i = aa[this.difficultyAi];
                break;
        }
        if (4096 != main.GameManager.enemyVelocityFactor) {
            i = (int) ((long) i * (long) main.GameManager.enemyVelocityFactor >> 12);
        }
        return i;
    }

    private int getProbabilityByState(int i) {
        int i_18_ = 0;
        int diff = GameManager.currentDifficulty; //2 == main.GameManager.currentDifficulty ? 1 : 0;
        switch (this.state) {
            case 0:
                break;
            case 24:
                i_18_ = i == 0 ? ae[diff][this.difficultyAi] : ab[diff][this.difficultyAi];
                break;
            case 25:
                i_18_ = (i == 0 ? ag[diff][this.difficultyAi][0] : 1 == i
                        ? ag[diff][this.difficultyAi][0] + ac[diff][this.difficultyAi]
                        : (ag[diff][this.difficultyAi][0] + ac[diff][this.difficultyAi]
                        + ad[diff][this.difficultyAi]));
                break;
            case 27:
                i_18_ = af[diff][this.difficultyAi];
                break;
            case 32:
                i_18_ = ag[diff][this.difficultyAi][1];
                break;
        }
        return i_18_;
    }
}
