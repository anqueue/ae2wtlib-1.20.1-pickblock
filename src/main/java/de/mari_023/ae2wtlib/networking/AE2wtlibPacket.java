package de.mari_023.ae2wtlib.networking;

import io.netty.buffer.Unpooled;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Player;

public abstract class AE2wtlibPacket {
    protected final FriendlyByteBuf buf;

    public AE2wtlibPacket(FriendlyByteBuf buf) {
        this.buf = buf;
    }

    public static FriendlyByteBuf createBuffer() {
        return new FriendlyByteBuf(Unpooled.buffer());
    }

    public abstract void processPacketData(Player player);

    public FriendlyByteBuf getPacketBuffer() {
        return buf;
    }

    public abstract String getPacketName();
}
