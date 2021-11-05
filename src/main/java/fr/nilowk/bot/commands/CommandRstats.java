package fr.nilowk.bot.commands;

import fr.nilowk.bot.utils.commands.Command;
import fr.nilowk.bot.utils.commands.CommandExecutor;
import fr.nilowk.bot.utils.utils.Statistique;
import org.javacord.api.event.message.MessageCreateEvent;

public class CommandRstats implements CommandExecutor {
    @Override
    public void run(MessageCreateEvent event, Command command, String[] args) {
        event.getMessage().delete();
        if(event.getMessageAuthor().canManageServer()) {
            //Statistique.regenerateStaffChannel();
            Statistique.regenerateMembersChannel();
            Statistique.regenerateBotsChannel();
            Statistique.regenerateCitoyensChannel();
            Statistique.regenerateOnlinesChannel();
        }
    }
}
