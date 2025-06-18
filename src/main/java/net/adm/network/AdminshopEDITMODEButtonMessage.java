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

import net.adm.procedures.OpenREGLAGEProcedure;
import net.adm.procedures.OpenItem9Procedure;
import net.adm.procedures.OpenItem8Procedure;
import net.adm.procedures.OpenItem7Procedure;
import net.adm.procedures.OpenItem6Procedure;
import net.adm.procedures.OpenItem5Procedure;
import net.adm.procedures.OpenItem4Procedure;
import net.adm.procedures.OpenItem3Procedure;
import net.adm.procedures.OpenItem2Procedure;
import net.adm.procedures.OpenItem1EDITProcedure;
import net.adm.procedures.OpenItem12Procedure;
import net.adm.procedures.OpenItem11Procedure;
import net.adm.procedures.OpenItem10Procedure;
import net.adm.AdmMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public record AdminshopEDITMODEButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {

	public static final Type<AdminshopEDITMODEButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(AdmMod.MODID, "adminshop_editmode_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, AdminshopEDITMODEButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, AdminshopEDITMODEButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new AdminshopEDITMODEButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));
	@Override
	public Type<AdminshopEDITMODEButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final AdminshopEDITMODEButtonMessage message, final IPayloadContext context) {
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

			OpenItem1EDITProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			OpenItem2Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			OpenItem3Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			OpenItem4Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 4) {

			OpenItem5Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 5) {

			OpenItem6Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 6) {

			OpenItem7Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 7) {

			OpenItem8Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 8) {

			OpenItem9Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 9) {

			OpenItem10Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 10) {

			OpenItem11Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 11) {

			OpenItem12Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 12) {

			OpenREGLAGEProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		AdmMod.addNetworkMessage(AdminshopEDITMODEButtonMessage.TYPE, AdminshopEDITMODEButtonMessage.STREAM_CODEC, AdminshopEDITMODEButtonMessage::handleData);
	}
}