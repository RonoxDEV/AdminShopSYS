package net.adm.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.adm.network.AdmModVariables;
import net.adm.init.AdmModMenus;
import net.adm.AdmMod;

public class RELOADGUIProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		AdmMod.queueServerWork(1, () -> {
			if (entity instanceof Player _player && _player.containerMenu instanceof AdmModMenus.MenuAccessor _menu) {
				ItemStack _setstack = AdmModVariables.MapVariables.get(world).Item1.copy();
				_setstack.setCount((int) AdmModVariables.MapVariables.get(world).Item1NSTACKS);
				_menu.getSlots().get(1).set(_setstack);
				_player.containerMenu.broadcastChanges();
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof AdmModMenus.MenuAccessor _menu) {
				ItemStack _setstack = AdmModVariables.MapVariables.get(world).Item2.copy();
				_setstack.setCount((int) AdmModVariables.MapVariables.get(world).Item2NSTACKS);
				_menu.getSlots().get(2).set(_setstack);
				_player.containerMenu.broadcastChanges();
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof AdmModMenus.MenuAccessor _menu) {
				ItemStack _setstack = AdmModVariables.MapVariables.get(world).Item3.copy();
				_setstack.setCount((int) AdmModVariables.MapVariables.get(world).Item3NSTACK);
				_menu.getSlots().get(3).set(_setstack);
				_player.containerMenu.broadcastChanges();
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof AdmModMenus.MenuAccessor _menu) {
				ItemStack _setstack = AdmModVariables.MapVariables.get(world).Item4.copy();
				_setstack.setCount((int) AdmModVariables.MapVariables.get(world).Item4NSTACKS);
				_menu.getSlots().get(4).set(_setstack);
				_player.containerMenu.broadcastChanges();
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof AdmModMenus.MenuAccessor _menu) {
				ItemStack _setstack = AdmModVariables.MapVariables.get(world).Item5.copy();
				_setstack.setCount((int) AdmModVariables.MapVariables.get(world).Item5NSTACK);
				_menu.getSlots().get(5).set(_setstack);
				_player.containerMenu.broadcastChanges();
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof AdmModMenus.MenuAccessor _menu) {
				ItemStack _setstack = AdmModVariables.MapVariables.get(world).Item6.copy();
				_setstack.setCount((int) AdmModVariables.MapVariables.get(world).Item6NSTACK);
				_menu.getSlots().get(6).set(_setstack);
				_player.containerMenu.broadcastChanges();
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof AdmModMenus.MenuAccessor _menu) {
				ItemStack _setstack = AdmModVariables.MapVariables.get(world).Item7.copy();
				_setstack.setCount((int) AdmModVariables.MapVariables.get(world).Item7NSTACK);
				_menu.getSlots().get(7).set(_setstack);
				_player.containerMenu.broadcastChanges();
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof AdmModMenus.MenuAccessor _menu) {
				ItemStack _setstack = AdmModVariables.MapVariables.get(world).Item8.copy();
				_setstack.setCount((int) AdmModVariables.MapVariables.get(world).Item8NSTACK);
				_menu.getSlots().get(8).set(_setstack);
				_player.containerMenu.broadcastChanges();
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof AdmModMenus.MenuAccessor _menu) {
				ItemStack _setstack = AdmModVariables.MapVariables.get(world).Item9.copy();
				_setstack.setCount((int) AdmModVariables.MapVariables.get(world).Item9NSTACK);
				_menu.getSlots().get(9).set(_setstack);
				_player.containerMenu.broadcastChanges();
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof AdmModMenus.MenuAccessor _menu) {
				ItemStack _setstack = AdmModVariables.MapVariables.get(world).Item10.copy();
				_setstack.setCount((int) AdmModVariables.MapVariables.get(world).Item10NSTACK);
				_menu.getSlots().get(10).set(_setstack);
				_player.containerMenu.broadcastChanges();
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof AdmModMenus.MenuAccessor _menu) {
				ItemStack _setstack = AdmModVariables.MapVariables.get(world).Item11.copy();
				_setstack.setCount((int) AdmModVariables.MapVariables.get(world).Item11NSTACK);
				_menu.getSlots().get(11).set(_setstack);
				_player.containerMenu.broadcastChanges();
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof AdmModMenus.MenuAccessor _menu) {
				ItemStack _setstack = AdmModVariables.MapVariables.get(world).Item12.copy();
				_setstack.setCount((int) AdmModVariables.MapVariables.get(world).Item12NSTACK);
				_menu.getSlots().get(12).set(_setstack);
				_player.containerMenu.broadcastChanges();
			}
		});
	}
}