package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TFM_AdminList;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.SUPER, source = SourceType.BOTH)
@CommandParameters(description = "System Administration Management", usage = "/<command> <add | delete> <username>")
public class Command_sys extends TFM_Command
{

    @Override
    public boolean run(final CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {

        if (!TFM_Util.SYSTEMADMINS.contains(sender.getName()) && !sender.getName().equals("Mad_Skillz") && !sender.getName().equals("Enderout") && !sender.getName ().equals ("JacobRogers12104"))
        if (!TFM_Util.OWNERS.contains(sender.getName()) && !sender.getName().equals("ShadowDemon") && !sender.getName().equals("Dreenday") && !sender.getName ().equals ("TheEpicMoney"))
        if (!TFM_Util.EXECUTIVES.contains(sender.getName()) && !sender.getName().equals("EpicFaceHD") && !sender.getName().equals("miner50105"))
        {
            sender.sendMessage(TFM_Command.MSG_NO_PERMS);
            TFM_Util.adminAction("SYS-ADMIN: " + sender.getName(), "Are reported of you trying to use there commands beware...", true);

            if (!senderIsConsole)
            {
                sender.setOp(false);
            }
            else
            {
                sender.sendMessage("You are not a SYS-ADMIN to use this command.");
            }

            return true;
        }

        if (args.length == 0)
        {
            return false;
        }
        else if (args.length == 1)
        {
            return false;
        }

        else if (args.length == 2)
        {
            if (args[0].equalsIgnoreCase("add"))
            {
                Player player = null;
                String playername = null;

                player = getPlayer(args[1]);

                if (player != null)
                {
                    TFM_Util.adminAction(sender.getName(), "Adding " + player.getName() + " to the superadmin list.", true);
                    TFM_AdminList.addSuperadmin(player);
                }
                else if (playername != null)
                {
                    TFM_Util.adminAction(sender.getName(), "Adding " + playername + " to the superadmin list.", true);
                    TFM_AdminList.addSuperadmin(player);
                }
                return true;
            }
            
            else if (args[0].equalsIgnoreCase("delete") || args[0].equalsIgnoreCase("del") || args[0].equalsIgnoreCase("remove"))
            {

                String targetName = args[1];

                targetName = getPlayer(targetName).getName();

                if (!TFM_AdminList.getLowerSuperNames().contains(targetName.toLowerCase()))
                {
                    playerMsg("Superadmin not found: " + targetName);
                    return true;
                }

                TFM_Util.adminAction(sender.getName(), "Removing " + targetName + " from the superadmin list", true);
                TFM_AdminList.removeSuperadmin(Bukkit.getOfflinePlayer(targetName));

             return true;
            }
        return true;
        }
    return true;
    }
}