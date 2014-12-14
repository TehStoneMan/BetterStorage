package net.mcft.copy.betterstorage.tile;

import java.util.Random;

import net.mcft.copy.betterstorage.api.BetterStorageEnchantment;
import net.mcft.copy.betterstorage.attachment.Attachments;
import net.mcft.copy.betterstorage.attachment.EnumAttachmentInteraction;
import net.mcft.copy.betterstorage.attachment.IHasAttachments;
import net.mcft.copy.betterstorage.proxy.ClientProxy;
import net.mcft.copy.betterstorage.tile.entity.TileEntityLockableDoor;
import net.mcft.copy.betterstorage.utils.WorldUtils;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import static net.minecraft.util.EnumFacing.*;

//TODO: Rewrite the door
public class TileLockableDoor extends TileBetterStorage {

    public final PropertyBool OPEN_PROP = PropertyBool.create("open");
    public final PropertyEnum HINGEPOSITION_PROP = PropertyEnum.create("hinge", BlockDoor.EnumHingePosition.class);
    public final PropertyBool POWERED_PROP = PropertyBool.create("powered");
    public final PropertyEnum HALF_PROP = PropertyEnum.create("half", BlockDoor.EnumDoorHalf.class);
    
	public TileLockableDoor() {
		super(Material.wood);
		
		setCreativeTab(null);
		setHardness(8.0F);
		setResistance(20.0F);
		setStepSound(soundTypeWood);	
		setHarvestLevel("axe", 2);
	}
	/*
	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z) {
		int metadata = world.getBlockMetadata(x, y, z);
		float offset = metadata == 0 ? 0F : -1F;
		TileEntityLockableDoor te = WorldUtils.get(world, x, y + (int)offset, z, TileEntityLockableDoor.class);
		
		if (te == null) return;
		
		switch (te.orientation) {
		case WEST:
			if (te.isOpen) setBlockBounds(0F, 0F, 0.005F / 16F, 1F, 1F, 2.995F / 16F);
			else setBlockBounds(0.005F / 16F, 0F, 0F, 2.995F / 16F, 1F, 1F);
			break;
		case EAST:
			if (te.isOpen) setBlockBounds(0F, 0F, 13.005F / 16F, 1F, 1F, 15.995F / 16F);
			else setBlockBounds(13.005F / 16F, 0F, 0F, 15.995F / 16F, 1F, 1F);
			break;
		case SOUTH:
			if (te.isOpen) setBlockBounds(0.005F / 16F, 0F, 0F, 2.995F / 16F, 1F, 1F);
			else setBlockBounds(0F, 0F, 13.005F / 16F, 1F, 1F, 15.995F / 16F);
			break;
		default:
			if (te.isOpen) setBlockBounds(13.005F / 16F, 0F, 0F, 15.995F / 16F, 1F, 1F);
			else setBlockBounds(0F, 0F, 0.005F / 16F, 1F, 1F, 2.995F / 16F);
			break;
		}		
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
		setBlockBoundsBasedOnState(world, x, y, z);
		return super.getCollisionBoundingBoxFromPool(world, x, y, z);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		iconUpper = iconRegister.registerIcon("door_iron_upper");
		iconLower = iconRegister.registerIcon("door_iron_lower");
		iconUpperFlipped = new IconFlipped(iconUpper, true, false);
		iconLowerFlipped = new IconFlipped(iconLower, true, false);
		blockIcon = iconUpper;
	}

	@Override
	public IIcon getIcon(IBlockAccess world, int x, int y, int z, int face) {
		int meta = world.getBlockMetadata(x, y, z);
		if (meta > 0) y -= 1;
		TileEntityLockableDoor lockable = WorldUtils.get(world, x, y, z, TileEntityLockableDoor.class);
		
		boolean flip = false;
		IIcon icon = iconUpper;
		
		if(meta == 0 || face == 1) {
			icon = iconLower;
		}
		
		switch(lockable.orientation) {
		case WEST: 
			if(face == 3 && !lockable.isOpen) flip = true;
			else if(face == 2 && lockable.isOpen) flip = true;
			break;
		case EAST:
			if(face == 4 && !lockable.isOpen) flip = true;
			else if(face == 3 && lockable.isOpen) flip = true;
			break;
		case SOUTH:
			if(face == 2 && !lockable.isOpen) flip = true;
			else if(face == 4 && lockable.isOpen) flip = true;
			break;
		default: 
			if(face == 3 && !lockable.isOpen) flip = true;
			else if(face == 5 && lockable.isOpen) flip = true;
			break;
		}

		icon = flip ? (icon == iconLower ? iconLowerFlipped : iconUpperFlipped) : icon;
		return icon;
	}
	*/

	@Override
	 public float getBlockHardness(World world, BlockPos pos){
		EnumFacing side = (EnumFacing) world.getBlockState(pos).getValue(FACING_PROP);
		if (!side.equals(DOWN)) pos = pos.offsetDown();
		TileEntityLockableDoor lockable = WorldUtils.get(world, pos, TileEntityLockableDoor.class);
		if ((lockable != null) && (lockable.getLock() != null)) return -1;
		else return super.getBlockHardness(world, pos);
	}
	
	@Override
	public float getExplosionResistance(World world, BlockPos pos, Entity exploder, Explosion explosion){
		EnumFacing side = (EnumFacing) world.getBlockState(pos).getValue(FACING_PROP);
		if (!side.equals(DOWN)) pos = pos.offsetDown();
		float modifier = 1.0F;
		TileEntityLockableDoor lockable = WorldUtils.get(world, pos, TileEntityLockableDoor.class);
		if (lockable != null) {
			int persistance = BetterStorageEnchantment.getLevel(lockable.getLock(), "persistance");
			if (persistance > 0) modifier += Math.pow(2, persistance);
		}
		return super.getExplosionResistance(exploder) * modifier;
	}
	
	@Override
	public boolean onBlockEventReceived(World world, BlockPos pos, IBlockState state, int eventID, int eventParam){
		TileEntity te = world.getTileEntity(pos);
        return ((te != null) ? te.receiveClientEvent(eventID, eventParam) : false);
	}

	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float hitX, float hitY, float hitZ) {
		if (!side.equals(DOWN)) pos = pos.offsetDown();
		TileEntityLockableDoor te = WorldUtils.get(world, pos, TileEntityLockableDoor.class);
		return te.onBlockActivated(world, pos, player, side, hitX, hitY, hitZ);
	}
	
	@Override
	public void onBlockClicked(World world, BlockPos pos, EntityPlayer player) {
		EnumFacing side = (EnumFacing) world.getBlockState(pos).getValue(FACING_PROP);
		if (!side.equals(DOWN)) pos = pos.offsetDown();
		Attachments attachments = WorldUtils.get(world, pos, IHasAttachments.class).getAttachments();
		boolean abort = attachments.interact(WorldUtils.rayTrace(player, 1.0F), player, EnumAttachmentInteraction.attack);
	}
	
	@Override
	public MovingObjectPosition collisionRayTrace(World world, BlockPos pos, Vec3 start, Vec3 end) {
		EnumFacing side = (EnumFacing) world.getBlockState(pos).getValue(FACING_PROP);
		pos = pos.offsetDown((side != DOWN ? 1 : 0));
		IHasAttachments te = WorldUtils.get(world, pos, IHasAttachments.class);
		if(te == null) return super.collisionRayTrace(world, pos, start, end);
		MovingObjectPosition movPos = te.getAttachments().rayTrace(world, pos, start, end);
		return movPos != null ? movPos : super.collisionRayTrace(world, pos, start, end);
	}

	@Override
	public ItemStack getPickBlock(MovingObjectPosition target, World world, BlockPos pos) {
		return new ItemStack(Items.iron_door);
	}
	
	
	@Override
	public void breakBlock(World world, BlockPos pos, IBlockState state) {
		EnumFacing side = (EnumFacing) state.getValue(FACING_PROP);
		if (!side.equals(DOWN)) return;
		super.breakBlock(world, pos, state);
	}
	
	@Override
	public void onNeighborBlockChange(World world, BlockPos pos, IBlockState state, Block neighborBlock) {
		int metadata = ((EnumFacing) state.getValue(FACING_PROP)).getIndex();
		int yModifier = ((metadata == 0) ? 1 : -1);
		int targetMeta = ((metadata == 0) ? 8 : 0);
		if (world.getBlockState(pos.offsetDown()).getBlock() == Blocks.air && metadata == 0) world.setBlockToAir(pos);
		EnumFacing side = (EnumFacing) world.getBlockState(pos.offsetDown(yModifier)).getValue(FACING_PROP);
		if ((world.getBlockState(pos.offsetDown(yModifier)).getBlock() == this) && (side.getIndex() == targetMeta)) return;
		world.setBlockToAir(pos);
		if (metadata == 0) WorldUtils.spawnItem(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(Items.iron_door));
	}
	
	/* Removed in 1.8
	  @Override
	public void onBlockPreDestroy(World world, int x, int y, int z, int meta) {
		if(meta == 0) {
			TileEntityLockableDoor te = WorldUtils.get(world, x, y, z, TileEntityLockableDoor.class);
			WorldUtils.dropStackFromBlock(te, te.getLock());
			te.setLockWithUpdate(null);
		}
		super.onBlockPreDestroy(world, x, y, z, meta);
	}*/

	@Override
	public boolean isOpaqueCube() { return false; }
	/*@Override
	public boolean renderAsNormalBlock() { return false; }*/

	@Override
	@SideOnly(Side.CLIENT)
	public int getRenderType() {
		return ClientProxy.lockableDoorRenderId;
	}

	@Override
	public int quantityDropped(IBlockState state, int fortune, Random random) {
		EnumFacing face = (EnumFacing) state.getValue(FACING_PROP);
		return ((face.equals(DOWN)) ? 1 : 0);
	} 
	
	@Override
	public boolean canProvidePower() { return true; }
	
	@Override
	public int isProvidingWeakPower(IBlockAccess world, BlockPos pos, IBlockState state, EnumFacing side) {
		EnumFacing face = (EnumFacing) state.getValue(FACING_PROP);
		if (!face.equals(DOWN)) pos = pos.offsetDown();
		TileEntityLockableDoor te = WorldUtils.get(world, pos, TileEntityLockableDoor.class);
		return te == null ? 0 : (te.isPowered() ? 15 : 0);
	}
	@Override
	public int isProvidingStrongPower(IBlockAccess world, BlockPos pos, IBlockState state, EnumFacing side) {
		return isProvidingWeakPower(world, pos, state, side);
	}
	
	@Override
	public void updateTick(World world, BlockPos pos, IBlockState state, Random rand) {
		EnumFacing face = (EnumFacing) state.getValue(FACING_PROP);
		if (!face.equals(DOWN)) return;
		WorldUtils.get(world, pos, TileEntityLockableDoor.class).setPowered(false);
	}
	
	@Override
	public TileEntity createTileEntity(World world, IBlockState state)
	{
		EnumFacing enumfacing = (EnumFacing)state.getValue(FACING_PROP);
		return ((enumfacing.equals(DOWN)) ? new TileEntityLockableDoor() : null);
	}

	@Override
	public boolean hasTileEntity(IBlockState state) { return true; }
	
}
