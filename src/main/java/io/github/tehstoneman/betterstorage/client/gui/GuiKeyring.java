package io.github.tehstoneman.betterstorage.client.gui;

import com.mojang.blaze3d.matrix.MatrixStack;

import io.github.tehstoneman.betterstorage.common.inventory.ContainerKeyring;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.text.ITextComponent;

public class GuiKeyring extends ContainerScreen< ContainerKeyring >
{
	public GuiKeyring( ContainerKeyring container, PlayerInventory playerInventory, ITextComponent title )
	{
		super( container, playerInventory, title );
		ySize = 131;
	}

	/*
	 * @Override
	 * public void render( int mouseX, int mouseY, float partialTicks )
	 * {
	 * renderBackground();
	 * super.render( mouseX, mouseY, partialTicks );
	 * renderHoveredToolTip( mouseX, mouseY );
	 * }
	 */

	/*
	 * @Override
	 * protected void drawGuiContainerForegroundLayer( int mouseX, int mouseY )
	 * {
	 * font.drawString( title.getFormattedText(), 8, 6, 0x404040 );
	 * font.drawString( playerInventory.getDisplayName().getFormattedText(), 8 + ( xSize - 176 ) / 2, ySize - 94, 0x404040 );
	 * }
	 */

	/*
	 * @Override
	 * protected void drawGuiContainerBackgroundLayer( float partialTicks, int x, int y )
	 * {
	 * minecraft.getTextureManager().bindTexture( Resources.CONTAINER_GENERIC );
	 * GlStateManager.color4f( 1.0F, 1.0F, 1.0F, 1.0F );
	 * 
	 * blit( guiLeft, guiTop, 0, 0, xSize, 35 );
	 * blit( guiLeft, guiTop + 35, 0, 125, xSize, 97 );
	 * }
	 */

	@Override
	protected void func_230450_a_( MatrixStack p_230450_1_, float p_230450_2_, int p_230450_3_, int p_230450_4_ )
	{
		// TODO Auto-generated method stub

	}
}