
package net.mcreator.notchsunrealizedideas.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.notchsunrealizedideas.NotchsUnrealizedIdeasModElements;

@NotchsUnrealizedIdeasModElements.ModElement.Tag
public class SaplingItem extends NotchsUnrealizedIdeasModElements.ModElement {
	@ObjectHolder("notchs_unrealized_ideas_:sapling")
	public static final Item block = null;
	public SaplingItem(NotchsUnrealizedIdeasModElements instance) {
		super(instance, 8);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.MISC).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("sapling");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
