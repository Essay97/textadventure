package setup;

import entities.GameMap;
import entities.GrabbableItem;
import entities.Item;
import entities.Room;
import entities.people.FighterNPC;
import entities.people.TalkerNPC;
import utils.Input;

public class DummyMapBuildStrategy implements MapBuildStrategy {

    @Override
    public GameMap build() {
        GameMap map = new GameMap();
        Room kitchen = new Room("Kitchen", "A room with lots of food. N: courtyard");
        Room courtyard = new Room("Courtyard", "A breath of fresh air. E: forest, S: kitchen");
        Room forest = new Room("Forest", "A place with a lot of trees. W: courtyard");

        kitchen.addItem(new GrabbableItem("coins", "a bag with some coins inside"));
        kitchen.addItem(new GrabbableItem("spoon", "this is just a spoon..."));
        forest.addItem(new Item("tree", "the forest is full of trees"));

        TalkerNPC mum = new TalkerNPC("mum", "She's your mum. Seems like she has something to tell you.");
        kitchen.getNpcs().add(mum);
        mum.getMatchers().add("my mum");
        mum.setDialogue(() -> {
            System.out.println("MUM: Hey, I was looking for you! Where are you going?");
            String[] choices = {"I'm staying at home", "I'll go in the forest"};
            for(int i = 0; i < choices.length; i++) {
                System.out.println("\t"+(i+1)+" - "+choices[i]);
            }
            int choice;
            while(true) {
                try {
                    String input = Input.prompt();
                    choice = Integer.parseInt(input);
                    System.out.println("YOU: "+choices[choice-1]);
                    System.out.println("MUM: Ok then, watch out!");
                    break;
                } catch (Exception e) {
                    System.out.println("Choose one from the options!");
                }
            }
        });

        FighterNPC thief = new FighterNPC("thief", "This person is clearly dangerous for you, pay attention!",
                6, 20);
        forest.getNpcs().add(thief);

        map.addRoom(kitchen);
        map.setN(kitchen, courtyard);
        map.setE(courtyard, forest);
        map.setS(courtyard, kitchen);
        map.setW(forest, courtyard);
        return map;
    }

}
