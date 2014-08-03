package net.mcft.copy.betterstorage.addon.nei;


import net.mcft.copy.betterstorage.addon.Addon;
import net.mcft.copy.betterstorage.client.gui.GuiCraftingStation;
import net.mcft.copy.betterstorage.content.BetterStorageTiles;
import net.mcft.copy.betterstorage.misc.Constants;
import net.minecraft.item.ItemStack;
import codechicken.nei.api.API;
import codechicken.nei.recipe.DefaultOverlayHandler;

public class NEIAddon extends Addon {
	
	public NEIAddon() {
		super("NotEnoughItems");
	}

	@Override
	public void postInitialize() {	
		
		API.hideItem(new ItemStack(BetterStorageTiles.lockableDoor));
		API.registerRecipeHandler(new NEIRecipeHandler());
		API.registerGuiOverlay(GuiCraftingStation.class, Constants.modId + ".craftingStation");
		API.registerGuiOverlayHandler(GuiCraftingStation.class, new DefaultOverlayHandler(), Constants.modId + ".craftingStation");
	}
}
