package net.adm.client.gui;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.WidgetSprites;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.adm.world.inventory.AdminshopEDITMODEMenu;
import net.adm.network.AdminshopEDITMODEButtonMessage;
import net.adm.init.AdmModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class AdminshopEDITMODEScreen extends AbstractContainerScreen<AdminshopEDITMODEMenu> implements AdmModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	Button button_1;
	Button button_2;
	Button button_3;
	Button button_4;
	Button button_5;
	Button button_6;
	Button button_7;
	Button button_8;
	Button button_9;
	Button button_10;
	Button button_11;
	Button button_12;
	ImageButton imagebutton_boutonparametrespixelarticon;

	public AdminshopEDITMODEScreen(AdminshopEDITMODEMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 265;
		this.imageHeight = 212;
	}

	@Override
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		menuStateUpdateActive = false;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("adm:textures/screens/adminshop_editmode.png");

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
	}

	@Override
	public void init() {
		super.init();
		button_1 = Button.builder(Component.translatable("gui.adm.adminshop_editmode.button_1"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new AdminshopEDITMODEButtonMessage(0, x, y, z));
				AdminshopEDITMODEButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 27, this.topPos + 52, 30, 20).build();
		this.addRenderableWidget(button_1);
		button_2 = Button.builder(Component.translatable("gui.adm.adminshop_editmode.button_2"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new AdminshopEDITMODEButtonMessage(1, x, y, z));
				AdminshopEDITMODEButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 86, this.topPos + 52, 30, 20).build();
		this.addRenderableWidget(button_2);
		button_3 = Button.builder(Component.translatable("gui.adm.adminshop_editmode.button_3"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new AdminshopEDITMODEButtonMessage(2, x, y, z));
				AdminshopEDITMODEButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 144, this.topPos + 52, 30, 20).build();
		this.addRenderableWidget(button_3);
		button_4 = Button.builder(Component.translatable("gui.adm.adminshop_editmode.button_4"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new AdminshopEDITMODEButtonMessage(3, x, y, z));
				AdminshopEDITMODEButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}).bounds(this.leftPos + 204, this.topPos + 52, 30, 20).build();
		this.addRenderableWidget(button_4);
		button_5 = Button.builder(Component.translatable("gui.adm.adminshop_editmode.button_5"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new AdminshopEDITMODEButtonMessage(4, x, y, z));
				AdminshopEDITMODEButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		}).bounds(this.leftPos + 27, this.topPos + 102, 30, 20).build();
		this.addRenderableWidget(button_5);
		button_6 = Button.builder(Component.translatable("gui.adm.adminshop_editmode.button_6"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new AdminshopEDITMODEButtonMessage(5, x, y, z));
				AdminshopEDITMODEButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		}).bounds(this.leftPos + 86, this.topPos + 102, 30, 20).build();
		this.addRenderableWidget(button_6);
		button_7 = Button.builder(Component.translatable("gui.adm.adminshop_editmode.button_7"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new AdminshopEDITMODEButtonMessage(6, x, y, z));
				AdminshopEDITMODEButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		}).bounds(this.leftPos + 144, this.topPos + 102, 30, 20).build();
		this.addRenderableWidget(button_7);
		button_8 = Button.builder(Component.translatable("gui.adm.adminshop_editmode.button_8"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new AdminshopEDITMODEButtonMessage(7, x, y, z));
				AdminshopEDITMODEButtonMessage.handleButtonAction(entity, 7, x, y, z);
			}
		}).bounds(this.leftPos + 204, this.topPos + 102, 30, 20).build();
		this.addRenderableWidget(button_8);
		button_9 = Button.builder(Component.translatable("gui.adm.adminshop_editmode.button_9"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new AdminshopEDITMODEButtonMessage(8, x, y, z));
				AdminshopEDITMODEButtonMessage.handleButtonAction(entity, 8, x, y, z);
			}
		}).bounds(this.leftPos + 27, this.topPos + 151, 30, 20).build();
		this.addRenderableWidget(button_9);
		button_10 = Button.builder(Component.translatable("gui.adm.adminshop_editmode.button_10"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new AdminshopEDITMODEButtonMessage(9, x, y, z));
				AdminshopEDITMODEButtonMessage.handleButtonAction(entity, 9, x, y, z);
			}
		}).bounds(this.leftPos + 83, this.topPos + 151, 35, 20).build();
		this.addRenderableWidget(button_10);
		button_11 = Button.builder(Component.translatable("gui.adm.adminshop_editmode.button_11"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new AdminshopEDITMODEButtonMessage(10, x, y, z));
				AdminshopEDITMODEButtonMessage.handleButtonAction(entity, 10, x, y, z);
			}
		}).bounds(this.leftPos + 142, this.topPos + 151, 35, 20).build();
		this.addRenderableWidget(button_11);
		button_12 = Button.builder(Component.translatable("gui.adm.adminshop_editmode.button_12"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new AdminshopEDITMODEButtonMessage(11, x, y, z));
				AdminshopEDITMODEButtonMessage.handleButtonAction(entity, 11, x, y, z);
			}
		}).bounds(this.leftPos + 201, this.topPos + 151, 35, 20).build();
		this.addRenderableWidget(button_12);
		imagebutton_boutonparametrespixelarticon = new ImageButton(this.leftPos + 219, this.topPos + 5, 40, 40, new WidgetSprites(ResourceLocation.parse("adm:textures/screens/dffff.png"), ResourceLocation.parse("adm:textures/screens/boblink5.png")),
				e -> {
					if (true) {
						PacketDistributor.sendToServer(new AdminshopEDITMODEButtonMessage(12, x, y, z));
						AdminshopEDITMODEButtonMessage.handleButtonAction(entity, 12, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(RenderType::guiTextured, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_boutonparametrespixelarticon);
	}
}