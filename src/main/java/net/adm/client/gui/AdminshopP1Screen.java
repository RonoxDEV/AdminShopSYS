package net.adm.client.gui;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.PlainTextButton;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.adm.world.inventory.AdminshopP1Menu;
import net.adm.procedures.ReturnPriceItem9Procedure;
import net.adm.procedures.ReturnPriceItem8Procedure;
import net.adm.procedures.ReturnPriceItem7Procedure;
import net.adm.procedures.ReturnPriceItem6Procedure;
import net.adm.procedures.ReturnPriceItem5Procedure;
import net.adm.procedures.ReturnPriceItem4Procedure;
import net.adm.procedures.ReturnPriceItem3Procedure;
import net.adm.procedures.ReturnPriceItem2Procedure;
import net.adm.procedures.ReturnPriceItem1Procedure;
import net.adm.procedures.ReturnPriceItem12Procedure;
import net.adm.procedures.ReturnPriceItem10Procedure;
import net.adm.network.AdminshopP1ButtonMessage;
import net.adm.init.AdmModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class AdminshopP1Screen extends AbstractContainerScreen<AdminshopP1Menu> implements AdmModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	Button button_empty;
	Button button_empty1;
	Button button_empty2;
	Button button_empty3;
	Button button_empty4;
	Button button_empty5;
	Button button_empty6;
	Button button_empty7;
	Button button_empty8;
	Button button_empty9;
	Button button_empty10;
	Button button_empty11;

	public AdminshopP1Screen(AdminshopP1Menu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 261;
		this.imageHeight = 191;
	}

	@Override
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		menuStateUpdateActive = false;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("adm:textures/screens/adminshop_p_1.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(RenderType::guiTextured, texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, ReturnPriceItem1Procedure.execute(world), 8, 25, -12829636, false);
		guiGraphics.drawString(this.font, ReturnPriceItem2Procedure.execute(world), 63, 25, -12829636, false);
		guiGraphics.drawString(this.font, ReturnPriceItem3Procedure.execute(world), 112, 25, -12829636, false);
		guiGraphics.drawString(this.font, ReturnPriceItem4Procedure.execute(world), 169, 25, -12829636, false);
		guiGraphics.drawString(this.font, ReturnPriceItem5Procedure.execute(world), 8, 59, -12829636, false);
		guiGraphics.drawString(this.font, ReturnPriceItem6Procedure.execute(world), 63, 59, -12829636, false);
		guiGraphics.drawString(this.font, ReturnPriceItem7Procedure.execute(world), 113, 59, -12829636, false);
		guiGraphics.drawString(this.font, ReturnPriceItem8Procedure.execute(world), 169, 59, -12829636, false);
		guiGraphics.drawString(this.font, ReturnPriceItem9Procedure.execute(world), 8, 91, -12829636, false);
		guiGraphics.drawString(this.font, ReturnPriceItem10Procedure.execute(world), 64, 91, -12829636, false);
		guiGraphics.drawString(this.font, ReturnPriceItem10Procedure.execute(world), 112, 91, -12829636, false);
		guiGraphics.drawString(this.font, ReturnPriceItem12Procedure.execute(world), 169, 91, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		button_empty = new PlainTextButton(this.leftPos + 29, this.topPos + 17, 25, 20, Component.translatable("gui.adm.adminshop_p_1.button_empty"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new AdminshopP1ButtonMessage(0, x, y, z));
				AdminshopP1ButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}, this.font);
		this.addRenderableWidget(button_empty);
		button_empty1 = new PlainTextButton(this.leftPos + 82, this.topPos + 16, 25, 20, Component.translatable("gui.adm.adminshop_p_1.button_empty1"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new AdminshopP1ButtonMessage(1, x, y, z));
				AdminshopP1ButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}, this.font);
		this.addRenderableWidget(button_empty1);
		button_empty2 = new PlainTextButton(this.leftPos + 135, this.topPos + 16, 25, 20, Component.translatable("gui.adm.adminshop_p_1.button_empty2"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new AdminshopP1ButtonMessage(2, x, y, z));
				AdminshopP1ButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}, this.font);
		this.addRenderableWidget(button_empty2);
		button_empty3 = new PlainTextButton(this.leftPos + 192, this.topPos + 16, 25, 20, Component.translatable("gui.adm.adminshop_p_1.button_empty3"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new AdminshopP1ButtonMessage(3, x, y, z));
				AdminshopP1ButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}, this.font);
		this.addRenderableWidget(button_empty3);
		button_empty4 = new PlainTextButton(this.leftPos + 29, this.topPos + 50, 25, 20, Component.translatable("gui.adm.adminshop_p_1.button_empty4"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new AdminshopP1ButtonMessage(4, x, y, z));
				AdminshopP1ButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		}, this.font);
		this.addRenderableWidget(button_empty4);
		button_empty5 = new PlainTextButton(this.leftPos + 82, this.topPos + 51, 25, 20, Component.translatable("gui.adm.adminshop_p_1.button_empty5"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new AdminshopP1ButtonMessage(5, x, y, z));
				AdminshopP1ButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		}, this.font);
		this.addRenderableWidget(button_empty5);
		button_empty6 = new PlainTextButton(this.leftPos + 135, this.topPos + 51, 25, 20, Component.translatable("gui.adm.adminshop_p_1.button_empty6"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new AdminshopP1ButtonMessage(6, x, y, z));
				AdminshopP1ButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		}, this.font);
		this.addRenderableWidget(button_empty6);
		button_empty7 = new PlainTextButton(this.leftPos + 192, this.topPos + 51, 25, 20, Component.translatable("gui.adm.adminshop_p_1.button_empty7"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new AdminshopP1ButtonMessage(7, x, y, z));
				AdminshopP1ButtonMessage.handleButtonAction(entity, 7, x, y, z);
			}
		}, this.font);
		this.addRenderableWidget(button_empty7);
		button_empty8 = new PlainTextButton(this.leftPos + 30, this.topPos + 83, 25, 20, Component.translatable("gui.adm.adminshop_p_1.button_empty8"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new AdminshopP1ButtonMessage(8, x, y, z));
				AdminshopP1ButtonMessage.handleButtonAction(entity, 8, x, y, z);
			}
		}, this.font);
		this.addRenderableWidget(button_empty8);
		button_empty9 = new PlainTextButton(this.leftPos + 83, this.topPos + 83, 25, 20, Component.translatable("gui.adm.adminshop_p_1.button_empty9"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new AdminshopP1ButtonMessage(9, x, y, z));
				AdminshopP1ButtonMessage.handleButtonAction(entity, 9, x, y, z);
			}
		}, this.font);
		this.addRenderableWidget(button_empty9);
		button_empty10 = new PlainTextButton(this.leftPos + 136, this.topPos + 83, 25, 20, Component.translatable("gui.adm.adminshop_p_1.button_empty10"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new AdminshopP1ButtonMessage(10, x, y, z));
				AdminshopP1ButtonMessage.handleButtonAction(entity, 10, x, y, z);
			}
		}, this.font);
		this.addRenderableWidget(button_empty10);
		button_empty11 = new PlainTextButton(this.leftPos + 190, this.topPos + 83, 25, 20, Component.translatable("gui.adm.adminshop_p_1.button_empty11"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new AdminshopP1ButtonMessage(11, x, y, z));
				AdminshopP1ButtonMessage.handleButtonAction(entity, 11, x, y, z);
			}
		}, this.font);
		this.addRenderableWidget(button_empty11);
	}
}