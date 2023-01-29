package net.ffnr.dndmod.dnd;

public class Character {
    public static int xp;

    public  static int getExperience()
    {
        return xp;
    }
    public static void setExperience(int x)
    {
        xp = x;
    }

    public static void changeExperience(int x)
    {
        xp += x;

    }


}
