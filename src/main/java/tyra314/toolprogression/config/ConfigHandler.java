package tyra314.toolprogression.config;

import net.minecraftforge.common.config.Configuration;
import org.apache.logging.log4j.Level;
import tyra314.toolprogression.ToolProgressionMod;
import tyra314.toolprogression.proxy.CommonProxy;

public class ConfigHandler
{

    private static final String CATEGORY_GENERAL = "general";
    private static final String CATEGORY_DIMENSIONS = "dimensions";
    private static final String CATEGORY_TOOLTIP = "tooltip";

    public static boolean isThisAGoodTutorial = true;
    public static String yourRealName = "Steve";

    public static void readConfig()
    {
        Configuration cfg = CommonProxy.config;

        try
        {
            cfg.load();
            initGeneralConfig(cfg);
            initDimensionConfig(cfg);
        } catch (Exception e1)
        {
            ToolProgressionMod.logger.log(Level.ERROR, "Problem loading config file!", e1);
        } finally
        {
            if (cfg.hasChanged())
            {
                cfg.save();
            }
        }
    }

    private static void initGeneralConfig(Configuration cfg)
    {
        cfg.addCustomCategoryComment(CATEGORY_GENERAL, "General configuration");
        isThisAGoodTutorial = cfg.getBoolean("goodTutorial", CATEGORY_GENERAL, isThisAGoodTutorial, "Set to false if you don't like this tutorial");
        yourRealName = cfg.getString("realName", CATEGORY_GENERAL, yourRealName, "Set your real name here");
    }

    private static void initDimensionConfig(Configuration cfg)
    {
        cfg.addCustomCategoryComment(CATEGORY_DIMENSIONS, "Dimension configuration");
    }
}
