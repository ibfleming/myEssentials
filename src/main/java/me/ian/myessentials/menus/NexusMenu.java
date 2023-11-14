package me.ian.myessentials.menus;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;
import org.mineacademy.fo.menu.Menu;
import org.mineacademy.fo.menu.button.Button;
import org.mineacademy.fo.menu.button.StartPosition;
import org.mineacademy.fo.menu.button.annotation.Position;
import org.mineacademy.fo.menu.model.ItemCreator;
import org.mineacademy.fo.remain.CompChatColor;
import org.mineacademy.fo.remain.CompMaterial;

public class NexusMenu extends Menu {
    private static final int SIZE = 3;

    @Position(start = StartPosition.CENTER, value = -3)
    private final Button lobbyButton;

    @Position(start = StartPosition.CENTER, value = -1)
    private final Button marketButton;

    @Position(start = StartPosition.CENTER, value = 1)
    private final Button userButton;

    @Position(start = StartPosition.CENTER, value = 3)
    private final Button spawnButton;

    public NexusMenu() {
        setTitle(CompChatColor.DARK_GRAY + "Nexus");
        setSize(9 * SIZE);

        this.addInfoButton();
        this.getInfo();

        this.lobbyButton = new Button() {
            @Override
            public void onClickedInMenu(Player player, Menu menu, ClickType click) {
            }

            @Override
            public ItemStack getItem() {
                return ItemCreator.of(CompMaterial.NETHER_STAR, "Lobby", "", "Teleport to Lobby.")
                        .glow(true)
                        .make();
            }
        };

        this.marketButton = new Button() {
            @Override
            public void onClickedInMenu(Player player, Menu menu, ClickType click) {
            }

            @Override
            public ItemStack getItem() {
                return ItemCreator.of(CompMaterial.GOLD_NUGGET, "Marketplace", "", "Teleport to the marketplace.")
                        .glow(true)
                        .make();
            }
        };

        this.userButton = new Button() {
            @Override
            public void onClickedInMenu(Player player, Menu menu, ClickType click) {
            }

            @Override
            public ItemStack getItem() {
                return ItemCreator.of(CompMaterial.RED_BED, "My Locations", "", "Teleport to your locations.")
                        .glow(true)
                        .make();
            }
        };

        this.spawnButton = new Button() {
            @Override
            public void onClickedInMenu(Player player, Menu menu, ClickType click) {
                World world = Bukkit.getWorlds().get(0);
                if( world != null ) {
                    Location spawnLoc = Bukkit.getWorlds().get(0).getSpawnLocation();
                    player.teleport(spawnLoc);
                }
            }

            @Override
            public ItemStack getItem() {
                return ItemCreator.of(CompMaterial.OAK_LEAVES, "Spawn", "", "Teleport to the world spawn point.")
                        .make();
            }
        };
    }

    public static void showTo(Player player) {
        new NexusMenu().displayTo(player);
    }
}
