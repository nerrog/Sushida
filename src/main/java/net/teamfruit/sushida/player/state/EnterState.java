package net.teamfruit.sushida.player.state;

import com.destroystokyo.paper.Title;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.teamfruit.sushida.player.StateContainer;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Player;

public class EnterState implements IState {
    @Override
    public IState onEnter(StateContainer state) {
        Player player = state.data.player;

        player.sendTitle(new Title(
                new ComponentBuilder("Enter").bold(true).color(ChatColor.RED).create(),
                new ComponentBuilder("エンターキーを押してください").bold(false).color(ChatColor.GREEN).create(),
                0, 10000, 0));

        player.playSound(player.getLocation(), "sushida:sushida.poke", SoundCategory.PLAYERS, 1, 1);

        return null;
    }

    @Override
    public IState onType(StateContainer state, String typed, String buffer) {
        if ("".equals(typed) && buffer.length() < 50)
            return new PlayState();
        return null;
    }

    @Override
    public IState onPause(StateContainer state) {
        return new PauseState();
    }

    @Override
    public IState onTick(StateContainer state) {
        Player player = state.data.player;

        player.sendTitle(new Title(
                new ComponentBuilder("Enter").bold(true).color(ChatColor.RED).create(),
                new ComponentBuilder("エンターキーを押してください").bold(false).color(ChatColor.GREEN).create(),
                5, 10, 5));

        if (state.bgmCount++ >= 4) {
            state.bgmCount = 0;
            player.playSound(player.getLocation(), "sushida:sushida.bgm", SoundCategory.RECORDS, 1, 1);
        }

        return null;
    }
}
