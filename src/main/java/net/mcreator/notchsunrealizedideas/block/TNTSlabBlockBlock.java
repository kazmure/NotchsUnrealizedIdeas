
package net.mcreator.notchsunrealizedideas.block;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.state.properties.SlabType;
import net.minecraft.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.notchsunrealizedideas.NotchsUnrealizedIdeasModElements;

import java.util.List;
import java.util.Collections;

@NotchsUnrealizedIdeasModElements.ModElement.Tag
public class TNTSlabBlockBlock extends NotchsUnrealizedIdeasModElements.ModElement {
	@ObjectHolder("notchs_unrealized_ideas_:tnt_slab_block")
	public static final Block block = null;
	public TNTSlabBlockBlock(NotchsUnrealizedIdeasModElements instance) {
		super(instance, 7);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(block.getRegistryName()));
	}
	public static class CustomBlock extends SlabBlock {
		public CustomBlock() {
			super(Block.Properties.create(Material.TNT).sound(SoundType.PLANT).hardnessAndResistance(0.2f, 1f).setLightLevel(s -> 0));
			setRegistryName("tnt_slab_block");
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, state.get(TYPE) == SlabType.DOUBLE ? 2 : 1));
		}
	}
}
