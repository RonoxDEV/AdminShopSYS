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

import net.adm.procedures.RegisterItem4EDITProcedure;
import net.adm.AdmMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public record Item4EDITButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {

	public static final Type<Item4EDITButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(AdmMod.MODID, "item_4_edit_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, Item4EDITButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, Item4EDITButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new Item4EDITButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));
	@Override
	public Type<Item4EDITButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final Item4EDITButtonMessage message, final IPayloadContext context) {
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

			RegisterItem4EDITProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		AdmMod.addNetworkMessage(Item4EDITButtonMessage.TYPE, Item4EDITButtonMessage.STREAM_CODEC, Item4EDITButtonMessage::handleData);
	}
}