package me.ian.myessentials;

import lombok.Getter;
import me.ian.myessentials.utils.ConsoleColors;

@Getter
public class EconomyManager {

    private static EconomyManager instance;
    public static final String name = "MyEconomyManager";

    private double globalAmount;

    EconomyManager() {
        globalAmount = 0.0;
        MyEssentials.getInstance().getLogger().info(ConsoleColors.WHITE + "    - " + ConsoleColors.WHITE_UNDERLINED + name + ConsoleColors.RESET);
    }

    public static EconomyManager getInstance() {
        if( instance == null ) {
            instance = new EconomyManager();
        }
        return instance;
    }

    public void setGlobalAmount(double amount) {
        this.globalAmount = amount;
    }

    public void addToGlobalAmount(double amount) {
        this.globalAmount += amount;
    }

    public void subFromGlobalCurrency(double amount) {
        this.globalAmount -= amount;
        if (this.globalAmount < 0) {
            this.globalAmount = 0;
        }
    }

}