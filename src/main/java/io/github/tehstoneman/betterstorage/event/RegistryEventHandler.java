package io.github.tehstoneman.betterstorage.event;

import io.github.tehstoneman.betterstorage.BetterStorage;
import io.github.tehstoneman.betterstorage.ModInfo;
import io.github.tehstoneman.betterstorage.common.block.BetterStorageBlocks;
import io.github.tehstoneman.betterstorage.common.block.BlockBetterStorage;
import io.github.tehstoneman.betterstorage.common.block.BlockCardboardBox;
import io.github.tehstoneman.betterstorage.common.block.BlockCrate;
import io.github.tehstoneman.betterstorage.common.block.BlockLockableDoor;
import io.github.tehstoneman.betterstorage.common.block.BlockLocker;
import io.github.tehstoneman.betterstorage.common.block.BlockReinforcedChest;
import io.github.tehstoneman.betterstorage.common.block.BlockReinforcedLocker;
import io.github.tehstoneman.betterstorage.common.enchantment.EnchantmentKey;
import io.github.tehstoneman.betterstorage.common.enchantment.EnchantmentLock;
import io.github.tehstoneman.betterstorage.common.inventory.ContainerCardboardBox;
import io.github.tehstoneman.betterstorage.common.inventory.ContainerCrate;
import io.github.tehstoneman.betterstorage.common.inventory.ContainerKeyring;
import io.github.tehstoneman.betterstorage.common.inventory.ContainerLocker;
import io.github.tehstoneman.betterstorage.common.inventory.ContainerReinforcedChest;
import io.github.tehstoneman.betterstorage.common.inventory.ContainerReinforcedLocker;
import io.github.tehstoneman.betterstorage.common.item.BetterStorageItems;
import io.github.tehstoneman.betterstorage.common.item.ItemBlockCrate;
import io.github.tehstoneman.betterstorage.common.item.ItemBlockLocker;
import io.github.tehstoneman.betterstorage.common.item.ItemBlockReinforcedChest;
import io.github.tehstoneman.betterstorage.common.item.ItemBlockReinforcedLocker;
import io.github.tehstoneman.betterstorage.common.item.cardboard.ItemBlockCardboardBox;
import io.github.tehstoneman.betterstorage.common.item.cardboard.ItemCardboardArmor;
import io.github.tehstoneman.betterstorage.common.item.cardboard.ItemCardboardAxe;
import io.github.tehstoneman.betterstorage.common.item.cardboard.ItemCardboardHoe;
import io.github.tehstoneman.betterstorage.common.item.cardboard.ItemCardboardPickaxe;
import io.github.tehstoneman.betterstorage.common.item.cardboard.ItemCardboardSheet;
import io.github.tehstoneman.betterstorage.common.item.cardboard.ItemCardboardShovel;
import io.github.tehstoneman.betterstorage.common.item.cardboard.ItemCardboardSword;
import io.github.tehstoneman.betterstorage.common.item.locking.ItemKey;
import io.github.tehstoneman.betterstorage.common.item.locking.ItemKeyring;
import io.github.tehstoneman.betterstorage.common.item.locking.ItemLock;
import io.github.tehstoneman.betterstorage.common.item.locking.ItemMasterKey;
import io.github.tehstoneman.betterstorage.common.tileentity.TileEntityCardboardBox;
import io.github.tehstoneman.betterstorage.common.tileentity.TileEntityCrate;
import io.github.tehstoneman.betterstorage.common.tileentity.TileEntityLockableDoor;
import io.github.tehstoneman.betterstorage.common.tileentity.TileEntityLocker;
import io.github.tehstoneman.betterstorage.common.tileentity.TileEntityReinforcedChest;
import io.github.tehstoneman.betterstorage.common.tileentity.TileEntityReinforcedLocker;
import net.minecraft.block.Block;
import net.minecraft.block.Block.Properties;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantment.Rarity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber( bus = Mod.EventBusSubscriber.Bus.MOD )
public class RegistryEventHandler
{
	@SubscribeEvent
	public static void onBlocksRegistry( final RegistryEvent.Register< Block > event )
	{
		final IForgeRegistry< Block > registry = event.getRegistry();

		registry.register( new BlockCrate().setRegistryName( ModInfo.MOD_ID, "crate" ) );
		registry.register( new BlockReinforcedChest().setRegistryName( ModInfo.MOD_ID, "reinforced_chest" ) );
		registry.register( new BlockLocker().setRegistryName( ModInfo.MOD_ID, "locker" ) );
		registry.register( new BlockReinforcedLocker().setRegistryName( ModInfo.MOD_ID, "reinforced_locker" ) );
		registry.register( new BlockLockableDoor().setRegistryName( ModInfo.MOD_ID, "lockable_door" ) );
		registry.register( new BlockCardboardBox().setRegistryName( ModInfo.MOD_ID, "cardboard_box" ) );
		registry.register( new BlockBetterStorage( Properties.create( Material.ROCK, MaterialColor.BLACK ).hardnessAndResistance( 5.0F, 6.0F ) )
				.setRegistryName( ModInfo.MOD_ID, "block_flint" ) );
	}

	@SubscribeEvent
	public static void onItemsRegistry( final RegistryEvent.Register< Item > event )
	{
		final IForgeRegistry< Item > registry = event.getRegistry();

		registry.register( new ItemBlockCrate( BetterStorageBlocks.CRATE ).setRegistryName( BetterStorageBlocks.CRATE.getRegistryName() ) );
		registry.register( new ItemBlockReinforcedChest( BetterStorageBlocks.REINFORCED_CHEST )
				.setRegistryName( BetterStorageBlocks.REINFORCED_CHEST.getRegistryName() ) );
		registry.register( new ItemBlockLocker( BetterStorageBlocks.LOCKER ).setRegistryName( BetterStorageBlocks.LOCKER.getRegistryName() ) );
		registry.register( new ItemBlockReinforcedLocker( BetterStorageBlocks.REINFORCED_LOCKER )
				.setRegistryName( BetterStorageBlocks.REINFORCED_LOCKER.getRegistryName() ) );

		registry.register( new ItemKey().setRegistryName( "key" ) );
		registry.register( new ItemKeyring().setRegistryName( "keyring" ) );
		registry.register( new ItemMasterKey().setRegistryName( "master_key" ) );
		registry.register( new ItemLock().setRegistryName( "lock" ) );

		registry.register( new ItemCardboardSheet().setRegistryName( ModInfo.MOD_ID, "cardboard_sheet" ) );

		registry.register( new ItemBlockCardboardBox( BetterStorageBlocks.CARDBOARD_BOX ).setRegistryName( ModInfo.MOD_ID, "cardboard_box" ) );

		registry.register( new ItemCardboardSword().setRegistryName( ModInfo.MOD_ID, "cardboard_sword" ) );
		registry.register( new ItemCardboardShovel().setRegistryName( ModInfo.MOD_ID, "cardboard_shovel" ) );
		registry.register( new ItemCardboardPickaxe().setRegistryName( ModInfo.MOD_ID, "cardboard_pickaxe" ) );
		registry.register( new ItemCardboardAxe().setRegistryName( ModInfo.MOD_ID, "cardboard_axe" ) );
		registry.register( new ItemCardboardHoe().setRegistryName( ModInfo.MOD_ID, "cardboard_hoe" ) );

		registry.register( new ItemCardboardArmor( EquipmentSlotType.HEAD ).setRegistryName( "cardboard_helmet" ) );
		registry.register( new ItemCardboardArmor( EquipmentSlotType.CHEST ).setRegistryName( "cardboard_chestplate" ) );
		registry.register( new ItemCardboardArmor( EquipmentSlotType.LEGS ).setRegistryName( "cardboard_leggings" ) );
		registry.register( new ItemCardboardArmor( EquipmentSlotType.FEET ).setRegistryName( "cardboard_boots" ) );

		registry.register( new BlockItem( BetterStorageBlocks.BLOCK_FLINT, new Item.Properties().group( BetterStorage.ITEM_GROUP ) )
				.setRegistryName( BetterStorageBlocks.BLOCK_FLINT.getRegistryName() ) );
	}

	@SubscribeEvent
	public static void onTileEntityRegistry( final RegistryEvent.Register< TileEntityType< ? > > event )
	{
		final IForgeRegistry< TileEntityType< ? > > registry = event.getRegistry();

		registry.register( TileEntityType.Builder.create( TileEntityCrate::new, BetterStorageBlocks.CRATE ).build( null )
				.setRegistryName( BetterStorageBlocks.CRATE.getRegistryName() ) );
		registry.register( TileEntityType.Builder.create( TileEntityReinforcedChest::new, BetterStorageBlocks.REINFORCED_CHEST ).build( null )
				.setRegistryName( BetterStorageBlocks.REINFORCED_CHEST.getRegistryName() ) );
		registry.register( TileEntityType.Builder.create( TileEntityLocker::new, BetterStorageBlocks.LOCKER ).build( null )
				.setRegistryName( BetterStorageBlocks.LOCKER.getRegistryName() ) );
		registry.register( TileEntityType.Builder.create( TileEntityReinforcedLocker::new, BetterStorageBlocks.REINFORCED_LOCKER ).build( null )
				.setRegistryName( BetterStorageBlocks.REINFORCED_LOCKER.getRegistryName() ) );
		registry.register( TileEntityType.Builder.create( TileEntityLockableDoor::new, BetterStorageBlocks.LOCKABLE_DOOR ).build( null )
				.setRegistryName( BetterStorageBlocks.LOCKABLE_DOOR.getRegistryName() ) );
		registry.register( TileEntityType.Builder.create( TileEntityCardboardBox::new, BetterStorageBlocks.CARDBOARD_BOX ).build( null )
				.setRegistryName( BetterStorageBlocks.CARDBOARD_BOX.getRegistryName() ) );
	}

	@SubscribeEvent
	public static void onContainerRegistry( final RegistryEvent.Register< ContainerType< ? > > event )
	{
		final IForgeRegistry< ContainerType< ? > > registry = event.getRegistry();

		registry.register( IForgeContainerType.create( ( windowID, inv, data ) ->
		{
			final BlockPos pos = data.readBlockPos();
			return new ContainerCrate( windowID, inv, BetterStorage.PROXY.getClientWorld(), pos );
		} ).setRegistryName( BetterStorageBlocks.CRATE.getRegistryName() ) );
		registry.register( IForgeContainerType.create( ( windowID, inv, data ) ->
		{
			final BlockPos pos = data.readBlockPos();
			return new ContainerLocker( windowID, inv, BetterStorage.PROXY.getClientWorld(), pos );
		} ).setRegistryName( BetterStorageBlocks.LOCKER.getRegistryName() ) );
		registry.register( IForgeContainerType.create( ( windowID, inv, data ) ->
		{
			final BlockPos pos = data.readBlockPos();
			return new ContainerReinforcedChest( windowID, inv, BetterStorage.PROXY.getClientWorld(), pos );
		} ).setRegistryName( BetterStorageBlocks.REINFORCED_CHEST.getRegistryName() ) );
		registry.register( IForgeContainerType.create( ( windowID, inv, data ) ->
		{
			final BlockPos pos = data.readBlockPos();
			return new ContainerReinforcedLocker( windowID, inv, BetterStorage.PROXY.getClientWorld(), pos );
		} ).setRegistryName( BetterStorageBlocks.REINFORCED_LOCKER.getRegistryName() ) );
		registry.register( IForgeContainerType.create( ( windowID, inv, data ) ->
		{
			final BlockPos pos = data.readBlockPos();
			return new ContainerCardboardBox( windowID, inv, BetterStorage.PROXY.getClientWorld(), pos );
		} ).setRegistryName( BetterStorageBlocks.CARDBOARD_BOX.getRegistryName() ) );
		registry.register( IForgeContainerType.create( ( windowID, inv, data ) ->
		{
			final ItemStack keyring = data.readItemStack();
			final int protectedIndex = data.readInt();
			return new ContainerKeyring( windowID, inv, keyring, protectedIndex );
		} ).setRegistryName( BetterStorageItems.KEYRING.getRegistryName() ) );
	}

	@SubscribeEvent
	public static void onEnchantmentRegistry( final RegistryEvent.Register< Enchantment > event )
	{
		final IForgeRegistry< Enchantment > registry = event.getRegistry();

		registry.register( new EnchantmentKey( Rarity.COMMON, 5, 5, 10, 30, 0 ).setRegistryName( "unlocking" ) );
		registry.register( new EnchantmentKey( Rarity.COMMON, 5, 5, 8, 30, 0 ).setRegistryName( "lockpicking" ) );
		registry.register( new EnchantmentKey( Rarity.COMMON, 5, 10, 12, 30, 0 ).setRegistryName( "morphing" ) );

		registry.register( new EnchantmentLock( Rarity.COMMON, 5, 1, 8, 30, 0 ).setRegistryName( "persistance" ) );
		registry.register( new EnchantmentLock( Rarity.COMMON, 5, 1, 8, 30, 0 ).setRegistryName( "security" ) );
		registry.register( new EnchantmentLock( Rarity.COMMON, 5, 1, 8, 30, 0 ).setRegistryName( "shock" ) );
		registry.register( new EnchantmentLock( Rarity.COMMON, 1, 1, 8, 30, 0 ).setRegistryName( "trigger" ) );
	}
}
