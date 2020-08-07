package com.example.examplemod;

import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class CustomSword extends ItemSword {

	public CustomSword() {
		super(ExampleMod.godMaterial);
		this.setRegistryName("gods_word");
		this.setUnlocalizedName("gods_word");
		this.setCreativeTab(CreativeTabs.COMBAT);
	}
	
	public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLiving, EntityLivingBase par3EntityLiving)
	{
		 lightningEffect(par2EntityLiving);
		 par1ItemStack.damageItem(1, par3EntityLiving);
		 return false;
	}
	
	public boolean onEntitySwing(EntityLivingBase entityLiving, ItemStack stack) {
		lightningEffectOnBlock(entityLiving);
		return false;
	}
	  
	public void lightningEffectOnBlock(EntityLivingBase par1EntityLiving)
	{
		 RayTraceResult lookingAt = Minecraft.getMinecraft().objectMouseOver;
		 if (lookingAt != null && lookingAt.typeOfHit == RayTraceResult.Type.BLOCK) {
		     BlockPos pos = lookingAt.getBlockPos();
		     World world = par1EntityLiving.world;
			 EntityLightningBolt lightning = new EntityLightningBolt(world, pos.getX(), pos.getY(), pos.getZ(), false);
			 lightning.setPosition(pos.getX(), pos.getY() + 1, pos.getZ());
			 world.spawnEntity(lightning);
		 }
//		 double x = par1EntityLiving.posX;
//		 double y = par1EntityLiving.posY;
//		 double z = par1EntityLiving.posZ;
//		 System.out.println(x);
//		 System.out.println(y);
//		 System.out.println(z);
		 
	}
	
	public void lightningEffect(EntityLivingBase par1EntityLiving)
	{
		 double x = par1EntityLiving.posX;
		 double y = par1EntityLiving.posY;
		 double z = par1EntityLiving.posZ;
		 World world = par1EntityLiving.world;
		 EntityLightningBolt lightning = new EntityLightningBolt(world, x, y, z, false);
		 lightning.setPosition(x, y + 1, z);
		 world.spawnEntity(lightning);
	}
}
