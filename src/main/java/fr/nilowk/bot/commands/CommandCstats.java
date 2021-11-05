package fr.nilowk.bot.commands;

import fr.nilowk.bot.Main;
import fr.nilowk.bot.utils.commands.Command;
import fr.nilowk.bot.utils.commands.CommandExecutor;
import org.javacord.api.entity.server.Server;
import org.javacord.api.event.message.MessageCreateEvent;

import java.util.Optional;

public class CommandCstats implements CommandExecutor {

    private static Optional<Server> server = Main.api.getServerById("793504580217339974");

    @Override
    public void run(MessageCreateEvent event, Command command, String[] args) {
        event.getMessage().delete();
        if (event.getMessageAuthor().canManageServer()) {
            clearStats();
        }

    }

    public static void clearStats() {

        try {
            server.get().getChannelCategoryById("812301065696837633").get().getChannels().get(0).delete();
        } catch (IndexOutOfBoundsException e) {

        }
        try {
            server.get().getChannelCategoryById("812301065696837633").get().getChannels().get(1).delete();
        } catch (IndexOutOfBoundsException e) {

        }

        try {
            server.get().getChannelCategoryById("812301065696837633").get().getChannels().get(2).delete();
        } catch (IndexOutOfBoundsException e) {

        }

        try {
            server.get().getChannelCategoryById("812301065696837633").get().getChannels().get(3).delete();
        } catch (IndexOutOfBoundsException e) {

        }

        try {
            server.get().getChannelCategoryById("812301065696837633").get().getChannels().get(4).delete();
        } catch (IndexOutOfBoundsException e) {

        }
        try {
            server.get().getChannelCategoryById("812301065696837633").get().getChannels().get(5).delete();
        } catch (IndexOutOfBoundsException e) {

        }
        try {
            server.get().getChannelCategoryById("812301065696837633").get().getChannels().get(6).delete();
        } catch (IndexOutOfBoundsException e) {

        }

    }

}
