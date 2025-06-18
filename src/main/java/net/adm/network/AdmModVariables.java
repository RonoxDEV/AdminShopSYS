package net.adm.network;

import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.saveddata.SavedData;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.HolderLookup;

import net.adm.AdmMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class AdmModVariables {
	public static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES = DeferredRegister.create(NeoForgeRegistries.Keys.ATTACHMENT_TYPES, AdmMod.MODID);

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		AdmMod.addNetworkMessage(SavedDataSyncMessage.TYPE, SavedDataSyncMessage.STREAM_CODEC, SavedDataSyncMessage::handleData);
	}

	@EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
			if (event.getEntity() instanceof ServerPlayer player) {
				SavedData mapdata = MapVariables.get(event.getEntity().level());
				SavedData worlddata = WorldVariables.get(event.getEntity().level());
				if (mapdata != null)
					PacketDistributor.sendToPlayer(player, new SavedDataSyncMessage(0, mapdata));
				if (worlddata != null)
					PacketDistributor.sendToPlayer(player, new SavedDataSyncMessage(1, worlddata));
			}
		}

		@SubscribeEvent
		public static void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (event.getEntity() instanceof ServerPlayer player) {
				SavedData worlddata = WorldVariables.get(event.getEntity().level());
				if (worlddata != null)
					PacketDistributor.sendToPlayer(player, new SavedDataSyncMessage(1, worlddata));
			}
		}
	}

	public static class WorldVariables extends SavedData {
		public static final String DATA_NAME = "adm_worldvars";

		public static WorldVariables load(CompoundTag tag, HolderLookup.Provider lookupProvider) {
			WorldVariables data = new WorldVariables();
			data.read(tag, lookupProvider);
			return data;
		}

		public void read(CompoundTag nbt, HolderLookup.Provider lookupProvider) {
		}

		@Override
		public CompoundTag save(CompoundTag nbt, HolderLookup.Provider lookupProvider) {
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof ServerLevel level)
				PacketDistributor.sendToPlayersInDimension(level, new SavedDataSyncMessage(1, this));
		}

		static WorldVariables clientSide = new WorldVariables();

		public static WorldVariables get(LevelAccessor world) {
			if (world instanceof ServerLevel level) {
				return level.getDataStorage().computeIfAbsent(new SavedData.Factory<>(WorldVariables::new, WorldVariables::load), DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class MapVariables extends SavedData {
		public static final String DATA_NAME = "adm_mapvars";
		public String Item1MONEY = "";
		public ItemStack Item1 = ItemStack.EMPTY;
		public double Item1NSTACKS = 0;
		public ItemStack ItemMONEY = ItemStack.EMPTY;
		public double Item2NSTACKS = 0.0;
		public ItemStack Item2 = ItemStack.EMPTY;
		public String Item2MONEY = "";
		public double Item3NSTACK = 0;
		public String Item3MONEY = "";
		public ItemStack Item3 = ItemStack.EMPTY;
		public ItemStack Item4 = ItemStack.EMPTY;
		public String Item4MONEY = "";
		public double Item4NSTACKS = 0;
		public double Item5NSTACK = 0;
		public String Item5MONEY = "";
		public ItemStack Item5 = ItemStack.EMPTY;
		public double Item6NSTACK = 0.0;
		public String Item6MONEY = "";
		public ItemStack Item6 = ItemStack.EMPTY;
		public double Item7NSTACK = 0;
		public String Item7MONEY = "";
		public ItemStack Item7 = ItemStack.EMPTY;
		public double Item8NSTACK = 0;
		public String Item8MONEY = "";
		public ItemStack Item8 = ItemStack.EMPTY;
		public double Item9NSTACK = 0;
		public String Item9MONEY = "";
		public ItemStack Item9 = ItemStack.EMPTY;
		public double Item10NSTACK = 0;
		public String Item10MONEY = "";
		public ItemStack Item10 = ItemStack.EMPTY;
		public double Item11NSTACK = 0;
		public String Item11MONEY = "";
		public ItemStack Item11 = ItemStack.EMPTY;
		public double Item12NSTACK = 0.0;
		public String Item12MONEY = "";
		public ItemStack Item12 = ItemStack.EMPTY;

		public static MapVariables load(CompoundTag tag, HolderLookup.Provider lookupProvider) {
			MapVariables data = new MapVariables();
			data.read(tag, lookupProvider);
			return data;
		}

		public void read(CompoundTag nbt, HolderLookup.Provider lookupProvider) {
			Item1MONEY = nbt.getString("Item1MONEY");
			Item1 = ItemStack.parseOptional(lookupProvider, nbt.getCompound("Item1"));
			Item1NSTACKS = nbt.getDouble("Item1NSTACKS");
			ItemMONEY = ItemStack.parseOptional(lookupProvider, nbt.getCompound("ItemMONEY"));
			Item2NSTACKS = nbt.getDouble("Item2NSTACKS");
			Item2 = ItemStack.parseOptional(lookupProvider, nbt.getCompound("Item2"));
			Item2MONEY = nbt.getString("Item2MONEY");
			Item3NSTACK = nbt.getDouble("Item3NSTACK");
			Item3MONEY = nbt.getString("Item3MONEY");
			Item3 = ItemStack.parseOptional(lookupProvider, nbt.getCompound("Item3"));
			Item4 = ItemStack.parseOptional(lookupProvider, nbt.getCompound("Item4"));
			Item4MONEY = nbt.getString("Item4MONEY");
			Item4NSTACKS = nbt.getDouble("Item4NSTACKS");
			Item5NSTACK = nbt.getDouble("Item5NSTACK");
			Item5MONEY = nbt.getString("Item5MONEY");
			Item5 = ItemStack.parseOptional(lookupProvider, nbt.getCompound("Item5"));
			Item6NSTACK = nbt.getDouble("Item6NSTACK");
			Item6MONEY = nbt.getString("Item6MONEY");
			Item6 = ItemStack.parseOptional(lookupProvider, nbt.getCompound("Item6"));
			Item7NSTACK = nbt.getDouble("Item7NSTACK");
			Item7MONEY = nbt.getString("Item7MONEY");
			Item7 = ItemStack.parseOptional(lookupProvider, nbt.getCompound("Item7"));
			Item8NSTACK = nbt.getDouble("Item8NSTACK");
			Item8MONEY = nbt.getString("Item8MONEY");
			Item8 = ItemStack.parseOptional(lookupProvider, nbt.getCompound("Item8"));
			Item9NSTACK = nbt.getDouble("Item9NSTACK");
			Item9MONEY = nbt.getString("Item9MONEY");
			Item9 = ItemStack.parseOptional(lookupProvider, nbt.getCompound("Item9"));
			Item10NSTACK = nbt.getDouble("Item10NSTACK");
			Item10MONEY = nbt.getString("Item10MONEY");
			Item10 = ItemStack.parseOptional(lookupProvider, nbt.getCompound("Item10"));
			Item11NSTACK = nbt.getDouble("Item11NSTACK");
			Item11MONEY = nbt.getString("Item11MONEY");
			Item11 = ItemStack.parseOptional(lookupProvider, nbt.getCompound("Item11"));
			Item12NSTACK = nbt.getDouble("Item12NSTACK");
			Item12MONEY = nbt.getString("Item12MONEY");
			Item12 = ItemStack.parseOptional(lookupProvider, nbt.getCompound("Item12"));
		}

		@Override
		public CompoundTag save(CompoundTag nbt, HolderLookup.Provider lookupProvider) {
			nbt.putString("Item1MONEY", Item1MONEY);
			nbt.put("Item1", Item1.saveOptional(lookupProvider));
			nbt.putDouble("Item1NSTACKS", Item1NSTACKS);
			nbt.put("ItemMONEY", ItemMONEY.saveOptional(lookupProvider));
			nbt.putDouble("Item2NSTACKS", Item2NSTACKS);
			nbt.put("Item2", Item2.saveOptional(lookupProvider));
			nbt.putString("Item2MONEY", Item2MONEY);
			nbt.putDouble("Item3NSTACK", Item3NSTACK);
			nbt.putString("Item3MONEY", Item3MONEY);
			nbt.put("Item3", Item3.saveOptional(lookupProvider));
			nbt.put("Item4", Item4.saveOptional(lookupProvider));
			nbt.putString("Item4MONEY", Item4MONEY);
			nbt.putDouble("Item4NSTACKS", Item4NSTACKS);
			nbt.putDouble("Item5NSTACK", Item5NSTACK);
			nbt.putString("Item5MONEY", Item5MONEY);
			nbt.put("Item5", Item5.saveOptional(lookupProvider));
			nbt.putDouble("Item6NSTACK", Item6NSTACK);
			nbt.putString("Item6MONEY", Item6MONEY);
			nbt.put("Item6", Item6.saveOptional(lookupProvider));
			nbt.putDouble("Item7NSTACK", Item7NSTACK);
			nbt.putString("Item7MONEY", Item7MONEY);
			nbt.put("Item7", Item7.saveOptional(lookupProvider));
			nbt.putDouble("Item8NSTACK", Item8NSTACK);
			nbt.putString("Item8MONEY", Item8MONEY);
			nbt.put("Item8", Item8.saveOptional(lookupProvider));
			nbt.putDouble("Item9NSTACK", Item9NSTACK);
			nbt.putString("Item9MONEY", Item9MONEY);
			nbt.put("Item9", Item9.saveOptional(lookupProvider));
			nbt.putDouble("Item10NSTACK", Item10NSTACK);
			nbt.putString("Item10MONEY", Item10MONEY);
			nbt.put("Item10", Item10.saveOptional(lookupProvider));
			nbt.putDouble("Item11NSTACK", Item11NSTACK);
			nbt.putString("Item11MONEY", Item11MONEY);
			nbt.put("Item11", Item11.saveOptional(lookupProvider));
			nbt.putDouble("Item12NSTACK", Item12NSTACK);
			nbt.putString("Item12MONEY", Item12MONEY);
			nbt.put("Item12", Item12.saveOptional(lookupProvider));
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof Level && !world.isClientSide())
				PacketDistributor.sendToAllPlayers(new SavedDataSyncMessage(0, this));
		}

		static MapVariables clientSide = new MapVariables();

		public static MapVariables get(LevelAccessor world) {
			if (world instanceof ServerLevelAccessor serverLevelAcc) {
				return serverLevelAcc.getLevel().getServer().getLevel(Level.OVERWORLD).getDataStorage().computeIfAbsent(new SavedData.Factory<>(MapVariables::new, MapVariables::load), DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public record SavedDataSyncMessage(int dataType, SavedData data) implements CustomPacketPayload {
		public static final Type<SavedDataSyncMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(AdmMod.MODID, "saved_data_sync"));
		public static final StreamCodec<RegistryFriendlyByteBuf, SavedDataSyncMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, SavedDataSyncMessage message) -> {
			buffer.writeInt(message.dataType);
			if (message.data != null)
				buffer.writeNbt(message.data.save(new CompoundTag(), buffer.registryAccess()));
		}, (RegistryFriendlyByteBuf buffer) -> {
			int dataType = buffer.readInt();
			CompoundTag nbt = buffer.readNbt();
			SavedData data = null;
			if (nbt != null) {
				data = dataType == 0 ? new MapVariables() : new WorldVariables();
				if (data instanceof MapVariables mapVariables)
					mapVariables.read(nbt, buffer.registryAccess());
				else if (data instanceof WorldVariables worldVariables)
					worldVariables.read(nbt, buffer.registryAccess());
			}
			return new SavedDataSyncMessage(dataType, data);
		});

		@Override
		public Type<SavedDataSyncMessage> type() {
			return TYPE;
		}

		public static void handleData(final SavedDataSyncMessage message, final IPayloadContext context) {
			if (context.flow() == PacketFlow.CLIENTBOUND && message.data != null) {
				context.enqueueWork(() -> {
					if (message.dataType == 0)
						MapVariables.clientSide.read(message.data.save(new CompoundTag(), context.player().registryAccess()), context.player().registryAccess());
					else
						WorldVariables.clientSide.read(message.data.save(new CompoundTag(), context.player().registryAccess()), context.player().registryAccess());
				}).exceptionally(e -> {
					context.connection().disconnect(Component.literal(e.getMessage()));
					return null;
				});
			}
		}
	}
}