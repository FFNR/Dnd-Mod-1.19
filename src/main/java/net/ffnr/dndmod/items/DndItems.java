package net.ffnr.dndmod.items;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.ffnr.dndmod.DndMod;
import net.ffnr.dndmod.material.SteelToolMaterial;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class DndItems
{
   public static final ItemGroup GROUP_NAME = FabricItemGroup.builder(new Identifier(DndMod.MOD_ID)).displayName(Text.literal("Dnd Items")).icon(()->new ItemStack(DndItems.STEEL)).build();
   public static final Item STEEL = registerItem("steel", new Item(new FabricItemSettings()));
   public static final ToolItem GREAT_AXE = registerToolItem("great_axe", new AxeItem(SteelToolMaterial.INSTANCE, 8.0F, -3.5F, new Item.Settings()));
   public static final ToolItem LONG_SWORD = registerToolItem("long_sword", new SwordItem(SteelToolMaterial.INSTANCE, 8, -3.0F, new Item.Settings()));
   public static Item registerItem(String name, Item item)
   {
      ItemGroupEvents.modifyEntriesEvent(GROUP_NAME).register(entries -> entries.add(STEEL));
      return Registry.register(Registries.ITEM, new Identifier(DndMod.MOD_ID, name), item);

   }
   public static ToolItem registerToolItem(String name, ToolItem item)
   {
      ItemGroupEvents.modifyEntriesEvent(GROUP_NAME).register(entries -> entries.add(GREAT_AXE));
      ItemGroupEvents.modifyEntriesEvent(GROUP_NAME).register(entries -> entries.add(LONG_SWORD));
      return Registry.register(Registries.ITEM, new Identifier(DndMod.MOD_ID, name), item);

   }
   public static void registerModItems()
   {

      DndMod.LOGGER.debug("Registering Items for " + DndMod.MOD_ID);

   }

}
