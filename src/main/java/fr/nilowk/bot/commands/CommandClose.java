package fr.nilowk.bot.commands;

import fr.nilowk.bot.utils.commands.Command;
import fr.nilowk.bot.utils.commands.CommandExecutor;
import org.javacord.api.event.message.MessageCreateEvent;

public class CommandClose implements CommandExecutor {

    private static long id = 0;

    @Override
    public void run(MessageCreateEvent event, Command command, String[] args) {
        event.getMessage().delete();
        if (event.getMessageAuthor().canCreateChannelsOnServer()) {
            id = event.getChannel().getId();
            event.getServer().get().getTextChannelById(id).get().delete();
        }

    }
}
