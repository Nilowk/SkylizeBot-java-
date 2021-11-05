package fr.nilowk.botluca;

import fr.nilowk.bot.utils.ConfigManager;
import fr.nilowk.bot.utils.commands.MessageManager;
import fr.nilowk.bot.utils.utils.Statistique;
import fr.nilowk.bot.utils.utils.UtilsManager;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;

import java.io.File;

public class Main {

    public static DiscordApi api;
    private static ConfigManager configManager;

    public static void main(String[] args) {

        System.out.println("bot ok");

        configManager = new ConfigManager(new File(System.getProperty("user.dir"), "config.toml"));

        api = new DiscordApiBuilder()
                .setToken(configManager.getToml().getString("bot.token"))
                .setAllIntents()
                .login()
                .join();

        api.addMessageCreateListener(MessageManager::create);
        api.getServerTextChannelById("814571822736867368").get().sendMessage("-cstats");
        api.getServerTextChannelById("814571822736867368").get().sendMessage("-rstats");
        api.addServerVoiceChannelMemberJoinListener(UtilsManager::createChannel);
        api.addServerVoiceChannelMemberLeaveListener(UtilsManager::deleteChannel);
        api.addUserChangeStatusListener(Statistique::statCountOnlines);
        api.addServerMemberJoinListener(Statistique::join);
        api.addServerMemberLeaveListener(Statistique::leave);
        api.addServerMemberJoinListener(Statistique::statCountMembers);
        api.addServerMemberLeaveListener(Statistique::statCountMember);
        api.addServerMemberJoinListener(Statistique::statCountBots);
        api.addServerMemberLeaveListener(Statistique::statCountBot);
        api.addServerMemberJoinListener(Statistique::statCountCitoyens);
        api.addServerMemberLeaveListener(Statistique::statCountCitoyen);

    }

    public static ConfigManager getConfigManager() {
        return configManager;
    }
}
