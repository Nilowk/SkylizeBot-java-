package fr.nilowk.bot.commands;

import fr.nilowk.bot.utils.MessageUtils;
import fr.nilowk.bot.utils.commands.Command;
import fr.nilowk.bot.utils.commands.CommandExecutor;
import org.javacord.api.event.message.MessageCreateEvent;

public class CommandClear implements CommandExecutor {
    @Override
    public void run(MessageCreateEvent event, Command command, String[] args) {
        event.getMessage().delete();
        if (event.getMessageAuthor().canManageMessagesInTextChannel()) {
            if (args.length < 1) {
                MessageUtils.sendAndDelete(event.getChannel(), "Veuillez définir un nombre de message à supprimer", 10_000);
                return;
            }
            try {
                int number = Integer.parseInt(args[0]);
                if (number >= 100 || number <= 1) {
                    MessageUtils.sendAndDelete(event.getChannel(), "Veuillez choisir un nombre entre 2 et 99", 10_000);
                } else {
                    event.getChannel().getMessages(number)
                            .thenAcceptAsync(messages -> {
                                event.getChannel().bulkDelete(messages).thenAcceptAsync(v -> {
                                    MessageUtils.sendAndDelete(event.getChannel(), "Vous avez supprimé " + number + " messages", 10_000);
                                });
                            });
                }
            } catch (NumberFormatException e) {
                MessageUtils.sendAndDelete(event.getChannel(), "Veuillez choisir un nombre correct", 10_000);
            }
        } else {
            MessageUtils.sendAndDelete(event.getChannel(), "Vous n'avez pas la permission d'utiliser cette commande", 10_000);
        }
    }
}

