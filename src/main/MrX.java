/* n - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
package main;

public final class MrX extends main.AbstractObject {

    private static final int[] W = {30000};
    private static final int[] X = {20480, 8192, 8192};
    private static final int[] Y = {20480, 8192, 8192};
    private static final int[] Z = {28672, 6553, 6553};
    private static final int[] aa = {28672, 6553, 6553};
    private static final int[] ab = {90, 90};
    private static final int[][] ac = {{0, 30, 80}, {0, 30, 80}};
    private static final int[][] ad = {{75, 50}, {75, 50}};
    private static final int[][] ae;
    private int af;
    private boolean ag;
    private boolean ah;
    private int ai;
    private int aj;
    private main.eExtendsAr ak;
    private static main.ObjectArt al;
    private static final int[][] am;
    private static final int[][] an;

    static {
        (new int[][]{{33, 33, 33}, null})[1] = new int[]{33, 33, 33};
        (new int[][]{{33, 33, 33}, null})[1] = new int[]{33, 33, 33};
        (new int[][]{{33, 33, 33}, null})[1] = new int[]{33, 33, 33};
        ae = new int[][]{{35, 60}, {50, 60}};
        am = new int[][]{{2000, 2000, 2000}, {2600, 2600, 2600}};
        an = new int[][]{{1600, 1600, 1600}, {2000, 2000, 2000}};
    }

    public MrX(main.ObjectArt var_ad, int i, int i_0_, int i_1_,
            int i_2_, int i_3_, int i_4_) {
        super(17, 0, i_0_, i_1_, 0, 0, 99);
        this.stateFlags |= 0x88401;
        this.r = new main.eExtendsAr(0, var_ad, 28);
        this.ak = new main.eExtendsAr(0, var_ad, 28);
        j(10);
        al = var_ad;
        this.collisionBox
                = new main.CollisionBox(this.position,
                        new main.Point(131072,
                                131072,
                                131072));
        this.state = 23;
        this.nextFrameToMove = 0;
        this.Q = 0;
        this.D = false;
        this.af = 0;
        this.energy = W[this.difficultyAi];
        this.maxEnergy = this.energy;
        this.visualEnergy = main.GameManager.f(this.energy);
        this.s = 5;
        this.name = "MR_X";
    }

    public final void update() {
        super.update();
        main.AbstractObject target = getPlayerTarget();
        if (this.state != 1 && target == null && (23 > this.state || this.state > 26)
                && !this.j()) {
            this.setState(3);
        }
        this.D = false;
        if ((23 > this.state || this.state > 26) && this.state != 3 && this.q > 0) {
            this.setState(3);
        }
        if (target != null && target.energy <= 0 && 27 <= this.state && this.state <= 36
                && this.state != 34) {
            this.setState(34);
        }
        if (26 < this.state && this.state <= 36 && main.GameManager.u == 0) {
            Q();
        }
        if (5 <= this.state && this.state <= 22) {
            this.a(this.state, V, target);
            if (this.energy <= 0 || this.energy - this.damage <= 0) {
                if (this.state == 16 && this.currAnimFrame == 12) {
                    this.y = 2;
                    this.setState(15);
                    main.Point var_q = this.position;
                    var_q.x = var_q.x + 286720 * (this.direction == 0 ? 1 : -1);
                    main.Point var_q_5_ = this.g;
                    var_q_5_.x = -var_q_5_.x;
                }
                if (this.state == 18 && this.currAnimFrame == 10) {
                    this.applyDamage(this.damage);
                    main.GameManager.d();
                    main.MrX.playSound(5);
                    this.g(12);
                    this.y = 2;
                    this.setState(15);
                    main.Point var_q = this.g;
                    var_q.x = -var_q.x;
                }
                if (this.state == 19 && this.currAnimFrame == 13) {
                    this.y = 2;
                    this.setState(15);
                    this.direction ^= 0x1;
                    main.Point var_q = this.g;
                    var_q.x = -var_q.x;
                    main.Point var_q_6_ = this.position;
                    var_q_6_.x = var_q_6_.x + 184320 * (this.direction == 0 ? -1 : 1);
                }
            }
        } else {
            main.AbstractObject var_af_8_ = target;
            int i = this.state;
            main.AbstractObject var_af_9_ = var_af_8_;
            int i_11_ = main.GameManager.getRandomNumber(100);
            int i_12_ = 0;
            int i_13_ = 0;
            if (var_af_9_ != null) {
                i_12_ = this.getDistanceX(var_af_9_);
                i_13_ = this.getDistanceZ(var_af_9_);
            }
            switch (i) {
                case 0:
                    this.setState(3);
                /* fall through */
                case 23:
                    if ((this.stateFlags & INVINCIBILITY_FLAG) == 0) {
                        this.setState(24);
                    }
                    break;
                case 24:
                    // if no more punks, bring more or move to standup
                    if (main.GameManager.enemyObjects.size() == 0) {
                        this.nextFrameToMove++;
                        if (30 < this.nextFrameToMove) {
                            if (2 > this.af) {
                                this.setState(25);
                            } else {
                                this.setState(26);
                            }
                        }
                    }
                    break;
                case 25:
                    if (this.loopMovement) {
                        this.Q();
                        this.setState(24);
                    }
                    break;
                case 26:
                    if (this.loopMovement) {
                        this.w++;
                        this.u = this.r.a() - 1;
                        this.nextFrameToMove++;
                        if (30 < this.nextFrameToMove) {
                            this.setState(3);
                        }
                    }
                    break;
                case 3:
                    this.A = 0;
                    this.B = 0;
                    this.g.set(0, 0, 0);
                    if (this.q > 0) {
                        this.q--;
                    } else if (var_af_9_ != null) {
                        this.setState(28);
                    } else {
                        this.q = 10;
                    }
                    break;
                case 4:
                    this.A = 0;
                    this.B = 0;
                    break;
                case 27:
                    main.AbstractObject.moveToTarget(this, target);
                    if (this.e(0, 0)) {
                        this.setState(35);
                    }
                    this.R = 7;
                    break;
                case 28:
                    main.AbstractObject.moveToTarget(this, target);
                    if (this.ag && 696320 > i_12_ && 40960 > i_13_) {
                        this.setState(31);
                    } else if (this.ah && 286720 >= i_12_ && 40960 > i_13_) {
                        this.setState(36);
                    } else if (this.e(0, 0)) {
                        if (i_12_ < 409600) {
                            this.setState(28);
                        } else if (50 > i_11_) {
                            this.setState(30);
                        } else {
                            this.setState(27);
                        }
                    } else {
                        this.R = 7;
                    }
                    break;
                case 29:
                    if (10 < this.currAnimFrame) {
                        this.setState(30);
                    }
                    break;
                case 35:
                    if (this.currAnimFrame % 10 == 0) {
                        if (this.t - 6 == 0) {
                            this.setState(28);
                            break;
                        }
                        this.c(--this.t);
                    }
                    if (this.currAnimFrame % 3 == 0) {
                        int i_14_ = 0;
                        i = 0;
                        switch (this.t) {
                            case 6:
                                i_14_ = 26;
                                i = 0;
                                break;
                            case 7:
                                i_14_ = 24;
                                i = 1;
                                break;
                            case 8:
                                i_14_ = 25;
                                i = 2;
                                break;
                        }
                        main.GameManager.enemyObjects.addElement(new main.PickableObject(al, this, i_14_, 28,
                                i, this.P()));
                    }
                    break;
                case 30:
                    this.targetPosition.x = this.position.x;
                    this.targetPosition.y = var_af_9_.position.z;
                    main.AbstractObject.moveToTarget(this, target);
                    if (81920 > this.getDistanceZ(var_af_9_)) {
                        this.setState(31);
                    }
                    this.R = 7;
                    break;
                case 31:
                    this.targetPosition.x
                            = var_af_9_.position.x + 204800 * (this.getDirectionTowardObject(var_af_9_) == 0
                            ? -1 : 1);
                    this.targetPosition.y = var_af_9_.position.z;
                    main.AbstractObject.moveToTarget(this, target);
                    if (286720 >= i_12_ && 40960 > i_13_) {
                        this.setState(36);
                    } else if (this.nextFrameToMove == 0) {
                        if (7 > main.GameManager.getRandomNumber(11)) {
                            this.setState(36);
                        } else {
                            this.setState(3);
                        }
                    } else {
                        this.R = 7;
                    }
                    break;
                case 36:
                    if (this.loopMovement) {
                        if (50 > i_11_) {
                            this.setState(32);
                        } else {
                            this.setState(27);
                        }
                    }
                    break;
                case 32:
                    main.AbstractObject.moveToTarget(this, target);
                    if (this.e(0, 0)) {
                        if (this.k(0) > i_11_) {
                            this.setState(31);
                        } else {
                            this.setState(27);
                        }
                    }
                    this.R = 7;
                    break;
                case 33:
                    main.AbstractObject.moveToTarget(this, target);
                    if (this.e(0, 0) || 60 < this.currAnimFrame) {
                        this.setState(31);
                    }
                    break;
                case 34:
                    if (4 == this.currAnimFrame) {
                        main.MrX.playSound(54);
                    }
                    if (this.currAnimFrame - 60 > 0) {
                        this.setState(27);
                    }
                    break;
            }
        }
        if (this.energy <= 0 && this.state == 15) {
            if (--this.nextFrameToMove < 0) {
                this.nextFrameToMove = 2;
            }
            for (int i = 0; i < 2; i++) {
                main.GameManager.enemyObjects.addElement(new main.PickableObject(al, this, 17, 28, 3, 0));
            }
        }
        super.i();
        this.h();
    }

    private int P() {
        int i = 2 == main.GameManager.currentDifficulty ? 1 : 0;
        int i_15_;
        switch (this.state) {
            default:
                return 1000;
            case 36:
                i_15_ = am[i][this.difficultyAi];
                break;
            case 35:
                i_15_ = an[i][this.difficultyAi];
        }
        return i_15_ + (2 == main.GameManager.currentDifficulty ? 100 : 0);
    }

    public final void checkHammerSmash() {
        this.checkAttackObjects(P(), 0);
    }

    public final void onAttackContact(main.AbstractObject var_af, int i, int i_16_,
            int i_17_, int i_18_) {
        if (23 > this.state || this.state > 26) {
            int i_19_;
            if ((i_19_ = this.onBeingAttacked(var_af, i, i_16_, i_17_, i_18_)) > 0) {
                this.setState(i_19_);
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
        if (this.state == 35) {
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
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 33:
            case 34:
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
        int i_20_ = main.GameManager.h + 491520;
        int i_21_ = main.GameManager.h;
        int i_22_ = main.GameManager.h + 1310720;
        main.AbstractObject player = getPlayerTarget();
        int i_23_ = main.GameManager.getRandomNumber(100);
        this.state = i;
        this.w();
        switch (i) {
            case 23:
                this.c(0);
                break;
            case 24:
                this.nextFrameToMove = 0;
                this.c(0);
                break;
            case 25:
                this.c(1);
                break;
            case 26:
                this.nextFrameToMove = 0;
                this.c(2);
                break;
            case 34:
                this.c(3);
                break;
            case 3:
            case 4:
                this.s = 0;
                this.c(4);
                break;
            case 5:
                this.d(19);
                break;
            case 14:
                this.n = 32;
                this.d(16);
                break;
            case 12:
            case 13:
                this.d(14);
                break;
            case 15:
                this.nextFrameToMove = 12;
                switch (this.y) {
                    default:
                        this.direction = this.C;
                        this.d(12);
                        break;
                    case 2:
                        this.F();
                        j(10);
                        this.c(17);
                        break;
                }
                break;
            case 20:
                this.d(12);
                break;
            case 19:
                this.d(21);
                break;
            case 16:
                this.d(23);
                break;
            case 17:
                this.y = 9;
                this.d(20);
                break;
            case 18:
                this.E();
                this.c(18);
                break;
            case 27:
                this.velocityX = R();
                this.velocityZ = S();
                this.targetPosition.x = this.position.x;
                this.targetPosition.y = main.MrX.z();
                this.c(4);
                break;
            case 28:
                this.velocityX = R();
                this.velocityZ = S();
                this.ag = k(2) > i_23_;
                this.ah = k(3) > i_23_;
                this.targetPosition.x = this.position.x < i_20_ ? i_22_ - 204800 : i_21_ + 204800;
                this.targetPosition.y
                        = (main.MrX.C() < player.position.z
                        ? main.MrX.z() : main.MrX.A());
                this.c(4);
                break;
            case 30:
                this.velocityX = R();
                this.velocityZ = S();
                this.targetPosition.y = player.position.z;
                this.c(4);
                break;
            case 31:
                this.velocityX = R() << 1;
                this.velocityZ = S() << 1;
                this.targetPosition.x = player.position.x + 102400 * (this.getDirectionTowardObject(player) == 0 ? -1 : 1);
                this.targetPosition.y = player.position.z;
                this.nextFrameToMove = 16 + main.GameManager.getRandomNumber(25);
                this.c(4);
                break;
            case 36:
                this.x = 2;
                this.c(9);
                break;
            case 32:
                this.velocityX = R();
                this.velocityZ = S();
                this.targetPosition.x = this.direction == 0 ? i_21_ : i_22_;
                this.targetPosition.y = this.position.z;
                this.c(4);
                break;
            case 35:
                main.MrX.playSound(16);
                this.x = 1;
                j(10);
                this.c(8);
                break;
            case 33:
                this.velocityX = R();
                this.velocityZ = S();
                this.targetPosition.x = this.position.x + 204800 * (this.getDirectionTowardObject(player) == 0 ? -1 : 1);
                this.targetPosition.y = this.position.z;
                this.c(4);
        }
    }

    private void j(int i) {
        this.aj = 0;
        this.ai = 10;
        this.ak.a(this.aj);
        this.ak.setB(this.direction == 0 ? 0 : 65536);
        this.ak.b(this.ai);
    }

    private void Q() {
        int i = main.GameManager.h + 1515520;
        int i_24_ = main.GameManager.h - 204800;
        main.GameManager.spawnObject(41, i, main.MrX.C(), 0, 1, 0,
                0);
        main.GameManager.spawnObject(41, i_24_, main.MrX.C(), 0, 0,
                0, 0);
        this.af++;
    }

    private int R() {
        int i = 0;
        switch (this.state) {
            case 0:
                break;
            case 27:
            case 28:
            case 31:
            case 32:
            case 33:
                i = X[this.difficultyAi];
                break;
            case 30:
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
            case 27:
            case 28:
            case 31:
            case 32:
            case 33:
                i = Y[this.difficultyAi];
                break;
            case 30:
                i = aa[this.difficultyAi];
                break;
        }
        if (4096 != main.GameManager.enemyVelocityFactor) {
            i = (int) ((long) i * (long) main.GameManager.bossVelocityFactor >> 12);
        }
        return i;
    }

    private int k(int i) {
        int i_25_ = 0;
        int i_26_ = 2 == main.GameManager.currentDifficulty ? 1 : 0;
        int i_27_ = W[this.difficultyAi] / 100 * 35 < this.energy ? 0 : 1;
        switch (this.state) {
            case 0:
                break;
            case 28:
                switch (i) {
                    case 0:
                        i_25_ = ad[i_26_][i_27_];
                        break;
                    case 1:
                        i_25_ = ad[i_26_][i_27_] + ae[i_26_][i_27_];
                        break;
                    case 2:
                        i_25_ = ac[i_26_][(W[this.difficultyAi] / 100 * 55 < this.energy ? 0
                                : W[this.difficultyAi] / 100 * 35 < this.energy ? 1 : 2)];
                        break;
                    case 3:
                        i_25_ = ab[i_26_];
                }
                break;
            case 32:
                i_25_ = ae[i_26_][i_27_];
                break;
        }
        return i_25_;
    }
}
