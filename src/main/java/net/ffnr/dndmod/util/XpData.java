package net.ffnr.dndmod.util;

import net.minecraft.nbt.NbtCompound;

public class XpData {
    //public static int xp;

    public  static int getExperience(IEntityDataSaver player)
    {
        NbtCompound nbt = player.getPersistentData();
        int xp = nbt.getInt("xp");
        return xp;
    }
    public static int setExperience(IEntityDataSaver player, int x)
    {
        NbtCompound nbt = player.getPersistentData();
        nbt.putInt("xp", x);
        return x;
    }

    public static int addExperience(IEntityDataSaver player, int x)
    {
        NbtCompound nbt = player.getPersistentData();
        int xp = nbt.getInt("xp");
        xp += x;
        nbt.putInt("xp", xp);
        return xp;
    }
    public static int clearExperience(IEntityDataSaver player)
    {
        NbtCompound nbt = player.getPersistentData();
        nbt.putInt("xp", 0);
        return 0;
    }
}
