package net.teamfruit.sushida.player.state;

import net.teamfruit.sushida.player.StateContainer;

public class PlayState implements IState {
    @Override
    public IState onEnter(StateContainer state) {
        onType(state, "");
        return null;
    }

    @Override
    public IState onType(StateContainer state, String typed) {
        state.data.player.sendTitle("プレイシーン", typed, 0, 100, 0);
        return null;
    }

    @Override
    public IState onPause(StateContainer state) {
        return new PauseState();
    }
}
