package net.teamfruit.sushida.listener;

import net.teamfruit.sushida.Sushida;
import net.teamfruit.sushida.player.PlayerData;
import net.teamfruit.sushida.player.state.IState;
import org.bukkit.scheduler.BukkitRunnable;

public class TickEventGenerator extends BukkitRunnable {
    @Override
    public void run() {
        Sushida.logic.states.removeOfflinePlayers();
        Sushida.logic.states.getPlayers().stream()
                .filter(PlayerData::hasSession)
                .map(PlayerData::getSession)
                .forEach(e -> e.apply(IState::onTick));
    }
}
