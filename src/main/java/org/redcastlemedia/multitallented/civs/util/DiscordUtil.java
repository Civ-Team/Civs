package org.redcastlemedia.multitallented.civs.util;

public final class DiscordUtil {
    private DiscordUtil() {

    }

    /*public static String atAllTownOwners(Town town) {
        String defaultMessage = "";
        try {
            for (UUID uuid : town.getRawPeople().keySet()) {
                if (!town.getRawPeople().get(uuid).contains(Constants.OWNER)) {
                    continue;
                }
                String discordUserId = Civs.discordSRV.getAccountLinkManager().getDiscordId(uuid);
                if (discordUserId != null) {
                    defaultMessage += " @" + discordUserId;
                    continue;
                }
                OfflinePlayer offlinePlayer = Bukkit.getOfflinePlayer(uuid);
                if (offlinePlayer.getName() != null) {
                    String mention = "";
                    for (Member member : Civs.discordSRV.getMainTextChannel().getMembers()) {
                        if (offlinePlayer.getName().startsWith(member.getUser().getName())) {
                            mention = " " + member.getUser().getAsMention();
                            break;
                        }
                    }
                    if (mention.isEmpty()) {
                        mention = " @" + offlinePlayer.getName();
                    }
                    defaultMessage += mention;
                }
            }
        } catch (Exception e) {
            Civs.logger.log(Level.SEVERE, "Unable to broadcast discord message", e);
        }
        return defaultMessage;
    }

    public static void sendMessageToMainChannel(String message) {
        try {
            Civs.discordSRV.getMainTextChannel().sendMessage(ChatColor.stripColor(message)).submit();
        } catch (Exception e) {
            Civs.logger.log(Level.SEVERE, "Unable to broadcast discord message", e);
        }
    }*/
}
