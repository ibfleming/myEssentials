package me.ian.myessentials.tasks;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class SpiralTask implements Runnable {

    @Getter
    private static final SpiralTask instance = new SpiralTask();

    private final Set<UUID> viewers = new HashSet<>();

    private SpiralTask() {
    }

    @Override
    public void run() {
        for(Player player : Bukkit.getOnlinePlayers())
            if(hasPlayer(player.getUniqueId()))
                generateSpiral(player);
    }

    // Particle Parameters
    public int strands = 10;
    public int particles = 80;
    public float radius = 5;
    public float curve = 10;
    public double rotation = Math.PI/4;

    private void generateSpiral(Player player) {
        Location location = player.getLocation();

        for(int i = 1; i <= strands; i++) {
            for(int j = 1; j <= particles; j++) {
                float ratio = (float) j / particles;
                double angle = curve * ratio * 2 * Math.PI / strands + (2 * Math.PI * i / strands) + rotation;
                double x = Math.cos(angle) * ratio * radius;
                double z = Math.sin(angle) * ratio * radius;
                location.add(x, 0, z);
                try {
                    Particle.DustOptions dust = new Particle.DustOptions(Color.fromRGB(255, 229, 204), 0.5F);
                    player.getWorld().spawnParticle(Particle.FLAME, location, 0, null);

                } catch (Throwable t) {
                    // Not supported
                }
                location.subtract(x, 0, z);
            }
        }

        /*
        double radius = 1;
        for(double y = 0; y <= 10; y += 0.05) {
            double x = radius * Math.cos(y) * 0.5;
            double z = radius * Math.sin(y) * 0.5;

            Vector particleLocation = new Vector(x, y, z);

            try {
                Particle.DustOptions dust = new Particle.DustOptions(Color.fromRGB(255, 229, 204), 0.6F);
                player.getWorld().spawnParticle(Particle.REDSTONE, location.clone().add(particleLocation), 0, dust);

            } catch (Throwable t) {
                // Not supported
            }

        }*/
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
