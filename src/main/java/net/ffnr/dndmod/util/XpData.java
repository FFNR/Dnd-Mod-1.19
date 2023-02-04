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

    // Leveling
    public  static int getLevel(IEntityDataSaver player)
    {
        NbtCompound nbt = player.getPersistentData();
        int lvl = nbt.getInt("lvl");
        return lvl;
    }
    public static int setLevel(IEntityDataSaver player, int x)
    {
        NbtCompound nbt = player.getPersistentData();
        nbt.putInt("lvl", x);
        return x;
    }

    public static int addLevel(IEntityDataSaver player, int x)
    {
        NbtCompound nbt = player.getPersistentData();
        int lvl = nbt.getInt("lvl");
        lvl += x;
        nbt.putInt("lvl", lvl);
        return lvl;
    }
    public static int clearLevel(IEntityDataSaver player)
    {
        NbtCompound nbt = player.getPersistentData();
        nbt.putInt("lvl", 0);
        return 0;
    }
    public static void checkForLevelUp(IEntityDataSaver player)
    {
        NbtCompound nbt = player.getPersistentData();
        int xp = nbt.getInt("xp");
        int lvl = nbt.getInt("lvl");
        if(xp >= 355000)
        {

            nbt.putInt("lvl", 20);
        }
        else if (xp >= 305000 && xp < 355000)
        {
            nbt.putInt("lvl", 19);
        }
        else if (xp >= 265000 && xp < 305000)
        {
            nbt.putInt("lvl", 18);
        }
        else if (xp >= 225000 && xp < 265000)
        {
            nbt.putInt("lvl", 17);
        }
        else if (xp >= 195000 && xp < 225000)
        {
            nbt.putInt("lvl", 16);
        }
        else if (xp >= 165000 && xp < 195000)
        {
            nbt.putInt("lvl", 15);
        }
        else if (xp >= 140000 && xp < 165000)
        {
            nbt.putInt("lvl", 14);
        }
        else if (xp >= 120000 && xp < 140000)
        {
            nbt.putInt("lvl", 13);
        }
        else if (xp >= 100000 && xp < 120000)
        {
            nbt.putInt("lvl", 12);
        }
        else if (xp >= 85000 && xp < 100000)
        {
            nbt.putInt("lvl", 11);
        }
        else if (xp >= 64000 && xp < 85000)
        {
            nbt.putInt("lvl", 10);
        }
        else if (xp >= 48000 && xp < 64000)
        {
            nbt.putInt("lvl", 9);
        }
        else if (xp >= 34000 && xp < 48000)
        {
            nbt.putInt("lvl", 8);
        }
        else if (xp >= 23000 && xp < 34000)
        {
            nbt.putInt("lvl", 7);
        }
        else if (xp >= 14000 && xp < 23000)
        {
            nbt.putInt("lvl", 6);
        }
        else if (xp >= 6500 && xp < 14000)
        {
            nbt.putInt("lvl", 5);
        }
        else if (xp >= 2700 && xp < 6500)
        {
            nbt.putInt("lvl", 4);
        }
        else if (xp >= 900 && xp < 2700)
        {
            nbt.putInt("lvl", 3);
        }
        else if (xp >= 300 && xp < 900)
        {
            nbt.putInt("lvl", 2);
        }
        else
        {
            nbt.putInt("lvl", 1);
        }

    }
}
