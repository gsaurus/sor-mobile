/* at - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
package main;

public final class Adam extends main.AbstractObject {

    //private static final int[] adamEnegyByDifficulty = {5000, 5000, 5000};
    private static final int[] velXByDifficulty = {20480, 8192, 8192};
    private static final int[] velZByDifficulty = {20480, 8192, 8192};
    private static final int[] fastVelXByDiff = {40960, 11468, 11468};
    private static final int[] fastVelZByDiff = {40960, 9011, 9011};
    private static final int[] teamAttackVelXByDiff = {40960, 11468, 11468};
    private main.Point previousPosition;
    protected main.AbstractObject myTarget;
    private int comboCounter;
    private boolean ae;
    private int attackMoveScore;
    private final int playerId;

    public Adam(main.ObjectArt var_ad, int i, int posX, int posZ, int PosY, int i_3_, int i_4_, int playerId) {
        super(3, 0, posX, posZ, PosY, i_3_, i_4_);
        previousPosition = new main.Point();
        this.playerId = playerId;
        this.stateFlags |= 0x8101;
        this.r = new main.eExtendsAr(0, var_ad, 14);
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
        this.energy = 10000; //adamEnegyByDifficulty[this.difficultyAi];
        this.maxEnergy = this.energy;
        this.visualEnergy = main.GameManager.f(this.energy);
        this.name = "ADAM";
        this.attackMoveScore = 0;
    }

    public final void update() {
        super.update();
        // Custom code: Handle pick up items
        if (state == 6) {
            dropWeapon();
            this.setState(3);
        }else if (state == 0 && (this.stateFlags & INVINCIBILITY_FLAG) != 0) {
            this.stateFlags &= ~INVINCIBILITY_FLAG;
            this.setState(1);
        }else if (state == 1){
            if (this.checkAndUpdateIfReachedTargetPosition()) {
                this.state = -1;
                this.setState(3);
            }
        }
        
        main.AbstractObject player = main.GameManager.getPlayer1();
        if (player == null || !player.isAlive() || player == this || player.objectType == 3)
            player = main.GameManager.getPlayer2();
        int dxToPl1 = 0;
        if (player == null || !player.isAlive() || player == this || player.objectType == 3) {
            dxToPl1 = mustMoveForward() ? 9000000 : 0;
        } else {
            dxToPl1 = this.getDistanceX(player);
            this.getDistanceZ(player); // err, this is not being used, guess it used z distance too...
        }
        this.D = false;
        int dx = 0;
        int dz = 0;
        if (this.state == 27 && this.myTarget != null) {
            dx = this.getDistanceX(this.myTarget);
            dz = this.getDistanceZ(this.myTarget);
            if (this.myTarget.state == 14) {
                this.myTarget = null;
                this.setState(3);
            }
        }
        if (this.state != 23 && this.state != 3 && this.q > 0) {
            this.setState(3);
        }
        if (5 <= this.state && this.state <= 22 && this.state != 17) {
            this.a(this.state, V, player);
        } else {
            switch (this.state) {
                case 2:
                    if (this.checkAndUpdateIfReachedTargetPosition()) {
                        this.state = -1;
                        this.setState(3);
                        //this.markToDie(); // original code mark it to die
                    }
                    break;
                case 23:
                    this.p = 99;
                    this.position.x += this.velocityX;
                    this.position.z += this.velocityZ;
                    if (this.position.x == this.K.x && this.position.z == this.K.z) {
                        this.velocityZ = -this.velocityZ;
                    }
                    if (!this.isInsideScreen(0, 0)) {
                        this.markToDie();
                    }
                    break;
                case 0:
                    this.setState(3);
                /* fall through */
                case 3:
                    this.A = 0;
                    this.B = 0;
                    this.g.set(0, 0, this.g.y);
                    if (this.q > 0) {
                        this.q--;
                    } else if (player != null) {
                        this.setState((GameManager.getPlayer3() == this && main.GameManager.adamExitScene) ? 23 : 24);
                    } else {
                        this.q = 10;
                    }
                    break;
                case 4:
                    this.A = 0;
                    this.B = 0;
                    break;
                case 17:
                    if (this.loopMovement) {
                        this.setState(33);
                    }
                    break;
                case 24:
                    // move away only if it's the 3rd auxiliar character
                    if (GameManager.getPlayer3() == this && main.GameManager.adamExitScene) {
                        this.setState(23);
                    } else {
                        if (this.currAnimFrame % 16 == 0) {
                            this.c(2);
                        }
                        if (this.loopMovement) {
                            this.c(1);
                        }
                        if (this.nextFrameToMove < this.currAnimFrame) {
                            this.myTarget = main.Adam.getTarget(this, 1536, Integer.MAX_VALUE, Integer.MAX_VALUE);//655360, main.Adam.B());
                            if (this.myTarget != null) {
                                this.setState(27);
                                break;
                            }
                        }
                        if (409600 < dxToPl1) {
                            this.setState(25);
                        }
                    }
                    break;
                case 25:
                    // move away only if it's the 3rd auxiliar character
                    if (GameManager.getPlayer3() == this && main.GameManager.adamExitScene) {
                        this.setState(23);
                    } else {
                        followTarget();
                        if (this.position.x == this.targetPosition.x && this.position.z == this.targetPosition.y
                                || (player != null && 204800 > dxToPl1)
                                || (player == null && !mustMoveForward())
                        ) {
                            this.setState(3);
                        }
                    }
                    break;
                case 27:
                    // move away only if it's the 3rd auxiliar character
                    if (GameManager.getPlayer3() == this && main.GameManager.adamExitScene) {
                        this.setState(23);
                    } else {
                        this.targetPosition.x = this.myTarget.position.x + 204800 * (this.getDirectionTowardObject(this.myTarget) == 0
                                ? -1 : 1);
                        this.targetPosition.y = this.myTarget.position.z;
                        followTarget();
                        if (163840 < dx && 204800 >= dx && 40960 > dz) {
                            this.setState(29);
                        }
                    }
                    break;
                case 28:
                    if (5 < this.currAnimFrame) {
                        if (this.ae) {
                            this.setState(30);
                        } else {
                            this.setState(3);
                        }
                    }
                    break;
                case 29:
                    if (this.loopMovement) {
                        this.setState(28);
                    }
                    break;
                case 30:
                case 31:
                case 32:
                    if (this.loopMovement) {
                        if (this.ae) {
                            this.setState(4 > this.comboCounter ? ++this.state : 3);
                        } else {
                            this.setState(3);
                        }
                    }
                    break;
                case 33:
                    if (16 > this.currAnimFrame) {
                        // team throw
                        this.position.x += this.velocityX;
                    }
                    if (this.loopMovement) {
                        this.setState(3);
                    }
                    break;
                case 34:
                    if (5 < this.currAnimFrame) {
                        this.grabbedObject.onAttackContact(this, this.A, 2, this.direction, 0);
                        this.grabbedObject = null;
                        this.setState(33);
                    }
                    break;
            }
        }
        super.i();
        this.h();
    }

    public final void checkHammerSmash() {
        int i = 81920;
        if (this.o == 0) {
            this.h();
            for (int i_8_ = 0; i_8_ < main.GameManager.collidableObjects.size();
                    i_8_++) {
                main.AbstractObject var_af;
                if (((var_af = ((main.AbstractObject) main.GameManager.collidableObjects.elementAt(i_8_))).stateFlags
                        & 0xe00) != 0
                        && this.a(var_af, i)) {
                    
                    main.Adam.addPlayerScore(playerId, this.attackMoveScore);
                    this.ae = true;
                    this.e(0);
                    main.AbstractObject var_af_9_ = var_af;
                    int i_11_ = this.A;
                    int i_12_ = this.x;
                    int i_13_ = this.direction;
                    i_8_ = 0;
                    switch (this.state) {
                        case 29:
                            i_8_ = 500;
                            break;
                        case 30:
                            i_8_ = 1000;
                            break;
                        case 31:
                            i_8_ = 1500;
                            break;
                        case 32:
                            i_8_ = 2000;
                            break;
                        case 33:
                            i_8_ = 2000;
                            break;
                    }
                    var_af_9_.onAttackContact(this, i_11_, i_12_, i_13_, i_8_);
                    if (this.t == 3 && var_af.position.y == 0) {
                        var_af.g.y = 32768;
                        var_af.position.y = 1;
                    }
                    var_af.p = 3;
                    main.Adam.playSound(this.soundToPlayOnContact);
                    var_af.c(0, 0, 40);
                    if (this.w == 0) {
                        this.w = 2;
                    }
                    break;
                }
            }
        }
    }

    public final void onAttackContact(main.AbstractObject var_af, int i, int i_15_,
            int i_16_, int i_17_) {
        int newState;
        if ((newState = this.onBeingAttacked(var_af, i, i_15_, i_16_, i_17_)) > 0) {
            this.setState(newState);
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
        this.myTarget = null;
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
            case 25:
            case 27:
                return true;
        }
        return false;
    }
    
    private static boolean isTargetedByOtherAdam(AbstractObject me, AbstractObject enemy) {
        AbstractObject obj;
        for (int i = 0 ; i < GameManager.players.length ; ++i) {
            obj = (GameManager.players[i]);
            if (obj != null && obj != me){
                if (obj.objectType == 3 && ((Adam)obj).myTarget == enemy){
                    return true;
                }
            }
        }
        return false;
    }

    public static main.AbstractObject getTarget(main.AbstractObject refObj, int int1, int maxDistX, int maxDistZ) {
        // Find closest enemy most of the time
        int randomIndex = -1;
        if (GameManager.getRandomNumber(100) < 40){
            randomIndex = GameManager.getRandomNumber(main.GameManager.collidableObjects.size());
        }
        int minDist = Integer.MAX_VALUE;
        main.AbstractObject finalObj = null;
        if (refObj.position.y != 0) {
            return null;
        }
        for (int i = 0; i < main.GameManager.collidableObjects.size(); i++) {
            main.AbstractObject obj;
            int dis;
            if (((obj = ((main.AbstractObject) main.GameManager.collidableObjects.elementAt(i))).stateFlags
                    & ~0x7fffffff) == 0
                    && obj.position.y == 0 && (obj.stateFlags & 0x8000) != 0
                    && (obj.stateFlags & int1) != 0
                    && (obj.stateFlags & 134217728) == 0
                    && (obj.objectType != 17 || (obj.state < 23 || obj.state > 26))
                    && !obj.u()
                    && (finalObj == null || !isTargetedByOtherAdam(refObj, obj))
             ){
                if (i == randomIndex) return obj; // sometimes random
                
                if ((dis = refObj.getDistanceX(obj)) < minDist && 16384 < dis
                    && dis <= maxDistX && refObj.getDistanceZ(obj) < maxDistZ
                ){
                    finalObj = obj;
                    minDist = dis;
                }
            }
        }
        return finalObj;
    }

    
    
    private boolean mustMoveForward()
    {        
        if (GameManager.currentLevel == 6) return false; // don't move forward on elevator stage 
        return this.getNumEnemies() == 0;
        //return this.getNumEnemies(655360, Integer.MAX_VALUE) == 0;
    }
    
    private void followTarget() {
        if (!main.GameManager._a0()) {
            main.AbstractObject pl1 = main.GameManager.getPlayer1();
            if (pl1 == null || pl1 == this || pl1.objectType == 3)
                pl1 = main.GameManager.getPlayer2();
            if (this.nextFrameToMove > 0) {
                this.nextFrameToMove--;
            }
            this.Q++;
//            if (this.state == 27) {
//                if (this.Q % 3 == 0) {
//                    this.direction = this.position.x < this.targetPosition.x ? 0 : 1;
//                }
//            } else if ((this.Q & 0x3) == 0) {
//                if (pl1 == null || pl1 == this || !pl1.isAlive() || pl1.objectType == 3) {
//                    if (mustMoveForward()) {
//                        this.direction = GameManager.currentLevel == 7 ? 1 : 0;
//                    }
//                }else {
//                    this.direction = this.getDirectionTowardObject(pl1);
//                }
//            }
            int dx;
            if ((dx = this.targetPosition.x - this.position.x) > this.velocityX) {
                dx = this.velocityX;
            } else if (dx < -this.velocityX) {
                dx = -this.velocityX;
            }
            int dz;
            if ((dz = this.targetPosition.y - this.position.z) > this.velocityZ) {
                dz = this.velocityZ;
            } else if (dz < -this.velocityZ) {
                dz = -this.velocityZ;
            }
            if (previousPosition.x == position.x && previousPosition.y == position.y && previousPosition.z == position.z) {
                // we're stuck
                if (GameManager.getRandomNumber(10) == 4) {
                    // try to move away from it
                    this.targetPosition.y += 50000 - GameManager.getRandomNumber(100000);
                }else if (GameManager.getRandomNumber(10) == 4) {
                    // try to destroy it
                    this.setState(30);
                }
            }
            previousPosition.x = position.x;
            previousPosition.y = position.y;
            previousPosition.z = position.z;
            if (dx != 0) {
                this.direction = dx < 0 ? 1 : 0;
            }
            this.position.x += dx;
            this.position.z += dz;
        }
    }

    public final void setState(int newState) {
        main.AbstractObject otherPlayer = main.GameManager.getPlayer1();
        if (otherPlayer == null || !otherPlayer.isAlive() || otherPlayer == this || otherPlayer.objectType == 3)
            otherPlayer = GameManager.getPlayer2();
        if (otherPlayer == null || !otherPlayer.isAlive() || otherPlayer == this || otherPlayer.objectType == 3)
            otherPlayer = null;
        this.state = newState;
        this.attackMoveScore = 20;
        this.w();
        switch (newState) {
            case 1:
                this.setupPlayerInitialPosition();
                this.c(0);
                break;
            case 2:
                this.c(0);
                break;
            case 23:
                this.velocityX = velXByDifficulty[this.difficultyAi] * (main.GameManager.currentLevel == 7 ? 1 : -1);
                this.direction = this.velocityX < 0 ? 1 : 0;
                this.velocityZ = velZByDifficulty[this.difficultyAi];
                this.c(0);
                main.Adam.playSound(43);
                break;
            case 3:
            case 4:
                this.c(1);
                break;
            case 5:
                this.g.set(0, 0, this.g.y);
                this.c(12);
                break;
            case 14:
                this.g.set(0, 0, this.g.y);
                this.n = 32;
                this.c(10);
                break;
            case 12:
            case 13:
                this.g.set(0, 0, this.g.y);
                this.c(5);
                break;
            case 15:
                this.g.set(0, 0, this.g.y);
                switch (this.y) {
                    default:
                        this.direction = this.C;
                        this.c(8);
                        break;
                    case 2:
                        this.o = 12;
                        this.p = 12;
                        this.direction = this.C;
                        this.g.x = this.direction == 0 ? -16384 : 16384;
                        this.c(9);
                        break;
                }
                break;
            case 17:
                this.direction ^= 0x1;
                this.c(6);
                break;
            case 7:
                main.Adam.i(this);
                this.c(0);
                break;
            case 8:
                main.Adam.h(this);
                this.c(0);
                break;
            case 24:
                this.x = 1;
                this.nextFrameToMove = main.GameManager.getRandomNumber(12);
                this.c(1);
                break;
            case 25:
                this.velocityX = velXByDifficulty[this.difficultyAi];
                this.velocityZ = velZByDifficulty[this.difficultyAi];
                if (otherPlayer != null && otherPlayer.isAlive()) {
                    this.targetPosition.x = otherPlayer.position.x + 204800 * (this.getDirectionTowardObject(otherPlayer) == 0 ? -1 : 1);
                    this.targetPosition.y = otherPlayer.position.z + (50 - main.GameManager.getRandomNumber(100) << 12);
                }else{
                    this.targetPosition.x = this.position.x + (GameManager.currentLevel == 7 ? -9000000 : 9000000);
                    if (GameManager.getRandomNumber(50) == 0){
                        this.targetPosition.y = 200000 + GameManager.getRandomNumber(800000);
                    }
                }
                this.D();
                this.c(0);
                break;
            case 27:
                this.velocityX = velXByDifficulty[this.difficultyAi];
                this.velocityZ = velZByDifficulty[this.difficultyAi];
                this.c(0);
                break;
            case 26:
                this.velocityX = fastVelXByDiff[this.difficultyAi];
                this.velocityZ = fastVelZByDiff[this.difficultyAi];
                this.c(0);
                break;
            case 28:
                // after first punch
                this.c(1);
                break;
            case 29:
                this.ae = false;
                if (this.myTarget != null) {
                    this.direction = this.getDirectionTowardObject(this.myTarget);
                }
                this.comboCounter = 0;
            /* fall through */
            case 30: // attack while walking
                this.attackMoveScore = 20;
                this.ae = false;
                this.comboCounter++;
                this.x = 1;
                this.c(2);
                break;
            case 31:
                // 3rd punch
                this.attackMoveScore = 30;
                this.ae = false;
                //main.Adam.playSound(43);
                this.comboCounter++;
                this.x = 1;
                this.c(3);
                break;
            case 32:
                // round kick
                this.attackMoveScore = 50;
                this.ae = false;
                //main.Adam.playSound(43);
                this.comboCounter++;
                this.x = 2;
                this.c(4);
                break;
            case 33:
                // team attack
                this.attackMoveScore = 50;
                main.Adam.playSound(43);
                this.x = 2;
                this.velocityX = teamAttackVelXByDiff[this.difficultyAi] * (this.direction == 0 ? 1 : -1);
                this.c(7);
                break;
            case 34:
                if (this.grabbedObject == null) {
                    this.setState(3);
                    break;
                }
                if (otherPlayer != null)
                    this.direction = this.getDirectionTowardObject(otherPlayer);
                else this.direction = GameManager.currentLevel == 7 ? 0 : 1;
                this.a(true, 106496);
                this.c(5);
        }
    }
}
