package main;

public abstract interface GameTexts {

    public static final String[] credits = {"Streets of Rage", "1.0.0", "(c) SEGA", "", "Publisher:", "Beijing ForceGen", "Information Technology Ltd.", "", "Developer:", "SEGA Corporation", "", "Customer Service Phone:", "010-89657897", "", "Email:", "support@forcegen.net", "", "More Games:", "http://www.forcegen.net", "", "Thanks for Playing!", "", "This software uses DynaFont.", "DynaFont is (c) DynaComware", "Taiwan Inc. ®", "", "", "Modifications: gsaurus", "Translation thanks to:", "DigitalDuck and JosephHeinrich"};
    public static final String[][] help = {
            {"-- Play", "Play the story mode through 7 levels", "and defeat Mr.X!", "", "-- Level Select", "Select any previously cleared level.", "Progress won't be saved.", "", "-- Tutorial", "Adam will teach you the basic controls.", ""},
            {"-- Ranking", "See the high scores.", "", "-- Options", "Change game settings.", "The game is saved when interrupted.", "Select \"Retry\" to continue last game."},
            {"[ Losing conditions ]", "Game ends when there are no lives left.", "You lose a life if:", "    - Health bar reaches 0.", "    - Fall into a trap or get out of bounds.", "    - Time out", "", "[ Continue ]", "When the game ends, you can continue", "up to 3 times, but the score will be reset."},
            {"[ Controls ]", "-- Move: hold Up / Down / Left / Right", "-- Attack: tap Left / Right", "-- Grab: get close to opponent.", "Once grabbed, you can:", "    - Throw: Left / Right", "    - Vault: Up", "    - Release: Down-Down", "-- Jump Attack: Up-Up, or 0 key"},
            {"-- Special: Tap OK twice.", "You may lose some health.", "-- Police: Press the left soft key or", "* twice to help clear enemies.", "You can use it once per life.", "", "[ Combos ]", "Different combinations of input keys will", "change the attack style.", "Become a combo master!"},
            {"[ Pause ]", "Press the right soft key to pause.", "", "[ Items ]", "There are hidden items to help you,", "such as health recovery and weapons.", "    - Pick up items: OK key", "    - Weapon attack: Left / Right", "    - Drop weapon: Down-Down"}
    };
    public static final String[][] helpSor2 = {
            {"-- Play", "Play the story mode through 7 levels", "and defeat Mr.X!", "", "-- Level Select", "Select any previously cleared level.", "Progress won't be saved.", "", "-- Tutorial", "Adam will teach you the basic controls.", ""},
            {"-- Ranking", "See the high scores.", "", "-- Options", "Change game settings.", "The game is saved when interrupted.", "Select \"Retry\" to continue last game."},
            {"[ Losing conditions ]", "Game ends when there are no lives left.", "You lose a life if:", "    - Health bar reaches 0.", "    - Fall into a trap or get out of bounds.", "    - Time out", "", "[ Continue ]", "When the game ends, you can continue", "up to 3 times, but the score will be reset."},
            {"[ Controls ]", "-- Move: hold Up / Down / Left / Right", "-- Attack: press X, W or 2", "-- Jump Attack: C, E or 3", "-- Grab: get close to opponent.", "Once grabbed, you can:", "    - Throw: Back + Attack", "    - Vault: Jump", "    - Release: Down-Down"},
            {"-- Special: Z, Q or 1", "You may lose some health.", "-- Police: V, R, 4, *, or left soft key.", "Helps you clear enemies.", "You can use it once per life.", "", "[ Combos ]", "Different combinations of input keys will", "change the attack style.", "Become a combo master!"},
            {"[ Pause ]", "Press the right soft key to pause.", "", "[ Items ]", "There are hidden items to help you,", "such as health recovery and weapons.", "    - Pick up items: OK key", "    - Weapon attack: Left / Right", "    - Drop weapon: Down-Down"}
    };
    public static final String[] intro = {
            "【Peaceful days have ended",
            "",
            "【Mr.X, who was said to come from",
            "Japan, founded a criminal syndicate.",
            "This organization got so powerful",
            "that the city became a district of",
            "violence and crime, where laws",
            "are meaningless.",
            "",
            "【The Syndicate even took control over",
            "the police force by bribing officials.",
            "",
            "【Public security couldn't be worse,",
            "and residents were increasingly",
            "disgruntled with the city...",
            "",
            "",
            "【Until one day, a group of",
            "youngsters stepped forward!",
            "",
            "【They are - Axel, Blaze, and Adam.",
            "",
            "【These ex-cops had seen through",
            "the extremely corrupt police force",
            "and vowed to defeat Mr.X and",
            "destroy the Syndicate.",
            "",
            "【They trained themselves",
            "to fight against them.",
            "",
            "",
            "【Bet everything on the fists.",
            "【The battle is about to begin!"
    };
    public static final String[][][] tutorialSpeeches = {
        {
            {"Hey! How are you?", "I'm Adam, your best partner!"},
            {"I'll teach you how to play!", ""},
            {"Keep holding down the directional", "keys to move!"},
            {"Quickly tap the directional keys","to attack!"},
            {"Move to the road cone, then", "hit it with your bare knuckle!"}
        },
        {
            {"You did well, pal!", "Easy, isn't it?"},
            {"Now about combos!", null},
            {"When you hit an enemy,", "keep tapping the directional keys."},
            {"Press Left-Left-Left-Left-Left.", "Try to defeat this punk."}
        },
        {
            //{"That's it!!", null},
            {"Alright!!", null},
           // {"After hitting once, you do a combo!!", null},
            {"You can change the combo style", "by tapping Up or Down."},
            {"Discover new combos yourself!", ""},
            {"Finally, let's see how", "to use the special attack!"},
            {"It beats all enemies around you.", "Quickly press OK twice!"},
        },
        {
            {"Yeah! That's it!!!", null},
            {"Beware, this attack takes some", "health when hitting enemies."},
            {"So don't be hasty, bro!", ""},
            {"I've taught you all the basics.", "Now use what you've learnt in game!"},
            {"See you later bro!", null}
        }
    };
    
    public static final String[][][] tutorialSpeechesSor2 = {
        {
            {"Hey! How are you?", "I'm Adam, your best partner!"},
            {"I'll teach you how to play!", ""},
            {"Keep holding down the directional", "keys to move!"},
            {"Tap X to attack.","Alternative keys are W or 2."},
            {"Move to the road cone, then", "hit it with your bare knuckle!"}
        },
        {
            {"You did well, pal!", "Easy, isn't it?"},
            {"Now about combos!", null},
            {"When you hit an enemy,", "keep tapping the attack key."},
            {"Press X-X-X-X-X.", "Try to defeat this punk."}
        },
        {
            //{"That's it!!", null},
            {"Alright!!", null},
           // {"After hitting once, you do a combo!!", null},
            {"You can change the combo style", "by tapping Up or Down."},
            {"Discover new combos yourself!", ""},
            {"Finally, let's see how", "to use the special attack!"},
            {"It beats all enemies around you.", "Tap Z! Alternatively: Q or 1"},
        },
        {
            {"Yeah! That's it!!!", null},
            {"Beware, this attack takes some", "health when hitting enemies."},
            {"So don't be hasty, bro!", ""},
            {"I've taught you all the basics.", "Now use what you've learnt in game!"},
            {"See you later bro!", null}
        }
    };
    public static final String[][] tutorialHints = {
        null,
        {"( Move: hold the arrow keys )", "( Attack: tap Left / Right )"},
        {"( Get close to the enemy, then attack )", "( Press Left-Left-Left-Left-Left )"},
        {"( Special: press OK twice )", ""}
    };
    
    public static final String[][] tutorialHintsSor2 = {
        null,
        {"( Move: hold the arrow keys )", "( Attack: tap X,W or 2 )"},
        {"( Get close to the enemy, then attack )", "( Press X-X-X-X-X )"},
        {"( Special: press Z, Q or 1 )", ""}
    };
    public static final String[] confirmation = {"Yes", "No"};
    public static final String[] mrXBecomeRightHandQuestion = {"You're no ordinary man.", "Do you want to be my right-hand man?"};
    public static final String[] mrXHappyToOblige = {"You really want to die, don't you?", "I'll be happy to oblige!"};
    public static final String[] mrXPromising = {"Kneel before me!", null};
    public static final String[] mrXKneel = {"Haha, how indomitable you are!", "This is promising..."};
    public static final String[] finalBloodOnHands = {"The blood on these contamined hands", "can't be washed away!"};
    public static final String[] lowScreenOptions = {"", "Yes", "No", "Sound: Off", "Sound: Low", "Sound: Medium", "Sound: High", "Pause", "Continue", "Back", "Retry", "Title Screen", "Web", "Login", "Quit", "", "Police", "Skip", "Vibration: On", "Vibration: Off"};
    public static final String[] miscInformation = {"Loading...", "Axel", "Blaze", "< Level ", " / ", " >", "Are you sure you", "want to quit?", "Yes", "No", "High Scores", " Rank       Score     Level      Dif   Character", "Resume game", "End game", "Help", "End game now?", "You", " has become Mr.X's right hand.", "", "Adam"};
}
