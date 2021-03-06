package io.github.tehstoneman.betterstorage.client.renderer.tileentity.model;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.model.ModelRenderer;

public class LargeChestModel extends ChestModel
{
	public LargeChestModel()
	{
		super( RenderType::getEntityCutout );

		chestBody = new ModelRenderer( 128, 64, 0, 19 );
		chestBody.addBox( 1.0F, 0.0F, 1.0F, 30.0F, 10.0F, 14.0F, 0.0F );

		chestLid = new ModelRenderer( 128, 64, 0, 0 );
		chestLid.addBox( 1.0F, 0.0F, 0.0F, 30.0F, 5.0F, 14.0F, 0.0F );
		chestLid.rotationPointY = 9.0F;
		chestLid.rotationPointZ = 1.0F;

		chestLatch = new ModelRenderer( 128, 64, 0, 0 );
		chestLatch.addBox( 15.0F, -1.0F, 15.0F, 2.0F, 4.0F, 1.0F, 0.0F );
		chestLatch.rotationPointY = 8.0F;
	}
}
