package me.ian.myessentials.models;

import io.papermc.paper.threadedregions.scheduler.ScheduledTask;
import me.ian.myessentials.MyEssentials;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitTask;

public final class Scheduler {

    private static final boolean isFolia = Bukkit.getVersion().contains("Folia");

    public static void run(Runnable runnable) {
        if (isFolia)
            Bukkit.getGlobalRegionScheduler()
                    .execute(MyEssentials.getInstance(), runnable);

        else
            Bukkit.getScheduler().runTask(MyEssentials.getInstance(), runnable);
    }

    public static Task runLater(Runnable runnable, long delayTicks) {
        if (isFolia)
            return new Task(Bukkit.getGlobalRegionScheduler()
                    .runDelayed(MyEssentials.getInstance(), t -> runnable.run(), delayTicks));

        else
            return new Task(Bukkit.getScheduler().runTaskLater(MyEssentials.getInstance(), runnable, delayTicks));
    }

    public static Task runTimer(Runnable runnable, long delayTicks, long periodTicks) {
        if (isFolia)
            return new Task(Bukkit.getGlobalRegionScheduler()
                    .runAtFixedRate(MyEssentials.getInstance(), t -> runnable.run(), delayTicks < 1 ? 1 : delayTicks, periodTicks));

        else
            return new Task(Bukkit.getScheduler().runTaskTimer(MyEssentials.getInstance(), runnable, delayTicks, periodTicks));
    }

    public static boolean isFolia() {
        return isFolia;
    }

    public static class Task {

        private Object foliaTask;
        private BukkitTask bukkitTask;

        Task(Object foliaTask) {
            this.foliaTask = foliaTask;
        }

        Task(BukkitTask bukkitTask) {
            this.bukkitTask = bukkitTask;
        }

        public void cancel() {
            if (foliaTask != null)
                ((ScheduledTask) foliaTask).cancel();
            else
                bukkitTask.cancel();
        }
    }
}