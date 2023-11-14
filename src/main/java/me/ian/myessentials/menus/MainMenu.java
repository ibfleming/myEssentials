package me.ian.myessentials.menus;

import org.mineacademy.fo.menu.Menu;
import org.mineacademy.fo.menu.MenuContainer;
import org.mineacademy.fo.menu.button.Button;
import org.mineacademy.fo.menu.button.ButtonMenu;
import org.mineacademy.fo.menu.button.StartPosition;
import org.mineacademy.fo.menu.button.annotation.Position;
import org.mineacademy.fo.remain.CompMaterial;

public class MainMenu extends Menu {

    private static final int ROW_SIZE = 3;

    @Position(start = StartPosition.CENTER, value = -2)
    private final Button healButton;

    @Position(start = StartPosition.CENTER)
    private final Button armorButton;

    @Position(start = StartPosition.CENTER, value = 2)
    private final Button flyButton;

    public MainMenu() {
        setSlotNumbersVisible();
        setTitle("&cMain Menu");
        setSize(9 * ROW_SIZE);

        this.healButton = new ButtonMenu(new HealMenu(), CompMaterial.GOLDEN_APPLE,
                "&6Heal",
                "",
                "Click to open the menu");

        this.armorButton = new ButtonMenu(new ArmorMenu(), CompMaterial.LEATHER_HELMET,
                "&6Armor",
                "",
                "Click to open the menu");

        this.flyButton = new ButtonMenu(new FlyMenu(), CompMaterial.FEATHER,
                "&6Fly",
                "",
                "Click to open the menu");
    }

    private class HealMenu extends Menu {
        HealMenu() {
            super(MainMenu.this);

            setTitle("&8Heal");
            setSize(9 * ROW_SIZE);
        }
    }
    private class ArmorMenu extends Menu {
        ArmorMenu() {
            super(MainMenu.this);

            setTitle("&8Armor");
            setSize(9 * ROW_SIZE);
        }
    }
    private class FlyMenu extends Menu {
        FlyMenu() {
            super(MainMenu.this);

            setTitle("&8Fly");
            setSize(9 * ROW_SIZE);
        }
    }
}
