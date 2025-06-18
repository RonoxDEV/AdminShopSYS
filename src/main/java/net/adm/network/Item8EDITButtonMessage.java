package net.adm.network;

import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.adm.procedures.RegisterItem8EDITProcedure;
import net.adm.AdmMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public record Item8EDITButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {

	public static final Type<Item8EDITButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(AdmMod.MODID, "item_8_edit_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, Item8EDITButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, Item8EDITButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new Item8EDITButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));
	@Override
	public Type<Item8EDITButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final Item8EDITButtonMessage message, final IPayloadContext context) {
		if (context.flow() == PacketFlow.SERVERBOUND) {
			context.enqueueWork(() -> handleButtonAction(context.player(), message.buttonID, message.x, message.y, message.z)).exceptionally(e -> {
				context.connection().disconnect(Component.literal(e.getMessage()));
				return null;
			});
		}
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level();
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			RegisterItem8EDITProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		AdmMod.addNetworkMessage(Item8EDITButtonMessage.TYPE, Item8EDITButtonMessage.STREAM_CODEC, Item8EDITButtonMessage::handleData);
	}
}