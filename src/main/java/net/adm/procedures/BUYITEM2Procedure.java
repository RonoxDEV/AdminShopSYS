package net.adm.procedures;

import org.checkerframework.checker.units.qual.s;

import net.neoforged.neoforge.items.ItemHandlerHelper;

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

public class BUYITEM2Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (new Object() {
			double convert(String s) {
				try {
					return Double.parseDouble(s.trim());
				} catch (Exception e) {
				}
				return 0;
			}
		}.convert(AdmModVariables.MapVariables.get(world).Item2MONEY) <= getAmountInGUISlot(entity, 0) && AdmModVariables.MapVariables.get(world).ItemMONEY
				.getItem() == (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof AdmModMenus.MenuAccessor _menu ? _menu.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem()) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = AdmModVariables.MapVariables.get(world).Item2.copy();
				_setstack.setCount((int) AdmModVariables.MapVariables.get(world).Item2NSTACKS);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof AdmModMenus.MenuAccessor _menu) {
				_menu.getSlots().get(0).remove((int) new Object() {
					double convert(String s) {
						try {
							return Double.parseDouble(s.trim());
						} catch (Exception e) {
						}
						return 0;
					}
				}.convert(AdmModVariables.MapVariables.get(world).Item2MONEY));
				_player.containerMenu.broadcastChanges();
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("adm:done")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("adm:done")), SoundSource.NEUTRAL, 1, 1, false);
				}
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