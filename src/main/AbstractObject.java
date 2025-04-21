/* af - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
package main;

public abstract class AbstractObject {
    
    public static final int INVINCIBILITY_FLAG = 0x8000000;

    protected int vaultCount;
    
    private static final int[] objectBaseBeatingScore = {100, 150, 200, 150, 200, 300, 1000, 1500, 2000, 2500, 2500, 3000, 10000, 5000};
    protected int objectType;
    protected int difficultyAi;
    protected int stateFlags;
    private int beatingScore;
    protected int state;
    protected int currAnimFrame;
    public main.Point position;
    protected main.Point g;
    protected main.Point h;
    protected int direction;
    protected int j;
    protected int maxEnergy;
    protected int energy;
    protected int visualEnergy;
    protected int n;
    protected int o;
    protected int p;
    protected int q;
    protected main.eExtendsAr r;
    protected int s;
    protected int t;
    protected int u;
    protected boolean loopMovement;
    protected int w;
    protected int x;
    protected int y;
    protected int damage;
    protected AbstractObject attacker;
    protected int A;
    protected int B;
    protected int C;
    protected boolean D;
    protected main.CollisionBox collisionBox;
    protected main.AbstractObject grabbedObject;
    protected boolean G;
    protected int comboCounter;
    private int Y;
    protected main.Point2D I;
    protected main.Point2D targetPosition;
    protected main.Point K;
    protected int velocityX;
    protected int velocityZ;
    protected int N;
    protected int O;
    private int Z;
    protected int nextFrameToMove;
    protected int Q;
    protected int R;
    public java.lang.String name;
    protected int T;
    protected int soundToPlayOnContact;
    public static final int[] V = {352256, 32768, 319488};
    
    protected AbstractObject lastTarget;
    protected int countToNextTarget;

    protected static void playSound(int i) {
        main.AudioController.playSound(i, 1); // second argument is unused
    }
    
    
    public AbstractObject getPlayerTarget()
    {
        // check single target
        if (GameManager.players[1] == null && GameManager.players[2] == null)
            lastTarget = GameManager.players[0];
        else if (GameManager.players[0] == null && GameManager.players[2] == null)
            lastTarget = GameManager.players[1];
        else if (GameManager.players[0] == null && GameManager.players[1] == null)
            lastTarget = GameManager.players[2];
        else{
            // multiple targets
            if (countToNextTarget > 0 && lastTarget != null && lastTarget.energy > 0){
                return lastTarget;
            }
            countToNextTarget = 10 + GameManager.getRandomNumber(140);
            if (GameManager.getRandomNumber(100) > 40) {
                // target closest player most of the time
                int closestDist = Integer.MAX_VALUE;
                int closestID = 0;
                int dist;
                AbstractObject obj;
                for (int i = 0 ; i < GameManager.players.length ; ++i){
                    obj = GameManager.players[i];
                    if (obj != null){
                        dist = this.getDistanceX(obj);
                        if (dist < closestDist) {
                            closestDist = dist;
                            closestID = i;
                        }
                    }
                }
                lastTarget = GameManager.players[closestID];
            }else {
            
                if (GameManager.players[0] == null)
                    lastTarget = GameManager.players[1+GameManager.getRandomNumber(2)];
                else if (GameManager.players[1] == null)
                    lastTarget = GameManager.players[GameManager.getRandomNumber(2)*2];
                else if (GameManager.players[2] == null)
                    lastTarget =  GameManager.players[GameManager.getRandomNumber(2)];
                else lastTarget =  GameManager.players[GameManager.getRandomNumber(3)];
            }
        }
        return lastTarget;
    }

    public final boolean j() {
        if (this.state > 0 && this.state < 23) {
            return true;
        }
        return false;
    }

    public void update(){
        --countToNextTarget;
    }

    public abstract void checkHammerSmash();

    public abstract void onAttackContact(main.AbstractObject var_af_0_, int i, int i_1_,
            int i_2_, int i_3_);

    public abstract boolean d();

    public abstract void e();

    public abstract void clearData();

    public abstract void b();

    public abstract void setState(int i);

    public AbstractObject(int objType, int aiType, int posX, int posZ, int posY, int direction, int i_9_) {
        //aiType = 2; // Debug 
        vaultCount = 0;
        this.objectType = objType;
        this.difficultyAi = aiType;
        this.stateFlags = 1;
        this.state = 0;
        this.position = new main.Point(posX, posZ, posY);
        this.g = new main.Point(0, 0, 0);
        this.h = new main.Point(0, 0, 0);
        this.direction = direction;
        this.j = i_9_;
        this.energy = 10;
        this.maxEnergy = 10;
        this.n = 0;
        this.o = 0;
        this.p = 0;
        this.q = 0;
        this.r = null;
        this.s = 0;
        this.u = 0;
        this.loopMovement = false;
        this.t = 0;
        this.w = 0;
        this.x = 0;
        this.y = 0;
        this.damage = 0;
        this.A = 0;
        this.C = 0;
        this.B = 0;
        this.D = false;
        this.collisionBox = null;
        this.grabbedObject = null;
        this.G = false;
        this.comboCounter = 0;
        this.I = new main.Point2D();
        this.targetPosition = new main.Point2D(posX, posZ);
        this.K = new main.Point(posX, posZ, posY);
        this.N = 0;
        this.O = 0;
        this.Z = 0;
        this.nextFrameToMove = 0;
        this.Q = 0;
        this.T = 1000;
        this.soundToPlayOnContact = 57;
        if (this.objectType >= 4 && this.objectType <= 17) {
            this.beatingScore = objectBaseBeatingScore[this.objectType - 4];
            if (this.objectType <= 9) {
                if (this.difficultyAi == 1) {
                    this.beatingScore += 100;
                } else if (this.difficultyAi == 2) {
                    this.beatingScore += 200;
                }
                this.beatingScore += 150*main.GameManager.currentDifficulty;
                //if (main.GameManager.currentDifficulty == 2) {
                //    this.beatingScore += 300;
                //}
            }
        }
    }

    public static void k() {
        main.GameManager.a();
    }

    public static void l() {
        main.GameManager.b();
    }

    public final void setupPlayerInitialPosition() {
        main.GameManager.k = 2;
        this.p = 16;
        boolean isPl2 = GameManager.getPlayer2() == this;
        int extraPosZ = isPl2 ? -89200 : 0;
        int extraPosX = isPl2 ? 89200 : 0;
        if (main.GameManager.currentLevel != 7) {
            this.position.x = main.GameManager.screenLockX - main.GameManager.halfScreenWidth12Left - 196608;
            this.position.z = 819200 + extraPosZ;
            this.direction = 0;
            this.targetPosition.set(this.position.x + 409600 + extraPosX, this.position.z);
        } else {
            this.position.x = main.GameManager.screenLockX + main.GameManager.halfScreenWidth12Left + 196608;
            this.position.z = 819200 + extraPosZ;
            this.direction = 1;
            this.targetPosition.set(this.position.x - 409600 - extraPosX, this.position.z);
        }
        this.position.y = 0;
    }

    public final void setTargetPosition(int px, int py) {
        this.targetPosition.set(px, py);
        this.setState(2);
    }

    public final boolean checkAndUpdateIfReachedTargetPosition() {
        main.GameManager.k = 2;
        this.p = 16;
        int i;
        if (java.lang.Math.abs(i = this.targetPosition.x - this.position.x) <= 10240) {
            this.position.x = this.targetPosition.x;
        } else if (this.targetPosition.x > this.position.x) {
            this.position.x += 10240;
            this.direction = 0;
        } else {
            this.position.x -= 10240;
            this.direction = 1;
        }
        if (java.lang.Math.abs(i = this.targetPosition.y - this.position.z) <= 7372) {
            this.position.z = this.targetPosition.y;
        } else if (this.targetPosition.y > this.position.z) {
            this.position.z += 7372;
        } else {
            this.position.z += -7372;
        }
        if (this.position.x == this.targetPosition.x && this.position.z == this.targetPosition.y) {
            return true;
        }
        return false;
    }

    protected final void a(main.eExtendsAr var_e, int i, int i_12_) {
        int newX;
        int newY;
        if ((this.stateFlags & 0x4) != 0) {
            newX = this.position.x;
            newY = this.position.z - this.position.y;
        } else {
            newX = (this.position.x - main.GameManager.screenLockX + main.GameManager.halfScreenWidth12Left);
            newY = (this.position.z - this.position.y - main.GameManager.screenLockY + main.GameManager.halfScreenHeight12Left);
        }
        var_e.a(this.s(), newX, newY, i, i_12_, this.direction == 0 ? 0 : 65536);
    }

    protected void h() {
        this.a(this.r, this.t, this.u);
    }

    public final void o() {
        if (this.position.y == 0) {
            this.playDyingSound();
            if (this.state != 15 && this.state != 14 && this.state != 5) {
                this.q = 10;
            }
            this.position.y = -1;
            if (this.N > 0) {
                this.g.y = -16384;
            }
        }
    }

    protected void i() {
        int i = main.GameManager.f(this.energy);
        if (this.visualEnergy > i) {
            this.visualEnergy--;
        } else if (this.visualEnergy < i) {
            if ((i -= this.visualEnergy) > 8) {
                i = 8;
            }
            this.visualEnergy += i;
        }
        if (main.GameManager.k == 0) {
            if (this.w == 0) {
                this.position.x += this.g.x;
                this.position.z += this.g.z;
                if (main.GameManager.currentLevel == 6 && this.g.x > 0) {
                    this.g.x = this.g.x * 92 / 100;
                }
            }
            if ((this.stateFlags & 0x10000) == 0) {
                this.position.x += this.h.x;
                this.position.z += this.h.z;
            }
        } else if (main.GameManager.k > 0 && main.MainCanvas.mainState == 15) {
            if (main.GameManager.currentLevel != 6) {
                this.position.x += this.g.x;
                // clamp when boss dies
                if ((this.stateFlags & 0x100) != 0 && this != GameManager.getPlayer3()) {
                    clampPositionToScreen();
                }
            }
            this.g.x = this.g.x * 85 / 100;
        }
        this.h.set(0, 0, 0);
        if (this.w == 0) {
            if (this.position.y != 0 && (this.g.y -= 16384) < -131072) {
                this.g.y = -131072;
            }
            if (this.position.y > 0) {
                this.position.y += this.g.y;
                if (this.position.y <= 0) {
                    this.position.y = 0;
                    this.g.x = 0;
                    this.g.z = 0;
                    this.g.y = 0;
                }
            } else if (this.position.y < 0) {
                if (this.r != null) {
                    if (main.GameManager.currentLevel == 6) {
                        if (!main.GameManager.copsBeingCalled) {
                            this.position.x += 24576;
                            this.s = 127;
                            if (this.state == 15) {
                                if (this.y == 2) {
                                    if (this.u > 8) {
                                        this.u = 8;
                                    }
                                } else {
                                    this.u = 0;
                                }
                            }
                        }
                    } else {
                        this.g.x = 0;
                        this.s = 6;
                    }
                }
                if (main.GameManager.currentLevel != 6 || this.u >= 8) {
                    this.position.y += this.g.y;
                }
                if (this.position.y <= -983040) {
                    this.markToDie();
                }
            }
        }
        i = main.GameManager.E[ main.GameManager.currentLevel];
        int i_15_ = main.GameManager.F[ main.GameManager.currentLevel];
        if (this.position.z < i) {
            if ((this.stateFlags & 0x80000) == 0) {
                this.position.z = i;
            }
        } else if (this.position.z > i_15_) {
            if ((this.stateFlags & 0x80000) == 0) {
                this.position.z = i_15_;
            }
        } else {
            this.stateFlags &= ~0x80000;
        }
    }

    private void clampPositionToScreen() {
        main.Point2D p1 = new main.Point2D(this.position.x + this.I.x,
                        this.position.z + this.I.y);
        main.Point2D p2 = new main.Point2D(p1.x, p1.y);
        int maxX = main.GameManager.screenLockX + main.GameManager.halfScreenWidth12Left - 65536;
        int minX = main.GameManager.screenLockX - main.GameManager.halfScreenWidth12Left + 65536;
        int minY = main.GameManager.screenLockY - main.GameManager.halfScreenHeight12Left + 65536;
        if (p1.x > maxX) {
            p1.x = maxX;
        } else if (p1.x < minX) {
            p1.x = minX;
        }
        if (p1.y < minY) {
            p1.y = minY;
        }
        this.position.x += p1.x - p2.x;
        this.position.z += p1.y - p2.y;
    }
    
    public final int getNumEnemies()
    {
        return getNumEnemies(Integer.MAX_VALUE, Integer.MAX_VALUE);
    }
    public final int getNumEnemies(int maxDistX, int maxDistZ) {
        int numEnemies = 0;
        for (int i = 0 ; i < GameManager.collidableObjects.size() ; ++i) {
            AbstractObject obj = (AbstractObject)main.GameManager.collidableObjects.elementAt(i);
            if ((obj.stateFlags & ~0x7fffffff) == 0
                    && obj.position.y == 0 && (obj.stateFlags & 0x8000) != 0
                    && (obj.stateFlags & 134217728) == 0 // invincible bosses..
                    && obj.energy > 0
                    && obj != GameManager.getPlayer1()
                    && obj != GameManager.getPlayer2()
                    && obj != GameManager.getPlayer3()
                    && getDistanceX(obj) < maxDistX
                    && getDistanceZ(obj) < maxDistZ
            ){
                ++numEnemies;
            }
        }
        return numEnemies;
    }
    
    
    public final boolean shouldCPUCallCops(int playerId)
    {
        
        if (MainCanvas.playerCopCalls[playerId] == 0) return false;
        
        int numEnemies = getNumEnemies();
        
        if (numEnemies == 0) return false; // no enemies, no copcall
        
        main.AbstractObject otherPlayer = main.GameManager.getPlayer1();
        if (otherPlayer == null || !otherPlayer.isAlive() || otherPlayer == this)
            otherPlayer = GameManager.getPlayer2();
        if (otherPlayer == null || !otherPlayer.isAlive() || otherPlayer == this)
            otherPlayer = null;
        
        if (otherPlayer != null && otherPlayer.energy <= 2500 && (numEnemies >= 10 || GameManager.getRandomNumber(100 - numEnemies*10) == 0)){
            // Save other player!
            return true;
        }
        
        // Save yourself!
        return GameManager.getRandomNumber(20+(100*(MainCanvas.playerCopCalls[playerId]-1))) == 0 && (
                (numEnemies >= 12)
                || (numEnemies >= 8 && this.energy < 5000*MainCanvas.playerCopCalls[playerId])
                || (numEnemies > 0 && this.energy <= 2500*MainCanvas.playerCopCalls[playerId])
              );
    }
    

    public final void checkScreenBoundsAndCopCall(int playerId) {
        if (main.GameManager.k <= 0) {
            if (main.GameManager.n > 0) {
                this.Y = 0;
                this.dropWeapon();
            }
            InputController controller = getController();
            boolean callCops = (controller == null && shouldCPUCallCops(playerId))
                    || (controller != null && controller.pressed(
                            InputController.ACTION_SOMETHING_2
                            | InputController.ACTION_STAR
                            | InputController.ACTION_LEFT_SOFT_KEY)
                    );
            if (main.MainCanvas.mainState == 14
                    && main.MainCanvas.playerCopCalls[playerId] > 0
                    && callCops
                    && main.GameManager.copCall(playerId)) {
                this.setState(3);
            } else {
                clampPositionToScreen();
            }
        }
    }

    public void g() {
        this.stateFlags &= ~0x30000000;
        if (this.w > 0) {
            this.w--;
        } else {
            if (this.n > 0) {
                this.n--;
            }
            if (this.o > 0) {
                this.o--;
            }
            if (this.p > 0) {
                this.p--;
            }
            if (this.N > 0) {
                this.N--;
            }
            this.currAnimFrame++;
            if (this.r != null) {
                if (this.n > 0) {
                    this.r.a |= 0x8;
                } else {
                    this.r.a &= ~0x8;
                }
                if ((this.stateFlags & 0x2) == 0) {
                    if (++this.u >= this.r.a()) {
                        this.u = 0;
                        this.loopMovement = true;
                    } else {
                        this.loopMovement = false;
                    }
                }
            }
        }
        if (main.GameManager.k <= 0) {
            if ((this.stateFlags & 0x600) != 0 && (this.stateFlags & 0x48000004) == 0) {
                if (this.position.x > main.GameManager.screenLockX + 901120) {
                    this.position.x = main.GameManager.screenLockX + 901120;
                } else if (this.position.x < main.GameManager.screenLockX - 901120) {
                    this.position.x = main.GameManager.screenLockX - 901120;
                }
            }
            main.AbstractObject var_af_19_ = this;
            boolean bool = false;
            if ((var_af_19_.R & 0x2) != 0) {
                main.AbstractObject var_af_20_ = var_af_19_;
                boolean bool_21_ = false;
                if (var_af_20_.position.x == var_af_20_.K.x
                        && var_af_20_.position.z == var_af_20_.K.z) {
                    var_af_20_.O++;
                } else {
                    var_af_20_.O = 0;
                }
                if (var_af_20_.O - 20 > 0) {
                    int i;
                    if ((i = var_af_20_.targetPosition.x - var_af_20_.position.x) != 0) {
                        if (var_af_20_.position.z - (main.GameManager.screenLockY
                                + main.AbstractObject.C())
                                > 0) {
                            var_af_20_.Z = 0;
                        } else {
                            var_af_20_.Z = 1;
                        }
                    } else if (main.GameManager.getRandomNumber(2) > 0) {
                        var_af_20_.Z = 2;
                    } else {
                        var_af_20_.Z = 3;
                    }
                    bool_21_ = true;
                }
                if (bool_21_) {
                    var_af_19_.setState(8);
                    bool = true;
                }
            }
            if (!bool) {
                if ((var_af_19_.R & 0x1) != 0 && var_af_19_.currAnimFrame - 120 > 0) {
                    var_af_19_.setState(7);
                    bool = true;
                }
                main.AbstractObject var_af_22_;
                if (!bool && (var_af_19_.R & 0x4) != 0
                        && !(var_af_22_ = var_af_19_).h(0)) {
                    var_af_19_.setState(7);
                    bool = true;
                }
            }
            if (bool) {
                /* empty */
            }
            this.K.set(this.position);
            this.R = 0;
            if (this.energy <= 0) {
                this.e();
            }
        }
    }

    public boolean a(main.AbstractObject var_af_23_, int i) {
        if ((var_af_23_.stateFlags & ~0x77ffffff) != 0 || (this.stateFlags & ~0x7fffffff) != 0) {
            return false;
        }
        if (var_af_23_.p > 0 || this.getDistanceZ(var_af_23_) > i || this == var_af_23_) {
            return false;
        }
        if (this.A != 0 && this.A == var_af_23_.B) {
            return false;
        }
        main.eExtendsAr var_e = this.r;
        main.eExtendsAr var_e_24_ = var_af_23_.r;
        var_af_23_.h();
        boolean bool = false;
        try {
            bool = var_e.a(var_e_24_, 1, 0);
        } catch (java.lang.Exception exception) {
            java.lang.Exception exception_25_;
            (exception_25_ = exception).printStackTrace();
        }
        return bool;
    }

    public final main.AbstractObject enemyCheckGrabPlayer(int distance, int maxZDistance) {
        java.lang.Object object = null;
        if (object != null) {
            /* empty */
        }
        if (main.GameManager._a0()) {
            return null;
        }
        if (this.grabbedObject != null) {
            return null;
        }
        for (int i = 0; i < main.GameManager.players.length; i++) {
            main.AbstractObject player = main.GameManager.players[i];
            if (player != null
                    && (player.stateFlags & 0x8000) != 0 && player.p <= 0
                    && this.o <= 0 && this.getDistanceX(player) < distance
                    && this.getDistanceZ(player) < maxZDistance && player.d()) {
                return player;
            }
        }
        return null;
    }

    public final int checkGrab(int i, int i_29_, int grabDirection) {
        grabDirection = 0;
        boolean bool = false;
        boolean bool_31_ = false;
        if (this.grabbedObject != null) {
            return 0;
        }
        if ((this.stateFlags & 0x200000) != 0) {
            return 0;
        }
        if (this.q > 0) {
            return 0;
        }
        InputController controller = this.getController();
        main.AbstractObject obj;
        if ((obj = main.AbstractObject.getEnemyInFront(this, 1792, i, i_29_)) != null) {
            if (this.direction == 0 && controller != null && controller.holded(// 57344
                            main.InputController.ACTION_RIGHT
                            | main.InputController.ACTION_UP
                            | main.InputController.ACTION_DOWN
                )
            ) {
                if (obj.direction == 1) {
                    bool = true;
                } else if (obj.direction == 0) {
                    bool_31_ = true;
                }
            } else if (this.direction == 1 && controller != null && controller.holded( // 45056
                            main.InputController.ACTION_LEFT
                            | main.InputController.ACTION_UP // up | down = 40960
                            | main.InputController.ACTION_DOWN
                )
            ) {
                if (obj.direction == 0) {
                    bool = true;
                } else if (obj.direction == 1) {
                    bool_31_ = true;
                }
            }
            if (bool) {
                grabDirection = 1;
            } else if (bool_31_) {
                grabDirection = 2;
            }
            if (obj.objectType == 3 && grabDirection == 2) {
                grabDirection = 1;
            }
            if (grabDirection == 1) {
                // grab object from front
                this.x = 10;
                this.grabbedObject = obj;
                return 1;
            }
            if (grabDirection == 2) {
                // grab object from back
                this.x = 11;
                this.grabbedObject = obj;
                return 2;
            }
        }
        return 0;
    }

    public final void q() {
        this.G = false;
    }

    public final boolean checkIfReleaseGrab() {
        if (this.grabbedObject == null) {
            return true;
        }
        int grabbedState = this.grabbedObject.state;
        if (this.grabbedObject.energy <= 0 || grabbedState == 15 || grabbedState == 3 || grabbedState == 4 || vaultCount >= 2) {
            this.grabbedObject.G = false;
            this.grabbedObject = null;
            vaultCount = 0;
            return true;
        }
        return false;
    }

    public void c(int i) {
        this.u = 0;
        this.t = i;
        this.r.a(this.u);
        this.r.setB(this.direction == 0 ? 0 : 65536);
        this.r.b(this.t);
        this.loopMovement = false;
    }

    public final void d(int i) {
        this.g.x = 0;
        this.g.z = 0;
        this.c(i);
    }

    public final int s() {
        if (this.s > 0) {
            return this.s;
        }
        if (this.position.y < 0) {
            if (main.GameManager.currentLevel == 6) {
                return 126;
            }
            return 6;
        }
        int i = ((this.position.z - main.GameManager.E[ main.GameManager.currentLevel]
                >> 12)
                + 8);
        if ((this.stateFlags & 0x10) != 0) {
            i++;
        }
        if (i > 120) {
            i = 120;
        } else if (i < 8) {
            i = 8;
        }
        return i;
    }

    public static int c(int i, int i_34_) {
        if (i_34_ < 0) {
            if (main.GameManager.currentLevel == 6) {
                return 127;
            }
            return 6;
        }
        if ((i = (i - main.GameManager.E[ main.GameManager.currentLevel]
                >> 12) + 8)
                > 120) {
            i = 120;
        } else if (i < 8) {
            i = 8;
        }
        return i;
    }

    public final int getDistanceX(main.AbstractObject obj) {
        if (obj == null)
            return Integer.MAX_VALUE;
        return java.lang.Math.abs(this.position.x - obj.position.x);
    }

    public final int getDistanceZ(main.AbstractObject var_af_36_) {
        return java.lang.Math.abs(this.position.z - var_af_36_.position.z);
    }

    public final int t() {
        java.lang.Object object = null;
        if (object != null) {
            /* empty */
        }
        if (main.GameManager._a1()) {
            return 0;
        }
        return java.lang.Math
                .abs(main.GameManager.screenLockX - this.position.x);
    }

    public final int getDirectionTowardObject(main.AbstractObject target) {
        if (this.position.x > target.position.x) {
            return 1;
        }
        return 0;
    }
    
    
    public final boolean isFacedToAnyPlayer() {
        return (GameManager.players[0] != null && isFacedToTarget(GameManager.players[0]))
                || (GameManager.players[1] != null && isFacedToTarget(GameManager.players[1]))
                || (GameManager.players[2] != null && isFacedToTarget(GameManager.players[2]))
        ;
    }

    public final boolean isFacedToTarget(main.AbstractObject target) {
        if (this.position.x < target.position.x) {
            if (target.direction == 1) {
                return true;
            }
            return false;
        }
        if (target.direction == 0) {
            return true;
        }
        return false;
    }

    public final boolean u() {
        if ((this.state != 15 || this.y != 2) && this.state != 5 && this.state != 14) {
            return false;
        }
        return true;
    }

    public final main.Point b(int i, int i_39_, int i_40_) {
        main.Point var_q_41_;
        main.Point var_q
                = (var_q_41_
                = new main.Point(this.position.x, this.position.z, this.position.y));
        var_q.x = var_q.x + (this.direction == 0 ? i : -i);
        var_q_41_.z += i_39_;
        main.Point var_q_42_ = var_q_41_;
        var_q_42_.y = var_q_42_.y;
        return var_q_41_;
    }

    public final main.Point a(main.Point[] var_qs) {
        main.Point var_q = var_qs[0];
        int i = main.ImageUtils.b(this.position.x, this.position.z, var_qs[0].x,
                var_qs[0].z);
        for (int i_43_ = 1; i_43_ < var_qs.length; i_43_++) {
            int i_44_;
            if ((i_44_
                    = main.ImageUtils.b(this.position.x, this.position.z,
                            var_qs[i_43_].x, var_qs[i_43_].z))
                    < i) {
                var_q = var_qs[i_43_];
                i = i_44_;
            }
        }
        return var_q;
    }

    public final void e(int i) {
        this.A = ((this.objectType & 0xfff) << 16) + ((this.state & 0xff) << 8) + (i + 1
                & 0xff);
    }

    public final void playDyingSound() {
        java.lang.Object object = null;
        if (object != null) {
            /* empty */
        }
        if (!main.GameManager._a1()) {
            int i;
            if (this.objectType == 3) AudioController.playSound(49, 1);
            main.AudioController.playSound(i = (this.objectType == 1 ? 47
                    : (this.objectType == 2
                    || this.objectType == 7
                    || this.objectType == 14
                    || this.objectType == 13)
                    ? 51 : (this.stateFlags & 0x400) != 0
                    ? 56 : 48),
                    1);
        }
    }

    public final void applyDamage(int damage) {
        int playerId = -1;
        if (attacker != null) {
            if (attacker == GameManager.getPlayer1())       playerId = 0;
            else if (attacker == GameManager.getPlayer2())  playerId = 1;
        }
        boolean addScore = playerId != -1;
        if (damage < 0) {
            addScore = false;
            damage = -damage;
        }
        if (this.energy > 0) {
            //if (this != main.GameManager.getPlayer1() // Debug
            // && this != main.GameManager.getPlayer2() // Debug
            // && this != main.GameManager.getPlayer3()
            //){ // Debug
                this.energy -= damage;
            //    energy = 0;             // Debug
           //}                           // Debug
            if (this.energy <= 0) {
                if (addScore) {
                    main.MainCanvas.addPlayerScore(playerId, this.beatingScore);
                }
                if ((this.stateFlags & 0x200) != 0) {
                    if ((this.stateFlags & 0x400) != 0) {
                        if (main.GameManager.currentLevel == 7 && this.objectType != 14
                                && this.objectType != 13) {
                            main.GameManager.r();
                            main.GameManager.t();
                        }
                    } else {
                        this.playDyingSound();
                    }
                }
                if (this.y != 6) {
                    this.y = 2;
                }
            }
        }
        if (damage != 0) {
            this.damage = 0;
        }
        if ((this.stateFlags & 0x600) != 0 && addScore) {
            main.GameManager.setObjInHUD(this, playerId);
        }
    }

    public final void c(int i, int i_48_, int i_49_) {
        if (!main.GameManager.copsBeingCalled) {
            i = this.direction == 0 ? i : -i;
            i = main.GameManager.getRandomNumber(20) - 10 + i << 12;
            i_48_ = main.GameManager.getRandomNumber(20) - 10 + i_48_ << 12;
            main.GameManager.collisionMapObjects.addElement(new main.CollisionMap(1, this.position.x + i, this.position.z + i_48_,
                    this.position.y + (i_49_ << 12), 0));
        }
    }

    public final void a(int i, int i_50_, int i_51_, int i_52_) {
        if (!main.GameManager.copsBeingCalled) {
            i = this.direction == 0 ? i : -i;
            i = main.GameManager.getRandomNumber(20) - 10 + i << 12;
            i_50_ = main.GameManager.getRandomNumber(20) - 10 + i_50_ << 12;
            i_51_ = 2;
            if (i_52_ == 1) {
                i_51_ = 3;
            }
            main.GameManager.collisionMapObjects.addElement(new main.CollisionMap(i_51_, this.position.x + i,
                    this.position.z + i_50_,
                    this.position.y + (48 << 12), 0));
        }
    }

    public final void d(int i, int i_53_, int i_54_) {
        i = (i = this.direction == 0 ? i : -i) + 4 - main.GameManager.getRandomNumber(8) << 12;
        i_53_ = i_53_ + 4 - main.GameManager.getRandomNumber(8) << 12;
        main.GameManager.collisionMapObjects.addElement(new main.CollisionMap(4, this.position.x + i, this.position.z + i_53_,
                this.position.y + (i_54_ << 12), 0));
    }

    public final void e(int i, int i_55_, int i_56_) {
        if (!main.GameManager.copsBeingCalled) {
            i = this.direction == 0 ? i : -i;
            for (i_55_ = 0; i_55_ < 2; i_55_++) {
                i_56_ = i + 24 - main.GameManager.getRandomNumber(48) << 12;
                int i_57_ = 8 - main.GameManager.getRandomNumber(16) << 12;
                main.GameManager.collisionMapObjects.addElement(new main.CollisionMap(4, this.position.x + i_56_,
                        this.position.z + i_57_, this.position.y,
                        0));
            }
        }
    }

    public final void g(int i) {
        this.d(i + 24, 8, 0);
        this.d(i, -4, 0);
        this.d(i - 24, -2, 0);
    }

    public final void f(int i, int i_58_, int i_59_) {
        this.g(i);
        for (i_58_ = 0; i_58_ < 5; i_58_++) {
            main.AbstractObject var_af_60_ = this;
            int i_61_ = i;
            int i_62_ = 0;
            int i_63_ = i_59_;
            int i_64_ = i_58_;
            int i_65_ = i_63_;
            int i_66_ = i_62_;
            int i_67_ = i_61_;
            main.AbstractObject var_af_68_;
            i_67_ = ((i_67_ = (var_af_68_ = var_af_60_).direction == 0 ? i_67_ : -i_67_)
                    + 4 - main.GameManager.getRandomNumber(8)) << 12;
            i_66_ = i_66_ + 4 - main.GameManager.getRandomNumber(8) << 12;
            main.GameManager.collisionMapObjects.addElement(new main.CollisionMap(5, var_af_68_.position.x + i_67_,
                    var_af_68_.position.z + i_66_,
                    var_af_68_.position.y + (i_65_ << 12),
                    i_64_));
        }
    }

    public static main.AbstractObject getEnemyInFront(main.AbstractObject var_af,
            int i, int i_69_, int i_70_) {
        int i_71_ = 4091904;
        main.AbstractObject resultingObj = null;
        if (var_af.position.y != 0) {
            return null;
        }
        for (int j = 0; j < main.GameManager.collidableObjects.size(); j++) {
            main.AbstractObject obj;
            int i_75_;
            if (((obj = ((main.AbstractObject) main.GameManager.collidableObjects.elementAt(j))).stateFlags
                    & ~0x7fffffff) == 0
                    && obj.position.y == 0 && (obj.stateFlags & 0x8000) != 0
                    && (obj.stateFlags & i) != 0
                    && (i_75_ = (var_af.direction == 0 ? obj.position.x - var_af.position.x
                    : var_af.position.x - obj.position.x)) < i_71_
                    && 16384 < i_75_ && i_75_ <= i_69_
                    && var_af.getDistanceZ(obj) < i_70_ && obj.d()
                    && obj.energy > 0 // custom: only consider enemies with some energy
             ) {
                resultingObj = obj;
                i_71_ = i_75_;
            }
        }
        return resultingObj;
    }
    
    
    public boolean isAlive(){
        return (this.stateFlags & ~0x7fffffff) == 0 && this.energy > 0;
    }

    public final void w() {
        this.currAnimFrame = 0;
        this.u = 0;
        this.x = 0;
        this.stateFlags &= ~0x170010;
        this.soundToPlayOnContact = 57;
    }

    public final boolean isInsideScreen(int i, int i_76_) {
        i = 655360 + (i << 12);
        i_76_ = 491520 + (i_76_ << 12);
        if (java.lang.Math
                .abs(main.GameManager.screenLockX - this.position.x) < i
                && java.lang.Math
                .abs(main.GameManager.screenLockY - this.position.z) < i_76_) {
            return true;
        }
        return false;
    }

    public final boolean x() {
        return this.h(0);
    }

    public final boolean h(int i) {
        int i_77_ = 655360;
        if (main.GameManager.currentLevel == 7) {
            if (java.lang.Math
                    .abs(main.GameManager.g - i_77_ - this.position.x)
                    < i_77_ + i) {
                return true;
            }
            return false;
        }
        if (java.lang.Math
                .abs(main.GameManager.h + i_77_ - this.position.x)
                < i_77_ + i) {
            return true;
        }
        return false;
    }

    public final boolean y() {
        if ((this.stateFlags & ~0x3ff7fffb) != 0) {
            return false;
        }
        if (main.GameManager.copsBeingCalled) {
            return false;
        }
        if (main.GameManager.currentLevel == 7) {
            if (main.GameManager.g + 262144 < this.position.x) {
                return true;
            }
            return false;
        }
        if (this.position.x < main.GameManager.h - 262144) {
            return true;
        }
        return false;
    }

    public final boolean e(int i, int i_78_) {
        if (i >= java.lang.Math.abs(this.targetPosition.x - this.position.x)
                && (i_78_
                >= java.lang.Math.abs(this.targetPosition.y - this.position.z))) {
            return true;
        }
        return false;
    }

    public static int z() {
        return main.GameManager.E[ main.GameManager.currentLevel];
    }

    public static int A() {
        return main.GameManager.F[ main.GameManager.currentLevel];
    }

    public static int B() {
        return (main.GameManager.F[ main.GameManager.currentLevel] - main.GameManager.E[ main.GameManager.currentLevel]);
    }

    public static int C() {
        return (main.GameManager.E[ main.GameManager.currentLevel]
                + main.AbstractObject.B() / 2);
    }

    public final boolean D() {
        boolean bool = false;
        if (this.targetPosition.y <= main.GameManager.E[ main.GameManager.currentLevel]) {
            this.targetPosition.y = main.GameManager.E[ main.GameManager.currentLevel];
            bool = true;
        } else if (this.targetPosition.y
                >= main.GameManager.F[ main.GameManager.currentLevel]) {
            bool = true;
            this.targetPosition.y = main.GameManager.F[ main.GameManager.currentLevel];
        }
        return bool;
    }

    public static void e(main.AbstractObject var_af) {
        var_af.g.set(0, 0, var_af.g.y);
        var_af.velocityZ = -20480;
    }

    public static void f(main.AbstractObject var_af) {
        var_af.g.set(0, 0, var_af.g.y);
        var_af.velocityX = -20480;
    }

    public static void g(main.AbstractObject var_af) {
        var_af.g.set(0, 0, var_af.g.y);
        var_af.velocityZ = -20480;
    }

    public static void h(main.AbstractObject var_af) {
        var_af.velocityX = 20480;
        var_af.velocityZ = 20480;
        if (var_af.Z < 2) {
            var_af.targetPosition.x = var_af.position.x;
        } else {
            var_af.targetPosition.y = var_af.position.z;
        }
        if (var_af.Z == 0) {
            var_af.targetPosition.y = var_af.position.z - 204800;
        } else if (var_af.Z - 1 == 0) {
            var_af.targetPosition.y = var_af.position.z + 204800;
        } else if (var_af.Z - 2 == 0) {
            var_af.targetPosition.x = var_af.position.x - 204800;
        } else {
            var_af.targetPosition.x = var_af.position.x + 204800;
        }
        var_af.D();
    }

    public static void i(main.AbstractObject var_af) {
        var_af.velocityX = 20480;
        var_af.velocityZ = 20480;
        var_af.targetPosition.set(main.GameManager.screenLockX, var_af.position.z);
    }

    public final void E() {
        main.Point var_q = this.position;
        var_q.x = var_q.x + (this.direction == 0 ? -81920 : 81920);
        main.Point var_q_79_ = this.g;
        var_q_79_.x = var_q_79_.x + (this.direction == 0 ? -32768 : 32768);
        this.g.z = 0;
        this.y = 9;
        this.stateFlags |= 0x10000;
    }

    public final void F() {
        this.stateFlags |= 0x10000;
        this.o = 12;
        this.p = 12;
        this.direction = this.C;
        this.g.x = this.direction == 0 ? -16384 : 16384;
    }

    public static void j(main.AbstractObject var_af) {
        if (9 > var_af.state || var_af.state > 11) {
            if ((var_af.stateFlags & 0x10000000) != 0) {
                var_af.setState(9);
            }
            if ((var_af.stateFlags & 0x20000000) != 0) {
                var_af.setState(10);
            }
        }
    }

    public final void G() {
        java.lang.Object object = null;
        if (object != null) {
            /* empty */
        }
        if (!main.GameManager._a0()) {
            this.stateFlags |= 0x10;
            this.g.x = 0;
            this.g.z = 0;
            this.grabbedObject.g.x = 0;
            this.grabbedObject.g.z = 0;
        }
    }

    public final void a(boolean bool, int i) {
        int i_80_ = bool ? 10 : 11;
        int i_81_ = this.direction;
        if (bool) {
            i_81_ ^= 0x1;
        }
        this.position.set(this.grabbedObject.position.x + (this.direction == 0 ? -i : i), this.grabbedObject.position.z, this.position.y);
        this.G();
        this.grabbedObject.direction = i_81_;
        this.grabbedObject.onAttackContact(this, 0, i_80_, this.direction, 0);
    }

    public final void a(boolean bool) {
        if (this.grabbedObject != null) {
            this.grabbedObject.position.set(this.position);
            main.Point var_q = this.grabbedObject.position;
            var_q.x = var_q.x + (this.direction == 0 ? 81920 : -81920);
            this.grabbedObject.direction = this.direction;
            if (bool) {
                this.grabbedObject.direction ^= 0x1;
            }
        }
    }

    public final void b(boolean bool, int i) {
        if (this.grabbedObject != null && this.grabbedObject.energy > 0) {
            this.stateFlags |= 0x10;
            this.grabbedObject.p = 2;
            this.grabbedObject.direction = bool ? this.direction : this.direction ^ 0x1;
            this.position.set(this.grabbedObject.position);
            main.Point var_q = this.position;
            var_q.x = var_q.x + (this.direction == 0 ? -i : i);
        }
    }

    public final void H() {
        if (this.grabbedObject != null && this.direction == 1 && this.position.x > 450560 && this.currAnimFrame < 5) {
            this.position.x += -32768;
            this.grabbedObject.position.x += -32768;
        }
    }

    public static int I() {
        return main.GameManager.getRandomNumber(4) - 2 << 11;
    }

    public final void markToDie() {
        this.releaseGrabbedObj();
        this.stateFlags &= ~0x1;
        this.stateFlags |= ~0x7fffffff;
    }

    public final void dropWeapon() {
        if (this.comboCounter != 0) {
            int i;
            if ((this.stateFlags & 0x100) != 0) {
                i = this.Y - 1;
            } else {
                i = 1;
            }
            switch (this.comboCounter) {
                case 1:
                    main.GameManager.dropWeaponOnTheFloor(3, this.position.x, this.position.z, 131072, i);
                    break;
                case 2:
                    main.GameManager.dropWeaponOnTheFloor(4, this.position.x, this.position.z, 131072, i);
                    break;
                case 3:
                    main.GameManager.dropWeaponOnTheFloor(5, this.position.x, this.position.z, 131072, i);
                    break;
            }
            this.comboCounter = 0;
        }
    }

    public static void addPlayerScore(int playerId, int score) {
        main.MainCanvas.addPlayerScore(playerId, score);
    }

    public final void pickItem(int playerId, int itemId, int i_82_) {
        switch (itemId) {
            default:
                break;
            case 1: // Cash 500 pts
                main.MainCanvas.addPlayerScore(playerId, 500);
                break;
            case 2: // Gold 2000 pts
                main.MainCanvas.addPlayerScore(playerId, 2000);
                break;
            // weapon
            case 3:
            case 4:
            case 5:
                this.dropWeapon(); // drop current weapon
                this.comboCounter = itemId - 2; // weapon id is stored on comboCounter...
                this.Y = i_82_;
                break;
            case 6:
                if (this.energy >= 10000) {
                    main.MainCanvas.addPlayerScore(playerId, 500);
                }
                if ((this.energy += 3000) > 10000) {
                    this.energy = 10000;
                }
                break;
            case 7:
                if (this.energy >= 10000) {
                    main.MainCanvas.addPlayerScore(playerId, 10000);
                }
                this.energy = 10000;
                break;
            case 8: { // extra live
                main.AudioController.playSound(6, 1);
                if (++main.MainCanvas.playerLives[playerId] > 9) {
                    main.MainCanvas.playerLives[playerId] = 9;
                }
                break;
            }
            case 9:
                if (++main.MainCanvas.playerCopCalls[playerId] > 9) {
                    main.MainCanvas.playerCopCalls[playerId] = 9;
                }
                break;
            case 10: // Adam help
                main.GameManager.spawnPlayer(3, 0, 983040, 0, 2);
        }
    }

    public final void L(AbstractObject target) {
        this.a(this.state, V, target);
    }

    public final void a(int i, int[] is, AbstractObject target) {
        this.D = false;
        switch (i) {
            case 5:
                this.g.set(0, 0, this.g.y);
                if (this.loopMovement) {
                    this.setState(3);
                }
                break;
            case 14:
                this.g.set(0, 0, this.g.y);
                this.p = 3;
                if (this.currAnimFrame > 21) {
                    this.markToDie();
                }
                break;
            case 15:
                if (this.y == 2 && this.position.y == 0) {
                    if ((this.stateFlags & 0x400) != 0) {
                        i = 11;
                        if (this.objectType == 12 || this.objectType == 15) {
                            i = 13;
                        }
                        if (this.currAnimFrame == i) {
                            if (this.objectType == 14 || this.objectType == 13) {
                                main.GameManager.c();
                                main.GameManager.a();
                            } else {
                                main.GameManager.e();
                            }
                            this.p = 32;
                            if (this.energy <= 0) {
                                if ((this.stateFlags & 0x200) != 0
                                        || main.GameManager.bossObjects.size() > 1
                                        || main.GameManager.currentLevel == 7) {
                                    main.AudioController.playSound(i = 5, 1);
                                }
                                this.f(-32, 0, 0);
                            } else {
                                main.AudioController.playSound(i = 5, 1);
                                this.g(-32);
                            }
                        }
                    } else if ((this.stateFlags & 0x200) != 0) {
                        if (this.currAnimFrame == 12) {
                            this.N = 8;
                            this.stateFlags &= ~0x10000;
                        }
                        if (this.currAnimFrame == 13) {
                            if (this.objectType == 9) {
                                main.GameManager.d();
                            } else {
                                main.GameManager.a();
                            }
                            main.AudioController.playSound(i = 5, 1);
                            this.g(-16);
                        }
                    }
                }
                if (this.loopMovement) {
                    if (this.energy <= 0) {
                        this.setState(14);
                    } else if (this.y != 1) {
                        this.setState(5);
                    } else {
                        this.setState(3);
                    }
                }
                break;
            case 12:
            case 13:
                if (!this.G) {
                    this.setState(3);
                    this.q = 6;
                }
                break;
            case 20:
                if (this.loopMovement) {
                    this.setState(12);
                }
                break;
            case 16:
                this.D = true;
                if (this.currAnimFrame == 9) {
                    main.AudioController.playSound(i = 30, 1);
                }
                if (this.currAnimFrame == 11) {
                    this.N = 20;
                    this.applyDamage(this.damage);
                    main.GameManager.e();
                    this.f(is[0] >> 12, 0, 0);
                }
                if (this.loopMovement) {
                    main.Point var_q = this.position;
                    var_q.x = var_q.x + (this.direction == 0 ? is[0] : -is[0]);
                    if (this.energy <= 0) {
                        this.setState(14);
                    } else {
                        this.setState(5);
                    }
                }
                break;
            case 17:
                this.D = true;
                if (this.loopMovement) {
                    this.setState(18);
                }
                break;
            case 18:
                this.D = true;
                if (this.currAnimFrame == 12) {
                    this.stateFlags &= ~0x10000;
                    this.N = 20;
                    this.applyDamage(this.damage);
                    main.GameManager.d();
                    main.AudioController.playSound(i = 5, 1);
                    this.f(16, 0, 0);
                }
                if (this.loopMovement) {
                    this.direction ^= 0x1;
                    if (this.energy <= 0) {
                        this.setState(14);
                    } else {
                        this.setState(5);
                    }
                }
                break;
            case 19:
                this.D = true;
                if (this.currAnimFrame == 7) {
                    this.N = 20;
                    this.applyDamage(this.damage);
                    main.GameManager.e();
                    main.AudioController.playSound(i = 5, 1);
                    this.f(-36, 0, -8);
                }
                if (this.loopMovement) {
                    main.Point var_q = this.position;
                    var_q.x = var_q.x + (this.C == 0 ? is[2] : -is[2]);
                    if (this.energy <= 0) {
                        this.setState(14);
                    } else {
                        this.setState(5);
                    }
                }
                break;
            case 22:
                if (240 <= this.currAnimFrame) {
                    this.setState(3);
                }
                break;
            case 7: {
                this.targetPosition.set(main.GameManager.screenLockX, this.position.z);
                main.AbstractObject.moveToTarget(this, target);
                main.AbstractObject var_af_85_ = this;
                if (java.lang.Math
                        .abs(main.GameManager.screenLockX - var_af_85_.position.x)
                        < 409600) {
                    this.setState(3);
                } else {
                    this.R = 2;
                }
                break;
            }
            case 8: {
                main.AbstractObject.moveToTarget(this, target);
                if (this.e(0, 0)) {
                    this.setState(3);
                } else {
                    this.R = 1;
                }
                break;
            }
            case 9:
                this.position.z += this.velocityZ;
                if (30 < this.currAnimFrame) {
                    this.setState(3);
                }
                break;
            case 10:
                this.position.x += this.velocityX;
                if (30 < this.currAnimFrame) {
                    this.setState(11);
                }
                break;
            case 11:
                this.position.z += this.velocityZ;
                if (30 < this.currAnimFrame) {
                    this.setState(3);
                }
                break;
        }
    }

    public final void releaseGrabbedObj() {
        if (this.grabbedObject != null) {
            this.grabbedObject.G = false;
            this.grabbedObject = null;
        }
        this.vaultCount = 0;
    }

    public static void moveToTarget(main.AbstractObject sourceObj, main.AbstractObject targetObj) {
        if (!main.GameManager.copsBeingCalled) {
            if (sourceObj.nextFrameToMove > 0) {
                sourceObj.nextFrameToMove--;
            }
            sourceObj.Q++;
            if (targetObj != null && sourceObj.currAnimFrame % 3 == 0) {
                sourceObj.direction = sourceObj.getDirectionTowardObject(targetObj);
            }
            int i;
            if ((i = sourceObj.targetPosition.x - sourceObj.position.x) > sourceObj.velocityX) {
                i = sourceObj.velocityX;
            } else if (i < -sourceObj.velocityX) {
                i = -sourceObj.velocityX;
            }
            int i_89_;
            if ((i_89_ = sourceObj.targetPosition.y - sourceObj.position.z) > sourceObj.velocityZ) {
                i_89_ = sourceObj.velocityZ;
            } else if (i_89_ < -sourceObj.velocityZ) {
                i_89_ = -sourceObj.velocityZ;
            }
            sourceObj.position.x += i;
            sourceObj.position.z += i_89_;
        }
    }

    public final boolean checkAttackObjects(int int1, int int2) {
        boolean bool = false;
        if (main.MainCanvas.mainState != 14) {
            return false;
        }
        if (this.o == 0 && !this.D && (this.stateFlags & 0x100) == 0) {
        //if (true){ // Debug
            for (int i = 0; i < main.GameManager.players.length; i++) {
                main.AbstractObject obj = main.GameManager.players[i];
                if (obj != null && this.a(obj, 65536)) {
                    if ((this.stateFlags & 0x100000) == 0) {
                        this.e(0);
                        obj.onAttackContact(this, this.A, this.x, this.direction, int1);
                        obj.c(0, 0, 40);
                        obj.p = 5;
                        main.AudioController.playSound(this.soundToPlayOnContact, 1);
                        main.GameManager.b();
                    }
                    bool = true;
                }
            }
        }
        if (this.D && (this.stateFlags & 0x600) != 0) {
        //if (true){ // Debug
            for (int i = 0; i < main.GameManager.collidableObjects.size(); i++) {
                main.AbstractObject obj;
                if (((obj = ((main.AbstractObject) main.GameManager.collidableObjects.elementAt(i)))
                        != null)
                        && obj != this && (obj.stateFlags & 0xe00) != 0
                        && this.a(obj, 131072)) {
                    this.e(0);
                    if (this.state == 16) {
                        int1 = this.direction;
                    } else {
                        int1 = this.direction ^ 0x1;
                    }
                    obj.onAttackContact(this, this.A, 2, int1, 2000);
                    obj.c(0, 0, 32);
                    this.w = 3;
                    main.AudioController.playSound(5, 1);
                    main.GameManager.a();
                }
            }
        }
        return bool;
    }
    
    
    public InputController getController(){
        // Default is null;
        return null;
    }

    public final int onBeingAttacked(main.AbstractObject attacker, int i, int i_98_, int i_99_, int attackDamage) {
        this.attacker = attacker;
        if (this.energy <= 0) {
            return 0;
        }
        // Check invincibility
        if ((this.stateFlags & INVINCIBILITY_FLAG) != 0) {
            return 0;
        }
        this.releaseGrabbedObj();
        this.B = i;
        this.y = i_98_;
        this.C = i_99_ == 0 ? 1 : 0;
        this.q = 0;
        if (attacker == null) {
            attackDamage = -attackDamage;
        }
        switch (i_98_) {
            case 0:
                return 0;
            default:
                break;
            case 1:
            case 2:
            case 3:
                this.G = false;
                this.applyDamage(attackDamage);
                return 15;
            case 4:
            case 5:
                this.applyDamage(attackDamage);
                return 20;
            case 6:
                this.G = false;
                this.damage = attackDamage; // delayed Damage
                return 15;
            case 7:
                this.damage = attackDamage; // delayed Damage
                this.applyDamage(0);
                return 19;
            case 8:
                this.damage = attackDamage; // delayed Damage
                this.applyDamage(0);
                return 16;
            case 9:
                this.damage = attackDamage; // delayed Damage
                this.applyDamage(0);
                return 17;
            case 10:
                this.G = true;
                this.applyDamage(0);
                return 12;
            case 11:
                this.G = true;
                this.applyDamage(0);
                return 13;
            case 12:
                this.damage = attackDamage; // delayed Damage
                this.applyDamage(0);
                return 22;
        }
        return 0;
    }

    public final boolean N() {
        this.releaseGrabbedObj();
        this.energy = 0;
        switch (this.state) {
            case 15:
                if (this.y != 2) {
                    return true;
                }
                return false;
            case 14:
            case 16:
            case 17:
            case 18:
            case 19:
                return false;
            default:
                return true;
        }
    }

    public final void clearAbstractData() {
        if (this.r != null) {
            main.eExtendsAr.d();
            this.r = null;
        }
        if (this.collisionBox != null) {
            this.collisionBox.clearData();
            this.collisionBox = null;
        }
    }
    
}
