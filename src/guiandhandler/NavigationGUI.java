package TeenTitians.src.guiandhandler;

import TeenTitians.src.Game;
import TeenTitians.src.entityclasses.Puzzle;
import TeenTitians.src.entityclasses.Room;
import TeenTitians.src.entityclasses.gameentities.Monster;
import TeenTitians.src.entityclasses.itemclasses.Armor;
import TeenTitians.src.entityclasses.itemclasses.Consumable;
import TeenTitians.src.entityclasses.itemclasses.Item;
import TeenTitians.src.entityclasses.itemclasses.Weapons;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
//NavigationGUI by Wesley;


public class NavigationGUI {

    Game game = new Game();

    PuzzleGUI pGUI;
    Monster spawnedMonster;

    protected JFrame frame;
    protected JPanel mainTextP, statsP, cmdLineP,inventoryP, mapP, loginP, loginTP, loginPP;
    protected JTextArea mainTextA, statsTA, inventoryTA, titleCard, loginTA, loginPA;
    protected JTextField cmdLineTF, loginTF;
    protected JPasswordField loginPF;
    protected JButton showExits, searchItem, searchPuzzle, back;
    protected Container con;
    private Font font = new Font("Times new Roman", Font.PLAIN, 24);

    protected BufferedImage map1;
    protected BufferedImage map2;

    public boolean showingExits = false;
    private boolean hasPuzzlebeenlaunched = false;
    private boolean hasMonsterSpawned;
    private boolean showingItem = false;
    private boolean isInventoryOpen = false;
    private boolean usingItems = false;
    private boolean equiping = false;
    private boolean unequiping = false;
    private boolean examining = false;


    //GUIHandler guiHandler;


        public NavigationGUI() {
 //FRAME
            frame = new JFrame();
            frame.setSize(1600,800);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().setBackground(Color.black);
            frame.setLayout(null);

            con = frame.getContentPane();
//LOGIN PANEL
            loginP = new JPanel(new GridLayout(3,1));
            loginP.setBounds(600, 200, 300,200);
            loginP.setBackground(Color.BLACK);
    //Title Card
            titleCard = new JTextArea("Phylactery");
            titleCard.setBackground(Color.BLACK);
            titleCard.setForeground(Color.white);
            titleCard.setFont(new Font("Algerian", Font.BOLD, 44));
    //Login Text Panel
            loginTP = new JPanel();
            loginTP.setBackground(Color.BLACK);
        //Login Username
            loginTA = new JTextArea("Username");
            loginTA.setBackground(Color.BLACK);
            loginTA.setForeground(Color.white);
            loginTA.setFont(font);
        //Login Text Field
            loginTF = new JTextField(30);
            loginTF.setHorizontalAlignment(JTextField.CENTER);
            loginTF.setForeground(Color.BLACK);
            loginTF.setFont(font);

    //Login Password
            loginPP = new JPanel();
            loginPP.setBackground(Color.BLACK);
        //Login Password
            loginPA = new JTextArea("Password");
            loginPA.setBackground(Color.BLACK);
            loginPA.setForeground(Color.white);
            loginPA.setFont(font);
        //Login Password Field
            loginPF = new JPasswordField(30);
            loginPF.setHorizontalAlignment(JPasswordField.CENTER);
            loginPF.setForeground(Color.BLACK);
            loginPF.setFont(font);
        //PASSWORD ACTIONLISTENER
            loginPF.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (!("".equals(loginTF) || "".equals(loginPF))) {
                        game.login.setUserName(loginTF.getText());
                        game.login.setPassword(String.valueOf(loginPF.getPassword()));
                        mainTextP.setVisible(true);
                        inventoryP.setVisible(true);
                        cmdLineP.setVisible(true);
                        statsP.setVisible(true);

                        loginP.setVisible(false);
                    }
                }
            });



//MAIN TEXT PANEL
            mainTextP = new JPanel(new GridLayout(4,1));
            mainTextP.setBounds(0,0,1080,640);
            mainTextP.setBackground(Color.black);

            mainTextP.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(Color.white,2), BorderFactory.createEtchedBorder(Color.white,Color.GRAY)));
     //Main Text Area
            mainTextA = new JTextArea(game.room.getDecription());
            mainTextA.setBounds(0,0,900,600);
            mainTextA.setLineWrap(true);
            mainTextA.setBackground(Color.black);
            mainTextA.setForeground(Color.white);
            mainTextA.setFont(font);


//INVENTORY PANEL
            inventoryP = new JPanel();
            inventoryP.setBounds(1077,0, 500, 745);
            inventoryP.setBackground(Color.BLACK);
            inventoryP.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(Color.white,2), BorderFactory.createEtchedBorder(Color.white,Color.GRAY)));
    //Inventory Text Area
            inventoryTA = new JTextArea("Inventory");
            inventoryTA.setBackground(Color.BLACK);
            inventoryTA.setForeground(Color.white);
            inventoryTA.setFont(font);
            inventoryTA.append("\n" + game.inventory.getInventory().toString());


//CMD LINE PANEL
            cmdLineP = new JPanel();
            //cmdLineP.setBounds(-12, 1000, 1000, 80);
            cmdLineP.setBackground(Color.black);
            cmdLineP.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(Color.white,2), BorderFactory.createEtchedBorder(Color.white,Color.GRAY)));

    //Show Exits Button
            showExits = new JButton("Show Exits");
            showExits.setBackground(Color.black);
            showExits.setForeground(Color.white);
            showExits.setFont(font);
        //Show Exits ActionListener
            showExits.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    showExits();
                }
            });
            showExits.setFocusPainted(true);
            showExits.setActionCommand("showExits");
    //CMD Line Text Field
            cmdLineTF = new JTextField(59);
            cmdLineTF.setBackground(Color.black);
            cmdLineTF.setForeground(Color.white);
            cmdLineTF.setFont(font);
            cmdLineTF.addActionListener(new ActionListener() {
                @Override
        //CMD Line ActionListener
                public void actionPerformed(ActionEvent e) {
                    //IF the GUI is currently showing exits, then feed player input into the ExitRoom method and
                    //switch back to normal
                    if (showingExits) {
                        game.room = game.room.exitRoom(cmdLineTF.getText());
                        spawnedMonster = monsterSpawner();
                        if (spawnedMonster == null) {
                            mainTextA.setText(game.room.enterRoom(game.room));
                        } else {
                            mainTextA.setText(game.room.enterRoom(game.room) + "\n" + "\n" + spawnedMonster.getDescription());
                        }
                        showExits.setVisible(true);
                        statsP.setVisible(true);
                        cmdLineTF.setText("");
                        game.puzzle = new Puzzle(game.room.getPuzzleLandmark());
                        showingExits = false;
                        back.setVisible(false);
                    }else if (usingItems) {
                        cmdLineTF.setText(use(cmdLineTF.getText()));
                        usingItems = false;
                        cmdLineTF.setText("");
                        resetStats();
                    }else if (equiping) {
                        equiping = false;
                        cmdLineTF.setText(equip(cmdLineTF.getText()));
                        cmdLineTF.setText("");
                        resetStats();
                    }else if (examining){
                        mainTextA.setText(examine(cmdLineTF.getText()));
                        cmdLineTF.setText("");
                    }else{
                        String input = cmdLineTF.getText();
                        switch (input) {
                            case "/search":
                                search();
                                cmdLineTF.setText("");
                                break;
                            case "/save":
                                game.login.readInfoValue(game.room.getRoomID(), game.inventory.getInventory().toString());
                                mainTextA.setText("Game Saved");
                                back.setVisible(true);
                                showExits.setVisible(false);
                                break;
                            case "/load":
                                load(game.login.loadvalue());
                                mainTextA.setText("Game Loaded");
                                back.setVisible(true);
                                showExits.setVisible(false);
                                break;
                            case "/attack":
                                if (hasMonsterSpawned) {
                                    int oldPHP = game.player.getCurrentHealth();
                                    int oldMHP = spawnedMonster.getCurrentHealth();
                                    boolean didHit = spawnedMonster.playerAttackHit(game.player.getAccuracy());
                                    int attack = spawnedMonster.attack(game.player.getHealth(),game.player.getCurrentHealth(),game.player.getSpeed(), didHit, game.player.getAttack());
                                    game.player.takeDamage(attack);
                                    int newPHP = game.player.getCurrentHealth();
                                    int newMHP = spawnedMonster.getCurrentHealth();
                                    int pHPD = oldPHP - newPHP;
                                    int mHPD = oldMHP - newMHP;
                                    if (game.player.getCurrentHealth() <= 0) {
                                        mainTextA.setText("You have been struck down");
                                        game.room = game.room.exitRoom("R1");
                                    }else if (spawnedMonster.getCurrentHealth() > 0) {
                                        mainTextA.setText("You clash furiously with the " + spawnedMonster.getName() + "\n" +
                                                "you take " + pHPD + " damage and deal " + mHPD + " damage. \n" +
                                                "the " + spawnedMonster.getName() + " has " + spawnedMonster.getCurrentHealth() + " HP left");
                                        resetStats();

                                    }else{
                                        mainTextA.setText("You clash furiously with the " + spawnedMonster.getName() +"\n" +
                                                "You take " + pHPD + " damage and deal " + mHPD + " damage. \n" +
                                                "The " + spawnedMonster.getName() + " has been struck down");
                                        resetStats();
                                    }
                                }else{
                                    mainTextA.setText("you clash furiously with the air... \n" +
                                            "Surprisingly, nothing happens");
                                }
                                back.setVisible(true);
                                showExits.setVisible(false);
                                break;
                            case "/block":
                                if (hasMonsterSpawned) {
                                    int oldPHP = game.player.getCurrentHealth();
                                    int oldMHP = spawnedMonster.getCurrentHealth();
                                    boolean didHit = spawnedMonster.playerAttackHit(game.player.getAccuracy());
                                    int attack = spawnedMonster.attack(game.player.getHealth(),game.player.getCurrentHealth(),game.player.getSpeed(), didHit, game.player.getAttack());
                                    game.player.defend();
                                    game.player.takeDamage(attack);
                                    int newPHP = game.player.getCurrentHealth();
                                    int newMHP = spawnedMonster.getCurrentHealth();
                                    int pHPD = oldPHP - newPHP;
                                    int mHPD = oldMHP - newMHP;
                                    mainTextA.setText("You defend yourself from the " + spawnedMonster.getName() +"\n" +
                                            "you take " + pHPD + " damage. \n" +
                                            "the " + spawnedMonster.getName() + " has " +spawnedMonster.getCurrentHealth() + " HP left");
                                    resetStats();
                                }else{
                                    mainTextA.setText("you defend your self against the air... \n" +
                                            "surprisingly, nothing happens");
                                }
                                back.setVisible(true);
                                showExits.setVisible(false);
                                break;
                            case "/help":
                                mainTextA.setText("/search, /save, /load, /attack, /block, /inventory, /help  \n" +
                                        "When in inventory, /use, /equip /unequip /drop /examine\n" +
                                        "When searching for items, /pickup \n" +
                                        "While Showing Exits, type R(room number) or SR(room number");
                                back.setVisible(true);
                                showExits.setVisible(false);
                                break;
                            case "/inventory":
                                mainTextA.setText(inventoryTA.getText());
                                inventoryP.setVisible(false);
                                isInventoryOpen = true;
                                cmdLineTF.setText("");
                                back.setVisible(true);
                                break;
                            case "/use":
                                if (isInventoryOpen) {
                                    mainTextA.append("\n Use which item?");
                                    usingItems = true;
                                }
                                break;
                            case "/equip":
                                if (isInventoryOpen) {
                                    mainTextA.append("\n Equip which item?");
                                    equiping = true;
                                }
                            case "/unequip":
                                if (isInventoryOpen) {
                                    unequip();
                                    resetStats();
                                }
                                break;
                            case "/pickup":
                                if (showingItem) {
                                    mainTextA.setText(pickUp(mainTextA.getText()));
                                }
                                break;
                            case "/examine":
                                examining = true;
                                break;
                            default:
                                mainTextA.setText("Invalid Command\n" +
                                        "Use /help to retrive a list of available commands");
                                back.setVisible(true);
                                showExits.setVisible(false);
                        }
                    }
                }
            });

    //Search Item Button
            searchItem = new JButton("");

            searchItem.setBackground(Color.BLACK);
            searchItem.setForeground(Color.white);
            searchItem.setFont(font);
            if (!game.room.getItems().isEmpty()){
                searchItem.setText("You find some items");
            }else{
                searchItem.setText("The room is empty of anything useful");
            }
        //Search Item ActionListener
            searchItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (!game.room.getItems().isEmpty()){
                        showItems();
                        showingItem = true;
                        searchItem.setVisible(false);
                        searchPuzzle.setVisible(false);
                    }
                }
            });

    //Search Puzzle Button
            searchPuzzle = new JButton("");

            searchPuzzle.setBackground(Color.BLACK);
            searchPuzzle.setForeground(Color.white);
            searchPuzzle.setFont(font);
        //Search Puzzle ActionListener
            searchPuzzle.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (game.puzzle.isPuzzle()) {
                        pGUI = new PuzzleGUI(game.room.getPuzzleLandmark(), game.room.getRoomID());
                        hasPuzzlebeenlaunched = true;
                    }
                }
            });

    //Back Button
            back = new JButton("Back");

            back.setBackground(Color.BLACK);
            back.setForeground(Color.white);
            back.setFont(font);
            back.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    mainTextA.setText(game.room.getDecription());
                    showExits.setVisible(true);
                    statsP.setVisible(true);
                    cmdLineTF.setText("");
                    inventoryP.setVisible(true);
                    back.setVisible(false);
                    searchPuzzle.setVisible(false);
                    searchItem.setVisible(false);
                    showingItem = false;
                    showingExits = false;
                    isInventoryOpen = false;
                }
            });

//STATS PANEL
            statsP = new JPanel();
            statsP.setBounds(0,640, 1300,120);
            statsP.setBackground(Color.black);
            statsP.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(Color.white,2), BorderFactory.createEtchedBorder(Color.white,Color.GRAY)));

    //Stats Text Area
            statsTA = new JTextArea("HP:" + game.player.getCurrentHealth()+"/"+game.player.getHealth()+
                    "\n Atk:" + game.player.getAttack() + " Def:" + game.player.getDefense() +
                    "\n Spd:" + game.player.getSpeed() +" Acc:" + game.player.getAccuracy() + "%\n ");
            statsTA.setBounds(0,0,900,80);
            statsTA.setLineWrap(true);
            statsTA.setBackground(Color.black);
            statsTA.setForeground(Color.white);
            statsTA.setFont(font);


//COMPONENTS ADD

    //Main Text Components
            mainTextP.add(mainTextA);
            mainTextP.add(searchItem);
            mainTextP.add(searchPuzzle);
            con.add(mainTextP);
    //Inventory Components
            inventoryP.add(inventoryTA);
            con.add(inventoryP);
    //CMD Line Components
            cmdLineP.add(cmdLineTF);
            cmdLineP.add(showExits);
            cmdLineP.add(back);
            mainTextP.add(cmdLineP);
    //Stats Components
            statsP.add(statsTA);
            con.add(statsP);
    //Login Components
            loginP.add(titleCard);

            loginTP.add(loginTA);
            loginTP.add(loginTF);
            loginP.add(loginTP);

            loginPP.add(loginPA);
            loginPP.add(loginPF);
            loginP.add(loginPP);

            con.add(loginP);
//COMPONENTS SET VISIBLE
            frame.setVisible(true);
    //LOGIN
            loginP.setVisible(true);
    //MAIN TEXT
            mainTextP.setVisible(false);
            searchItem.setVisible(false);
            searchPuzzle.setVisible(false);
    //INVENTORY
            inventoryP.setVisible(false);
    //CMD LINE
            cmdLineP.setVisible(false);
            back.setVisible(false);
    //STATS
            statsP.setVisible(false);

        }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JPanel getMainTextP() {
        return mainTextP;
    }

    public void setMainTextP(JPanel mainTextP) {
        this.mainTextP = mainTextP;
    }

    public JPanel getStatsP() {
        return statsP;
    }

    public void setStatsP(JPanel statsP) {
        this.statsP = statsP;
    }

    public JPanel getCmdLineP() {
        return cmdLineP;
    }

    public void setCmdLineP(JPanel cmdLineP) {
        this.cmdLineP = cmdLineP;
    }

    public JTextArea getMainTextA() {
        return mainTextA;
    }

    public void setMainTextA(String text) {
        this.mainTextA.setText(text);
    }

    public JTextArea getStatsTA() {
        return statsTA;
    }

    public void setStatsTA(JTextArea statsTA) {
        this.statsTA = statsTA;
    }

    public JTextField getCmdLineTF() {
        return cmdLineTF;
    }

    public void setCmdLineTF(JTextField cmdLineTF) {
        this.cmdLineTF = cmdLineTF;
    }

    public Container getCon() {
        return con;
    }

    public void setCon(Container con) {
        this.con = con;
    }


    public void showExits() {
        if (hasPuzzlebeenlaunched) {
            game.room.setExitList(pGUI.game.room.getExitList());
            hasPuzzlebeenlaunched = false;
        }

            String exitText = "";
        for (int i = 0; i < game.room.getExitList().length; i++) {
            exitText += game.room.getExitList()[i] + ", ";
        }
        mainTextA.setText(exitText);
        showExits.setVisible(false);
        showingExits = true;
        back.setVisible(true);
    }

    public void search() {

        game.puzzle.setUpPuzzle();
        searchPuzzle.setVisible(true);
        searchItem.setVisible(true);
        back.setVisible(true);
        showExits.setVisible(false);
        searchPuzzle.setText(game.puzzle.getpButtonDesc());
    }

    public Monster monsterSpawner() {
        Monster monster1 = new Monster();
        Monster monster2 = new Monster();
        Monster monster3 = new Monster();
        Monster monster4 = new Monster();

        boolean does1spawn = false;
        boolean does2spawn = false;
        boolean does3spawn = false;
        boolean does4spawn = false;

        String monsterList = game.room.getMonsters().replace(" ", "");

        if ("None".equals(monsterList)) {
            return null;
        }else {
            String[] monstersList = monsterList.split(","); //Splits the Monsters value into into each individuial ID

            for (int i = 0; i < monstersList.length; i++) {
                switch (i) {
                    case 0: monster1 = monster1.makeMonster(monstersList[i]); break;  //Runs through the monsterList, instantiating the first ID as the appropirate monster,
                    case 1: monster2 = monster2.makeMonster(monstersList[i]); break;  //instantiates the second ID as the appropiate monster
                    case 2: monster3 = monster3.makeMonster(monstersList[i]); break;  //etc
                    case 3: monster4 = monster4.makeMonster(monstersList[i]); break;  //etc
                }

            }

            for (int i = 0; i < monstersList.length; i++) {
                switch (i) {
                    case 0: does1spawn = monster1.spawnMonster(); break; //Runs the monsterSpawn method and grabs the resulting boolean.
                    case 1: does2spawn = monster2.spawnMonster(); break;
                    case 2: does3spawn = monster3.spawnMonster(); break;
                    case 3: does4spawn = monster4.spawnMonster(); break;
                }
            }
            if (does1spawn) {       //works through the booleans to decide which one to spawn. Priority is given to the first in the list,
                hasMonsterSpawned = true;
                return monster1;    //which equates to the toughest monster that can spawn in that room.
            }else if (does2spawn) {
                hasMonsterSpawned = true;
                return monster2;
            }else if (does3spawn) {
                hasMonsterSpawned = true;
                return monster3;
            }else if (does4spawn) {
                hasMonsterSpawned = true;
                return monster4;
            }else{
                return null;
            }
        }
    }

    public void load(String loadInput) {
        if (loadInput.isEmpty()) {
            cmdLineTF.setText("Please Save before loading");
        }else {
            String input[] = loadInput.split("/");
            for (int i = 0; i < input.length; i++) {
                System.out.println("Array:-" + input[i] + "-");
            }
            game.room = game.room.exitRoom(input[0]);
            ArrayList<String> temp = new ArrayList<>();
            input[1].replace("[", "");
            input[1].replace("]", "");
            String[] inventoryInput = input[1].split(",");
            for (int i = 0; i < inventoryInput.length; i++) {
                temp.add(inventoryInput[i]);
            }

            game.inventory.setInventory(temp);
        }



    }

    public void showItems() {
        String itemList = game.room.getItems();
        itemList.replace(" ", "");
        Item item1 = new Item();
        Item item2 = new Item();
        Item item3 = new Item();
        Item item4 = new Item();
        Item item5 = new Item();

        String[] itemsList = itemList.split(",");

        for (int i = 0; i < itemsList.length; i++) {
            System.out.println("Just Checking:-" + itemsList[i] +"-");
            switch (i) {
                case 0: item1 = item1.makeItem(itemsList[i]); break;  //Runs through the itemsList, instantiating the first ID as the appropirate item,
                case 1: item2 = item2.makeItem(itemsList[i]); break;  //instantiates the second ID as the appropiate item
                case 2: item3 = item3.makeItem(itemsList[i]); break;  //etc
                case 3: item4 = item4.makeItem(itemsList[i]); break;  //etc
                case 4: item5 = item5.makeItem(itemsList[i]); break;
            }

        }
        String name1 = "";
        String name2 = "";
        String name3 = "";
        String name4 = "";
        String name5 = "";

        if (!item1.getName().equals("")) {
            name1 = item1.getName() + ",";
        }
        if (!item2.getName().equals("")){
            name2 = item2.getName() + ",";
        }
        if (!item3.getName().equals("")) {
            name3 = item3.getName() + ",";
        }
        if (!item4.getName().equals("")) {
            name4 = item4.getName() + ",";
        }
        if (!item5.getName().equals("")) {
            name5 = item5.getName();
        }

        mainTextA.setText(name1 + name2 + name3 + name4 + name5);
        showingItem = true;
    }

    public String pickUp(String itemList) {
        String[] itemsList = itemList.split(",");
        String newText = "";

        if (game.inventory.getInventory().contains(itemsList[0])) {
            for (int i = 1; i < itemsList.length; i++) {
                newText += itemsList[i];
            }
            newText += itemsList[0];
            cmdLineTF.setText("Already have one of those");
            return newText;

        }else {
            game.inventory.addToInventory(itemsList[0]);
            inventoryTA.append("\n" + itemsList[0]);

            for (int i = 1; i < itemsList.length; i++) {
                newText += itemsList[i] + ", ";
            }
            return newText;
        }
    }
    public String use(String itemName) {
        Consumable c = new Consumable();
            if (game.inventory.getInventory().contains(itemName)) {
                if (game.inventory.getInventoryMap().containsKey(itemName)) {
                    String itemID = game.inventory.getInventoryMap().get(itemName);
                    switch (itemID) {
                        case "A1":
                        case "A2":
                        case "A3":
                        case "A4":
                        case "A5":
                        case "A6":
                        case "A7":
                        case "A8":
                        case "A16":
                        case "A26":
                            game.inventory.removeFromInventory(itemName);
                            c = (Consumable) c.makeItem(itemID);
                            if ((c.getRecoverHealth() + game.player.getCurrentHealth()) < game.player.getHealth()) {
                                game.player.setCurrentHealth(game.player.getCurrentHealth() + c.getRecoverHealth());
                                return "you recover " + c.getRecoverHealth() + " HP!";
                            } else {
                                int difference = (c.getRecoverHealth() + game.player.getCurrentHealth() - game.player.getHealth());
                                game.player.setCurrentHealth(game.player.getCurrentHealth() + difference);
                                return "you recover " + difference + " HP!";
                            }
                        default:
                            return "Item not usable";

                    }
                }else {
                    return "Invaild Item Name";
                }
            }else{
                return "You don't have that Item";
            }
    }
    public String equip(String itemName) {
        Armor a = new Armor();
        Weapons w = new Weapons();
        if (game.inventory.getInventory().contains(itemName)) {
            if (game.inventory.getInventoryMap().containsKey(itemName)) {
                String itemID = game.inventory.getInventoryMap().get(itemName);
                switch (itemID) {
                    case "A9":
                    case "A10":
                    case "A11":
                    case "A12":
                    case "A13":
                    case "A14":
                    case "A15":
                    case "A23":
                    case "A28":
                        w = (Weapons) w.equip(itemID);
                        game.player.setAttack(15);
                        game.player.setAttack(game.player.getAttack() + w.getDamage());
                        game.player.setAccuracy(33);
                        game.player.setAccuracy(game.player.getAccuracy() + w.getAccuracy());
                        game.player.setSpeed(33);
                        game.player.setSpeed(game.player.getSpeed() + w.getSpeed());
                        game.player.setDefense(25);
                        game.player.setDefense(game.player.getDefense() + w.getDefence());
                        return "Successfully Equiped!";
                    case "A17":
                    case "A18":
                    case "A19":
                    case "A20":
                    case "A21":
                    case "A22":
                    case "A24":
                    case "A25":
                        a = (Armor) a.equip(itemID);
                        game.player.setHealth(75);
                        game.player.setHealth(game.player.getHealth() + a.getHP());
                        game.player.setAccuracy(33);
                        game.player.setAccuracy(game.player.getAccuracy() + a.getAccuracy());
                        game.player.setSpeed(33);
                        game.player.setSpeed(game.player.getSpeed() + a.getSpeed());
                        game.player.setDefense(25);
                        game.player.setDefense(game.player.getDefense() + a.getDefence());
                        return "Successfully equipped!";
                    default:
                        return "Item not usable";

                }
            }else{
                return "Invalid Name";
            }
        }else{
            return "You don't have that Item";
        }
    }

    public String unequip() {
            game.player.setHealth(75);
            game.player.setAttack(15);
            game.player.setDefense(25);
            game.player.setSpeed(33);
            game.player.setAccuracy(33);
            return "All Item Unequiped";

    }

    public String examine(String itemName) {
            if (game.inventory.getInventoryMap().containsKey(itemName)) {
                Item item = new Item();
                item = item.makeItem(game.inventory.getInventoryMap().get(itemName));
                return item.getDescription();
            }else {
                return "Invalid Item Name";
            }

    }
    public void resetStats() {
        statsTA.setText("HP:" + game.player.getCurrentHealth()+"/"+game.player.getHealth()+
                "\n Atk:" + game.player.getAttack() + " Def:" + game.player.getDefense() +
                "\n Spd:" + game.player.getSpeed() +" Acc:" + game.player.getAccuracy() + "%\n ");
    }
}

