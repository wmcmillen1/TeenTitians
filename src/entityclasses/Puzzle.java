package TeenTitians.src.entityclasses;

public class Puzzle {
    private int puzzleLandmark;
    //private boolean isPuzzle;
    private String puzzleDescription;
    private String pButtonDesc;
    private String puzzleSolution;
    private String rewardAccess;

    public Puzzle(String puzzleLandmark) {
        this.puzzleLandmark = Character.getNumericValue(puzzleLandmark.charAt(1));

    }

    public int getPuzzleLandmark() {
        return puzzleLandmark;
    }

    public void setPuzzleLandmark(int puzzleLandmark) {
        this.puzzleLandmark = puzzleLandmark;
    }

//    public boolean isPuzzle() {
//        return isPuzzle;
//    }
//
//    public void setPuzzle(boolean puzzle) {
//        isPuzzle = puzzle;
//    }

    public String getPuzzleDescription() {
        return puzzleDescription;
    }

    public void setPuzzleDescription(String puzzleDescription) {
        this.puzzleDescription = puzzleDescription;
    }

    public String getpButtonDesc() {
        return pButtonDesc;
    }

    public void setpButtonDesc(String pButtonDesc) {
        this.pButtonDesc = pButtonDesc;
    }

    public String getPuzzleSolution() {
        return puzzleSolution;
    }

    public void setPuzzleSolution(String puzzleSolution) {
        this.puzzleSolution = puzzleSolution;
    }

    public String getRewardAccess() {
        return rewardAccess;
    }

    public void setRewardAccess(String rewardAccess) {
        this.rewardAccess = rewardAccess;
    }

    public boolean isPuzzle() {
        if (puzzleLandmark == 1 || puzzleLandmark == 2 || puzzleLandmark == 3 ||puzzleLandmark == 4 ||puzzleLandmark == 5 ||puzzleLandmark == 6 || puzzleLandmark == 7 ||puzzleLandmark == 8) {
            return true;
        }else{
            return false;
        }
    }

    public void setUpPuzzle() {
        if (puzzleLandmark == 1) {
            puzzleDescription = "this is puzzle 1, It is not done (Its really rather complicated)";
            pButtonDesc = "something strange is here1";
        }else if (puzzleLandmark == 2) {
            puzzleDescription = "this is puzzle 2, It is not done (Almost all the others are though... So there's that)";
            pButtonDesc = "something strange is here2";
        }else if (puzzleLandmark == 3) {
            puzzleDescription = "What is soft and yet cannot be slept upon?";
            pButtonDesc = "There is something inscribed beneath the lily pads";
            puzzleSolution = "Water";
            rewardAccess = "SR5";
        }else if (puzzleLandmark == 4) {
            puzzleDescription = "You encounter two friendly strangers\n" +
                    "They begin to speak to you\n" +
                    "Both: “I’m telling the truth; the other tells only lies.”\n" +
                    "\n" +
                    "NPC1: “You do not need every key to reach the second floor.”\n" +
                    "\n" +
                    "NPC2: “Jotaro Kujo is the worst Jojo.”\n" +
                    "\n" +
                    "NPC1: “The wimpy dagger can be upgraded into a powerful weapon.”\n" +
                    "\n" +
                    "NPC2: “You will receive a powerful weapon if you solve this puzzle.”\n" +
                    "\n" +
                    "NPC1: “Griffith did nothing wrong.”\n" +
                    "\n" +
                    "Who is telling the truth?";
            pButtonDesc = "Two people stand in the distance";
            puzzleSolution = "NPC2";
            rewardAccess = "SR2";
        }else if (puzzleLandmark == 5) {
            puzzleDescription = "What can point in every direction but can't reach the destination by itself.";
            pButtonDesc = "Words seem to shimmer in the iridescent fabric";
            puzzleSolution = "Your Finger";
            rewardAccess = "SR1";
        }else if (puzzleLandmark == 6) {
            puzzleDescription = "this is puzzle 6, (HOW ARE WE SUPPOSED TO IMPLEMENT A MAZE?!?, this might take a bit longer than the rest)";
            pButtonDesc = "something strange is here6";
        }else if (puzzleLandmark == 7) {
            puzzleDescription = "A murderer is condemned to death, yet has the rare opportunity to choose the method of his demise. Which room should he choose in order to avoid a grisly fate? \n" +
                    "ROOM 1: A raging fire pit.\n" +
                    "ROOM 2: Full of soldiers with loaded guns.\n" +
                    "ROOM 3: A pit full of hungry lions who haven’t eaten in years.\n";
            pButtonDesc = "A note rests besides the chest";
            puzzleSolution = "ROOM 3";
            rewardAccess = "SR6";
        }else if (puzzleLandmark == 8) {
            puzzleDescription = "16, 06, 68, 88, ?, 98\n" +
                    "What number goes where the ‘?’ is?\n";
            pButtonDesc = "Behind the painting the cracks from a line of numbers";
            puzzleSolution = "78";
            rewardAccess = "SR1";
        }else{
            puzzleDescription = "NOT NULL";
            pButtonDesc = "Nothing unusual here";
        }
    }


    public String implementSolution(String playerSolution) {
        if (playerSolution.equalsIgnoreCase(puzzleSolution)) {
            return "success";
        }else{
            return "fail";
        }

    }
}
