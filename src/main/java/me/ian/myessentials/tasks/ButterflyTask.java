package me.ian.myessentials.tasks;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public final class ButterflyTask implements Runnable {

    @Getter
    private static final ButterflyTask instance = new ButterflyTask();

    private final Set<UUID> viewers = new HashSet<>();

    private ButterflyTask() {
    }

    @Override
    public void run() {
        for(Player player : Bukkit.getOnlinePlayers())
            if(hasPlayer(player.getUniqueId()))
                generateButterflyWingEffect(player);
    }

    private void generateButterflyWingEffect(Player player) {
        Location location = player.getLocation();

        location.add(location.getDirection().normalize().multiply(-0.5)); // Move behind the player
        location.add(0, 0.85, 0); // Push down to the chest
        location.setPitch(0F); // Stop vertical rotation

        double wingSize = 0.35;
        double circlesAmount = 4;

        for (double degree = 0; degree < 360; degree += 2 /* particle density */) {
            double radians = Math.toRadians(degree);

            double circle = wingSize * Math.pow(Math.E, Math.cos(radians));
            double radius = circle - Math.cos(circlesAmount * radians);

            double x = Math.sin(radians) * radius;
            double z = Math.cos(radians) * radius;

            Vector particleLocation = new Vector(x, 0, z);

            rotateAroundAxisX(particleLocation, -90);
            rotateAroundAxisY(particleLocation, location.getYaw());

            try {
                Particle.DustOptions dust = new Particle.DustOptions(Color.fromRGB(255, 255, 255), 0.6F);
                player.getWorld().spawnParticle(Particle.REDSTONE, location.clone().add(particleLocation), 0, dust);

            } catch (Throwable t) {
                // Not supported
            }
        }
    }

    private void rotateAroundAxisX(Vector vector, double angle) {
        angle = Math.toRadians(angle);

        double cos = Math.cos(angle);
        double sin = Math.sin(angle);
        double y = vector.getY() * cos - vector.getZ() * sin;
        double z = vector.getY() * sin + vector.getZ() * cos;

        vector.setY(y).setZ(z);
    }

    private void rotateAroundAxisY(Vector vector, double angle) {
        angle = -angle;
        angle = Math.toRadians(angle);

        double cos = Math.cos(angle);
        double sin = Math.sin(angle);
        double x = vector.getX() * cos + vector.getZ() * sin;
        double z = vector.getX() * -sin + vector.getZ() * cos;

        vector.setX(x).setZ(z);
    }

    public void addPlayer(UUID uuid) {
        viewers.add(uuid);
    }

    public void removePlayer(UUID uuid) {
        viewers.remove(uuid);
    }

    public boolean hasPlayer(UUID uuid) {
        return viewers.contains(uuid);
    }
}
