package net.adm.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.adm.network.AdmModVariables;
import net.adm.init.AdmModMenus;

public class RegisterItem9EDITProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		AdmModVariables.MapVariables.get(world).Item9 = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof AdmModMenus.MenuAccessor _menu ? _menu.getSlots().get(0).getItem() : ItemStack.EMPTY).copy();
		AdmModVariables.MapVariables.get(world).syncData(world);
		AdmModVariables.MapVariables.get(world).Item9NSTACK = getAmountInGUISlot(entity, 0);
		AdmModVariables.MapVariables.get(world).syncData(world);
		AdmModVariables.MapVariables.get(world).Item9MONEY = (entity instanceof Player _entity && _entity.containerMenu instanceof AdmModMenus.MenuAccessor _menu) ? _menu.getMenuState(0, "Money", "") : "";
		AdmModVariables.MapVariables.get(world).syncData(world);
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("adm:done")), SoundSource.NEUTRAL, 1, 1);
			} else {
				_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("adm:done")), SoundSource.NEUTRAL, 1, 1, false);
			}
		}
	}

	private static int getAmountInGUISlot(Entity entity, int sltid) {
		if (entity instanceof Player player && player.containerMenu instanceof AdmModMenus.MenuAccessor _menu) {
			ItemStack stack = _menu.getSlots().get(sltid).getItem();
			if (stack != null)
				return stack.getCount();
		}
		return 0;
	}
}