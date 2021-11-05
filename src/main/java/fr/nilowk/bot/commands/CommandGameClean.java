package fr.nilowk.bot.commands;

import fr.nilowk.bot.utils.commands.Command;
import fr.nilowk.bot.utils.commands.CommandExecutor;
import org.javacord.api.event.message.MessageCreateEvent;

public class CommandGameClean implements CommandExecutor {
    @Override
    public void run(MessageCreateEvent event, Command command, String[] args) {
        event.getMessage().delete();
        CommandGameppc.clean();
        CommandGamem.clean();
    }
}
