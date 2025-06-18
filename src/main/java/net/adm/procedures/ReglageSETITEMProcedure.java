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

public class ReglageSETITEMProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		AdmModVariables.MapVariables.get(world).ItemMONEY = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof AdmModMenus.MenuAccessor _menu ? _menu.getSlots().get(0).getItem() : ItemStack.EMPTY).copy();
		AdmModVariables.MapVariables.get(world).syncData(world);
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("adm:done")), SoundSource.NEUTRAL, 1, 1);
			} else {
				_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("adm:done")), SoundSource.NEUTRAL, 1, 1, false);
			}
		}
	}
}