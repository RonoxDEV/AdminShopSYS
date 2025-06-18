package net.adm.client.gui;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.Minecraft;

import net.adm.world.inventory.Item3EDITMenu;
import net.adm.network.Item3EDITButtonMessage;
import net.adm.init.AdmModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class Item3EDITScreen extends AbstractContainerScreen<Item3EDITMenu> implements AdmModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	EditBox Money;
	Button button_done;

	public Item3EDITScreen(Item3EDITMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	@Override
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		if (elementType == 0 && elementState instanceof String stringState) {
			if (name.equals("Money"))
				Money.setValue(stringState);
		}
		menuStateUpdateActive = false;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("adm:textures/screens/item_3_edit.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		Money.render(guiGraphics, mouseX, mouseY, partialTicks);
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
		if (Money.isFocused())
			return Money.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void resize(Minecraft minecraft, int width, int height) {
		String MoneyValue = Money.getValue();
		super.resize(minecraft, width, height);
		Money.setValue(MoneyValue);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.adm.item_3_edit.label_empty"), 22, 58, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		Money = new EditBox(this.font, this.leftPos + 42, this.topPos + 54, 118, 18, Component.translatable("gui.adm.item_3_edit.Money"));
		Money.setMaxLength(8192);
		Money.setResponder(content -> {
			if (!menuStateUpdateActive)
				menu.sendMenuStateUpdate(entity, 0, "Money", content, false);
		});
		Money.setHint(Component.translatable("gui.adm.item_3_edit.Money"));
		this.addWidget(this.Money);
		button_done = Button.builder(Component.translatable("gui.adm.item_3_edit.button_done"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new Item3EDITButtonMessage(0, x, y, z));
				Item3EDITButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 119, this.topPos + 17, 46, 20).build();
		this.addRenderableWidget(button_done);
	}
}