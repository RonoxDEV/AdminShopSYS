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

import net.adm.procedures.BUYITEM9Procedure;
import net.adm.procedures.BUYITEM8Procedure;
import net.adm.procedures.BUYITEM7Procedure;
import net.adm.procedures.BUYITEM6Procedure;
import net.adm.procedures.BUYITEM5Procedure;
import net.adm.procedures.BUYITEM4Procedure;
import net.adm.procedures.BUYITEM3Procedure;
import net.adm.procedures.BUYITEM2Procedure;
import net.adm.procedures.BUYITEM1Procedure;
import net.adm.procedures.BUYITEM12Procedure;
import net.adm.procedures.BUYITEM11Procedure;
import net.adm.procedures.BUYITEM10Procedure;
import net.adm.AdmMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public record AdminshopP1ButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {

	public static final Type<AdminshopP1ButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(AdmMod.MODID, "adminshop_p_1_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, AdminshopP1ButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, AdminshopP1ButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new AdminshopP1ButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));
	@Override
	public Type<AdminshopP1ButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final AdminshopP1ButtonMessage message, final IPayloadContext context) {
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

			BUYITEM1Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			BUYITEM2Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			BUYITEM3Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			BUYITEM4Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 4) {

			BUYITEM5Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 5) {

			BUYITEM6Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 6) {

			BUYITEM7Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 7) {

			BUYITEM8Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 8) {

			BUYITEM9Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 9) {

			BUYITEM10Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 10) {

			BUYITEM11Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 11) {

			BUYITEM12Procedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		AdmMod.addNetworkMessage(AdminshopP1ButtonMessage.TYPE, AdminshopP1ButtonMessage.STREAM_CODEC, AdminshopP1ButtonMessage::handleData);
	}
}