package techreborn.client.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.translation.I18n;

import techreborn.client.container.builder.ContainerBuilder;
import techreborn.tiles.TileChargeBench;

public class GuiChargeBench extends GuiContainer {

	private static final ResourceLocation texture = new ResourceLocation("techreborn", "textures/gui/chargebench.png");

	TileChargeBench chargebench;

	public GuiChargeBench(final EntityPlayer player, final TileChargeBench tile) {
		super(new ContainerBuilder().player(player.inventory).inventory().hotbar().addInventory().tile(tile)
				.energy(0, 62, 21).energy(1, 80, 21).energy(2, 98, 21).energy(3, 62, 39).energy(4, 80, 39)
				.energy(5, 98, 39).addInventory().create());
		this.xSize = 176;
		this.ySize = 167;
		chargebench = tile;
	}

	@Override
	public void initGui() {
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		super.initGui();
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(texture);
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);

		int j = 0;

		j = chargebench.getEnergyScaled(12);
		if (j > 0) {
			this.drawTexturedModalRect(k + 10, l + 32 + 12 - j, 176, 12 - j, 14, j + 2);
		}
	}

	protected void drawGuiContainerForegroundLayer(int p_146979_1_, int p_146979_2_) {
		String name = I18n.translateToLocal("tile.techreborn.chargebench.name");
		this.fontRendererObj.drawString(name, this.xSize / 2 - this.fontRendererObj.getStringWidth(name) / 2, 6,
			4210752);
		this.fontRendererObj.drawString(I18n.translateToLocalFormatted("container.inventory", new Object[0]), 8,
			this.ySize - 96 + 2, 4210752);
	}
}
