package net.adm.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.adm.network.AdmModVariables;

public class ReturnPriceItem8Procedure {
	public static String execute(LevelAccessor world) {
		return AdmModVariables.MapVariables.get(world).Item8MONEY + "$";
	}
}