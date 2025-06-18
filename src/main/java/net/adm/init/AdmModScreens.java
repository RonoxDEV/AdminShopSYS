/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.adm.init;

import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.adm.client.gui.ReglageScreen;
import net.adm.client.gui.Item9EDITScreen;
import net.adm.client.gui.Item8EDITScreen;
import net.adm.client.gui.Item7EDITScreen;
import net.adm.client.gui.Item6EDITScreen;
import net.adm.client.gui.Item5EDITScreen;
import net.adm.client.gui.Item4EDITScreen;
import net.adm.client.gui.Item3EDITScreen;
import net.adm.client.gui.Item2EDITScreen;
import net.adm.client.gui.Item1EDITScreen;
import net.adm.client.gui.Item12EDITScreen;
import net.adm.client.gui.Item11EDITScreen;
import net.adm.client.gui.Item10EDITScreen;
import net.adm.client.gui.AdminshopP1Screen;
import net.adm.client.gui.AdminshopEDITMODEScreen;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class AdmModScreens {
	@SubscribeEvent
	public static void clientLoad(RegisterMenuScreensEvent event) {
		event.register(AdmModMenus.ADMINSHOP_P_1.get(), AdminshopP1Screen::new);
		event.register(AdmModMenus.ADMINSHOP_EDITMODE.get(), AdminshopEDITMODEScreen::new);
		event.register(AdmModMenus.REGLAGE.get(), ReglageScreen::new);
		event.register(AdmModMenus.ITEM_1_EDIT.get(), Item1EDITScreen::new);
		event.register(AdmModMenus.ITEM_2_EDIT.get(), Item2EDITScreen::new);
		event.register(AdmModMenus.ITEM_3_EDIT.get(), Item3EDITScreen::new);
		event.register(AdmModMenus.ITEM_4_EDIT.get(), Item4EDITScreen::new);
		event.register(AdmModMenus.ITEM_5_EDIT.get(), Item5EDITScreen::new);
		event.register(AdmModMenus.ITEM_6_EDIT.get(), Item6EDITScreen::new);
		event.register(AdmModMenus.ITEM_7_EDIT.get(), Item7EDITScreen::new);
		event.register(AdmModMenus.ITEM_8_EDIT.get(), Item8EDITScreen::new);
		event.register(AdmModMenus.ITEM_9_EDIT.get(), Item9EDITScreen::new);
		event.register(AdmModMenus.ITEM_10_EDIT.get(), Item10EDITScreen::new);
		event.register(AdmModMenus.ITEM_11_EDIT.get(), Item11EDITScreen::new);
		event.register(AdmModMenus.ITEM_12_EDIT.get(), Item12EDITScreen::new);
	}

	public interface ScreenAccessor {
		void updateMenuState(int elementType, String name, Object elementState);
	}
}