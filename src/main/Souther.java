/* ac - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
package main;

public final class Souther extends main.AbstractObject {

    private static final int[] W = {20000, 20000};
    private static final int[] X = {10240, 8192, 8192};
    private static final int[] Y = {18432, 8192, 8192};
    private static final int[] Z = {24576, 23756, 23756};
    private static final int[] aa = {22118, 21299, 21299};
    private static final int[] ab = {24576, 23756, 23756};
    private static final int[] ac = {22118, 21299, 21299};
    private static final int[] ad = {35225, 23756, 23756};
    private static final int[] ae = {13107, 21299, 21299};
    private int af;
    private int ag;
    private static main.eExtendsAr[] ah;
    private main.Point[] ai;
    private static final int[][] aj;
    private static final int[][] ak;

    static {
        (new int[]{35, 50, 0})[2] = 25;
        (new int[]{15, 0})[1] = 45;
        aj = new int[][]{{1400, 1400, 1400}, {1400, 1400, 1400}};
        ak = new int[][]{{1800, 1800, 1800}, {1800, 1800, 1800}};
    }

    public Souther(main.ObjectArt var_ad, int i, int i_0_, int i_1_,
            int i_2_, int i_3_, int i_4_) {
        super(11, i, i_0_, i_1_, i_2_, i_3_, i_4_);
        this.stateFlags |= 0x8401;
        this.r = new main.eExtendsAr(0, var_ad, 14);
        if (ah == null) {
            ah = new main.eExtendsAr[4];
        }
        this.ai = new main.Point[4];
        for (i = 0; i < 4; i++) {
            ah[i] = new main.eExtendsAr(0, var_ad, 14);
            this.ai[i] = new main.Point(0, 0, 0);
            ah[i].a(4);
            ah[i].setB(this.direction == 0 ? 0 : 65536);
            ah[i].b(2);
            ah[i].d = 383;
        }
        this.collisionBox
                = new main.CollisionBox(this.position,
                        new main.Point(65536,
                                32768,
                                131072));
        this.nextFrameToMove = 0;
        this.af = 0;
        this.Q = 0;
        this.ag = 0;
        this.D = false;
        this.energy = W[this.difficultyAi];
        this.maxEnergy = this.energy;
        this.visualEnergy = main.GameManager.f(this.energy);
        this.name = "JACK";
    }

    public final void update() {
        super.update();
        main.AbstractObject target = getPlayerTarget();
        int i = 0;
        int i_5_ = 0;
        if (target == null) {
            if (this.state != 23 && !this.j()) {
                this.setState(3);
            }
        } else {
            i = this.getDistanceX(target);
            i_5_ = this.getDistanceZ(target);
        }
        this.D = false;
        if (this.state != 3 && this.q > 0 && this.state != 23) {
            this.setState(3);
        }
        if (5 < this.state && this.state <= 22) {
            this.a(this.state, V, target);
        } else {
            int i_8_ = i;
            int i_9_ = i_5_;
            i_5_ = i_8_;
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
                        this.setState(25);
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
                        if (245760 > i_5_ && 40960 > i_9_) {
                            this.setState(32);
                        } else {
                            this.setState(3);
                        }
                    }
                    break;
                case 25:
                    if (main.InputController.holdedAnyOf(InputController.ACTION_UP)) {
                        this.position.z += this.R();
                    } else if (main.InputController.holdedAnyOf(InputController.ACTION_DOWN)) {
                        this.position.z -= this.R();
                    }
                    if (main.InputController.holdedAnyOf(InputController.ACTION_LEFT)) {
                        this.position.x -= this.Q();
                    } else if (main.InputController.holdedAnyOf(InputController.ACTION_RIGHT)) {
                        this.position.x += this.Q();
                    }
                    if ((target.stateFlags & 0x20000) != 0) {
                        this.setState(31);
                    } else if (409600 > i_5_) {
                        this.setState(29);
                    } else if (!this.isFacedToTarget(target)) {
                        this.setState(32);
                    } else if (!main.Souther.P()) {
                        this.setState(27);
                    } else if (!this.x()) {
                        this.setState(30);
                    }
                    break;
                case 27:
                    if (this.nextFrameToMove > 0) {
                        this.nextFrameToMove--;
                    } else {
                        this.nextFrameToMove = 30;
                        this.af ^= 0x1;
                    }
                    if ((this.currAnimFrame & 0x3) == 0) {
                        this.direction = this.getDirectionTowardObject(target);
                    }
                    do {
                        if (this.af == 0) {
                            this.position.x += 5461;
                            if (15 >= this.nextFrameToMove) {
                                this.position.z -= 5461;
                                break;
                            }
                        } else {
                            this.position.x -= 5461;
                            if (15 < this.nextFrameToMove) {
                                this.position.z -= 5461;
                                break;
                            }
                        }
                        this.position.z += 5461;
                    } while (false);
                    if (409600 > i_5_) {
                        this.setState(29);
                    } else if ((target.stateFlags & 0x20000) != 0) {
                        this.setState(31);
                    } else {
                        if (204800 > i_5_ && 40960 > i_9_) {
                            if (W[this.difficultyAi] / 2 < this.energy) {
                                this.setState(31);
                            } else {
                                this.setState(32);
                            }
                        }
                        if (this.currAnimFrame % 120 == 0) {
                            this.setState(28);
                        } else if (main.Souther.P()) {
                            this.setState(25);
                        } else if (!this.x()) {
                            this.setState(30);
                        }
                    }
                    break;
                case 29:
                    if ((this.Q & 0x3) == 0) {
                        this.direction = this.getDirectionTowardObject(target);
                    }
                    if (this.position.x < target.position.x) {
                        this.position.x -= this.Q();
                    } else {
                        this.position.x += this.Q();
                    }
                    if (81920 > i_9_) {
                        if (this.position.z < target.position.z) {
                            this.position.z -= this.R();
                        } else {
                            this.position.z += this.R();
                        }
                    }
                    if (286720 > i_5_ && 40960 > i_9_ && !target.u()) {
                        this.setState(31);
                    } else if (!this.x()) {
                        this.setState(30);
                    } else if (30 < this.currAnimFrame) {
                        this.setState(3);
                    }
                    break;
                case 28:
                    if (target.position.x < this.position.x) {
                        this.targetPosition.x = target.position.x + 204800;
                    } else {
                        this.targetPosition.x = target.position.x - 204800;
                    }
                    this.targetPosition.y = target.position.z - 40960;
                    this.j(0);
                    if (this.e(20480, 20480)) {
                        this.setState(31);
                    } else if (this.currAnimFrame - 60 > 0) {
                        this.setState(3);
                    }
                    break;
                case 31:
                    if (this.loopMovement) {
                        this.setState(29);
                    }
                    break;
                case 32:
                    if (5 < this.currAnimFrame) {
                        this.nextFrameToMove++;
                        this.w++;
                        if (this.nextFrameToMove - 27 < 0) {
                            this.d(30, 0, 0);
                            this.position.x += this.velocityX;
                            this.position.z += this.velocityZ;
                        }
                        if (this.nextFrameToMove - 35 > 0) {
                            this.setState(3);
                        }
                    }
                    break;
                case 30:
                    this.j(0);
                    if (286720 > i_5_ && 40960 > i_9_ && !target.u()) {
                        this.setState(31);
                    } else {
                        if (this.e(0, 0)) {
                            this.setState(3);
                        }
                        this.R = 3;
                    }
                    break;
            }
        }
        super.i();
        main.Souther var_ac_12_;
        if (this.state == 32 && (var_ac_12_ = this).nextFrameToMove % 2 == 0) {
            for (i = 3; i > 0; i--) {
                var_ac_12_.ai[i].set(var_ac_12_.ai[i - 1]);
            }
            var_ac_12_.ai[0].set(var_ac_12_.position);
        }
        if (main.GameManager.currentLevel == 2) {
            if (this.ag == 0) {
                main.GameManager.e(3);
                this.ag++;
            } else if (this.ag == 1) {
                if (this.energy <= 13000) {
                    main.GameManager.e(2);
                    this.ag++;
                }
            } else if (this.ag == 2 && this.energy <= 3000) {
                main.GameManager.e(5);
                this.ag++;
            }
        }
        this.h();
    }

    public final void checkHammerSmash() {
        main.Souther var_ac_13_ = this;
        main.Souther var_ac_14_ = this;
        int i = 2 == main.GameManager.currentDifficulty ? 1 : 0;
        int i_15_;
        while_0_:
        do {
            int i_16_;
            switch (var_ac_14_.state) {
                default:
                    i_15_ = 1000;
                    break while_0_;
                case 31:
                    i_16_ = aj[i][var_ac_14_.difficultyAi];
                    break;
                case 32:
                    i_16_ = ak[i][var_ac_14_.difficultyAi];
            }
            i_15_ = i_16_ + (2 == main.GameManager.currentDifficulty ? 100 : 0);
        } while (false);
        var_ac_13_.checkAttackObjects(i_15_, 0);
    }

    public final void onAttackContact(main.AbstractObject var_af, int i, int i_17_,
            int i_18_, int i_19_) {
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
        if (this.state - 32 == 0 && this.currAnimFrame - 5 > 0) {
            for (int i = 0; i < 4; i++) {
                main.ar.addElementToVector1(ah[i]);
            }
        }
    }

    public final void clearData() {
        this.clearAbstractData();
        for (int i = 0; i < 4; i++) {
            if (ah[i] != null) {
                ah[i] = null;
            }
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
            case 7:
            case 25:
            case 27:
            case 28:
            case 29:
            case 31:
                return true;
        }
        return false;
    }

    protected final void h() {
        super.h();
        for (int i = 0; i < 4; i++) {
            int i_21_ = (this.ai[i].x - main.GameManager.screenLockX
                    + main.GameManager.halfScreenWidth12Left);
            int i_22_ = (this.ai[i].z - this.ai[i].y - main.GameManager.screenLockY
                    + main.GameManager.halfScreenHeight12Left);
            int i_23_ = this.velocityZ >= 0 ? -i - 1 : i + 1;
            ah[i].a(this.s() + i_23_, i_21_, i_22_, 2, 4,
                    this.direction == 0 ? 0 : 65536);
        }
    }

    private void j(int i) {
        main.AbstractObject var_af = getPlayerTarget();
        if (this.nextFrameToMove > 0) {
            this.nextFrameToMove--;
        }
        this.Q++;
        if ((this.Q & 0x3) == 0) {
            this.direction = this.getDirectionTowardObject(var_af);
        }
        boolean bool = false;
        boolean bool_24_ = false;
        if ((i = this.targetPosition.x - this.position.x) > this.velocityX) {
            i = this.velocityX;
        } else if (i < -this.velocityX) {
            i = -this.velocityX;
        }
        int i_25_;
        if ((i_25_ = this.targetPosition.y - this.position.z) > this.velocityZ) {
            i_25_ = this.velocityZ;
        } else if (i_25_ < -this.velocityZ) {
            i_25_ = -this.velocityZ;
        }
        this.position.x += i;
        this.position.z += i_25_;
    }

    public final void setState(int i) {
        int i_26_ = main.GameManager.h + 655360;
        main.AbstractObject var_af = getPlayerTarget();
        int i_27_ = 0;
        int i_28_ = 0;
        if (var_af != null) {
            this.getDistanceX(var_af);
            i_27_ = this.getDistanceZ(var_af);
            i_28_ = this.getDirectionTowardObject(var_af);
        }
        this.w();
        this.state = i;
        this.soundToPlayOnContact = 4;
        while_1_:
        do {
            switch (i) {
                case 23:
                    this.c(4);
                    return;
                case 3:
                case 4:
                    this.c(0);
                    return;
                case 5:
                    this.d(11);
                    return;
                case 14:
                    this.n = 32;
                    this.d(10);
                    return;
                case 12:
                case 13:
                    this.d(3);
                    return;
                case 15:
                    switch (this.y) {
                        default:
                            this.direction = this.C;
                            this.d(5);
                            break;
                        case 2:
                            this.F();
                            this.c(6);
                            return;
                    }
                    return;
                case 19:
                    this.d(9);
                    return;
                case 16:
                    this.d(13);
                    return;
                case 17:
                    this.y = 9;
                    this.d(7);
                    return;
                case 18:
                    this.E();
                    this.c(8);
                    return;
                case 7:
                    main.AbstractObject.i(this);
                    break;
                case 24:
                    this.velocityX = Q();
                    this.velocityZ = R();
                    this.targetPosition.set(var_af.position.x, var_af.position.z);
                    break;
                case 25:
                    this.velocityX = 1;
                    this.nextFrameToMove = 15 + main.GameManager.getRandomNumber(15);
                    break;
                case 27:
                    this.nextFrameToMove = 30;
                    this.targetPosition.x = this.position.x - 163840;
                    this.targetPosition.y = this.position.z;
                    break;
                case 29:
                    this.c(0);
                    return;
                case 28:
                    this.velocityX = Q();
                    this.velocityZ = R();
                    break;
                case 31:
                    this.direction = i_28_;
                    this.x = 2;
                    this.c(2);
                    return;
                case 32:
                    this.nextFrameToMove = 0;
                    this.targetPosition.x = var_af.position.x;
                    this.velocityX = Q();
                    this.direction = 0;
                    if (i_28_ != 0) {
                        main.Souther var_ac_29_ = this;
                        var_ac_29_.velocityX = -var_ac_29_.velocityX;
                        this.direction = 1;
                    }
                    this.velocityZ = 0;
                    if (40960 < i_27_) {
                        i = (int) (((long) java.lang.Math
                                .abs(var_af.position.x - this.position.x)
                                << 12)
                                / (long) Q());
                        this.velocityZ = (int) ((long) (var_af.position.z - this.position.z) << 12) / i;
                        if (R() < java.lang.Math.abs(this.velocityZ)) {
                            this.velocityZ = R() * (this.velocityZ < 0 ? -1 : 1);
                        }
                    }
                    for (i = 0; i < 4; i++) {
                        this.ai[i].set(this.position);
                    }
                    this.x = 2;
                    this.c(2);
                    return;
                case 30:
                    this.velocityX = Q();
                    this.velocityZ = R();
                    this.targetPosition.x = i_26_;
                    if (this.position.z < var_af.position.z) {
                        this.targetPosition.y = main.Souther.z();
                    } else {
                        this.targetPosition.y = main.Souther.A();
                    }
                    break;
                default:
                    break while_1_;
            }
            this.c(0);
        } while (false);
    }

    private static boolean P() {
        boolean bool = false;
        if (main.InputController.holdedAnyOf(InputController.ACTION_UP)
                || main.InputController.holdedAnyOf(InputController.ACTION_DOWN)
                || main.InputController.holdedAnyOf(InputController.ACTION_LEFT)
                || main.InputController.holdedAnyOf(InputController.ACTION_RIGHT)) {
            bool = true;
        }
        return bool;
    }

    private int Q() {
        int i = 0;
        switch (this.state) {
            case 0:
                break;
            case 25:
            case 27:
            case 29:
                i = X[this.difficultyAi];
                break;
            case 28:
                i = Z[this.difficultyAi];
                break;
            case 32:
                i = ad[this.difficultyAi];
                break;
            case 30:
                i = ab[this.difficultyAi];
                break;
        }
        if (4096 != main.GameManager.enemyVelocityFactor) {
            i = (int) ((long) i * (long) main.GameManager.bossVelocityFactor >> 12);
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
            case 27:
            case 29:
                i = Y[this.difficultyAi];
                break;
            case 28:
                i = aa[this.difficultyAi];
                break;
            case 32:
                i = ae[this.difficultyAi];
                break;
            case 30:
                i = ac[this.difficultyAi];
                break;
        }
        if (4096 != main.GameManager.enemyVelocityFactor) {
            i = (int) ((long) i * (long) main.GameManager.bossVelocityFactor >> 12);
        }
        return i;
    }
}
