package net.mcreator.notchsunrealizedideas.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Hand;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.mcreator.notchsunrealizedideas.item.SaplingItem;
import net.mcreator.notchsunrealizedideas.block.SaplingBlockBlock;
import net.mcreator.notchsunrealizedideas.NotchsUnrealizedIdeasModElements;
import net.mcreator.notchsunrealizedideas.NotchsUnrealizedIdeasMod;

import java.util.Map;

@NotchsUnrealizedIdeasModElements.ModElement.Tag
public class SaplingRightClickedOnBlockProcedure extends NotchsUnrealizedIdeasModElements.ModElement {
	public SaplingRightClickedOnBlockProcedure(NotchsUnrealizedIdeasModElements instance) {
		super(instance, 8);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NotchsUnrealizedIdeasMod.LOGGER.warn("Failed to load dependency entity for procedure SaplingRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				NotchsUnrealizedIdeasMod.LOGGER.warn("Failed to load dependency x for procedure SaplingRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				NotchsUnrealizedIdeasMod.LOGGER.warn("Failed to load dependency y for procedure SaplingRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				NotchsUnrealizedIdeasMod.LOGGER.warn("Failed to load dependency z for procedure SaplingRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				NotchsUnrealizedIdeasMod.LOGGER.warn("Failed to load dependency world for procedure SaplingRightClickedOnBlock!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getMaterial() == net.minecraft.block.material.Material.EARTH)
				|| ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getMaterial() == net.minecraft.block.material.Material.ORGANIC))
				&& ((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.AIR.getDefaultState().getBlock()))) {
			if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
					.getItem() == new ItemStack(SaplingItem.block, (int) (1)).getItem())) {
				world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), SaplingBlockBlock.block.getDefaultState(), 3);
				if (entity instanceof LivingEntity) {
					((LivingEntity) entity).swing(Hand.MAIN_HAND, true);
				}
				if (entity instanceof LivingEntity) {
					ItemStack _setstack = new ItemStack(SaplingItem.block, (int) (1));
					_setstack.setCount(
							(int) (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).getCount())
									- 1));
					((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
					if (entity instanceof ServerPlayerEntity)
						((ServerPlayerEntity) entity).inventory.markDirty();
				}
			} else if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
					.getItem() == new ItemStack(SaplingItem.block, (int) (1)).getItem())) {
				world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), SaplingBlockBlock.block.getDefaultState(), 3);
				if (entity instanceof LivingEntity) {
					((LivingEntity) entity).swing(Hand.OFF_HAND, true);
				}
				if (entity instanceof LivingEntity) {
					ItemStack _setstack = new ItemStack(SaplingItem.block, (int) (1));
					_setstack.setCount(
							(int) (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)).getCount())
									- 1));
					((LivingEntity) entity).setHeldItem(Hand.OFF_HAND, _setstack);
					if (entity instanceof ServerPlayerEntity)
						((ServerPlayerEntity) entity).inventory.markDirty();
				}
			}
			if (world instanceof World && !world.isRemote()) {
				((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.glass.place")),
						SoundCategory.NEUTRAL, (float) 1, (float) 1);
			} else {
				((World) world).playSound(x, y, z,
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.glass.place")),
						SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
			}
		}
	}
}
