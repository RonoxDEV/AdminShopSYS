/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.adm.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;

import net.minecraft.world.inventory.Slot;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.core.registries.Registries;
import net.minecraft.client.Minecraft;

import net.adm.world.inventory.ReglageMenu;
import net.adm.world.inventory.Item9EDITMenu;
import net.adm.world.inventory.Item8EDITMenu;
import net.adm.world.inventory.Item7EDITMenu;
import net.adm.world.inventory.Item6EDITMenu;
import net.adm.world.inventory.Item5EDITMenu;
import net.adm.world.inventory.Item4EDITMenu;
import net.adm.world.inventory.Item3EDITMenu;
import net.adm.world.inventory.Item2EDITMenu;
import net.adm.world.inventory.Item1EDITMenu;
import net.adm.world.inventory.Item12EDITMenu;
import net.adm.world.inventory.Item11EDITMenu;
import net.adm.world.inventory.Item10EDITMenu;
import net.adm.world.inventory.AdminshopP1Menu;
import net.adm.world.inventory.AdminshopEDITMODEMenu;
import net.adm.network.MenuStateUpdateMessage;
import net.adm.AdmMod;

import java.util.Map;

public class AdmModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(Registries.MENU, AdmMod.MODID);
	public static final DeferredHolder<MenuType<?>, MenuType<AdminshopP1Menu>> ADMINSHOP_P_1 = REGISTRY.register("adminshop_p_1", () -> IMenuTypeExtension.create(AdminshopP1Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<AdminshopEDITMODEMenu>> ADMINSHOP_EDITMODE = REGISTRY.register("adminshop_editmode", () -> IMenuTypeExtension.create(AdminshopEDITMODEMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<ReglageMenu>> REGLAGE = REGISTRY.register("reglage", () -> IMenuTypeExtension.create(ReglageMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<Item1EDITMenu>> ITEM_1_EDIT = REGISTRY.register("item_1_edit", () -> IMenuTypeExtension.create(Item1EDITMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<Item2EDITMenu>> ITEM_2_EDIT = REGISTRY.register("item_2_edit", () -> IMenuTypeExtension.create(Item2EDITMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<Item3EDITMenu>> ITEM_3_EDIT = REGISTRY.register("item_3_edit", () -> IMenuTypeExtension.create(Item3EDITMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<Item4EDITMenu>> ITEM_4_EDIT = REGISTRY.register("item_4_edit", () -> IMenuTypeExtension.create(Item4EDITMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<Item5EDITMenu>> ITEM_5_EDIT = REGISTRY.register("item_5_edit", () -> IMenuTypeExtension.create(Item5EDITMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<Item6EDITMenu>> ITEM_6_EDIT = REGISTRY.register("item_6_edit", () -> IMenuTypeExtension.create(Item6EDITMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<Item7EDITMenu>> ITEM_7_EDIT = REGISTRY.register("item_7_edit", () -> IMenuTypeExtension.create(Item7EDITMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<Item8EDITMenu>> ITEM_8_EDIT = REGISTRY.register("item_8_edit", () -> IMenuTypeExtension.create(Item8EDITMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<Item9EDITMenu>> ITEM_9_EDIT = REGISTRY.register("item_9_edit", () -> IMenuTypeExtension.create(Item9EDITMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<Item10EDITMenu>> ITEM_10_EDIT = REGISTRY.register("item_10_edit", () -> IMenuTypeExtension.create(Item10EDITMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<Item11EDITMenu>> ITEM_11_EDIT = REGISTRY.register("item_11_edit", () -> IMenuTypeExtension.create(Item11EDITMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<Item12EDITMenu>> ITEM_12_EDIT = REGISTRY.register("item_12_edit", () -> IMenuTypeExtension.create(Item12EDITMenu::new));

	public interface MenuAccessor {
		Map<String, Object> getMenuState();

		Map<Integer, Slot> getSlots();

		default void sendMenuStateUpdate(Player player, int elementType, String name, Object elementState, boolean needClientUpdate) {
			getMenuState().put(elementType + ":" + name, elementState);
			if (player instanceof ServerPlayer serverPlayer) {
				PacketDistributor.sendToPlayer(serverPlayer, new MenuStateUpdateMessage(elementType, name, elementState));
			} else if (player.level().isClientSide) {
				if (Minecraft.getInstance().screen instanceof AdmModScreens.ScreenAccessor accessor && needClientUpdate)
					accessor.updateMenuState(elementType, name, elementState);
				PacketDistributor.sendToServer(new MenuStateUpdateMessage(elementType, name, elementState));
			}
		}

		default <T> T getMenuState(int elementType, String name, T defaultValue) {
			try {
				return (T) getMenuState().getOrDefault(elementType + ":" + name, defaultValue);
			} catch (ClassCastException e) {
				return defaultValue;
			}
		}
	}
}