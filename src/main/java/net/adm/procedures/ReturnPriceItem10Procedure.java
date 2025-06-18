package net.adm.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.adm.network.AdmModVariables;

public class ReturnPriceItem10Procedure {
	public static String execute(LevelAccessor world) {
		return AdmModVariables.MapVariables.get(world).Item10MONEY + "$";
	}
}