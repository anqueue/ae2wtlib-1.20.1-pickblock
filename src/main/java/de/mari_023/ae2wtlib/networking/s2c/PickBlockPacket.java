package de.mari_023.ae2wtlib.networking.s2c;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

import de.mari_023.ae2wtlib.AE2wtlibEvents;
import de.mari_023.ae2wtlib.networking.AE2wtlibPacket;

public class PickBlockPacket extends AE2wtlibPacket {
    public static final String NAME = "pick_block";
    private final ItemStack itemStack;

    public PickBlockPacket(FriendlyByteBuf buf) {
        super(buf);
        this.itemStack = buf.readItem();
    }

    public PickBlockPacket(ItemStack itemStack) {
        super(createBuffer());
        this.itemStack = itemStack;
        buf.writeItem(itemStack);
    }

    @Override
    public void processPacketData(Player player) {
        if (!(player instanceof ServerPlayer serverPlayer))
            return;
        AE2wtlibEvents.pickBlock(serverPlayer, itemStack);
    }

    @Override
    public String getPacketName() {
        return NAME;
    }
}
